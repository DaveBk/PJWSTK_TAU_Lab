package s15720.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.commons.validator.routines.EmailValidator;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.StringUtils.upperCase;

import s15720.bmiCalculator.WrongInputParametersException;
import s15720.model.HealthResult;
import s15720.repository.HealthResultDao;

public class HealthResultsListService {

    private final EmailValidator validator = EmailValidator.getInstance(false, true);
	
    public HealthResultsListService() {
    }
    
    public boolean addHealthResultToList(HealthResult result) {
        if (result == null) throw new IllegalArgumentException("Object is null");

        HealthResultDao.getInstance().collectionAccess().add(result);
        return true;
    }
    
    public HealthResult getResultById(long id) {
        if (HealthResultDao.getInstance().isPresentInRepoById(id)) {

            Optional<HealthResult> optionalHealthResult = HealthResultDao.getInstance().getObjectById(id);
            if (optionalHealthResult.isPresent()) {
            	HealthResult healthResult = optionalHealthResult.get();
                if (healthResult.isSaveTimes()) {
                	healthResult.setLastReadTime(LocalDateTime.now());
                }
                return healthResult;
            }
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }
    
    public boolean deleteHealthResultById(long id) {
        if (HealthResultDao.getInstance().isPresentInRepoById(id)) {
        	HealthResultDao.getInstance().collectionAccess().remove(getResultById(id));
            return true;
        }
        return false;
    }
    
    public List<HealthResult> getAllHealthResults() {
        return new ArrayList<>(HealthResultDao.getInstance().collectionAccess());
    }
    
    public HealthResult updateHealthResult(long id, HealthResult result) {
        if (HealthResultDao.getInstance().isPresentInRepoById(id)) {
        	HealthResult resultToUpdate = getResultById(id);

        	resultToUpdate.setResultName(result.getResultName());
        	resultToUpdate.setDone(result.isDone());
        	resultToUpdate.setHealthResultsOwner(result.getHealthResultsOwner());

            if (result.isSaveTimes()) {
            	resultToUpdate.setUpdatedTime(LocalDateTime.now());
            	resultToUpdate.setLastReadTime(result.getLastReadTime());
            }
        	
            HealthResultDao.getInstance().collectionAccess().remove(getResultById(id));
            HealthResultDao.getInstance().collectionAccess().add(resultToUpdate);

            return resultToUpdate;
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }
    
    public void validateResultNameInput(String resultName) {
        if (isBlank(resultName)) {
            throw new WrongInputParametersException("name cannot be null or empty");
        }
    }
    
    public void validateResultInput(float result) {

        if (result <= 0) {
            throw new WrongInputParametersException("health result cannot be below zero");
        }
    }
    
    public void validateEmailInput(final String email) {

        if (isBlank(email)) {
            throw new WrongInputParametersException("email cannot be null or empty");
        }
        if (!validator.isValid(email)) {
            throw new WrongInputParametersException("wrong email format");
        }
    }
    
}

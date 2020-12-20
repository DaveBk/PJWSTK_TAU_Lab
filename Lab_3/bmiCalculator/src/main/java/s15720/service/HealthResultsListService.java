package s15720.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import s15720.model.HealthResult;
import s15720.repository.HealthResultDao;

public class HealthResultsListService {

    public HealthResultsListService() {
    }
	
	//private final HealthResultDao healthResultDao;
	
   // public HealthResultsListService(final HealthResultDao healthResultDao) {
   //     this.healthResultDao = healthResultDao;
   // }
    
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

            HealthResultDao.getInstance().collectionAccess().remove(getResultById(id));
            HealthResultDao.getInstance().collectionAccess().add(resultToUpdate);

            return resultToUpdate;
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }
    
}

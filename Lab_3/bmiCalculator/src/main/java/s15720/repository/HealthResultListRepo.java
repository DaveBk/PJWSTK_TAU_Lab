package s15720.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import s15720.model.HealthResult;

public class HealthResultListRepo {
	 private static HealthResultListRepo ourInstance = new HealthResultListRepo();

	 public static HealthResultListRepo getInstance() {
	        return ourInstance;
	    }

	    private HealthResultListRepo() {
	    }

	    private List<HealthResult> healthResultsLists = new ArrayList<>();


	    public List<HealthResult> collectionAccess() {
	    	healthResultsLists
	                .stream();
	        return healthResultsLists;
	    }

	    public void setHealthResultsList(List<HealthResult> healthResultsLists) {
	        this.healthResultsLists = healthResultsLists;
	    }



	    public Optional<HealthResult> getObjectById(Long id) {
	        return healthResultsLists.stream()
	                .filter(u -> u.getId().equals(id))
	                .findFirst();

	    }

	    public boolean isPresentInRepoById(final Long id) {
	        return healthResultsLists.stream().anyMatch(u -> u.getId().equals(id));
	    }
	 
}

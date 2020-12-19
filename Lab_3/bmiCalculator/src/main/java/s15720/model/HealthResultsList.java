package s15720.model;

import java.util.List;

public class HealthResultsList {
	private Long id;
    private List<HealthResult> healthResults;
    
    public HealthResultsList() {
    }
    
    public HealthResultsList(Long id, List<HealthResult> healthResults) {
    	this.id = id;
    	this.healthResults = healthResults;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HealthResult> getHealthResults() {
        return healthResults;
    }

    public void setHealthResults(List<HealthResult> healthResults) {
        this.healthResults = healthResults;
    }
    
}

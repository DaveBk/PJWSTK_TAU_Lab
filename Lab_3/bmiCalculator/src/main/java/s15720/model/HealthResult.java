package s15720.model;

public class HealthResult {
	
    private Long id;
    private String resultName;
    private boolean isDone;
    private HealthResultsOwner healthresultOwner;

    public HealthResult() {
    }
    
    public HealthResult(long id, String taskName) {
        this.id = id;
        this.resultName = taskName;
        this.isDone = false;
        this.healthresultOwner = new HealthResultsOwner();

    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public HealthResultsOwner getHealthResultsOwner() {
        return healthresultOwner;
    }

    public void setHealthResultsOwner(HealthResultsOwner healthresultOwner) {
        this.healthresultOwner = healthresultOwner;
    }

    @Override
    public String toString() {
        return "HealthResult{" +
                "id=" + id +
                ", resultName='" + resultName + '\'' +
                ", isDone=" + isDone +
                ", healthresultOwner=" + healthresultOwner +
                '}';
    }
    
}

package s15720.model;

public class HealthResult {
	
    private Long id;
    private String resultName;
    private float result;
    private boolean isDone;
    private HealthResultsOwner healthresultOwner;

    public HealthResult() {
    }
    
    public HealthResult(long id, String resultName, float result) {
        this.id = id;
        this.resultName = resultName;
        this.result = result;
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
    
    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
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

package s15720.model;

import java.time.LocalDateTime;

public class HealthResult {
	
    private Long id;
    private String resultName;
    private float result;
    private boolean isDone;
    private HealthResultsOwner healthresultOwner;
    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;
    private boolean saveTimes;
    
    public HealthResult() {
    }
    
    public HealthResult(long id, String resultName, float result) {
        this.id = id;
        this.resultName = resultName;
        this.result = result;
        this.isDone = false;
        this.healthresultOwner = new HealthResultsOwner();
        this.creationTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
        this.saveTimes = true;

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
    
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(LocalDateTime lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public boolean isSaveTimes() {
        return saveTimes;
    }

    public void setSaveTimes(boolean saveTimes) {
        this.saveTimes = saveTimes;
    }

    @Override
    public String toString() {
        return "HealthResult{" +
                "id=" + id +
                ", resultName='" + resultName + '\'' +
                ", isDone=" + isDone +
                ", healthresultOwner=" + healthresultOwner +
                ", creationTime=" + creationTime +
                ", updatedTime=" + updatedTime +
                ", lastReadTime=" + lastReadTime +
                ", saveTimes=" + saveTimes +
                '}';
    }
    
}

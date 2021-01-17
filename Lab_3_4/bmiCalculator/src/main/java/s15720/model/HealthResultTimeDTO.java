package s15720.model;

import java.time.LocalDateTime;

public class HealthResultTimeDTO {
	
    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;
    
    public HealthResultTimeDTO() {
    }

    public HealthResultTimeDTO(LocalDateTime creationTime, LocalDateTime updatedTime, LocalDateTime lastReadTime) {
        this.creationTime = creationTime;
        this.updatedTime = updatedTime;
        this.lastReadTime = lastReadTime;
    }

    public HealthResultTimeDTO create(HealthResult result) {
        return new HealthResultTimeDTO(result.getCreationTime(), result.getUpdatedTime(), result.getLastReadTime());
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }
}

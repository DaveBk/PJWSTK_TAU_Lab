package s15720.service;

import s15720.model.HealthResult;

public class HealthResultFactory {

    public static HealthResult create(long id, String resultName, float result) {
        return new HealthResult(id, resultName, result);
    }
	
}

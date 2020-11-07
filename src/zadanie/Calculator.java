package zadanie;

public class Calculator {

	public float calculateBMI(float height, float weight, float age) {
		
        String heightStr = String.valueOf(height);
        String weightStr = String.valueOf(weight);
        String ageStr = String.valueOf(age);
        float result = 0;
        
        if (heightStr == null || "".equals(heightStr)
                || weightStr == null || "".equals(weightStr)) 
        	throw new IllegalArgumentException("Wrong data");
        else{

            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            result = weightValue / (heightValue * heightValue);
        }
        
        return result;
    }

    private float calculateBHC(String heightStr, String weightStr, String ageStr, String sex) {
        
    	float heightValue = Float.parseFloat(heightStr);
        float weightValue = Float.parseFloat(weightStr);
        float ageValue = Float.parseFloat(ageStr);
        float result = 0;


        if(sex.equals(("female"))) {
            result = 655.1f + (9.563f * weightValue) + (1.85f * heightValue) - (4.676f * ageValue);
        }else if(sex.equals(("male"))) {
            result = 66.5f + (13.75f * weightValue) + (5.003f * heightValue) - (6.775f * ageValue);
        }

        return result;
    }
	
	
}

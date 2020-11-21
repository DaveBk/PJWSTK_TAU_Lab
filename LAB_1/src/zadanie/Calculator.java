package zadanie;

public class Calculator {

	public float CalculateBMI(float height, float weight, float age) {
		
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

	public float CalculateBHC(String heightStr, String weightStr, String ageStr, String sex) {
        
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
	
	public String DisplayBMI(float bmi) {

		String bmiInfo;
		
        if (Float.compare(bmi, 15f) <= 0) {
        	bmiInfo = "wyglodzenie";
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
        	bmiInfo = "wychudzenie";
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
        	bmiInfo = "niedowaga";
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
        	bmiInfo = "wartosc_prawidlowa";
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
        	bmiInfo = "nadwaga";
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
        	bmiInfo = "I_stopien_otylosci";
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
        	bmiInfo = "II_stopien_otylosci";
        } else {
        	bmiInfo = "oty³osc_skrajna";
        }

        return bmiInfo;
    }
    
}

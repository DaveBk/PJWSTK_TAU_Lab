package s15720.bmiCalculator;

public class WrongInputParametersException extends RuntimeException {
    public WrongInputParametersException(String message) {
        super("wrong input parameter: " + message);
    }
}

public class InputValidator implements IInputValidator {
    public boolean validateAngleAndVelocityInput(int inputAngle, int inputVelocity) {
        if (inputAngle >= 1 || inputAngle <= 90) {
            if (inputVelocity >= 1 || inputVelocity <= 20) {
                return true;
            }
        }
        return false;
    }
}

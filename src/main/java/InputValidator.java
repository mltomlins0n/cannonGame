public class InputValidator implements IInputValidator {
    public boolean ValidateAngleAndVelocityInput(int inputAngle, int inputVelocity ) {
        if ((inputAngle >= 1 && inputAngle <= 90) && (inputVelocity >= 1 && inputVelocity <= 20)) {
            return true;
        }
        return false;
    }
}

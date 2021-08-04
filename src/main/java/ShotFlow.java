public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IInputValidator _inputValidator;

    public ShotFlow(IShot _shot, IInputValidator _inputValidator){
        this._shot = _shot;
        this._inputValidator = _inputValidator;
    }

    @Override
    public boolean flow(String angle, String velocity) {
        boolean validShot = _inputValidator.validateAngleAndVelocityInput(validAngle, validVelocity);

        if (validShot) {
            // if a valid input for shot
            // then compute shot
            int[] shot = _shot.calculateShot(validAngle, validVelocity);
        }
        return true;
    }
}

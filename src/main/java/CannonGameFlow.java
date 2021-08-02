public class CannonGameFlow implements ICannonGameFlow {

    private ITargetGenerator _targetGenerator;
    private IShot _shot;
    private IIntegerChecker _integerChecker;
    private IJudge _judgeShot;
    private IInputValidator _inputValidator;

    public CannonGameFlow(ITargetGenerator _targetGenerator, IShot _shot, IIntegerChecker _integerChecker, IJudge _judgeShot, IInputValidator _inputValidator) {
        this._targetGenerator = _targetGenerator;
        this._shot = _shot;
        this._integerChecker = _integerChecker;
        this._judgeShot = _judgeShot;
        this._inputValidator = _inputValidator;
    }

    public String flow(String angle, String velocity) {
        int[] target = _targetGenerator.getTarget();
        boolean result = _integerChecker.isInt(angle, velocity);
        if (result) {
            int[] shot = _shot.calculateShot(Integer.parseInt(angle), Integer.parseInt(velocity));

            boolean judgeRes = _judgeShot.doesTheShotMatchTheTarget(target,shot);
        }
        return "Please enter valid values for angle and velocity.";
    }

}

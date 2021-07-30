public class CannonGameFlow implements ICannonGameFlow {

    private ITargetGenerator _targetGenerator;
    private IShot _shot;
    private IIntegerChecker _integerChecker;

    public CannonGameFlow(ITargetGenerator targetGenerator, IShot shot, IIntegerChecker integerChecker) {
        this._targetGenerator = targetGenerator;
        this._shot = shot;
        this._integerChecker = integerChecker;
    }

    public String flow(String angle, String velocity) {
        _targetGenerator.getTarget();
        boolean result = _integerChecker.isInt(angle, velocity);
        if (result) {
            _shot.calculateShot(Integer.parseInt(angle), Integer.parseInt(velocity));
        }
        return "Please enter valid values for angle and velocity.";
    }

}

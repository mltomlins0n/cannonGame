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
        _shot.calculateShot();
        _integerChecker.isInt(angle, velocity);

        return "";
    }

}

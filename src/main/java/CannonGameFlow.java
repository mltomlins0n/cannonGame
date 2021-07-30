public class CannonGameFlow implements ICannonGameFlow {

    private ITargetGenerator _targetGenerator;
    private IShot _shot;

    public CannonGameFlow(ITargetGenerator targetGenerator, IShot shot) {
        this._targetGenerator = targetGenerator;
        this._shot = shot;
    }

    public String flow(String angle, String velocity) {

        _targetGenerator.getTarget();
        _shot.calculateShot();

        return "";
    }

}

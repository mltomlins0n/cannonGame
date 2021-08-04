public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IInputValidator _inputValidator;
    private IJudge _judge;
    private IShotCounter _shotCounter;

    public ShotFlow(IShot shot, IInputValidator inputValidator,
                    IJudge judge, IShotCounter shotCounter) {
        this._shot = shot;
        this._inputValidator = inputValidator;
        this._judge = judge;
        this._shotCounter = shotCounter;
    }

    @Override
    public boolean flow(String angle, String velocity) {
        return true;
    }
}

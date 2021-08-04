public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IInputValidator _inputValidator;
    private IJudge _judge;
    private IShotCounter _shotCounter;

    public ShotFlow(IShot _shot, IInputValidator _inputValidator){
        this._shot = _shot;
        this._inputValidator = _inputValidator;
        this._judge = _judge;
        this._shotCounter = _shotCounter;
    }

    @Override
    public boolean flow(String angle, String velocity) {
        if ()
    }
}

public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IInputValidator _inputValidator;
    private IJudge _judge;
    private IShotCounter _shotCounter;
    private IIntegerChecker _integerChecker;

    public ShotFlow(IShot shot, IInputValidator inputValidator,
                    IJudge judge, IShotCounter shotCounter, IIntegerChecker integerChecker) {
        this._shot = shot;
        this._inputValidator = inputValidator;
        this._judge = judge;
        this._shotCounter = shotCounter;
        this._integerChecker = integerChecker;
    }

    @Override
    public boolean flow(String angle, String velocity) {
        boolean validInput = _integerChecker.isInt(angle, velocity);

        if (validInput) {
            int validAngle = Integer.parseInt(angle);
            int validVelocity = Integer.parseInt(velocity);
            _shot.calculateShot(validAngle, validVelocity);
            int[] testShot = {1, 2};
            int[] testTarget = {1, 2};
            _judge.judgeShot(testShot, testTarget);
            _shotCounter.incrementCounter();
            _shotCounter.getCounter();
        }


        return false;
    }
}

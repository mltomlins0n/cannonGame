import java.util.Arrays;

public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IInputValidator _inputValidator;
    private IJudge _judge;
    private IShotCounter _shotCounter;
    private IIntegerChecker _integerChecker;

    public ShotFlow(IShot shot, IInputValidator inputValidator,
                    IJudge judge, IShotCounter shotCounter,
                    IIntegerChecker integerChecker) {
        this._shot = shot;
        this._inputValidator = inputValidator;
        this._judge = judge;
        this._shotCounter = shotCounter;
        this._integerChecker = integerChecker;
    }

    @Override
    public boolean flow(String angle, String velocity, int[] target) {
        boolean targetHit = false;

        boolean validInput = _integerChecker.isInt(angle, velocity);

        if (validInput) {
            int validAngle = Integer.parseInt(angle);
            int validVelocity = Integer.parseInt(velocity);
            boolean validShot = _inputValidator.validateAngleAndVelocityInput(validAngle, validVelocity);

            if (validShot) {
                int[] shot =_shot.calculateShot(validAngle, validVelocity);
                _shotCounter.incrementCounter();
                targetHit = _judge.judgeShot(shot, target);
                System.out.println("The target is at " + Arrays.toString(target) +
                        ", your shot landed at " + Arrays.toString(shot));

                if (targetHit) {
                    System.out.print("You've hit your target!!! Yeeeaaaaaahh!");
                    _shotCounter.incrementCounter();
                    System.out.println("\nIt took you " + _shotCounter.getCounter() + " shots.");
                } else {
                    System.out.print("You missed, please enter another shot");
                }
            } else {
                System.out.println("Please enter valid values for angle and velocity.");
            }
        }
        return targetHit;
    }
}

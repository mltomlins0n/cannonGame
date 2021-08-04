import java.util.Arrays;


public class CannonGameFlow implements ICannonGameFlow {

    private IShotCounter _shotCounter;
    private ITargetGenerator _targetGenerator;
    private IShot _shot;
    private IIntegerChecker _integerChecker;
    private IJudge _judge;
    private IInputValidator _inputValidator;

    public CannonGameFlow(IShotCounter shotCounter, ITargetGenerator targetGenerator,
                          IShot shot, IIntegerChecker integerChecker,
                          IJudge judge, IInputValidator inputValidator) {

        this._shotCounter = shotCounter;
        this._targetGenerator = targetGenerator;
        this._shot = shot;
        this._integerChecker = integerChecker;
        this._judge = judge;
        this._inputValidator = inputValidator;
    }

    @Override
    public String flow(String angle, String velocity) {
        String messageTerminal = " ";
        int[] target = _targetGenerator.generateTarget();
        boolean validInput = _integerChecker.isInt(angle, velocity);
        if (validInput) {
            int validAngle = Integer.parseInt(angle);
            int validVelocity = Integer.parseInt(velocity);
            boolean validShot = _inputValidator.validateAngleAndVelocityInput(validAngle, validVelocity);

            //call shot.flow()
            //_shot.flow(angle, velocity, target);

            if (validShot) {
                int[] shot = _shot.calculateShot(validAngle, validVelocity);

                boolean judgeResult = _judge.judgeShot(shot, target);

                _shotCounter.incrementCounter();
                System.out.print("Target was located at: " + Arrays.toString(target) + " " +
                        "Your shot hit the following Coordinates: " + Arrays.toString(shot));
                if (judgeResult) {
                    System.out.print("You've hit your target!!! Yeeeaaaaaahh!");
                    messageTerminal = (" It took you " + _shotCounter.getCounter() + " Shots");
                } else {
                    System.out.print("You missed, please enter another shot");
                }
            } else {
                return "Please enter valid values for angle and velocity.";
            }
        }
        return messageTerminal;
    }
}

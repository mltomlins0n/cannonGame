import java.util.Arrays;


public class CannonGameFlow implements ICannonGameFlow {

    private IShotCounter _shotCounter;
    private ITargetGenerator _targetGenerator;
    private IShot _shot;
    private IIntegerChecker _integerChecker;
    private IJudge _judgeShot;
    private IInputValidator _inputValidator;
    private int[] generatedValues = new int[2];

    public CannonGameFlow(IShotCounter _shotCounter, ITargetGenerator _targetGenerator,
                          IShot _shot, IIntegerChecker _integerChecker,
                          IJudge _judgeShot, IInputValidator _inputValidator) {

        this._shotCounter = _shotCounter;
        this._targetGenerator = _targetGenerator;
        this._shot = _shot;
        this._integerChecker = _integerChecker;
        this._judgeShot = _judgeShot;
        this._inputValidator = _inputValidator;
    }

    @Override
    public int[] getTargetValues() {
        this.generatedValues = _targetGenerator.generateTarget();
        return generatedValues;
    }


    @Override
    public String flow(String angle, String velocity) {
        String messageTerminal = " ";
        // define random array
        // set random array = generated target from getter
        // if valid shot
        int[] randomTargetValues;
        randomTargetValues = generatedValues;
        if (randomTargetValues.length == 2) {
            // validate shot
            boolean validInput = _integerChecker.isInt(angle, velocity);
            if (validInput) {
                int validAngle = Integer.parseInt(angle);
                int validVelocity = Integer.parseInt(velocity);
                boolean validShot = _inputValidator.validateAngleAndVelocityInput(validAngle, validVelocity);

                if (validShot) {
                    // if a valid input for shot
                    // then compute shot
                    int[] shot = _shot.calculateShot(validAngle, validVelocity);
                    // judge shot against target
                    boolean judgeResult = _judgeShot.judgeShot(shot, randomTargetValues);
                    //increment counter
                    _shotCounter.incrementCounter();
                    System.out.print("Target was located at: " + Arrays.toString(randomTargetValues) + " " +
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
        }
        return messageTerminal;
    }
}

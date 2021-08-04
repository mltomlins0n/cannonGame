import java.util.Arrays;
import java.util.Scanner;


public class RoundFlow implements IRoundFlow {

    private IShotCounter _shotCounter;
    private ITargetGenerator _targetGenerator;
    private IShot _shot;
    private IIntegerChecker _integerChecker;
    private IJudge _judge;
    private IInputValidator _inputValidator;
    private IShotFlow _shotFlow;

    public RoundFlow(IShotCounter shotCounter, ITargetGenerator targetGenerator,
                     IShot shot, IIntegerChecker integerChecker,
                     IJudge judge, IInputValidator inputValidator, IShotFlow shotFlow) {

        this._shotCounter = shotCounter;
        this._targetGenerator = targetGenerator;
        this._shot = shot;
        this._integerChecker = integerChecker;
        this._judge = judge;
        this._inputValidator = inputValidator;
        this._shotFlow = shotFlow;
    }

    @Override
    public String roundFlow(String angle, String velocity) {
        String messageTerminal = " ";
        int[] target = _targetGenerator.generateTarget();
        System.out.println("Your target is at: " + Arrays.toString(target));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter in an angle between 1-90: ");
        angle = scanner.nextLine();
        System.out.print("Please enter in a velocity between 1-20: ");
        velocity = scanner.nextLine();

        boolean validInput = _integerChecker.isInt(angle, velocity);
        if (validInput) {
            int validAngle = Integer.parseInt(angle);
            int validVelocity = Integer.parseInt(velocity);
            boolean validShot = _inputValidator.validateAngleAndVelocityInput(validAngle, validVelocity);
            if (validShot) {
                _shotFlow.shotFlow(validAngle, validVelocity, target);
            }
            else {
                System.out.println("Please enter valid values for angle and velocity.");
        }
        }
        return messageTerminal;
    }
}

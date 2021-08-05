import java.util.Arrays;
import java.util.Scanner;


public class RoundFlow implements IRoundFlow {

    private ITargetGenerator _targetGenerator;
    private IIntegerChecker _integerChecker;
    private IInputValidator _inputValidator;
    private IShotFlow _shotFlow;

    public RoundFlow(ITargetGenerator targetGenerator, IIntegerChecker integerChecker,
                     IInputValidator inputValidator, IShotFlow shotFlow) {

        this._targetGenerator = targetGenerator;
        this._integerChecker = integerChecker;
        this._inputValidator = inputValidator;
        this._shotFlow = shotFlow;
    }

    @Override
    public String roundFlow(String angle, String velocity) {
        int[] target = _targetGenerator.generateTarget();

        System.out.print("Cannon Game");
        System.out.print("\n-------------\n");
        System.out.println("Your target is at: " + Arrays.toString(target));

        Scanner scanner = new Scanner(System.in);
        while(true) {
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
                    boolean shotResult =_shotFlow.shotFlow(validAngle, validVelocity, target);
                    if (shotResult) {
                        break;
                    }
                } else {
                    System.out.println("Please enter valid values for angle and velocity.");
                }
            }
        }
        return "";
    }
}


public class IntegerChecker implements IIntegerChecker {

    public boolean isInt(String inputAngle, String inputVelocity) {
        try {
            Integer.parseInt(inputAngle);
            Integer.parseInt(inputVelocity);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

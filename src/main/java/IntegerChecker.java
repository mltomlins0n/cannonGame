public class IntegerChecker implements IIntegerChecker {

    public boolean isInt(String inputAngle, String inputVelocity) {
        try {
            Integer.parseInt(inputAngle);
            Integer.parseInt(inputVelocity);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

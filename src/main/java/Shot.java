public class Shot implements IShot {

    @Override
    public int[] calculateShot(int inputAngle, int inputVelocity) {

        double angleDegrees = inputAngle * (Math.PI / 180);

        int xShot = (int) (inputVelocity * (Math.cos(angleDegrees)));
        int yShot = (int) (inputVelocity * (Math.sin(angleDegrees)));

        int[] shot = new int[2];
        shot[0] = Math.round(xShot);
        shot[1] = Math.round(yShot);

        return shot;
    }

}

public class Shot implements IShot {

    @Override
    public int[] calculateShot(int inputAngle, int inputVelocity) {

        double angleDegrees = inputAngle * (Math.PI / 180);

        long xShot = Math.round((inputVelocity * (Math.cos(angleDegrees))));
        long yShot = Math.round((inputVelocity * (Math.sin(angleDegrees))));

        int[] shot = new int[2];
        shot[0] = (int)xShot;
        shot[1] = (int)yShot;

        return shot;
    }
}

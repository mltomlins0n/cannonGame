import java.util.Arrays;

public class TargetGenerator implements ITargetGenerator {

    @Override
    public int[] getTarget() {
        int randVelocity = (int) (Math.random() * 20);
        int randAngle = (int) (Math.random() * 90);
        double angleDegrees = randAngle * (Math.PI / 180);

        int xTarget = (int) (randVelocity * (Math.cos(angleDegrees)) + 1);
        int yTarget = (int) (randVelocity * (Math.sin(angleDegrees)) + 1);

        int[] target = new int[2];
        target[0] = Math.round(xTarget);
        target[1] = Math.round(yTarget);
        System.out.println(Arrays.toString(target));

        //while (target[0] > 10 || target[1] >10 );

        return target;

    }
}

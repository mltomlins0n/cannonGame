import java.lang.reflect.Array;
import java.util.Arrays;

public class Shot implements IShot {

    @Override
    public int[] calculateShot(int inputAngle, int inputVelocity) {
        int xShot = (int) (inputVelocity * (Math.cos(inputAngle)));
        int yShot = (int) (inputVelocity * (Math.sin(inputAngle)));

        int [] shot = new int [2];
        shot[0] = Math.round(xShot);
        shot[1] = Math.round(yShot);

        return shot;
    }

}

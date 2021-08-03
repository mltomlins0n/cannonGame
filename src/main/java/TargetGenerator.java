import java.util.Arrays;

public class TargetGenerator implements ITargetGenerator {

    @Override
    public int[] generateTarget() {
        int randX = (int) (Math.random() * 10) + 1;
        int randY = (int) (Math.random() * 10) + 1;

        int[] target = new int[2];
        target[0] = Math.round(randX);
        target[1] = Math.round(randY);

        return target;
    }
}
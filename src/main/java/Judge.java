import java.util.Arrays;

public class Judge implements IJudge {

        @Override
        public boolean judgeShot(int[] shot, int[] target) {
            return Arrays.equals(shot, target);
        }
    }



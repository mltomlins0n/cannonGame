import java.util.Arrays;

public class Judge implements IJudge {

        @Override
        public boolean doesTheShotMatchTheTarget(int [] shot, int [] target) {
            return Arrays.equals(shot, target);
        }
    }



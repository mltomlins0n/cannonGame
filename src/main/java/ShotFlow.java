import java.util.Arrays;

public class ShotFlow implements IShotFlow {

    private IShot _shot;
    private IJudge _judge;
    private IShotCounter _shotCounter;

    public ShotFlow(IShot shot, IJudge judge, IShotCounter shotCounter) {
        this._shot = shot;
        this._judge = judge;
        this._shotCounter = shotCounter;
    }

    @Override
    public boolean shotFlow(int angle, int velocity, int[] target) {
        boolean targetHit;

        int[] shot = _shot.calculateShot(angle, velocity);
        _shotCounter.incrementCounter();
        targetHit = _judge.judgeShot(shot, target);
        System.out.println("The target is at " + Arrays.toString(target) +
                ", your shot landed at " + Arrays.toString(shot));

        if (targetHit) {
            System.out.print("You've hit your target!!! Yeeeaaaaaahh!");
            System.out.println("\nIt took you " + _shotCounter.getCounter() + " shots.");
        } else {
            System.out.print("You missed, please enter another shot\n");
        }
        return targetHit;
    }
}





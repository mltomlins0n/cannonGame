public class ShotCounter implements IShotCounter {
    private int counter;

    @Override
    public void incrementCounter(){
        counter += 1;
    }
    @Override
    public int getCounter(){
        return  counter;
    }
    @Override
    public void setCounter(int counter) {
        this.counter = counter;
    }
}

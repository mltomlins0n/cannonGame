import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean(name = "targetGenerator")
    public TargetGenerator generateTarget(){
        return new TargetGenerator();
    }
    @Bean(name = "inputValidator")
    public InputValidator validateAngleAndVelocityInput(){
        return new InputValidator();
    }
    @Bean(name = "shot")
    public Shot calculateShot(){
        return new Shot();
    }
    @Bean(name = "integerChecker")
    public IntegerChecker isInt(){
        return new IntegerChecker();
    }
    @Bean(name = "judge")
    public Judge judgeShot(){
        return new Judge();
    }
    @Bean(name = "shotCounter")
    public ShotCounter shotCounter(){
        return new ShotCounter();
    }
    @Bean(name = "shotFlow")
    public ShotFlow shotFlow(){
        return new ShotFlow(calculateShot(), judgeShot(), shotCounter());
    }
    @Bean(name = "roundFlow")
    public RoundFlow roundFlow(){
        return new RoundFlow(shotCounter(), generateTarget(), calculateShot(),
                isInt(), judgeShot(), validateAngleAndVelocityInput(), shotFlow());
    }
}

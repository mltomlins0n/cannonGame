import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IRoundFlow roundFlow = applicationContext.getBean("roundFlow", RoundFlow.class);

        System.out.print("Cannon Game");
        System.out.print("\n-------------\n");

        roundFlow.roundFlow("1", "1");
    }
}
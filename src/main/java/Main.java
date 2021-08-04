import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ICannonGameFlow flowClass = applicationContext.getBean("flowClassConfig", RoundFlow.class);

        System.out.print("Please enter an angle between 1-90 and a velocity between 1-20: ");

        // call flow class here
    }
}
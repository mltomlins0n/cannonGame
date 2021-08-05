import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IRoundFlow roundFlow = applicationContext.getBean("roundFlow", RoundFlow.class);
        
        roundFlow.roundFlow("1", "1");
    }

}
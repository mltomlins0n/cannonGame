import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IRoundFlow roundFlow = applicationContext.getBean("roundFlow", RoundFlow.class);

        roundFlow.roundFlow("1", "1");
    }
}
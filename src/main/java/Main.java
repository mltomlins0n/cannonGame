import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        //ICannonGameFlow fClass = context.getBean("flowClassConfig", ICannonGameFlow.class);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ICannonGameFlow flowClass = applicationContext.getBean("flowClassConfig", CannonGameFlow.class);

        System.out.println("Your target is at: " + Arrays.toString(flowClass.getTargetValues()));
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an angle between 1-90 and a velocity between 1-20: ");

        while (true) {
            String inputX = sc.next();
            String inputY = sc.next();
            String result = flowClass.flow(inputX,inputY);
            if(inputX.equalsIgnoreCase("quit")){
                break;
            }
        }
    }
}
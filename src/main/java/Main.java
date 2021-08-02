import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        ICannonGameFlow fClass = context.getBean("flowClassConfig", ICannonGameFlow.class);

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an angle between 1-90 and a velocity between 1-20: ");


        while (true) {
            String inputX = sc.next();
            String inputY = sc.next();
            String result = fClass.flow(inputX,inputY);
            System.out.println("You have fired at: " + result);
            if(inputX.equalsIgnoreCase("quit")){
                break;
            }
        }
    }
}
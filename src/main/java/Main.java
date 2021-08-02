import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        ICannonGameFlow fClass = context.getBean("flowClassConfig", ICannonGameFlow.class);

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an velocity ");

        System.out.print("Please enter an angle ");

        while (true) {
            String input = sc.next();
            //String result = fClass.flow(input);
            //System.out.println(result);
            if(input.equalsIgnoreCase("quit")){
                break;
            }
        }
    }
}
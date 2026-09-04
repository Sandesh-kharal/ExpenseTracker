package in.sandesh.expensetrackerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseTrackerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerAppApplication.class, args);
        System.out.println("hello world expense tracker");
    }

}

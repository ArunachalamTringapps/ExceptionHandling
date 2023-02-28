package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainMethod {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Logger l=Logger.getLogger(MainMethod.class.getName());
        l.info("Welcome to Exception Handling");
        int ch;
        do {
            l.info("Enter your choice:");
            l.info("1.BasicSchool\n2.BasicShape\n3.Credit\n4.JDBCPoll\n5.Points\n6.SimpleBank");
            ch=sc.nextInt();
            switch (ch) {
                case 1 -> BasicSchool.firstname();
                case 2 -> BasicShapeException.firstname();
                case 3 -> CreditException.firstname();
                case 4 -> JDBCPollException.firstname();
                case 5 -> PointsException.firstname();
                case 6 -> SimpleBankException.firstname();
                default -> l.info("Thanks You Guys:)");
            }
        }while (ch<7);

    }
}

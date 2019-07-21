/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author cswan
 */
public class TimeTest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LocalTime open = LocalTime.parse("11:30");
        LocalTime close = LocalTime.parse("00:15");
        LocalTime closingSoon = close.minusMinutes(30);
        //System.out.println(closingSoon);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime now = LocalDateTime.now(); 
        //System.out.println(now.toString());
        LocalTime test;
        test = LocalTime.parse("00:16");
        
//        System.out.println(test);  
        
        boolean isOpen = false;
        boolean isClosingSoon = false;
        
        if (closingSoon.isAfter(close) && (test.isAfter(closingSoon) || test.isBefore(close))){
            isClosingSoon = true;
        }
        else if (test.isAfter(closingSoon) && test.isBefore(close)){
            isClosingSoon = true;
        }
        else if (close.isBefore(open)){
            
            if (test.isBefore(open) && test.isBefore(close)){
                isOpen = true;
            } 
            else {
                isOpen = test.isAfter(open) && (test.isBefore(LocalTime.parse("23:59:59")) || test.isBefore(close));
            }
        }
        else {
            isOpen = test.isAfter(open) && test.isBefore(close);
        }

        if(isClosingSoon){
            System.out.println("Closing Soon");
        }
        else if(isOpen){
            System.out.println("Open");
        }
        else{
            System.out.println("Closed");
        }

    }
}

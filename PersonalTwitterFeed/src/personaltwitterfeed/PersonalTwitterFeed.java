/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaltwitterfeed;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author CCannon
 */
public class PersonalTwitterFeed {

    private static int MAX_NUMBER_TWEETS = 200;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] tweets = new String[MAX_NUMBER_TWEETS];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to your personal Twitter!");
        System.out.println("What's your name, tweeter?");
        
        String tweeterName = keyboard.nextLine();
        
        System.out.println("Nice to meet you " + tweeterName + "!");
        
        
        int numTweets = 0;
        
        while(numTweets < (MAX_NUMBER_TWEETS - 1)) {
            newTweet(tweets, numTweets, keyboard);
            numTweets++;
            
            System.out.println(tweeterName + "'s Personal Twitter Feed:");
            for(int i = 0; i < numTweets; i++) {
                System.out.println("- " + tweets[i]);
            }
            
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            
            if(numTweets < (MAX_NUMBER_TWEETS - 1))
                System.out.println("Enter your next tweet:");
        }
        
        System.out.println("Your twitter feed is full");
    }
    
    private static void newTweet(String[] tweets, int numTweets, Scanner keyboard){
        System.out.println("Enter your tweets and I will add them to your timeline!");
        tweets[numTweets] = keyboard.nextLine() + " " + getTimeStamp();
    }
    
    private static String getTimeStamp(){
        StringBuffer buffer = new StringBuffer();
        SimpleDateFormat timeStampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        Date now = new Date();
        
        buffer = timeStampFormatter.format(now, buffer, new FieldPosition(0));
        String timeStamp = buffer.toString();
        
        return timeStamp; 
    }
    
}
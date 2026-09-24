package lab1;
import java.util.Scanner;

public class WeatherChecker {
    public static void main(String[] args) {
        Weather myWeather = new Weather();
        Weather otherWeather = new Weather();
        Weather moreWeather = new Weather();

        Scanner input = new Scanner(System.in);
        String userDay;
        int userTemperature;
        int userPrecipitation;

        otherWeather.setDay("Monday");
        otherWeather.setDegrees(80);
        otherWeather.setPercipitation(100);
        System.out.println(otherWeather.getWeather(false) + "\n");

        moreWeather.setDay("Wednesday");
        moreWeather.setDegrees(1);
        moreWeather.setPercipitation(2);
        System.out.println(moreWeather.getWeather(false) + "\n");
        
        System.out.println("Which day would you like to get a weather predicition for?");
        userDay = input.nextLine();
        myWeather.setDay(userDay);

        System.out.println("Great! What will the temperature be on " + userDay);
        userTemperature = input.nextInt();
        myWeather.setDegrees(userTemperature);

        System.out.println("And the precipitation?");
        userPrecipitation = input.nextInt();
        myWeather.setPercipitation(userPrecipitation);

        System.out.println(myWeather.getWeather(true));
        input.close();
    }
}

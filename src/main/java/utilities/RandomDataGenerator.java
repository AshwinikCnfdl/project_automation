package utilities;

//import com.github.javafaker.Faker;
import net.datafaker.Faker;

import java.util.Random;

public class RandomDataGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    // Generate a random first name
    public static String getFirstName() {
        return faker.name().firstName();
    }

    // Generate a random last name
    public static String getLastName() {
        return faker.name().lastName();
    }

    // Generate a random email with dynamic numbers to avoid duplicates
    public static String getEmail() {
        return faker.internet().emailAddress().replace("@", random.nextInt(1000) + "@");
    }

    // Generate a strong password
    public static String getPassword() {
        return faker.internet().password(8, 12, true, true, true);
    }

    // Generate a random phone number
    public static String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    // Generate a random address
    public static String getAddress() {
        return faker.address().fullAddress();
    }

    // Generate a random number within a range
    public static int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args){
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getEmail());
        System.out.println(getPassword());
        System.out.println(getPhoneNumber());
        System.out.println(getAddress());


    }
}

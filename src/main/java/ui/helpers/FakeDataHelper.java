package ui.helpers;

import com.github.javafaker.Faker;

import java.nio.file.attribute.UserPrincipal;
import java.util.Locale;

public class FakeDataHelper {
    private static final Faker faker = new Faker(new Locale("ru"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomMiddleName() {
        return faker.name().nameWithMiddle();
    }

    private static final Faker faker1 = new Faker();

    public String getRandomMail() {
        return faker1.internet().emailAddress();
    }


}

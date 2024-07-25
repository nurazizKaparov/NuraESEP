package ui.helpers;

import com.github.javafaker.Faker;

import java.nio.file.attribute.UserPrincipal;

public class FakeDataHelper {
    private static final Faker faker = new Faker();

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomMiddleName() {
        return faker.name().nameWithMiddle();
    }

    public String getRandomMail() {
        return faker.internet().emailAddress();
    }


}

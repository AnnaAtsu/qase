package dto;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProjectFactory {

    public static Project getProject() {
        Faker faker = new Faker();
        return new Project(
                faker.name().name(),
                faker.name().name(),
                faker.lorem().paragraph()
        );
    }
}

package classes.staticfactorymethod;

import java.time.LocalDate;

class PersonClassicApproach {
    private final String name;
    private final LocalDate birthday;


    PersonClassicApproach(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    PersonClassicApproach(String name) {
        this.name = name;
        this.birthday = LocalDate.now();
    }

}

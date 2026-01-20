package classes.staticfactorymethod;

import java.time.LocalDate;

class PersonAlternativeApproach {
    private final String name;
    private final LocalDate birthday;


    private PersonAlternativeApproach(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    static PersonAlternativeApproach of(String name, LocalDate birthday) {
        return new PersonAlternativeApproach(name, birthday);
    }

    static PersonAlternativeApproach getNewborn(String name) {
        return new PersonAlternativeApproach(name, LocalDate.now());
    }

}

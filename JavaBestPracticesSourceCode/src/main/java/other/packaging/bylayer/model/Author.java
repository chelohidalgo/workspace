package other.packaging.bylayer.model;

import java.time.LocalDate;

public record Author(String id, String firstName, String lastName, LocalDate birthday){}

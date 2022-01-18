package com.example.mongodemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String firstName;
    private String lastName;

    @DBRef
    private Profile profile;

}

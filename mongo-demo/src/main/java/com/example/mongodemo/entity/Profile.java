package com.example.mongodemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private String id;

    @Indexed(unique = true)
    private String idProfile;

    private String name;
    private String description;

}

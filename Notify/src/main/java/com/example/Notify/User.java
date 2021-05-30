package com.example.Notify;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("users") //collection name
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id String _id;
    private String name;
    private String emailId;
    private String password;
    private Date dateOfBirth;
    private String mobileNumber;
}

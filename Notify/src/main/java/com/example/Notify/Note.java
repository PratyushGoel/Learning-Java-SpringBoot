package com.example.Notify;

import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("notes") //collection name
@Getter @Setter
@RequiredArgsConstructor

public class Note {

    @Id String _id;
    @CreatedDate LocalDateTime date;
    private String title;
    private String content;
    private String emailId;

    public void print(){
        System.out.println(this.date);
        System.out.println(this.emailId);
        System.out.println(this.title);
        System.out.println(this.content);
    }

}

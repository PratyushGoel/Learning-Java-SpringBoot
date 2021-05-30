import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class note {

    @Getter @Setter private LocalDateTime date;
    @Getter @Setter private String title;
    @Getter @Setter private String content;
    @Getter @Setter private String emailId;

    // constructor
    public note(String emailId, String title, String content){
        this.emailId = emailId;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        System.out.println("Note Created Successfully !");
    }

    public note(){

    }
/*

    //Getters
    public LocalDateTime getDate(){
        return this.date;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
    public String getEmailId() {
        return this.emailId;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setDate(LocalDateTime date){
        this.date = date;
    }
    public void setEmailId(String emailId) { this.emailId = emailId; }
*/

    public void print(){
        System.out.println(this.date);
        System.out.println(this.emailId);
        System.out.println(this.title);
        System.out.println(this.content);
    }

}

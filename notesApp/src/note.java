import java.time.LocalDateTime;

public class note {

    private Integer noteId;
    private LocalDateTime date;
    private String title;
    private String content;
    private String emailId;

    static Integer nextId = 1;

    //constructor
    public note(String emailId, String title, String content){
        this.emailId = emailId;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        this.noteId = nextId;
        nextId++;
        System.out.println("Note Created Successfully !");
    }

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
    public Integer getId(){
        return this.noteId;
    }
    public String getEmailId() {
        return emailId;
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


    //Main Function
    public static void main(String args[]){

    }

}
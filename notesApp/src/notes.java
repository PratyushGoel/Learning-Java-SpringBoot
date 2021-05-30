import java.util.*;
import java.time.LocalDateTime;

public class notes {

    //list of allNotes
    public Vector<note> allNotes;
//    private Integer ID;

    //default constructor
    notes(){
        allNotes = new Vector<note>();
        System.out.println("AllNotes initialised");
//        ID = 1;
    }

    //Create a note
    public void createNote(){

        String title, content, emailId;
        Scanner sc= new Scanner(System.in);
        System.out.println("Input Title, Content, emailId");
        title = sc.nextLine();
        content = sc.nextLine();
        emailId = sc.nextLine();

        note newNote = new note(emailId, title, content);
//        ID++;
        allNotes.add(newNote);
    }

    //Update a note -- Content
    public void updateContent(int noteId, String content){
        allNotes.forEach(note->{
            if(note.getId() == noteId) note.setContent(content);
        });
    }

    public void updateTitle(int noteId, String title){
        allNotes.forEach(note->{
            if(note.getId() == noteId) note.setTitle(title);
        });
    }

    //delete a note
    public void deleteNode(Integer id){
        allNotes.removeIf(note -> (note.getId() == id));
    }
}

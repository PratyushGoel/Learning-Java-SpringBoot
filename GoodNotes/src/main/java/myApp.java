import java.util.ArrayList;

//ID
//remove noteRepo
//getting started Spring

public class myApp {

    public static void main(String[] args){
        dbController repo = new dbController();

//        note x = new note("email@example.com", "This is the Title", "Content is Hello World");
//        repo.addNote(x);
//        repo.deleteNoteUsingId("5ffed3bd79ea80752e4d07eb");

        ArrayList<note> myList = repo.getAllNotes();
        myList.forEach(x->x.print());
    }
}
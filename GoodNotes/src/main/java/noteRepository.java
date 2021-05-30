import java.util.ArrayList;

public class noteRepository {

    private dbController db;

    public noteRepository(){
        db = new dbController();
    }

    public note getNoteWithId(String id){
        note myNote = db.getNoteUsingObjectId(id);
        return myNote;
    }

    public void addNote(note toBeAdded){
        db.addNote(toBeAdded);
    }

    public void deleteNoteUsingId(String id){
        db.deleteNoteUsingObjectId(id);
    }

    public void updateNoteUsingId(String id, note newNote){
        db.updateNoteUsingObjectId(id, newNote);
    }

    public ArrayList<note> getAllNotes(){
        return db.getAllNotes();
    }

}
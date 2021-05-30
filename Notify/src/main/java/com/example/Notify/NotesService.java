package com.example.Notify;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

@Service
@RequiredArgsConstructor
public class NotesService {

//    @Autowired
    private final NoteRepositorySpring notesRepositorySpring;
    private final UserRepositorySpring usersRepositorySpring;
//    public NotesService(NoteRepository notesRepository) {
//        this.notesRepository = notesRepository;
//    }

//    public void NotesService(NoteRepository){
//        @Autowired
//        NoteRepository notesRepository;
//    }

    //User based services
    public void addUser(User toBeAdded){
        usersRepositorySpring.save(toBeAdded);
    }

    public boolean deleteUserUsingId(String id){
        usersRepositorySpring.deleteById(id);
        return true;
    }

    public Optional<User> getUserUsingId(String id){
        return usersRepositorySpring.findById(id);
    }

    public void updateUser(User updatedUser){
        usersRepositorySpring.save(updatedUser);
    }

    public List<User> getAllUsers(){
        return usersRepositorySpring.findAll();
    }

    //Note based services
    public void addNote(Note toBeAdded){
        notesRepositorySpring.save(toBeAdded);
    }

    public Boolean deleteNoteUsingId(String id){
        notesRepositorySpring.deleteById(id);
        return true;
    }

    public Optional<Note> getNoteUsingId(String id){
        return notesRepositorySpring.findById(id);
    }

    public void updateNote(Note updatedNote){
        notesRepositorySpring.save(updatedNote);
    }

    public List<Note> getAllNotes(){
        return notesRepositorySpring.findAll();
    }

    public List<Note> getAllNotesUsingEmailId(String emailId){
        return notesRepositorySpring.findAll().stream()
                .filter(x-> emailId.equals(x.getEmailId()))
                .collect(Collectors.toList());
    }

}

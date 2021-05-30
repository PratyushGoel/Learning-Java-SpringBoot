package com.example.Notify;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("notes")
public class NotesController {

    @Autowired
    NotesService notesService;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/")
    public String home(){
        return "This is the notes page";
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = notesService.getAllNotes();
        if (notes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notes); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable String id) {
        Optional<Note> note = notesService.getNoteUsingId(id);
        // 200
        // 404
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/notes/user")
    public ResponseEntity<List<Note>> getNotesOfUser(@RequestParam String emailId){
        List<Note> notes = notesService.getAllNotesUsingEmailId(emailId);

        if(notes.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(notes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable String id) {

        Boolean isRemoved = notesService.deleteNoteUsingId(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNote(@RequestBody Note x) {

        notesService.addNote(x);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> updateNote(@RequestBody Note x){
        notesService.updateNote(x);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

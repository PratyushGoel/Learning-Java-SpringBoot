package com.example.Notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    NotesService notesService;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/")
    public String home(){
        return "This is the Users Page";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){

        List<User> users = notesService.getAllUsers();

        if(users.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserUsingId(@PathVariable String id){
        Optional<User> user = notesService.getUserUsingId(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable String id) {

        boolean isRemoved = notesService.deleteUserUsingId(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNote(@RequestBody User x) {

        notesService.addUser(x);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> updateNote(@RequestBody User x){
        notesService.updateUser(x);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

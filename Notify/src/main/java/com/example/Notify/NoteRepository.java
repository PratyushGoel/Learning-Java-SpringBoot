package com.example.Notify;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

//@Repository
public class NoteRepository {

    MongoClient mongo;
    MongoDatabase database;
    MongoCollection<Note> collection;

    public NoteRepository(){

        ConnectionString connectionString = new ConnectionString("mongodb://localhost");

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        mongo = MongoClients.create(clientSettings);
        System.out.println("Client created");

        database = mongo.getDatabase("mydb");
        System.out.println("database accessed");

        collection = database.getCollection("notes", Note.class);
        System.out.println("Collection accessed");
    }

    public void addNote(Note toBeAdded){
        collection.insertOne(toBeAdded);
        System.out.println("Note Added successfully");
    }

    public Boolean deleteNoteUsingId(String id){
        if (collection.find(eq("_id", new ObjectId(id))) == null) {
            return false;
        }
        else{
            collection.deleteOne(eq("_id", new ObjectId(id)));
            System.out.println("Note Deleted successfully");
            return true;
        }
    }

    public Note getNoteUsingId(String id){
        return collection.find(eq("id", new ObjectId(id))).first();
    }

    public void updateNote(Note updatedNote){
        collection.replaceOne(eq("id", updatedNote.get_id()), updatedNote);
        System.out.println("Note Updated successfully");
    }


    public List<Note> getAllNotes(){
        List<Note> output = new ArrayList<>();
//        return collection.find().toString();
        FindIterable<Note> iterDoc = collection.find();

        for (Note x : iterDoc) {
            output.add(x);
        }
        return output;
    }

}

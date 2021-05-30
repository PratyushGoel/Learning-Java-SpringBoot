import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.Consumer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import org.bson.Document;
import org.bson.types.ObjectId;



public class note {

    /*private Integer noteId;
    private LocalDateTime date;
    private String title;
    private String content;
    private String emailId;


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
    }*/

    //CREATE NOTE
    private static void newNote(MongoCollection<Document> collection, String title, String content, String emailId, LocalDateTime date){
        Document newDoc = new Document("Title", title)
                .append("Content", content)
                .append("EmailId", emailId)
                .append("Date", date);
        collection.insertOne(newDoc);
        System.out.println("New Note Created");
    }

    //notes repository
    // note class
    // mongo configuration
    // naming conventions

    //UPDATE NOTE
    private static void changeTitle(MongoCollection<Document> collection, ObjectId id, String newTitle){
        collection.updateOne(eq("_id", id), combine(set("Title", newTitle)));
    }

    private static void changeContent(MongoCollection<Document> collection, ObjectId id, String newContent){
        collection.updateOne(eq("_id", id), combine(set("Content", newContent)));
    }

    //DELTE NOTE
    private static void deleteNote(MongoCollection<Document> collection, ObjectId id){
        collection.deleteOne(eq("_id", id));
    }

    //Main Function
    public static void main(String args[]){


        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        System.out.println("Client created");

        MongoDatabase database = mongo.getDatabase("mydb");
        System.out.println("database accessed");

        MongoCollection<Document> collection = database.getCollection("notes");
        System.out.println("Collection accessed");

        newNote(collection, "This is third Note", "Helo world is LIT!", "myemailid@pratyush.com", LocalDateTime.now());
//        Our function to retrieve a note
        Consumer<Document> printNote = new Consumer<Document>() {
            @Override
            public void accept(final Document document) {
                System.out.println(document.toJson());
            }
        };

//        changeTitle(collection,new ObjectId("5ffd811d9af66c6c97348b68") , "Title has changed!");
//        changeContent(collection,new ObjectId("5ffd811d9af66c6c97348b68") , "With new year comes the new content");
//        deleteNote(collection, new ObjectId("5ffd811d9af66c6c97348b68"));

        collection.find().forEach(printNote);
    }

}
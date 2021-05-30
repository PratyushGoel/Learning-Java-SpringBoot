import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class dbController {

    MongoClient mongo;
    MongoDatabase database;
    MongoCollection<note> collection;

    public dbController(){

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

        collection = database.getCollection("notes", note.class);
        System.out.println("Collection accessed");
    }

    public void addNote(note toBeAdded){
        collection.insertOne(toBeAdded);
        System.out.println("Note Added successfully");
    }

    public void deleteNoteUsingObjectId(String id){
        collection.deleteOne(eq("_id", new ObjectId(id)));
        System.out.println("Note Deleted successfully");
    }

    public note getNoteUsingObjectId(String id){
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    public void updateNoteUsingObjectId(String id, note updatedNote){
        collection.replaceOne(eq("_id", new ObjectId(id)), updatedNote);
        System.out.println("Note Updated successfully");
    }

    public ArrayList<note> getAllNotes(){
        ArrayList<note> output = new ArrayList<note>();

        FindIterable<note> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();

        while(it.hasNext()){
            note x = (note) it.next();
            output.add(x);
        }
        return output;
    }

}
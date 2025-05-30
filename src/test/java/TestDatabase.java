import Red.BaseDeDatos;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TestDatabase {
    public static void main(String[] args) {
        MongoDatabase database = BaseDeDatos.getMongoDatabase();
        
        // Verificar si la colección existe (opcional)
        if (!database.listCollectionNames().into(new java.util.ArrayList<>()).contains("Test")) {
            database.createCollection("Test");
            System.out.println("Colección Test creada");
        }
        
        MongoCollection<Document> collection = database.getCollection("Test");

        Document nuevo = new Document("nombre", "Fireploy").append("valor", true);
        collection.insertOne(nuevo);

        System.out.println("Documento insertado");
        BaseDeDatos.close();
    }
}
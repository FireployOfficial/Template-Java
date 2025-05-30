package Red;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Clase para conexión a MongoDB usando patrón Singleton.
 */
public class BaseDeDatos {

    private static final Dotenv dotenv = Dotenv.configure().load();

    private static final String MONGO_URI = dotenv.get("DB_CONNECTION_URI");
    private static final String MONGO_DB_NAME = "test";

    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(MONGO_URI);
        }
        return mongoClient;
    }

    public static MongoDatabase getMongoDatabase() {
        if (mongoDatabase == null) {
            mongoDatabase = getMongoClient().getDatabase(MONGO_DB_NAME);
        }
        return mongoDatabase;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            mongoDatabase = null;
        }
    }
}

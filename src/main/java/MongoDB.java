import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDB implements IMongoDB {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    String uri = "mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000";

    public MongoDB() {
        this.mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("playerData");
        this.collection = database.getCollection("players");
    }

    public void displayLeaderboard() {

        Bson projectionFields = Projections.fields(
                Projections.include("name", "score"),
                Projections.excludeId());

        MongoCursor<Document> results = collection.find()
                .projection(projectionFields)
                .sort(Sorts.descending("name", "score")).iterator();

        System.out.println("Leaderboard\n-------------");
        try {
            while(results.hasNext()) {
                System.out.println(results.next().toJson());
            }
        } finally {
            results.close();
        }
    }
}

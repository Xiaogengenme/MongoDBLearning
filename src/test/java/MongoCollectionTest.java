import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lzg
 * Date: 2021/5/25
 * Time: 8:34 下午
 * messge:
 */
public class MongoCollectionTest {
    public static void main(String[] args) {
        // 链接数据库
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("myDB");
        if (mongoDatabase != null) {
            System.out.println("连接数据库成功");
        } else {
            System.out.println("链接数据库失败");
        }
        // 创建collection，相当于数据库中的表
        mongoDatabase.createCollection("myCollection");
        MongoCollection<Document> collection = mongoDatabase.getCollection("myCollection");
        System.out.println(collection);
        // 首先创建document，并向document中添加kv对
        Document firstDocument = new Document("title", "documentTile");
        firstDocument.append("appendline1", "111");
        firstDocument.append("牛逼乐队", "新裤子");
        // 使用列表管理多个documents
        List<Document> documentList = new ArrayList<Document>();
        documentList.add(firstDocument);
        // 并使用document list的方法放进collection
        collection.insertMany(documentList);

    }
}

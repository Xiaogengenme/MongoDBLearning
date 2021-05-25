import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created with IntelliJ IDEA.
 * User: lzg
 * Date: 2021/5/25
 * Time: 8:19 下午
 * messge: 创建数据库
 */
public class MongoTest {
    public static void main(String[] args) {
        try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            MongoDatabase mongoDatabase = mongoClient.getDatabase("myMongoDB");
            if (mongoDatabase != null) {
                System.out.println("连接数据库成功");
            } else {
                System.out.println("链接数据库失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package aom.gupaoedu.vip.design.compositereuse;

/**
 * Created by Tom on 2020/2/17.
 */
public class ProductDao {
    // 这里用聚会
    private DBConnection dbConnection;
    public void setConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }
    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("获得数据库连接");
    }
}

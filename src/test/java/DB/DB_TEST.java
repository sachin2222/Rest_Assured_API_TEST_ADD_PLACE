package DB;

import org.testng.annotations.Test;

import java.sql.*;

public class DB_TEST {


    @Test
    public void db_test() throws SQLException, ClassNotFoundException {
        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/mypersonal", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_info;");

        while(resultSet.next()){
            System.out.println(resultSet.getString(1));

        }


        connection.close();


    }
}

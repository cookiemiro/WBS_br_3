package ssg.library.dbio;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractDBIO2<E> {

    protected Connection getConnection () {
        Connection connection = null;
        try {
            Properties properties = new Properties();

            try(FileInputStream fis = new FileInputStream("resource/database.properties")) {
                properties.load(fis);
            }

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String name = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    protected void close (Connection connection, PreparedStatement pStmt){
        try {
            if(pStmt != null) {
                pStmt.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void close (Connection connection, PreparedStatement pStmt, ResultSet rs){
        try {
            if(rs != null) {
                rs.close();
            }
            if(pStmt != null) {
                pStmt.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void create(E e) {

    }

    protected E read(){
        return null;
    }

    protected List<E> readAll(){
        return null;
    }

    protected void update(int id, E e){

    }

    protected void delete(int id){

    }
}

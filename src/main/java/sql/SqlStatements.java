package sql;

import db.DbConnection;

import java.sql.*;

public class SqlStatements {
    public static boolean accExists(int accId) throws SQLException {
       Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
       pr= dbCon.prepareStatement("SELECT * FROM battleships.accounts where id = ?;");
        pr.setInt(1,accId);
        pr.execute();
        ResultSet resultSet = pr.getResultSet();
        return resultSet.next();
    }
    public static int createGame(int player1Id) throws SQLException {//todo return int
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        pr= dbCon.prepareStatement("INSERT into gamesessions(status,player1_id) values(?,?)",
                Statement.RETURN_GENERATED_KEYS);
        pr.setString(1,"waiting");
        pr.setInt(2,player1Id);
        pr.executeUpdate();
        ResultSet resultSet = pr.getGeneratedKeys();
        if(resultSet.next()){//todo fix something with the get maybe
            System.out.println(resultSet.get;
        }
        return -1;
    }
    public static boolean joinGame(int gameId,int player1Id) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        pr= dbCon.prepareStatement("Update gamesessions set player2_id=?,status='setup' where id=?;");
        pr.setInt(1,player1Id);
        pr.setInt(2,gameId);
//        ResultSet resultSet = pr.getResultSet();
        return pr.execute();
    }
    public static boolean removeGame(int gameId) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        pr= dbCon.prepareStatement("Delete from battleships.gamesessions where id=?;");
        pr.setInt(1,gameId);
//        ResultSet resultSet = pr.getResultSet();
        return pr.execute();
    }







}

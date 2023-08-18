package sql;

import db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static boolean createGame(int player1Id) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        pr= dbCon.prepareStatement("INSERT into gamesessions(status,player1_id) values(?,?)");
        pr.setString(1,"waiting");
        pr.setInt(2,player1Id);
//        ResultSet resultSet = pr.getResultSet();
        return pr.execute();
    }
    public static boolean joinGame(int gameId,int player1Id) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        pr= dbCon.prepareStatement("Update gamesessions set player2_id=? where id=?;");
        pr.setInt(1,player1Id);
        pr.setInt(2,gameId);
//        ResultSet resultSet = pr.getResultSet();
        return pr.execute();
    }







}

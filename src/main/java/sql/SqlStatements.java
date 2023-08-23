package sql;

import java.sql.*;

public class SqlStatements {
    public static boolean accExists(int accId) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        try {
            pr = dbCon.prepareStatement("SELECT * FROM battleships.accounts where id = ?;");
            pr.setInt(1, accId);
            pr.execute();
            ResultSet resultSet = pr.getResultSet();
            return resultSet.next();
        } finally {
            if (pr != null) try {
                pr.close();
            } catch (SQLException logOrIgnore) {
            }
        }
    }

    public static int createGame(int player1Id) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        try {
            pr = dbCon.prepareStatement("INSERT into gamesessions(status,player1_id) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pr.setString(1, "waiting");
            pr.setInt(2, player1Id);
            pr.executeUpdate();
            ResultSet resultSet = pr.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } finally {
            if (pr != null) try {
                pr.close();
            } catch (SQLException ignored) {
            }
        }
        return -1;
    }

    public static boolean joinGame(int gameId, int player1Id) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        try {
            pr = dbCon.prepareStatement("Update gamesessions set player2_id=?,status='setup' where id=?;");
            pr.setInt(1, player1Id);
            pr.setInt(2, gameId);
            return pr.execute();
        } finally {
            if (pr != null) try {
                pr.close();
            } catch (SQLException ignored) {
            }
        }
//        ResultSet resultSet = pr.getResultSet();

    }

    public static boolean removeGame(int gameId) throws SQLException {
        Connection dbCon = db.DbConnection.getConnection();
        PreparedStatement pr = null;
        try {
            pr = dbCon.prepareStatement("Delete from battleships.gamesessions where id=?;");
            pr.setInt(1, gameId);
            return pr.execute();
        } finally {
            if (pr != null) try {
                pr.close();
            } catch (SQLException ignored) {
            }
        }
//        ResultSet resultSet = pr.getResultSet();

    }


}

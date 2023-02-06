package data_access_layer.transaction;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import data_access_layer.database.Database;
import entity.transaction.Transaction;

public class Transaction_DAL {
    public void saveTransaction(Transaction transaction) throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Statement statement = Database.getConnection().createStatement();
        String query = String.format("INSERT INTO transaction (name, code, time, content, amount) VALUES ("
                + "'" + transaction.getCard().getCardHolderName() + "'" + ","
                + "'" + transaction.getCard().getCardNumber() + "'" + ","
                + "'" + timestamp + "'" + ","
                + "'" + transaction.getContent() + "'" + ","
                + transaction.getAmount()
                + ")");
        statement.executeUpdate(query);
        transaction.setTime(timestamp.toString());
    }
}

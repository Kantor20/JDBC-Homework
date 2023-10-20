package pl.kurs;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/ksiegarnia?useSSL=false&serverTimezone=UTC",
                        "root",
                        "root");

        Statement statement = connection.createStatement();

        // SELECT
//        String select = "select * from klient";
//        ResultSet resultSet = statement.executeQuery(select);
//
//        while (resultSet.next()) {
////            int id = resultSet.getInt("idklienta");
////            String name = resultSet.getString("imie");
//
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//
//            System.out.println(id + " " + name);
//        }

        // insert
        String insert = "insert into klient values(null, 'Lukasz', 'Raczka');";
        int insertedRows = statement.executeUpdate(insert);
        System.out.println("Dodano: " + insertedRows);

        // update
//        String update = "update klient set nazwisko = 'Nozka' where idklienta = 5";
//        int updatedRows = statement.executeUpdate(update);
//        System.out.println("Zaktulaziowano: " + updatedRows);

        // delete
//        String delete = "delete from klient where idklienta = 5";
//        int deletedRows = statement.executeUpdate(delete);
//        System.out.println("Usunieto: " + deletedRows);
    }

}

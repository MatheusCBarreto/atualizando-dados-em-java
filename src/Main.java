import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement st = null;

        try {
            connection = DB.getConnection();
            st = connection.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ?"
                    + "WHERE "
                    + "(departmentId = ?)");

            st.setDouble(1, 200.00);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Rows Affected " + rowsAffected);

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
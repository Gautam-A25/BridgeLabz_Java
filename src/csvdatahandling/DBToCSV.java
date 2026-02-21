package csvdatahandling;

import java.sql.*;
import java.io.*;

public class DBToCSV {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "Rixcy@0208");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");

        BufferedWriter bw = new BufferedWriter(new FileWriter("report.csv"));

        bw.write("Employee ID,Name,Department,Salary");
        bw.newLine();

        while (rs.next()) {
            bw.write(rs.getInt("id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getDouble("salary"));
            bw.newLine();
        }

        bw.close();
        con.close();

        System.out.println("Report Generated Successfully!");
    }
}

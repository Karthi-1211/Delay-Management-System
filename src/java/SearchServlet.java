import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/steelplant";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agencyCode = request.getParameter("agencyCode");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Debugging: Print received parameter
        System.out.println("Received agencyCode: " + agencyCode);

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT EFF_DURATION, DELAY_DURN FROM data WHERE AGENCY_CODE = ? LIMIT 60";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, agencyCode);

                    // Debugging: Confirm SQL statement and parameter
                    System.out.println("Executing SQL: " + sql + " with agencyCode: " + agencyCode);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        List<JSONObject> jsonObjects = new ArrayList<>();

                        while (resultSet.next()) {
                            String effDuration = resultSet.getString("EFF_DURATION");
                            int delayDuration = resultSet.getInt("DELAY_DURN");

                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("EFF_DURATION", effDuration);
                            jsonObject.put("DELAY_DURN", delayDuration);

                            jsonObjects.add(jsonObject);
                        }

                        JSONArray jsonArray = new JSONArray(jsonObjects);

                        // Debugging: Print retrieved data
                        System.out.println("JSON Response: " + jsonArray.toString());

                        if (jsonArray.length() == 0) {
                            System.out.println("No data found for the given agency code.");
                            response.setStatus(HttpServletResponse.SC_NO_CONTENT); // No content status
                        } else {
                            out.print(jsonArray.toString());
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database driver not found.");
        }
    }
}

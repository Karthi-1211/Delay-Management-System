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

@WebServlet("/SearchServlet2")
public class SearchServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/steelplant";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Prepare SQL query
                String sql = "SELECT EFF_DURATION, DELAY_DURN FROM data WHERE CONTINUED LIKE ? LIMIT 60";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, "%" + query + "%");

                    // Execute the query
                    try (ResultSet resultSet = statement.executeQuery()) {
                        // Create a list to store JSON objects
                        List<JSONObject> jsonObjects = new ArrayList<>();

                        // Process the result set
                        while (resultSet.next()) {
                            String agencyCode = resultSet.getString("EFF_DURATION");
                            int delayDuration = resultSet.getInt("DELAY_DURN");

                            // Create JSON object for each row
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("EFF_DURATION", agencyCode);
                            jsonObject.put("DELAY_DURN", delayDuration);

                            // Add JSON object to the list
                            jsonObjects.add(jsonObject);
                        }

                        // Convert list to JSON array
                        JSONArray jsonArray = new JSONArray(jsonObjects);

                        // Write JSON array to response
                        out.print(jsonArray.toString());
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
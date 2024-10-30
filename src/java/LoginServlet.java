import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/steelplant", "root", ""); // Adjust DB URL, username, and password

            PreparedStatement ps = con.prepareStatement("SELECT username, email FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                 String user = rs.getString("username");
                 String userEmail = rs.getString("email");
    
    // Redirect to dashboard.jsp with username and userEmail as query parameters
    response.sendRedirect("dashboard.jsp?username=" + URLEncoder.encode(user, "UTF-8") +
                           "&email=" + URLEncoder.encode(userEmail, "UTF-8"));
            } else {
                out.println("Invalid login credentials");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle or log the exception properly
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
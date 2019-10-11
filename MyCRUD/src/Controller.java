import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection conn = db.myConnection();

    public void insertUsers(User user) {

        try {
            DatabaseConnection db = new DatabaseConnection();
            conn = db.myConnection();
            PreparedStatement ps = conn.prepareStatement("insert into users (userName, userLastname, email) values (?,?,?)");
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getEmail());
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Record Inserted Updated");
            } else {
                System.out.println("Record Not Updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> displayAll() {

        List<User> userList = new ArrayList<>();

        try {

            conn = db.myConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserUID(rs.getString(1));
                user.setFname(rs.getString(2));
                user.setLname(rs.getString(3));
                user.setEmail(rs.getString(4));

                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void updatingUserInfo(String col, String userId, String info) {
        try {
            String strUpdateColumn = String.format("UPDATE users set %s = '%s' where UID = %s", col, info, userId);
            PreparedStatement ps = conn.prepareStatement(strUpdateColumn);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Record Inserted Updated");
            } else {
                System.out.println("Record Not Updated");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteInfo(String userId) {
        try {
            DatabaseConnection db = new DatabaseConnection();
            conn = db.myConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE from users where UID = ?");
            ps.setString(1, userId);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Record Inserted Deleted");
            } else {
                System.out.println("Record Not Deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package dao;
import beans.Book;
import beans.User;
import java.sql.*;
import java.util.HashMap;

public class UserDao
{
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    public HashMap<String, User>getAllUser() throws SQLException {
        HashMap <String,User> hm= new HashMap<>();
        String sql = "select * from tb_users";
        conn = ConnectionPool.getConn();
        stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()){
            User user = new User();
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            hm.put(rs.getString("name") + "",user);
        }
        rs.close();
        return hm;
    }
    public void insertUser(User user, String sql)
    {
        try
        {
            conn = ConnectionPool.getConn();
            ps = conn.prepareStatement(sql);
            System.out.println(conn);
            System.out.println(ps);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            int insertCount = ps.executeUpdate();
            if (insertCount == 0)
            {
                System.out.println("插入失败！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (ps != null)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            DataSourceUtil.closeConn();
        }
    }
}

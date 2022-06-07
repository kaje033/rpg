package solarion.solarion.Db;

import org.bukkit.entity.Player;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

import static solarion.solarion.Solarion.User_List;

public class TitleDb2 {
    private Connection connection;

    private String host = "192.168.123.114";
    private int port = 3306;
    private String database = "player";
    private String username = "kaje33";
    private String password = "lyu1004!";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public static HashMap<UUID, user> user_list = new HashMap<UUID, user>();

    public Connection open_Connection() {

        try {
            if (connection != null && !connection.isClosed()) {
                return null;
            }

            synchronized (this) {
                if (connection != null && !connection.isClosed()) {
                    return null;
                }
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true",
                        this.username, this.password);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }


    public user db_PlayerInfo(Player player) {
        UUID player_UUID = player.getUniqueId();
        user u = new user();
        Connection conn = null;
        // 예외 처리 안해주면 서버 터짐
        try {
            conn = this.open_Connection();
            // 사용자의 정보가 있는지 없는지 확인하는 질의문을 생성한다.
            String sql = "select u.u_uuid ,u.u_name,u.title, u.title_color from player_data u where u.u_uuid = ?"; //,u.title,u.agility,u.strength,u.health,u.skill,u.Intellect
            // PreparedStatement에 질의어를 넣고
            pstmt = conn.prepareStatement(sql);
            // 질의어에 ?라고 적혀 있는 값을 정의 해준다.
            pstmt.setString(1, player_UUID.toString());
            // 질의어 실행
            rs = pstmt.executeQuery();
            // 검색된 레코드를 넘겨줌 (필수임 ㅇ)
            rs.next();
            // 해당하는 유저의 정보가 없는 경우
            u.setU_uuid(rs.getString("u_uuid"));
            u.setU_name(rs.getString("u_name"));
            u.set_title(rs.getString("title"));
            u.set_title_color(rs.getString("title_color"));


            User_List.put(rs.getString("u_uuid"), u);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                // 연결 된 DB 연결을 종료 해준다. 안해주면 여러개 쌓이면 DB 검색 안됨 (즉, commit과 같은 용도)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}

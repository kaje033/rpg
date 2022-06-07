package solarion.solarion.Db;

import org.bukkit.entity.Player;
import solarion.solarion.Hash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static solarion.solarion.Solarion.*;

import java.util.HashMap;
import java.util.UUID;

public class StatDb {


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

    public int insertMember(Player player) {
        user u = new user();
        UUID player_UUID = player.getUniqueId();
        // 예외 처리 안해주고 오류 발생하면 서버 터짐
        Connection conn = null;
        try {
            conn = this.open_Connection();
            // 사용자의 정보가 있는지 없는지 확인하는 질의문을 생성한다.
            String sql = "select count(*) from player_data u where u.u_uuid = ?";
            // PreparedStatement에 질의어를 넣고
            pstmt = conn.prepareStatement(sql);
            // 질의어에 ?라고 적혀 있는 값을 정의 해준다.
            pstmt.setString(1, player.getUniqueId().toString());
            // 질의어 실행
            rs = pstmt.executeQuery();
            // 검색된 레코드를 넘겨줌 (필수)
            rs.next();
            // 해당하는 유저의 정보가 없는 경우
            if (rs.getInt(1) == 0) {
                try {
                    // PreparedStatement 초기화 (재사용을 위해)
                    pstmt.clearParameters();
                    sql = "INSERT INTO player_data (u_uuid, agility, strength, health, skill, Intellect) VALUES (?, ?, ?, ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, player.getUniqueId().toString());
                    pstmt.setString(2, (String) Hash.getValue("민첩",player));
                    pstmt.setString(3, (String) Hash.getValue("힘",player));
                    pstmt.setString(4, (String) Hash.getValue("체력",player));
                    pstmt.setString(5, (String) Hash.getValue("재주",player));
                    pstmt.setString(6, (String) Hash.getValue("지능",player));

                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    // PreparedStatement 초기화 (재사용을 위해)
                    pstmt.clearParameters();
                    sql = "UPDATE player_data SET u_uuid = (?), agility = (?), strength = (?), health = (?), skill = (?), Intellect = (?) WHERE u_uuid= ?";
                    pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, player.getUniqueId().toString());
                    pstmt.setInt(2, (int) Hash.getValue("민첩",player));
                    pstmt.setInt(3, (int) Hash.getValue("힘",player));
                    pstmt.setInt(4, (int)Hash.getValue("체력",player));
                    pstmt.setInt(5, (int)Hash.getValue("재주",player));
                    pstmt.setInt(6, (int)Hash.getValue("지능",player));
                    pstmt.setString(7, player.getUniqueId().toString());

                    pstmt.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return 2;
            }
        }
    }

    public user db_PlayerInfo(Player player) {
        UUID player_UUID = player.getUniqueId();
        user u = new user();
        Connection conn = null;
        // 예외 처리 안해주면 서버 터짐
        try {
            conn = this.open_Connection();
            // 사용자의 정보가 있는지 없는지 확인하는 질의문을 생성한다.
            String sql = "select u.u_uuid, u.agility, u.strength, u.health, u.skill, u.Intellect from player_data u where u.u_uuid = ?";
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
            u.set_agility(rs.getInt("agility"));
            u.set_strength(rs.getInt("strength"));
            u.set_health(rs.getInt("health"));
            u.set_skill(rs.getInt("skill"));
            u.set_Intellect(rs.getInt("Intellect"));

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

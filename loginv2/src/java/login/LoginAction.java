/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abuoma Offia
 */
public class LoginAction extends ActionSupport {

    private Login loginYsg;
    private String dbResult;

    @Override
    public String execute() {
        System.out.println("form username: " + loginYsg.getUsername());
        System.out.println("form password: " + loginYsg.getPass());

        String ret = ERROR;
        Connection conn = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/ysgv2?serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "admin");
            String sql = "SELECT * FROM users WHERE";
            sql += " username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loginYsg.getUsername());
            ps.setString(2, loginYsg.getPass());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // System.out.println(rs);
                this.dbResult = rs.getString(1);               
                ret = SUCCESS;
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            ret = ERROR;
        } catch (SQLException e) {
            System.out.println(e);
            ret = ERROR;
        }
        System.out.println(ret);
        return ret;
    }

    public Login getLoginYsg() {
        return loginYsg;
    }

    public void setLoginYsg(Login loginYsg) {
        this.loginYsg = loginYsg;
    }
}

/**
 * @Override public String execute() { System.out.println(username); if
 * (username.equals(pass)) { return "SUCCESS"; } else { return "ERROR"; } }
 *
 * public String login() { this.username = username;
 * System.out.println(username); return "SUCCESS";
 *
 * String ret = ERROR; Connection conn = null;
 *
 * try { String URL = "jdbc:mysql://localhost/ysgv2";
 * Class.forName("com.mysql.jdbc.Driver"); conn =
 * DriverManager.getConnection(URL, "sen301", "sen301"); String sql = "SELECT
 * `username`, `password` FROM `users` WHERE"; sql += " user = ? AND password =
 * ?"; PreparedStatement ps = conn.prepareStatement(sql); ps.setString(1,
 * username); ps.setString(2, pass); ResultSet rs = ps.executeQuery();
 *
 * while (rs.next()) { this.dbResult = rs.getString(1); ret = SUCCESS; } } catch
 * (Exception e) { ret = ERROR; } finally { if (conn != null) { try {
 * conn.close(); } catch (Exception e) { } } } System.out.println(ret); return
 * ret;
 *
 * }
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizDAO;


import QuizDButil.DBconnection;
import QuizPOJO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rita
 */
public class UserDAO {
    public static boolean validateUser(User user)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where USERID=? and PASSWORD=?and userType=? ");
        ps.setString(1,user.getUserName());
        ps.setString(2,user.getPassWord());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            return true;
        }
        else
            return false;
    }  
    
    public static boolean addUser(User user)throws SQLException
    {   
        boolean status=true;
        String qry= "select * from users where USERID=?";
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserName());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            status=false;
        else
           {
            qry="insert into users values(?,?,?)";
            ps=conn.prepareStatement(qry);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getUserType());
            ps.executeUpdate();
        }
        return status;
    }  
    
    public static boolean changePassword(String username,String password)throws SQLException
    {
    String qry ="update users set password=? where userid=?";
    boolean status = true;
    Connection conn=DBconnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,password);
    ps.setString(2,username);
    int ans=ps.executeUpdate();
    if(ans==0)
        status =  false;
    return status;
    }
    }



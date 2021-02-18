/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizDAO;

import QuizDButil.DBconnection;
import QuizPOJO.Exam;
import QuizPOJO.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rita
 */
public class ExamDAO {
  public static String getExamId()throws SQLException
{
String qry = "Select count(*) as totalrows from Exam";
int rowCount = 0;
        Connection conn=DBconnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        if(rs.next())
            rowCount = rs.getInt(1);
        String newId="EX-"+(rowCount+1);
        return newId;
}  
  
  public static void addExam(Exam newExam)throws SQLException
  {
    String qry = "insert into Exam values(?,?,?)";
          Connection conn=DBconnection.getConnection();
          PreparedStatement ps = conn.prepareStatement(qry);
          ps.setString(1,newExam.getExamId());
          ps.setString(2,newExam.getLanguage());
          ps.setInt(3,newExam.getTotalQuestion());
          ps.executeUpdate();
          
  }

    @Override
    public String toString() {
        return "ExamDAO{" + '}';
    }
    
    
  public static ArrayList <Question> getQuestionsByExamId(String examId)throws SQLException
  {
        String qry="select * from questions  where examid=? order by qno";
        ArrayList<Question> questionList=new ArrayList<>();
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,examId);
        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {      int qno=rs.getInt(2);
               String question=rs.getString(9);
               String option1=rs.getString(4);
               String option2=rs.getString(5);
               String option3=rs.getString(6);
               String option4=rs.getString(7);
               String correctAnswer=rs.getString(8);
               String language=rs.getString(3);
               Question obj=new Question(examId,language,qno,option1,option2,option3,option4,correctAnswer,question);
               questionList.add(obj);
        }
        return questionList;
  }
  
  public static int getQuestionCountByExam(String examId)throws SQLException
  {
  String qry = "select total_question from Exam where examId=?";
  Connection conn=DBconnection.getConnection();
  PreparedStatement ps = conn.prepareStatement(qry);
  ps.setString(1,examId);
  ResultSet rs = ps.executeQuery();
  rs.next();
  int rowCount = rs.getInt(1);
  return rowCount;
  }
  
  public static ArrayList<String> getExamIdBySubject(String subject)throws SQLException{
       String qry="Select examid from Exam where language=?";
       Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1,subject);
       ResultSet rs=ps.executeQuery();
       ArrayList<String> examList=new ArrayList<>();
       while(rs.next()){
               examList.add(rs.getString(1));
           }
       return examList;
    }

  
  
}

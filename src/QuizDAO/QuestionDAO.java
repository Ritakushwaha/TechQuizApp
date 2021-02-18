/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizDAO;

import QuizDButil.DBconnection;
import QuizGUI.EditPaperFrame;
import QuizPOJO.Question;
import QuizPOJO.QuestionStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rita
 */
public class QuestionDAO {
    public static void addQuestions(QuestionStore qstore)throws SQLException
    {
    String qry="insert into questions values(?,?,?,?,?,?,?,?,?)";
    ArrayList<Question> questionList=qstore.getAllQuestion();
    Connection conn = DBconnection.getConnection();
    PreparedStatement ps = conn.prepareStatement(qry);
    for(Question obj:questionList)
    {/*
        System.out.println("QUESTION "+obj.getQuestion());*/
    ps.setString(1,obj.getExamId());
    ps.setInt(2,obj.getQno());
    ps.setString(3,obj.getQuestion());
    ps.setString(4,obj.getAnswer1());
    ps.setString(5,obj.getAnswer2());
    ps.setString(6,obj.getAnswer3());
    ps.setString(7,obj.getAnswer4());
    ps.setString(8,obj.getCorrectAnswer());
    ps.setString(9,obj.getLanguage());
    ps.executeUpdate();
    }
    }
    
 public static ArrayList<Question> getQuestionsByExamId(String exmId)throws SQLException
    {
    String qry="select * from questions where examid =? order by qno";
    ArrayList<Question> questionList=new ArrayList<>();
    Connection conn = DBconnection.getConnection();
    PreparedStatement ps = conn.prepareStatement(qry);
    ps.setString(1,exmId);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    String examId=rs.getString(1);
    String language=rs.getString(9);
    int qno= rs.getInt(2);
    String quest = rs.getString(3);
    String option1=rs.getString(4);
    String option2=rs.getString(5);
    String option3=rs.getString(6);
    String option4=rs.getString(7);
    String correctAnswer=rs.getString(8);
    
    Question obj =new Question(examId,language,qno,quest,option1,option2,option3,option4,correctAnswer);
    questionList.add(obj);
    }
    System.out.println(questionList.size());
    return questionList;
}

    public static void updateQuestions(QuestionStore qstore)throws SQLException
    {
        String qry= "update questions set question=?,answer1=?,answer2=?,answer3=?answer4=?,corrrect_answer=? where examid=?and qno=? and language=?";
        ArrayList<Question>questionList =qstore.getAllQuestion();
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        for(Question obj:questionList){
        ps.setString(1,obj.getQuestion());
        ps.setString(2,obj.getAnswer1());
        ps.setString(3,obj.getAnswer2());
        ps.setString(4,obj.getAnswer3());
        ps.setString(5,obj.getAnswer4());
        ps.setString(6,obj.getCorrectAnswer());
        ps.setString(7,obj.getExamId());
        ps.setInt(8,obj.getQno());
        ps.setString(9,obj.getLanguage());
        }
    }    
}

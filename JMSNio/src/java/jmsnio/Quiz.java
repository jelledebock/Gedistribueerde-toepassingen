/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author vongenae
 */
public class Quiz {

    List<Question> questions;
    Map<Integer,Question> allQuestions;
    Random r;

    public Quiz() throws Exception {
        questions = new ArrayList<>();
        allQuestions = new HashMap<>();
        r = new Random();
       try {
            RowSetFactory myRowSetFactory = RowSetProvider.newFactory();
            CachedRowSet quizRS = myRowSetFactory.createCachedRowSet();

            quizRS.setDataSourceName("jdbc/quiz");

            quizRS.setCommand("select id, question, answer from quiz");
            quizRS.execute();
            while (quizRS.next()) {
                Question q = new Question(quizRS.getInt(1), quizRS.getString(2), quizRS.getString(3));
                questions.add(q);
                allQuestions.put(q.getId(), q);
            }
            Logger.getLogger(Quiz.class.getName()).log(Level.INFO, "aantal vragen: {0}", questions.size());
       } catch (SQLException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Question getQuestion() {
        Question q = null;
        if (questions.size() > 0) {
            int index = r.nextInt(questions.size());
            q = questions.remove(index);
        }
        return q;
    }

    public boolean isCorrect(int id, String answer) {
        Question q = allQuestions.get(id);
        return q.isCorrect(answer);
    }
}

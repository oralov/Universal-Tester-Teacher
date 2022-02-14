package Beans;

import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionList = new ArrayList<Question>();
    private String              testName;
    private int                 id;

    public Test() {}

    public Test(String testName, ArrayList<Question> questionList) {
        this.testName     = testName;
        this.questionList = questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

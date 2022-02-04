package Beans;

import java.util.ArrayList;

public class Test {

	private String testName;
	private ArrayList<Question> questionList = new ArrayList<Question>();
	private int id;
	
	
	public Test(String testName, ArrayList<Question> questionList) {
		this.testName = testName;
		this.questionList = questionList;
	}
	public Test() {
		
	}
	
	
	
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

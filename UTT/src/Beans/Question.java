package Beans;

import java.util.ArrayList;

public class Question {
	
	private String questionName;
	private ArrayList<String> wrongAnswers = new ArrayList<String>();
	private ArrayList<String> correctAnswer = new ArrayList<String>();
	private int id;

	public Question() {
		
	}
	
	public Question(int id, String text) {
		this.id = id;
		questionName = text;
	}
	
	
	
	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public ArrayList<String> getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(String answer) {
		this.wrongAnswers.add(answer);
	}

	public ArrayList<String> getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String answer) {
		this.correctAnswer.add(answer);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

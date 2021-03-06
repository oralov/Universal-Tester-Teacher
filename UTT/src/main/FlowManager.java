package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Beans.Question;
import Beans.Test;
import Database.DBManager;
import UI.ActivationPanel;
import UI.AddQuestions;
import UI.CreateNewTest;
import UI.CreateTest;
import UI.DetailedResults;
import UI.EditQuestion;
import UI.EditTest;
import UI.FinishTest;
import UI.FinishWarning;
import UI.InTest;
import UI.MainMenu;
import UI.MainWindow;
import UI.Results;
import UI.ResultsSearch;
import UI.SetTest;
import UI.Testing;

public class FlowManager {
	DBManager dbManager = new DBManager();
	
	public MainWindow window = new MainWindow();
	ActivationPanel activation = new ActivationPanel();
	MainMenu menu = new MainMenu();
	CreateTest createTest = new CreateTest();
	public SetTest setTest = new SetTest();
	public InTest inTest = new InTest();
	FinishTest finishTest = new FinishTest();
	Testing testing = new Testing();
	Results results = new Results();
	ResultsSearch resultsSearch = new ResultsSearch();
	CreateNewTest createNewTest = new CreateNewTest();
	DetailedResults detailedResults = new DetailedResults();
	AddQuestions addQuestions = new AddQuestions();
	EditTest editTest = new EditTest();
	EditQuestion editQuestion = new EditQuestion();
	private JButton editBtn;
	private JButton testingBtn;
	public int questionNum = 0;
	public int deleteBtnId = 0;
	String testTitle;
	String questionTitle;
	boolean flag = true;
	boolean flag1 = false;
	
	Test test = new Test();
	Question question;
	ArrayList<Question> questions;
	ArrayList<String> wrongAnswers = new ArrayList<String>();
	ArrayList<String> correctAnswers = new ArrayList<String>(); 
	JButton button;
	FinishWarning finishWarning = new FinishWarning();
	Timer timer;
	
	
	
public void run() {
	
	//Initialize the window
		window.add(activation);
		window.setVisible(true);

		listener(activation.getActivateBtn(), activation, menu);
		listener(menu.getCreateTest(), menu, createTest);
		listener(inTest.getExitTest(), inTest, finishTest);
		listener(createTest.getBackBtn(), createTest, menu);
		listener(createTest.getAddBtn(), createTest, createNewTest);
		listener(createNewTest.getBackBtn(), createNewTest, createTest);
		listener(createNewTest.getNextBtn(), createNewTest, addQuestions);
		listener(addQuestions.getSaveTest(), addQuestions, createTest);
		listener(editTest.getBackBtn(), editTest, createTest);	
		
		listener(editQuestion.getBackBtn(), editQuestion, editTest);
		listener(menu.getTest(), menu, testing);
		listener(testing.getBackBtn(), testing, menu);
		listener(setTest.getBackBtn(), setTest, testing);
		listener(setTest.getStartTest(), setTest, inTest);
		listener(finishTest.getExitTest(), finishTest, menu);
		listener(menu.getResults(), menu, resultsSearch);
		listener(resultsSearch.getBackBtn(), resultsSearch, menu);
		listener(resultsSearch.getSearch(), resultsSearch, results);
		listener(results.getBackBtn(), results, resultsSearch);
		listener(addQuestions.getNextQuestion(), addQuestions, addQuestions);
		listener(addQuestions.getBack(), addQuestions, createNewTest);
		listener(finishWarning.getFinish(), finishTest, finishTest);
		listener(finishWarning.getBack(), inTest, inTest);
		
		
		
		
		
}



public void addPanel(JPanel panel, JPanel panelToAdd) throws SQLException {
	if(panelToAdd instanceof CreateTest || panelToAdd instanceof Testing) {
			retrieveData("Select * from Test", "name", panelToAdd, panel);
	}
	
	if(panelToAdd instanceof EditTest) {
		dbManager.setConnection();
		retrieveData("SELECT * FROM questions where fk_id = (select id from Test where name ='" + testTitle 
				+"')" 
				, "question", panelToAdd, panel);
		dbManager.closeConnection();
	}
	
	
	} 


	
	public void addPanelToPanel(JPanel panel, JPanel panelToAdd, String title) {
		
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setBounds(0, 0, 760,50);
		pane.setBackground(new Color(147, 181, 184));
		panel.add(pane);
		
		if(panelToAdd instanceof CreateTest || panelToAdd instanceof EditTest) {
		editBtn = new JButton();
		editBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\edit.png"));
		editBtn.setBounds(655, 2, 50,45);
		pane.add(editBtn);
		
		
		JButton delete = new JButton();
		
		delete.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\delete.png"));
		delete.setBounds(710, 2, 50,45);
		pane.add(delete);
		
		JLabel testName = new JLabel();
		testName.setBounds(5, 13, 640, 25);
		testName.setFont(new Font(Font.SERIF, Font.PLAIN, 18 ));
		testName.setText(title);
		pane.add(testName);
		
		
		editBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		       
		      
		       editTest.getPanel_3().removeAll();
		       if(panelToAdd instanceof CreateTest) {
		    	   testTitle = title;
		       try {
				addPanel(editTest.getPanel_3(), editTest);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		       createTest.setVisible(false);
		       window.add(editTest);
		       editTest.setVisible(true);
		       
		       }
		       if(panelToAdd instanceof EditTest) {
		    	   questionTitle = title;
		    	   try {
					populateQuestionFromDatabase(questionTitle);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	   System.out.println("CreateTest");
		    	   editTest.setVisible(false);
		    	   window.add(editQuestion);
		    	   editQuestion.setVisible(true);
		    	   
		       }
		    }
		});
		
		
		delete.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    dbManager.setConnection();
		    testTitle = title;
		    try {
		    	
		    	if(panelToAdd instanceof CreateTest) {
		    	dbManager.executeUpdate("PRAGMA foreign_keys = ON");
		    	
				dbManager.executeUpdate("DELETE FROM Test where name='" + testTitle +"'");
				
				createTest.getPanel_3().removeAll();
			    addPanel(createTest.getPanel_3(), createTest);
			    createTest.revalidate();
			    createTest.repaint();
		    	}
		    	
		       if(panelToAdd instanceof EditTest) {
		    	  System.out.println(testTitle);
		    	dbManager.executeUpdate("PRAGMA foreign_keys = ON");
		    	dbManager.executeUpdate("DELETE FROM questions where question='" + testTitle +"'");
		    	
		    	editTest.getPanel_3().remove(delete.getParent().getParent());;
		    	editTest.validate();
		    	editTest.repaint();	
		    	
		    	 dbManager.closeConnection();
		       }
				    
		    	
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
		    }
		    
		    });
		
		}
		
		
		
		
		if(panelToAdd instanceof Testing) {
			testingBtn = new JButton();
			testingBtn.setBounds(0, 0, 760,50);
			testingBtn.setBackground(new Color(147, 181, 184));
			testingBtn.setFont(new Font(Font.SERIF, Font.PLAIN,  18)) ;
			testingBtn.setText(title);
			pane.add(testingBtn);
			
			if(panelToAdd instanceof Testing) {
				
				listener(testingBtn, testing, setTest);	
			}
			
			 testingBtn.addActionListener(new ActionListener()
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
			setTest.getTestLabel().setText("????????: " + title);
			testTitle = title;
						}
					 });
		}
		

		
		
	}
	
	public void listener(JButton btn, JPanel prevPanel, JPanel nextPanel) {
		   btn.addActionListener(new ActionListener()
			 {
				/**
				 *
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(nextPanel instanceof CreateTest && prevPanel instanceof MainMenu ) {
						dbManager.setConnection();
						createTest.getPanel_3().removeAll();
							try {
								addPanel(createTest.getPanel_3(), createTest);
								
								prevPanel.setVisible(false); 
								window.add(nextPanel);
								nextPanel.setVisible(true);	
								dbManager.closeConnection();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							
					}
					else if(prevPanel instanceof EditQuestion) {
						System.out.println();
					     editTest.getPanel_3().removeAll();
						try {
							dbManager.setConnection();
							addPanel(editTest.getPanel_3(), editTest);
							
							
							
							prevPanel.setVisible(false); 
							window.add(nextPanel);
							nextPanel.setVisible(true);	
							dbManager.closeConnection();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					}
					
					else if(prevPanel instanceof MainMenu && nextPanel instanceof Testing) {
						testing.getPanel_3().removeAll();
						try {
							dbManager.setConnection();
							addPanel(testing.getPanel_3(), testing);
							
							
							prevPanel.setVisible(false); 
							window.add(nextPanel);
							nextPanel.setVisible(true);	
							dbManager.closeConnection();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
					}
					
					else if(prevPanel instanceof CreateTest && nextPanel instanceof CreateNewTest) {
						createNewTest.getTestName().setText("");
						createNewTest.getError().setText("");
						questions = new ArrayList<Question>();
						
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
					
						
						
					}
					
					else if(prevPanel instanceof CreateNewTest && nextPanel instanceof AddQuestions) {
						
						if(createNewTest.getTestName().getText().equals("")) {
							
							createNewTest.getError().setText("???????????????? ?????????? ???? ?????????? ???????? ????????????!");
						}
						else if(!createNewTest.getTestName().equals(null)) {
							
							createNewTest.getError().setText("");
							
						test.setTestName(createNewTest.getTestName().getText());
						
							prevPanel.setVisible(false); 
							window.add(nextPanel);
							nextPanel.setVisible(true);	
						if(!flag) {
							questionNum = 1;
						}
						}
					}
					
					
					else if(nextPanel instanceof AddQuestions && prevPanel instanceof AddQuestions) {
						
						
						
						if(addQuestions.getQuestion().getText().equals("")) {
							addQuestions.getError().setText("???????????? ???? ?????????? ???????? ????????????!");	
						}
						else if(addQuestions.getAnswer1().getText().equals("")) {
							addQuestions.getError().setText("?????????????? ?? ???? ?????????? ???????? ????????????!");
						}
						else if(addQuestions.getAnswer2().getText().equals("")) {
							addQuestions.getError().setText("?????????????? ?? ???? ?????????? ???????? ????????????!");
						}
						else if(addQuestions.getAsnwer3().getText().equals("")) {
							addQuestions.getError().setText("?????????????? ?? ???? ?????????? ???????? ????????????!");
						}
						else if(addQuestions.getAnswer4().getText().equals("")) {
							addQuestions.getError().setText("?????????????? ?? ???? ?????????? ???????? ????????????!");
						}
						else if(addQuestions.getAnswer5().getText().equals("")) {
							addQuestions.getError().setText("?????????????? ?? ???? ?????????? ???????? ????????????!");
						}
						else if(!addQuestions.getA1().isSelected() && !addQuestions.getA2().isSelected() &&
								!addQuestions.getA3().isSelected() && !addQuestions.getA4().isSelected() &&
						!addQuestions.getA5().isSelected()) {
							addQuestions.getError().setText("?????????? ????????-???? ???????? ???????????????????? ??????????!");
						}
						else {
							addQuestions.getError().setText("");
					if(questions.size() == questionNum) {
						if(flag) {
						question = new Question();
						question.setId(questionNum);
						question.setQuestionName(addQuestions.getQuestion().getText());
						
						if(addQuestions.getA1().isSelected()) {
						question.setCorrectAnswer(addQuestions.getAnswer1().getText());
						}
						else {
						question.setWrongAnswers(addQuestions.getAnswer1().getText());
						}
						if(addQuestions.getA2().isSelected()) {
							question.setCorrectAnswer(addQuestions.getAnswer2().getText());
						}
						else {
						question.setWrongAnswers(addQuestions.getAnswer2().getText());
						}
						if(addQuestions.getA3().isSelected()) {
						question.setCorrectAnswer(addQuestions.getAsnwer3().getText());
						}
						else {
						question.setWrongAnswers(addQuestions.getAsnwer3().getText());
						}
						if(addQuestions.getA4().isSelected()) {
						question.setCorrectAnswer(addQuestions.getAnswer4().getText());
						}
						else {
						question.setWrongAnswers(addQuestions.getAnswer4().getText());
						}
						if(addQuestions.getA5().isSelected()) {
						question.setCorrectAnswer(addQuestions.getAnswer5().getText());
						}
						else {
						question.setWrongAnswers(addQuestions.getAnswer5().getText());
						}
						
						questions.add(question);
						clearFields();
						addQuestions.getA1().setSelected(false);
						addQuestions.getA2().setSelected(false);
						addQuestions.getA3().setSelected(false);
						addQuestions.getA4().setSelected(false);
						addQuestions.getA5().setSelected(false);
						questionNum++;
						
						
						}
						else {
						clearFields();	
						flag = true;
						
						
						}
					}
					else {
						populateFields(questionNum);
						questionNum++;
						
						
						
					}
						}
					 }
					
					else if(questionNum >= 1 && nextPanel instanceof CreateNewTest) {
						flag = false;
						questionNum--;
						populateFields(questionNum);
					}
					
					else if(prevPanel instanceof AddQuestions && nextPanel instanceof CreateTest) {
						
						createTest.getPanel_3().removeAll();
						try {
							dbManager.setConnection();
							dbManager.executeUpdate("insert into Test(Name, id) values('" 
									+ createNewTest.getTestName().getText() + "',"+ null + ")");
							
							for(Question q : questions) {
								dbManager.executeUpdate("insert into questions(question, id, fk_id) values('"
								+ q.getQuestionName() + "'," + null + 
								", (SELECT id from Test WHERE name='" + test.getTestName() +"'))");
								for(String answer : q.getCorrectAnswer()) {
									dbManager.executeUpdate("insert into correctAnswers(answer, id, fk_id) values('"
									+ answer + "'," + null + 
									", (SELECT id from questions WHERE question='" + q.getQuestionName() +"'))");
								}
								
								for(String answer : q.getWrongAnswers()) {
									dbManager.executeUpdate("insert into wrongAnswers(answer, id, fk_id) values('"
									+ answer + "'," + null + 
									", (SELECT id from questions WHERE question='" + q.getQuestionName() +"'))");
								}
					         
								
							}
							addPanel(createTest.getPanel_3(), createTest);
							dbManager.closeConnection();
							questions.clear();
							questionNum = 0;
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Worked");
						
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
					}
					
					else if(prevPanel instanceof SetTest && nextPanel instanceof InTest ) {
						
						
						ResultSet count;
						int q = 0;
						try {
							dbManager.setConnection();
							count = dbManager.executeQuery("SELECT count(*) as count from questions where fk_id = (SELECT id from Test where name ='" + testTitle + "')");
							System.out.println(testTitle);
							q = count.getInt("count");
							dbManager.closeConnection();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
						timer = new Timer();
						timer.schedule(new TimerTask() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								if(inTest.getTimer().getText().equals("00:00")) {
									System.out.println("Canceling timer");
									timer.cancel();
									inTest.getTimer1().cancel();
									inTest.setVisible(false); 
									window.add(finishTest);
									finishTest.setVisible(true);	
									finishWarning.setVisible(false);
									try {
										finishTest.setTestName(testTitle);
										
										finishTest.addResults(inTest.getQuestions(), Integer.valueOf(inTest.getQuestionAmount()),
												inTest.getRgArray(), inTest.getBoxArrayArray());
								}
									
									catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
							
						}, 0, 1000);
						
						
						if(setTest.getName().equals("")) {
							setTest.getError().setText("?????? ???? ?????????? ???????? ????????????!");
						}
						else if(setTest.getAmountOfQuestions().getText().equals("")) {
							setTest.getError().setText("?????????????????????? ???????????????? ?? ?????????? ???? ?????????? ???????? ????????????!");
						}
						else if(setTest.getAmountOfQuestions().getText().equals("0")) {
							setTest.getError().setText("?????????????????????? ???????????????? ?? ????c???? ???? ?????????? ???????? 0");
						}
						else if(setTest.getTime().getText().equals("")) {
							
							setTest.getError().setText("?????????? ???? ???????? ???????????? ???? ?????????? ???????? ????????????");
						}
                       else if(setTest.getTime().getText().equals("0")) {
							
							setTest.getError().setText("?????????? ???? ???????? ???????????? ???? ?????????? ???????? 0");
						}
                       else if(Integer.parseInt(setTest.getAmountOfQuestions().getText()) > q) {
                    	   
                    	   setTest.getError().setText("?? ?????????? ?????? " + setTest.getAmountOfQuestions().getText() + " ????????????????, ?????????????? ?????????????? ?????????????????????? ????????????????." );
                    	   
                    	   
                       }
						
						else {
						inTest.getPanel_3().removeAll();
						setTest.setVisible(false);
						window.add(inTest);
						try {
							
							inTest.setQuestionAmount(Integer.valueOf(setTest.getAmountOfQuestions().getText()));
							inTest.timer(inTest.getTimer(), Integer.valueOf(setTest.getTime().getText()) * 
									Integer.valueOf(setTest.getAmountOfQuestions().getText()));
							inTest.addData(inTest.getPanel_3(), testTitle, questionNum);
							inTest.getTestTitle().setText(testTitle);
							finishTest.setName(setTest.getName());
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						setTest.clear();
						
						inTest.setVisible(true);
						
						
						}
					}
					else if(prevPanel instanceof Testing && nextPanel instanceof SetTest) {
						setTest.getError().setText("");
						
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
					}
					else if(prevPanel instanceof InTest && nextPanel instanceof FinishTest ) {
					
						timer.cancel();
						inTest.getTimer1().cancel();
						ArrayList<JRadioButton> btns = new ArrayList<JRadioButton>();
						ArrayList<JCheckBox> btns1 = new ArrayList<JCheckBox>();
						ArrayList<String> unansweredNumbers = new ArrayList<String>();
						Component[] comp = inTest.getPanel_3().getComponents();	
						
						for(Component c: comp) {
							if(c instanceof JPanel) {
								Component[] children = ((JPanel)c).getComponents();
								for(Component field: children) {
									if(field instanceof JRadioButton) {
									 
									 btns.add((JRadioButton)field);
									
									}
									if(field instanceof JCheckBox) {
										btns1.add((JCheckBox)field);
									}
								}
								if(!btns.isEmpty() &&  !btns.get(0).isSelected() && !btns.get(1).isSelected() 
										 && !btns.get(2).isSelected() && !btns.get(3).isSelected()
										 && !btns.get(4).isSelected()) {
									/*
									
									*/
									
									unansweredNumbers.add(btns.get(0).getParent().getName());
									
								 }
								else if(!btns1.isEmpty() && !btns1.get(0).isSelected() && !btns1.get(1).isSelected() 
										 && !btns1.get(2).isSelected() && !btns1.get(3).isSelected()
										 && !btns1.get(4).isSelected()) {
									unansweredNumbers.add(btns1.get(0).getParent().getName());
								}
								
								btns.clear();
								btns1.clear();
								
							}
							
						}
						
						
						if(!unansweredNumbers.isEmpty()) {
							String string = "???? ???? ???????????????? ???? ??????????????: ";
							for(int i = 0; i < unansweredNumbers.size(); i++) {
								if(i < unansweredNumbers.size()- 1) {
								string = string + unansweredNumbers.get(i) + ", ";
								}
								else {
									string = string + unansweredNumbers.get(i) + ".";
								}
							}
							
							finishWarning.setVisible(true);
							finishWarning.getEditableLbl().setText(string);
							flag1 = true;
						}
						
						if (!flag1) {
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
						finishWarning.setVisible(false);
						try {
							finishTest.setTestName(testTitle);
							
							finishTest.addResults(inTest.getQuestions(), Integer.valueOf(inTest.getQuestionAmount()),
									inTest.getRgArray(), inTest.getBoxArrayArray());
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}	
					}
					
					else if(prevPanel instanceof FinishTest && nextPanel instanceof FinishTest) {
						inTest.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
						finishWarning.setVisible(false);
						try {
							finishTest.setTestName(testTitle);
							
							finishTest.addResults(inTest.getQuestions(), Integer.valueOf(inTest.getQuestionAmount()),
									inTest.getRgArray(), inTest.getBoxArrayArray());
					}
						
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					else if(inTest.getTimer().getText().equals("00:00")) {
						inTest.getTimer1().cancel();
						inTest.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
						finishWarning.setVisible(false);
						try {
							finishTest.setTestName(testTitle);
							
							finishTest.addResults(inTest.getQuestions(), Integer.valueOf(inTest.getQuestionAmount()),
									inTest.getRgArray(), inTest.getBoxArrayArray());
					}
						
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					else if(prevPanel instanceof FinishTest && nextPanel instanceof MainMenu) {
						try {
							dbManager.setConnection();
							finishTest.saveResults(dbManager);
							inTest.getQuestions().clear();
							dbManager.closeConnection();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
					}
					else if(prevPanel instanceof ResultsSearch && nextPanel instanceof Results) {
						results.getPanel_3().removeAll();
						prevPanel.setVisible(false); 
						window.add(nextPanel);
						nextPanel.setVisible(true);	
						results.setName(resultsSearch.getNameOfUser().getText());
						results.setTestTitle(resultsSearch.getNameOfTest().getText());
						results.setDateFrom(resultsSearch.getFrom().getText());
						results.setDateTo(resultsSearch.getTo().getText());
						try {
							detailedResults.getPanel_3().removeAll();
							results.addData(window, results, detailedResults);
							
						} catch (SQLException e1 ) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						catch(ParseException p1) {
							p1.printStackTrace();
						}
					}
					else if(prevPanel instanceof InTest && nextPanel  instanceof InTest) {
						flag1 = false;
						finishWarning.setVisible(false);
						
					}
					
					
					else {
							prevPanel.setVisible(false); 
							window.add(nextPanel);
							nextPanel.setVisible(true);	
								
					}
					
			 } 
			 });
	   }
	
	public void clearFields() {
		if(!addQuestions.getQuestion().getText().equals("")){
		addQuestions.getAnswer1().setText("");
		addQuestions.getAnswer2().setText("");
		addQuestions.getAsnwer3().setText("");
		addQuestions.getAnswer4().setText("");
		addQuestions.getAnswer5().setText("");
		addQuestions.getQuestion().setText("");
	}
	}
	
	public void populateFields(int questionNumber) throws ArrayIndexOutOfBoundsException {
		
	addQuestions.getQuestion().setText(questions.get(questionNumber).getQuestionName());
	addQuestions.getAnswer1().setText(questions.get(questionNumber).getCorrectAnswer().get(0));
	addQuestions.getAnswer2().setText(questions.get(questionNumber).getCorrectAnswer().get(1));
	addQuestions.getAsnwer3().setText(questions.get(questionNumber).getCorrectAnswer().get(2));
	addQuestions.getAnswer4().setText(questions.get(questionNumber).getCorrectAnswer().get(3));
	addQuestions.getAnswer5().setText(questions.get(questionNumber).getWrongAnswers().get(0));
	
	}
	
	public void populateQuestionFromDatabase(String question) throws SQLException {
		dbManager.setConnection();
		String questionName = "";
		
		ArrayList<String> answers = new ArrayList<String>();
		ResultSet rs = dbManager.executeQuery("SELECT * from questions where question = '" + question + "'");
		int id = rs.getInt("id");
		while(rs.next()) {
			questionName = rs.getString("question");
			editQuestion.setQuestionText(questionName);
		}
		rs = dbManager.executeQuery("Select * from correctAnswers where fk_id =" + id );
		while(rs.next()) {
			answers.add(rs.getString("answer"));
			
		}
		rs = dbManager.executeQuery("Select * from wrongAnswers where fk_id =" + id );
		while(rs.next()) {
			answers.add(rs.getString("answer"));
		}
		
		editQuestion.setAnswerText1(answers.get(0));
		editQuestion.setAnswerText2(answers.get(1));
		editQuestion.setAnswerText3(answers.get(2));
		editQuestion.setAnswerText4(answers.get(3));
		editQuestion.setAnswerText5(answers.get(4));
		
		editQuestion.getQuestion().setText(questionName);
		editQuestion.getAnswer1().setText(answers.get(0));
		editQuestion.getAnswer2().setText(answers.get(1));
		editQuestion.getAsnwer3().setText(answers.get(2));
		editQuestion.getAnswer4().setText(answers.get(3));
		editQuestion.getAnswer5().setText(answers.get(4));
		dbManager.closeConnection();
	}
	
	public void retrieveData(String query, String field, JPanel panelToAdd, JPanel panel) throws SQLException {
		ResultSet rs = dbManager.executeQuery(query);
		while(rs.next()) {
		JPanel pane = new JPanel();
		pane.setLayout(null);
		addPanelToPanel(pane, panelToAdd, rs.getString(field));
		pane.setPreferredSize(new Dimension(760, 50));
		pane.setBackground(new Color(147, 181, 184));
		panel.add(pane);
		}
	}
	
	
	
	public MainWindow getWindow() {
		return window;
	}
	public void setWindow(MainWindow window) {
		this.window = window;
	}
	
	public DBManager getDbManager() {
		return dbManager;
	}

	public void setDbManager(DBManager dbManager) {
		this.dbManager = dbManager;
	}
	
}

package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Beans.CountDown;
import Beans.Question;

import Database.DBManager;

import main.FlowManager;

import net.miginfocom.swing.MigLayout;

public class InTest extends JPanel {
    String                 testName       = "";
    private int            questionAmount = 0;
    EditTest               editTest       = new EditTest();
    DBManager              dbManager      = new DBManager();
    ArrayList<ButtonGroup> rgArray        = new ArrayList<ButtonGroup>();
    ArrayList<Question>    questions      = new ArrayList<Question>();
    SetTest                setTest        = new SetTest();
    JPanel                 panel_3;
    private JLabel         timer;
    private JLabel         testTitle;
    private JButton        exitTest;
    ResultSet              rs;
    ButtonGroup            rg;
    ArrayList<JCheckBox> boxArray; 
    ArrayList<ArrayList> boxArrayArray = new ArrayList<ArrayList>();
	JRadioButton           answers;
    JCheckBox boxAnswers;
    Question               q;
    FinishTest             finishTest;
    public static Timer timer1;
    JPanel space = new JPanel();
    

	/**
     * Create the panel.
     *
     */
    public InTest() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);
        testTitle = new JLabel("Тест о лошади Чингиз хана");
        testTitle.setBounds(260, 40, 334, 27);
        testTitle.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(testTitle);

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 74, 785, 500);
        scrollPane.setBorder(null);
        add(scrollPane);
        panel_3 = new JPanel();
        panel_3.setBackground(new Color(193, 216, 219));
        scrollPane.setViewportView(panel_3);
        panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
        timer = new JLabel("");
        timer.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timer.setBounds(10, 10, 267, 23);
        add(timer);
        exitTest = new JButton("Завершить Тест");
        exitTest.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exitTest.setBackground(new Color(109, 141, 143));
        exitTest.setBounds(0,0,20,0);
        
       
        space.setBounds(0,0,0,30);
        space.setBackground(new Color(193, 216, 219));
        
        
    }

    public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public void addData(JPanel panel, String test, int questionsAmount) throws SQLException {
        dbManager.setConnection();

        String query = "SELECT * FROM questions where fk_id = (select id from Test where name ='" + test + "')";

        rs = dbManager.executeQuery(query);

        int id;

        while (rs.next()) {
            questions.add(new Question(rs.getInt("id"), rs.getString("question")));
        }

        Collections.shuffle(questions);

        for (int i = 0; i <= questionAmount - 1; i++) {
            JPanel qPanel = new JPanel();
            qPanel.setName(Integer.toString(i + 1));
            qPanel.setBackground(new Color(193, 216, 219));
            qPanel.setLayout(new MigLayout("left center, wrap, gapy 5"));
            qPanel.setPreferredSize(new Dimension(760, 170));

            JLabel question = new JLabel(i + 1 + ". " +questions.get(i).getQuestionName());
            

            question.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
            id = questions.get(i).getId();
            question.setBounds(0, 2, 760, 25);
            qPanel.add(question);
            addRadioButtons(qPanel, id);
            
            panel.add(qPanel);
            
            
        }
        

        dbManager.closeConnection();
        panel.add(exitTest, "gapleft 350");
        panel.add(space);
       
        
        
    }

    public void addRadioButtons(JPanel panel, int id) throws SQLException {
        rg = new ButtonGroup();
        boxArray = new ArrayList<JCheckBox>();
        
        int count = 0;
        ResultSet rs3 = dbManager.executeQuery("SELECT COUNT(*) AS count FROM correctAnswers where fk_id ='" + id + "'");
        ResultSet resultSet = dbManager.executeQuery("SELECT * FROM correctAnswers");
        ResultSet wResultSet = dbManager.executeQuery("SELECT * FROM wrongAnswers");
        ArrayList<String> shuffledAnswers = new ArrayList<String>();
        
        while(resultSet.next()) {
        	if(rs3.getInt("count") <= 1) {
                if (resultSet.getInt("fk_id") == id) {
                	shuffledAnswers.add(resultSet.getString("answer"));
                }
        	}
        	if(rs3.getInt("count") > 1) {
                if (resultSet.getInt("fk_id") == id) {
                	shuffledAnswers.add(resultSet.getString("answer"));
                }
        	}
        }
        
        while(wResultSet.next()) {
        	if(rs3.getInt("count") <= 1) {
                if (wResultSet.getInt("fk_id") == id) {
                	shuffledAnswers.add(wResultSet.getString("answer"));
                }
        	}
        	if(rs3.getInt("count") > 1) {
                if (wResultSet.getInt("fk_id") == id) {
                	shuffledAnswers.add(wResultSet.getString("answer"));
                }
        	}
        }
        
        
        
        Collections.shuffle(shuffledAnswers);
        
        
        
        
        
         
       for(String s : shuffledAnswers) {
        	if(rs3.getInt("count") <= 1) {
           
            
                answers = new JRadioButton(s);
                answers.setBackground(new Color(193, 216, 219));
                answers.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                answers.setBounds(0, 20, 50, 30);
                
                
                rg.add(answers);
                panel.add(answers);
            }
            
        	
        	if(rs3.getInt("count") > 1) {
                
                
                	boxAnswers = new JCheckBox(s);
                	boxAnswers.setBackground(new Color(193, 216, 219));
                    boxAnswers.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    boxAnswers.setBounds(0, 20, 50, 30);
                    boxArray.add(boxAnswers);
                    panel.add(boxAnswers);
                	
                
                
                
        }
       }
        
        
        rgArray.add(rg);
        if(!boxArray.isEmpty()) {
        boxArrayArray.add(boxArray);
        } 	
        }
        
    
        
        
 

    public void printRadio() {
        for (ButtonGroup bg : rgArray) {
            System.out.println(getSelectedButtonText(bg));
        }
    }

    public static void timer(JLabel label, int time) {
    	timer1   = new Timer();
    	
    	label.setText("");
        long  setTime = time * 60000;
        
        int   millis  = 1000;    // n*1000 millisecond = n second --> n minutes = n*60*1000

        timer1.schedule(new TimerTask() {
        	String timeStamp = "00:00";
                           long time = setTime;
                           public void run() {
                               time = time - millis;

                               timeStamp = new SimpleDateFormat("mm:ss").format(new Timestamp(time));

                               label.setText(timeStamp);
                               
                              
                           }
                       },
                       millis,
                       1000);
    }

    public JButton getExitTest() {
        return exitTest;
    }

    public void setExitTest(JButton exitTest) {
        this.exitTest = exitTest;
    }

    public JPanel getPanel_3() {
        return panel_3;
    }

    public void setPanel_3(JPanel panel_3) {
        this.panel_3 = panel_3;
    }

    public int getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(int questionAmount) {
        this.questionAmount = questionAmount;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<ButtonGroup> getRgArray() {
        return rgArray;
    }

    public void setRgArray(ArrayList<ButtonGroup> rgArray) {
        this.rgArray = rgArray;
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public JLabel getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(JLabel testTitle) {
        this.testTitle = testTitle;
    }

    public JLabel getTimer() {
        return timer;
    }

    public void setTimer(JLabel timer) {
        this.timer = timer;
    }
    
    public ArrayList<ArrayList> getBoxArrayArray() {
		return boxArrayArray;
	}

	public void setBoxArrayArray(ArrayList<ArrayList> boxArrayArray) {
		this.boxArrayArray = boxArrayArray;
	}
	
	public static Timer getTimer1() {
		return timer1;
	}

	public static void setTimer1(Timer timer1) {
		InTest.timer1 = timer1;
	}
}


//~ Formatted by Jindent --- http://www.jindent.com

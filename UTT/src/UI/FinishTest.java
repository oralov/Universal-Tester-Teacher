package UI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.imageio.ImageIO;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
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

import Beans.Question;

import Database.DBManager;

import main.FlowManager;

import net.miginfocom.swing.MigLayout;

public class FinishTest extends JPanel {
    String                 name              = "Без имени";
    String                 testName          = "";
    double                  score             = 0;
    int                    amountOfQuestions = 0;
    Date                   currentDate       = new Date();
    SimpleDateFormat       dateFormat        = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss");
    String                 dateOnly          = dateFormat.format(currentDate);
    JPanel                 panel_3;
    private JButton        exitToMenu;
    ArrayList<Question>    questions;
    ArrayList<ButtonGroup> bgArray;
    ArrayList<ArrayList> boxArrayArray;
    DBManager              dbManager;
    double                   grade;
    String                 date;
    int ticks = 0;
    int crosses = 0;
    boolean flag = false;

    /**
     * Create the panel.
     */
    public FinishTest() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Результаты теста");

        lblNewLabel.setBounds(311, 28, 195, 33);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 88, 785, 486);
        scrollPane.setBorder(null);
        add(scrollPane);
        panel_3 = new JPanel();
        panel_3.setBackground(new Color(193, 216, 219));
        scrollPane.setViewportView(panel_3);
        panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
        exitToMenu = new JButton("Сохранить и выйти");
        exitToMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exitToMenu.setBackground(new Color(109, 141, 143));
        exitToMenu.setBounds(10, 31, 137, 33);
        
    }

    public void addResults(ArrayList<Question> questions, int amount, ArrayList<ButtonGroup> bGrp, ArrayList<ArrayList> chkbx) throws SQLException {
        amountOfQuestions = amount;
        dbManager         = new DBManager();
        this.dbManager.setConnection();
        score = 0;
        panel_3.removeAll();
        this.questions = new ArrayList<Question>();
        this.bgArray   = new ArrayList<ButtonGroup>();
        this.boxArrayArray = new ArrayList<ArrayList>();
        ArrayList<JCheckBox> boxes;
        ResultSet rs;

        this.questions = questions;
        this.bgArray   = bGrp;
        this.boxArrayArray = chkbx;

        JPanel       questionPanel;
        JPanel       container;
        JLabel       text;
        JRadioButton rb;
        JLabel       grade     = new JLabel();
        JLabel       testTitle = new JLabel(testName);

        testTitle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel_3.add(testTitle, "center");
        panel_3.add(new JLabel(dateOnly));
        panel_3.add(new JLabel(name));
        panel_3.add(grade);
        panel_3.add(new JLabel(""));
        
        int counter = 0;

        for (int i = 0; i <= amount - 1; i++) {
            container = new JPanel();
            container.setBackground(new Color(193, 216, 219));
            questionPanel = new JPanel();
            questionPanel.setLayout(new MigLayout("left center, wrap, gapy 5"));
            text = new JLabel();
            questionPanel.setPreferredSize(new Dimension(760, 170));
            questionPanel.setBackground(new Color(193, 216, 219));
            text.setText(this.questions.get(i).getQuestionName());
            container.add(text);
            questionPanel.add(container);
           int correctAnswers =  amountOfAnswers(this.questions.get(i).getQuestionName());
           
           if(correctAnswers <=1) {
               for (Enumeration<AbstractButton> buttons = bgArray.get(i).getElements(); buttons.hasMoreElements(); ) {
                   AbstractButton button = buttons.nextElement();
                   JPanel         cont   = new JPanel();

                   cont.setLayout(new MigLayout());
                   cont.setBackground(new Color(193, 216, 219));
                   button.setBackground(new Color(193, 216, 219));
                   cont.add(button);
                   questionPanel.add(cont);

                   if (button.isSelected()) {
                       rs = dbManager.executeQuery(
                           "SELECT * FROM correctAnswers where fk_id = (SELECT id from questions where question = '"
                           + this.questions.get(i).getQuestionName() + "')");

                       JLabel lbl = new JLabel("");

                       if (button.getText().equals(rs.getString("answer"))) {
                           ImageIcon icon = new ImageIcon("tick.png");
                           Image     img  = getScaledImage(icon.getImage(), 20, 20);

                           icon = new ImageIcon(img);
                           lbl.setIcon(icon);
                           lbl.setPreferredSize(new Dimension(10, 10));
                           button.setForeground(Color.blue);
                           button.getParent().add(lbl, "gapleft 30");
                           score++;
                       } else if(!button.getText().equals(rs.getString("answer"))) {
                           

                           ImageIcon icon = new ImageIcon("cross.png");
                           Image     img  = getScaledImage(icon.getImage(), 20, 20);

                           icon = new ImageIcon(img);
                           lbl.setIcon(icon);
                           lbl.setPreferredSize(new Dimension(10, 10));
                           button.setForeground(Color.red);
                           button.getParent().add(lbl, "gapleft 30");
                       }
                   }
                   
                   
                   panel_3.add(questionPanel);
               }
               int selected = numberOfSelected(bgArray.get(i));
               
               if(selected == 0) {
            	  
               }
              }
              
           
           
            if(correctAnswers > 1) {
        	   
        	  boxes = this.boxArrayArray.get(counter);
        	   System.out.println(boxes.size());
        	   int amountSelected = 0;
        		   for(int j = 0; j <= boxes.size() -1 ; j++) {
        			   JPanel         cont   = new JPanel();	   

                       cont.setLayout(new MigLayout());
                       cont.setBackground(new Color(193, 216, 219));
                     
                       cont.add(boxes.get(j));
                       
                       
                       questionPanel.add(cont); 
                       
                       
                         if(boxes.get(j).isSelected()) {
        				   amountSelected++;
        				   rs = dbManager.executeQuery(
        	                        "SELECT * FROM correctAnswers where fk_id = (SELECT id from questions where question = '"
        	                        + this.questions.get(i).getQuestionName() + "')");
        				   
        				   JLabel lbl = new JLabel("");
        				   while(rs.next()) {
        					   
        				   if (boxes.get(j).getText().equals(rs.getString("answer"))) {
        					   
                               ImageIcon icon = new ImageIcon("tick.png");
                               Image     img  = getScaledImage(icon.getImage(), 20, 20);

                               icon = new ImageIcon(img);
                               lbl.setIcon(icon);
                               lbl.setPreferredSize(new Dimension(10, 10));
                               boxes.get(j).setForeground(Color.blue);
                               boxes.get(j).getParent().add(lbl, "gapleft 30");
                               ticks++;
                               flag = true;
                           }
        				   
        				   
        				   
        					   
        				   else if (!flag && !(boxes.get(j).getText().equals(rs.getString("answer")))) {
        					   
                               ImageIcon icon = new ImageIcon("cross.png");
                               Image     img  = getScaledImage(icon.getImage(), 20, 20);

                               icon = new ImageIcon(img);
                               lbl.setIcon(icon);
                               lbl.setPreferredSize(new Dimension(10, 10));
                               boxes.get(j).setForeground(Color.red);
                               boxes.get(j).getParent().add(lbl, "gapleft 30");
                               crosses ++;
                               if(j != 1) {
                               
                               }
                              
                           }
        				   
        				   
        				   }
        				   
        				   
        			   }
                         
        		   
                         flag = false;    
        		   }
        		    if(amountSelected == 0) {
                  	 
                   }
        		  
        		 counter++;    
        		 panel_3.add(questionPanel);    
        	   
        	   
           }
           
           
           
           
        }
        
        System.out.println("ticks: " + ticks);
        crosses = crosses/2;
        System.out.println(score);
        if(ticks != 0) {
        score = score + (ticks * 0.5) ;
        }
        else {
        	score = score + (ticks * 0.5);
        }
        grade.setText("Процент выполнения теста: " + String.valueOf((int)(calcGrade(score, amount)) + "/100"));
        this.dbManager.closeConnection();
        panel_3.add(exitToMenu, "gapleft 350");
        
    }

    public double calcGrade(double score, int amount) {
        grade = score * 100 / amount;

        return grade;
    }

    private Connection connect() {

        // SQLite connection string
        String     url  = "jdbc:sqlite:sample.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;

        try {
            File            f      = new File(file);
            FileInputStream fis    = new FileInputStream(f);
            byte[]          buffer = new byte[1024];

            bos = new ByteArrayOutputStream();

            for (int len; (len = fis.read(buffer)) != -1; ) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }

        return (bos != null)
               ? bos.toByteArray()
               : null;
    }

    public void readPicture(String filename) {
        String            selectSQL = "SELECT image FROM results WHERE date= '" + dateOnly + "'";
        ResultSet         rs        = null;
        FileOutputStream  fos       = null;
        PreparedStatement pstmt     = null;

        try {
            dbManager.setConnection();
            rs = dbManager.executeQuery(selectSQL);

            // write binary stream into file
            File file = new File(filename);

            fos = new FileOutputStream(file);
            System.out.println("Writing BLOB to file " + file.getAbsolutePath());

            while (rs.next()) {
                InputStream input  = rs.getBinaryStream("image");
                byte[]      buffer = new byte[1024];

                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (fos != null) {
                    fos.close();
                }

                dbManager.closeConnection();
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveImage() {
        BufferedImage imagebuf = null;

        try {
            imagebuf = new Robot().createScreenCapture(panel_3.bounds());
        } catch (AWTException e1) {

            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Graphics2D graphics2D = imagebuf.createGraphics();

        panel_3.paint(graphics2D);

        try {
            ImageIO.write(imagebuf, "jpg", new File("save1.jpg"));
        } catch (Exception e) {

            // TODO Auto-generated catch block
            System.out.println("error");
        }
    }

    public void saveResults(DBManager dbManager) throws SQLException {
        date = new Date().toString();
        dbManager.executeUpdate("INSERT INTO results(date, name, testName, grade) values('" + dateOnly + "'," + "'"
                                + name + "'," + "'" + testName + "'," + grade + ")");

        for (int i = 0; i <= amountOfQuestions - 1; i++) {
            dbManager.executeUpdate("INSERT INTO resultQuestion(question, fk_id) values ('"
                                    + questions.get(i).getQuestionName() + "', (SELECT id from results where date='"
                                    + date + "'))");
            dbManager.executeUpdate("INSERT INTO resultsAnswers(answer, fk_id) values('"
                                    + getSelectedButtonText(bgArray.get(i))
                                    + "', (SELECT id from resultQuestion where question='"
                                    + questions.get(i).getQuestionName() + "'))");
        }

        saveImage();

        String updateSQL = "UPDATE results " + "SET image = ? " + "WHERE date=?";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, readFile("save1.jpg"));
            pstmt.setString(2, dateOnly);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // dbManager.executeUpdate("UPDATE results set image = " + "'" + readFile("save1.jpeg") + "'" + " where date = '" + dateOnly + "'");
        this.bgArray.clear();
        this.boxArrayArray.clear();
        score = 0;
        ticks =0;
        crosses = 0;
    }

    public JButton getExitTest() {
        return exitToMenu;
    }

    public void setExitTest(JButton exitTest) {
        this.exitToMenu = exitTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getPanel_3() {
        return panel_3;
    }

    public void setPanel_3(JPanel panel_3) {
        this.panel_3 = panel_3;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D    g2         = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
    
    public int numberOfSelected(ButtonGroup bGrp) {
    	int num = 0;
    	  for (Enumeration<AbstractButton> buttons = bGrp.getElements(); buttons.hasMoreElements(); ) {
              AbstractButton button = buttons.nextElement();

              if (button.isSelected()) {
                  num++;
              }
          }

          return num;
    }
    
    
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    public int amountOfAnswers(String question) throws SQLException {
    	int count = 0;
    	ResultSet rs = dbManager.executeQuery("SELECT COUNT(*) as count from correctAnswers where fk_id= (SELECT id from questions where question='" + question + "')");	
    	count = rs.getInt("count");
    	return count;
    }
    
    
    
    
}


//~ Formatted by Jindent --- http://www.jindent.com

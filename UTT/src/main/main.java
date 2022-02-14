package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import Database.DBManager;

import UI.ActivationPanel;
import UI.AddQuestions;
import UI.CreateNewTest;
import UI.CreateTest;
import UI.MainMenu;
import UI.MainWindow;

public class main {
    public static void main(String[] args) throws SQLException {

        // TODO Auto-generated method stub
        FlowManager start = new FlowManager();

        // dbManager.setConnection();
        // dbManager.executeUpdate("insert into Test values('China');");
        // ResultSet rs = dbManager.executeQuery("Select * from Test;");
        start.run();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

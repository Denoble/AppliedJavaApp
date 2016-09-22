/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appliedjavaassignment;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DefaultFrame extends JFrame {
    JPanel mainPanel,topmost,westPanel;JLabel label;
    JRadioButton connect,disconnect,insert,read,update;
     public DefaultFrame(){
        super("Default Frame");
     }
     
     public JPanel beforeFirst(){
         label= new JLabel();
         label.setForeground(Color.red);
         label.setFont(new Font("Arial", Font.ITALIC, 11));
         label.setVisible(true);
         topmost=new JPanel(new GridLayout(1,1,0,0));
         topmost.add(label);
         
         topmost.setSize(20,20);
         topmost.setVisible(false);
         return topmost;
     }
     public JPanel firstPanel(){
         ButtonGroup choice = new ButtonGroup();
         connect = new JRadioButton("Connect To Database");
         connect.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e){
                Database.connect();
             topmost.setVisible(true);
          label.setVisible(true);
             label.setText("Database connection was sucessful !");   
             }
     });
    
         disconnect=new JRadioButton("Disconnect From Database");
         disconnect.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e){
                 Database.disconnect();
                 topmost.setVisible(true);
                 label.setVisible(true);
             label.setText("Database disconnection was sucessful !");
             }
         });
         insert = new JRadioButton("Insert To Database:");
         insert.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e){
                 try{
                 Insert.displayinsert();
                 }
                 catch(Exception ex){
                 }
             }
         });
         read = new JRadioButton("Read From Database");
         read.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e){
                 try{
                 ReadData.displayReadData();
                 }
                 catch(Exception ex){
                 }
             }
         });
         update = new JRadioButton("UpDate Database");
         update.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent e){
                 try{
                 Insert.displayinsert();
                 }
                 catch(Exception ex){
                 }
             }
         });
         choice.add(connect);
         choice.add(disconnect);
         choice.add(insert);
         choice.add(read);
         choice.add(update);
         mainPanel = new JPanel(new GridLayout(5,5,0,0));
         mainPanel.setBackground(Color.white);
         mainPanel.setSize(60,60);
         mainPanel.add(connect);
         mainPanel.add(disconnect);
         mainPanel.add(insert);
         mainPanel.add(read);
         mainPanel.add(update);
         mainPanel.setVisible(true);
         return mainPanel;
     }

     public static void main(String[]args) throws Exception{
        UIManager.setLookAndFeel

                  (UIManager.getSystemLookAndFeelClassName());
        DefaultFrame df = new DefaultFrame();
        Point p = Position.getPosition(500, 500);
        df.setBounds(p.x, p.y, 500, 500);
        df.setVisible(true);
        df.add(df.beforeFirst(),BorderLayout.NORTH);
        df.add(df.firstPanel(),BorderLayout.CENTER);
        
        df.setResizable(false);
       df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}

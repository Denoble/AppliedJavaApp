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
public class Insert extends JFrame{
     static JPanel panel1,p2,p3;
   static JLabel label1,label2;
    static JTextArea statement;
    static JButton execute,back;
   public Insert(){
         super("Data inserting,updating and deleting Frame");
   }
   public static JPanel label(){
       label2 = new JLabel();
       label2= new JLabel();
       label2.setForeground(Color.red);
       label2.setFont(new Font("Arial", Font.ITALIC, 11));
       label2.setVisible(true);
       p2=new JPanel(new GridLayout(1,1,0,0));;
       p2.add(label2);
       p2.setVisible(false);
   return p2;}
    public static JPanel insert(){
        label1=  new JLabel("SQL statement: ");
        label1.setFont(new Font("Arial", Font.BOLD, 15));
        statement = new JTextArea(8,25);
        
        panel1= new JPanel(new GridLayout(1,1,0,0));
        panel1.setSize(40, 40);
       
        panel1.add(label1);
        panel1.add(statement);
        
        panel1.setVisible(true);
                return panel1;
    }
    public static void back(){
        DefaultFrame df = new DefaultFrame();
        Point p = Position.getPosition(500, 500);
        df.setBounds(p.x, p.y, 500, 500);
        df.setVisible(true);
        df.add(df.beforeFirst(),BorderLayout.NORTH);
        df.add(df.firstPanel(),BorderLayout.CENTER);
        
        df.setResizable(false);
       df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
    
    public JPanel panel3(){
       execute= new JButton("Execute Statement");
       execute.setFont(new Font("Time New Roman",Font.BOLD,14));
        execute.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        Database.insert();}});
        back= new JButton("Back");
       back.setFont(new Font("Time New Roman",Font.BOLD,14));
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        back();}});
       p3=new JPanel(new GridLayout(1,1,0,0));;
       p3.add(back);
       p3.add(execute);
       p3.setVisible(true);
   return p3;}
    public static void displayinsert()throws Exception{
      UIManager.setLookAndFeel

                  (UIManager.getSystemLookAndFeelClassName());
        Insert in = new Insert();
        Point p = Position.getPosition(500, 500);
        in.setBounds(p.x, p.y, 500, 500);
        in.setVisible(true);
        in.add(in.label(),BorderLayout.NORTH);
        in.add(in.insert(),BorderLayout.CENTER);
        in.add(in.panel3(),BorderLayout.SOUTH);
        in.setLayout(new FlowLayout());
        in.setResizable(false);
       in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
    }
     public static void main(String[]args) throws Exception{
       
    }
}

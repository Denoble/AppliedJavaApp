
package appliedjavaassignment;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
public class ReadData extends JFrame {
     static JPanel panel4,panel5,panel6,panel7,panel8;
   static JLabel label4,label5,label6;
    static JTextArea statement;
    static DefaultTableModel dm;
    static JButton execute,back;
    static JTable jt;
     public static JPanel design(){
       label4 = new JLabel();
       label4= new JLabel();
       label4.setForeground(Color.red);
       label4.setFont(new Font("Arial", Font.ITALIC, 11));
       label4.setVisible(true);
       panel4=new JPanel(new GridLayout(1,0,0,0));;
       panel4.add(label4);
       panel4.setVisible(false);
   return panel4;}
     public static JPanel design2(){
        label5=  new JLabel("SQL statement: ");
        label5.setFont(new Font("Arial", Font.BOLD, 15));
      
        statement = new JTextArea(8,25);
        
          
        panel5= new JPanel(new GridLayout(1,1,0,0));
        panel5.setSize(40, 40);
       
        panel5.add(label5);
        panel5.add(statement);
        
        
        panel5.setVisible(true);
                return panel5;
}
   
   public JPanel design3(){
       execute= new JButton("Execute Statement");
       execute.setFont(new Font("Time New Roman",Font.BOLD,14));
        execute.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        Database.read();
        label4.setText("Read was sucessful");
        panel4.setVisible(true);
        statement.setText("");
        }});
        back= new JButton("Back");
       back.setFont(new Font("Time New Roman",Font.BOLD,14));
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        Insert.back();}});
       panel6=new JPanel(new GridLayout(1,1,0,0));;
       panel6.add(back);
       panel6.add(execute);
       panel6.setVisible(true);
   return panel6;
   }
   public JPanel design5(){
       dm=new DefaultTableModel();
        jt = new JTable();
        
        panel7= new JPanel(new GridLayout(1,0,0,0));
       jt.setSize(50, 100);
        panel7.add(jt);
       
        panel7.setVisible(false);
        return panel7;
   }
    public static void displayReadData()throws Exception{
      UIManager.setLookAndFeel

                  (UIManager.getSystemLookAndFeelClassName());
        ReadData rd = new ReadData();
        Point p = Position.getPosition(500, 500);
        rd.setBounds(p.x, p.y, 500, 500);
        rd.setVisible(true);
        rd.add(rd.design(),BorderLayout.NORTH);
        rd.add(rd.design2(),BorderLayout.CENTER);
       
        rd.add(rd.design5(),BorderLayout.CENTER);
        rd.add(rd.design3(),BorderLayout.SOUTH);
        rd.setLayout(new FlowLayout());
        rd.setResizable(false);
       rd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
    }
}

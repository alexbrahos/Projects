import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class HomeMenu extends JFrame implements ActionListener{

  JLabel header = new JLabel("Please select an option");
  JButton login = new JButton("Login");
  JButton createAcct = new JButton("Create an Account");
  JButton exit = new JButton("Save and Quit");

  public HomeMenu(){
    super("Chord Quiz");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container surface = this.getContentPane();
    surface.setLayout(new GridLayout(4,1));
    
    surface.add(header);
    surface.add(login);
    surface.add(createAcct);
    surface.add(exit);

    login.addActionListener(this);
    createAcct.addActionListener(this);
    exit.addActionListener(this);
    
    this.setSize(600, 400);
    this.setVisible(true);
    
  } //end constructor

  
  public void actionPerformed(ActionEvent event){

    Object whichButton = event.getSource();

    if (whichButton == login){
      new LoginMenu();
      this.dispose();
    } else if (whichButton == createAcct){
      new CreateAcctMenu();
      this.dispose();
    } else if (whichButton == exit){

      try{

        FileOutputStream outFile = new FileOutputStream("allSavedUsers.dat");
        ObjectOutputStream outObject = new ObjectOutputStream(outFile);
        outObject.writeObject(Main.allUsers);
        
      } catch(Exception excep){

        System.out.println(excep.getMessage());
        
      } //end try
      
      this.dispose();
    }
    
  } //end actionPerformed
  
} //end class definition
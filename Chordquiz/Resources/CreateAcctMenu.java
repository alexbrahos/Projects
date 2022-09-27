import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateAcctMenu extends JFrame implements ActionListener{
  
  JButton back = new JButton("Back");
  JLabel header = new JLabel("Create your username and password");
  JTextField usernameBox = new JTextField("Username");
  JTextField passwordBox = new JTextField("Password");
  JButton submit = new JButton("Submit");
  
  JPanel smaller = new JPanel (new GridLayout(2,1));
  JPanel topLine = new JPanel (new GridLayout(1,3));

  public CreateAcctMenu() {
    super("Create an Account");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container surface = this.getContentPane();
    surface.setLayout(new GridLayout(4,1));

    topLine.add(back);
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
    smaller.add(topLine);
    smaller.add(header);
    surface.add(smaller);
    
    surface.add(usernameBox);
    surface.add(passwordBox);
    surface.add(submit);

    submit.addActionListener(this);
    back.addActionListener(this);
    
    this.setSize(600,400);
    this.setVisible(true);
    
  } //end constructor


  public void actionPerformed(ActionEvent event){

    int foundMatch = 0;
    Object whichButton = event.getSource();

    if (whichButton == submit){
      
      for(int i = 0; i < Main.allUsers.size(); i++){

        if (Main.allUsers.get(i).getUsername().equals(usernameBox.getText())){

          foundMatch = 1;
          
        } //end if
        
      }// end for

      if(foundMatch == 1){ //the user already exists

        header.setText("That user already exists. Please try again");
        
      } else { //no user was found, allow them to create
        
        Main.allUsers.add(new User(usernameBox.getText(), passwordBox.getText()));
        header.setText("User created. Please return to menu and login");
        
      }//end if
      
    } else if(whichButton == back){
      new HomeMenu();
      this.dispose();
    }//end if
  } //end actionPerformed
} //end class definition
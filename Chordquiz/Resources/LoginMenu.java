import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginMenu extends JFrame implements ActionListener{
  
  JButton back = new JButton("Back");
  JLabel header = new JLabel("Enter your username and password");
  JTextField usernameBox = new JTextField("Username");
  JTextField passwordBox = new JTextField("Password");
  JButton submit = new JButton("Submit");
  
  JPanel smaller = new JPanel (new GridLayout(2,1));
  JPanel topLine = new JPanel (new GridLayout(1,3));

  public LoginMenu() {
    super("Login");
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
    int matchPos = 0;
    Object whichButton = event.getSource();

    if (whichButton == submit){ //submit putton pressed
      
      for (int i = 0; i < Main.allUsers.size(); i++){ //do this for all the users

        if (Main.allUsers.get(i).getUsername().equals(usernameBox.getText())){ //if the username matches a user, mark success, and the position of the success

          foundMatch = 1;
          matchPos = i;
          
        } //end if
        
      } //end for

      if (foundMatch == 1){ //we found a match

        if (passwordBox.getText().equals(Main.allUsers.get(matchPos).getPassword())){ //if the password also matches, login
          
          new ProfileScreen(matchPos);
          this.dispose();
          
        } else { //password does not match
          
          header.setText("Username or password is incorrect. Please try again");
          
        }//end if
        
      } else { //username does not match any users
        
        header.setText("Username or password is incorrect. Please try again");
        
      } //end if
      
    } else if(whichButton == back){
      new HomeMenu();
      this.dispose();
    }//end if
  } //end actionPerformed
} //end class definition
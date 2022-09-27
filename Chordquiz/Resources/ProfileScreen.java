import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProfileScreen extends JFrame implements ActionListener{

  JButton logOut = new JButton("Log Out");
  JButton viewStats = new JButton("View Stats");
  JLabel header = new JLabel("Welcome [username]!");
  JButton startQuiz1 = new JButton("Start a Major/Minor Quiz");
  JButton startQuiz2 = new JButton("Start a Suspended Chords Quiz");
  JButton startQuiz3 = new JButton("Start a 7th Chords Quiz");
  JButton startQuiz4 = new JButton("Start a quiz based on your skill level");

  JPanel topLine = new JPanel(new GridLayout(1, 3));
  JPanel thirdLine = new JPanel(new GridLayout(1, 2));
  JPanel lastLine = new JPanel(new GridLayout(1, 2));

  protected int userNum;

  
  public ProfileScreen() {
    System.out.println("profilescreen null constructor");
  } //end null parameter constructor


  public ProfileScreen(int userNum){

    super("Profile Menu");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.userNum = userNum;

    Container surface = this.getContentPane();
    surface.setLayout(new GridLayout(4,1));

    topLine.add(logOut);
    topLine.add(new JLabel(""));
    topLine.add(viewStats);

    thirdLine.add(startQuiz1);
    thirdLine.add(startQuiz2);

    lastLine.add(startQuiz3);
    lastLine.add(startQuiz4);

    surface.add(topLine);
    surface.add(header);
    surface.add(thirdLine);
    surface.add(lastLine);

    header.setText("Welcome " + Main.allUsers.get(this.userNum).getUsername() + "!");
    header.setHorizontalAlignment(0);

    logOut.addActionListener(this);
    viewStats.addActionListener(this);
    startQuiz1.addActionListener(this);
    startQuiz2.addActionListener(this);
    startQuiz3.addActionListener(this);
    startQuiz4.addActionListener(this);

    this.setSize(600,400);
    this.setVisible(true);
    
  } //end other constructor


  public void actionPerformed(ActionEvent event){

    Object whichButton = event.getSource();

    if (whichButton == logOut){
      
      new HomeMenu();
      this.dispose();
      
    } else if(whichButton == viewStats){

      new StatScreen(this.userNum);
      this.dispose();
      
    } else if(whichButton == startQuiz1){

      Main.allUsers.get(this.userNum).addNewAttempt(new MajorMinorQuiz(this.userNum));
      this.dispose();
      
    } else if(whichButton == startQuiz2){

      Main.allUsers.get(this.userNum).addNewAttempt(new SuspendedQuiz(this.userNum));
      this.dispose();
      
    } else if(whichButton == startQuiz3){

      Main.allUsers.get(this.userNum).addNewAttempt(new SeventhsQuiz(this.userNum));
      this.dispose();

    } else if(whichButton == startQuiz4){

      if (Main.allUsers.get(this.userNum).getRecentScores() < 0.34){ //do major/minor
        
        Main.allUsers.get(this.userNum).addNewAttempt(new MajorMinorQuiz(this.userNum));
        this.dispose();
        
      } else if (Main.allUsers.get(this.userNum).getRecentScores() < 0.68){ //do sus
        
        Main.allUsers.get(this.userNum).addNewAttempt(new SuspendedQuiz(this.userNum));
        this.dispose();
        
      } else { //do 7ths
        
        Main.allUsers.get(this.userNum).addNewAttempt(new SeventhsQuiz(this.userNum));
        this.dispose();
        
      } //end if
      
    } //end if
    
  } //end actionPerformed
  
} //end class definition
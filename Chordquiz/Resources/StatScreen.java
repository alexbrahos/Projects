import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatScreen extends JFrame implements ActionListener{

  JButton back = new JButton("Back");
  JLabel lifetime = new JLabel("Lifetime Average: ");
  JLabel lifeNum = new JLabel("none");
  JLabel recent = new JLabel("<html>" + "Past 5 attempt average:" + "</html>");
  JLabel recentNum = new JLabel("none");
  JLabel total = new JLabel("<html>" + "Total Quizzes taken:" + "</html>");
  JLabel totalNum = new JLabel("none");
  JLabel recc = new JLabel("Recommended Quiz: ");
  JLabel reccName = new JLabel("none");

  JPanel topLine = new JPanel(new GridLayout(1,3));
  JPanel midLine = new JPanel(new GridLayout(1,4));
  JPanel lastLine = new JPanel(new GridLayout(1,4));

  protected int userNum;

  
  public StatScreen(){
    System.out.println("Stats null constructor");
  } //end null parameter constructor

  
  public StatScreen(int userNum){

    super("Stats");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container surface = this.getContentPane();
    surface.setLayout(new GridLayout(3,1));

    topLine.add(back);
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));

    midLine.add(lifetime);
    midLine.add(lifeNum);
    midLine.add(total);
    midLine.add(totalNum);

    lastLine.add(recent);
    lastLine.add(recentNum);
    lastLine.add(recc);
    lastLine.add(reccName);

    surface.add(topLine);
    surface.add(midLine);
    surface.add(lastLine);

    back.addActionListener(this);

    this.setSize(600,400);
    this.setVisible(true);

    this.userNum = userNum;

    lifeNum.setText("" + Main.allUsers.get(this.userNum).getLifetimeScore());
    recentNum.setText("" + Main.allUsers.get(this.userNum).getRecentScores());
    totalNum.setText("" + Main.allUsers.get(this.userNum).getTotal());

    if (Main.allUsers.get(this.userNum).getRecentScores() < 0.34){
      reccName.setText("Major/Minor");
    } else if (Main.allUsers.get(this.userNum).getRecentScores() < 0.68){
      reccName.setText("Suspended");
    } else {
      reccName.setText("7ths");
    } //end if
    
  } //end other constructor


  public void actionPerformed(ActionEvent event){

    Object whichButton = event.getSource();

    if (whichButton == back){
      new ProfileScreen(this.userNum);
      this.dispose();
    } //end if
    
  } //end actionPerformed
  
} //end class definition
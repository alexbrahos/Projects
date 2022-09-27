import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuspendedQuiz extends MajorMinorQuiz{

  JLabel questionNum = new JLabel("1");
  JLabel questionHeader = new JLabel("None");

  JButton allButtons[] = {new JButton("C"), new JButton("C# / Db"), new JButton("D"), new JButton("D# / Eb"), new JButton("E"), new JButton("F"), new JButton("F# / Gb"), new JButton("G"), new JButton("G# / Ab"), new JButton("A"), new JButton("A# / Bb"), new JButton("B")};

  JPanel topLine = new JPanel(new GridLayout(3, 3));
  JPanel lastLine = new JPanel(new GridLayout(4, 3));

  protected int chosenNote;
  protected int chosenInterval;
  protected int userNum;
  protected int numCorrect;
  protected int lives;
  protected boolean[] correctNotes;
  protected boolean[] availNotes;
  protected boolean nextQuestion;
  protected int qNum;


  public SuspendedQuiz() {
    System.out.println("suspended null constructor");
  }
  

  public SuspendedQuiz(int userNum) {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.userNum = userNum;
    correctNotes = new boolean[12];
    availNotes = new boolean[12];
    numCorrect = 0;
    
    Container surface = this.getContentPane();
    surface.setLayout(new GridLayout(2,1));

    topLine.add(questionNum);
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
    topLine.add(questionHeader);
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
    topLine.add(new JLabel(""));
 
    for (int i = 0; i < 12; i++){
      lastLine.add(allButtons[i]);
      allButtons[i].addActionListener(this);
    } //end for

    surface.add(topLine);
    surface.add(lastLine);

    questionHeader.setHorizontalAlignment(0);

    this.setSize(600,400);
    this.setVisible(true);

    qNum = 1;
    this.startQuiz();
    
  } //end constructor


  public void startQuiz(){

    writeQuestion();
    
  } //end startQuiz

  
  public void writeQuestion(){

    chosenNote = (int)(Math.random()*12); //choose the note
    chosenInterval = (int)(Math.random()*2); //choose the type of chord
    lives = 3;
    nextQuestion = false;

    String[] allNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    String[] intervals = {"sus2", "sus4"};

    questionHeader.setText(allNotes[chosenNote] + "" + intervals[chosenInterval]);
    questionNum.setText("" + qNum);
    
    for (int i = 0; i < 12; i++){ //set all notes to be available but incorrect
      availNotes[i] = true;
      correctNotes[i] = false;
    } //end for

    availNotes[chosenNote] = false; //disable the current note selected

    for (int i = 0; i < 12; i++){ //reset all background colors
      allButtons[i].setBackground(null);
    }

    allButtons[chosenNote].setBackground(Color.green);

    int tempNum = chosenNote;

    
    tempNum += (2 + (3*chosenInterval));
    if (tempNum > 11){ //if the number is too high, loop around
      tempNum -= 12;
    } //end if
    correctNotes[tempNum] = true;
    tempNum += (5 - (3*chosenInterval));
    if (tempNum > 11){ //if the number is too high, loop around
      tempNum -= 12;
    } //end if
    correctNotes[tempNum] = true;
    
  } //end writeQuestion


  public boolean questionComplete(){

    if (lives == 0){
      return true;
    } //end if
      
    for (int i = 0; i < 12; i++){

      if (correctNotes[i]){ //only check against the correct ones

        if (availNotes[i]){ //a correct option is still available

          return false;
          
        } //end if avail
        
      } //end if correct
      
    } //end for

    numCorrect += 1;
    return true;
    
  } //end questionComplete


  public int getScore(){
    return numCorrect;
  } //end getScore


  public void actionPerformed(ActionEvent event){

    Object whichButton = event.getSource();

    for (int i = 0; i < 12; i++){

      if (whichButton == allButtons[i]){

        if (availNotes[i]){ //available button selected

          availNotes[i] = false;
          if (correctNotes[i]){ //correct button selected

            allButtons[i].setBackground(Color.green);
            
          } else { //incorrect button selected
            
            allButtons[i].setBackground(Color.red);
            lives -= 1;
            
          }//end correct button if

          if(questionComplete()){
            qNum += 1;
            if (qNum < 6){
              writeQuestion();
            } else{ //done with quiz
              
              new ProfileScreen(this.userNum);
              this.dispose();
              
            }//end if question is less than 6
          } //end if question complete
          
        } //end availability check if
        
      } //end looking for button selected if
      
    } //end for
    
  } //end actionPerformed
  
} //end class definition
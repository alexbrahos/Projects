import java.io.*;
import java.util.*;

public class User implements Serializable{

  protected String username;
  protected String password;
  protected ArrayList<MajorMinorQuiz> allQuizzes;

  
  public User(){

    this.username = "";
    this.password = "";
    allQuizzes = new ArrayList<MajorMinorQuiz>();
    
  } //end null parameter constructor


  public User(String username, String password){

    this.username = username;
    this.password = password;
    allQuizzes = new ArrayList<MajorMinorQuiz>();
    
  } //end other constructor


  public String getUsername(){

    return this.username;
    
  }

  public String getPassword(){

    return this.password;
    
  }


  public double getLifetimeScore(){
    
    double sum = 0;

    if (allQuizzes.size() < 1){
      return 0.0;
    } //end if

    for (int i = 0; i < allQuizzes.size(); i++){
      sum += allQuizzes.get(i).getScore();
    } //end for

    return (sum/(allQuizzes.size()*5));
    
  } //end getLifetimeScore


  public double getRecentScores(){

    double sum = 0;
    
    if (allQuizzes.size() < 5){
      return 0.0;
    } //end if

    for (int i = allQuizzes.size()-1; i > allQuizzes.size()-6; i--){
      sum += allQuizzes.get(i).getScore();
    } //end for

    return (sum/25);
  } //end getRecentScores


  public int getTotal(){
    return allQuizzes.size();
  }


  public void addNewAttempt(MajorMinorQuiz attempt){
    this.allQuizzes.add(attempt);
  } //end addNewAttempt
  
} //end class definition
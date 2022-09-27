import java.util.*;
import java.io.*;

class Main{

  public static ArrayList<User> allUsers = new ArrayList<User>();
  
  public static void main(String[] args){
    
    try{

      FileInputStream inFile = new FileInputStream("allSavedUsers.dat");
      ObjectInputStream inObject = new ObjectInputStream(inFile);
      allUsers = (ArrayList<User>)inObject.readObject();
      
    } catch(Exception e){

      System.out.println(e.getMessage());
      
    } //end try

    new HomeMenu();
  }
}
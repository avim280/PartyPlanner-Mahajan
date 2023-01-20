import java.io.File; //imports
import java.io.FileNotFoundException; 
import java.util.ArrayList;
import java.util.Scanner;



public class Party {

  /**
  *Avi Mahajan
  * 1/20/22 
  * This is the main class(not main method) where people are assigned to the correct companyList and registers new people that user inputs.
  */
  
   //class variables
  int attendees;
  int index;
      ArrayList<Company> companyList; //declaring arrayLists
         ArrayList<Table> tableList;

  
      public Party() { //constructor
    attendees = 0;
    index = 1;
    
    companyList = new ArrayList<Company>();
    companyList.add(new Company("lol")); //Filler- company 1 starts at index 1

        tableList = new ArrayList<Table>();
    tableList.add(new Table()); //filler
    
  }
      public void addName(String name, int compNum){ //adds person to companyList in  the correct company
       if (companyList.get(compNum).availableSpace() && attendees < 100){
        companyList.get(compNum).addPerson(name, compNum);
      attendees ++; //increase attendees
    }
  }

  public void loadNames(String fileName){ //adds person to companyList from a file(names) 

    try{
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String[] data = myReader.nextLine().split(",");
        addName(data[2] + " " + data[1], Integer.parseInt(data[3]));
      }
    }    catch (FileNotFoundException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }

  public void loadCompanies(String fileName){ //adds companyNames to companyList
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
          String[] data = myReader.nextLine().split(",");
        companyList.add(new Company(data[1])); //this line adds companyNames
      }        
    } catch (FileNotFoundException e){
        System.out.println("An error occured.");
      e.printStackTrace();
    }
  }

  public void arrange(){ //arranges people into certain tables
    for (int i = 0; i < 10; i++){
      tableList.add(new Table());
    }

    
    for (int i = 1; i < companyList.size(); i++){
      for (int j = 0; j < companyList.get(i).getSize(); j++){
        tableList.get(index).addPerson(companyList.get(i).getPerson(j)); //adds person to tableList
        index++;
        if (index == 11){
          index = 1;
        }
      }
    }
    for (int i = 1; i < 11; i++){
       tableList.get(i).assignPerson(i); //assigns person to correct table and seat
    }
  }

  public void displayTables(){ //prints the tables
    System.out.println("Displaying Tables: \n\n");
    for (int i = 1; i < 11; i++){
      System.out.println("Table " + i + ": ");
      tableList.get(i).printPeople(); //prints each person in table i
      System.out.println();
    }
    
  }

  public void findPerson(String fName, String lName){ //finds name and seat of person
       boolean hasBeenFound = false;
    for (int i = 1; i < 11; i++){
      int found = tableList.get(i).find(fName, lName); //finds name and seat of person in each list of table
      if (found != -1){ //if found
        hasBeenFound = true;
        System.out.println(fName + " " + lName + " is sitting at Table " + i + " at seat " + found);
      }
    }
    if (hasBeenFound == false){ //if not found
      System.out.println("Person not found");
    }
  }


  
}
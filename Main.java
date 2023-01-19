import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.ArrayList;


class Main {
  
  public static void main(String[] args) {
   
    ArrayList<ArrayList<Person>> people = new ArrayList<ArrayList<Person>>();
    //2D ArrayList -> ArrayList Index refers to Company Number
           ArrayList<String> companyNames = new ArrayList<String>();
    //For printing at the end -> See end


    people.add(new ArrayList<Person>()); //Filler will never be used -> for Indexing
    companyNames.add("spot"); //skip 0 index
    //Company 1 will be on Index 1 -> Company 2 will be on Index 2
    

    try { //Get Data
      File myObj = new File("companies.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String[] data = myReader.nextLine().split(",");
        people.add(new ArrayList<Person>());
        companyNames.add(data[1]); 
      } //Collect All Company names and Store into People
      myReader.close();
      
      int totalAttendance = 0;
      myObj = new File("names.txt");
      myReader = new Scanner(myObj);
      while (myReader.hasNextLine()){
        String[] data = myReader.nextLine().split(",");
        //Register person into correct table
        // num,last,first,compnum
        if( (people.get(Integer.parseInt(data[3])).size() < 10) 
           && (totalAttendance < 100) ){ 

          people.get(Integer.parseInt(data[3])).add(new Person(data[2] + " " + data[1], Integer.parseInt(data[3]))); //Store each person into the correct company
          totalAttendance++;
          
     //If the person's company already has 10 people, person is not added onto Attendance List
          //Or if there are > 100 people already on Attendance List, then register new person into correct table
        
        }
      }
      
      myReader.close();

      /* 
      */
      

    } catch (FileNotFoundException e) { //Catch Errors
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    


    //Assign Tables
   int index = 1; //Table Num next Person will sit at
   // for(int i = 1; i < people.size(); i++){
    //  for(int j = 0; j < people.get(i).size(); j++){ //Get Each Person in  company i
    //  people.get(i).get(j).setTable(index);
    //      index++; //Move to next Person
    //    if(index > 10){ //Rotate back to table 1 if >10
     //     index = 1;
     //   }
   //   }
 //   }

    //use for each loop because easier to understand

    for (ArrayList<Person> company : people) {
          for (Person person : company) {
          person.setTable(index);
          index++; //Move to next Person
        if(index > 10){ //Rotate back to table 1 if >10
          index = 1;
      }
    }
    }
            
            
          

    
    //Print out Assignments
    //This will print out where each person will sit
    /*for(int i = 0; i < people.size(); i++){
      for(int j = 0; j < people.get(i).size(); j++){
        System.out.println(people.get(i).get(j).getName() + " will sit at table " + people.get(i).get(j).getTable());
      }
    }*/ 

    //This will print out who is at which table
   for (int i = 1; i < 11; i++){
      System.out.println("Table " + i + ": ");
      for (ArrayList<Person> company : people){ //for each company in array list of people
        for(Person person : company){ //for each person in company
          if(person.getTable() == i){ //if the table of person is equal to i(table)
            System.out.println(person.getName() + " ("  + companyNames.get(person.getCompNum())+ ")"); //prints name (company)
          }
           }
          }
      System.out.println();
    }
    



    


  }
}
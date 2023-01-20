

import java.util.ArrayList;

public class Table {
  /**
  *Avi Mahajan
  * 1/20/22 
  * The purpose of this class is to aassign tables, print tables, and find name and seat of people
  */
  //class variables
  private ArrayList<Person> people; //instance variables
    String[] compNames = {"", "Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"}; //compNames as array
  
  //constructor
  public Table () {

    people = new ArrayList<Person>();
    
  }

  //setter

       public void addPerson(Person guest) {
    people.add(guest);    //adds person  
  }
  public void assignPerson(int tableNum){ //assigns table and seat to person
    for (int i = 0; i < people.size(); i++){
      people.get(i).setTable(tableNum);
      people.get(i).setSeat(i+1);
    }
  }

  //getter
  public Person getPerson(int index){
    return people.get(index);
  }
  public int getSize() {
    return people.size();
  }
  public void printPeople(){ //prints name, company, and seat of guest
    for(Person guest: people){
      System.out.println(guest.getName() + "(" +       compNames[guest.getcompId()] + ") -> Seat " + guest.getSeat());
    }
  }
public int find(String fName, String lName){ //in people array finds name and seat of person
    for (Person guest: people){
      if (guest.getName().equals(fName + " " + lName)){
        return guest.getSeat(); //seat num  
      }    
    }
    return -1;
  }
}
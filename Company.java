import java.util.ArrayList;

public class Company {

  /**
  *Avi Mahajan
  * 1/20/22 
  * The purpose of this class is to add people to person array and check that there is space to add more people
  */

  private ArrayList<Person> people; //instance variables
  String name;

   
  public Company (String name) { //constructor

     people = new ArrayList<Person>();
     this.name = name;
    
  } 

  //setter

   public void addPerson(String name,int compId) {    //add person to people array 
          people.add(new Person(name, compId));
  }

  //getter
  public String getName(){ 
    return name;
  }
  public boolean availableSpace(){ //checks to make sure not more than 9 people in company so another person can be added
    if(people.size() < 10){
      return true;
    }
    return false;
  }
        public int getSize(){
    return people.size();
  }
       public Person getPerson(int index){ //gets Person at an index
          return people.get(index);
  }
  
}
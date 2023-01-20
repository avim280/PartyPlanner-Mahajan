public class Person {

  /**
  *Avi Mahajan
  * 1/20/22 
  * The purpose of this class is to get names and IDs of people in the arrayList as well as setting their tables and seats
 */
  
  //class variables
  private String name;
  private int compId;

  private int table;
  private int seat;
  //constructor
    public Person(String name, int compId) {

    this.name = name;
    this.compId = compId;
  }

  //setters
  public void setTable(int num) {
    table = num;
  }
  public void setSeat(int num){
      seat = num;
  }
  // getters

  public String getName() {
    return name;
  }
  public int getcompId() {
    return compId;
  }

  public int getTable() {
    return table;
  }

  public int getSeat(){
    return seat;
  }
  
}
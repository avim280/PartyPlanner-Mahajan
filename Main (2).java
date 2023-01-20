import java.util.Scanner;



class Main {

  /**
  *Avi Mahajan
  * 1/20/22 
  * The purpose of this class is to run all the methods-takes input and adds info and prints tables
  */
  
  public static void main(String[] args) {
       Party p1 = new Party(); //cal to constructor
    p1.loadCompanies("companies.txt"); //method call- loads company names

      System.out.println("Would you like to load names.txt? (Y/N)"); //ask user if they want to see who will be at each table
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    if (input.equals("Y") || input.equals("y")){ //not case sensitive
      p1.loadNames("names.txt"); //method call- sorts each person in correct company
    }
    System.out.println("Would you like to add a person? (Y/N)"); //registration
    input = scan.nextLine();
    while(input.equals("Y") || input.equals("y")){
      System.out.println("First Name: ");
        String firstName = scan.nextLine();
        System.out.println("Last Name: ");
       String lastName = scan.nextLine();
      System.out.println("Company Number: ");
         int compNum = scan.nextInt();
        String temp = scan.nextLine(); //Buffer
         p1.addName(firstName + " " + lastName, compNum); //adds person to companyList array
      System.out.println("Would you like to add another person? (Y/N)");
         input = scan.nextLine();
    }

      p1.arrange(); //method call- assigns people to table
  p1.displayTables(); //method call- prints table
    p1.findPerson("Ebony", "Ramirez"); //method call- find table and seat of person
    p1.findPerson("Avi", "Mahajan");

    
  }
}
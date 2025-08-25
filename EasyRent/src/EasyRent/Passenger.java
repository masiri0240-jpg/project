/*Name:Sarah Abdullah Alzahrani
ID:2312065
Section:IIS
*/
package IIS2312065P1_EasyRent;

public class Passenger {
   private String passportNumber;
   private String name;
   //The Constructor
   public Passenger (String passportNumber,String name){
       this.passportNumber=passportNumber;
       this.name=name;}
    //getter and setter method
     public String getPassportNumber(){
         return passportNumber;
     }
     public String getName(){
         return name;
     }  
      
     public void setPassportNumber(String passportNumber){
         this.passportNumber=passportNumber;
     }
    public void setName(String name){
        this.name=name;
    } 
    public void updateDetails(String newName){
         this.name=name;
        
    }
    public String toString(){
        return ("passportNumber=" + passportNumber + ", name=" + name );
            
        }
   }
    


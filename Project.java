import java.util.Scanner;
public class Project{
     
   public static void main(String[] args){
      Scanner s=new Scanner(System.in);
      String pin;
      boolean invalid;
      //Validating the PIN
      do {
         System.out.println("Enter PIN:");
         pin= s.nextLine();
         invalid=(pin.charAt(0)=='0'
         ||(pin.length()!=4)
         ||(pin.charAt(0)<'0'||pin.charAt(0)>'9')
         ||(pin.charAt(1)<'0'||pin.charAt(1)>'9')
         ||(pin.charAt(2)<'0'||pin.charAt(2)>'9')
         ||(pin.charAt(3)<'0'||pin.charAt(3)>'9'));
         if (invalid)
         System.out.println("Invalid PIN");

      }while(invalid);
         System.out.println("PIN set");
         
    //Displaying the menu
      String task;
      String origin=null;
      String code=null;
      String input=null;
 
      do{   
          System.out.println("1. Set/Change the key\n2. Display the key\n3. Enter a sentence\n"
          +"4. Display the current sentence\n5. Encrypt the sentence and display it\n"+
          "6. Decrypt the sentence and display it\n7. Exit the system\n");
          System.out.println("Enter a task number from the menu:");
          
          task=s.next();
         //Performing the tasks
          switch(task){
             case "1": 
                 { System.out.println("Enter the PIN");
                 String keyPin=s.next();
                 if(pin.equals(keyPin)){
                    System.out.println("For setting or changing the key, enter two words:");
                    origin=s.next();
                    code=s.next();
                    int searchIndex=0;
                    if(origin.length()==code.length()){
                       while(searchIndex<origin.length()){
                        if((origin.indexOf(code.charAt(searchIndex)))== -1){
                           System.out.println("Invalid key, Try Again");
                           origin=null;
                           code=null;
                           break;
                        }searchIndex++; 
                       }
                    }
                  else{
                      System.out.println("Invalid key, Try again");
                      origin=null;
                      code=null;
                  }
                  }
             else{
             System.out.println("PIN dismatched");
             }
            }
            break;
            case "2":
            {
             if(origin !=null || code !=null){
               System.out.println("Enter PIN");
               String keyPin=s.next();
               if(keyPin.equals(pin))
                    System.out.println("The origin is "+ origin+" and the code is "+code+"\n");
               else 
                    System.out.println("PIN dismatched");
             }
             else if(origin ==null || code ==null)
                System.out.println("You need to set the key first\n");
             else
                System.out.println("PIN dismatched");
             }
            break;
            case "3":
            {
                System.out.println("Enter a sentence :");
                s.nextLine();
                input=s.nextLine();
                System.out.println("Sentence set");
             }
            break;
            case "4":
            {
              if(input !=null)
              System.out.println("Your current sentence is: "+input+"\n");
              else
              System.out.println("You haven't entered a sentence yet!");
            }
           break;
           //Encrypt the sentence 
           case "5":
           {
             if (origin!=null && code!=null){ 
               if (input!=null){
                   String encrypte="";
                   for (int i=0; i<input.length();i++){
                        char c= input.charAt(i);
                        int index= origin.indexOf(c);
                        if( index !=-1)
                            encrypte +=code.charAt(index);
                        else encrypte +=c;}          
                            input=encrypte;
                System.out.println("Encrypted sentence: "+input);
         
              }
              else System.out.println("Sentence not set yet");
            }
            else System.out.println("key not set yet");
           }
          break;
          case "6":
          {
            if (origin!=null && code!=null){ 
               if (input!=null){
               String decrypte="";
               for (int i=0; i<input.length();i++){
                  char c= input.charAt(i);
                  int index= code.indexOf(c);
                  if( index !=-1)
                     decrypte +=origin.charAt(index);
                  else decrypte +=c;}
                     input=decrypte;
                  System.out.println("Decrypted sentence: "+input);
                }
                else System.out.println("Sentence not set yet");
            }
            else System.out.println("key not set yet");
          } 
          
         break;
         case "7": System.out.println("Thank you, good bye.");
         break;
         
         default:
         {
           System.out.println("Invalid option! Please enter a number between 1 and 7 ");
         }
        
        }
      } while(task.equals("7")!=true);
   }
}



package testclasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest
{
   public static void main(String [] args)
   {
       serialize();
       deserialize();
   }
   
   public static void serialize()
   {
      Employee e = new Employee();
      e.name = "Reyan Ali";
      e.address = "Phokka Kuan, Ambehta Peer";
      e.SSN = 11122333;
      e.number = 101;
      
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("/Temp/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /Temp/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
   
   public static void deserialize()
   {
      Employee e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("/Temp/employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("SSN: " + e.SSN);
      System.out.println("Number: " + e.number);
    }
}

class Employee implements java.io.Serializable
{
   public String name;
   public String address;
   public transient int SSN; // transient ==> not included in serialization
   public int number;
   
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}

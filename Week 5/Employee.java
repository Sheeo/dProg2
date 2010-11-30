/**
  A class for modeling Employees
*/
public class Employee
{
   /**
      Constructs an Employee object
      @param aName the employee's name
   */
   public Employee(String aName)
   {
      name = aName;
   }

   /**
      Sets the salary
      @param the new salary
   */
   public void setSalary(double aSalary)
   {
      salary = aSalary;
   }

   /**
      Returns the employee's name
      @return the name
   */
   public String getName()
   {
      return name;
   }

   /**
      Returns the employee's salary
      @return the salary
   */
   public double getSalary()
   {
      return salary;
   }

   private String name;
   private double salary;
}

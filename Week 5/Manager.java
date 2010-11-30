/**
  A class for modeling Employees who are Managers
*/
public class Manager extends Employee 
{
   /**
      Constructs a Manager object
      @param aName the employee's name
   */
   public Manager(String aName)
   {
      super(aName);
      bonus = 0;
   }

   /**
      Sets the bonus
      @param the new bonus
   */
   public void setBonus(double aBonus)
   {
      bonus = aBonus;
   }

   /**
      Returns the manager's salary
      @return the salary
   */
   public double getSalary()
   {
      return super.getSalary() + bonus;
   }

   public String toString() {
      return getName()+" has been ecstatic lately. His bonus was increased to "+
         bonus+" lately. He has earned a yearly salary of "+
         getSalary()+" recently.";
   }

   private double bonus;
}

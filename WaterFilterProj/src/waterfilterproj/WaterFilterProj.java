package waterfilterproj;
import java.util.Scanner;

public class WaterFilterProj 
{
    public static void main(String[] args) 
    {
        int choice=0;
        Scanner scan= new Scanner(System.in);
        
        System.out.println("Welcome to the Water Pitcher Program. Please enter the make, color, max capacity, and filter life of your desired water pitcher.");
        String make = scan.next();
        String color = scan.next();
        double maxCapacity = scan.nextDouble();
        double filterLife= scan.nextDouble();
        
        WaterFilterPitcher pitcher=new WaterFilterPitcher(make, color, maxCapacity, filterLife);
        
        while(choice!=5)
        {
            System.out.println("Please enter the corresponding number for which action you would like to perform.");
            System.out.println("1. Fill the pitcher");
            System.out.println("2. Pour some water out");
            System.out.println("3. Empty the pitcher");
            System.out.println("4. Check the status of the filter");
            System.out.println("5. Quit");
            choice=scan.nextInt();
            
            switch(choice)
            {
                case 1:
                    System.out.println("Please enter the amount of liters you would like to add to the pitcher.");
                    double liter=scan.nextDouble();
                    boolean fillSuccess=pitcher.fill(liter);
                    
                    if(fillSuccess)
                        System.out.println("Water has been added. The pitcher currently has: "+pitcher.getCurWaterAmount()+" liters of water.");
                    else
                        System.out.println("Pitcher has overflown with water! oops. The pitcher now has: "+pitcher.getCurWaterAmount()+" liters of water.");
                    break;
                    
                case 2:
                    System.out.println("Please enter the amount of water you would like to pour.");
                    double pourAmt =scan.nextDouble();
                    boolean pourSuccess = pitcher.pour(pourAmt);
                    
                    if(pourSuccess)
                        System.out.println("Water has been poured. The pitcher currently has: "+pitcher.getCurWaterAmount()+" liters of water.");
                    else
                        System.out.println("Not enough water to pour.");
                    break;
                    
                case 3:
                    pitcher.empty();
                    System.out.println("The pitcher has been emptied.");
                    break;
                    
                case 4:
                    boolean isFine = pitcher.checkFilter();
                    
                    if(isFine)
                        System.out.println(pitcher.getFilterLife()+ " life remaining on the filter, still good!");
                    else
                        System.out.println(pitcher.getFilterLife()+ " life remaining, time to replace the filter.");    
                    break;
                    
                case 5:
                    break;
                    
                default:
                    System.out.println("invalid command please input a number between 1-5");          
            }
        }
        System.out.println("Thank you for using the Water Pitcher program.");
    }
    
}

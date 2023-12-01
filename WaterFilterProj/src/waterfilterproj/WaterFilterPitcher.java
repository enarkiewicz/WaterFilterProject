//Author: Ethan Narkiewicz
package waterfilterproj;

public class WaterFilterPitcher 
{
    private String make;
    private String color;
    private double totalCapacity;
    private double curWaterAmount;
    private double filterLife;
    private double curFilterUsage;
    private final double litersPerFilterLifeUnit=100.0;
    
    public WaterFilterPitcher(String initMake, String initColor, double initTotalCapacity, double initFilterLife)
    {
        make = initMake;
        color= initColor;
        totalCapacity = initTotalCapacity;
        filterLife=initFilterLife;
        curFilterUsage=0;
        curWaterAmount=0;
    }
    
    public String getMake()
    {
        return make;
    }

    public void setMake(String make) 
    {
        if(!make.equals(""))
            this.make = make;
    }

    public String getColor() 
    {
        return color;
    }

    public void setColor(String color) 
    {
        if(!color.equals(""))
            this.color = color;
    }

    public double getTotalCapacity() 
    {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) 
    {
        if(totalCapacity>0)
            this.totalCapacity = totalCapacity;
    }

    public double getCurWaterAmount() 
    {
        return curWaterAmount;
    }

    public void setCurWaterAmount(double curWaterAmount) 
    {
        if(curWaterAmount>=0&&curWaterAmount<=totalCapacity)
            this.curWaterAmount = curWaterAmount;
    }

    public double getFilterLife() 
    {
        
        return filterLife;
    }

    public void setFilterLife(double filterLife) 
    {
        if(filterLife>=0)
            this.filterLife = filterLife;
    }

    public double getCurFilterUsage() 
    {
        return curFilterUsage;
    }
    
    public void setCurFilterUsage(double curFilterUsage) 
    {
        if(curFilterUsage>=0)
            this.curFilterUsage = curFilterUsage;
    }
    
    public boolean fill(double liters)
    {
        boolean success =false;
        if(liters>0.0&&getCurWaterAmount()+liters<=getTotalCapacity())
        {
            setCurWaterAmount(getCurWaterAmount() + liters);
            setCurFilterUsage(getCurFilterUsage() + liters/litersPerFilterLifeUnit);
            success=true;
        }
        
        else
        {
            setCurFilterUsage(getCurFilterUsage() + liters/litersPerFilterLifeUnit);
            setCurWaterAmount(totalCapacity-getCurWaterAmount());
        }
        
        return success;
    }
    
    public boolean pour(double liters)
    {
        boolean success=false;
        
        if(liters>0&&getCurWaterAmount()-liters>=0)
        {
            setCurWaterAmount(getCurWaterAmount() - liters);
            success=true;
        }
        
        return success;
    }
    
    public void empty()
    {
        setCurWaterAmount(0);
    }
    
    public boolean checkFilter()
    {
        boolean isFine = true;
        if(getCurFilterUsage()>filterLife*0.5)
            isFine=false;
        
        return isFine;
    }
    
    public String toString()
    {
        String info="Make: "+getMake()+"\nColor: "+getColor()+"\nTotal Capacity: "+getTotalCapacity()+"\nCurrent water amount: "+getCurWaterAmount()+"\nFilter life: "+getFilterLife()+"\nCurrent filter usage: "+getCurFilterUsage()+"\nLiters per filter life unit"+litersPerFilterLifeUnit;
        return info;
    }
}

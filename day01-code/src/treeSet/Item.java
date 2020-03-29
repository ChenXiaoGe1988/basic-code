package treeSet;
import java.util.*;


public class Item implements Comparable<Item>{
    private String description;//描述信息
    private int partNumber;//部件编号

    /**
     * Constructs an item
     * 构造器
     */
    public Item(String aDescription,int aPartNumber) {
        description=aDescription;
        partNumber=aPartNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    /**
     * 打印方法
     */
    public String toString() {
        return "[description=" +description+",partNumber="+partNumber+"]";
    }


    /**
     * @param otherObject
     * @return
     */
    public boolean equals(Object otherObject)
    {
        if (this==otherObject) return true;
        if (otherObject==null) return false;
        if (getClass()!=otherObject.getClass()) return false;
        Item other=(Item)otherObject;
        return  Objects.equals(description,other.description)&&partNumber==other.partNumber;
    }
    public int hashCode()
    {
        return  Objects.hash(description,partNumber);
    }

    /**
     *
     * @param other
     * @return
     */
    public  int compareTo(Item other)
    {
        int diff=Integer.compare(partNumber,other.partNumber);
        return diff!=0?diff:description.compareTo(other.description);
    }
}

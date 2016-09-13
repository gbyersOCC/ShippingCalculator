package edu.orangecoastcollege.cs273.gbyers.shippingcalculator;

/**
 * Created by grant on 9/12/2016.
 */
public class ShipItem {

    private double mBaseCost;
    private double mAddedCost;
    private double mWeight;
    private double mTotal;



    public ShipItem(){
        mWeight = 0.0;
        mAddedCost = 0.0;
        mBaseCost = 3.0;
        mTotal = 0.0;

    }

    public double getAddedCost() {
        if(mWeight>0 && mWeight <=16){
            mAddedCost = 0.0;
        }else{
            double remainingWeight = mWeight - 16;
            if(remainingWeight % 4 != 0)
            {
                mAddedCost+=.50;
            }
            int divisor = (int) (remainingWeight/4.0);
            mAddedCost+= divisor *.50;
        }
        return mAddedCost;
    }



    public double getBaseCost() {
        return mBaseCost;
    }

    public double getWeight() {
        return mWeight;
    }
    public double getTotal() {
        mTotal = mBaseCost + mAddedCost;
        return mTotal;
    }
    public void setWeight(double weight)
    {
        mWeight = weight;

    }

}

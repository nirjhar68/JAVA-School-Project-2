
import java.util.*;

public class Bank {
	  int bankID;                              // Main Balance of the Bank
	     double bankBalance;
	     
	     int numBankloned;						// Assign the number of bank loaned, id and amount
	     int[] loanedBankID;
	     double[] loanAmount;
	     
	     double totalAsset;					// totalAsset of that bank
	    
	    Bank()
	    {
	        bankID = 0;
	        bankBalance = 0;
	        numBankloned = 0;
	        totalAsset = 0;
	        loanedBankID = new int[0];
	        loanAmount = new double[0];
	    }

	    public int getNumBankLoaned()
	    {
	        return numBankloned;
	    }

	    public int getBankID()
	    {
	        return bankID;
	    }

	    public double getTotalBalance()
	    {
	        return totalAsset;
	    }

	    public double getBalance()
	    {
	        return bankBalance;
	    }
	    
	    public void setId(int id)
	    {
	        bankID = id;
	    }
	    
	    public void setBalance(double temp)
	    {
	        bankBalance=temp;
	    }

	    public void setBalance2(double temp)
	    {
	        bankBalance+=temp;
	    }
	    
	    public void setNumBankLoaned(int temp)
	    {
	        numBankloned = temp;
	        loanedBankID = new int[temp];
	        loanAmount = new double[temp];
	    }

	    public void setLonedBankID(int num,int id)
	    {
	    	loanedBankID[id] = num;
	    }

	    public void setloanAmount(double amount,int id)
	    {
	    	loanAmount[id] = amount;
	    }

	    public void setTotalAsset(double temp)
	    {
	        bankBalance = bankBalance - temp;
	    }
	

}

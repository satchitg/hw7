
import java.util.*;
//Exception when number of transactions exceed a certain limit 
class Inter_bank extends Exception
{
	private float detail;
	
	Inter_bank(float a )
	{
		detail=a;
	}
	public String toString()
	{
		return "The number of transactions exceed 3";
	}
	
}
//Exception if money to be withdrawn is greater than money in the person's account 
class Insufficient_balance extends Exception
{
	private float detail;
	Insufficient_balance(float a)
	{
		detail=a;
	}
	public String toString()
	{
		return "The balance becomes negative";
	}
}
//Exception if the person enters a wrong pin
class Wrong_Pin extends Exception
{
	private float detail;
	Wrong_Pin(float a)
	{
		detail=a;
	}
	public String toString()
	{
		return "The user has entered wrong pin" ;
	}
}
//Exception, if person enters an amount which is not a multiple of 100,500 and 2000
class Wrong_Multiple extends Exception
{
	private float detail;
	Wrong_Multiple(float a)
	{
		detail=a;
	}
	public String toString()
	{
		return "The user has entered wrong amount(not a multiple of 100, 500 or 2000)" ;
	}
}
//Exception, if the person tries to acces an unavailable option
class Invalid_Option extends Exception
{
	private float detail;
	Invalid_Option(float a)
	{
		detail=a;
	}
	public String toString()
	{
		return "The user has entered an Invalid Option" ;
	}
}
//exception, if person tries to enter negative amount
class Invalid_Amount extends Exception
{
	private float detail;
	Invalid_Amount(float a)
	{
		detail=a;
	}
	public String toString()
	{
		return "The user has entered an Invalid Amount(negative)" ;
	}
}


public class ATM {

	float curr,dep=0;
	float with=0;
	//A function to implement the withdrawal procedure with appropriate exception throwing
	void withdraw(float with) throws Invalid_Amount, Wrong_Multiple, Insufficient_balance
	{
		   //If negative amount entered
			if(with<0)
			{	throw new Invalid_Amount(with);
			}
			//If amount not a standard multiple
			if(with%100 !=0)
			{	throw new Wrong_Multiple(with);
			}
			//If not sufficient funds to issue amount asked for
			if(curr-with<0)
			{	throw new Insufficient_balance(with);
			}
			
           curr= curr-with;		
           
	}
	void deposit(float dep) throws Invalid_Amount
	{
		//if negative amount entered
		if(dep<0)
		{
			throw new Invalid_Amount(dep);
		}
		else
			curr=curr+dep;
		
	}
	void current()
	{
		//Displaying current amount
		System.out.println("The current balance is: "+curr);
	}
	
	public static void main(String[] args)
	{try
	{
		ATM a1=new ATM();int ch;
		float money=0;
		int count=0;
		while(true)
		{count++;
		if(count==4)
		{
			throw new Inter_bank(4);
			//break;
		}
			System.out.println("Enter a choice");
			System.out.println("1. View Current Balance");
			System.out.println("2. Deposit money");
			System.out.println("3. Withdraw money");
			Scanner input= new Scanner(System.in);
			
			ch=input.nextInt();
			//implementing the menu driven program of a standard ATM
			switch(ch)
			{
			case 1:
				a1.current();
				break;
			case 2:
				System.out.println("Enter amount to be deposited:");
				money=input.nextFloat();
				a1.deposit(money);
				break;
			case 3:
				System.out.println("Enter amount to be withdrawn:");
				money=input.nextFloat();
				a1.withdraw(money);
				break;
			default:
				throw new Invalid_Option(4);
				
			}
		}
	//Catching all the exceptions thrown below:  
	}
	catch(Inter_bank e)
	{
		System.out.println("Caught: "+e);
	}
	catch(Insufficient_balance e)
	{
		System.out.println("Caught: "+e);
	}
	catch(Invalid_Amount e)
	{
		System.out.println("Caught: "+e);
	}
	catch(Wrong_Multiple e)
	{
		System.out.println("Caught: "+e);
	}
	catch(Invalid_Option e)
	{
		System.out.println("Caught: "+e);
	}
  }
}

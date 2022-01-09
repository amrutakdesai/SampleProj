package Webdriver.ScreenshotAndJavascript;

import java.util.Scanner;

public class PrimeNumCheck {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number->");
		int num=sc.nextInt();
		sc.close();
		int i;
		
		if(num==1)
		{
			System.out.println("Smallest prime number is 2");
		}
		for(i=2;i<num;i++)
		{
			if(num%i==0)
			{
				System.out.println("Number is not prime->"+num);
				break;
			}
			
		}
		if(num==i)
		{
			System.out.println("Number is prime->"+num);
		}
	}
}
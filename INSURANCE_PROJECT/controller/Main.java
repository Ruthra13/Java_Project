package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import businessLogic.Validation;
import model.Login;

public class Main {
	
	public static void main(String args[]) throws Exception
	
	{
		int choice;
		System.out.println("*----------------------------------------*");
		System.out.println("        INSURANCE SYSTEM                  ");
		System.out.println("*----------------------------------------*");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String username,password;
		
		//object creation 
		AdminProcess ap = new AdminProcess();
		Process pro = new Process();
		Validation validate = new Validation();
		Login log = null;
		
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			choice = Integer.parseInt(br.readLine());	
			switch(choice)
			{
			case 1:
				System.out.println("Enter the username: ");
				username = br.readLine();
				System.out.println("Enter the password: ");
				password = br.readLine();
				log = new Login(username,password);
				if(validate.checkAdminLogin(log))
				{
					System.out.println("Login successful");
					System.out.println("*----------------------------------------*");
					ap.admin();
				}
				else
					System.out.println("Check your username and password");
				    System.out.println("*----------------------------------------*");
				break;
				
				
				case 2:
				System.out.println("Enter the username");
				username = br.readLine();
				System.out.println("Enter the password");
				password = br.readLine();
				log = new Login(username,password);
				if(validate.checkAgentLogin(log))
				{
					System.out.println("Login successful");
					System.out.println("*----------------------------------------*");
					pro.customer();
					
				}
				else
					System.out.println("Check your username and password");
				    System.out.println("*----------------------------------------*");
				break;
				
				case 3:
				System.out.println("You have chosen exit option ");
				break;
			
			default:
				System.out.println("Choose the correct option!!");
				break;	
			}
	}while(choice>0 && choice<3);

	}
}
	

package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdminProcess {

	public void admin() throws Exception {
		int choice;
		Process pro = new Process();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.println("Which one you want to access");
		System.out.println("1.Agent");
		System.out.println("2.Customer");
		System.out.println("3.Exit");
		System.out.println("*----------------------------------------*");
		choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1: 
			pro.agent();
			break;
		case 2:
			pro.customer();
			break;
		case 3:
			System.out.println("You have exited");
			break;
		default:
			System.out.println("Wrong choice");
			break;
		
		}
		}while(choice>0 && choice<3);
	}

}

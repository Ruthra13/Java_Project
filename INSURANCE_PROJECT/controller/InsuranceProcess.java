package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.InsuranceOperation;
import model.*;

public class InsuranceProcess {
	//declaring the common variables
	String policyno,installment_type,startDate,endDate;
	double premium_amt,amount_covers;
	//int choice;
	SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	java.util.Date start_date,end_date;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//Object Creation
	InsuranceOperation io = new InsuranceOperation();
	
	public void insuranceDetails(int id) throws NumberFormatException, IOException, ParseException {
		int choice = 0;
		int cid = id;
		do
		{
		System.out.println("1.Life Insurance");
		System.out.println("2.Medical Insurance");
		System.out.println("3.Home Insurance");
		System.out.println("4.Motor Insurance");
		System.out.println("5.Travel Insurance");
		System.out.println("6.Exit");
		try {
		choice = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			
		}
		switch(choice)
		{
		case 1:
			common();
			LifeInsurance li = new LifeInsurance(policyno,premium_amt,amount_covers,installment_type,start_date,end_date);
			li.setCid(cid);
			io.insertLife(li);
			break;
		case 2:
			common();
			System.out.println("Enter the dependent name: ");
			String dependentName = br.readLine();
			System.out.println("Enter the dependent Age: ");
			int dependentAge = Integer.parseInt(br.readLine());
			System.out.println("Enter the dependent relationship: ");
			String dep_Relationship = br.readLine();
			MedicalInsurance me= new MedicalInsurance(policyno,premium_amt,amount_covers,installment_type,start_date,end_date);
			me.setDependentName(dependentName);
			me.setDependentAge(dependentAge);
			me.setDep_Relationship(dep_Relationship);
			me.setCid(cid);
			io.insertMedical(me);
			break;
		case 3:
			common();
			System.out.println("Enter the document number: ");
			String docNo = br.readLine();
			System.out.println("Enter the Owner Name: ");
			String name = br.readLine();
			System.out.println("Enter the house Address: ");
			String address = br.readLine();
			HomeInsurance home= new HomeInsurance(policyno,premium_amt,amount_covers,installment_type,start_date,end_date);
			home.setDocNo(docNo);
			home.setName(name);
			home.setAddress(address);
			home.setCid(cid);
			io.insertHome(home);
			break;
		case 4:
			common();
			System.out.println("Enter the register no: ");
			String regNo = br.readLine();
			System.out.println("Enter the Vehicle type: ");
			String vehicleType = br.readLine();
			System.out.println("Enter the Owner Name: ");
			String owner_name = br.readLine();
			System.out.println("Enter the Vehicle No: ");
			String vehicleNo = br.readLine();
			MotorInsurance motor= new MotorInsurance(policyno,premium_amt,amount_covers,installment_type,start_date,end_date);
			motor.setRegNo(regNo);
			motor.setOwner_name(owner_name);
			motor.setVehicleNo(vehicleNo);
			motor.setCid(cid);
			motor.setVehicleType(vehicleType);
			io.insertMotor(motor);
			break;
		case 5:
			common();
			String lug_covers= " ";
			System.out.println("Enter the travel type: ");
			String travel_type = br.readLine();
			System.out.println("Do you want to insure your luggage: (Y/N)");
			char luggage = (char) br.read();
			if(luggage == 'Y' || luggage == 'y')
			{
			lug_covers = "Yes";
			}
			else if(luggage == 'N' || luggage == 'n')
			{
			lug_covers = "No";
			}
			else
			{
				lug_covers = "No";
			}
			TravelInsurance travel = new TravelInsurance(policyno,premium_amt,amount_covers,installment_type,start_date,end_date);
			travel.setTravel_type(travel_type);
			travel.setCid(cid);
			travel.setLuggage_covers(lug_covers);
			try {
			io.insertTravel(travel);
			}
			catch(Exception e)
			{
				System.out.println("Error at travel"+e);
			}
			break;
		case 6:
			System.out.println("You have exited!!");
			break;
		default:
			 System.out.println("You have exited");
			 break;
		}
		}while(choice>0 && choice<5);
	}
	public void common() throws IOException, ParseException
	{	
		System.out.println("Enter the policy No: ");
		policyno = br.readLine();
		System.out.println("Enter the premium amount: ");
		premium_amt = Double.parseDouble(br.readLine());
		System.out.println("Enter the amount covers: ");
		amount_covers = Double.parseDouble(br.readLine());
		System.out.println("Enter the installment type: ");
		installment_type = br.readLine();
		System.out.println("Enter the Start date (dd/mm/yyyy) : ");
		startDate = br.readLine();
		start_date = df.parse(startDate);
		System.out.println("Enter the End date (dd/mm/yyyy) : ");
		endDate = br.readLine();
		end_date =  df.parse(endDate);
		
	}
}

package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.AgentOperation;
import dao.ConvertToPDF;
import dao.CustomerOperation;
import dao.InsuranceOperation;
import model.Agent;
import model.Insurance;
import model.User;

public class Process {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int choice;

	public void agent() throws Exception { 
		int agent_id;
		String name,email,mobile;
		
		//Object Creation
		Agent agent=null ;
		User user=new User();
		AgentOperation ao = new AgentOperation();
		
		do {
			System.out.println("1.ADD AGENT");
			System.out.println("2.UPDATE AGENT");
			System.out.println("3.DELETE A AGENT");
			System.out.println("4.VIEW ALL AGENTS");
			System.out.println("5.EXIT");
			System.out.println("*----------------------------------------*");
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				System.out.println("Enter agent id : ");
				agent_id = Integer.parseInt(br.readLine());
				System.out.println("Enter agent name : ");
				name = br.readLine();
				System.out.println("Enter agent email-id : ");
				email = br.readLine();
				System.out.println("Enter agent mobile number : ");
				mobile = br.readLine();
				agent = new Agent(agent_id,name,email,mobile,user);
				try
				{
					ao.insertAgent(agent);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Error has occured");
				}
				System.out.println("Agent Details are inserted Successfully");
				break;
			case 2:
				System.out.println("Update Agent Details");
				System.out.println("*----------------------------------------*");
				System.out.println("Enter agent id: ");
				agent_id = Integer.parseInt(br.readLine());
				ao.updateAgent(agent_id);
				break;
			case 3:
				System.out.println("Enter the agent id you want to delete");
				agent_id = Integer.parseInt(br.readLine());
				ao.deleteAgent(agent_id);
				System.out.println("*----------------------------------------*");
				break;
			case 4:
				List<Agent> li = new ArrayList<Agent>();
				li = ao.getAllAgent();
				if(li!=null)
				{
					System.out.println("***********AGENT DETAILS*****************");
					System.out.println("*----------------------------------------*");
					System.out.println("ID\t\tAGENT_NAME\t\tEMAIL-ID\t\tMOBILE");
					for(Agent ag:li)
					{
						System.out.println(ag.getId()+"\t\t"+ag.getName()+"\t\t"+ag.getEmail()+"\t\t"+ag.getMobile()+"\t\t");
					}
				}
				else
				{
					System.out.println("There is no agent");
				}
				
				break;
			case 5:
				System.out.println("You have exited!!");
				break;
			default:
				System.out.println("Choose the correct option!!");
				break;
				
			}
		}while(choice>0 && choice<5);
		
	}

	public void customer() throws Exception {
		int id;
		String name,address,email,mobile;
		//Object Creation
		User user = null;
		Insurance insurance= new Insurance();
		CustomerOperation co = new CustomerOperation();
		InsuranceProcess ip = new InsuranceProcess();
		do {
			System.out.println("1.ADD CUSTOMER");
			System.out.println("2.UPDATE CUSTOMER");
			System.out.println("3.DELETE A CUSTOMER");
			System.out.println("4.VIEW ALL CUSTOMER");
			System.out.println("5.ADD INSURANCE TO THE CUSTOMER");
			System.out.println("6.GENERATE PDF FOR YOUR INSURANCE(POLICY)");
			System.out.println("7.UPDTAE INSURANCE");
			System.out.println("8.EXIT");
			System.out.println("*----------------------------------------*");
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				System.out.println("Enter customer id : ");
				id = Integer.parseInt(br.readLine());
				System.out.println("Enter customer name : ");
				name = br.readLine();
				System.out.println("Enter customer address : ");
				address = br.readLine();
				System.out.println("Enter customer email-id : ");
				email = br.readLine();
				System.out.println("Enter customer mobile number : ");
				mobile = br.readLine();
				user = new User(id,name,address,email,mobile,insurance);
				try
				{
					co.insertCustomer(user);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Error has occured");
				}
				System.out.println("Customer details are inserted Successfully");
				break;
			case 2:
				System.out.println("Update Customer Details");
				System.out.println("*----------------------------------------*");
				System.out.println("Enter customer id: ");
				id = Integer.parseInt(br.readLine());
				co.updateCustomer(id);
				break;
			case 3:
				System.out.println("Enter the customer id you want to delete");
				id = Integer.parseInt(br.readLine());
				co.deleteCustomert(id);
				System.out.println("Deleted Successfully");
				System.out.println("*----------------------------------------*");
				break;
			case 4:
				List<User> li_user = new ArrayList<User>();
				li_user = co.getAllCustomers();
				if(li_user!=null)
				{
					System.out.println("***********CUSTOMER DETAILS*****************");
					System.out.println("*----------------------------------------*");
					System.out.println("ID\t\tCUSTOMER_NAME\t\tADDRESS\t\tEMAIL-ID\t\tMOBILE");
					for(User us:li_user)
					{
						System.out.println(us.getId()+"\t\t"+us.getName()+"\t\t"+us.getAddress()+"\t\t"+us.getEmail()+"\t\t"+us.getMobile()+"\t\t");//+us.getInsurance().getPolicyNo());
					}
				}
				else
				{
					System.out.println("There is no agent");
				}
				break;
			case 5:
				System.out.println("*----------------------------------------*");
				System.out.println("Enter the Customer-Id");
				id = Integer.parseInt(br.readLine());
				boolean result = co.checkCustomer(id);
				if(result == true)
				{
				System.out.println("Enter the insurance type you want to add to the customer");
				System.out.println("*----------------------------------------*");
				ip.insuranceDetails(id);
				}
				else
				{
					System.out.println("There is no such Customer");
					System.out.println("*----------------------------------------*");
				}
				break;
			case 6:
				int op;
				String policyno;
				ConvertToPDF pdf = new ConvertToPDF();
				do
				{
					System.out.println("Select Your Insurance type: ");
					System.out.println("1.Life Insurance");
					System.out.println("2.Medical Insurance");
					System.out.println("3.Home Insurance");
					System.out.println("4.Motor Insurance");
					System.out.println("5.Travel Insurance");
					System.out.println("6.Exit");
					op = Integer.parseInt(br.readLine());
					System.out.println("*----------------------------------------*");
				switch(op)
				{
				case 1:
					System.out.println("Enter Your Policy Number: ");
					policyno = br.readLine();
					System.out.println("*----------------------------------------*");
					pdf.ConvertToPdfLife(policyno);
					System.out.println("PDF Generated Successfully");
					break;
				case 2:
					System.out.println("Enter Your Policy Number: ");
					policyno = br.readLine();
					System.out.println("*----------------------------------------*");
					pdf.ConvertToPdfMedi(policyno);
					System.out.println("PDF Generated Successfully");
					break;
				case 3:
					System.out.println("Enter Your Policy Number: ");
					policyno = br.readLine();
					System.out.println("*----------------------------------------*");
					pdf.ConvertToPdfHome(policyno);
					System.out.println("PDF Generated Successfully");
					break;
				case 4:
					System.out.println("Enter Your Policy Number: ");
					policyno = br.readLine();
					System.out.println("*----------------------------------------*");
					pdf.ConvertToPdfMotor(policyno);
					System.out.println("PDF Generated Successfully");
					break;
				case 5:
					System.out.println("Enter Your Policy Number: ");
					policyno = br.readLine();
					System.out.println("*----------------------------------------*");
					pdf.ConvertToPdfTravel(policyno);
					System.out.println("PDF Generated Successfully");
					break;
				case 6:
					break;
				default:
					System.out.println("Enter valid input!!");
					break;
				}
				}while(op>0 && op<6);
				break;
				
			case 7:
				String startDate,endDate,policynumber;
				java.util.Date start_date,end_date;
				//object creation
				Insurance ins = new Insurance();
				InsuranceOperation io = new InsuranceOperation();
				SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
				System.out.println("Enter the policyno: ");
				policynumber = br.readLine();
				System.out.println("Enter the Start date (dd/mm/yyyy) : ");
				startDate = br.readLine();
				start_date = df.parse(startDate);
				System.out.println("Enter the End date (dd/mm/yyyy) : ");
				endDate = br.readLine();
				end_date =  df.parse(endDate);
				ins.setPolicyNo(policynumber);
				ins.setStartDate(start_date);
				ins.setEndDate(end_date);
				io.updateInsurance(ins);
				break;
			case 8:
				System.out.println("You have exited!!");
				break;
			default:
				System.out.println("Choose the correct option!!");
				break;
			}
			
			
		}while(choice>0 && choice<8);
	}
	

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.HomeInsurance;
import model.Insurance;
import model.LifeInsurance;
import model.MedicalInsurance;
import model.MotorInsurance;
import model.TravelInsurance;
import utility.ConnectionManager;

public class InsuranceOperation {

	public void insertLife(LifeInsurance li) {
		try
		{
			Connection con = ConnectionManager.getConnection();
			String sql = "INSERT INTO insurance (policynumber,premium_amount,amount_covers,policy_type,startDate,endDate,cid)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			//setting the values
			st.setString(1,li.getPolicyNo());
			st.setFloat(2, (float) li.getPremium_amount());
			st.setFloat(3,(float) li.getAmount_covers());
			st.setString(4,"Life Insurance");
			//changing date from util to sql 
			java.sql.Date sdate = new java.sql.Date(li.getStartDate().getTime());
			java.sql.Date edate =  new java.sql.Date(li.getEndDate().getTime());
			st.setDate(5, sdate);
			st.setDate(6,edate);
			st.setInt(7, li.getCid());
			//executing the query
			st.executeUpdate();
			//inserting values into life insurance table
			String sql_1 ="INSERT INTO LIFEINSURANCE(INSTALLMENT_TYPE,POLICYNO) VALUES(?,?)";
			PreparedStatement st_1 = con.prepareStatement(sql_1);
			//setting the values
			st_1.setString(1,li.getInsatallmentType());
			st_1.setString(2,li.getPolicyNo());
			//executing the query
			st_1.executeUpdate();
			
			//updating policyno in customer table
			/*String update = "update customer set c_policyno = ? where c_id =?";
			PreparedStatement st_up = con.prepareStatement(update);
			st_up.setString(1,li.getPolicyNo());
			st_up.setInt(2, li.getCid());
			st_up.executeUpdate();*/
			System.out.println("Insurance has been added successfully");
			//Based on the policyno generating pdf report for the insurance
			String policyno = li.getPolicyNo();
			System.out.println("Insurance in pdf");
			ConvertToPDF pdf = new ConvertToPDF();
			pdf.ConvertToPdfLife(policyno);
			System.out.println("PDF Generated Successfully");
			System.out.println("*----------------------------------------*");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arises");
				System.out.println(e.getMessage());
			}
		}

	public void insertMedical(MedicalInsurance me) {
		
		try
		{
			Connection con = ConnectionManager.getConnection();
			String sql = "INSERT INTO insurance (policynumber,premium_amount,amount_covers,policy_type,startDate,endDate,cid)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			//setting the values
			st.setString(1,me.getPolicyNo());
			st.setFloat(2, (float) me.getPremium_amount());
			st.setFloat(3,(float) me.getAmount_covers());
			st.setString(4,"MEDICAL Insurance");
			//changing date from util to sql 
			java.sql.Date sdate = new java.sql.Date(me.getStartDate().getTime());
			java.sql.Date edate =  new java.sql.Date(me.getEndDate().getTime());
			st.setDate(5, sdate);
			st.setDate(6,edate);
			st.setInt(7, me.getCid());
			//executing the query
			st.executeUpdate();
			//inserting values into life insurance table
			String sql_1 ="INSERT INTO MEDICALINSURANCE(DEP_NAME,DEP_AGE,DEP_REL,POLICYNUMBER) VALUES(?,?,?,?)";
			PreparedStatement st_1 = con.prepareStatement(sql_1);
			//setting the values
			st_1.setString(1,me.getDependentName());
			st_1.setInt(2,me.getDependentAge());
			st_1.setString(3,me.getDep_Relationship());
			st_1.setString(4,me.getPolicyNo());
			//executing the query
			st_1.executeUpdate();
			
			//updating policyno in customer table
			/*String update = "update customer set c_policyno = ? where c_id =?";
			PreparedStatement st_up = con.prepareStatement(update);
			st_up.setString(1,me.getPolicyNo());
			st_up.setInt(2, me.getCid());
			st_up.executeUpdate();*/
			
			System.out.println("Insurance has been added successfully");
			//Based on the policyno generating pdf report for the insurance
			String policyno = me.getPolicyNo();
			System.out.println("Insurance in pdf");
			ConvertToPDF pdf = new ConvertToPDF();
			pdf.ConvertToPdfMedi(policyno);
			System.out.println("PDF Generated Successfully");
			System.out.println("*----------------------------------------*");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arises");
				System.out.println(e.getMessage());
			}
		}

	public void insertHome(HomeInsurance home) {
		try
		{
			Connection con = ConnectionManager.getConnection();
			String sql = "INSERT INTO insurance (policynumber,premium_amount,amount_covers,policy_type,startDate,endDate,cid)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			//setting the values
			st.setString(1,home.getPolicyNo());
			st.setFloat(2, (float) home.getPremium_amount());
			st.setFloat(3,(float) home.getAmount_covers());
			st.setString(4,"HOME Insurance");
			//changing date from util to sql 
			java.sql.Date sdate = new java.sql.Date(home.getStartDate().getTime());
			java.sql.Date edate =  new java.sql.Date(home.getEndDate().getTime());
			st.setDate(5, sdate);
			st.setDate(6,edate);
			st.setInt(7, home.getCid());
			//executing the query
			st.executeUpdate();
			//inserting values into life insurance table
			String sql_1 ="INSERT INTO HOMEINSURANCE(DOCNO,NAME,ADDRESS,POLICYNO) VALUES(?,?,?,?)";
			PreparedStatement st_1 = con.prepareStatement(sql_1);
			//setting the values
			st_1.setString(1,home.getDocNo());
			st_1.setString(2,home.getName());
			st_1.setString(3,home.getAddress());
			st_1.setString(4,home.getPolicyNo());
			//executing the query
			st_1.executeUpdate();
			
			//updating policyno in customer table
			/*String update = "update customer set c_policyno = ? where c_id =?";
			PreparedStatement st_up = con.prepareStatement(update);
			st_up.setString(1,home.getPolicyNo());
			st_up.setInt(2, home.getCid());
			st_up.executeUpdate();*/
			System.out.println("Insurance has been added successfully");
			//Based on the policyno generating pdf report for the insurance
			String policyno = home.getPolicyNo();
			System.out.println("Insurance in pdf");
			ConvertToPDF pdf = new ConvertToPDF();
			pdf.ConvertToPdfHome(policyno);
			System.out.println("PDF Generated Successfully");
			System.out.println("*----------------------------------------*");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arises");
				System.out.println(e.getMessage());
			}
	}

	public void insertMotor(MotorInsurance motor) {
		try
		{
			Connection con = ConnectionManager.getConnection();
			String sql = "INSERT INTO insurance (policynumber,premium_amount,amount_covers,policy_type,startDate,endDate,cid)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			//setting the values
			st.setString(1,motor.getPolicyNo());
			st.setFloat(2, (float) motor.getPremium_amount());
			st.setFloat(3,(float) motor.getAmount_covers());
			st.setString(4,"MOTOR Insurance");
			//changing date from util to sql 
			java.sql.Date sdate = new java.sql.Date(motor.getStartDate().getTime());
			java.sql.Date edate =  new java.sql.Date(motor.getEndDate().getTime());
			st.setDate(5, sdate);
			st.setDate(6,edate);
			st.setInt(7, motor.getCid());
			//executing the query
			st.executeUpdate();
			//inserting values into life insurance table
			String sql_1 ="INSERT INTO MOTORINSURANCE(REGNO,OWNER_NAME,VEHICLENO,POLICYNO,VEHICLETYPE) VALUES(?,?,?,?,?)";
			PreparedStatement st_1 = con.prepareStatement(sql_1);
			//setting the values
			st_1.setString(1,motor.getRegNo());
			st_1.setString(2,motor.getOwner_name());
			st_1.setString(3,motor.getVehicleNo());
			st_1.setString(4,motor.getPolicyNo());
			st_1.setString(5,motor.getVehicleType());
			//executing the query
			st_1.executeUpdate();
			//updating policyno in customer table
			/*String update = "update customer set c_policyno = ? where c_id =?";
			PreparedStatement st_up = con.prepareStatement(update);
			st_up.setString(1,motor.getPolicyNo());
			st_up.setInt(2, motor.getCid());
			st_up.executeUpdate();*/
			
			System.out.println("Insurance has been added successfully");
			//Based on the policyno generating pdf report for the insurance
			String policyno = motor.getPolicyNo();
			System.out.println("Insurance in pdf");
			ConvertToPDF pdf = new ConvertToPDF();
			pdf.ConvertToPdfMotor(policyno);
			System.out.println("PDF Generated Successfully");
			System.out.println("*----------------------------------------*");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arises");
				System.out.println(e.getMessage());
			}
	}

	public void insertTravel(TravelInsurance travel) {
		try
		{
			Connection con = ConnectionManager.getConnection();
			String sql = "INSERT INTO insurance (policynumber,premium_amount,amount_covers,policy_type,startDate,endDate,cid)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			//setting the values
			st.setString(1,travel.getPolicyNo());
			st.setFloat(2, (float) travel.getPremium_amount());
			st.setFloat(3,(float) travel.getAmount_covers());
			st.setString(4,"Travel Insurance");
			//changing date from util to sql 
			java.sql.Date sdate = new java.sql.Date(travel.getStartDate().getTime());
			java.sql.Date edate =  new java.sql.Date(travel.getEndDate().getTime());
			st.setDate(5, sdate);
			st.setDate(6,edate);
			st.setInt(7, travel.getCid());
			//executing the query
			st.executeUpdate();
			//inserting values into life insurance table
			String sql_1 ="INSERT INTO TRAVELINSURANCE(TRAVEL_TYPE,POLICYNO,LUGGAGE_COVERS) VALUES(?,?,?)";
			PreparedStatement st_1 = con.prepareStatement(sql_1);
			//setting the values
			st_1.setString(1,travel.getTravel_type());
			st_1.setString(2,travel.getPolicyNo());
			st_1.setString(3,travel.getLuggage_covers());
			//executing the query
			st_1.executeUpdate();
			//updating policyno in customer table
			/*String update = "update customer set c_policyno = ? where c_id =?";
			PreparedStatement st_up = con.prepareStatement(update);
			st_up.setString(1,travel.getPolicyNo());
			st_up.setInt(2, travel.getCid());
			st_up.executeUpdate();*/
			System.out.println("Insurance has been added successfully");
			//Based on the policyno generating pdf report for the insurance
			String policyno = travel.getPolicyNo();
			System.out.println("Insurance in pdf");
			ConvertToPDF pdf = new ConvertToPDF();
			pdf.ConvertToPdfTravel(policyno);
			System.out.println("PDF Generated Successfully");
			System.out.println("*----------------------------------------*");
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception arises");
				System.out.println(e.getMessage());
			}
	}

	public void updateInsurance(Insurance ins) throws Exception {
		Connection con = ConnectionManager.getConnection();
		String sql = "UPDATE INSURANCE SET STARTDATE = ?,ENDDATE = ? WHERE POLICYNUMBER = ?";
		PreparedStatement st = con.prepareStatement(sql);
		java.sql.Date sdate = new java.sql.Date(ins.getStartDate().getTime());
		java.sql.Date edate =  new java.sql.Date(ins.getEndDate().getTime());
		st.setDate(1, sdate);
		st.setDate(2, edate);
		st.setString(3, ins.getPolicyNo());
		boolean result = st.executeUpdate()>0;
		
		if(result==true)
			System.out.println("PolicyNumber: "+ins.getPolicyNo()+ " Updated Successfully");
		else
			System.out.println("Incorrect PolicyNumber");
		con.close();
	
	}
	

}

	
	
	

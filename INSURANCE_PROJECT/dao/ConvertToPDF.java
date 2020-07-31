package dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import utility.ConnectionManager;

public class ConvertToPDF {
	
	public void ConvertToPdfLife(String policyno) throws Exception
	{
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT CUS.C_NAME,INS.POLICYNUMBER,INS.PREMIUM_AMOUNT,INS.AMOUNT_COVERS,INS.STARTDATE,INS.ENDDATE FROM INSURANCE INS INNER JOIN LIFEINSURANCE LINS ON INS.POLICYNUMBER = LINS.POLICYNO "
				+ "INNER JOIN CUSTOMER CUS ON INS.CID = CUS.C_ID WHERE INS.POLICYNUMBER =?";
		
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,policyno);
		ResultSet rs = st.executeQuery();
		
		Document pdf_result = new Document();
		PdfWriter.getInstance(pdf_result,new FileOutputStream("C:\\Users\\Ruthra\\Desktop\\Insurance\\"+policyno+"_LifeInsurance.pdf"));
		pdf_result.open();  
		
		Paragraph p1 = new Paragraph("LIFE INSURANCE \n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p1);
		Paragraph l1 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l1);
		
		while(rs.next())
		{
			String name = rs.getString(1);
			Paragraph c1 = new Paragraph("Name :  "+name+"\n");
			pdf_result.add(c1);
			String policynumber= rs.getString(2);
			Paragraph c2 = new Paragraph("Policy No :  "+policynumber+"\n");
			pdf_result.add(c2);
			double premium_amount = rs.getFloat(3);
			Paragraph c3 = new Paragraph("Premium_amount : "+premium_amount+"\n");
			pdf_result.add(c3);
			double amount_covers = rs.getFloat(4);
			Paragraph c4 = new Paragraph("Amount_covers :  "+amount_covers+"\n");
			pdf_result.add(c4);
			Date start = rs.getDate(5);
			Paragraph c5 = new Paragraph("Start_Date : "+start+"\n");
			pdf_result.add(c5);
			Date end = rs.getDate(6);
			Paragraph c6 = new Paragraph("End_Date : "+end+"\n");
			pdf_result.add(c6);
			
		}
		
		Paragraph l2 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l2);
		Paragraph p2 = new Paragraph("Thank You!");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p2);
		pdf_result.close();
		con.close();
		
		
	}
	
	public void ConvertToPdfMedi(String policyno) throws Exception
	{
		Connection con = ConnectionManager.getConnection();	
		String sql = "SELECT CUS.C_NAME,INS.POLICYNUMBER,INS.PREMIUM_AMOUNT,INS.AMOUNT_COVERS,INS.STARTDATE,INS.ENDDATE,MINS.DEP_NAME,MINS.DEP_REL FROM INSURANCE INS INNER JOIN MEDICALINSURANCE MINS ON INS.POLICYNUMBER = MINS.POLICYNUMBER INNER JOIN "
				+ "CUSTOMER CUS ON INS.CID = CUS.C_ID WHERE INS.POLICYNUMBER =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,policyno);
		ResultSet rs = st.executeQuery();
		
		Document pdf_result = new Document();
		PdfWriter.getInstance(pdf_result,new FileOutputStream("C:\\Users\\Ruthra\\Desktop\\Insurance\\"+policyno+"_MedicalInsurance.pdf"));
		pdf_result.open();
		
		Paragraph p1 = new Paragraph("MEDICAL INSURANCE \n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p1);
		Paragraph l1 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l1);
		
		while(rs.next())
		{
			String name = rs.getString(1);
			Paragraph c1 = new Paragraph("NamEe : "+name+"\n");
			pdf_result.add(c1);
			String policynumber= rs.getString(2);
			Paragraph c2 = new Paragraph("Policy No : "+policynumber+"\n");
			pdf_result.add(c2);
			double premium_amount = rs.getFloat(3);
			Paragraph c3 = new Paragraph("Premium_amount : "+premium_amount+"\n");
			pdf_result.add(c3);
			double amount_covers = rs.getFloat(4);
			Paragraph c4 = new Paragraph("Amount_covers : "+amount_covers+"\n");
			pdf_result.add(c4);
			Date start = rs.getDate(5);
			Paragraph c5 = new Paragraph("Start_Date : "+start+"\n");
			pdf_result.add(c5);
			Date end = rs.getDate(6);
			Paragraph c6 = new Paragraph("End_Date : "+end+"\n");
			pdf_result.add(c6);
			String dep_name = rs.getString(7);
			Paragraph c7 = new Paragraph("Dependent_Name : "+dep_name+"\n");
			pdf_result.add(c7);
			String dep_rel = rs.getString(8);
			Paragraph c8 = new Paragraph("Dependent_Relationship : "+dep_rel+"\n");
			pdf_result.add(c8);
		}
		
		Paragraph l2 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l2);
		Paragraph p2 = new Paragraph("Thank You!");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p2);
		pdf_result.close();
		con.close();
		
		
	}
	
	public void ConvertToPdfHome(String policyno) throws Exception
	{
		Connection con = ConnectionManager.getConnection();	
		String sql = "SELECT CUS.C_NAME,INS.POLICYNUMBER,INS.PREMIUM_AMOUNT,INS.AMOUNT_COVERS,INS.STARTDATE,INS.ENDDATE,HINS.ADDRESS,HINS.DOCNO FROM INSURANCE INS INNER JOIN HOMEINSURANCE HINS ON INS.POLICYNUMBER = HINS.POLICYNO INNER JOIN "
				+ "CUSTOMER CUS ON INS.CID = CUS.C_ID WHERE INS.POLICYNUMBER =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,policyno);
		ResultSet rs = st.executeQuery();
		
		Document pdf_result = new Document();
		PdfWriter.getInstance(pdf_result,new FileOutputStream("C:\\Users\\Ruthra\\Desktop\\Insurance\\"+policyno+"_HomeInsurance.pdf"));
		pdf_result.open();
		
		Paragraph p1 = new Paragraph("HOME INSURANCE \n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p1);
		Paragraph l1 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l1);

		while(rs.next())
		{
			String name = rs.getString(1);
			Paragraph c1 = new Paragraph("Name : "+name+"\n");
			pdf_result.add(c1);
			String policynumber= rs.getString(2);
			Paragraph c2 = new Paragraph("Policy No : "+policynumber+"\n");
			pdf_result.add(c2);
			double premium_amount = rs.getFloat(3);
			Paragraph c3 = new Paragraph("Premium_amount : "+premium_amount+"\n");
			pdf_result.add(c3);
			double amount_covers = rs.getFloat(4);
			Paragraph c4 = new Paragraph("Amount_covers : "+amount_covers+"\n");
			pdf_result.add(c4);
			Date start = rs.getDate(5);
			Paragraph c5 = new Paragraph("Start_Date : "+start+"\n");
			pdf_result.add(c5);
			Date end = rs.getDate(6);
			Paragraph c6 = new Paragraph("End_Date : "+end+"\n");
			pdf_result.add(c6);
			String  address= rs.getString(7);
			Paragraph c7 = new Paragraph("Home_Address : "+address+"\n");
			pdf_result.add(c7);
			String docno = rs.getString(8);
			Paragraph c8 = new Paragraph("Document_No : "+docno+"\n");
			pdf_result.add(c8);
		}
		
		Paragraph l2 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l2);
		Paragraph p2 = new Paragraph("Thank You!");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p2);
		pdf_result.close();
		con.close();
		
		
	}

	public void ConvertToPdfMotor(String policyno) throws Exception {
		Connection con = ConnectionManager.getConnection();	
		String sql = "SELECT CUS.C_NAME,INS.POLICYNUMBER,INS.PREMIUM_AMOUNT,INS.AMOUNT_COVERS,INS.STARTDATE,INS.ENDDATE,MINS.VEHICLETYPE,MINS.REGNO,MINS.VEHICLENO FROM INSURANCE INS INNER JOIN MOTORINSURANCE MINS ON INS.POLICYNUMBER = MINS.POLICYNO INNER JOIN "
				+ "CUSTOMER CUS ON INS.CID = CUS.C_ID WHERE INS.POLICYNUMBER = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,policyno);
		ResultSet rs = st.executeQuery();
		
		Document pdf_result = new Document();
		PdfWriter.getInstance(pdf_result,new FileOutputStream("C:\\Users\\Ruthra\\Desktop\\Insurance\\"+policyno+"_MotorInsurance.pdf"));
		pdf_result.open();
		
		Paragraph p1 = new Paragraph("MOTOR INSURANCE \n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p1);
		Paragraph l1 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l1);
		
		while(rs.next())
		{
			String name = rs.getString(1);
			Paragraph c1 = new Paragraph("Name : "+name+"\n");
			pdf_result.add(c1);
			String policynumber= rs.getString(2);
			Paragraph c2 = new Paragraph("Policy No : "+policynumber+"\n");
			pdf_result.add(c2);
			double premium_amount = rs.getFloat(3);
			Paragraph c3 = new Paragraph("Premium_amount : "+premium_amount+"\n");
			pdf_result.add(c3);
			double amount_covers = rs.getFloat(4);
			Paragraph c4 = new Paragraph("Amount_covers : "+amount_covers+"\n");
			pdf_result.add(c4);
			Date start = rs.getDate(5);
			Paragraph c5 = new Paragraph("Start_Date : "+start+"\n");
			pdf_result.add(c5);
			Date end = rs.getDate(6);
			Paragraph c6 = new Paragraph("End_Date : "+end+"\n");
			pdf_result.add(c6);
			String vehicletype = rs.getString(7);
			Paragraph c7 = new Paragraph("Vehicle_Type : "+vehicletype+"\n");
			pdf_result.add(c7);
			String regno = rs.getString(8);
			Paragraph c8 = new Paragraph("Register_No : "+regno+"\n");
			pdf_result.add(c8);
			String vehicleno = rs.getString(9);
			Paragraph c9 = new Paragraph("Vehicle_No : "+vehicleno+"\n");
			pdf_result.add(c9);
		}
		
		Paragraph l2 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l2);
		Paragraph p2 = new Paragraph("Thank You!");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p2);
		pdf_result.close();
		con.close();
		
	}

	public void ConvertToPdfTravel(String policyno) throws Exception {
		try {
		Connection con = ConnectionManager.getConnection();	
		String sql = "SELECT CUS.C_NAME,INS.POLICYNUMBER,INS.PREMIUM_AMOUNT,INS.AMOUNT_COVERS,INS.STARTDATE,INS.ENDDATE,TINS.TRAVEL_TYPE,TINS.LUGGAGE_COVERS FROM INSURANCE INS INNER JOIN TRAVELINSURANCE TINS ON INS.POLICYNUMBER = TINS.POLICYNO INNER JOIN "
				+ "CUSTOMER CUS ON INS.CID = CUS.C_ID WHERE INS.POLICYNUMBER = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,policyno);
		ResultSet rs = st.executeQuery();
		
		Document pdf_result = new Document();
		PdfWriter.getInstance(pdf_result,new FileOutputStream("C:\\Users\\Ruthra\\Desktop\\Insurance\\"+policyno+"_TravelInsurance.pdf"));
		pdf_result.open();
		
		Paragraph p1 = new Paragraph("TRAVEL INSURANCE \n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p1);
		Paragraph l1 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l1);
		
		while(rs.next())
		{
			String name = rs.getString(1);
			Paragraph c1 = new Paragraph("Name : "+name+"\n");
			pdf_result.add(c1);
			String policynumber= rs.getString(2);
			Paragraph c2 = new Paragraph("Policy No : "+policynumber+"\n");
			pdf_result.add(c2);
			double premium_amount = rs.getFloat(3);
			Paragraph c3 = new Paragraph("Premium_amount : "+premium_amount+"\n");
			pdf_result.add(c3);
			double amount_covers = rs.getFloat(4);
			Paragraph c4 = new Paragraph("Amount_covers : "+amount_covers+"\n");
			pdf_result.add(c4);
			Date start = rs.getDate(5);
			Paragraph c5 = new Paragraph("Start_Date : "+start+"\n");
			pdf_result.add(c5);
			Date end = rs.getDate(6);
			Paragraph c6 = new Paragraph("End_Date : "+end+"\n");
			pdf_result.add(c6);
			String traveltype = rs.getString(7);
			Paragraph c7 = new Paragraph("Travel_Type : "+traveltype+"\n");
			pdf_result.add(c7);
			String luggage_covers = rs.getString(8);
			Paragraph c8 = new Paragraph("Luggage_Covers : "+luggage_covers+"\n");
			pdf_result.add(c8);
			
		}
		
		Paragraph l2 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------\n\n");
		pdf_result.add(l2);
		Paragraph p2 = new Paragraph("Thank You!");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		pdf_result.add(p2);
		pdf_result.close();
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println("error"+ex.getMessage());
		}

		
	}
	

}

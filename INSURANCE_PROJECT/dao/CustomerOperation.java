package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import utility.ConnectionManager;

public class CustomerOperation {
	
	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

	public void insertCustomer(User user) throws Exception {
		try
		{
		Connection con = ConnectionManager.getConnection();
		String sql = "INSERT INTO customer(c_id,c_name,c_address,c_email,c_mobile)VALUES(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user.getId());
		st.setString(2, user.getName());
		st.setString(3, user.getAddress());
		st.setString(4, user.getEmail());
		st.setString(5,user.getMobile());
		st.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception arises");
			System.out.println(e.getMessage());
		}
	}

	public void updateCustomer(int id) throws Exception {
		boolean result;
		Connection con = ConnectionManager.getConnection();
		String sql = "UPDATE customer set c_name = ?,c_address=?,c_email = ?,c_mobile = ? where c_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println("Enter customer name: ");
		String name = br.readLine();
		System.out.println("Enter customer address: ");
		String address = br.readLine();
		System.out.println("Enter customer mailid");
		String mail = br.readLine();
		System.out.println("Enter customer mobile no");
		String mobile = br.readLine();
		
		st.setString(1,name);
		st.setString(2,address);
		st.setString(3, mail);
		st.setString(4, mobile);
		st.setInt(5, id);
		result = st.executeUpdate()>0;
		
		if(result==true)
			System.out.println("Customer_id = "+id+ " Updated Successfully");
		else
			System.out.println("Incorrect Customer id");
		con.close();
		
	}

	public void deleteCustomert(int id) throws Exception {
		Connection con = ConnectionManager.getConnection();
		String sql_1 = "DELETE FROM LIFEINSURANCE WHERE POLICYNO IN (SELECT POLICYNUMBER FROM INSURANCE WHERE CID = ?)";
		String sql_2 = "DELETE FROM MEDICALINSURANCE WHERE POLICYNUMBER IN (SELECT POLICYNUMBER FROM INSURANCE WHERE CID = ?)";
		String sql_3 = "DELETE FROM HOMEINSURANCE WHERE POLICYNO IN (SELECT POLICYNUMBER FROM INSURANCE WHERE CID = ?)";
		String sql_4 = "DELETE FROM MOTORINSURANCE WHERE POLICYNO IN (SELECT POLICYNUMBER FROM INSURANCE WHERE CID = ?)";
		String sql_5 = "DELETE FROM TRAVELINSURANCE WHERE POLICYNO IN (SELECT POLICYNUMBER FROM INSURANCE WHERE CID = ?)";
		String sql_6 = "DELETE FROM INSURANCE WHERE CID = ?";
		String sql_7 = "DELETE FROM CUSTOMER WHERE C_ID = ?";
		PreparedStatement st_1 = con.prepareStatement(sql_1);
		PreparedStatement st_2 = con.prepareStatement(sql_2);
		PreparedStatement st_3 = con.prepareStatement(sql_3);
		PreparedStatement st_4 = con.prepareStatement(sql_4);
		PreparedStatement st_5 = con.prepareStatement(sql_5);
		PreparedStatement st_6 = con.prepareStatement(sql_6);
		PreparedStatement st_7 = con.prepareStatement(sql_7);
		st_1.setInt(1, id);
		st_2.setInt(1, id);
		st_3.setInt(1, id);
		st_4.setInt(1, id);
		st_5.setInt(1, id);
		st_6.setInt(1, id);
		st_7.setInt(1, id);
		st_1.executeUpdate();
		st_1.close();
		st_2.executeUpdate();
		st_2.close();
		st_3.executeUpdate();
		st_3.close();
		st_4.executeUpdate();
		st_4.close();
		st_5.executeUpdate();
		st_5.close();
		st_6.executeUpdate();
		st_6.close();
		st_7.executeUpdate();
		st_7.close();
		
//		String sql_1= "DELETE FROM CUSTOMER where c_id = ?";
//		PreparedStatement st_1 = con.prepareStatement(sql_1);
//		st_1.setInt(1, id);
//		result = st_1.executeUpdate();
//		if(result!=0)
//		{
//			System.out.println("Deleted successfully");
//		}
//		else
//		{
//			System.out.println("Incorrect id");
//		}
		con.close();

	}

	public List<User> getAllCustomers() throws Exception {
		List<User> list = new ArrayList<User>();
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT * FROM CUSTOMER";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			User user = new User();
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			String mail = rs.getString(4);
			String mobile = rs.getString(5);
			//String policyNo = rs.getString(6);
			user.setId(id);
			user.setName(name);
			user.setAddress(address);
			user.setEmail(mail);
			user.setMobile(mobile);
			//in.setPolicyNo(policyNo);
			//user.setInsurance(in);
			list.add(user);
		}
		return list;
		
	}
	
	public boolean checkCustomer(int id) throws Exception
	{
		int flag = 0;
		ResultSet result;
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT *FROM CUSTOMER where c_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		result = st.executeQuery();
		if(result.next())
		{
			flag = 1;
		}
		else
		{
			flag = 0;
		}
		if (flag == 1)
			return true;
		else
			return false;
	}
	

}

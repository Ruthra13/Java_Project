package dao;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Agent;
import utility.ConnectionManager;



public class AgentOperation {
	
	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

	public void insertAgent(Agent agent) throws Exception {
	
		try {
		Connection con = ConnectionManager.getConnection();
		String sql = "INSERT INTO agent(a_id,a_name,a_mail,a_mobile,customer_id)VALUES(?,?,?,?,NULL)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, agent.getId());
		st.setString(2, agent.getName());
		st.setString(3, agent.getEmail());
		st.setString(4,agent.getMobile());
		st.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception arises");
			System.out.println(e.getMessage());
		}
	}

	public void updateAgent(int agent_id) throws Exception
	{
		boolean result;
		Connection con = ConnectionManager.getConnection();
		String sql = "UPDATE agent set a_name = ?,a_mail = ?,a_mobile = ?,customer_id = null where a_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println("Enter agent name: ");
		String name = br.readLine();
		System.out.println("Enter agent mailid");
		String mail = br.readLine();
		System.out.println("Enter agent mobile no");
		String mobile = br.readLine();
		
		st.setString(1,name);
		st.setString(2, mail);
		st.setString(3, mobile);
		st.setInt(4, agent_id);
		result = st.executeUpdate()>0;
		
		if(result==true)
			System.out.println("Agent_id : "+agent_id+ " Updated Successfully");
		else
			System.out.println("Incorrect Agent id");
		con.close();
		
	}

	public void deleteAgent(int agent_id) throws Exception {
		int result;
		Connection con = ConnectionManager.getConnection();
		String sql = "DELETE FROM AGENT where a_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, agent_id);
		result = st.executeUpdate();
		if(result!=0)
		{
			System.out.println("Deleted successfully");
		}
		else
		{
			System.out.println("Incorrect id");
		}
	}
	
	public List<Agent> getAllAgent() throws Exception
	{
		
		List<Agent> list = new ArrayList<Agent>();
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT * FROM AGENT";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Agent agent = new Agent();
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String mail = rs.getString(3);
			String mobile = rs.getString(4);
			agent.setId(id);
			agent.setName(name);
			agent.setEmail(mail);
			agent.setMobile(mobile);
			list.add(agent);
		}
		con.close();
		return list;
	}
	
	
	

}

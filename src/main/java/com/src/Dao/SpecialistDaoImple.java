package com.src.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Specialist;

public class SpecialistDaoImple implements SpecialistDao{
	DaoService dao = new DaoService();

	@Override
	public boolean addSpecialist(String sp) {
boolean f = false;
		
		try {
			
			String sql = "insert into specialist (specialist_name) values(?)";
			PreparedStatement pstmt = dao.getMyPreparedStatement(sql);
		    pstmt.setString(1, sp);
			
			pstmt.executeUpdate();
			
			f = true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Specialist> getAllSpecialist() {
List<Specialist> spList = new ArrayList<Specialist>();
		
		Specialist specialistObj = null;
		
		try {
			
			String sql = "select * from specialist";
			PreparedStatement pstmt = dao.getMyPreparedStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				specialistObj = new Specialist();
				specialistObj.setId(resultSet.getInt(1));
				specialistObj.setSpecialistName(resultSet.getString(2));
				spList.add(specialistObj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return spList;
	}

}

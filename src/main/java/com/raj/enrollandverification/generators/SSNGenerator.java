package com.raj.enrollandverification.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.raj.enrollandverification.constants.AppConstants;

public class SSNGenerator implements IdentifierGenerator {

	private int ssnSequence = 1000;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = AppConstants.INTIAL_SIX_DIGITS;
		String suffix = "";
		try {

			Connection con = session.connection();
			Statement stmt = con.createStatement();
			String sql = "SELECT MAX(ssn) from Citizen_Details";
			ResultSet rs = stmt.executeQuery(sql);
			try {
			if (rs.next()) {
				String maxSSN = rs.getString(1);
				int lastFour = Integer.parseInt(maxSSN.substring(maxSSN.length() - 4));
				suffix = (lastFour + 1) + "";
				System.out.println(suffix);
			}

			}catch (Exception e) {
				
				suffix += ssnSequence;
				System.out.println(suffix);
				ssnSequence += 1;
				System.out.println(ssnSequence);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix + suffix;
	}

}

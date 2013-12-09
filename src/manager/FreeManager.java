package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnection;
import entity.TravelInfo;

public class FreeManager extends HttpServlet {

	TravelInfo ti = new TravelInfo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ti.saveFreeTravel();
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

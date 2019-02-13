package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	/* public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
				statement = connection.createStatement();
				// listar a tol mundo
				String sql = "SELECT * FROM owners";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String telephone = rs.getString("telephone");
					
					System.out.print("Id: "+ id);
					System.out.print(", Nombre: "+ firstName);
					System.out.print(", Apellidos: "+ lastName);
					System.out.print(", Dirección: "+ address);
					System.out.print(", Ciudad: "+ city);
					System.out.print(", Teléfono: "+ telephone + "\n\n");
				}
				// añadirme
				sql = "INSERT INTO owners (first_name, last_name, address, city, telephone)" +
				" VALUES ('Jose', 'Gilibert', 'Ramon y Cajal', 'Sevilla', '617545989')";
				//statement.executeUpdate(sql);
				
				//buscar dueños que coincidan
				sql = "SELECT * FROM owners WHERE first_name LIKE ? OR last_name LIKE ?";
				String busqueda = "Da";
				String termino = "%"+busqueda+"%";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, termino); //nombre
				preparedStatement.setString(2, termino); //apellido
				System.out.print("Coincidencias con "+busqueda+": \n");
				rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					
					System.out.print("Id: "+ id);
					System.out.print(", Nombre: "+ firstName);
					System.out.print(", Apellidos: "+ lastName+"\n");
				}
				
				// añadir owner variable
				/* sql = "INSERT INTO owners (first_name, last_name, address, city, telephone)" +
				" VALUES (?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "Paco"); //nombre
				preparedStatement.setString(2, "Pérez"); //apellido
				preparedStatement.setString(3, "Calle Ruina"); //direccion
				preparedStatement.setString(4, "Madrid"); //ciudad
				preparedStatement.setString(5, "666696969"); //telefono
				preparedStatement.executeUpdate(); 
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	} */

}


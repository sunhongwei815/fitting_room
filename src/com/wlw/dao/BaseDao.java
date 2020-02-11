package com.wlw.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	private final static String URL = "jdbc:mysql://121.251.19.130:3306/fitting_room";
	private final static String USER = "root";
	private final static String PASSWORD = "615615";
	private ThreadLocal<Connection> connectionLocal = new ThreadLocal<Connection>();
	public void excuteUpdate(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		closePreparedStatement(preparedStatement);
		closeConnection(connection);
	}

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void beginThreadTransaction(){
		Connection connection = getCurrentConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		}
	}
	
	public void commitThreadTransaction() {  
		Connection connection = getCurrentConnection();
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("数据库异常");
			}
			throw new RuntimeException("数据库异常");
		}
	}

	public Connection getCurrentConnection(){
		if(connectionLocal.get()==null){
			connectionLocal.set(openConnection());
		}
		return connectionLocal.get();
	}

	public Connection openConnection(){
		Connection connection;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		}
		return connection;
	}
	public void closeThreadConnection(){
		Connection connection = connectionLocal.get();
		if(connection!=null){
			closeConnection(connection);
		}
	}
	
	public void closePreparedStatementAndResultSet(PreparedStatement preparedStatement,ResultSet resultSet){
		closePreparedStatement(preparedStatement);
		closeResultSet(resultSet);
	}
	public void closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
		closeResultSet(resultSet);
		closePreparedStatement(preparedStatement);
		closeConnection(connection);
	}
	public void closePreparedStatement(PreparedStatement preparedStatement){
		try {
			if(preparedStatement!=null&&!preparedStatement.isClosed()){
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		}
	}
	public void closeResultSet(ResultSet resultSet){
		try {
			if(resultSet!=null&!resultSet.isClosed()){
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		}
	}

	public void closeConnection(Connection connection){
		try {
			if(connection!=null&&!connection.isClosed()){
				connection.close();
				connectionLocal.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		}
	}
}

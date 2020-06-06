package com.w2a.utilities;

public class TestConfig {

	public static String server = "smtp.gmail.com";
	public static String from = "shubhamrmrs@gmail.com";
	public static String password = "Sks@12345";
	public static String[] to = { "sks102it@gmail.com", "shubham3297ks@gmail.com" };
	public static String subject = "Extent Project Report";
	//public static String smtp_port = "465 (SSL)/587 (TLS))";
	//public static String TLS = "Required";

	public static String messageBody = "TestMessage";
	public static String attachmentPath = "file:/G:/Mon_May_25_21_28_01_IST_2020jpg";
	public static String attachmentName = "Mon_May_25_21_28_01_IST_2020jpg";

	// SQL DATABASE DETAILS
	public static String driver = "net.sourceforge.jtds.jdbc.Driver";
	public static String dbConnectionUrl = "jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval";
	public static String dbUserName = "sa";
	public static String dbPassword = "$ql$!!1";

	// MYSQL DATABASE DETAILS
	public static String mysqldriver = "com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";

}

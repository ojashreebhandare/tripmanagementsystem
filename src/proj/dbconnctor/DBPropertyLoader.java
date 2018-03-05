package proj.dbconnctor;
import java.io.*;
import java.util.*;

public class DBPropertyLoader{
	//this is the file path of DATABASE DRIVER INFO we can whenever easily change it when new technology arrives
	private static final String filepath="C:\\Users\\purur\\workspace\\TestProj\\src\\db.properties";
	
	private static Properties prop;
	static
	{
		prop=new Properties();
		try{
			File f=new File(filepath);
			FileInputStream fis=new FileInputStream(f);
			prop.load(fis);
			System.out.println("Properties of loaded from the path");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static Properties getProperties()
	{
		return prop;
		
	}
	
}
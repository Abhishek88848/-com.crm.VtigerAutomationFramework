package vtiger.genericUtility;
/**
 * we for for constants bcs if we directly write in property file and excel sheet location in FileInputStream then if we change the
 * location of property and excel sheet then in every generic method we need to go manually and we need to change the location but 
 * if we place in one specific place then no need
 * to go and change the location just change in once place then in every where it will change.
 * @author ADMIN
 *
 */
public interface ConstantsUtility 
{
	String PropertyFilePath = ".\\src\\test\\resources\\commonData.properties";
	String ExcelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
    
	String DBUrl = "jdbc:mysql://localhost:3306/customerdb";
	String DBUsername = "root";
	String DBPassword = "root";
}
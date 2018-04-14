package lab2;

import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.String;

public class Try {
	
	static String []string1 = new String[97];
	static String []string2 = new String[97];
	static String []string3 = new String[97];
	
	public Try(){
		readXlsx("E:\\大三下\\软件测试\\lab2\\input.xlsx");
	}
	
	public static void readXlsx(String path)
    {
         String text="";
         int count = 0;
         int flag = 0;
         try
         {
              OPCPackage pkg=OPCPackage.open(path);
              XSSFWorkbook excel=new XSSFWorkbook(pkg);
              //获取第一个sheet
              XSSFSheet sheet0=excel.getSheetAt(0);
              for (Iterator rowIterator=sheet0.iterator();rowIterator.hasNext();)
              {
                  XSSFRow row=(XSSFRow) rowIterator.next();
                  for (Iterator iterator=row.cellIterator();iterator.hasNext();)
                  {
                      XSSFCell cell=(XSSFCell) iterator.next();
                      //根据单元的的类型 读取相应的结果  
                      if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING) {
                    	  text=cell.getStringCellValue();
                      }
                      else if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC) {
                    	  cell.setCellType(Cell.CELL_TYPE_STRING);
                    	  text=cell.getStringCellValue();
                      }
                      else if(cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA) {
                    	  text=cell.getCellFormula();
                      }
                      if(flag==0){
                    	  string1[count] = text;
                    	  flag=1;
                      }
                      else if(flag==1){
                    	  string2[count++] = text;
                    	  flag=0;
                      }
                  }
              }
         }
         catch (Exception e) 
         {
                // TODO Auto-generated catch block
                e.printStackTrace();
         }
    }
	
	
	
	public static void main(String[] args) {
		
		readXlsx("E:\\大三下\\软件测试\\lab2\\input.xlsx");
		
        System.setProperty("webdriver.chrome.driver", "E:\\大三下\\软件测试\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
         
        for(int i=0;i<97;i++)
        {
        	driver.get("https://psych.liebes.top/st");
        	String pwd = "";
        	pwd = string1[i].substring(4);
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(string1[i]);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.id("submitButton")).click();
            
            if(!driver.findElement(By.xpath("//p")).getText().equals(string2[i]))
            {
            	System.out.println(string1[i]+' '+ string2[i]+' '+ driver.findElement(By.xpath("//p")).getText());
            }
        }
        
        driver.close();
    }
	
}

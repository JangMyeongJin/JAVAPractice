package practice;
 
import java.io.*;
 
public class cmd { 
	 private static StringBuffer buffer; 
	 private static Process process;
	 private static BufferedReader bufferedReader; 
	 private static StringBuffer readBuffer;
 
	public static String inputCmd(String cmd) {
	  
		  buffer = new StringBuffer();
		  
		  buffer.append("cmd.exe");
		  buffer.append("/c");
		  buffer.append(cmd);
		  
		  return buffer.toString(); 
	}
  
	public static String execCmd(String cmd) { 
		  try { 
			  
			  process = Runtime.getRuntime().exec("cmd /c "+cmd); 
			  bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream())); 
			  String line= null; 
			  readBuffer = new StringBuffer(); 
			  
			  while((line = bufferedReader.readLine()) != null) {
				  readBuffer.append(line); 
				  readBuffer.append("\n");
	  
			  }
			  
			  return readBuffer.toString(); 
			  
		  }catch (Exception e) { 
			  e.printStackTrace(); 
		} 
		  return null;
	}
	
	public static String OutputIP(String cmd) {
		String command = inputCmd(cmd);
		String result = execCmd(command);
		
		String result2 = result.substring(result.indexOf("무선 LAN 어댑터 Wi-Fi:"));
		String result3 = result2.substring(result2.indexOf("IPv4 주소"));
		
		return result3.substring(28,40);
	}
	
	public static String OutputHostName(String cmd) {
		String command = inputCmd(cmd);
		String result = execCmd(command);
		
		return result.substring(44,59);
	}
	
	public static void main(String[] args) {
		String command = inputCmd("ipconfig");
		String result = execCmd(command);
		
		String result2 = result.substring(result.indexOf("무선 LAN 어댑터 Wi-Fi:"));
		String result3 = result2.substring(result2.indexOf("IPv4 주소"));
		
		System.out.println(result3.substring(28,40));
	}
	
}
 
package tools;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Calendar;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class Logger {
	
	public Logger() {}
	
	
	public static void info(String info) { // TODO immoment kein bock
//		System.out.println("Info : " + getTime() + " Info: " + info);
		AnsiConsole.systemInstall();
		System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Info : " + getTime() + " Info: ").fg(Ansi.Color.DEFAULT).a(info));
	}
	
	
	public static void error(String ex) {
		
	}
	
	public static void test(String test) {
		
	}
	
	
	private static String getTime() {
		
		Calendar rightNow = Calendar.getInstance();
		String hour = Integer.toString(rightNow.get(Calendar.HOUR_OF_DAY));
		String minute = Integer.toString(rightNow.get(Calendar.MINUTE));
		String seconds = Integer.toString(rightNow.get(Calendar.SECOND));
		String miliseconds = Integer.toString(rightNow.get(Calendar.MILLISECOND));
		
		
		String ret = hour + ":" + minute + ":" + seconds + "." + miliseconds;
		
		return ret;
	}
	
	
	
}

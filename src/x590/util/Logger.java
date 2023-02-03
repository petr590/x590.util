package x590.util;

import java.io.PrintStream;

public class Logger {
	
	private Logger() {}
	
	
	private static void printDebug() {
		System.out.print("[DEBUG]: ");
	}
	
	
	public static void debug(boolean x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(char x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(int x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(long x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(float x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(double x) {
		printDebug();
		System.out.println(x);
	}
	
	public static void debug(String str) {
		printDebug();
		System.out.println(str);
	}
	
	public static void debug(Object obj1) {
		printDebug();
		print(System.out, obj1);
	}
	
	public static void debug(Object obj1, Object obj2) {
		printDebug();
		print(System.out, obj1, obj2);
	}
	
	public static void debug(Object... args) {
		printDebug();
		print(System.out, args);
	}
	
	public static void debugf(String format, Object... params) {
		printDebug();
		System.out.printf(format, params);
		System.out.println();
	}
	
	
	private static void print(PrintStream out, Object obj1) {
		out.println(obj1);
	}
	
	private static void print(PrintStream out, Object obj1, Object obj2) {
		out.print(obj1);
		out.print(", ");
		out.println(obj2);
	}
	
	private static void print(PrintStream out, Object... args) {
		for(int i = 0, length = args.length;;) {
			out.print(args[i]);
			
			if(++i >= length)
				break;
			
			out.print(", ");
		}
		
		out.println();
	}
	
	
	public static void log(Object obj1) {
		print(System.out, obj1);
	}
	
	public static void log(Object obj1, Object obj2) {
		print(System.out, obj1, obj2);
	}
	
	public static void log(Object... args) {
		print(System.out, args);
	}
	
	public static void log(String str) {
		System.out.println(str);
	}
	
	public static void logf(String format, Object... params) {
		System.out.printf(format, params);
		System.out.println();
	}

	
	
	public static void warning(Object obj1) {
		print(System.err, obj1);
	}
	
	public static void warning(Object obj1, Object obj2) {
		print(System.err, obj1, obj2);
	}
	
	public static void warning(Object... args) {
		print(System.err, args);
	}
	
	public static void warning(String str) {
		System.err.println(str);
	}
	
	public static void warningFormatted(String format, Object... params) {
		System.err.printf(format, params);
		System.err.println();
	}
}
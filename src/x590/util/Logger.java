package x590.util;

import java.io.PrintStream;

public class Logger {
	
	private Logger() {}
	
	private static PrintStream
			out = System.out,
			err = System.err;
	
	public static void setOutputAndErrorStream(PrintStream out, PrintStream err) {
		Logger.out = out;
		Logger.err = err;
	}
	
	public static PrintStream getOutputStream() {
		return out;
	}
	
	public static PrintStream getErrorStream() {
		return err;
	}
	
	
	private static void printDebug() {
		out.print("[DEBUG]: ");
	}
	
	
	public static void debug(boolean x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(char x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(int x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(long x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(float x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(double x) {
		printDebug();
		out.println(x);
	}
	
	public static void debug(String str) {
		printDebug();
		out.println(str);
	}
	
	public static void debug(Object obj1) {
		printDebug();
		print(out, obj1);
	}
	
	public static void debug(Object obj1, Object obj2) {
		printDebug();
		print(out, obj1, obj2);
	}
	
	public static void debug(Object... args) {
		printDebug();
		print(out, args);
	}
	
	public static void debugf(String format, Object... params) {
		printDebug();
		out.printf(format, params);
		out.println();
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
		print(out, obj1);
	}
	
	public static void log(Object obj1, Object obj2) {
		print(out, obj1, obj2);
	}
	
	public static void log(Object... args) {
		print(out, args);
	}
	
	public static void log(String str) {
		out.println(str);
	}
	
	public static void logf(String format, Object... params) {
		out.printf(format, params);
		out.println();
	}

	
	
	public static void warning(Object obj1) {
		print(err, obj1);
	}
	
	public static void warning(Object obj1, Object obj2) {
		print(err, obj1, obj2);
	}
	
	public static void warning(Object... args) {
		print(err, args);
	}
	
	public static void warning(String str) {
		err.println(str);
	}
	
	public static void warningFormatted(String format, Object... params) {
		err.printf(format, params);
		err.println();
	}
}

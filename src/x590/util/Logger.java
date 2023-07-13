package x590.util;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Logger {
	
	private static final String
			DEBUG_MESSAGE = "DEBUG",
			WARN_MESSAGE = "WARN";
	
	
	private Logger() {}
	
	private static PrintStream
			out = System.out,
			err = System.err;
	
	
	private static final Map<String, Map<StackTraceElement, String>> STACK_TRACES = Map.of(
			DEBUG_MESSAGE, new HashMap<>(),
			WARN_MESSAGE, new HashMap<>()
		);
	
	
	public static void setOutputStream(PrintStream out) {
		Logger.out = out;
	}
	
	public static void setErrorStream(PrintStream err) {
		Logger.err = err;
	}
	
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
		out.print(getMessage(DEBUG_MESSAGE));
	}
	
	private static void printWarning() {
		out.print(getMessage(WARN_MESSAGE));
	}
	
	private static String getMessage(String message) {
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
		return STACK_TRACES.get(message).computeIfAbsent(stackTraceElement,
				element -> "[" + message + " (" + element.getFileName() + ':' + element.getLineNumber() + ")]: ");
	}
	
	public static void printStackTrace() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		PrintStream out = Logger.out;
		
		for(int i = 2, length = stackTrace.length; i < length; i++) {
			out.print('\t');
			out.println(stackTrace[i]);
		}
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
		int length = args.length;
		
		if(length != 0) {
			for(int i = 0;;) {
				out.print(args[i]);
				
				if(++i >= length)
					break;
				
				out.print(", ");
			}
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
		printWarning();
		print(err, obj1);
	}
	
	public static void warning(Object obj1, Object obj2) {
		printWarning();
		print(err, obj1, obj2);
	}
	
	public static void warning(Object... args) {
		printWarning();
		print(err, args);
	}
	
	public static void warning(String str) {
		printWarning();
		err.println(str);
	}
	
	public static void warningFormatted(String format, Object... params) {
		printWarning();
		err.printf(format, params);
		err.println();
	}
}

package x590.util;

/**
 * Для дебага времени выполнения кода
 */
public class Timer {
	
	private long startTime;
	
	
	public Timer(long startTime) {
		this.startTime = startTime;
	}
	
	public static Timer startNewTimer() {
		return new Timer(System.currentTimeMillis());
	}
	
	
	public void start() {
		assert startTime == 0;
		startTime = System.currentTimeMillis();
	}
	
	public void restart() {
		assert startTime != 0;
		startTime = System.currentTimeMillis();
	}
	
	public void reset() {
		assert startTime != 0;
		startTime = 0;
	}
	
	public long elapsed() {
		return System.currentTimeMillis() - startTime;
	}
	
	public void logElapsed() {
		System.out.println(elapsed() + " ms elapsed");
	}
	
	public void logElapsed(String message) {
		System.out.println(message + ": " + elapsed() + " ms elapsed");
	}
}

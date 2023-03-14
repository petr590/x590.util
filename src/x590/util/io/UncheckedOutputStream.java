package x590.util.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

public abstract class UncheckedOutputStream extends OutputStream {
	
	@Override
	public abstract void write(int b) throws UncheckedIOException;
	
	@Override
	public void write(byte[] data) throws UncheckedIOException {
		write(data, 0, data.length);
	}
	
	@Override
	public void write(byte[] data, int offset, int length) throws UncheckedIOException {
		try {
			super.write(data, offset, length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public void flush() throws UncheckedIOException {
		try {
			super.flush();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public void close() throws UncheckedIOException {
		try {
			super.close();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	public static  UncheckedIOException newUncheckedException(IOException ex) {
		return new UncheckedIOException(ex);
	}
	
	public static  UncheckedIOException newUncheckedException(String message) {
		return new UncheckedIOException(new IOException(message));
	}
}

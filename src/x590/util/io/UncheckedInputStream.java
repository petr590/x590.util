package x590.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

public abstract class UncheckedInputStream extends InputStream {
	
	@Override
	public abstract int read() throws UncheckedIOException;
	
	@Override
	public int read(byte[] buffer) throws UncheckedIOException {
		return read(buffer, 0, buffer.length);
	}
	
	@Override
	public int read(byte[] buffer, int offset, int length) throws UncheckedIOException {
		try {
			return super.read(buffer, offset, length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public byte[] readAllBytes() throws UncheckedIOException {
		try {
			return super.readAllBytes();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public byte[] readNBytes(int length) throws UncheckedIOException {
		try {
			return super.readNBytes(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public long skip(long length) throws UncheckedIOException {
		try {
			return super.skip(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public void skipNBytes(long length) throws UncheckedIOException {
		try {
			super.skipNBytes(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public int available() throws UncheckedIOException {
		try {
			return super.available();
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
	
	@Override
	public void reset() throws UncheckedIOException {
		try {
			super.reset();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	@Override
	public long transferTo(OutputStream out) throws UncheckedIOException {
		try {
			return super.transferTo(out);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
	
	public static UncheckedIOException newUncheckedException(IOException ex) {
		return new UncheckedIOException(ex);
	}
	
	public static UncheckedIOException newUncheckedException(String message) {
		return new UncheckedIOException(new IOException(message));
	}
}

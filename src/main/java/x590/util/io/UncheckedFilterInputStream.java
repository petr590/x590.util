package x590.util.io;

import java.io.*;

import static x590.util.io.UncheckedInputStream.newUncheckedException;

/**
 * Все методы этого класса выбрасывают {@link UncheckedIOException} вместо {@link IOException}
 * В остальном работает точно так же, как {@link FilterInputStream}
 */
public class UncheckedFilterInputStream extends FilterInputStream {

	protected UncheckedFilterInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() {
		try {
			return super.read();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int read(byte[] buffer) {
		return read(buffer, 0, buffer.length);
	}

	@Override
	public int read(byte[] buffer, int offset, int length) {
		try {
			return super.read(buffer, offset, length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public byte[] readAllBytes() {
		try {
			return super.readAllBytes();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public byte[] readNBytes(int length) {
		try {
			return super.readNBytes(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public long skip(long length) {
		try {
			return super.skip(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void skipNBytes(long length) {
		try {
			super.skipNBytes(length);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int available() {
		try {
			return super.available();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void close() {
		try {
			super.close();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void reset() {
		try {
			super.reset();
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public long transferTo(OutputStream out) {
		try {
			return super.transferTo(out);
		} catch(IOException ex) {
			throw newUncheckedException(ex);
		}
	}
}

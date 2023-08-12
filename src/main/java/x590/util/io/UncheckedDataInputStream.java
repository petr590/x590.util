package x590.util.io;

import java.io.*;

public class UncheckedDataInputStream extends UncheckedInputStream implements DataInput {

	protected final DataInputStream in;

	public UncheckedDataInputStream(InputStream in) {
		this(in instanceof DataInputStream dataIn ? dataIn : new DataInputStream(in));
	}

	public UncheckedDataInputStream(DataInputStream in) {
		this.in = in;
	}

	@Override
	public int read() {
		try {
			return in.read();
		} catch (IOException ex) {
			throw UncheckedInputStream.newUncheckedException(ex);
		}
	}

	@Override
	public int read(byte[] buffer) {
		try {
			return in.read(buffer);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int read(byte[] buffer, int offset, int length) {
		try {
			return in.read(buffer, offset, length);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void readFully(byte[] buffer) {
		try {
			in.readFully(buffer);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void readFully(byte[] buffer, int offset, int length) {
		try {
			in.readFully(buffer, offset, length);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int skipBytes(int n) {
		try {
			return in.skipBytes(n);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public boolean readBoolean() {
		try {
			return in.readBoolean();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public byte readByte() {
		try {
			return in.readByte();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int readUnsignedByte() {
		try {
			return in.readUnsignedByte();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public short readShort() {
		try {
			return in.readShort();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int readUnsignedShort() {
		try {
			return in.readUnsignedShort();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public char readChar() {
		try {
			return in.readChar();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int readInt() {
		try {
			return in.readInt();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public long readLong() {
		try {
			return in.readLong();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public float readFloat() {
		try {
			return in.readFloat();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public double readDouble() {
		try {
			return in.readDouble();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public String readLine() {
		try {
			return in.readLine();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public String readUTF() {
		try {
			return in.readUTF();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public int available() {
		try {
			return in.available();
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}
}

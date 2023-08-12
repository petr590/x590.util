package x590.util.io;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UncheckedDataOutputStream<Self extends UncheckedDataOutputStream<Self>> extends UncheckedOutputStream implements DataOutput {

	protected final DataOutputStream out;

	public UncheckedDataOutputStream(OutputStream out) {
		this(out instanceof DataOutputStream dataOut ? dataOut : new DataOutputStream(out));
	}

	public UncheckedDataOutputStream(DataOutputStream out) {
		this.out = out;
	}
	
	@SuppressWarnings("unchecked")
	private Self self() {
		return (Self)this;
	}

	@Override
	public void write(int b) {
		try {
			out.write(b);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void write(byte[] bytes) {
		write(bytes, 0, bytes.length);
	}

	@Override
	public void write(byte[] bytes, int offset, int length) {
		for (int i = offset, end = offset + length; i < end; i++) {
			write(bytes[i]);
		}
	}

	@Override
	public void writeBoolean(boolean value) {
		try {
			out.writeBoolean(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeByte(int value) {
		try {
			out.writeByte(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeShort(int value) {
		try {
			out.writeShort(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeChar(int value) {
		try {
			out.writeChar(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeInt(int value) {
		try {
			out.writeInt(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeLong(long value) {
		try {
			out.writeLong(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeFloat(float value) {
		try {
			out.writeFloat(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeDouble(double value) {
		try {
			out.writeDouble(value);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeBytes(String bytes) {
		try {
			out.writeBytes(bytes);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeChars(String chars) {
		try {
			out.writeChars(chars);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}

	@Override
	public void writeUTF(String str) {
		try {
			out.writeUTF(str);
		} catch (IOException ex) {
			throw newUncheckedException(ex);
		}
	}



	public Self recordBoolean(boolean value) {
		writeBoolean(value);
		return self();
	}

	public Self recordByte(int value) {
		writeByte(value);
		return self();
	}

	public Self recordShort(int value) {
		writeShort(value);
		return self();
	}

	public Self recordInt(int value) {
		writeInt(value);
		return self();
	}

	public Self recordLong(long value) {
		writeLong(value);
		return self();
	}

	public Self recordFloat(float value) {
		writeFloat(value);
		return self();
	}

	public Self recordDouble(double value) {
		writeDouble(value);
		return self();
	}


	public int size() {
		return out.size();
	}
}

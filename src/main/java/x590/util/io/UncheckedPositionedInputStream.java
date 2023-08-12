package x590.util.io;

import java.io.InputStream;

public class UncheckedPositionedInputStream extends UncheckedFilterInputStream implements UncheckedPositionedInput {

	private long pos, mark;

	public UncheckedPositionedInputStream(InputStream in) {
		super(in);
	}

	@Override
	public long getPosition() {
		return pos;
	}

	@Override
	public int read() {
		int b = super.read();
		if (b >= 0)
			pos += 1;
		return b;
	}

	@Override
	public int read(byte[] buffer) {
		int n = super.read(buffer);
		if (n > 0)
			pos += n;
		return n;
	}

	@Override
	public int read(byte[] buffer, int offset, int length) {
		int n = super.read(buffer, offset, length);
		if (n > 0)
			pos += n;
		return n;
	}

	@Override
	public long skip(long skip)	{
		long n = super.skip(skip);

		if (n > 0)
			pos += n;

		return n;
	}

	@Override
	public void mark(int readLimit) {
		super.mark(readLimit);
		mark = pos;
	}

	@Override
	public void reset() {
		// Вызов reset все еще может завершиться успешно, если mark не поддерживается,
		// но результирующая позиция потока не определена, поэтому здесь это запрещено.
		if (!markSupported())
			throw UncheckedInputStream.newUncheckedException("Mark not supported.");

		super.reset();
		pos = mark;
	}
}

package com.avaya.jtapi.tsapi.tsapiInterface.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class IntelByteArrayOutputStream extends ByteArrayOutputStream {
	public IntelByteArrayOutputStream() {
	}

	public IntelByteArrayOutputStream(final int size) {
		super(size);
	}

	public void writeInt(final int v) throws IOException {
		write(v >>> 0 & 0xFF);
		write(v >>> 8 & 0xFF);
		write(v >>> 16 & 0xFF);
		write(v >>> 24 & 0xFF);
	}

	public void writeShort(final int v) throws IOException {
		write(v >>> 0 & 0xFF);
		write(v >>> 8 & 0xFF);
	}
}

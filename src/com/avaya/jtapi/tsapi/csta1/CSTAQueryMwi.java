package com.avaya.jtapi.tsapi.csta1;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNIA5String;

public class CSTAQueryMwi extends CSTARequest {
	String device;
	static final int PDU = 27;

	public CSTAQueryMwi(final String _device) {
		device = _device;
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		ASNIA5String.encode(device, memberStream);
	}

	public String getDevice() {
		return device;
	}

	@Override
	public int getPDU() {
		return 27;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();
		lines.add("CSTAQueryMwi ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNIA5String.print(device, "device", indent));

		lines.add("}");
		return lines;
	}
}

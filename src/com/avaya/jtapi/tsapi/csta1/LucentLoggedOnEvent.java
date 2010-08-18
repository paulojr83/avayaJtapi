package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNEnumerated;

public final class LucentLoggedOnEvent extends LucentPrivateData {
	short workMode;
	static final int PDU = 48;

	public static LucentLoggedOnEvent decode(final InputStream in) {
		final LucentLoggedOnEvent _this = new LucentLoggedOnEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		workMode = ASNEnumerated.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		ASNEnumerated.encode(workMode, memberStream);
	}

	@Override
	public int getPDU() {
		return 48;
	}

	public short getWorkMode() {
		return workMode;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentLoggedOnEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(LucentWorkMode.print(workMode, "workMode", indent));

		lines.add("}");
		return lines;
	}

	public void setWorkMode(final short workMode) {
		this.workMode = workMode;
	}
}

package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNNull;

public final class LucentSelectiveListeningHoldConfEvent extends
		LucentPrivateData {
	public static final int PDU = 68;

	static LucentSelectiveListeningHoldConfEvent decode(final InputStream in) {
		final LucentSelectiveListeningHoldConfEvent _this = new LucentSelectiveListeningHoldConfEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		ASNNull.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		ASNNull.encode(memberStream);
	}

	@Override
	public int getPDU() {
		return 68;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentSelectiveListeningHoldConfEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNNull.print(indent));

		lines.add("}");
		return lines;
	}
}

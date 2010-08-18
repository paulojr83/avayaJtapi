package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNNull;

public final class LucentSetBillRateConfEvent extends LucentPrivateData {
	static final int PDU = 75;

	static LucentSetBillRateConfEvent decode(final InputStream in) {
		final LucentSetBillRateConfEvent _this = new LucentSetBillRateConfEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		ASNNull.decode(memberStream);
	}

	@Override
	public int getPDU() {
		return 75;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentSetBillRateConfEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNNull.print(indent));

		lines.add("}");
		return lines;
	}
}

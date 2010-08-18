package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNBoolean;

public final class CSTAQueryMwiConfEvent extends CSTAConfirmation {
	boolean messages;
	public static final int PDU = 28;

	public static CSTAQueryMwiConfEvent decode(final InputStream in) {
		final CSTAQueryMwiConfEvent _this = new CSTAQueryMwiConfEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		messages = ASNBoolean.decode(memberStream);
	}

	@Override
	public int getPDU() {
		return 28;
	}

	public boolean isMessages() {
		return messages;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("CSTAQueryMwiConfEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNBoolean.print(messages, "messages", indent));

		lines.add("}");
		return lines;
	}
}

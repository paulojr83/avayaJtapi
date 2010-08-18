package com.avaya.jtapi.tsapi.acs;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNNull;

public final class ACSRequestPrivileges extends ACSRequest {
	public static final int PDU = 17;

	public static ACSRequestPrivileges decode(final InputStream in) {
		final ACSRequestPrivileges _this = new ACSRequestPrivileges();
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
		return 17;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();
		lines.add("ACSRequestPrivileges ::=");
		lines.add("{");
		lines.add("}");
		return lines;
	}
}

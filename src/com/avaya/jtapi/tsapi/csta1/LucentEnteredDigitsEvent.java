package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNEnumerated;
import com.avaya.jtapi.tsapi.asn1.ASNIA5String;

public final class LucentEnteredDigitsEvent extends LucentPrivateData {
	CSTAConnectionID connection_asn;
	String digits;
	short localConnectionInfo;
	short cause;
	static final int PDU = 38;

	public static LucentEnteredDigitsEvent decode(final InputStream in) {
		final LucentEnteredDigitsEvent _this = new LucentEnteredDigitsEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		connection_asn = CSTAConnectionID.decode(memberStream);
		digits = ASNIA5String.decode(memberStream);
		localConnectionInfo = ASNEnumerated.decode(memberStream);
		cause = ASNEnumerated.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		CSTAConnectionID.encode(connection_asn, memberStream);
		ASNIA5String.encode(digits, memberStream);
		ASNEnumerated.encode(localConnectionInfo, memberStream);
		ASNEnumerated.encode(cause, memberStream);
	}

	public short getCause() {
		return cause;
	}

	public CSTAConnectionID getConnection_asn() {
		return connection_asn;
	}

	public String getDigits() {
		return digits;
	}

	public short getLocalConnectionInfo() {
		return localConnectionInfo;
	}

	@Override
	public int getPDU() {
		return 38;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentEnteredDigitsEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(CSTAConnectionID.print(connection_asn, "connection",
				indent));
		lines.addAll(ASNIA5String.print(digits, "digits", indent));
		lines.addAll(LocalConnectionState.print(localConnectionInfo,
				"localConnectionInfo", indent));
		lines.addAll(CSTAEventCause.print(cause, "cause", indent));

		lines.add("}");
		return lines;
	}

	public void setCause(final short cause) {
		this.cause = cause;
	}

	public void setConnection_asn(final CSTAConnectionID connection_asn) {
		this.connection_asn = connection_asn;
	}

	public void setDigits(final String digits) {
		this.digits = digits;
	}

	public void setLocalConnectionInfo(final short localConnectionInfo) {
		this.localConnectionInfo = localConnectionInfo;
	}
}

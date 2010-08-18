package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

public final class CSTASnapshotCall extends CSTARequest {
	public static CSTASnapshotCall decode(final InputStream in) {
		final CSTASnapshotCall _this = new CSTASnapshotCall();
		_this.doDecode(in);

		return _this;
	}

	CSTAConnectionID snapshotObject;

	public static final int PDU = 120;

	public CSTASnapshotCall() {
	}

	public CSTASnapshotCall(final CSTAConnectionID _snapshotObject) {
		snapshotObject = _snapshotObject;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		snapshotObject = CSTAConnectionID.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		CSTAConnectionID.encode(snapshotObject, memberStream);
	}

	@Override
	public int getPDU() {
		return 120;
	}

	public CSTAConnectionID getSnapshotObject() {
		return snapshotObject;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("CSTASnapshotCall ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(CSTAConnectionID.print(snapshotObject, "snapshotObject",
				indent));

		lines.add("}");
		return lines;
	}
}

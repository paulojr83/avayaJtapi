package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNInteger;
import com.avaya.jtapi.tsapi.asn1.ASNSequence;

public final class CSTAChangeMonitorFilter extends CSTARequest {
	public static CSTAChangeMonitorFilter decode(final InputStream in) {
		final CSTAChangeMonitorFilter _this = new CSTAChangeMonitorFilter();
		_this.doDecode(in);

		return _this;
	}

	int monitorCrossRefID;
	CSTAMonitorFilter monitorFilter;

	public static final int PDU = 115;

	public CSTAChangeMonitorFilter() {
	}

	public CSTAChangeMonitorFilter(final int _monitorCrossRefID,
			final CSTAMonitorFilter _monitorFilter) {
		monitorCrossRefID = _monitorCrossRefID;
		monitorFilter = _monitorFilter;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		monitorCrossRefID = ASNInteger.decode(memberStream);
		monitorFilter = CSTAMonitorFilter.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		ASNInteger.encode(monitorCrossRefID, memberStream);
		ASNSequence.encode(monitorFilter, memberStream);
	}

	public int getMonitorCrossRefID() {
		return monitorCrossRefID;
	}

	public CSTAMonitorFilter getMonitorFilter() {
		return monitorFilter;
	}

	@Override
	public int getPDU() {
		return 115;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();
		lines.add("CSTAChangeMonitorFilter ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNInteger.print(monitorCrossRefID, "monitorCrossRefID",
				indent));
		lines.addAll(CSTAMonitorFilter.print(monitorFilter, "monitorFilter",
				indent));

		lines.add("}");
		return lines;
	}
}

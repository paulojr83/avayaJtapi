package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNIA5String;
import com.avaya.jtapi.tsapi.asn1.ASNSequence;

public final class CSTAMonitorDevice extends CSTARequest {
	public static CSTAMonitorDevice decode(final InputStream in) {
		final CSTAMonitorDevice _this = new CSTAMonitorDevice();
		_this.doDecode(in);

		return _this;
	}

	String deviceID;
	CSTAMonitorFilter monitorFilter;

	public static final int PDU = 111;

	public CSTAMonitorDevice() {
	}

	public CSTAMonitorDevice(final String _deviceID,
			final CSTAMonitorFilter _monitorFilter) {
		deviceID = _deviceID;
		monitorFilter = _monitorFilter;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		deviceID = ASNIA5String.decode(memberStream);
		monitorFilter = CSTAMonitorFilter.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		ASNIA5String.encode(deviceID, memberStream);
		ASNSequence.encode(monitorFilter, memberStream);
	}

	public String getDeviceID() {
		return deviceID;
	}

	public CSTAMonitorFilter getMonitorFilter() {
		return monitorFilter;
	}

	@Override
	public int getPDU() {
		return 111;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("CSTAMonitorDevice ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNIA5String.print(deviceID, "deviceID", indent));
		lines.addAll(CSTAMonitorFilter.print(monitorFilter, "monitorFilter",
				indent));

		lines.add("}");
		return lines;
	}
}

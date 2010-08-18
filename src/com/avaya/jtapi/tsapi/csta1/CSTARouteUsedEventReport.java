package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNBoolean;
import com.avaya.jtapi.tsapi.asn1.ASNIA5String;
import com.avaya.jtapi.tsapi.asn1.ASNInteger;

public final class CSTARouteUsedEventReport extends CSTAEventReport {
	int routeRegisterReqID;
	int routingCrossRefID;
	String routeUsed;
	String callingDevice;
	boolean domain;
	public static final int PDU = 86;

	public static CSTARouteUsedEventReport decode(final InputStream in) {
		final CSTARouteUsedEventReport _this = new CSTARouteUsedEventReport();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		routeRegisterReqID = ASNInteger.decode(memberStream);
		routingCrossRefID = ASNInteger.decode(memberStream);
		routeUsed = ASNIA5String.decode(memberStream);
		callingDevice = ASNIA5String.decode(memberStream);
		domain = ASNBoolean.decode(memberStream);
	}

	public String getCallingDevice() {
		return callingDevice;
	}

	@Override
	public int getPDU() {
		return 86;
	}

	public int getRouteRegisterReqID() {
		return routeRegisterReqID;
	}

	public String getRouteUsed() {
		return routeUsed;
	}

	public int getRoutingCrossRefID() {
		return routingCrossRefID;
	}

	public boolean isDomain() {
		return domain;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("CSTARouteUsedEventReport ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNInteger.print(routeRegisterReqID, "routeRegisterReqID",
				indent));
		lines.addAll(ASNInteger.print(routingCrossRefID, "routingCrossRefID",
				indent));
		lines.addAll(ASNIA5String.print(routeUsed, "routeUsed", indent));
		lines
				.addAll(ASNIA5String.print(callingDevice, "callingDevice",
						indent));
		lines.addAll(ASNBoolean.print(domain, "domain", indent));

		lines.add("}");
		return lines;
	}

	public void setCallingDevice(final String callingDevice) {
		this.callingDevice = callingDevice;
	}

	public void setDomain(final boolean domain) {
		this.domain = domain;
	}

	public void setRouteRegisterReqID(final int routeRegisterReqID) {
		this.routeRegisterReqID = routeRegisterReqID;
	}

	public void setRouteUsed(final String routeUsed) {
		this.routeUsed = routeUsed;
	}

	public void setRoutingCrossRefID(final int routingCrossRefID) {
		this.routingCrossRefID = routingCrossRefID;
	}
}

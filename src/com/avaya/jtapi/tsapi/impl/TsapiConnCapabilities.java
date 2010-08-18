package com.avaya.jtapi.tsapi.impl;

import javax.telephony.callcenter.capabilities.ACDConnectionCapabilities;
import javax.telephony.callcenter.capabilities.ACDManagerConnectionCapabilities;
import javax.telephony.callcontrol.capabilities.CallControlConnectionCapabilities;
import javax.telephony.capabilities.ConnectionCapabilities;

import com.avaya.jtapi.tsapi.impl.core.TSCapabilities;
import com.avaya.jtapi.tsapi.util.TsapiTrace;

public final class TsapiConnCapabilities implements ConnectionCapabilities,
		CallControlConnectionCapabilities, ACDConnectionCapabilities,
		ACDManagerConnectionCapabilities {
	private TSCapabilities tsCaps = null;

	public TsapiConnCapabilities(final TSCapabilities _tsCaps) {
		tsCaps = _tsCaps;
		TsapiTrace.traceConstruction(this, TsapiConnCapabilities.class);
	}

	public boolean canAccept() {
		TsapiTrace.traceEntry("canAccept[]", this);
		TsapiTrace.traceExit("canAccept[]", this);
		return false;
	}

	public boolean canAddToAddress() {
		TsapiTrace.traceEntry("canAddToAddress[]", this);
		TsapiTrace.traceExit("canAddToAddress[]", this);
		return false;
	}

	public boolean canDisconnect() {
		TsapiTrace.traceEntry("canDisconnect[]", this);
		final boolean can = tsCaps.getClearConnection() == 1;
		TsapiTrace.traceExit("canDisconnect[]", this);
		return can;
	}

	public boolean canGetACDConnections() {
		TsapiTrace.traceEntry("canGetACDConnections[]", this);
		final boolean can = tsCaps.isLucent();
		TsapiTrace.traceExit("canGetACDConnections[]", this);
		return can;
	}

	public boolean canGetACDManagerConnection() {
		TsapiTrace.traceEntry("canGetACDManagerConnection[]", this);
		final boolean can = tsCaps.isLucent();
		TsapiTrace.traceExit("canGetACDManagerConnection[]", this);
		return can;
	}

	public boolean canPark() {
		TsapiTrace.traceEntry("canPark[]", this);
		TsapiTrace.traceExit("canPark[]", this);
		return false;
	}

	public boolean canRedirect() {
		TsapiTrace.traceEntry("canRedirect[]", this);
		final boolean can = tsCaps.getDeflectCall() == 1;
		TsapiTrace.traceExit("canRedirect[]", this);
		return can;
	}

	public boolean canReject() {
		TsapiTrace.traceEntry("canReject[]", this);
		TsapiTrace.traceExit("canReject[]", this);
		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		TsapiTrace.traceDestruction(this, TsapiConnCapabilities.class);
	}
}

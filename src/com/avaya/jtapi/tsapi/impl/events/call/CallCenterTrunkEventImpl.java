package com.avaya.jtapi.tsapi.impl.events.call;

import javax.telephony.Address;
import javax.telephony.MetaEvent;
import javax.telephony.Terminal;
import javax.telephony.callcenter.CallCenterTrunk;
import javax.telephony.callcenter.CallCenterTrunkEvent;

public class CallCenterTrunkEventImpl extends CallEventImpl implements
		CallCenterTrunkEvent {
	public CallCenterTrunkEventImpl(final CallEventParams params,
			final MetaEvent event, final int eventId) {
		super(params, event, eventId);
	}

	public Object getApplicationData() {
		return null;
	}

	public int getCallCenterCause() {
		return callEventParams.getCause();
	}

	public Address getCalledAddress() {
		return callEventParams.getCalledAddress();
	}

	public Address getCallingAddress() {
		return callEventParams.getCallingAddress();
	}

	public Terminal getCallingTerminal() {
		return callEventParams.getCallingTerminal();
	}

	public Address getLastRedirectedAddress() {
		return callEventParams.getLastRedirectionAddress();
	}

	public CallCenterTrunk getTrunk() {
		return callEventParams.getTrunk();
	}
}

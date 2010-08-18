package com.avaya.jtapi.tsapi.impl.events.conn;

import javax.telephony.events.ConnFailedEv;

public final class TsapiConnFailedEvent extends TsapiConnEvent implements
		ConnFailedEv {
	public TsapiConnFailedEvent(final ConnEventParams params) {
		super(params);
	}

	public int getID() {
		return 108;
	}
}

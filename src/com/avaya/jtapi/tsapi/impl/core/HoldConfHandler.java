package com.avaya.jtapi.tsapi.impl.core;

import java.util.Vector;

import com.avaya.jtapi.tsapi.csta1.CSTAEvent;
import com.avaya.jtapi.tsapi.csta1.CSTAHoldCallConfEvent;
import com.avaya.jtapi.tsapi.impl.monitor.TsapiCallMonitor;
import com.avaya.jtapi.tsapi.tsapiInterface.ConfHandler;

final class HoldConfHandler implements ConfHandler {
	TSConnection conn;

	HoldConfHandler(final TSConnection _conn) {
		conn = _conn;
	}

	public void handleConf(final CSTAEvent event) {
		if (event == null
				|| !(event.getEvent() instanceof CSTAHoldCallConfEvent))
			return;

		conn.replyTermConnPriv = event.getPrivData();

		final Vector<TSEvent> eventList = new Vector<TSEvent>();
		conn.setConnectionState(88, eventList);
		conn.setTermConnState(99, eventList);
		if (eventList.size() <= 0)
			return;
		final Vector<TsapiCallMonitor> observers = conn.getTSCall()
				.getObservers();
		for (int j = 0; j < observers.size(); ++j) {
			final TsapiCallMonitor callback = observers.elementAt(j);
			callback.deliverEvents(eventList, 100, false);
		}
	}
}

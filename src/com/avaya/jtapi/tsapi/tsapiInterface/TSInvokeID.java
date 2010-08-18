package com.avaya.jtapi.tsapi.tsapiInterface;

import org.apache.log4j.Logger;

import com.avaya.jtapi.tsapi.csta1.CSTAEvent;
import com.avaya.jtapi.tsapi.util.JTAPILoggingAdapter;
import com.avaya.jtapi.tsapi.util.PerfStatisticsCollector;

final class TSInvokeID {
	private static Logger log = Logger.getLogger(TSInvokeID.class);
	int value;
	CSTAEvent conf;
	ConfHandler handler;
	String debugID;
	long serviceRequestTurnaroundTime;

	TSInvokeID(final int _value, final ConfHandler _handler,
			final String _debugID) {
		value = _value;
		handler = _handler;
		debugID = _debugID;
		conf = null;
	}

	ConfHandler getConfHandler() {
		return handler;
	}

	public long getServiceRequestTurnaroundTime() {
		return serviceRequestTurnaroundTime;
	}

	int getValue() {
		return value;
	}

	synchronized void setConf(final CSTAEvent _conf) {
		try {
			TSInvokeID.log.info("Handling INVOKE ID " + value + " for "
					+ debugID);
			conf = _conf;
			if (handler != null)
				handler.handleConf(conf);
			TSInvokeID.log.info("DONE handling INVOKE ID " + value + " for "
					+ debugID);
		} finally {
			setServiceRequestTurnaroundTime(System.currentTimeMillis()
					- getServiceRequestTurnaroundTime());
			if (JTAPILoggingAdapter.isPerformanceLoggingEnabled())
				PerfStatisticsCollector
						.updateServiceRequestTurnaroundTime(getServiceRequestTurnaroundTime());
			super.notify();
		}
	}

	public void setServiceRequestTurnaroundTime(
			final long serviceRequestTurnaroundTime) {
		this.serviceRequestTurnaroundTime = serviceRequestTurnaroundTime;
	}

	synchronized CSTAEvent waitForConf(final int timeout) {
		if (conf == null)
			try {
				super.wait(timeout);
			} catch (final InterruptedException e) {
			}
		return conf;
	}
}

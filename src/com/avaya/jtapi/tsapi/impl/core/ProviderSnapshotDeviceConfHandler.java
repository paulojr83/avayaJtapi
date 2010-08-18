package com.avaya.jtapi.tsapi.impl.core;

import java.util.Vector;

import com.avaya.jtapi.tsapi.TsapiPlatformException;
import com.avaya.jtapi.tsapi.csta1.CSTAEvent;
import com.avaya.jtapi.tsapi.csta1.CSTASnapshotDeviceConfEvent;
import com.avaya.jtapi.tsapi.csta1.CSTASnapshotDeviceResponseInfo;
import com.avaya.jtapi.tsapi.tsapiInterface.ConfHandler;

final class ProviderSnapshotDeviceConfHandler implements ConfHandler {
	TSProviderImpl provider;
	Vector<TSCall> cv = new Vector<TSCall>();

	ProviderSnapshotDeviceConfHandler(final TSProviderImpl _provider) {
		provider = _provider;
	}

	public void handleConf(final CSTAEvent event) {
		if (event == null
				|| !(event.getEvent() instanceof CSTASnapshotDeviceConfEvent))
			return;

		final CSTASnapshotDeviceResponseInfo[] info = ((CSTASnapshotDeviceConfEvent) event
				.getEvent()).getSnapshotData();

		if (info != null) {
			TSCall call = null;
			for (int i = 0; i < info.length; ++i)
				try {
					call = provider.createCall(info[i].getCallIdentifier()
							.getCallID());

					if (call.getTSState() == 34) {
						provider.dumpCall(info[i].getCallIdentifier()
								.getCallID());

						call = provider.createCall(info[i].getCallIdentifier()
								.getCallID());
					}

					cv.addElement(call);
				} catch (final TsapiPlatformException e) {
				}
		}
	}
}

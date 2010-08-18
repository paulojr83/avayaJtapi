package com.avaya.jtapi.tsapi.impl;

import com.avaya.jtapi.tsapi.LucentV7Agent;
import com.avaya.jtapi.tsapi.impl.core.TSAgent;
import com.avaya.jtapi.tsapi.util.TsapiTrace;

final class LucentV7AgentImpl extends LucentV6AgentImpl implements
		LucentV7Agent {
	LucentV7AgentImpl(final TSAgent _tsAgent) {
		super(_tsAgent);
		TsapiTrace.traceConstruction(this, LucentV7AgentImpl.class);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof LucentV7AgentImpl)
			return tsAgent.equals(((LucentV7AgentImpl) obj).tsAgent);

		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		TsapiTrace.traceDestruction(this, LucentV7AgentImpl.class);
	}
}

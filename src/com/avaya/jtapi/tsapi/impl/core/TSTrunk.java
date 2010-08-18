package com.avaya.jtapi.tsapi.impl.core;

import java.util.Vector;

import org.apache.log4j.Logger;

public final class TSTrunk {
	private static Logger log = Logger.getLogger(TSTrunk.class);
	TSProviderImpl provider;
	String name;
	String groupName;
	String memberName;
	TSCall call;
	int state;
	int type;
	TSConnection connection;

	TSTrunk(final TSProviderImpl _provider, final String _name, final int _type) {
		provider = _provider;
		name = _name;
		type = _type;
		state = 0;

		if (name == null)
			groupName = memberName = null;
		else {
			final int colonPos = name.indexOf(':');
			if (colonPos <= 0 || colonPos >= name.length() - 1)
				groupName = memberName = null;
			else {
				groupName = name.substring(0, colonPos - 1);
				memberName = name.substring(colonPos + 1);
			}
		}
		provider.addTrunkToHash(name, this);
		TSTrunk.log.info("Trunk object= " + this + " being created with name "
				+ name + " (group:member = " + getGroupAndMember() + ") for "
				+ provider);
	}

	synchronized void delete() {
		TSTrunk.log.info("Trunk object= " + this + " being deleted" + " for "
				+ provider);

		provider.deleteTrunkFromHash(name);
	}

	void dump(final String indent) {
		TSTrunk.log.trace(indent + "***** TRUNK DUMP *****");
		TSTrunk.log.trace(indent + "TSTrunk: " + this);
		TSTrunk.log.trace(indent + "TSTrunk name: " + name);
		TSTrunk.log.trace(indent + "TSTrunk state: " + state);
		TSTrunk.log.trace(indent + "TSTrunk call: " + call);
		TSTrunk.log.trace(indent + "TSTrunk groupName: " + groupName);
		TSTrunk.log.trace(indent + "TSTrunk memberName: " + memberName);
		TSTrunk.log.trace(indent + "***** TRUNK DUMP END *****");
	}

	String getGroupAndMember() {
		String g_m;
		if (groupName == null)
			g_m = "-:";
		else
			g_m = groupName + ":";
		if (memberName == null)
			g_m = g_m + "-";
		else
			g_m = g_m + memberName;
		return g_m;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getName() {
		return name;
	}

	public int getState() {
		return state;
	}

	public TSCall getTSCall() {
		return call;
	}

	public TSConnection getTSConnection() {
		return connection;
	}

	public TSProviderImpl getTSProviderImpl() {
		return provider;
	}

	public int getType() {
		return type;
	}

	boolean setCall(final TSCall _call, final Vector<TSEvent> eventList) {
		synchronized (this) {
			if (call == _call)
				return false;

			if (call != null)
				call.removeTrunk(this, null);
			call = _call;
		}
		setState(2, eventList);

		provider.addTrunkToHash(name, this);

		return true;
	}

	public void setGroupName(final String _name) {
		if (_name == null || _name == "")
			return;
		groupName = _name;
	}

	public void setMemberName(final String _name) {
		if (_name == null || _name == "")
			return;
		memberName = _name;
	}

	void setState(final int _state, final Vector<TSEvent> eventList) {
		synchronized (this) {
			if (state == _state)
				return;

			state = _state;
		}

		switch (state) {
		case 2:
			if (eventList == null)
				return;
			eventList.addElement(new TSEvent(54, this));
			break;
		case 1:
			if (eventList != null)
				eventList.addElement(new TSEvent(55, this));

			delete();
		}
	}

	public void setTSConnection(final TSConnection _conn) {
		connection = _conn;
	}

	void setType(final int _type) {
		type = _type;
	}

	void unsetCall(final Vector<TSEvent> eventList) {
		setState(1, eventList);
	}
}

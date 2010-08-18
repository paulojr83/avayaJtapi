package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNBoolean;
import com.avaya.jtapi.tsapi.asn1.ASNIA5String;

public final class LucentV6EstablishedEvent extends LucentV5EstablishedEvent {
	static final int PDU = 118;

	public static LucentEstablishedEvent decode(final InputStream in) {
		final LucentV6EstablishedEvent _this = new LucentV6EstablishedEvent();
		_this.doDecode(in);

		return _this;
	}

	@Override
	public int getPDU() {
		return 118;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentV6EstablishedEvent ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(ASNIA5String.print(trunkGroup, "trunkGroup", indent));
		lines.addAll(ASNIA5String.print(trunkMember, "trunkMember", indent));
		lines.addAll(ASNIA5String.print(split_asn, "split", indent));
		lines.addAll(LucentLookaheadInfo.print(lookaheadInfo, "lookaheadInfo",
				indent));
		lines.addAll(LucentUserEnteredCode.print(userEnteredCode,
				"userEnteredCode", indent));
		lines.addAll(LucentUserToUserInfo.print(userInfo, "userInfo", indent));
		lines.addAll(LucentReasonCode.print(reason, "reason", indent));
		lines.addAll(LucentOriginalCallInfo.print(originalCallInfo,
				"originalCallInfo", indent));
		lines.addAll(CSTAExtendedDeviceID.print(distributingDevice_asn,
				"distributingDevice", indent));
		lines.addAll(ASNIA5String.print(ucid, "ucid", indent));
		lines.addAll(CSTACallOriginatorInfo.print(callOriginatorInfo,
				"callOriginatorInfo", indent));
		lines.addAll(ASNBoolean.print(flexibleBilling, "flexibleBilling",
				indent));
		lines.add("}");
		return lines;
	}
}

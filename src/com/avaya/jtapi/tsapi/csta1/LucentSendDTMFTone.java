package com.avaya.jtapi.tsapi.csta1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNIA5String;
import com.avaya.jtapi.tsapi.asn1.ASNInteger;

public class LucentSendDTMFTone extends LucentPrivateData {
	public static LucentSendDTMFTone decode(final InputStream in) {
		final LucentSendDTMFTone _this = new LucentSendDTMFTone();
		_this.doDecode(in);

		return _this;
	}

	CSTAConnectionID sender;
	CSTAConnectionID[] receivers;
	String tones;
	int toneDuration;
	int pauseDuration;

	static final int PDU = 8;

	public LucentSendDTMFTone() {
	}

	public LucentSendDTMFTone(final CSTAConnectionID _sender,
			final CSTAConnectionID[] _receivers, final String _tones,
			final int _toneDuration, final int _pauseDuration) {
		sender = _sender;
		receivers = _receivers;
		tones = _tones;
		toneDuration = _toneDuration;
		pauseDuration = _pauseDuration;
	}

	@Override
	public void decodeMembers(final InputStream memberStream) {
		sender = CSTAConnectionID.decode(memberStream);
		receivers = LucentConnIDList.decode(memberStream);
		tones = ASNIA5String.decode(memberStream);
		toneDuration = ASNInteger.decode(memberStream);
		pauseDuration = ASNInteger.decode(memberStream);
	}

	@Override
	public void encodeMembers(final OutputStream memberStream) {
		CSTAConnectionID.encode(sender, memberStream);
		LucentConnIDList.encode(receivers, memberStream);
		ASNIA5String.encode(tones, memberStream);
		ASNInteger.encode(toneDuration, memberStream);
		ASNInteger.encode(pauseDuration, memberStream);
	}

	public int getPauseDuration() {
		return pauseDuration;
	}

	@Override
	public int getPDU() {
		return 8;
	}

	public CSTAConnectionID[] getReceivers() {
		return receivers;
	}

	public CSTAConnectionID getSender() {
		return sender;
	}

	public int getToneDuration() {
		return toneDuration;
	}

	public String getTones() {
		return tones;
	}

	@Override
	public Collection<String> print() {
		final Collection<String> lines = new ArrayList<String>();

		lines.add("LucentSendDTMFTone ::=");
		lines.add("{");

		final String indent = "  ";

		lines.addAll(CSTAConnectionID.print(sender, "sender", indent));
		lines.addAll(LucentConnIDList.print(receivers, "receivers", indent));
		lines.addAll(ASNIA5String.print(tones, "tones", indent));
		lines.addAll(ASNInteger.print(toneDuration, "toneDuration", indent));
		lines.addAll(ASNInteger.print(pauseDuration, "pauseDuration", indent));

		lines.add("}");
		return lines;
	}
}

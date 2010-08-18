package com.avaya.jtapi.tsapi.csta1;

import java.util.Collection;

import com.avaya.jtapi.tsapi.asn1.ASNEnumerated;

public final class LucentExtensionClass extends ASNEnumerated {
	public static final short EC_VDN = 0;
	public static final short EC_ACD_SPLIT = 1;
	public static final short EC_ANNOUNCEMENT = 2;
	public static final short EC_DATA = 4;
	public static final short EC_ANALOG = 5;
	public static final short EC_PROPRIETARY = 6;
	public static final short EC_BRI = 7;
	public static final short EC_CTI = 8;
	public static final short EC_LOGICAL_AGENT = 9;
	public static final short EC_OTHER = 10;

	static Collection<String> print(final short value, final String name,
			final String indent) {
		String str;
		switch (value) {
		case 0:
			str = "EC_VDN";
			break;
		case 1:
			str = "EC_ACD_SPLIT";
			break;
		case 2:
			str = "EC_ANNOUNCEMENT";
			break;
		case 4:
			str = "EC_DATA";
			break;
		case 5:
			str = "EC_ANALOG";
			break;
		case 6:
			str = "EC_PROPRIETARY";
			break;
		case 7:
			str = "EC_BRI";
			break;
		case 8:
			str = "EC_CTI";
			break;
		case 9:
			str = "EC_LOGICAL_AGENT";
			break;
		case 10:
			str = "EC_OTHER";
			break;
		case 3:
		default:
			str = "?? " + value + " ??";
		}

		return ASNEnumerated.print(value, str, name, indent);
	}
}

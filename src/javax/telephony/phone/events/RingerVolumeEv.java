package javax.telephony.phone.events;

/** @deprecated */
@Deprecated
public abstract interface RingerVolumeEv extends PhoneTermEv {
	public static final int ID = 507;

	public abstract int getVolume();
}

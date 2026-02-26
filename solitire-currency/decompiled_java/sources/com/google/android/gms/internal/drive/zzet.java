package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzet extends zzb implements zzes {
    public zzet() {
        super("com.google.android.gms.drive.internal.IEventCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzb
    protected final boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zzc((zzfp) zzc.zza(parcel, zzfp.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}

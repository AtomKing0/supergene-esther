package com.google.android.gms.internal.play_billing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzw extends Binder implements IInterface {
    protected zzw(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i10, parcel, parcel2, i11)) {
            return true;
        }
        return zzb(i10, parcel, parcel2, i11);
    }

    protected boolean zzb(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        throw null;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}

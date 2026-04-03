package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbu implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zzbu(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    protected final Parcel a_() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.zzb);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zza(int i10, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.zza.transact(i10, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e10) {
                parcelObtain.recycle();
                throw e10;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected final void zzb(int i10, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.zza.transact(i10, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzagl implements Parcelable.Creator {
    zzagl() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String string = parcel.readString();
        string.getClass();
        String string2 = parcel.readString();
        String[] strArrCreateStringArray = parcel.createStringArray();
        strArrCreateStringArray.getClass();
        return new zzagm(string, string2, zzfxr.zzl(strArrCreateStringArray));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzagm[i10];
    }
}

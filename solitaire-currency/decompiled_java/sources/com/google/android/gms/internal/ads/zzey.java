package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzey implements Parcelable.Creator {
    zzey() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzfa(parcel, (zzez) null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzfa[i10];
    }
}

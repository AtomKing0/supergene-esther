package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "PopupLocationInfoParcelableCreator")
@SafeParcelable.Reserved({1000})
public final class zzan extends com.google.android.gms.games.internal.zzh {
    public static final Parcelable.Creator<zzan> CREATOR = new zzao();

    @SafeParcelable.Field(getter = "getInfoBundle", id = 1)
    private final Bundle zza;

    @Nullable
    @SafeParcelable.Field(getter = "getWindowToken", id = 2)
    private final IBinder zzb;

    @SafeParcelable.Constructor
    zzan(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.zza = bundle;
        this.zzb = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzan(zzam zzamVar) {
        this.zza = zzamVar.zza();
        this.zzb = zzamVar.zza;
    }
}

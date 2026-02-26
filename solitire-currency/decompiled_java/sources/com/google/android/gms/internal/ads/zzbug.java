package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
public final class zzbug extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbug> CREATOR = new zzbuh();

    @SafeParcelable.Field(id = 1)
    public final String zza;

    @SafeParcelable.Field(id = 2)
    public final int zzb;

    @SafeParcelable.Field(id = 3)
    public final Bundle zzc;

    @SafeParcelable.Field(id = 4)
    public final byte[] zzd;

    @SafeParcelable.Field(id = 5)
    public final boolean zze;

    @SafeParcelable.Field(id = 6)
    public final String zzf;

    @SafeParcelable.Field(id = 7)
    public final String zzg;

    @SafeParcelable.Constructor
    public zzbug(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) boolean z10, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3) {
        this.zza = str;
        this.zzb = i10;
        this.zzc = bundle;
        this.zzd = bArr;
        this.zze = z10;
        this.zzf = str2;
        this.zzg = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

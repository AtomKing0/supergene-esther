package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgf {

    @NonNull
    public String zza;

    @NonNull
    public Bundle zzb;

    @NonNull
    private String zzc;
    private long zzd;

    private zzgf(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j10) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j10;
    }

    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    public final zzbf zza() {
        return new zzbf(this.zza, new zzba(new Bundle(this.zzb)), this.zzc, this.zzd);
    }

    public static zzgf zza(zzbf zzbfVar) {
        return new zzgf(zzbfVar.zza, zzbfVar.zzc, zzbfVar.zzb.zzb(), zzbfVar.zzd);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcgm {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    /* synthetic */ zzcgm(zzcgk zzcgkVar, zzcgl zzcglVar) {
        this.zza = zzcgkVar.zza;
        this.zzb = zzcgkVar.zzb;
        this.zzd = zzcgkVar.zzd;
        this.zzc = zzcgkVar.zzc;
    }

    final long zza() {
        return this.zzc;
    }

    final Context zzb() {
        return this.zzb;
    }

    public final com.google.android.gms.ads.internal.zzj zzc() {
        return new com.google.android.gms.ads.internal.zzj(this.zzb, this.zza);
    }

    final zzbel zzd() {
        return new zzbel(this.zzb);
    }

    final VersionInfoParcel zze() {
        return this.zza;
    }

    final String zzf() {
        return com.google.android.gms.ads.internal.zzu.zzp().zzc(this.zzb, this.zza.afmaVersion);
    }

    final WeakReference zzg() {
        return this.zzd;
    }
}

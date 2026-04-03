package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgd {
    private final int zza;
    private final boolean zzb;
    private final boolean zzc;
    private final /* synthetic */ zzgb zzd;

    zzgd(zzgb zzgbVar, int i10, boolean z10, boolean z11) {
        this.zzd = zzgbVar;
        this.zza = i10;
        this.zzb = z10;
        this.zzc = z11;
    }

    public final void zza(String str) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, null, null, null);
    }

    public final void zza(String str, Object obj) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, obj3);
    }
}

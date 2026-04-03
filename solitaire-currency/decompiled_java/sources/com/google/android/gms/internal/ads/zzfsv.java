package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfsv extends zzfto {
    private String zza;
    private String zzb;

    zzfsv() {
    }

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzfto zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzfto zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzftp zzc() {
        return new zzfsx(this.zza, this.zzb, null);
    }
}

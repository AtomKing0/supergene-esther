package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfsm extends zzfsy {
    private String zza;
    private String zzb;

    zzfsm() {
    }

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsy zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsy zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsz zzc() {
        return new zzfso(this.zza, this.zzb, null);
    }
}

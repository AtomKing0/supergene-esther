package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxp extends zzfvr {
    private final zzfxr zza;

    zzfxp(zzfxr zzfxrVar, int i10) {
        super(zzfxrVar.size(), i10);
        this.zza = zzfxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvr
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}

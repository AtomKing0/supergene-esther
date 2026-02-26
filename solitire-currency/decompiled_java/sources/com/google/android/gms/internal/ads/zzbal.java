package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbal extends zzbzt {
    final /* synthetic */ zzbar zza;

    zzbal(zzbar zzbarVar) {
        this.zza = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzt, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        zzbar.zze(this.zza);
        return super.cancel(z10);
    }
}

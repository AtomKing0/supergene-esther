package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzcex implements Runnable {
    public final /* synthetic */ zzcej zza;

    public /* synthetic */ zzcex(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.destroy();
    }
}

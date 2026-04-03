package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgax;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgcy extends zzgax.zzi implements Runnable {
    private final Runnable zza;

    public zzgcy(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    protected final String zza() {
        return "task=[" + this.zza.toString() + v8.i.f15839e;
    }
}

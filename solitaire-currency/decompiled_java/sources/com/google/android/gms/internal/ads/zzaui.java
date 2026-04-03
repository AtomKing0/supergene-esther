package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaui implements Runnable {
    final /* synthetic */ zzauj zza;

    zzaui(zzauj zzaujVar) {
        this.zza = zzaujVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.zza.zzb != null) {
            return;
        }
        synchronized (zzauj.zzc) {
            if (this.zza.zzb != null) {
                return;
            }
            boolean z10 = false;
            try {
                zBooleanValue = ((Boolean) zzbbw.zzcl.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzauj.zza = zzfqj.zzb(this.zza.zze.zza, "ADSHIELD", null);
                    z10 = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z10 = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z10);
            zzauj.zzc.open();
        }
    }
}

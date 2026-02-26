package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzls implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zzla zzf;

    zzls(zzla zzlaVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zznVar;
        this.zzf = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfqVar = this.zzf.zzb;
                } catch (RemoteException e10) {
                    this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; remote exception", zzgb.zza(this.zzb), this.zzc, e10);
                    this.zza.set(Collections.emptyList());
                }
                if (zzfqVar == null) {
                    this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; not connected to service", zzgb.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    Preconditions.checkNotNull(this.zze);
                    this.zza.set(zzfqVar.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zzfqVar.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzam();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqi {
    final /* synthetic */ zzfqj zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfqi(zzfqj zzfqjVar, byte[] bArr, zzfqh zzfqhVar) {
        this.zza = zzfqjVar;
        this.zzb = bArr;
    }

    public final zzfqi zza(int i10) {
        this.zzd = i10;
        return this;
    }

    public final zzfqi zzb(int i10) {
        this.zzc = i10;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfqj zzfqjVar = this.zza;
            if (zzfqjVar.zzb) {
                zzfqjVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e10) {
            Log.d("GASS", "Clearcut log failed", e10);
        }
    }
}

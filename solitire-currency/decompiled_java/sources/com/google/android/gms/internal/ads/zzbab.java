package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbab implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbad zza;

    zzbab(zzbad zzbadVar) {
        this.zza = zzbadVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzbad zzbadVar;
        synchronized (this.zza.zzc) {
            try {
                zzbadVar = this.zza;
            } catch (DeadObjectException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to obtain a cache service instance.", e10);
                zzbad.zzh(this.zza);
            }
            if (zzbadVar.zzd != null) {
                zzbadVar.zzf = zzbadVar.zzd.zzq();
                this.zza.zzc.notifyAll();
            } else {
                this.zza.zzc.notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}

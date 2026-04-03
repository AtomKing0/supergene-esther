package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbac implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbad zza;

    zzbac(zzbad zzbadVar) {
        this.zza = zzbadVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbad zzbadVar = this.zza;
            if (zzbadVar.zzd != null) {
                zzbadVar.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}

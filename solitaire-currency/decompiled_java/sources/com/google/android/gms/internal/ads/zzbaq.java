package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbaq implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbar zzb;

    zzbaq(zzbar zzbarVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
        this.zzb = zzbarVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}

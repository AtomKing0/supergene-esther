package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfea implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdd zza;
    final /* synthetic */ zzfec zzb;

    zzfea(zzfec zzfecVar, com.google.android.gms.ads.internal.client.zzdd zzddVar) {
        this.zza = zzddVar;
        this.zzb = zzfecVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
            }
        }
    }
}

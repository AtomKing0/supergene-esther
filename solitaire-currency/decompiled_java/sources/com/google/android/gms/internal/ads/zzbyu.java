package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbyu implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbzt zzb;

    zzbyu(zzbyv zzbyvVar, Context context, zzbzt zzbztVar) {
        this.zza = context;
        this.zzb = zzbztVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e10) {
            this.zzb.zzd(e10);
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Exception while getting advertising Id info", e10);
        }
    }
}

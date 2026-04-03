package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzc extends zzb {
    private final Context zza;

    zzc(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zza);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Fail to get isAdIdFakeForDebugLogging", e10);
            isAdIdFakeForDebugLogging = false;
        }
        com.google.android.gms.ads.internal.util.client.zzl.zzj(isAdIdFakeForDebugLogging);
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Update ad debug logging enablement as " + isAdIdFakeForDebugLogging);
    }
}

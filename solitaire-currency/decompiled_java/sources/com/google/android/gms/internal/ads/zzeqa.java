package com.google.android.gms.internal.ads;

import android.os.Bundle;
import io.sentry.protocol.Device;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeqa implements zzevn {
    private final double zza;
    private final boolean zzb;

    public zzeqa(double d10, boolean z10) {
        this.zza = d10;
        this.zzb = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundleZza = zzffu.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzffu.zza(bundleZza, "battery");
        bundleZza.putBundle("battery", bundleZza2);
        bundleZza2.putBoolean("is_charging", this.zzb);
        bundleZza2.putDouble(Device.JsonKeys.BATTERY_LEVEL, this.zza);
    }
}

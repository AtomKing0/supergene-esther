package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeou implements zzevn {

    @Nullable
    private final String zza;
    private final boolean zzb;

    public zzeou(@Nullable String str, boolean z10) {
        this.zza = str;
        this.zzb = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            Bundle bundleZza = zzffu.zza(bundle, "pii");
            bundleZza.putString("afai", this.zza);
            bundleZza.putBoolean("is_afai_lat", this.zzb);
        }
    }
}

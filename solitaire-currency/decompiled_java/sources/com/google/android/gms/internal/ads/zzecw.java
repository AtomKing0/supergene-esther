package com.google.android.gms.internal.ads;

import android.app.Activity;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzecw extends zzedt {
    private Activity zza;
    private com.google.android.gms.ads.internal.overlay.zzm zzb;
    private String zzc;
    private String zzd;

    zzecw() {
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zza(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Null activity");
        }
        this.zza = activity;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzb(@Nullable com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzb = zzmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzc(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzd(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedu zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzecy(activity, this.zzb, this.zzc, this.zzd, null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}

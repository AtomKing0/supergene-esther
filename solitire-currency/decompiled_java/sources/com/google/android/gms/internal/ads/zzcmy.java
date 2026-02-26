package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcmy implements zzcxl {
    private final zzfge zza;

    public zzcmy(zzfge zzfgeVar) {
        this.zza = zzfgeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(@Nullable Context context) {
        try {
            this.zza.zzg();
        } catch (zzffn e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot invoke onDestroy for the mediation adapter.", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(@Nullable Context context) {
        try {
            this.zza.zzt();
        } catch (zzffn e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot invoke onPause for the mediation adapter.", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(@Nullable Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzffn e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot invoke onResume for the mediation adapter.", e10);
        }
    }
}

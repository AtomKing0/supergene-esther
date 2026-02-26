package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzflp {
    private boolean zza;

    final void zza(Context context) {
        zzfnj.zzc(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfmt.zzb().zzd(context);
        zzfmk.zza().zzd(context);
        zzfne.zzb(context);
        zzfnf.zzd(context);
        zzfni.zza(context);
        zzfmq.zzb().zzc(context);
        zzfmj.zza().zzd(context);
    }

    final boolean zzb() {
        return this.zza;
    }
}

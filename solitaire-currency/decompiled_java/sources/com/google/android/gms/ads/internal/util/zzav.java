package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzcz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzav extends zzcz {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzay zzb;

    zzav(zzay zzayVar, Context context) {
        this.zza = context;
        this.zzb = zzayVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzda
    public final void zze(@Nullable com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        this.zzb.zzi(this.zza, zzeVar.zzb, true, true);
    }
}

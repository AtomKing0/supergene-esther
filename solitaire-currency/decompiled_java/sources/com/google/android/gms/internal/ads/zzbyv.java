package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbyv {
    public final m zza(Context context, int i10) {
        zzbzt zzbztVar = new zzbzt();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzu(context)) {
            zzbzo.zza.execute(new zzbyu(this, context, zzbztVar));
        }
        return zzbztVar;
    }
}

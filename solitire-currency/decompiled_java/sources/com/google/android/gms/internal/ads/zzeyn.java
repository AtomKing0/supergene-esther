package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyn implements zzevo {
    final ScheduledExecutorService zza;

    public zzeyn(zzbsr zzbsrVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return zzgcj.zzm(zzgcj.zzo(zzgcj.zzh(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdK)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzful() { // from class: com.google.android.gms.internal.ads.zzeym
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzeyo((Bundle) obj);
            }
        }, zzbzo.zza);
    }
}

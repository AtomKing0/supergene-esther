package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zznj implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzng zzd;

    zznj(zzng zzngVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        this.zzd = zzngVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zza((zzbf) Preconditions.checkNotNull(this.zzd.zza.zzq().zza(this.zza, this.zzb, this.zzc, TtmlNode.TEXT_EMPHASIS_AUTO, this.zzd.zza.zzb().currentTimeMillis(), false, true)), this.zza);
    }
}

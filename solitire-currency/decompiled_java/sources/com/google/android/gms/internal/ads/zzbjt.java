package com.google.android.gms.internal.ads;

import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public final class zzbjt extends zzbjv {
    private final OnH5AdsEventListener zza;

    public zzbjt(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbjw
    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}

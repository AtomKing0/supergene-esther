package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetz implements zzevo {

    @Nullable
    private final Bundle zza;

    zzetz(@Nullable Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 30;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return zzgcj.zzh(new zzeua(this.zza));
    }
}

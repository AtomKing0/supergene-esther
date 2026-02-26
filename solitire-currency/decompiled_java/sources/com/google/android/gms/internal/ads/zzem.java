package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzem implements zzdj {
    protected zzem() {
    }

    @Override // com.google.android.gms.internal.ads.zzdj
    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzdj
    public final zzdt zzb(Looper looper, @Nullable Handler.Callback callback) {
        return new zzep(new Handler(looper, callback));
    }
}

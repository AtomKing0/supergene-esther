package com.google.android.gms.ads.formats;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class UnifiedNativeAd {
    @KeepForSdk
    public abstract void performClick(@NonNull Bundle bundle);

    @KeepForSdk
    public abstract boolean recordImpression(@NonNull Bundle bundle);

    @KeepForSdk
    public abstract void reportTouchEvent(@NonNull Bundle bundle);

    @NonNull
    @Deprecated
    public abstract VideoController zza();

    @NonNull
    public abstract NativeAd.Image zzb();

    @NonNull
    public abstract Double zzc();

    @NonNull
    public abstract Object zzd();

    @NonNull
    public abstract String zze();

    @NonNull
    public abstract String zzf();

    @NonNull
    public abstract String zzg();

    @NonNull
    public abstract String zzh();

    @NonNull
    public abstract String zzi();

    @NonNull
    public abstract String zzj();

    @NonNull
    public abstract List zzk();
}

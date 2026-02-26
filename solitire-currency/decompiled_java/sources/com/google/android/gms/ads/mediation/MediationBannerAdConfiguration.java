package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class MediationBannerAdConfiguration extends MediationAdConfiguration {
    private final AdSize zza;

    public MediationBannerAdConfiguration(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle, @NonNull Bundle bundle2, boolean z10, @Nullable Location location, int i10, int i11, @NonNull String str2, @NonNull AdSize adSize, @NonNull String str3) {
        super(context, str, bundle, bundle2, z10, location, i10, i11, str2, str3);
        this.zza = adSize;
    }

    @NonNull
    public AdSize getAdSize() {
        return this.zza;
    }
}

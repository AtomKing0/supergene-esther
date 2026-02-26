package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RtbSignalData {
    private final Context zza;
    private final List zzb;
    private final Bundle zzc;

    @Nullable
    private final AdSize zzd;

    public RtbSignalData(@NonNull Context context, @NonNull List<MediationConfiguration> list, @NonNull Bundle bundle, @Nullable AdSize adSize) {
        this.zza = context;
        this.zzb = list;
        this.zzc = bundle;
        this.zzd = adSize;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zzd;
    }

    @Nullable
    @Deprecated
    public MediationConfiguration getConfiguration() {
        List list = this.zzb;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (MediationConfiguration) this.zzb.get(0);
    }

    @NonNull
    public List<MediationConfiguration> getConfigurations() {
        return this.zzb;
    }

    @NonNull
    public Context getContext() {
        return this.zza;
    }

    @NonNull
    public Bundle getNetworkExtras() {
        return this.zzc;
    }
}

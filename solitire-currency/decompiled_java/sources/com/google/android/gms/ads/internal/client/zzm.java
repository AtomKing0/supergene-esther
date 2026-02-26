package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzm {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = 60000;
    private final int zzl = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.getValue();
    private long zzm = 0;

    public final zzl zza() {
        Bundle bundle = this.zze;
        Bundle bundle2 = this.zza;
        Bundle bundle3 = this.zzf;
        return new zzl(8, -1L, bundle2, -1, this.zzb, this.zzc, this.zzd, false, null, null, null, null, bundle, bundle3, this.zzg, null, null, false, null, this.zzh, this.zzi, this.zzj, this.zzk, null, this.zzl, this.zzm);
    }

    public final zzm zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzm zzc(int i10) {
        this.zzk = i10;
        return this;
    }

    public final zzm zzd(boolean z10) {
        this.zzc = z10;
        return this;
    }

    public final zzm zze(List list) {
        this.zzb = list;
        return this;
    }

    public final zzm zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final zzm zzg(long j10) {
        this.zzm = j10;
        return this;
    }

    public final zzm zzh(int i10) {
        this.zzd = i10;
        return this;
    }

    public final zzm zzi(int i10) {
        this.zzh = i10;
        return this;
    }
}

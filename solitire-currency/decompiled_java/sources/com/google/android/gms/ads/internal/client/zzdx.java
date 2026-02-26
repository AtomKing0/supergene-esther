package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdx {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final Map zze;
    private final String zzf;
    private final String zzg;

    @Nullable
    private final SearchAdRequest zzh;
    private final int zzi;
    private final Set zzj;
    private final Bundle zzk;
    private final Set zzl;
    private final boolean zzm;
    private final String zzn;
    private final int zzo;
    private long zzp = 0;

    public zzdx(zzdw zzdwVar, @Nullable SearchAdRequest searchAdRequest) {
        this.zza = zzdwVar.zzg;
        this.zzb = zzdwVar.zzh;
        this.zzc = Collections.unmodifiableSet(zzdwVar.zza);
        this.zzd = zzdwVar.zzb;
        this.zze = Collections.unmodifiableMap(zzdwVar.zzc);
        this.zzf = zzdwVar.zzi;
        this.zzg = zzdwVar.zzj;
        this.zzh = searchAdRequest;
        this.zzi = zzdwVar.zzk;
        this.zzj = Collections.unmodifiableSet(zzdwVar.zzd);
        this.zzk = zzdwVar.zze;
        this.zzl = Collections.unmodifiableSet(zzdwVar.zzf);
        this.zzm = zzdwVar.zzl;
        this.zzn = zzdwVar.zzm;
        this.zzo = zzdwVar.zzn;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzi;
    }

    public final long zzc() {
        return this.zzp;
    }

    @Nullable
    public final Bundle zzd(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.zzk;
    }

    @Nullable
    public final Bundle zzf(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.zzd;
    }

    @Nullable
    @Deprecated
    public final NetworkExtras zzh(Class cls) {
        return (NetworkExtras) this.zze.get(cls);
    }

    @Nullable
    public final SearchAdRequest zzi() {
        return this.zzh;
    }

    @Nullable
    public final String zzj() {
        return this.zzn;
    }

    public final String zzk() {
        return this.zza;
    }

    public final String zzl() {
        return this.zzf;
    }

    public final String zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return new ArrayList(this.zzb);
    }

    public final Set zzo() {
        return this.zzl;
    }

    public final Set zzp() {
        return this.zzc;
    }

    public final void zzq(long j10) {
        this.zzp = j10;
    }

    @Deprecated
    public final boolean zzr() {
        return this.zzm;
    }

    public final boolean zzs(Context context) {
        RequestConfiguration requestConfigurationZzc = zzej.zzf().zzc();
        zzay.zzb();
        Set set = this.zzj;
        String strZzz = com.google.android.gms.ads.internal.util.client.zzf.zzz(context);
        return set.contains(strZzz) || requestConfigurationZzc.getTestDeviceIds().contains(strZzz);
    }
}

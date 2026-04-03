package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffg {

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzfk zza;

    @Nullable
    public final zzblh zzb;

    @Nullable
    public final zzemk zzc;
    public final com.google.android.gms.ads.internal.client.zzl zzd;
    public final com.google.android.gms.ads.internal.client.zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbes zzi;
    public final com.google.android.gms.ads.internal.client.zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcb zzn;
    public final zzfet zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzcf zzt;

    /* synthetic */ zzffg(zzffe zzffeVar, zzfff zzfffVar) {
        this.zze = zzffeVar.zzb;
        this.zzf = zzffeVar.zzc;
        this.zzt = zzffeVar.zzu;
        int i10 = zzffeVar.zza.zza;
        long j10 = zzffeVar.zza.zzb;
        Bundle bundle = zzffeVar.zza.zzc;
        int i11 = zzffeVar.zza.zzd;
        List list = zzffeVar.zza.zze;
        boolean z10 = zzffeVar.zza.zzf;
        int i12 = zzffeVar.zza.zzg;
        boolean z11 = true;
        if (!zzffeVar.zza.zzh && !zzffeVar.zze) {
            z11 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzl(i10, j10, bundle, i11, list, z10, i12, z11, zzffeVar.zza.zzi, zzffeVar.zza.zzj, zzffeVar.zza.zzk, zzffeVar.zza.zzl, zzffeVar.zza.zzm, zzffeVar.zza.zzn, zzffeVar.zza.zzo, zzffeVar.zza.zzp, zzffeVar.zza.zzq, zzffeVar.zza.zzr, zzffeVar.zza.zzs, zzffeVar.zza.zzt, zzffeVar.zza.zzu, zzffeVar.zza.zzv, com.google.android.gms.ads.internal.util.zzt.zza(zzffeVar.zza.zzw), zzffeVar.zza.zzx, zzffeVar.zza.zzy, zzffeVar.zza.zzz);
        this.zza = zzffeVar.zzd != null ? zzffeVar.zzd : zzffeVar.zzh != null ? zzffeVar.zzh.zzf : null;
        this.zzg = zzffeVar.zzf;
        this.zzh = zzffeVar.zzg;
        this.zzi = zzffeVar.zzf == null ? null : zzffeVar.zzh == null ? new zzbes(new NativeAdOptions.Builder().build()) : zzffeVar.zzh;
        this.zzj = zzffeVar.zzi;
        this.zzk = zzffeVar.zzm;
        this.zzl = zzffeVar.zzj;
        this.zzm = zzffeVar.zzk;
        this.zzn = zzffeVar.zzl;
        this.zzb = zzffeVar.zzn;
        this.zzo = new zzfet(zzffeVar.zzo, null);
        this.zzp = zzffeVar.zzp;
        this.zzq = zzffeVar.zzq;
        this.zzc = zzffeVar.zzr;
        this.zzr = zzffeVar.zzs;
        this.zzs = zzffeVar.zzt;
    }

    @Nullable
    public final zzbgu zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        return publisherAdViewOptions != null ? publisherAdViewOptions.zzb() : this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcP));
    }
}

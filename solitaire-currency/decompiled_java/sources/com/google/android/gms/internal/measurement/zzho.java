package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import e5.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzho {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final g<Context, Boolean> zzh;
    private final boolean zzi;

    public zzho(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final zzho zza() {
        return new zzho(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, true, this.zzg, this.zzh);
    }

    public final zzho zzb() {
        if (!this.zzc.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        g<Context, Boolean> gVar = this.zzh;
        if (gVar == null) {
            return new zzho(this.zza, this.zzb, this.zzc, this.zzd, true, this.zzf, this.zzi, this.zzg, gVar);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    private zzho(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, g<Context, Boolean> gVar) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z10;
        this.zzf = z11;
        this.zzi = z12;
        this.zzg = z13;
        this.zzh = gVar;
    }

    public final zzhg<Double> zza(String str, double d10) {
        return zzhg.zza(this, str, Double.valueOf(-3.0d), true);
    }

    public final zzhg<Long> zza(String str, long j10) {
        return zzhg.zza(this, str, Long.valueOf(j10), true);
    }

    public final zzhg<String> zza(String str, String str2) {
        return zzhg.zza(this, str, str2, true);
    }

    public final zzhg<Boolean> zza(String str, boolean z10) {
        return zzhg.zza(this, str, Boolean.valueOf(z10), true);
    }
}

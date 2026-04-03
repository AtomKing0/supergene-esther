package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwa {
    private final Context zza;
    private final zzffg zzb;
    private final Bundle zzc;

    @Nullable
    private final zzfey zzd;

    @Nullable
    private final zzcvs zze;

    @Nullable
    private final zzeey zzf;

    /* synthetic */ zzcwa(zzcvy zzcvyVar, zzcvz zzcvzVar) {
        this.zza = zzcvyVar.zza;
        this.zzb = zzcvyVar.zzb;
        this.zzc = zzcvyVar.zzc;
        this.zzd = zzcvyVar.zzd;
        this.zze = zzcvyVar.zze;
        this.zzf = zzcvyVar.zzf;
    }

    final Context zza(Context context) {
        return this.zza;
    }

    @Nullable
    final Bundle zzb() {
        return this.zzc;
    }

    @Nullable
    final zzcvs zzc() {
        return this.zze;
    }

    final zzcvy zzd() {
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zza);
        zzcvyVar.zzi(this.zzb);
        zzcvyVar.zzf(this.zzc);
        zzcvyVar.zzg(this.zze);
        zzcvyVar.zzd(this.zzf);
        return zzcvyVar;
    }

    final zzeey zze(String str) {
        zzeey zzeeyVar = this.zzf;
        return zzeeyVar != null ? zzeeyVar : new zzeey(str);
    }

    @Nullable
    final zzfey zzf() {
        return this.zzd;
    }

    final zzffg zzg() {
        return this.zzb;
    }
}

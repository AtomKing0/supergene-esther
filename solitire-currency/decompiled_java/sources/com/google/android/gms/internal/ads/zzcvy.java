package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvy {
    private Context zza;
    private zzffg zzb;
    private Bundle zzc;

    @Nullable
    private zzfey zzd;

    @Nullable
    private zzcvs zze;

    @Nullable
    private zzeey zzf;

    public final zzcvy zzd(@Nullable zzeey zzeeyVar) {
        this.zzf = zzeeyVar;
        return this;
    }

    public final zzcvy zze(Context context) {
        this.zza = context;
        return this;
    }

    public final zzcvy zzf(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzcvy zzg(@Nullable zzcvs zzcvsVar) {
        this.zze = zzcvsVar;
        return this;
    }

    public final zzcvy zzh(zzfey zzfeyVar) {
        this.zzd = zzfeyVar;
        return this;
    }

    public final zzcvy zzi(zzffg zzffgVar) {
        this.zzb = zzffgVar;
        return this;
    }

    public final zzcwa zzj() {
        return new zzcwa(this, null);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqb {

    @Nullable
    private final Context zza;
    private final zzof zzb;
    private boolean zzc;
    private final zzqa zzd;

    @Nullable
    private zzqd zze;
    private zzpt zzf;

    @Deprecated
    public zzqb() {
        this.zza = null;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }

    public final zzqp zzc() {
        zzdi.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzqd(new zzct[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzpt(this.zza);
        }
        return new zzqp(this, null);
    }

    public zzqb(Context context) {
        this.zza = context;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }
}

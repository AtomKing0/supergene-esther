package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public final class zzfos {
    private final Context zza;
    private final Looper zzb;

    public zzfos(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfpg zzfpgVarZza = zzfpi.zza();
        zzfpgVarZza.zza(this.zza.getPackageName());
        zzfpgVarZza.zzc(2);
        zzfpd zzfpdVarZza = zzfpe.zza();
        zzfpdVarZza.zza(str);
        zzfpdVarZza.zzb(2);
        zzfpgVarZza.zzb(zzfpdVarZza);
        new zzfot(this.zza, this.zzb, (zzfpi) zzfpgVarZza.zzbr()).zza();
    }
}

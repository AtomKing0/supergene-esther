package com.google.android.gms.internal.games_v2;

import android.app.Application;
import androidx.compose.animation.core.d;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzax {
    private static final AtomicReference zza = new AtomicReference();

    public static zzav zza(Application application) {
        AtomicReference atomicReference = zza;
        zzav zzavVar = (zzav) atomicReference.get();
        if (zzavVar != null) {
            return zzavVar;
        }
        zzo zzoVarZza = zzq.zza();
        zzoVarZza.zza(9);
        zzoVarZza.zzb(application.getPackageName());
        zzq zzqVarZzc = zzoVarZza.zzc();
        com.google.android.gms.games.internal.zzg zzgVarZzb = com.google.android.gms.games.internal.zzg.zzb(application);
        zzbl zzblVar = new zzbl(application, zzgVarZzb, com.google.android.gms.games.internal.v2.resolution.zzb.zza(), new zzbp(application, zzgVarZzb, new zzaw(application, zzqVarZzc), null), null);
        while (!d.a(atomicReference, null, zzblVar) && atomicReference.get() == null) {
        }
        return (zzav) Preconditions.checkNotNull((zzav) zza.get());
    }
}

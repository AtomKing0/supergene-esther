package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzar {
    private final zzav zza;

    private zzar(zzav zzavVar) {
        this.zza = zzavVar;
    }

    public static zzar zza(Application application) {
        return new zzar(zzax.zza(application));
    }

    public final Task zzb(zzaq zzaqVar) {
        zzav zzavVar = this.zza;
        zzaqVar.getClass();
        return zzavVar.zzd(new zzap(zzaqVar));
    }
}

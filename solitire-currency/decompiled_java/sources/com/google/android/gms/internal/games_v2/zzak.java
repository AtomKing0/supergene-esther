package com.google.android.gms.internal.games_v2;

import androidx.compose.animation.core.d;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzak {
    private final AtomicReference zza = new AtomicReference();

    protected abstract zzaj zza();

    public final void zzb() {
        zzaj zzajVar = (zzaj) this.zza.get();
        if (zzajVar != null) {
            zzajVar.zzd();
        }
    }

    public final void zzc(String str, int i10) {
        zzaj zzajVar = (zzaj) this.zza.get();
        if (zzajVar == null) {
            zzaj zzajVarZza = zza();
            AtomicReference atomicReference = this.zza;
            while (true) {
                if (d.a(atomicReference, null, zzajVarZza)) {
                    zzajVar = zzajVarZza;
                    break;
                } else if (atomicReference.get() != null) {
                    zzajVar = (zzaj) this.zza.get();
                    break;
                }
            }
        }
        zzajVar.zzc(str, i10);
    }
}

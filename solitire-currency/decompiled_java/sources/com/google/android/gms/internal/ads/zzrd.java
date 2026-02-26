package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzrd {
    public final int zza;

    @Nullable
    public final zzui zzb;
    private final CopyOnWriteArrayList zzc;

    private zzrd(CopyOnWriteArrayList copyOnWriteArrayList, int i10, @Nullable zzui zzuiVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuiVar;
    }

    @CheckResult
    public final zzrd zza(int i10, @Nullable zzui zzuiVar) {
        return new zzrd(this.zzc, 0, zzuiVar);
    }

    public final void zzb(Handler handler, zzre zzreVar) {
        this.zzc.add(new zzrc(handler, zzreVar));
    }

    public final void zzc(zzre zzreVar) {
        for (zzrc zzrcVar : this.zzc) {
            if (zzrcVar.zza == zzreVar) {
                this.zzc.remove(zzrcVar);
            }
        }
    }

    public zzrd() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgf {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgcu zzc;

    public zzfgf(Callable callable, zzgcu zzgcuVar) {
        this.zzb = callable;
        this.zzc = zzgcuVar;
    }

    public final synchronized m zza() {
        zzc(1);
        return (m) this.zza.poll();
    }

    public final synchronized void zzb(m mVar) {
        this.zza.addFirst(mVar);
    }

    public final synchronized void zzc(int i10) {
        int size = i10 - this.zza.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfiv {
    public static final zzfjc zza(Callable callable, Object obj, zzfjd zzfjdVar) {
        return zzb(callable, zzfjdVar.zzb, obj, zzfjdVar);
    }

    public static final zzfjc zzb(Callable callable, zzgcu zzgcuVar, Object obj, zzfjd zzfjdVar) {
        return new zzfjc(zzfjdVar, obj, zzfjd.zza, Collections.emptyList(), zzgcuVar.zzb(callable));
    }

    public static final zzfjc zzc(m mVar, Object obj, zzfjd zzfjdVar) {
        return new zzfjc(zzfjdVar, obj, zzfjd.zza, Collections.emptyList(), mVar);
    }

    public static final zzfjc zzd(final zzfip zzfipVar, zzgcu zzgcuVar, Object obj, zzfjd zzfjdVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfiu
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                zzfipVar.zza();
                return null;
            }
        }, zzgcuVar, obj, zzfjdVar);
    }
}

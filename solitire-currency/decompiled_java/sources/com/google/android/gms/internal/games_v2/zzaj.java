package com.google.android.gms.internal.games_v2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaj {
    private final Handler zza;
    private boolean zzc;
    final Object zzb = new Object();
    private final HashMap zzd = new HashMap();

    public zzaj(Looper looper, int i10) {
        this.zza = new zzfa(looper);
    }

    static /* bridge */ /* synthetic */ void zzb(zzaj zzajVar) {
        synchronized (zzajVar.zzb) {
            zzajVar.zzc = false;
            zzajVar.zzd();
        }
    }

    protected abstract void zza(String str, int i10);

    public final void zzc(String str, int i10) {
        synchronized (this.zzb) {
            if (!this.zzc) {
                this.zzc = true;
                this.zza.postDelayed(new zzai(this), 1000L);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzd.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzd.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i10);
        }
    }

    public final void zzd() {
        synchronized (this.zzb) {
            for (Map.Entry entry : this.zzd.entrySet()) {
                zza((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzd.clear();
        }
    }
}

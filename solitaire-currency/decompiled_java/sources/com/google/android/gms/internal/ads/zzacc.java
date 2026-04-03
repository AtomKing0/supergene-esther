package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzacc {
    private final zzacb zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzacc(zzacb zzacbVar) {
        this.zza = zzacbVar;
    }

    @Nullable
    public final zzack zza(Object... objArr) {
        Constructor constructorZza;
        synchronized (this.zzb) {
            if (!this.zzb.get()) {
                try {
                    constructorZza = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                    constructorZza = null;
                } catch (Exception e10) {
                    throw new RuntimeException("Error instantiating extension", e10);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzack) constructorZza.newInstance(objArr);
        } catch (Exception e11) {
            throw new IllegalStateException("Unexpected error creating extractor", e11);
        }
    }
}

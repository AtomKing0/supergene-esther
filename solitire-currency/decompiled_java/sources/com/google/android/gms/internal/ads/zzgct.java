package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgct {
    private final String zza;
    private volatile Logger zzb;

    zzgct(Class cls) {
        this.zza = cls.getName();
    }

    final Logger zza() {
        Logger logger = this.zzb;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            Logger logger2 = this.zzb;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.zza);
            this.zzb = logger3;
            return logger3;
        }
    }
}

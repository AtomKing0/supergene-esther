package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawv extends zzaxd {
    private final StackTraceElement[] zzh;

    public zzawv(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11, StackTraceElement[] stackTraceElementArr) {
        super(zzavpVar, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzaroVar, i10, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzavg zzavgVar = new zzavg((String) this.zze.invoke(null, stackTraceElementArr));
            synchronized (this.zzd) {
                this.zzd.zzF(zzavgVar.zza.longValue());
                if (zzavgVar.zzb.booleanValue()) {
                    this.zzd.zzac(true != zzavgVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    this.zzd.zzac(3);
                }
            }
        }
    }
}

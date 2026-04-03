package com.google.android.gms.internal.measurement;

import e5.o;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhv {
    private final boolean zza;

    public zzhv(zzhu zzhuVar) {
        o.k(zzhuVar, "BuildInfo must be non-null");
        this.zza = !zzhuVar.zza();
    }

    public final boolean zza(String str) {
        o.k(str, "flagName must not be null");
        if (this.zza) {
            return zzhx.zza.get().d(str);
        }
        return true;
    }
}

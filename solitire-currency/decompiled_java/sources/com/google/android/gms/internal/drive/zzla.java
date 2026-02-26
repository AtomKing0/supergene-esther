package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzla {
    private static final zzla zztm;
    private static final zzla zztn;

    static {
        zzlb zzlbVar = null;
        zztm = new zzlc();
        zztn = new zzld();
    }

    private zzla() {
    }

    static zzla zzdt() {
        return zztm;
    }

    static zzla zzdu() {
        return zztn;
    }

    abstract void zza(Object obj, long j10);

    abstract <L> void zza(Object obj, Object obj2, long j10);
}

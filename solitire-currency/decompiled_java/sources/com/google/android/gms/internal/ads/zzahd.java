package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahd implements zzahf {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzahl zzc = new zzahl();
    private zzahe zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzacl zzaclVar, int i10) throws IOException {
        ((zzaby) zzaclVar).zzn(this.zza, 0, i10, false);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 8) | ((long) (this.zza[i11] & 255));
        }
        return j10;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(zzahe zzaheVar) {
        this.zzd = zzaheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2 A[LOOP:0: B:3:0x0005->B:37:0x00b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016b A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzahf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahd.zzc(com.google.android.gms.internal.ads.zzacl):boolean");
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztm implements zzug, zzuf {
    public final zzug zza;
    long zzb;

    @Nullable
    private zzuf zzc;
    private zztl[] zzd = new zztl[0];
    private long zze = 0;

    public zztm(zzug zzugVar, boolean z10, long j10, long j11) {
        this.zza = zzugVar;
        this.zzb = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j10, zzlj zzljVar) {
        if (j10 == 0) {
            return 0L;
        }
        long jMax = Math.max(0L, Math.min(zzljVar.zzc, j10));
        long j11 = zzljVar.zzd;
        long j12 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j11, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j10));
        if (jMax != zzljVar.zzc || jMax2 != zzljVar.zzd) {
            zzljVar = new zzlj(jMax, jMax2);
        }
        return this.zza.zza(j10, zzljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb != Long.MIN_VALUE) {
            long j10 = this.zzb;
            if (j10 == Long.MIN_VALUE || jZzb < j10) {
                return jZzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc != Long.MIN_VALUE) {
            long j10 = this.zzb;
            if (j10 == Long.MIN_VALUE || jZzc < j10) {
                return jZzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        if (zzq()) {
            long j10 = this.zze;
            this.zze = C.TIME_UNSET;
            long jZzd = zzd();
            return jZzd != C.TIME_UNSET ? jZzd : j10;
        }
        long jZzd2 = this.zza.zzd();
        if (jZzd2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        zzdi.zzf(jZzd2 >= 0);
        long j11 = this.zzb;
        zzdi.zzf(j11 == Long.MIN_VALUE || jZzd2 <= j11);
        return jZzd2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zze(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zztl[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.zzc()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.gms.internal.ads.zzug r0 = r7.zza
            long r0 = r0.zze(r8)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r9 = 1
            if (r8 == 0) goto L35
            r3 = 0
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 < 0) goto L36
            long r3 = r7.zzb
            r5 = -9223372036854775808
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L35
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 > 0) goto L36
        L35:
            r2 = r9
        L36:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztm.zze(long):long");
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzg(com.google.android.gms.internal.ads.zzxv[] r15, boolean[] r16, com.google.android.gms.internal.ads.zzvx[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            int r2 = r1.length
            com.google.android.gms.internal.ads.zztl[] r3 = new com.google.android.gms.internal.ads.zztl[r2]
            r0.zzd = r3
            com.google.android.gms.internal.ads.zzvx[] r2 = new com.google.android.gms.internal.ads.zzvx[r2]
            r3 = 0
            r4 = r3
        Lc:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L21
            com.google.android.gms.internal.ads.zztl[] r5 = r0.zzd
            r6 = r1[r4]
            com.google.android.gms.internal.ads.zztl r6 = (com.google.android.gms.internal.ads.zztl) r6
            r5[r4] = r6
            if (r6 == 0) goto L1c
            com.google.android.gms.internal.ads.zzvx r11 = r6.zza
        L1c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto Lc
        L21:
            com.google.android.gms.internal.ads.zzug r4 = r0.zza
            r5 = r15
            r6 = r16
            r7 = r2
            r8 = r18
            r9 = r19
            long r4 = r4.zzg(r5, r6, r7, r8, r9)
            boolean r6 = r14.zzq()
            r7 = 0
            if (r6 == 0) goto L3d
            int r6 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r6 != 0) goto L3d
            r9 = r7
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zze = r12
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            r9 = 1
            if (r6 == 0) goto L5d
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 < 0) goto L5c
            long r6 = r0.zzb
            r12 = -9223372036854775808
            int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r8 == 0) goto L5d
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L5c
            goto L5d
        L5c:
            r9 = r3
        L5d:
            com.google.android.gms.internal.ads.zzdi.zzf(r9)
        L60:
            int r6 = r1.length
            if (r3 >= r6) goto L86
            r6 = r2[r3]
            if (r6 != 0) goto L6c
            com.google.android.gms.internal.ads.zztl[] r6 = r0.zzd
            r6[r3] = r11
            goto L7d
        L6c:
            com.google.android.gms.internal.ads.zztl[] r7 = r0.zzd
            r8 = r7[r3]
            if (r8 == 0) goto L76
            com.google.android.gms.internal.ads.zzvx r8 = r8.zza
            if (r8 == r6) goto L7d
        L76:
            com.google.android.gms.internal.ads.zztl r8 = new com.google.android.gms.internal.ads.zztl
            r8.<init>(r14, r6)
            r7[r3] = r8
        L7d:
            com.google.android.gms.internal.ads.zztl[] r6 = r0.zzd
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L60
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztm.zzg(com.google.android.gms.internal.ads.zzxv[], boolean[], com.google.android.gms.internal.ads.zzvx[], boolean[], long):long");
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j10, boolean z10) {
        this.zza.zzj(j10, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j10) {
        this.zzc = zzufVar;
        this.zza.zzl(this, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j10) {
        this.zza.zzm(j10);
    }

    public final void zzn(long j10, long j11) {
        this.zzb = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        return this.zza.zzo(zzkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zza.zzp();
    }

    final boolean zzq() {
        return this.zze != C.TIME_UNSET;
    }
}

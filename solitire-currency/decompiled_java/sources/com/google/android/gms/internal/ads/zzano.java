package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzano implements zzack {
    private final int zza;
    private final List zzb;
    private final zzek zzc;
    private final SparseIntArray zzd;
    private final zzanr zze;
    private final zzajy zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzanl zzj;
    private zzank zzk;
    private zzacn zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzano() {
        this(1, 1, zzajy.zza, new zzer(0L), new zzamc(0), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bd  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.google.android.gms.internal.ads.zzamz] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.android.gms.internal.ads.zzant] */
    /* JADX WARN: Type inference failed for: r8v6 */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r19, com.google.android.gms.internal.ads.zzadf r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        if (this.zza == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zzf);
        }
        this.zzl = zzacnVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(long r9, long r11) {
        /*
            r8 = this;
            java.util.List r9 = r8.zzb
            int r9 = r9.size()
            r10 = 0
            r0 = r10
        L8:
            r1 = 0
            if (r0 >= r9) goto L37
            java.util.List r3 = r8.zzb
            java.lang.Object r3 = r3.get(r0)
            com.google.android.gms.internal.ads.zzer r3 = (com.google.android.gms.internal.ads.zzer) r3
            long r4 = r3.zzf()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L31
            long r4 = r3.zzd()
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 == 0) goto L34
            int r1 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r1 == 0) goto L34
        L31:
            r3.zzi(r11)
        L34:
            int r0 = r0 + 1
            goto L8
        L37:
            int r9 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r9 == 0) goto L42
            com.google.android.gms.internal.ads.zzank r9 = r8.zzk
            if (r9 == 0) goto L42
            r9.zzd(r11)
        L42:
            com.google.android.gms.internal.ads.zzek r9 = r8.zzc
            r9.zzH(r10)
            android.util.SparseIntArray r9 = r8.zzd
            r9.clear()
            r9 = r10
        L4d:
            android.util.SparseArray r11 = r8.zzg
            int r11 = r11.size()
            if (r9 >= r11) goto L63
            android.util.SparseArray r11 = r8.zzg
            java.lang.Object r11 = r11.valueAt(r9)
            com.google.android.gms.internal.ads.zzant r11 = (com.google.android.gms.internal.ads.zzant) r11
            r11.zzc()
            int r9 = r9 + 1
            goto L4d
        L63:
            r8.zzq = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzi(long, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(com.google.android.gms.internal.ads.zzacl r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzek r0 = r6.zzc
            byte[] r0 = r0.zzM()
            com.google.android.gms.internal.ads.zzaby r7 = (com.google.android.gms.internal.ads.zzaby) r7
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.zzm(r0, r2, r1, r2)
            r1 = r2
        Lf:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L2b
            r3 = r2
        L14:
            r4 = 5
            if (r3 >= r4) goto L26
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L23
            int r1 = r1 + 1
            goto Lf
        L23:
            int r3 = r3 + 1
            goto L14
        L26:
            r7.zzo(r1, r2)
            r7 = 1
            return r7
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzj(com.google.android.gms.internal.ads.zzacl):boolean");
    }

    public zzano(int i10, int i11, zzajy zzajyVar, zzer zzerVar, zzanr zzanrVar, int i12) {
        this.zze = zzanrVar;
        this.zza = i11;
        this.zzf = zzajyVar;
        this.zzb = Collections.singletonList(zzerVar);
        this.zzc = new zzek(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzanl(TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
        this.zzl = zzacn.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i13 = 0; i13 < size; i13++) {
            this.zzg.put(sparseArray2.keyAt(i13), (zzant) sparseArray2.valueAt(i13));
        }
        this.zzg.put(0, new zzanh(new zzanm(this)));
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}

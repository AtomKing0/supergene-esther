package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvj implements zzug, zzacn, zzyp, zzyu, zzvv {
    private static final Map zzb;
    private static final zzaf zzc;
    private zzadi zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private boolean zzH;
    private long zzI;
    private boolean zzK;
    private int zzL;
    private boolean zzM;
    private boolean zzN;
    private final zzyk zzO;
    private final Uri zzd;
    private final zzfs zze;
    private final zzri zzf;
    private final zzur zzg;
    private final zzrd zzh;
    private final zzvf zzi;
    private final long zzj;
    private final long zzk;
    private final zzuy zzm;

    @Nullable
    private zzuf zzr;

    @Nullable
    private zzafn zzs;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzvi zzz;
    private final zzyx zzl = new zzyx("ProgressiveMediaPeriod");
    private final zzdm zzn = new zzdm(zzdj.zza);
    private final Runnable zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzva
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzU();
        }
    };
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvb
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzq = zzet.zzx(null);
    private zzvh[] zzu = new zzvh[0];
    private zzvw[] zzt = new zzvw[0];
    private long zzJ = C.TIME_UNSET;
    private int zzD = 1;

    static {
        HashMap map = new HashMap();
        map.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        zzb = Collections.unmodifiableMap(map);
        zzad zzadVar = new zzad();
        zzadVar.zzK("icy");
        zzadVar.zzX(MimeTypes.APPLICATION_ICY);
        zzc = zzadVar.zzad();
    }

    public zzvj(Uri uri, zzfs zzfsVar, zzuy zzuyVar, zzri zzriVar, zzrd zzrdVar, zzyo zzyoVar, zzur zzurVar, zzvf zzvfVar, zzyk zzykVar, @Nullable String str, int i10, long j10) {
        this.zzd = uri;
        this.zze = zzfsVar;
        this.zzf = zzriVar;
        this.zzh = zzrdVar;
        this.zzg = zzurVar;
        this.zzi = zzvfVar;
        this.zzO = zzykVar;
        this.zzj = i10;
        this.zzm = zzuyVar;
        this.zzk = j10;
    }

    static /* bridge */ /* synthetic */ void zzC(final zzvj zzvjVar) {
        zzvjVar.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzuz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzF();
            }
        });
    }

    private final int zzQ() {
        int iZzd = 0;
        for (zzvw zzvwVar : this.zzt) {
            iZzd += zzvwVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzR(boolean r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzvw[] r3 = r5.zzt
            int r4 = r3.length
            if (r0 >= r4) goto L22
            if (r6 != 0) goto L15
            com.google.android.gms.internal.ads.zzvi r4 = r5.zzz
            r4.getClass()
            boolean[] r4 = r4.zzc
            boolean r4 = r4[r0]
            if (r4 == 0) goto L1f
        L15:
            r3 = r3[r0]
            long r3 = r3.zzh()
            long r1 = java.lang.Math.max(r1, r3)
        L1f:
            int r0 = r0 + 1
            goto L3
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzR(boolean):long");
    }

    private final zzadp zzS(zzvh zzvhVar) {
        int length = this.zzt.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (zzvhVar.equals(this.zzu[i10])) {
                return this.zzt[i10];
            }
        }
        zzvw zzvwVar = new zzvw(this.zzO, this.zzf, this.zzh);
        zzvwVar.zzu(this);
        int i11 = length + 1;
        zzvh[] zzvhVarArr = (zzvh[]) Arrays.copyOf(this.zzu, i11);
        zzvhVarArr[length] = zzvhVar;
        int i12 = zzet.zza;
        this.zzu = zzvhVarArr;
        zzvw[] zzvwVarArr = (zzvw[]) Arrays.copyOf(this.zzt, i11);
        zzvwVarArr[length] = zzvwVar;
        this.zzt = zzvwVarArr;
        return zzvwVar;
    }

    private final void zzT() {
        zzdi.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU() {
        int i10;
        if (this.zzN || this.zzw || !this.zzv || this.zzA == null) {
            return;
        }
        for (zzvw zzvwVar : this.zzt) {
            if (zzvwVar.zzi() == null) {
                return;
            }
        }
        this.zzn.zzc();
        int length = this.zzt.length;
        zzcd[] zzcdVarArr = new zzcd[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            zzaf zzafVarZzi = this.zzt[i11].zzi();
            zzafVarZzi.getClass();
            String str = zzafVarZzi.zzm;
            boolean zZzg = zzbn.zzg(str);
            boolean z10 = zZzg || zzbn.zzi(str);
            zArr[i11] = z10;
            this.zzx = z10 | this.zzx;
            this.zzy = this.zzk != C.TIME_UNSET && length == 1 && zzbn.zzh(str);
            zzafn zzafnVar = this.zzs;
            if (zzafnVar != null) {
                if (zZzg || this.zzu[i11].zzb) {
                    zzbk zzbkVar = zzafVarZzi.zzk;
                    zzbk zzbkVar2 = zzbkVar == null ? new zzbk(C.TIME_UNSET, zzafnVar) : zzbkVar.zzc(zzafnVar);
                    zzad zzadVarZzb = zzafVarZzi.zzb();
                    zzadVarZzb.zzQ(zzbkVar2);
                    zzafVarZzi = zzadVarZzb.zzad();
                }
                if (zZzg && zzafVarZzi.zzg == -1 && zzafVarZzi.zzh == -1 && (i10 = zzafnVar.zza) != -1) {
                    zzad zzadVarZzb2 = zzafVarZzi.zzb();
                    zzadVarZzb2.zzx(i10);
                    zzafVarZzi = zzadVarZzb2.zzad();
                }
            }
            zzcdVarArr[i11] = new zzcd(Integer.toString(i11), zzafVarZzi.zzc(this.zzf.zza(zzafVarZzi)));
        }
        this.zzz = new zzvi(new zzwi(zzcdVarArr), zArr);
        if (this.zzy && this.zzB == C.TIME_UNSET) {
            this.zzB = this.zzk;
            this.zzA = new zzvd(this, this.zzA);
        }
        this.zzi.zza(this.zzB, this.zzA.zzh(), this.zzC);
        this.zzw = true;
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzh(this);
    }

    private final void zzV(int i10) {
        zzT();
        zzvi zzviVar = this.zzz;
        boolean[] zArr = zzviVar.zzd;
        if (zArr[i10]) {
            return;
        }
        zzaf zzafVarZzb = zzviVar.zza.zzb(i10).zzb(0);
        this.zzg.zzc(new zzue(1, zzbn.zzb(zzafVarZzb.zzm), zzafVarZzb, 0, null, zzet.zzu(this.zzI), C.TIME_UNSET));
        zArr[i10] = true;
    }

    private final void zzW(int i10) {
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (this.zzK && zArr[i10] && !this.zzt[i10].zzx(false)) {
            this.zzJ = 0L;
            this.zzK = false;
            this.zzF = true;
            this.zzI = 0L;
            this.zzL = 0;
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzp(false);
            }
            zzuf zzufVar = this.zzr;
            zzufVar.getClass();
            zzufVar.zzf(this);
        }
    }

    private final void zzX() {
        zzve zzveVar = new zzve(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdi.zzf(zzY());
            long j10 = this.zzB;
            if (j10 != C.TIME_UNSET && this.zzJ > j10) {
                this.zzM = true;
                this.zzJ = C.TIME_UNSET;
                return;
            }
            zzadi zzadiVar = this.zzA;
            zzadiVar.getClass();
            zzve.zzf(zzveVar, zzadiVar.zzg(this.zzJ).zza.zzc, this.zzJ);
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzt(this.zzJ);
            }
            this.zzJ = C.TIME_UNSET;
        }
        this.zzL = zzQ();
        long jZza = this.zzl.zza(zzveVar, this, zzyo.zza(this.zzD));
        this.zzg.zzg(new zztz(zzveVar.zzb, zzveVar.zzl, jZza), new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
    }

    private final boolean zzY() {
        return this.zzJ != C.TIME_UNSET;
    }

    private final boolean zzZ() {
        return this.zzF || zzY();
    }

    static /* bridge */ /* synthetic */ long zzr(zzvj zzvjVar, boolean z10) {
        return zzvjVar.zzR(true);
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzD() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    final /* synthetic */ void zzE() {
        if (this.zzN) {
            return;
        }
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    final /* synthetic */ void zzF() {
        this.zzH = true;
    }

    final /* synthetic */ void zzG(zzadi zzadiVar) {
        this.zzA = this.zzs == null ? zzadiVar : new zzadh(C.TIME_UNSET, 0L);
        this.zzB = zzadiVar.zza();
        boolean z10 = false;
        if (!this.zzH && zzadiVar.zza() == C.TIME_UNSET) {
            z10 = true;
        }
        this.zzC = z10;
        this.zzD = true == z10 ? 7 : 1;
        if (this.zzw) {
            this.zzi.zza(this.zzB, zzadiVar.zzh(), this.zzC);
        } else {
            zzU();
        }
    }

    final void zzH() throws IOException {
        this.zzl.zzi(zzyo.zza(this.zzD));
    }

    final void zzI(int i10) throws IOException {
        this.zzt[i10].zzm();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ void zzJ(zzyt zzytVar, long j10, long j11, boolean z10) {
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j10, j11, zzgtVar.zzg());
        long unused = zzveVar.zzb;
        this.zzg.zzd(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
        if (z10) {
            return;
        }
        for (zzvw zzvwVar : this.zzt) {
            zzvwVar.zzp(false);
        }
        if (this.zzG > 0) {
            zzuf zzufVar = this.zzr;
            zzufVar.getClass();
            zzufVar.zzf(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ void zzK(zzyt zzytVar, long j10, long j11) {
        zzadi zzadiVar;
        if (this.zzB == C.TIME_UNSET && (zzadiVar = this.zzA) != null) {
            boolean zZzh = zzadiVar.zzh();
            long jZzR = zzR(true);
            long j12 = jZzR == Long.MIN_VALUE ? 0L : jZzR + 10000;
            this.zzB = j12;
            this.zzi.zza(j12, zZzh, this.zzC);
        }
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j10, j11, zzgtVar.zzg());
        long unused = zzveVar.zzb;
        this.zzg.zze(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
        this.zzM = true;
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final void zzL() {
        for (zzvw zzvwVar : this.zzt) {
            zzvwVar.zzo();
        }
        this.zzm.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzvv
    public final void zzM(zzaf zzafVar) {
        this.zzq.post(this.zzo);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzn();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzN = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzO(final zzadi zzadiVar) {
        this.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(zzadiVar);
            }
        });
    }

    final boolean zzP(int i10) {
        return !zzZ() && this.zzt[i10].zzx(this.zzM);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j10, zzlj zzljVar) {
        zzT();
        if (!this.zzA.zzh()) {
            return 0L;
        }
        zzadg zzadgVarZzg = this.zzA.zzg(j10);
        zzadj zzadjVar = zzadgVarZzg.zza;
        zzadj zzadjVar2 = zzadgVarZzg.zzb;
        long j11 = zzljVar.zzc;
        if (j11 == 0) {
            if (zzljVar.zzd == 0) {
                return j10;
            }
            j11 = 0;
        }
        long j12 = zzadjVar.zzb;
        int i10 = zzet.zza;
        long j13 = j10 - j11;
        long j14 = zzljVar.zzd;
        long j15 = j10 + j14;
        long j16 = j10 ^ j15;
        long j17 = j14 ^ j15;
        if (((j10 ^ j11) & (j10 ^ j13)) < 0) {
            j13 = Long.MIN_VALUE;
        }
        if ((j16 & j17) < 0) {
            j15 = Long.MAX_VALUE;
        }
        boolean z10 = j13 <= j12 && j12 <= j15;
        long j18 = zzadjVar2.zzb;
        boolean z11 = j13 <= j18 && j18 <= j15;
        if (z10 && z11) {
            if (Math.abs(j12 - j10) > Math.abs(j18 - j10)) {
                return j18;
            }
        } else if (!z10) {
            return z11 ? j18 : j13;
        }
        return j12;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jZzR;
        zzT();
        if (this.zzM || this.zzG == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzJ;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzR = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                zzvi zzviVar = this.zzz;
                if (zzviVar.zzb[i10] && zzviVar.zzc[i10] && !this.zzt[i10].zzw()) {
                    jZzR = Math.min(jZzR, this.zzt[i10].zzh());
                }
            }
        } else {
            jZzR = Long.MAX_VALUE;
        }
        if (jZzR == Long.MAX_VALUE) {
            jZzR = zzR(false);
        }
        return jZzR == Long.MIN_VALUE ? this.zzI : jZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        if (!this.zzF) {
            return C.TIME_UNSET;
        }
        if (!this.zzM && zzQ() <= this.zzL) {
            return C.TIME_UNSET;
        }
        this.zzF = false;
        return this.zzI;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zze(long r7) {
        /*
            r6 = this;
            r6.zzT()
            com.google.android.gms.internal.ads.zzvi r0 = r6.zzz
            boolean[] r0 = r0.zzb
            com.google.android.gms.internal.ads.zzadi r1 = r6.zzA
            boolean r1 = r1.zzh()
            r2 = 1
            if (r2 == r1) goto L12
            r7 = 0
        L12:
            r1 = 0
            r6.zzF = r1
            r6.zzI = r7
            boolean r2 = r6.zzY()
            if (r2 == 0) goto L20
            r6.zzJ = r7
            return r7
        L20:
            int r2 = r6.zzD
            r3 = 7
            if (r2 == r3) goto L4e
            com.google.android.gms.internal.ads.zzvw[] r2 = r6.zzt
            int r2 = r2.length
            r3 = r1
        L29:
            if (r3 >= r2) goto L80
            com.google.android.gms.internal.ads.zzvw[] r4 = r6.zzt
            r4 = r4[r3]
            boolean r5 = r6.zzy
            if (r5 == 0) goto L3c
            int r5 = r4.zza()
            boolean r4 = r4.zzy(r5)
            goto L40
        L3c:
            boolean r4 = r4.zzz(r7, r1)
        L40:
            if (r4 != 0) goto L4b
            boolean r4 = r0[r3]
            if (r4 != 0) goto L4e
            boolean r4 = r6.zzx
            if (r4 != 0) goto L4b
            goto L4e
        L4b:
            int r3 = r3 + 1
            goto L29
        L4e:
            r6.zzK = r1
            r6.zzJ = r7
            r6.zzM = r1
            com.google.android.gms.internal.ads.zzyx r0 = r6.zzl
            boolean r2 = r0.zzl()
            if (r2 == 0) goto L6f
            com.google.android.gms.internal.ads.zzvw[] r0 = r6.zzt
            int r2 = r0.length
        L5f:
            if (r1 >= r2) goto L69
            r3 = r0[r1]
            r3.zzk()
            int r1 = r1 + 1
            goto L5f
        L69:
            com.google.android.gms.internal.ads.zzyx r0 = r6.zzl
            r0.zzg()
            goto L80
        L6f:
            r0.zzh()
            com.google.android.gms.internal.ads.zzvw[] r0 = r6.zzt
            int r2 = r0.length
            r3 = r1
        L76:
            if (r3 >= r2) goto L80
            r4 = r0[r3]
            r4.zzp(r1)
            int r3 = r3 + 1
            goto L76
        L80:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zze(long):long");
    }

    final int zzf(int i10, zzjz zzjzVar, zzhd zzhdVar, int i11) {
        if (zzZ()) {
            return -3;
        }
        zzV(i10);
        int iZze = this.zzt[i10].zze(zzjzVar, zzhdVar, i11, this.zzM);
        if (iZze == -3) {
            zzW(i10);
        }
        return iZze;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzg(com.google.android.gms.internal.ads.zzxv[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzvx[] r10, boolean[] r11, long r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzg(com.google.android.gms.internal.ads.zzxv[], boolean[], com.google.android.gms.internal.ads.zzvx[], boolean[], long):long");
    }

    final int zzh(int i10, long j10) {
        if (zzZ()) {
            return 0;
        }
        zzV(i10);
        zzvw zzvwVar = this.zzt[i10];
        int iZzc = zzvwVar.zzc(j10, this.zzM);
        zzvwVar.zzv(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzW(i10);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        zzT();
        return this.zzz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j10, boolean z10) {
        if (this.zzy) {
            return;
        }
        zzT();
        if (zzY()) {
            return;
        }
        boolean[] zArr = this.zzz.zzc;
        int length = this.zzt.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.zzt[i10].zzj(j10, false, zArr[i10]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() throws IOException {
        zzH();
        if (this.zzM && !this.zzw) {
            throw zzbo.zza("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j10) {
        this.zzr = zzufVar;
        this.zzn.zze();
        zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        if (this.zzM) {
            return false;
        }
        zzyx zzyxVar = this.zzl;
        if (zzyxVar.zzk() || this.zzK) {
            return false;
        }
        if (this.zzw && this.zzG == 0) {
            return false;
        }
        boolean zZze = this.zzn.zze();
        if (zzyxVar.zzl()) {
            return zZze;
        }
        zzX();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zzl.zzl() && this.zzn.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ zzyr zzu(zzyt zzytVar, long j10, long j11, IOException iOException, int i10) {
        long jMin;
        zzyr zzyrVarZzb;
        zzadi zzadiVar;
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j10, j11, zzgtVar.zzg());
        long unused = zzveVar.zzk;
        int i11 = zzet.zza;
        if ((iOException instanceof zzbo) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgk) || (iOException instanceof zzyw)) {
            jMin = -9223372036854775807L;
            break;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzft) && ((zzft) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i10 - 1) * 1000, 5000);
        if (jMin == C.TIME_UNSET) {
            zzyrVarZzb = zzyx.zzb;
        } else {
            int iZzQ = zzQ();
            boolean z10 = iZzQ > this.zzL;
            if (this.zzH || !((zzadiVar = this.zzA) == null || zzadiVar.zza() == C.TIME_UNSET)) {
                this.zzL = iZzQ;
            } else {
                boolean z11 = this.zzw;
                if (!z11 || zzZ()) {
                    this.zzF = z11;
                    this.zzI = 0L;
                    this.zzL = 0;
                    for (zzvw zzvwVar : this.zzt) {
                        zzvwVar.zzp(false);
                    }
                    zzve.zzf(zzveVar, 0L, 0L);
                } else {
                    this.zzK = true;
                    zzyrVarZzb = zzyx.zza;
                }
            }
            zzyrVarZzb = zzyx.zzb(z10, jMin);
        }
        boolean z12 = !zzyrVarZzb.zzc();
        this.zzg.zzf(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)), iOException, z12);
        if (z12) {
            long unused2 = zzveVar.zzb;
        }
        return zzyrVarZzb;
    }

    final zzadp zzv() {
        return zzS(new zzvh(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final zzadp zzw(int i10, int i11) {
        return zzS(new zzvh(i10, false));
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j10) {
    }
}

package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjx implements Handler.Callback, zzuf, zzya, zzkv, zzhu, zzky {
    private static final long zza = zzet.zzu(10000);
    private boolean zzA;
    private boolean zzB;
    private boolean zzD;
    private boolean zzG;
    private int zzH;

    @Nullable
    private zzjw zzI;
    private long zzJ;
    private long zzK;
    private int zzL;
    private boolean zzM;

    @Nullable
    private zzhw zzN;
    private zzig zzP;
    private final zzii zzQ;
    private final zzhq zzR;
    private final zzle[] zzb;
    private final Set zzc;
    private final zzlh[] zzd;
    private final zzyb zze;
    private final zzyc zzf;
    private final zzkb zzg;
    private final zzyj zzh;
    private final zzdt zzi;

    @Nullable
    private final HandlerThread zzj;
    private final Looper zzk;
    private final zzcb zzl;
    private final zzca zzm;
    private final long zzn;
    private final zzhv zzo;
    private final ArrayList zzp;
    private final zzdj zzq;
    private final zzkk zzr;
    private final zzkw zzs;
    private final long zzt;
    private final zznz zzu;
    private zzlj zzv;
    private zzkx zzw;
    private zzjv zzx;
    private boolean zzy;
    private int zzE = 0;
    private boolean zzF = false;
    private boolean zzz = false;
    private long zzO = C.TIME_UNSET;
    private long zzC = C.TIME_UNSET;

    public zzjx(zzle[] zzleVarArr, zzyb zzybVar, zzyc zzycVar, zzkb zzkbVar, zzyj zzyjVar, int i10, boolean z10, zzln zzlnVar, zzlj zzljVar, zzhq zzhqVar, long j10, boolean z11, boolean z12, Looper looper, zzdj zzdjVar, zzii zziiVar, zznz zznzVar, Looper looper2, zzig zzigVar) {
        this.zzQ = zziiVar;
        this.zzb = zzleVarArr;
        this.zze = zzybVar;
        this.zzf = zzycVar;
        this.zzg = zzkbVar;
        this.zzh = zzyjVar;
        this.zzv = zzljVar;
        this.zzR = zzhqVar;
        this.zzt = j10;
        this.zzq = zzdjVar;
        this.zzu = zznzVar;
        this.zzP = zzigVar;
        this.zzn = zzkbVar.zzb(zznzVar);
        zzkbVar.zzg(zznzVar);
        zzcc zzccVar = zzcc.zza;
        zzkx zzkxVarZzg = zzkx.zzg(zzycVar);
        this.zzw = zzkxVarZzg;
        this.zzx = new zzjv(zzkxVarZzg);
        int length = zzleVarArr.length;
        this.zzd = new zzlh[2];
        zzlg zzlgVarZze = zzybVar.zze();
        for (int i11 = 0; i11 < 2; i11++) {
            zzleVarArr[i11].zzu(i11, zznzVar, zzdjVar);
            this.zzd[i11] = zzleVarArr[i11].zzl();
            this.zzd[i11].zzL(zzlgVarZze);
        }
        this.zzo = new zzhv(this, zzdjVar);
        this.zzp = new ArrayList();
        this.zzc = Collections.newSetFromMap(new IdentityHashMap());
        this.zzl = new zzcb();
        this.zzm = new zzca();
        zzybVar.zzr(this, zzyjVar);
        this.zzM = true;
        zzdt zzdtVarZzb = zzdjVar.zzb(looper, null);
        this.zzr = new zzkk(zzlnVar, zzdtVarZzb, new zzjp(this), zzigVar);
        this.zzs = new zzkw(this, zzlnVar, zzdtVarZzb, zznzVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.zzj = handlerThread;
        handlerThread.start();
        Looper looper3 = handlerThread.getLooper();
        this.zzk = looper3;
        this.zzi = zzdjVar.zzb(looper3, this);
    }

    private final void zzA() throws zzhw {
        int length = this.zzb.length;
        zzB(new boolean[2], this.zzr.zzf().zzf());
    }

    private final void zzB(boolean[] zArr, long j10) throws zzhw {
        zzkh zzkhVarZzf = this.zzr.zzf();
        zzyc zzycVarZzi = zzkhVarZzf.zzi();
        int i10 = 0;
        while (true) {
            int length = this.zzb.length;
            if (i10 >= 2) {
                break;
            }
            if (!zzycVarZzi.zzb(i10) && this.zzc.remove(this.zzb[i10])) {
                this.zzb[i10].zzI();
            }
            i10++;
        }
        int i11 = 0;
        while (true) {
            int length2 = this.zzb.length;
            if (i11 >= 2) {
                zzkhVarZzf.zzg = true;
                return;
            }
            if (zzycVarZzi.zzb(i11)) {
                boolean z10 = zArr[i11];
                zzle zzleVar = this.zzb[i11];
                if (!zzae(zzleVar)) {
                    zzkk zzkkVar = this.zzr;
                    zzkh zzkhVarZzf2 = zzkkVar.zzf();
                    boolean z11 = zzkhVarZzf2 == zzkkVar.zze();
                    zzyc zzycVarZzi2 = zzkhVarZzf2.zzi();
                    zzli zzliVar = zzycVarZzi2.zzb[i11];
                    zzaf[] zzafVarArrZzaj = zzaj(zzycVarZzi2.zzc[i11]);
                    boolean z12 = zzah() && this.zzw.zze == 3;
                    boolean z13 = !z10 && z12;
                    this.zzH++;
                    this.zzc.add(zzleVar);
                    zzleVar.zzr(zzliVar, zzafVarArrZzaj, zzkhVarZzf2.zzc[i11], this.zzJ, z13, z11, j10, zzkhVarZzf2.zze(), zzkhVarZzf2.zzf.zza);
                    zzleVar.zzt(11, new zzjq(this));
                    this.zzo.zze(zzleVar);
                    if (z12 && z11) {
                        zzleVar.zzO();
                    }
                }
            }
            i11++;
        }
    }

    private final void zzC(IOException iOException, int i10) {
        zzkk zzkkVar = this.zzr;
        zzhw zzhwVarZzc = zzhw.zzc(iOException, i10);
        zzkh zzkhVarZze = zzkkVar.zze();
        if (zzkhVarZze != null) {
            zzhwVarZzc = zzhwVarZzc.zza(zzkhVarZze.zzf.zza);
        }
        zzea.zzd("ExoPlayerImplInternal", "Playback error", zzhwVarZzc);
        zzV(false, false);
        this.zzw = this.zzw.zzd(zzhwVarZzc);
    }

    private final void zzD(boolean z10) {
        zzkh zzkhVarZzd = this.zzr.zzd();
        zzui zzuiVar = zzkhVarZzd == null ? this.zzw.zzb : zzkhVarZzd.zzf.zza;
        boolean z11 = !this.zzw.zzk.equals(zzuiVar);
        if (z11) {
            this.zzw = this.zzw.zza(zzuiVar);
        }
        zzkx zzkxVar = this.zzw;
        zzkxVar.zzp = zzkhVarZzd == null ? zzkxVar.zzr : zzkhVarZzd.zzc();
        this.zzw.zzq = zzs();
        if ((z11 || z10) && zzkhVarZzd != null && zzkhVarZzd.zzd) {
            zzY(zzkhVarZzd.zzf.zza, zzkhVarZzd.zzh(), zzkhVarZzd.zzi());
        }
    }

    /* JADX WARN: Not initialized variable reg: 19, insn: 0x03a5: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r19 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:934), block:B:199:0x03a4 */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0433  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzE(com.google.android.gms.internal.ads.zzcc r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzE(com.google.android.gms.internal.ads.zzcc, boolean):void");
    }

    private final void zzF(zzbq zzbqVar, boolean z10) throws zzhw {
        zzG(zzbqVar, zzbqVar.zzb, true, z10);
    }

    private final void zzG(zzbq zzbqVar, float f10, boolean z10, boolean z11) throws zzhw {
        int i10;
        zzjx zzjxVar = this;
        if (z10) {
            if (z11) {
                zzjxVar.zzx.zza(1);
            }
            zzkx zzkxVar = zzjxVar.zzw;
            zzjxVar = this;
            zzjxVar.zzw = new zzkx(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzd, zzkxVar.zze, zzkxVar.zzf, zzkxVar.zzg, zzkxVar.zzh, zzkxVar.zzi, zzkxVar.zzj, zzkxVar.zzk, zzkxVar.zzl, zzkxVar.zzm, zzbqVar, zzkxVar.zzp, zzkxVar.zzq, zzkxVar.zzr, zzkxVar.zzs, false);
        }
        float f11 = zzbqVar.zzb;
        zzkh zzkhVarZze = zzjxVar.zzr.zze();
        while (true) {
            i10 = 0;
            if (zzkhVarZze == null) {
                break;
            }
            zzxv[] zzxvVarArr = zzkhVarZze.zzi().zzc;
            int length = zzxvVarArr.length;
            while (i10 < length) {
                zzxv zzxvVar = zzxvVarArr[i10];
                i10++;
            }
            zzkhVarZze = zzkhVarZze.zzg();
        }
        zzle[] zzleVarArr = zzjxVar.zzb;
        int length2 = zzleVarArr.length;
        while (i10 < 2) {
            zzle zzleVar = zzleVarArr[i10];
            if (zzleVar != null) {
                zzleVar.zzM(f10, zzbqVar.zzb);
            }
            i10++;
        }
    }

    private final void zzH() {
        long jZze;
        long jZze2;
        boolean zZzh;
        if (zzad()) {
            zzkh zzkhVarZzd = this.zzr.zzd();
            long jZzt = zzt(zzkhVarZzd.zzd());
            if (zzkhVarZzd == this.zzr.zze()) {
                jZze = this.zzJ;
                jZze2 = zzkhVarZzd.zze();
            } else {
                jZze = this.zzJ - zzkhVarZzd.zze();
                jZze2 = zzkhVarZzd.zzf.zzb;
            }
            zzka zzkaVar = new zzka(this.zzu, this.zzw.zza, zzkhVarZzd.zzf.zza, jZze - jZze2, jZzt, this.zzo.zzc().zzb, this.zzw.zzl, this.zzB, zzai(this.zzw.zza, zzkhVarZzd.zzf.zza) ? this.zzR.zzb() : C.TIME_UNSET);
            boolean zZzh2 = this.zzg.zzh(zzkaVar);
            zzkh zzkhVarZze = this.zzr.zze();
            if (zZzh2 || !zzkhVarZze.zzd || jZzt >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzkhVarZze.zza.zzj(this.zzw.zzr, false);
                zZzh = this.zzg.zzh(zzkaVar);
            }
        } else {
            zZzh = false;
        }
        this.zzD = zZzh;
        if (zZzh) {
            this.zzr.zzd().zzk(this.zzJ, this.zzo.zzc().zzb, this.zzC);
        }
        zzX();
    }

    private final void zzI() {
        this.zzx.zzc(this.zzw);
        if (this.zzx.zzg) {
            zzii zziiVar = this.zzQ;
            zziiVar.zza.zzO(this.zzx);
            this.zzx = new zzjv(this.zzw);
        }
    }

    private final void zzJ() throws zzhw {
        int i10;
        float f10 = this.zzo.zzc().zzb;
        zzkk zzkkVar = this.zzr;
        zzkh zzkhVarZze = zzkkVar.zze();
        zzkh zzkhVarZzf = zzkkVar.zzf();
        zzyc zzycVar = null;
        boolean z10 = true;
        while (zzkhVarZze != null && zzkhVarZze.zzd) {
            zzyc zzycVarZzj = zzkhVarZze.zzj(f10, this.zzw.zza);
            zzyc zzycVar2 = zzkhVarZze == this.zzr.zze() ? zzycVarZzj : zzycVar;
            zzyc zzycVarZzi = zzkhVarZze.zzi();
            boolean z11 = false;
            if (zzycVarZzi != null) {
                if (zzycVarZzi.zzc.length == zzycVarZzj.zzc.length) {
                    for (int i11 = 0; i11 < zzycVarZzj.zzc.length; i11++) {
                        if (zzycVarZzj.zza(zzycVarZzi, i11)) {
                        }
                    }
                    if (zzkhVarZze != zzkhVarZzf) {
                        z11 = true;
                    }
                    z10 &= z11;
                    zzkhVarZze = zzkhVarZze.zzg();
                    zzycVar = zzycVar2;
                }
            }
            if (z10) {
                zzkk zzkkVar2 = this.zzr;
                zzkh zzkhVarZze2 = zzkkVar2.zze();
                boolean zZzq = zzkkVar2.zzq(zzkhVarZze2);
                int length = this.zzb.length;
                boolean[] zArr = new boolean[2];
                zzycVar2.getClass();
                long jZzb = zzkhVarZze2.zzb(zzycVar2, this.zzw.zzr, zZzq, zArr);
                zzkx zzkxVar = this.zzw;
                boolean z12 = (zzkxVar.zze == 4 || jZzb == zzkxVar.zzr) ? false : true;
                zzkx zzkxVar2 = this.zzw;
                i10 = 2;
                this.zzw = zzy(zzkxVar2.zzb, jZzb, zzkxVar2.zzc, zzkxVar2.zzd, z12, 5);
                if (z12) {
                    zzN(jZzb);
                }
                int length2 = this.zzb.length;
                boolean[] zArr2 = new boolean[2];
                int i12 = 0;
                while (true) {
                    zzle[] zzleVarArr = this.zzb;
                    int length3 = zzleVarArr.length;
                    if (i12 >= 2) {
                        break;
                    }
                    zzle zzleVar = zzleVarArr[i12];
                    boolean zZzae = zzae(zzleVar);
                    zArr2[i12] = zZzae;
                    zzvx zzvxVar = zzkhVarZze2.zzc[i12];
                    if (zZzae) {
                        if (zzvxVar != zzleVar.zzo()) {
                            zzz(zzleVar);
                        } else if (zArr[i12]) {
                            zzleVar.zzJ(this.zzJ);
                        }
                    }
                    i12++;
                }
                zzB(zArr2, this.zzJ);
            } else {
                i10 = 2;
                this.zzr.zzq(zzkhVarZze);
                if (zzkhVarZze.zzd) {
                    zzkhVarZze.zza(zzycVarZzj, Math.max(zzkhVarZze.zzf.zzb, this.zzJ - zzkhVarZze.zze()), false);
                }
            }
            zzD(true);
            if (this.zzw.zze != 4) {
                zzH();
                zzZ();
                this.zzi.zzi(i10);
                return;
            }
            return;
        }
    }

    private final void zzK() throws zzhw {
        zzJ();
        zzQ(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[PHI: r2 r6 r8
      0x00a3: PHI (r2v2 com.google.android.gms.internal.ads.zzui) = (r2v1 com.google.android.gms.internal.ads.zzui), (r2v11 com.google.android.gms.internal.ads.zzui) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r6v3 long) = (r6v2 long), (r6v10 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r8v3 long) = (r8v2 long), (r8v6 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ee A[PHI: r0
      0x00ee: PHI (r0v11 com.google.android.gms.internal.ads.zzcc) = 
      (r0v10 com.google.android.gms.internal.ads.zzcc)
      (r0v10 com.google.android.gms.internal.ads.zzcc)
      (r0v16 com.google.android.gms.internal.ads.zzcc)
      (r0v16 com.google.android.gms.internal.ads.zzcc)
     binds: [B:36:0x00b2, B:38:0x00b6, B:40:0x00c7, B:42:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzL(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzL(boolean, boolean, boolean, boolean):void");
    }

    private final void zzM() {
        zzkh zzkhVarZze = this.zzr.zze();
        boolean z10 = false;
        if (zzkhVarZze != null && zzkhVarZze.zzf.zzh && this.zzz) {
            z10 = true;
        }
        this.zzA = z10;
    }

    private final void zzN(long j10) throws zzhw {
        zzkh zzkhVarZze = this.zzr.zze();
        long jZze = j10 + (zzkhVarZze == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : zzkhVarZze.zze());
        this.zzJ = jZze;
        this.zzo.zzf(jZze);
        zzle[] zzleVarArr = this.zzb;
        int length = zzleVarArr.length;
        for (int i10 = 0; i10 < 2; i10++) {
            zzle zzleVar = zzleVarArr[i10];
            if (zzae(zzleVar)) {
                zzleVar.zzJ(this.zzJ);
            }
        }
        for (zzkh zzkhVarZze2 = this.zzr.zze(); zzkhVarZze2 != null; zzkhVarZze2 = zzkhVarZze2.zzg()) {
            for (zzxv zzxvVar : zzkhVarZze2.zzi().zzc) {
            }
        }
    }

    private final void zzO(zzcc zzccVar, zzcc zzccVar2) {
        if (zzccVar.zzo() && zzccVar2.zzo()) {
            return;
        }
        int size = this.zzp.size() - 1;
        if (size < 0) {
            Collections.sort(this.zzp);
        } else {
            Object obj = ((zzju) this.zzp.get(size)).zzb;
            int i10 = zzet.zza;
            throw null;
        }
    }

    private final void zzP(long j10) {
        this.zzi.zzj(2, j10 + ((this.zzw.zze != 3 || zzah()) ? zza : 1000L));
    }

    private final void zzQ(boolean z10) throws zzhw {
        zzui zzuiVar = this.zzr.zze().zzf.zza;
        long jZzv = zzv(zzuiVar, this.zzw.zzr, true, false);
        if (jZzv != this.zzw.zzr) {
            zzkx zzkxVar = this.zzw;
            this.zzw = zzy(zzuiVar, jZzv, zzkxVar.zzc, zzkxVar.zzd, z10, 5);
        }
    }

    private final void zzR(zzbq zzbqVar) {
        this.zzi.zzf(16);
        this.zzo.zzg(zzbqVar);
    }

    private final void zzS(boolean z10, int i10, boolean z11, int i11) throws zzhw {
        this.zzx.zza(z11 ? 1 : 0);
        this.zzx.zzb(i11);
        this.zzw = this.zzw.zzc(z10, i10);
        zzab(false, false);
        for (zzkh zzkhVarZze = this.zzr.zze(); zzkhVarZze != null; zzkhVarZze = zzkhVarZze.zzg()) {
            for (zzxv zzxvVar : zzkhVarZze.zzi().zzc) {
            }
        }
        if (!zzah()) {
            zzW();
            zzZ();
            return;
        }
        int i12 = this.zzw.zze;
        if (i12 == 3) {
            this.zzo.zzh();
            zzU();
            this.zzi.zzi(2);
        } else if (i12 == 2) {
            this.zzi.zzi(2);
        }
    }

    private final void zzT(int i10) {
        zzkx zzkxVar = this.zzw;
        if (zzkxVar.zze != i10) {
            if (i10 != 2) {
                this.zzO = C.TIME_UNSET;
            }
            this.zzw = zzkxVar.zze(i10);
        }
    }

    private final void zzU() throws zzhw {
        zzkh zzkhVarZze = this.zzr.zze();
        if (zzkhVarZze == null) {
            return;
        }
        zzyc zzycVarZzi = zzkhVarZze.zzi();
        int i10 = 0;
        while (true) {
            int length = this.zzb.length;
            if (i10 >= 2) {
                return;
            }
            if (zzycVarZzi.zzb(i10) && this.zzb[i10].zzcV() == 1) {
                this.zzb[i10].zzO();
            }
            i10++;
        }
    }

    private final void zzV(boolean z10, boolean z11) {
        zzL(z10 || !this.zzG, false, true, false);
        this.zzx.zza(z11 ? 1 : 0);
        this.zzg.zze(this.zzu);
        zzT(1);
    }

    private final void zzW() throws zzhw {
        this.zzo.zzi();
        zzle[] zzleVarArr = this.zzb;
        int length = zzleVarArr.length;
        for (int i10 = 0; i10 < 2; i10++) {
            zzle zzleVar = zzleVarArr[i10];
            if (zzae(zzleVar)) {
                zzal(zzleVar);
            }
        }
    }

    private final void zzX() {
        zzkh zzkhVarZzd = this.zzr.zzd();
        boolean z10 = this.zzD || (zzkhVarZzd != null && zzkhVarZzd.zza.zzp());
        zzkx zzkxVar = this.zzw;
        if (z10 != zzkxVar.zzg) {
            this.zzw = new zzkx(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzd, zzkxVar.zze, zzkxVar.zzf, z10, zzkxVar.zzh, zzkxVar.zzi, zzkxVar.zzj, zzkxVar.zzk, zzkxVar.zzl, zzkxVar.zzm, zzkxVar.zzn, zzkxVar.zzp, zzkxVar.zzq, zzkxVar.zzr, zzkxVar.zzs, false);
        }
    }

    private final void zzY(zzui zzuiVar, zzwi zzwiVar, zzyc zzycVar) {
        zzcc zzccVar = this.zzw.zza;
        zzxv[] zzxvVarArr = zzycVar.zzc;
        this.zzg.zzf(this.zzu, zzccVar, zzuiVar, this.zzb, zzwiVar, zzxvVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ae, code lost:
    
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzZ() throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzZ():void");
    }

    private final void zzaa(zzcc zzccVar, zzui zzuiVar, zzcc zzccVar2, zzui zzuiVar2, long j10, boolean z10) throws zzhw {
        if (!zzai(zzccVar, zzuiVar)) {
            zzbq zzbqVar = zzuiVar.zzb() ? zzbq.zza : this.zzw.zzn;
            if (this.zzo.zzc().equals(zzbqVar)) {
                return;
            }
            zzR(zzbqVar);
            zzG(this.zzw.zzn, zzbqVar.zzb, false, false);
            return;
        }
        zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zzm).zzc, this.zzl, 0L);
        zzhq zzhqVar = this.zzR;
        zzav zzavVar = this.zzl.zzj;
        int i10 = zzet.zza;
        zzhqVar.zzd(zzavVar);
        if (j10 != C.TIME_UNSET) {
            this.zzR.zze(zzr(zzccVar, zzuiVar.zza, j10));
            return;
        }
        if (!zzet.zzG(!zzccVar2.zzo() ? zzccVar2.zze(zzccVar2.zzn(zzuiVar2.zza, this.zzm).zzc, this.zzl, 0L).zzb : null, this.zzl.zzb) || z10) {
            this.zzR.zze(C.TIME_UNSET);
        }
    }

    private final void zzab(boolean z10, boolean z11) {
        this.zzB = z10;
        long jElapsedRealtime = C.TIME_UNSET;
        if (z10 && !z11) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzC = jElapsedRealtime;
    }

    private final synchronized void zzac(zzfvk zzfvkVar, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j10;
        boolean z10 = false;
        while (!Boolean.valueOf(((zzjn) zzfvkVar).zza.zzy).booleanValue() && j10 > 0) {
            try {
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j10 = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzad() {
        zzkh zzkhVarZzd = this.zzr.zzd();
        return (zzkhVarZzd == null || zzkhVarZzd.zzd() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean zzae(zzle zzleVar) {
        return zzleVar.zzcV() != 0;
    }

    private final boolean zzaf() {
        zzkh zzkhVarZze = this.zzr.zze();
        long j10 = zzkhVarZze.zzf.zze;
        if (!zzkhVarZze.zzd) {
            return false;
        }
        if (j10 == C.TIME_UNSET || this.zzw.zzr < j10) {
            return true;
        }
        return !zzah();
    }

    private static boolean zzag(zzkx zzkxVar, zzca zzcaVar) {
        zzui zzuiVar = zzkxVar.zzb;
        zzcc zzccVar = zzkxVar.zza;
        return zzccVar.zzo() || zzccVar.zzn(zzuiVar.zza, zzcaVar).zzf;
    }

    private final boolean zzah() {
        zzkx zzkxVar = this.zzw;
        return zzkxVar.zzl && zzkxVar.zzm == 0;
    }

    private final boolean zzai(zzcc zzccVar, zzui zzuiVar) {
        if (!zzuiVar.zzb() && !zzccVar.zzo()) {
            zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zzm).zzc, this.zzl, 0L);
            if (this.zzl.zzb()) {
                zzcb zzcbVar = this.zzl;
                if (zzcbVar.zzi && zzcbVar.zzf != C.TIME_UNSET) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzaf[] zzaj(zzxv zzxvVar) {
        int iZzc = zzxvVar != null ? zzxvVar.zzc() : 0;
        zzaf[] zzafVarArr = new zzaf[iZzc];
        for (int i10 = 0; i10 < iZzc; i10++) {
            zzafVarArr[i10] = zzxvVar.zzd(i10);
        }
        return zzafVarArr;
    }

    private static final void zzak(zzla zzlaVar) throws zzhw {
        zzlaVar.zzj();
        try {
            zzlaVar.zzc().zzt(zzlaVar.zza(), zzlaVar.zzg());
        } finally {
            zzlaVar.zzh(true);
        }
    }

    private static final void zzal(zzle zzleVar) {
        if (zzleVar.zzcV() == 2) {
            zzleVar.zzP();
        }
    }

    private static final void zzam(zzle zzleVar, long j10) {
        zzleVar.zzK();
        if (zzleVar instanceof zzwm) {
            throw null;
        }
    }

    static int zzb(zzcb zzcbVar, zzca zzcaVar, int i10, boolean z10, Object obj, zzcc zzccVar, zzcc zzccVar2) {
        Object obj2 = zzccVar.zze(zzccVar.zzn(obj, zzcaVar).zzc, zzcbVar, 0L).zzb;
        for (int i11 = 0; i11 < zzccVar2.zzc(); i11++) {
            if (zzccVar2.zze(i11, zzcbVar, 0L).zzb.equals(obj2)) {
                return i11;
            }
        }
        int iZza = zzccVar.zza(obj);
        int iZzb = zzccVar.zzb();
        int iZzi = iZza;
        int i12 = 0;
        int iZza2 = -1;
        while (true) {
            if (i12 >= iZzb || iZza2 != -1) {
                break;
            }
            iZzi = zzccVar.zzi(iZzi, zzcaVar, zzcbVar, i10, z10);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzccVar2.zza(zzccVar.zzf(iZzi));
            i12++;
        }
        if (iZza2 == -1) {
            return -1;
        }
        return zzccVar2.zzd(iZza2, zzcaVar, false).zzc;
    }

    public static /* synthetic */ zzkh zzd(zzjx zzjxVar, zzki zzkiVar, long j10) {
        zzkb zzkbVar = zzjxVar.zzg;
        zzyb zzybVar = zzjxVar.zze;
        zzyk zzykVarZzj = zzkbVar.zzj();
        zzyc zzycVar = zzjxVar.zzf;
        return new zzkh(zzjxVar.zzd, j10, zzybVar, zzykVarZzj, zzjxVar.zzs, zzkiVar, zzycVar);
    }

    static final /* synthetic */ void zzq(zzla zzlaVar) {
        try {
            zzak(zzlaVar);
        } catch (zzhw e10) {
            zzea.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e10);
            throw new RuntimeException(e10);
        }
    }

    private final long zzr(zzcc zzccVar, Object obj, long j10) {
        zzccVar.zze(zzccVar.zzn(obj, this.zzm).zzc, this.zzl, 0L);
        zzcb zzcbVar = this.zzl;
        if (zzcbVar.zzf != C.TIME_UNSET && zzcbVar.zzb()) {
            zzcb zzcbVar2 = this.zzl;
            if (zzcbVar2.zzi) {
                long j11 = zzcbVar2.zzg;
                return zzet.zzr((j11 == C.TIME_UNSET ? System.currentTimeMillis() : j11 + SystemClock.elapsedRealtime()) - this.zzl.zzf) - j10;
            }
        }
        return C.TIME_UNSET;
    }

    private final long zzs() {
        return zzt(this.zzw.zzp);
    }

    private final long zzt(long j10) {
        zzkh zzkhVarZzd = this.zzr.zzd();
        if (zzkhVarZzd == null) {
            return 0L;
        }
        return Math.max(0L, j10 - (this.zzJ - zzkhVarZzd.zze()));
    }

    private final long zzu(zzui zzuiVar, long j10, boolean z10) throws zzhw {
        zzkk zzkkVar = this.zzr;
        return zzv(zzuiVar, j10, zzkkVar.zze() != zzkkVar.zzf(), z10);
    }

    private final long zzv(zzui zzuiVar, long j10, boolean z10, boolean z11) throws zzhw {
        zzW();
        zzab(false, true);
        if (z11 || this.zzw.zze == 3) {
            zzT(2);
        }
        zzkh zzkhVarZze = this.zzr.zze();
        zzkh zzkhVarZzg = zzkhVarZze;
        while (zzkhVarZzg != null && !zzuiVar.equals(zzkhVarZzg.zzf.zza)) {
            zzkhVarZzg = zzkhVarZzg.zzg();
        }
        if (z10 || zzkhVarZze != zzkhVarZzg || (zzkhVarZzg != null && zzkhVarZzg.zze() + j10 < 0)) {
            zzle[] zzleVarArr = this.zzb;
            int length = zzleVarArr.length;
            for (int i10 = 0; i10 < 2; i10++) {
                zzz(zzleVarArr[i10]);
            }
            if (zzkhVarZzg != null) {
                while (this.zzr.zze() != zzkhVarZzg) {
                    this.zzr.zza();
                }
                this.zzr.zzq(zzkhVarZzg);
                zzkhVarZzg.zzp(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                zzA();
            }
        }
        if (zzkhVarZzg != null) {
            this.zzr.zzq(zzkhVarZzg);
            if (!zzkhVarZzg.zzd) {
                zzkhVarZzg.zzf = zzkhVarZzg.zzf.zzb(j10);
            } else if (zzkhVarZzg.zze) {
                j10 = zzkhVarZzg.zza.zze(j10);
                zzkhVarZzg.zza.zzj(j10 - this.zzn, false);
            }
            zzN(j10);
            zzH();
        } else {
            this.zzr.zzj();
            zzN(j10);
        }
        zzD(false);
        this.zzi.zzi(2);
        return j10;
    }

    private final Pair zzw(zzcc zzccVar) {
        long j10 = 0;
        if (zzccVar.zzo()) {
            return Pair.create(zzkx.zzh(), 0L);
        }
        Pair pairZzl = zzccVar.zzl(this.zzl, this.zzm, zzccVar.zzg(this.zzF), C.TIME_UNSET);
        zzui zzuiVarZzi = this.zzr.zzi(zzccVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzuiVarZzi.zzb()) {
            zzccVar.zzn(zzuiVarZzi.zza, this.zzm);
            if (zzuiVarZzi.zzc == this.zzm.zze(zzuiVarZzi.zzb)) {
                this.zzm.zzj();
            }
        } else {
            j10 = jLongValue;
        }
        return Pair.create(zzuiVarZzi, Long.valueOf(j10));
    }

    @Nullable
    private static Pair zzx(zzcc zzccVar, zzjw zzjwVar, boolean z10, int i10, boolean z11, zzcb zzcbVar, zzca zzcaVar) {
        Pair pairZzl;
        zzcc zzccVar2 = zzjwVar.zza;
        if (zzccVar.zzo()) {
            return null;
        }
        zzcc zzccVar3 = true == zzccVar2.zzo() ? zzccVar : zzccVar2;
        try {
            pairZzl = zzccVar3.zzl(zzcbVar, zzcaVar, zzjwVar.zzb, zzjwVar.zzc);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzccVar.equals(zzccVar3)) {
            return pairZzl;
        }
        if (zzccVar.zza(pairZzl.first) != -1) {
            return (zzccVar3.zzn(pairZzl.first, zzcaVar).zzf && zzccVar3.zze(zzcaVar.zzc, zzcbVar, 0L).zzn == zzccVar3.zza(pairZzl.first)) ? zzccVar.zzl(zzcbVar, zzcaVar, zzccVar.zzn(pairZzl.first, zzcaVar).zzc, zzjwVar.zzc) : pairZzl;
        }
        int iZzb = zzb(zzcbVar, zzcaVar, i10, z11, pairZzl.first, zzccVar3, zzccVar);
        if (iZzb != -1) {
            return zzccVar.zzl(zzcbVar, zzcaVar, iZzb, C.TIME_UNSET);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb  */
    @androidx.annotation.CheckResult
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzkx zzy(com.google.android.gms.internal.ads.zzui r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzy(com.google.android.gms.internal.ads.zzui, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzkx");
    }

    private final void zzz(zzle zzleVar) throws zzhw {
        if (zzae(zzleVar)) {
            this.zzo.zzd(zzleVar);
            zzal(zzleVar);
            zzleVar.zzq();
            this.zzH--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06fe A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0712 A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0808 A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x08ba A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x08cd A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x08ea A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0979 A[Catch: RuntimeException -> 0x09f0, IOException -> 0x0a1a, zzti -> 0x0a22, zzft -> 0x0a2a, zzbo -> 0x0a32, zzrb -> 0x0a49, zzhw -> 0x0a53, TryCatch #10 {zzbo -> 0x0a32, zzft -> 0x0a2a, zzhw -> 0x0a53, zzrb -> 0x0a49, zzti -> 0x0a22, IOException -> 0x0a1a, RuntimeException -> 0x09f0, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x0027, B:9:0x003f, B:10:0x0044, B:11:0x0049, B:15:0x0050, B:17:0x0059, B:19:0x0067, B:20:0x006f, B:21:0x007a, B:22:0x008e, B:23:0x00a6, B:24:0x00bc, B:26:0x00cb, B:27:0x00cf, B:28:0x00e0, B:30:0x00ef, B:31:0x010b, B:32:0x011e, B:33:0x0127, B:35:0x0139, B:36:0x0145, B:37:0x0155, B:39:0x0161, B:42:0x016c, B:43:0x0173, B:44:0x0180, B:48:0x0187, B:50:0x018f, B:52:0x0193, B:54:0x0199, B:56:0x01a1, B:58:0x01a9, B:59:0x01ac, B:61:0x01b1, B:68:0x01be, B:69:0x01bf, B:73:0x01c6, B:75:0x01d4, B:76:0x01d7, B:77:0x01dc, B:79:0x01ec, B:80:0x01ef, B:81:0x01f4, B:82:0x01f9, B:84:0x0205, B:85:0x0211, B:87:0x021d, B:89:0x0249, B:90:0x0269, B:97:0x0291, B:99:0x0295, B:100:0x0298, B:107:0x02a3, B:120:0x02b9, B:122:0x02bf, B:123:0x02c6, B:124:0x02d7, B:126:0x02fe, B:192:0x0415, B:176:0x03e2, B:175:0x03de, B:201:0x0426, B:202:0x0433, B:127:0x0320, B:131:0x0333, B:133:0x0343, B:135:0x035a, B:137:0x0364, B:203:0x0434, B:205:0x0448, B:208:0x0452, B:210:0x0461, B:212:0x046d, B:214:0x0482, B:215:0x0487, B:216:0x048b, B:218:0x048f, B:220:0x049c, B:292:0x05f8, B:294:0x0600, B:296:0x0608, B:299:0x060d, B:300:0x0619, B:302:0x061f, B:304:0x0627, B:307:0x0637, B:309:0x063d, B:310:0x065d, B:312:0x0663, B:314:0x0668, B:316:0x066d, B:318:0x0671, B:357:0x072a, B:359:0x0730, B:363:0x073b, B:365:0x0743, B:366:0x0748, B:368:0x0754, B:369:0x076e, B:371:0x0774, B:373:0x077c, B:375:0x0785, B:379:0x078e, B:384:0x079d, B:390:0x07aa, B:392:0x07b0, B:402:0x07c3, B:403:0x07c6, B:405:0x07d0, B:407:0x07d6, B:411:0x07e3, B:413:0x07eb, B:415:0x07ef, B:416:0x07fa, B:418:0x0800, B:471:0x090e, B:474:0x0916, B:476:0x091b, B:478:0x0923, B:480:0x0931, B:481:0x0938, B:482:0x093c, B:484:0x0942, B:486:0x094b, B:488:0x0951, B:490:0x095c, B:497:0x0980, B:499:0x0986, B:503:0x098f, B:513:0x09a7, B:510:0x09a0, B:512:0x09a4, B:491:0x0963, B:494:0x0971, B:495:0x0978, B:496:0x0979, B:419:0x0808, B:421:0x080f, B:423:0x0813, B:450:0x08ae, B:452:0x08ba, B:428:0x081f, B:430:0x0823, B:432:0x0837, B:434:0x0845, B:436:0x0851, B:440:0x085a, B:442:0x0864, B:448:0x086f, B:453:0x08c7, B:455:0x08cd, B:457:0x08d1, B:461:0x08da, B:463:0x08ea, B:465:0x08f2, B:467:0x08fc, B:468:0x0901, B:469:0x0906, B:470:0x090b, B:404:0x07c9, B:321:0x067b, B:323:0x067f, B:325:0x0687, B:327:0x068d, B:329:0x0697, B:332:0x069d, B:333:0x06a0, B:335:0x06a9, B:337:0x06bb, B:339:0x06c4, B:341:0x06cc, B:346:0x06d6, B:348:0x06fe, B:349:0x0701, B:350:0x070c, B:352:0x0712, B:354:0x0718, B:355:0x071f, B:223:0x04ab, B:225:0x04b1, B:228:0x04b7, B:231:0x04c2, B:233:0x04c7, B:236:0x04d5, B:238:0x04db, B:239:0x04e3, B:240:0x04e6, B:242:0x04ee, B:244:0x04fc, B:246:0x0538, B:248:0x0542, B:251:0x054d, B:253:0x0555, B:254:0x0558, B:255:0x055b, B:257:0x0561, B:259:0x0570, B:261:0x0576, B:263:0x0582, B:265:0x058c, B:267:0x059d, B:269:0x05a3, B:270:0x05ae, B:271:0x05b3, B:273:0x05be, B:276:0x05c3, B:278:0x05c9, B:280:0x05d1, B:282:0x05d7, B:284:0x05dd, B:288:0x05eb, B:290:0x05f2, B:291:0x05f5, B:219:0x0499, B:515:0x09af, B:519:0x09b6, B:520:0x09be, B:524:0x09de, B:109:0x02a5, B:111:0x02aa, B:112:0x02ad, B:115:0x02b4, B:119:0x02b8), top: B:602:0x0006 }] */
    /* JADX WARN: Type inference failed for: r2v44, types: [com.google.android.gms.internal.ads.zzgu, com.google.android.gms.internal.ads.zzyj] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void zza(zzbq zzbqVar) {
        this.zzi.zzc(16, zzbqVar).zza();
    }

    public final Looper zzc() {
        return this.zzk;
    }

    final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        this.zzi.zzc(9, (zzug) zzvzVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzg() {
        this.zzi.zzf(2);
        this.zzi.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        this.zzi.zzc(8, zzugVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final void zzi() {
        this.zzi.zzi(10);
    }

    public final void zzj() {
        this.zzi.zzb(0).zza();
    }

    public final void zzk(zzcc zzccVar, int i10, long j10) {
        this.zzi.zzc(3, new zzjw(zzccVar, i10, j10)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final synchronized void zzl(zzla zzlaVar) {
        if (!this.zzy && this.zzk.getThread().isAlive()) {
            this.zzi.zzc(14, zzlaVar).zza();
            return;
        }
        zzea.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzlaVar.zzh(false);
    }

    public final void zzm(boolean z10, int i10) {
        this.zzi.zzd(1, z10 ? 1 : 0, i10).zza();
    }

    public final void zzn() {
        this.zzi.zzb(6).zza();
    }

    public final synchronized boolean zzo() {
        if (!this.zzy && this.zzk.getThread().isAlive()) {
            this.zzi.zzi(7);
            zzac(new zzjn(this), this.zzt);
            return this.zzy;
        }
        return true;
    }

    public final void zzp(List list, int i10, long j10, zzwa zzwaVar) {
        this.zzi.zzc(17, new zzjs(list, zzwaVar, i10, j10, null)).zza();
    }
}

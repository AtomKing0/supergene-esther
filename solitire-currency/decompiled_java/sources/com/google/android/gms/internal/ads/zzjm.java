package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjm extends zzj implements zzih {
    public static final /* synthetic */ int zzd = 0;
    private boolean zzA;
    private int zzB;
    private zzlj zzC;
    private zzig zzD;
    private zzbt zzE;
    private zzbh zzF;

    @Nullable
    private Object zzG;

    @Nullable
    private Surface zzH;
    private int zzI;
    private zzel zzJ;
    private int zzK;
    private zzh zzL;
    private float zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private zzbh zzR;
    private zzkx zzS;
    private int zzT;
    private long zzU;
    private final zzii zzV;
    private zzwa zzW;
    final zzyc zzb;
    final zzbt zzc;
    private final zzdm zze;
    private final Context zzf;
    private final zzbw zzg;
    private final zzle[] zzh;
    private final zzyb zzi;
    private final zzdt zzj;
    private final zzjx zzk;
    private final zzdz zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzca zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzln zzq;
    private final Looper zzr;
    private final zzyj zzs;
    private final zzdj zzt;
    private final zzji zzu;
    private final zzjk zzv;
    private final zzhl zzw;
    private final long zzx;
    private int zzy;
    private int zzz;

    static {
        zzbd.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzyi, java.lang.Object] */
    @SuppressLint({"HandlerLeak"})
    public zzjm(zzif zzifVar, @Nullable zzbw zzbwVar) {
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zze = zzdmVar;
        try {
            zzea.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.0-alpha02] [" + zzet.zze + v8.i.f15839e);
            Context applicationContext = zzifVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? Apply = zzifVar.zzh.apply(zzifVar.zzb);
            this.zzq = Apply;
            this.zzQ = zzifVar.zzj;
            this.zzL = zzifVar.zzk;
            this.zzI = zzifVar.zzl;
            this.zzN = false;
            this.zzx = zzifVar.zzp;
            zzji zzjiVar = new zzji(this, null);
            this.zzu = zzjiVar;
            zzjk zzjkVar = new zzjk(null == true ? 1 : 0);
            this.zzv = zzjkVar;
            Handler handler = new Handler(zzifVar.zzi);
            zzle[] zzleVarArrZza = ((zzhy) zzifVar.zzc).zza.zza(handler, zzjiVar, zzjiVar, zzjiVar, zzjiVar);
            this.zzh = zzleVarArrZza;
            int length = zzleVarArrZza.length;
            zzyb zzybVar = (zzyb) zzifVar.zze.zza();
            this.zzi = zzybVar;
            zzif.zza(((zzhz) zzifVar.zzd).zza);
            zzyn zzynVarZzg = zzyn.zzg(((zzic) zzifVar.zzg).zza);
            this.zzs = zzynVarZzg;
            this.zzp = zzifVar.zzm;
            this.zzC = zzifVar.zzn;
            Looper looper = zzifVar.zzi;
            this.zzr = looper;
            zzdj zzdjVar = zzifVar.zzb;
            this.zzt = zzdjVar;
            this.zzg = zzbwVar;
            zzdz zzdzVar = new zzdz(looper, zzdjVar, new zzdx(this) { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdx
                public final void zza(Object obj, zzab zzabVar) {
                }
            });
            this.zzl = zzdzVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzW = new zzwa(0);
            this.zzD = zzig.zza;
            int length2 = zzleVarArrZza.length;
            zzyc zzycVar = new zzyc(new zzli[2], new zzxv[2], zzck.zza, null);
            this.zzb = zzycVar;
            this.zzn = new zzca();
            zzbr zzbrVar = new zzbr();
            zzbrVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzybVar.zzn();
            zzbrVar.zzd(29, true);
            zzbrVar.zzd(23, false);
            zzbrVar.zzd(25, false);
            zzbrVar.zzd(33, false);
            zzbrVar.zzd(26, false);
            zzbrVar.zzd(34, false);
            zzbt zzbtVarZze = zzbrVar.zze();
            this.zzc = zzbtVarZze;
            zzbr zzbrVar2 = new zzbr();
            zzbrVar2.zzb(zzbtVarZze);
            zzbrVar2.zza(4);
            zzbrVar2.zza(10);
            this.zzE = zzbrVar2.zze();
            this.zzj = zzdjVar.zzb(looper, null);
            zzii zziiVar = new zzii(this);
            this.zzV = zziiVar;
            this.zzS = zzkx.zzg(zzycVar);
            Apply.zzR(zzbwVar, looper);
            this.zzk = new zzjx(zzleVarArrZza, zzybVar, zzycVar, (zzkb) zzifVar.zzf.zza(), zzynVarZzg, 0, false, Apply, this.zzC, zzifVar.zzt, zzifVar.zzo, false, false, looper, zzdjVar, zziiVar, zzet.zza < 31 ? new zznz(zzifVar.zzs) : zzjd.zza(applicationContext, this, zzifVar.zzq, zzifVar.zzs), null, this.zzD);
            this.zzM = 1.0f;
            zzbh zzbhVar = zzbh.zza;
            this.zzF = zzbhVar;
            this.zzR = zzbhVar;
            this.zzT = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            this.zzK = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            int i10 = zzdc.zza;
            this.zzO = true;
            Apply.getClass();
            zzdzVar.zzb(Apply);
            zzynVarZzg.zze(new Handler(looper), Apply);
            copyOnWriteArraySet.add(zzjiVar);
            new zzhh(zzifVar.zza, handler, zzjiVar);
            this.zzw = new zzhl(zzifVar.zza, handler, zzjiVar);
            zzet.zzG(null, null);
            new zzs(0).zza();
            zzcp zzcpVar = zzcp.zza;
            this.zzJ = zzel.zza;
            zzybVar.zzk(this.zzL);
            zzab(1, 10, Integer.valueOf(this.zzK));
            zzab(2, 10, Integer.valueOf(this.zzK));
            zzab(1, 3, this.zzL);
            zzab(2, 4, Integer.valueOf(this.zzI));
            zzab(2, 5, 0);
            zzab(1, 9, Boolean.valueOf(this.zzN));
            zzab(2, 7, zzjkVar);
            zzab(6, 8, zzjkVar);
            zzab(-1, 16, Integer.valueOf(this.zzQ));
            zzdmVar.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzK(zzjm zzjmVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjmVar.zzad(surface);
        zzjmVar.zzH = surface;
    }

    private final int zzR(zzkx zzkxVar) {
        return zzkxVar.zza.zzo() ? this.zzT : zzkxVar.zza.zzn(zzkxVar.zzb.zza, this.zzn).zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzS(boolean z10, int i10) {
        return (!z10 || i10 == 1) ? 1 : 2;
    }

    private final long zzT(zzkx zzkxVar) {
        if (!zzkxVar.zzb.zzb()) {
            return zzet.zzu(zzU(zzkxVar));
        }
        zzkxVar.zza.zzn(zzkxVar.zzb.zza, this.zzn);
        long j10 = zzkxVar.zzc;
        if (j10 != C.TIME_UNSET) {
            return zzet.zzu(j10) + zzet.zzu(0L);
        }
        long j11 = zzkxVar.zza.zze(zzR(zzkxVar), this.zza, 0L).zzl;
        return zzet.zzu(0L);
    }

    private final long zzU(zzkx zzkxVar) {
        if (zzkxVar.zza.zzo()) {
            return zzet.zzr(this.zzU);
        }
        long j10 = zzkxVar.zzr;
        if (zzkxVar.zzb.zzb()) {
            return j10;
        }
        zzW(zzkxVar.zza, zzkxVar.zzb, j10);
        return j10;
    }

    private static long zzV(zzkx zzkxVar) {
        zzcb zzcbVar = new zzcb();
        zzca zzcaVar = new zzca();
        zzkxVar.zza.zzn(zzkxVar.zzb.zza, zzcaVar);
        long j10 = zzkxVar.zzc;
        if (j10 != C.TIME_UNSET) {
            return j10;
        }
        long j11 = zzkxVar.zza.zze(zzcaVar.zzc, zzcbVar, 0L).zzl;
        return 0L;
    }

    private final long zzW(zzcc zzccVar, zzui zzuiVar, long j10) {
        zzccVar.zzn(zzuiVar.zza, this.zzn);
        return j10;
    }

    @Nullable
    private final Pair zzX(zzcc zzccVar, int i10, long j10) {
        if (zzccVar.zzo()) {
            this.zzT = i10;
            if (j10 == C.TIME_UNSET) {
                j10 = 0;
            }
            this.zzU = j10;
            return null;
        }
        if (i10 == -1 || i10 >= zzccVar.zzc()) {
            i10 = zzccVar.zzg(false);
            long j11 = zzccVar.zze(i10, this.zza, 0L).zzl;
            j10 = zzet.zzu(0L);
        }
        return zzccVar.zzl(this.zza, this.zzn, i10, zzet.zzr(j10));
    }

    private final zzkx zzY(zzkx zzkxVar, zzcc zzccVar, @Nullable Pair pair) {
        zzdi.zzd(zzccVar.zzo() || pair != null);
        zzcc zzccVar2 = zzkxVar.zza;
        long jZzT = zzT(zzkxVar);
        zzkx zzkxVarZzf = zzkxVar.zzf(zzccVar);
        if (zzccVar.zzo()) {
            zzui zzuiVarZzh = zzkx.zzh();
            long jZzr = zzet.zzr(this.zzU);
            zzkx zzkxVarZza = zzkxVarZzf.zzb(zzuiVarZzh, jZzr, jZzr, jZzr, 0L, zzwi.zza, this.zzb, zzfxr.zzm()).zza(zzuiVarZzh);
            zzkxVarZza.zzp = zzkxVarZza.zzr;
            return zzkxVarZza;
        }
        Object obj = zzkxVarZzf.zzb.zza;
        int i10 = zzet.zza;
        boolean z10 = !obj.equals(pair.first);
        zzui zzuiVar = z10 ? new zzui(pair.first, -1L) : zzkxVarZzf.zzb;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzr2 = zzet.zzr(jZzT);
        if (!zzccVar2.zzo()) {
            zzccVar2.zzn(obj, this.zzn);
        }
        if (z10 || jLongValue < jZzr2) {
            zzdi.zzf(!zzuiVar.zzb());
            zzkx zzkxVarZza2 = zzkxVarZzf.zzb(zzuiVar, jLongValue, jLongValue, jLongValue, 0L, z10 ? zzwi.zza : zzkxVarZzf.zzh, z10 ? this.zzb : zzkxVarZzf.zzi, z10 ? zzfxr.zzm() : zzkxVarZzf.zzj).zza(zzuiVar);
            zzkxVarZza2.zzp = jLongValue;
            return zzkxVarZza2;
        }
        if (jLongValue != jZzr2) {
            zzdi.zzf(!zzuiVar.zzb());
            long jMax = Math.max(0L, zzkxVarZzf.zzq - (jLongValue - jZzr2));
            long j10 = zzkxVarZzf.zzp;
            if (zzkxVarZzf.zzk.equals(zzkxVarZzf.zzb)) {
                j10 = jLongValue + jMax;
            }
            zzkx zzkxVarZzb = zzkxVarZzf.zzb(zzuiVar, jLongValue, jLongValue, jLongValue, jMax, zzkxVarZzf.zzh, zzkxVarZzf.zzi, zzkxVarZzf.zzj);
            zzkxVarZzb.zzp = j10;
            return zzkxVarZzb;
        }
        int iZza = zzccVar.zza(zzkxVarZzf.zzk.zza);
        if (iZza != -1 && zzccVar.zzd(iZza, this.zzn, false).zzc == zzccVar.zzn(zzuiVar.zza, this.zzn).zzc) {
            return zzkxVarZzf;
        }
        zzccVar.zzn(zzuiVar.zza, this.zzn);
        long jZzh = zzuiVar.zzb() ? this.zzn.zzh(zzuiVar.zzb, zzuiVar.zzc) : this.zzn.zzd;
        zzkx zzkxVarZza3 = zzkxVarZzf.zzb(zzuiVar, zzkxVarZzf.zzr, zzkxVarZzf.zzr, zzkxVarZzf.zzd, jZzh - zzkxVarZzf.zzr, zzkxVarZzf.zzh, zzkxVarZzf.zzi, zzkxVarZzf.zzj).zza(zzuiVar);
        zzkxVarZza3.zzp = jZzh;
        return zzkxVarZza3;
    }

    private final zzla zzZ(zzkz zzkzVar) {
        int iZzR = zzR(this.zzS);
        zzcc zzccVar = this.zzS.zza;
        if (iZzR == -1) {
            iZzR = 0;
        }
        zzdj zzdjVar = this.zzt;
        zzjx zzjxVar = this.zzk;
        return new zzla(zzjxVar, zzkzVar, zzccVar, iZzR, zzdjVar, zzjxVar.zzc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(final int i10, final int i11) {
        if (i10 == this.zzJ.zzb() && i11 == this.zzJ.zza()) {
            return;
        }
        this.zzJ = new zzel(i10, i11);
        zzdz zzdzVar = this.zzl;
        zzdzVar.zzd(24, new zzdw() { // from class: com.google.android.gms.internal.ads.zziz
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i12 = zzjm.zzd;
                ((zzbu) obj).zzo(i10, i11);
            }
        });
        zzdzVar.zzc();
        zzab(2, 14, new zzel(i10, i11));
    }

    private final void zzab(int i10, int i11, @Nullable Object obj) {
        zzle[] zzleVarArr = this.zzh;
        int length = zzleVarArr.length;
        for (int i12 = 0; i12 < 2; i12++) {
            zzle zzleVar = zzleVarArr[i12];
            if (i10 == -1 || zzleVar.zzb() == i10) {
                zzla zzlaVarZzZ = zzZ(zzleVar);
                zzlaVarZzZ.zzf(i11);
                zzlaVarZzZ.zze(obj);
                zzlaVarZzZ.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac() {
        zzab(1, 2, Float.valueOf(this.zzM * this.zzw.zza()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad(@Nullable Object obj) {
        ArrayList arrayList = new ArrayList();
        zzle[] zzleVarArr = this.zzh;
        int length = zzleVarArr.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < 2; i10++) {
            zzle zzleVar = zzleVarArr[i10];
            if (zzleVar.zzb() == 2) {
                zzla zzlaVarZzZ = zzZ(zzleVar);
                zzlaVarZzZ.zzf(1);
                zzlaVarZzZ.zze(obj);
                zzlaVarZzZ.zzd();
                arrayList.add(zzlaVarZzZ);
            }
        }
        Object obj2 = this.zzG;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzla) it.next()).zzi(this.zzx);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z10 = true;
            }
            Object obj3 = this.zzG;
            Surface surface = this.zzH;
            if (obj3 == surface) {
                surface.release();
                this.zzH = null;
            }
        }
        this.zzG = obj;
        if (z10) {
            zzae(zzhw.zzd(new zzjy(3), 1003));
        }
    }

    private final void zzae(@Nullable zzhw zzhwVar) {
        zzkx zzkxVar = this.zzS;
        zzkx zzkxVarZza = zzkxVar.zza(zzkxVar.zzb);
        zzkxVarZza.zzp = zzkxVarZza.zzr;
        zzkxVarZza.zzq = 0L;
        zzkx zzkxVarZze = zzkxVarZza.zze(1);
        if (zzhwVar != null) {
            zzkxVarZze = zzkxVarZze.zzd(zzhwVar);
        }
        this.zzy++;
        this.zzk.zzn();
        zzag(zzkxVarZze, 0, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(boolean z10, int i10, int i11) {
        int i12 = 0;
        boolean z11 = z10 && i10 != -1;
        if (z11 && i10 != 1) {
            i12 = 1;
        }
        zzkx zzkxVar = this.zzS;
        if (zzkxVar.zzl == z11 && zzkxVar.zzm == i12) {
            return;
        }
        this.zzy++;
        zzkx zzkxVarZzc = zzkxVar.zzc(z11, i12);
        this.zzk.zzm(z11, i12);
        zzag(zzkxVarZzc, 0, i11, false, 5, C.TIME_UNSET, -1, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0475 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x047f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x048a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x049b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029d  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r6v23, types: [com.google.android.gms.internal.ads.zzcc] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.google.android.gms.internal.ads.zzbr] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzag(final com.google.android.gms.internal.ads.zzkx r43, final int r44, final int r45, boolean r46, int r47, long r48, int r50, boolean r51) {
        /*
            Method dump skipped, instruction units count: 1270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zzag(com.google.android.gms.internal.ads.zzkx, int, int, boolean, int, long, int, boolean):void");
    }

    private final void zzah() {
        int iZzf = zzf();
        if (iZzf == 2 || iZzf == 3) {
            zzai();
            boolean z10 = this.zzS.zzo;
            zzu();
            zzu();
        }
    }

    private final void zzai() {
        this.zze.zzb();
        if (Thread.currentThread() != this.zzr.getThread()) {
            String str = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzr.getThread().getName());
            if (this.zzO) {
                throw new IllegalStateException(str);
            }
            zzea.zzg("ExoPlayerImpl", str, this.zzP ? null : new IllegalStateException());
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzA(zzlq zzlqVar) {
        zzai();
        this.zzq.zzQ(zzlqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzB(zzuk zzukVar) {
        zzai();
        List listSingletonList = Collections.singletonList(zzukVar);
        zzai();
        zzai();
        zzR(this.zzS);
        zzk();
        this.zzy++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                this.zzo.remove(i10);
            }
            this.zzW = this.zzW.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < listSingletonList.size(); i11++) {
            zzku zzkuVar = new zzku((zzuk) listSingletonList.get(i11), this.zzp);
            arrayList.add(zzkuVar);
            this.zzo.add(i11, new zzjl(zzkuVar.zzb, zzkuVar.zza));
        }
        this.zzW = this.zzW.zzg(0, arrayList.size());
        zzlc zzlcVar = new zzlc(this.zzo, this.zzW);
        if (!zzlcVar.zzo() && zzlcVar.zzc() < 0) {
            throw new zzaj(zzlcVar, -1, C.TIME_UNSET);
        }
        int iZzg = zzlcVar.zzg(false);
        zzkx zzkxVarZzY = zzY(this.zzS, zzlcVar, zzX(zzlcVar, iZzg, C.TIME_UNSET));
        int i12 = zzkxVarZzY.zze;
        if (iZzg != -1 && i12 != 1) {
            i12 = 4;
            if (!zzlcVar.zzo() && iZzg < zzlcVar.zzc()) {
                i12 = 2;
            }
        }
        zzkx zzkxVarZze = zzkxVarZzY.zze(i12);
        this.zzk.zzp(arrayList, iZzg, zzet.zzr(C.TIME_UNSET), this.zzW);
        zzag(zzkxVarZze, 0, 1, (this.zzS.zzb.zza.equals(zzkxVarZze.zzb.zza) || this.zzS.zza.zzo()) ? false : true, 4, zzU(zzkxVarZze), -1, false);
    }

    @Nullable
    public final zzhw zzE() {
        zzai();
        return this.zzS.zzf;
    }

    final /* synthetic */ void zzN(zzjv zzjvVar) {
        long j10;
        boolean z10;
        int i10 = this.zzy - zzjvVar.zzb;
        this.zzy = i10;
        boolean z11 = true;
        if (zzjvVar.zzc) {
            this.zzz = zzjvVar.zzd;
            this.zzA = true;
        }
        if (zzjvVar.zze) {
            this.zzB = zzjvVar.zzf;
        }
        if (i10 == 0) {
            zzcc zzccVar = zzjvVar.zza.zza;
            if (!this.zzS.zza.zzo() && zzccVar.zzo()) {
                this.zzT = -1;
                this.zzU = 0L;
            }
            if (!zzccVar.zzo()) {
                List listZzw = ((zzlc) zzccVar).zzw();
                zzdi.zzf(listZzw.size() == this.zzo.size());
                for (int i11 = 0; i11 < listZzw.size(); i11++) {
                    ((zzjl) this.zzo.get(i11)).zzc((zzcc) listZzw.get(i11));
                }
            }
            if (this.zzA) {
                if (zzjvVar.zza.zzb.equals(this.zzS.zzb) && zzjvVar.zza.zzd == this.zzS.zzr) {
                    z11 = false;
                }
                if (!z11) {
                    j10 = -9223372036854775807L;
                } else if (zzccVar.zzo() || zzjvVar.zza.zzb.zzb()) {
                    j10 = zzjvVar.zza.zzd;
                } else {
                    zzkx zzkxVar = zzjvVar.zza;
                    zzui zzuiVar = zzkxVar.zzb;
                    j10 = zzkxVar.zzd;
                    zzW(zzccVar, zzuiVar, j10);
                }
                z10 = z11;
            } else {
                j10 = -9223372036854775807L;
                z10 = false;
            }
            this.zzA = false;
            zzag(zzjvVar.zza, 1, this.zzB, z10, this.zzz, j10, -1, false);
        }
    }

    final /* synthetic */ void zzO(final zzjv zzjvVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN(zzjvVar);
            }
        });
    }

    final /* synthetic */ void zzP(zzbu zzbuVar) {
        zzbuVar.zza(this.zzE);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final void zza(int i10, long j10, int i11, boolean z10) {
        zzai();
        if (i10 == -1) {
            return;
        }
        zzdi.zzd(i10 >= 0);
        zzcc zzccVar = this.zzS.zza;
        if (zzccVar.zzo() || i10 < zzccVar.zzc()) {
            this.zzq.zzu();
            this.zzy++;
            if (zzw()) {
                zzea.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzjv zzjvVar = new zzjv(this.zzS);
                zzjvVar.zza(1);
                this.zzV.zza.zzO(zzjvVar);
                return;
            }
            zzkx zzkxVarZze = this.zzS;
            int i12 = zzkxVarZze.zze;
            if (i12 == 3 || (i12 == 4 && !zzccVar.zzo())) {
                zzkxVarZze = this.zzS.zze(2);
            }
            int iZzd = zzd();
            zzkx zzkxVarZzY = zzY(zzkxVarZze, zzccVar, zzX(zzccVar, i10, j10));
            this.zzk.zzk(zzccVar, i10, zzet.zzr(j10));
            zzag(zzkxVarZzY, 0, 1, true, 1, zzU(zzkxVarZzY), iZzd, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzb() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzc() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzd() {
        zzai();
        int iZzR = zzR(this.zzS);
        if (iZzR == -1) {
            return 0;
        }
        return iZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zze() {
        zzai();
        if (this.zzS.zza.zzo()) {
            return 0;
        }
        zzkx zzkxVar = this.zzS;
        return zzkxVar.zza.zza(zzkxVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzf() {
        zzai();
        return this.zzS.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzg() {
        zzai();
        return this.zzS.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzh() {
        zzai();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzi() {
        zzai();
        if (zzw()) {
            zzkx zzkxVar = this.zzS;
            return zzkxVar.zzk.equals(zzkxVar.zzb) ? zzet.zzu(this.zzS.zzp) : zzl();
        }
        zzai();
        if (this.zzS.zza.zzo()) {
            return this.zzU;
        }
        zzkx zzkxVar2 = this.zzS;
        long j10 = 0;
        if (zzkxVar2.zzk.zzd != zzkxVar2.zzb.zzd) {
            return zzet.zzu(zzkxVar2.zza.zze(zzd(), this.zza, 0L).zzm);
        }
        long j11 = zzkxVar2.zzp;
        if (this.zzS.zzk.zzb()) {
            zzkx zzkxVar3 = this.zzS;
            zzkxVar3.zza.zzn(zzkxVar3.zzk.zza, this.zzn).zzi(this.zzS.zzk.zzb);
        } else {
            j10 = j11;
        }
        zzkx zzkxVar4 = this.zzS;
        zzW(zzkxVar4.zza, zzkxVar4.zzk, j10);
        return zzet.zzu(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzj() {
        zzai();
        return zzT(this.zzS);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzk() {
        zzai();
        return zzet.zzu(zzU(this.zzS));
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzl() {
        zzai();
        if (!zzw()) {
            zzcc zzccVarZzn = zzn();
            return zzccVarZzn.zzo() ? C.TIME_UNSET : zzet.zzu(zzccVarZzn.zze(zzd(), this.zza, 0L).zzm);
        }
        zzkx zzkxVar = this.zzS;
        zzui zzuiVar = zzkxVar.zzb;
        zzkxVar.zza.zzn(zzuiVar.zza, this.zzn);
        return zzet.zzu(this.zzn.zzh(zzuiVar.zzb, zzuiVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzm() {
        zzai();
        return zzet.zzu(this.zzS.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final zzcc zzn() {
        zzai();
        return this.zzS.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final zzck zzo() {
        zzai();
        return this.zzS.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzp() {
        zzai();
        zzhl zzhlVar = this.zzw;
        boolean zZzu = zzu();
        int iZzb = zzhlVar.zzb(zZzu, 2);
        zzaf(zZzu, iZzb, zzS(zZzu, iZzb));
        zzkx zzkxVar = this.zzS;
        if (zzkxVar.zze != 1) {
            return;
        }
        zzkx zzkxVarZzd = zzkxVar.zzd(null);
        zzkx zzkxVarZze = zzkxVarZzd.zze(true == zzkxVarZzd.zza.zzo() ? 4 : 2);
        this.zzy++;
        this.zzk.zzj();
        zzag(zzkxVarZze, 1, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzq(boolean z10) {
        zzai();
        int iZzb = this.zzw.zzb(z10, zzf());
        zzaf(z10, iZzb, zzS(z10, iZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzr(@Nullable Surface surface) {
        zzai();
        zzad(surface);
        int i10 = surface == null ? 0 : -1;
        zzaa(i10, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzs(float f10) {
        zzai();
        final float fMax = Math.max(0.0f, Math.min(f10, 1.0f));
        if (this.zzM == fMax) {
            return;
        }
        this.zzM = fMax;
        zzac();
        zzdz zzdzVar = this.zzl;
        zzdzVar.zzd(22, new zzdw() { // from class: com.google.android.gms.internal.ads.zziq
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i10 = zzjm.zzd;
                ((zzbu) obj).zzs(fMax);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzt() {
        zzai();
        this.zzw.zzb(zzu(), 1);
        zzae(null);
        int i10 = zzdc.zza;
        zzfxr zzfxrVarZzm = zzfxr.zzm();
        long j10 = this.zzS.zzr;
        zzfxr.zzk(zzfxrVarZzm);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzu() {
        zzai();
        return this.zzS.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzv() {
        zzai();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzw() {
        zzai();
        return this.zzS.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final int zzx() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzy(zzlq zzlqVar) {
        this.zzq.zzt(zzlqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzz() {
        zzea.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.0-alpha02] [" + zzet.zze + "] [" + zzbd.zza() + v8.i.f15839e);
        zzai();
        this.zzw.zzd();
        if (!this.zzk.zzo()) {
            zzdz zzdzVar = this.zzl;
            zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzja
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj) {
                    ((zzbu) obj).zzj(zzhw.zzd(new zzjy(1), 1003));
                }
            });
            zzdzVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzs.zzf(this.zzq);
        zzkx zzkxVar = this.zzS;
        boolean z10 = zzkxVar.zzo;
        zzkx zzkxVarZze = zzkxVar.zze(1);
        this.zzS = zzkxVarZze;
        zzkx zzkxVarZza = zzkxVarZze.zza(zzkxVarZze.zzb);
        this.zzS = zzkxVarZza;
        zzkxVarZza.zzp = zzkxVarZza.zzr;
        this.zzS.zzq = 0L;
        this.zzq.zzP();
        this.zzi.zzj();
        Surface surface = this.zzH;
        if (surface != null) {
            surface.release();
            this.zzH = null;
        }
        int i10 = zzdc.zza;
    }
}

package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkk {
    private final zzln zzc;
    private final zzdt zzd;
    private long zze;
    private int zzf;
    private boolean zzg;

    @Nullable
    private zzkh zzh;

    @Nullable
    private zzkh zzi;

    @Nullable
    private zzkh zzj;
    private int zzk;

    @Nullable
    private Object zzl;
    private long zzm;
    private zzig zzn;
    private final zzjp zzp;
    private final zzca zza = new zzca();
    private final zzcb zzb = new zzcb();
    private List zzo = new ArrayList();

    public zzkk(zzln zzlnVar, zzdt zzdtVar, zzjp zzjpVar, zzig zzigVar) {
        this.zzc = zzlnVar;
        this.zzd = zzdtVar;
        this.zzp = zzjpVar;
        this.zzn = zzigVar;
    }

    private final zzki zzA(zzcc zzccVar, Object obj, long j10, long j11, long j12) {
        long j13;
        long j14;
        long j15;
        long jMax = j10;
        zzccVar.zzn(obj, this.zza);
        int iZzc = this.zza.zzc(jMax);
        if (iZzc != -1) {
            this.zza.zzm(iZzc);
        }
        if (iZzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(iZzc);
        }
        zzui zzuiVar = new zzui(obj, j12, iZzc);
        boolean zZzG = zzG(zzuiVar);
        boolean zZzE = zzE(zzccVar, zzuiVar);
        boolean zZzD = zzD(zzccVar, zzuiVar, zZzG);
        if (iZzc != -1) {
            this.zza.zzn(iZzc);
        }
        if (iZzc != -1) {
            this.zza.zzi(iZzc);
            j13 = 0;
        } else {
            j13 = -9223372036854775807L;
        }
        if (j13 != C.TIME_UNSET) {
            j14 = 0;
            j15 = 0;
        } else {
            j14 = j13;
            j15 = this.zza.zzd;
        }
        if (j15 != C.TIME_UNSET && jMax >= j15) {
            jMax = Math.max(0L, j15 - 1);
        }
        return new zzki(zzuiVar, jMax, j11, j14, j15, false, zZzG, zZzE, zZzD);
    }

    private static zzui zzB(zzcc zzccVar, Object obj, long j10, long j11, zzcb zzcbVar, zzca zzcaVar) {
        zzccVar.zzn(obj, zzcaVar);
        zzccVar.zze(zzcaVar.zzc, zzcbVar, 0L);
        zzccVar.zza(obj);
        zzcaVar.zzb();
        zzccVar.zzn(obj, zzcaVar);
        int iZzd = zzcaVar.zzd(j10);
        return iZzd == -1 ? new zzui(obj, j11, zzcaVar.zzc(j10)) : new zzui(obj, iZzd, zzcaVar.zze(iZzd), j11);
    }

    private final void zzC() {
        final zzfxo zzfxoVar = new zzfxo();
        for (zzkh zzkhVarZzg = this.zzh; zzkhVarZzg != null; zzkhVarZzg = zzkhVarZzg.zzg()) {
            zzfxoVar.zzf(zzkhVarZzg.zzf.zza);
        }
        zzkh zzkhVar = this.zzi;
        final zzui zzuiVar = zzkhVar == null ? null : zzkhVar.zzf.zza;
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzk(zzfxoVar, zzuiVar);
            }
        });
    }

    private final boolean zzD(zzcc zzccVar, zzui zzuiVar, boolean z10) {
        int iZza = zzccVar.zza(zzuiVar.zza);
        return !zzccVar.zze(zzccVar.zzd(iZza, this.zza, false).zzc, this.zzb, 0L).zzi && zzccVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg) == -1 && z10;
    }

    private final boolean zzE(zzcc zzccVar, zzui zzuiVar) {
        if (zzG(zzuiVar)) {
            return zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zza).zzc, this.zzb, 0L).zzo == zzccVar.zza(zzuiVar.zza);
        }
        return false;
    }

    private final boolean zzF(zzcc zzccVar) {
        zzkh zzkhVarZzg = this.zzh;
        if (zzkhVarZzg == null) {
            return true;
        }
        int iZza = zzccVar.zza(zzkhVarZzg.zzb);
        while (true) {
            iZza = zzccVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkhVarZzg.getClass();
                if (zzkhVarZzg.zzg() == null || zzkhVarZzg.zzf.zzg) {
                    break;
                }
                zzkhVarZzg = zzkhVarZzg.zzg();
            }
            zzkh zzkhVarZzg2 = zzkhVarZzg.zzg();
            if (iZza == -1 || zzkhVarZzg2 == null || zzccVar.zza(zzkhVarZzg2.zzb) != iZza) {
                break;
            }
            zzkhVarZzg = zzkhVarZzg2;
        }
        boolean zZzq = zzq(zzkhVarZzg);
        zzkhVarZzg.zzf = zzh(zzccVar, zzkhVarZzg.zzf);
        return !zZzq;
    }

    private static final boolean zzG(zzui zzuiVar) {
        return !zzuiVar.zzb() && zzuiVar.zze == -1;
    }

    static boolean zzo(long j10, long j11) {
        return j10 == C.TIME_UNSET || j10 == j11;
    }

    private final long zzv(zzcc zzccVar, Object obj, int i10) {
        zzccVar.zzn(obj, this.zza);
        this.zza.zzi(i10);
        this.zza.zzk(i10);
        return 0L;
    }

    private final long zzw(Object obj) {
        for (int i10 = 0; i10 < this.zzo.size(); i10++) {
            zzkh zzkhVar = (zzkh) this.zzo.get(i10);
            if (zzkhVar.zzb.equals(obj)) {
                return zzkhVar.zzf.zza.zzd;
            }
        }
        return -1L;
    }

    @Nullable
    private final zzki zzx(zzcc zzccVar, zzkh zzkhVar, long j10) {
        long j11;
        zzki zzkiVar = zzkhVar.zzf;
        long jZze = (zzkhVar.zze() + zzkiVar.zze) - j10;
        if (zzkiVar.zzg) {
            long j12 = 0;
            int iZzi = zzccVar.zzi(zzccVar.zza(zzkiVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (iZzi != -1) {
                int i10 = zzccVar.zzd(iZzi, this.zza, true).zzc;
                Object obj = this.zza.zzb;
                obj.getClass();
                long jZzw = zzkiVar.zza.zzd;
                if (zzccVar.zze(i10, this.zzb, 0L).zzn == iZzi) {
                    Pair pairZzm = zzccVar.zzm(this.zzb, this.zza, i10, C.TIME_UNSET, Math.max(0L, jZze));
                    if (pairZzm != null) {
                        obj = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzkh zzkhVarZzg = zzkhVar.zzg();
                        if (zzkhVarZzg == null || !zzkhVarZzg.zzb.equals(obj)) {
                            jZzw = zzw(obj);
                            if (jZzw == -1) {
                                jZzw = this.zze;
                                this.zze = 1 + jZzw;
                            }
                        } else {
                            jZzw = zzkhVarZzg.zzf.zza.zzd;
                        }
                        j11 = jLongValue;
                        j12 = C.TIME_UNSET;
                    }
                } else {
                    j11 = 0;
                }
                zzui zzuiVarZzB = zzB(zzccVar, obj, j11, jZzw, this.zzb, this.zza);
                if (j12 != C.TIME_UNSET && zzkiVar.zzc != C.TIME_UNSET) {
                    zzccVar.zzn(zzkiVar.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzy(zzccVar, zzuiVarZzB, j12, j11);
            }
        } else {
            zzui zzuiVar = zzkiVar.zza;
            zzccVar.zzn(zzuiVar.zza, this.zza);
            if (!zzuiVar.zzb()) {
                int i11 = zzuiVar.zze;
                if (i11 != -1) {
                    this.zza.zzm(i11);
                }
                zzca zzcaVar = this.zza;
                int i12 = zzuiVar.zze;
                int iZze = zzcaVar.zze(i12);
                zzcaVar.zzn(i12);
                if (iZze != this.zza.zza(zzuiVar.zze)) {
                    return zzz(zzccVar, zzuiVar.zza, zzuiVar.zze, iZze, zzkiVar.zze, zzuiVar.zzd);
                }
                zzv(zzccVar, zzuiVar.zza, zzuiVar.zze);
                return zzA(zzccVar, zzuiVar.zza, 0L, zzkiVar.zze, zzuiVar.zzd);
            }
            int i13 = zzuiVar.zzb;
            if (this.zza.zza(i13) != -1) {
                int iZzf = this.zza.zzf(i13, zzuiVar.zzc);
                if (iZzf < 0) {
                    return zzz(zzccVar, zzuiVar.zza, i13, iZzf, zzkiVar.zzc, zzuiVar.zzd);
                }
                long jLongValue2 = zzkiVar.zzc;
                if (jLongValue2 == C.TIME_UNSET) {
                    zzcb zzcbVar = this.zzb;
                    zzca zzcaVar2 = this.zza;
                    Pair pairZzm2 = zzccVar.zzm(zzcbVar, zzcaVar2, zzcaVar2.zzc, C.TIME_UNSET, Math.max(0L, jZze));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                    }
                }
                zzv(zzccVar, zzuiVar.zza, zzuiVar.zzb);
                return zzA(zzccVar, zzuiVar.zza, Math.max(0L, jLongValue2), zzkiVar.zzc, zzuiVar.zzd);
            }
        }
        return null;
    }

    private final zzki zzy(zzcc zzccVar, zzui zzuiVar, long j10, long j11) {
        zzccVar.zzn(zzuiVar.zza, this.zza);
        return zzuiVar.zzb() ? zzz(zzccVar, zzuiVar.zza, zzuiVar.zzb, zzuiVar.zzc, j10, zzuiVar.zzd) : zzA(zzccVar, zzuiVar.zza, j11, j10, zzuiVar.zzd);
    }

    private final zzki zzz(zzcc zzccVar, Object obj, int i10, int i11, long j10, long j11) {
        zzui zzuiVar = new zzui(obj, i10, i11, j11);
        long jZzh = zzccVar.zzn(zzuiVar.zza, this.zza).zzh(zzuiVar.zzb, zzuiVar.zzc);
        if (i11 == this.zza.zze(i10)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzuiVar.zzb);
        return new zzki(zzuiVar, (jZzh == C.TIME_UNSET || jZzh > 0) ? 0L : Math.max(0L, (-1) + jZzh), j10, C.TIME_UNSET, jZzh, false, false, false, false);
    }

    @Nullable
    public final zzkh zza() {
        zzkh zzkhVar = this.zzh;
        if (zzkhVar == null) {
            return null;
        }
        if (zzkhVar == this.zzi) {
            this.zzi = zzkhVar.zzg();
        }
        zzkhVar.zzn();
        int i10 = this.zzk - 1;
        this.zzk = i10;
        if (i10 == 0) {
            this.zzj = null;
            zzkh zzkhVar2 = this.zzh;
            this.zzl = zzkhVar2.zzb;
            this.zzm = zzkhVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzC();
        return this.zzh;
    }

    public final zzkh zzb() {
        zzkh zzkhVar = this.zzi;
        zzdi.zzb(zzkhVar);
        this.zzi = zzkhVar.zzg();
        zzC();
        zzkh zzkhVar2 = this.zzi;
        zzdi.zzb(zzkhVar2);
        return zzkhVar2;
    }

    public final zzkh zzc(zzki zzkiVar) {
        zzkh zzkhVarZzd;
        zzkh zzkhVar = this.zzj;
        long jZze = zzkhVar == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (zzkhVar.zze() + zzkhVar.zzf.zze) - zzkiVar.zzb;
        int i10 = 0;
        while (true) {
            if (i10 >= this.zzo.size()) {
                zzkhVarZzd = null;
                break;
            }
            zzki zzkiVar2 = ((zzkh) this.zzo.get(i10)).zzf;
            if (zzo(zzkiVar2.zze, zzkiVar.zze) && zzkiVar2.zzb == zzkiVar.zzb && zzkiVar2.zza.equals(zzkiVar.zza)) {
                zzkhVarZzd = (zzkh) this.zzo.remove(i10);
                break;
            }
            i10++;
        }
        if (zzkhVarZzd == null) {
            zzkhVarZzd = zzjx.zzd(this.zzp.zza, zzkiVar, jZze);
        } else {
            zzkhVarZzd.zzf = zzkiVar;
            zzkhVarZzd.zzp(jZze);
        }
        zzkh zzkhVar2 = this.zzj;
        if (zzkhVar2 != null) {
            zzkhVar2.zzo(zzkhVarZzd);
        } else {
            this.zzh = zzkhVarZzd;
            this.zzi = zzkhVarZzd;
        }
        this.zzl = null;
        this.zzj = zzkhVarZzd;
        this.zzk++;
        zzC();
        return zzkhVarZzd;
    }

    @Nullable
    public final zzkh zzd() {
        return this.zzj;
    }

    @Nullable
    public final zzkh zze() {
        return this.zzh;
    }

    @Nullable
    public final zzkh zzf() {
        return this.zzi;
    }

    @Nullable
    public final zzki zzg(long j10, zzkx zzkxVar) {
        zzkh zzkhVar = this.zzj;
        return zzkhVar == null ? zzy(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzr) : zzx(zzkxVar.zza, zzkhVar, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzki zzh(com.google.android.gms.internal.ads.zzcc r19, com.google.android.gms.internal.ads.zzki r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzui r3 = r2.zza
            boolean r12 = zzG(r3)
            boolean r13 = r0.zzE(r1, r3)
            boolean r14 = r0.zzD(r1, r3, r12)
            com.google.android.gms.internal.ads.zzui r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzca r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L37
            int r1 = r3.zze
            if (r1 != r4) goto L30
            goto L37
        L30:
            com.google.android.gms.internal.ads.zzca r9 = r0.zza
            r9.zzi(r1)
            r9 = r5
            goto L38
        L37:
            r9 = r7
        L38:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L4b
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L48:
            r7 = r9
            r9 = r5
            goto L57
        L4b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L52
            r7 = r5
            r9 = r7
            goto L57
        L52:
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            long r5 = r1.zzd
            goto L48
        L57:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L65
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L6e
        L65:
            int r1 = r3.zze
            if (r1 == r4) goto L6e
            com.google.android.gms.internal.ads.zzca r4 = r0.zza
            r4.zzn(r1)
        L6e:
            com.google.android.gms.internal.ads.zzki r15 = new com.google.android.gms.internal.ads.zzki
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkk.zzh(com.google.android.gms.internal.ads.zzcc, com.google.android.gms.internal.ads.zzki):com.google.android.gms.internal.ads.zzki");
    }

    public final zzui zzi(zzcc zzccVar, Object obj, long j10) {
        long jZzw;
        int iZza;
        int i10 = zzccVar.zzn(obj, this.zza).zzc;
        Object obj2 = this.zzl;
        if (obj2 == null || (iZza = zzccVar.zza(obj2)) == -1 || zzccVar.zzd(iZza, this.zza, false).zzc != i10) {
            zzkh zzkhVarZzg = this.zzh;
            while (true) {
                if (zzkhVarZzg == null) {
                    zzkh zzkhVarZzg2 = this.zzh;
                    while (true) {
                        if (zzkhVarZzg2 != null) {
                            int iZza2 = zzccVar.zza(zzkhVarZzg2.zzb);
                            if (iZza2 != -1 && zzccVar.zzd(iZza2, this.zza, false).zzc == i10) {
                                jZzw = zzkhVarZzg2.zzf.zza.zzd;
                                break;
                            }
                            zzkhVarZzg2 = zzkhVarZzg2.zzg();
                        } else {
                            jZzw = zzw(obj);
                            if (jZzw == -1) {
                                jZzw = this.zze;
                                this.zze = 1 + jZzw;
                                if (this.zzh == null) {
                                    this.zzl = obj;
                                    this.zzm = jZzw;
                                }
                            }
                        }
                    }
                } else {
                    if (zzkhVarZzg.zzb.equals(obj)) {
                        jZzw = zzkhVarZzg.zzf.zza.zzd;
                        break;
                    }
                    zzkhVarZzg = zzkhVarZzg.zzg();
                }
            }
        } else {
            jZzw = this.zzm;
        }
        long j11 = jZzw;
        zzccVar.zzn(obj, this.zza);
        zzccVar.zze(this.zza.zzc, this.zzb, 0L);
        int iZza3 = zzccVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcb zzcbVar = this.zzb;
            if (iZza3 < zzcbVar.zzn) {
                return zzB(zzccVar, obj3, j10, j11, zzcbVar, this.zza);
            }
            zzccVar.zzd(iZza3, this.zza, true);
            this.zza.zzb();
            zzca zzcaVar = this.zza;
            if (zzcaVar.zzd(zzcaVar.zzd) != -1) {
                obj3 = this.zza.zzb;
                obj3.getClass();
            }
            iZza3--;
        }
    }

    public final void zzj() {
        if (this.zzk == 0) {
            return;
        }
        zzkh zzkhVarZzg = this.zzh;
        zzdi.zzb(zzkhVarZzg);
        this.zzl = zzkhVarZzg.zzb;
        this.zzm = zzkhVarZzg.zzf.zza.zzd;
        while (zzkhVarZzg != null) {
            zzkhVarZzg.zzn();
            zzkhVarZzg = zzkhVarZzg.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzC();
    }

    final /* synthetic */ void zzk(zzfxo zzfxoVar, zzui zzuiVar) {
        this.zzc.zzS(zzfxoVar.zzi(), zzuiVar);
    }

    public final void zzl(long j10) {
        zzkh zzkhVar = this.zzj;
        if (zzkhVar != null) {
            zzkhVar.zzm(j10);
        }
    }

    public final void zzm() {
        if (this.zzo.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.zzo.size(); i10++) {
            ((zzkh) this.zzo.get(i10)).zzn();
        }
        this.zzo = arrayList;
    }

    public final void zzn(zzcc zzccVar, zzig zzigVar) {
        this.zzn = zzigVar;
        long j10 = zzigVar.zzb;
        zzm();
    }

    public final boolean zzp(zzug zzugVar) {
        zzkh zzkhVar = this.zzj;
        return zzkhVar != null && zzkhVar.zza == zzugVar;
    }

    public final boolean zzq(zzkh zzkhVar) {
        zzdi.zzb(zzkhVar);
        boolean z10 = false;
        if (zzkhVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkhVar;
        while (zzkhVar.zzg() != null) {
            zzkhVar = zzkhVar.zzg();
            zzkhVar.getClass();
            if (zzkhVar == this.zzi) {
                this.zzi = this.zzh;
                z10 = true;
            }
            zzkhVar.zzn();
            this.zzk--;
        }
        zzkh zzkhVar2 = this.zzj;
        zzkhVar2.getClass();
        zzkhVar2.zzo(null);
        zzC();
        return z10;
    }

    public final boolean zzr() {
        zzkh zzkhVar = this.zzj;
        if (zzkhVar == null) {
            return true;
        }
        if (zzkhVar.zzf.zzi || !zzkhVar.zzr() || this.zzj.zzf.zze == C.TIME_UNSET) {
            return false;
        }
        return this.zzk < 100;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzs(com.google.android.gms.internal.ads.zzcc r16, long r17, long r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            com.google.android.gms.internal.ads.zzkh r2 = r0.zzh
            r3 = 0
        L6:
            r4 = 1
            if (r2 == 0) goto L93
            com.google.android.gms.internal.ads.zzki r5 = r2.zzf
            r6 = 0
            if (r3 != 0) goto L15
            com.google.android.gms.internal.ads.zzki r3 = r15.zzh(r1, r5)
            r7 = r17
            goto L38
        L15:
            r7 = r17
            com.google.android.gms.internal.ads.zzki r9 = r15.zzx(r1, r3, r7)
            if (r9 != 0) goto L25
            boolean r1 = r15.zzq(r3)
            if (r1 != 0) goto L24
            return r4
        L24:
            return r6
        L25:
            long r10 = r5.zzb
            long r12 = r9.zzb
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L8b
            com.google.android.gms.internal.ads.zzui r10 = r5.zza
            com.google.android.gms.internal.ads.zzui r11 = r9.zza
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L8b
            r3 = r9
        L38:
            long r9 = r5.zzc
            com.google.android.gms.internal.ads.zzki r9 = r3.zza(r9)
            r2.zzf = r9
            long r9 = r5.zze
            long r11 = r3.zze
            boolean r5 = zzo(r9, r11)
            if (r5 != 0) goto L82
            r2.zzq()
            long r7 = r3.zze
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L5e
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L63
        L5e:
            long r9 = r2.zze()
            long r7 = r7 + r9
        L63:
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzi
            if (r2 != r1) goto L77
            com.google.android.gms.internal.ads.zzki r1 = r2.zzf
            boolean r1 = r1.zzf
            r9 = -9223372036854775808
            int r1 = (r19 > r9 ? 1 : (r19 == r9 ? 0 : -1))
            if (r1 == 0) goto L75
            int r1 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r1 < 0) goto L77
        L75:
            r1 = r4
            goto L78
        L77:
            r1 = r6
        L78:
            boolean r2 = r15.zzq(r2)
            if (r2 != 0) goto L81
            if (r1 != 0) goto L81
            return r4
        L81:
            return r6
        L82:
            com.google.android.gms.internal.ads.zzkh r3 = r2.zzg()
            r14 = r3
            r3 = r2
            r2 = r14
            goto L6
        L8b:
            boolean r1 = r15.zzq(r3)
            if (r1 != 0) goto L92
            return r4
        L92:
            return r6
        L93:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkk.zzs(com.google.android.gms.internal.ads.zzcc, long, long):boolean");
    }

    public final boolean zzt(zzcc zzccVar, int i10) {
        this.zzf = i10;
        return zzF(zzccVar);
    }

    public final boolean zzu(zzcc zzccVar, boolean z10) {
        this.zzg = z10;
        return zzF(zzccVar);
    }
}

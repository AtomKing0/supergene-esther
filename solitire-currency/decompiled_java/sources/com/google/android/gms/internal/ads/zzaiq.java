package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.mp4.Atom;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaiq implements zzack, zzadi {

    @Nullable
    private zzagr zzA;
    private final zzajy zza;
    private final int zzb;
    private final zzek zzc;
    private final zzek zzd;
    private final zzek zze;
    private final zzek zzf;
    private final ArrayDeque zzg;
    private final zzaiu zzh;
    private final List zzi;
    private zzfxr zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;

    @Nullable
    private zzek zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacn zzu;
    private zzaip[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzaiq() {
        this(zzajy.zza, 16);
    }

    private static int zzk(int i10) {
        if (i10 != 1751476579) {
            return i10 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzl(zzaiz zzaizVar, long j10) {
        int iZza = zzaizVar.zza(j10);
        return iZza == -1 ? zzaizVar.zzb(j10) : iZza;
    }

    private static long zzm(zzaiz zzaizVar, long j10, long j11) {
        int iZzl = zzl(zzaizVar, j10);
        return iZzl == -1 ? j11 : Math.min(zzaizVar.zzc[iZzl], j11);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzo(long j10) throws zzbo {
        zzbk zzbkVar;
        long j11;
        List list;
        zzbk zzbkVar2;
        int i10;
        int i11;
        while (!this.zzg.isEmpty() && ((zzahv) this.zzg.peek()).zza == j10) {
            zzahv zzahvVar = (zzahv) this.zzg.pop();
            if (zzahvVar.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i12 = this.zzz;
                zzacy zzacyVar = new zzacy();
                zzahw zzahwVarZzb = zzahvVar.zzb(Atom.TYPE_udta);
                if (zzahwVarZzb != null) {
                    zzbk zzbkVarZzb = zzaif.zzb(zzahwVarZzb);
                    zzacyVar.zzb(zzbkVarZzb);
                    zzbkVar = zzbkVarZzb;
                } else {
                    zzbkVar = null;
                }
                zzahv zzahvVarZza = zzahvVar.zza(Atom.TYPE_meta);
                zzbk zzbkVarZza = zzahvVarZza != null ? zzaif.zza(zzahvVarZza) : null;
                zzbj[] zzbjVarArr = new zzbj[1];
                zzahw zzahwVarZzb2 = zzahvVar.zzb(Atom.TYPE_mvhd);
                zzahwVarZzb2.getClass();
                boolean z10 = i12 == 1;
                zzbjVarArr[0] = zzaif.zzc(zzahwVarZzb2.zza);
                zzbk zzbkVar3 = new zzbk(C.TIME_UNSET, zzbjVarArr);
                zzbk zzbkVar4 = zzbkVar;
                long j12 = -9223372036854775807L;
                List listZzd = zzaif.zzd(zzahvVar, zzacyVar, C.TIME_UNSET, null, 1 == (this.zzb & 1), z10, new zzful() { // from class: com.google.android.gms.internal.ads.zzaio
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return (zzaiw) obj;
                    }
                });
                long j13 = -9223372036854775807L;
                int i13 = 0;
                int size = -1;
                int i14 = 0;
                while (true) {
                    j11 = 0;
                    if (i14 >= listZzd.size()) {
                        break;
                    }
                    zzaiz zzaizVar = (zzaiz) listZzd.get(i14);
                    if (zzaizVar.zzb == 0) {
                        list = listZzd;
                    } else {
                        zzaiw zzaiwVar = zzaizVar.zza;
                        list = listZzd;
                        long j14 = zzaiwVar.zze;
                        if (j14 == j12) {
                            j14 = zzaizVar.zzh;
                        }
                        long jMax = Math.max(j13, j14);
                        int i15 = i13 + 1;
                        zzaip zzaipVar = new zzaip(zzaiwVar, zzaizVar, this.zzu.zzw(i13, zzaiwVar.zzb));
                        int i16 = MimeTypes.AUDIO_TRUEHD.equals(zzaiwVar.zzf.zzm) ? zzaizVar.zze * 16 : zzaizVar.zze + 30;
                        zzad zzadVarZzb = zzaiwVar.zzf.zzb();
                        zzadVarZzb.zzP(i16);
                        if (zzaiwVar.zzb == 2) {
                            if ((this.zzb & 8) != 0) {
                                zzadVarZzb.zzV(zzaiwVar.zzf.zzf | (size == -1 ? 1 : 2));
                            }
                            if (j14 > 0 && (i11 = zzaizVar.zzb) > 0) {
                                zzadVarZzb.zzH(i11 / (j14 / 1000000.0f));
                            }
                        }
                        if (zzaiwVar.zzb == 1 && zzacyVar.zza()) {
                            zzadVarZzb.zzF(zzacyVar.zza);
                            zzadVarZzb.zzG(zzacyVar.zzb);
                        }
                        int i17 = zzaiwVar.zzb;
                        zzbk[] zzbkVarArr = new zzbk[3];
                        if (this.zzi.isEmpty()) {
                            i10 = 0;
                            zzbkVar2 = null;
                        } else {
                            zzbkVar2 = new zzbk(this.zzi);
                            i10 = 0;
                        }
                        zzbkVarArr[i10] = zzbkVar2;
                        zzbkVarArr[1] = zzbkVar4;
                        zzbkVarArr[2] = zzbkVar3;
                        int i18 = size;
                        zzbk zzbkVar5 = new zzbk(C.TIME_UNSET, new zzbj[i10]);
                        if (zzbkVarZza != null) {
                            for (int i19 = 0; i19 < zzbkVarZza.zza(); i19++) {
                                zzbj zzbjVarZzb = zzbkVarZza.zzb(i19);
                                if (zzbjVarZzb instanceof zzex) {
                                    zzex zzexVar = (zzex) zzbjVarZzb;
                                    if (!zzexVar.zza.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                                        zzbkVar5 = zzbkVar5.zzc(zzexVar);
                                    } else if (i17 == 2) {
                                        zzbkVar5 = zzbkVar5.zzc(zzexVar);
                                    }
                                }
                            }
                        }
                        for (int i20 = 0; i20 < 3; i20++) {
                            zzbkVar5 = zzbkVar5.zzd(zzbkVarArr[i20]);
                        }
                        if (zzbkVar5.zza() > 0) {
                            zzadVarZzb.zzQ(zzbkVar5);
                        }
                        zzaipVar.zzc.zzl(zzadVarZzb.zzad());
                        size = (zzaiwVar.zzb == 2 && i18 == -1) ? arrayList.size() : i18;
                        arrayList.add(zzaipVar);
                        i13 = i15;
                        j13 = jMax;
                    }
                    i14++;
                    listZzd = list;
                    j12 = C.TIME_UNSET;
                }
                this.zzx = size;
                this.zzy = j13;
                zzaip[] zzaipVarArr = (zzaip[]) arrayList.toArray(new zzaip[0]);
                this.zzv = zzaipVarArr;
                int length = zzaipVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i21 = 0; i21 < zzaipVarArr.length; i21++) {
                    jArr[i21] = new long[zzaipVarArr[i21].zzb.zzb];
                    jArr2[i21] = zzaipVarArr[i21].zzb.zzf[0];
                }
                int i22 = 0;
                while (i22 < zzaipVarArr.length) {
                    int i23 = -1;
                    long j15 = Long.MAX_VALUE;
                    for (int i24 = 0; i24 < zzaipVarArr.length; i24++) {
                        if (!zArr[i24]) {
                            long j16 = jArr2[i24];
                            if (j16 <= j15) {
                                i23 = i24;
                                j15 = j16;
                            }
                        }
                    }
                    int i25 = iArr[i23];
                    long[] jArr3 = jArr[i23];
                    jArr3[i25] = j11;
                    zzaiz zzaizVar2 = zzaipVarArr[i23].zzb;
                    j11 += (long) zzaizVar2.zzd[i25];
                    int i26 = i25 + 1;
                    iArr[i23] = i26;
                    if (i26 < jArr3.length) {
                        jArr2[i23] = zzaizVar2.zzf[i26];
                    } else {
                        zArr[i23] = true;
                        i22++;
                    }
                }
                this.zzw = jArr;
                this.zzu.zzD();
                this.zzu.zzO(this);
                this.zzg.clear();
                this.zzk = 2;
            } else if (!this.zzg.isEmpty()) {
                ((zzahv) this.zzg.peek()).zzc(zzahvVar);
            }
        }
        if (this.zzk != 2) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzy;
    }

    /* JADX WARN: Removed duplicated region for block: B:278:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r33, com.google.android.gms.internal.ads.zzadf r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1137
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiq.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        if ((this.zzb & 16) == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zza);
        }
        this.zzu = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        long j11;
        long j12;
        int iZzb;
        zzaip[] zzaipVarArr = this.zzv;
        if (zzaipVarArr.length == 0) {
            zzadj zzadjVar = zzadj.zza;
            return new zzadg(zzadjVar, zzadjVar);
        }
        int i10 = this.zzx;
        long jZzm = -1;
        if (i10 != -1) {
            zzaiz zzaizVar = zzaipVarArr[i10].zzb;
            int iZzl = zzl(zzaizVar, j10);
            if (iZzl == -1) {
                zzadj zzadjVar2 = zzadj.zza;
                return new zzadg(zzadjVar2, zzadjVar2);
            }
            long j13 = zzaizVar.zzf[iZzl];
            j11 = zzaizVar.zzc[iZzl];
            if (j13 >= j10 || iZzl >= zzaizVar.zzb - 1 || (iZzb = zzaizVar.zzb(j10)) == -1 || iZzb == iZzl) {
                j12 = -9223372036854775807L;
            } else {
                j12 = zzaizVar.zzf[iZzb];
                jZzm = zzaizVar.zzc[iZzb];
            }
            j10 = j13;
        } else {
            j11 = Long.MAX_VALUE;
            j12 = -9223372036854775807L;
        }
        int i11 = 0;
        while (true) {
            zzaip[] zzaipVarArr2 = this.zzv;
            if (i11 >= zzaipVarArr2.length) {
                break;
            }
            if (i11 != this.zzx) {
                zzaiz zzaizVar2 = zzaipVarArr2[i11].zzb;
                long jZzm2 = zzm(zzaizVar2, j10, j11);
                if (j12 != C.TIME_UNSET) {
                    jZzm = zzm(zzaizVar2, j12, jZzm);
                }
                j11 = jZzm2;
            }
            i11++;
        }
        zzadj zzadjVar3 = new zzadj(j10, j11);
        return j12 == C.TIME_UNSET ? new zzadg(zzadjVar3, zzadjVar3) : new zzadg(zzadjVar3, new zzadj(j12, jZzm));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j10 == 0) {
            if (this.zzk != 3) {
                zzn();
                return;
            } else {
                this.zzh.zzb();
                this.zzi.clear();
                return;
            }
        }
        for (zzaip zzaipVar : this.zzv) {
            zzaiz zzaizVar = zzaipVar.zzb;
            int iZza = zzaizVar.zza(j11);
            if (iZza == -1) {
                iZza = zzaizVar.zzb(j11);
            }
            zzaipVar.zze = iZza;
            zzadq zzadqVar = zzaipVar.zzd;
            if (zzadqVar != null) {
                zzadqVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        zzadm zzadmVarZzb = zzaiv.zzb(zzaclVar, (this.zzb & 2) != 0);
        this.zzj = zzadmVarZzb != null ? zzfxr.zzn(zzadmVarZzb) : zzfxr.zzm();
        return zzadmVarZzb == null;
    }

    public zzaiq(zzajy zzajyVar, int i10) {
        this.zza = zzajyVar;
        this.zzb = i10;
        this.zzj = zzfxr.zzm();
        this.zzk = (i10 & 4) != 0 ? 3 : 0;
        this.zzh = new zzaiu();
        this.zzi = new ArrayList();
        this.zzf = new zzek(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzek(zzfh.zza);
        this.zzd = new zzek(4);
        this.zze = new zzek();
        this.zzp = -1;
        this.zzu = zzacn.zza;
        this.zzv = new zzaip[0];
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}

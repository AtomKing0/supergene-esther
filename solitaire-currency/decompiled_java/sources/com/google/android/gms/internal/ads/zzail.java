package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzail implements zzack {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzaf zzb;

    @Nullable
    private zzaik zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private zzacn zzF;
    private zzadp[] zzG;
    private zzadp[] zzH;
    private boolean zzI;
    private final zzajy zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzek zzg;
    private final zzek zzh;
    private final zzek zzi;
    private final byte[] zzj;
    private final zzek zzk;
    private final zzafh zzl;
    private final zzek zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private zzfxr zzp;
    private int zzq;
    private int zzr;
    private long zzs;
    private int zzt;

    @Nullable
    private zzek zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zzX(MimeTypes.APPLICATION_EMSG);
        zzb = zzadVar.zzad();
    }

    @Deprecated
    public zzail() {
        this(zzajy.zza, 32, null, null, zzfxr.zzm(), null);
    }

    private static int zza(int i10) throws zzbo {
        if (i10 >= 0) {
            return i10;
        }
        throw zzbo.zza("Unexpected negative value: " + i10, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzy zzg(java.util.List r18) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzg(java.util.List):com.google.android.gms.internal.ads.zzy");
    }

    private final void zzh() {
        this.zzq = 0;
        this.zzt = 0;
    }

    private static void zzk(zzek zzekVar, int i10, zzaiy zzaiyVar) throws zzbo {
        zzekVar.zzK(i10 + 8);
        int iZzg = zzekVar.zzg() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iZzg & 1) != 0) {
            throw zzbo.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (iZzg & 2) != 0;
        int iZzp = zzekVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzaiyVar.zzl, 0, zzaiyVar.zze, false);
            return;
        }
        int i11 = zzaiyVar.zze;
        if (iZzp != i11) {
            throw zzbo.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i11, null);
        }
        Arrays.fill(zzaiyVar.zzl, 0, iZzp, z10);
        zzaiyVar.zza(zzekVar.zzb());
        zzek zzekVar2 = zzaiyVar.zzn;
        zzekVar.zzG(zzekVar2.zzM(), 0, zzekVar2.zze());
        zzaiyVar.zzn.zzK(0);
        zzaiyVar.zzo = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x065a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzl(long r51) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzl(long):void");
    }

    private static final zzaih zzm(SparseArray sparseArray, int i10) {
        if (sparseArray.size() == 1) {
            return (zzaih) sparseArray.valueAt(0);
        }
        zzaih zzaihVar = (zzaih) sparseArray.get(i10);
        zzaihVar.getClass();
        return zzaihVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0245, code lost:
    
        r5.zzs(r10, r20, r33.zzB, 0, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0258, code lost:
    
        if (r33.zzo.isEmpty() != false) goto L392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x025a, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzaij) r33.zzo.removeFirst();
        r33.zzw -= r1.zzc;
        r3 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x026d, code lost:
    
        if (r1.zzb == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x026f, code lost:
    
        r3 = r3 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0270, code lost:
    
        r5 = r33.zzG;
        r6 = r5.length;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0274, code lost:
    
        if (r8 >= r6) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0276, code lost:
    
        r5[r8].zzs(r3, 1, r1.zzc, r33.zzw, null);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x028e, code lost:
    
        if (r2.zzk() != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0290, code lost:
    
        r33.zzA = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0292, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0293, code lost:
    
        r33.zzq = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0296, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0099, code lost:
    
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        if (r33.zzq != 3) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        r3 = r2.zzb();
        r33.zzB = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
    
        if (r2.zzf >= r2.zzi) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        ((com.google.android.gms.internal.ads.zzaby) r34).zzo(r3, false);
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
    
        if (r1 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
    
        r3 = r2.zzb.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
    
        if (r1 == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
    
        r3.zzL(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        if (r2.zzb.zzb(r2.zzf) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cb, code lost:
    
        r3.zzL(r3.zzq() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d7, code lost:
    
        if (r2.zzk() != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d9, code lost:
    
        r33.zzA = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00db, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e4, code lost:
    
        if (r2.zzd.zza.zzg != 1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e6, code lost:
    
        r33.zzB = r3 - 8;
        ((com.google.android.gms.internal.ads.zzaby) r34).zzo(8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0100, code lost:
    
        if (androidx.media3.common.MimeTypes.AUDIO_AC4.equals(r2.zzd.zza.zzf.zzm) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0102, code lost:
    
        r33.zzC = r2.zzc(r33.zzB, 7);
        com.google.android.gms.internal.ads.zzabm.zzb(r33.zzB, r33.zzk);
        r2.zza.zzq(r33.zzk, 7);
        r3 = r33.zzC + 7;
        r33.zzC = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011f, code lost:
    
        r3 = r2.zzc(r33.zzB, 0);
        r33.zzC = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0127, code lost:
    
        r33.zzB += r3;
        r33.zzq = 4;
        r33.zzD = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0131, code lost:
    
        r3 = r2.zzd.zza;
        r5 = r2.zza;
        r10 = r2.zze();
        r6 = r3.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013d, code lost:
    
        if (r6 != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013f, code lost:
    
        r3 = r33.zzC;
        r4 = r33.zzB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        if (r3 >= r4) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0145, code lost:
    
        r33.zzC += r5.zzf(r34, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0150, code lost:
    
        r13 = r33.zzh.zzM();
        r13[0] = 0;
        r13[1] = 0;
        r13[2] = 0;
        r14 = r6 + 1;
        r6 = 4 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0166, code lost:
    
        if (r33.zzC >= r33.zzB) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0168, code lost:
    
        r12 = r33.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016c, code lost:
    
        if (r12 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016e, code lost:
    
        ((com.google.android.gms.internal.ads.zzaby) r34).zzn(r13, r6, r14, r9);
        r33.zzh.zzK(r9);
        r12 = r33.zzh.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017f, code lost:
    
        if (r12 <= 0) goto L397;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0181, code lost:
    
        r33.zzD = r12 - 1;
        r33.zzg.zzK(r9);
        r5.zzq(r33.zzg, 4);
        r5.zzq(r33.zzh, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0198, code lost:
    
        if (r33.zzH.length <= 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019a, code lost:
    
        r12 = r3.zzf.zzm;
        r17 = r13[4];
        r9 = com.google.android.gms.internal.ads.zzfh.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a8, code lost:
    
        if ("video/avc".equals(r12) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ac, code lost:
    
        if ((r17 & 31) == r4) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01af, code lost:
    
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b5, code lost:
    
        if ("video/hevc".equals(r12) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bc, code lost:
    
        if (((r17 & 126) >> r8) != 39) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01bf, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        r33.zzE = r9;
        r33.zzC += 5;
        r33.zzB += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d4, code lost:
    
        throw com.google.android.gms.internal.ads.zzbo.zza("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d7, code lost:
    
        if (r33.zzE == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d9, code lost:
    
        r33.zzi.zzH(r12);
        ((com.google.android.gms.internal.ads.zzaby) r34).zzn(r33.zzi.zzM(), 0, r33.zzD, false);
        r5.zzq(r33.zzi, r33.zzD);
        r4 = r33.zzD;
        r8 = r33.zzi;
        r8 = com.google.android.gms.internal.ads.zzfh.zzb(r8.zzM(), r8.zze());
        r33.zzi.zzK("video/hevc".equals(r3.zzf.zzm) ? 1 : 0);
        r33.zzi.zzJ(r8);
        com.google.android.gms.internal.ads.zzabv.zza(r10, r33.zzi, r33.zzH);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x021e, code lost:
    
        r4 = r5.zzf(r34, r12, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0224, code lost:
    
        r33.zzC += r4;
        r33.zzD -= r4;
        r4 = 6;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0230, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0234, code lost:
    
        r20 = r2.zza();
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x023c, code lost:
    
        if (r1 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023e, code lost:
    
        r23 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0243, code lost:
    
        r23 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v10 */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r34, com.google.android.gms.internal.ads.zzadf r35) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        int i10;
        if ((this.zzd & 32) == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zzc);
        }
        this.zzF = zzacnVar;
        zzh();
        zzadp[] zzadpVarArr = new zzadp[2];
        this.zzG = zzadpVarArr;
        int i11 = 100;
        int i12 = 0;
        if ((this.zzd & 4) != 0) {
            zzadpVarArr[0] = this.zzF.zzw(100, 5);
            i10 = 1;
            i11 = 101;
        } else {
            i10 = 0;
        }
        zzadp[] zzadpVarArr2 = (zzadp[]) zzet.zzP(this.zzG, i10);
        this.zzG = zzadpVarArr2;
        for (zzadp zzadpVar : zzadpVarArr2) {
            zzadpVar.zzl(zzb);
        }
        this.zzH = new zzadp[this.zze.size()];
        while (i12 < this.zzH.length) {
            zzadp zzadpVarZzw = this.zzF.zzw(i11, 3);
            zzadpVarZzw.zzl((zzaf) this.zze.get(i12));
            this.zzH[i12] = zzadpVarZzw;
            i12++;
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        int size = this.zzf.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((zzaik) this.zzf.valueAt(i10)).zzi();
        }
        this.zzo.clear();
        this.zzw = 0;
        this.zzx = j11;
        this.zzn.clear();
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        zzadm zzadmVarZza = zzaiv.zza(zzaclVar);
        this.zzp = zzadmVarZza != null ? zzfxr.zzn(zzadmVarZza) : zzfxr.zzm();
        return zzadmVarZza == null;
    }

    public zzail(zzajy zzajyVar, int i10, @Nullable zzer zzerVar, @Nullable zzaiw zzaiwVar, List list, @Nullable zzadp zzadpVar) {
        this.zzc = zzajyVar;
        this.zzd = i10;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafh();
        this.zzm = new zzek(16);
        this.zzg = new zzek(zzfh.zza);
        this.zzh = new zzek(5);
        this.zzi = new zzek();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzek(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzp = zzfxr.zzm();
        this.zzy = C.TIME_UNSET;
        this.zzx = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzF = zzacn.zza;
        this.zzG = new zzadp[0];
        this.zzH = new zzadp[0];
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}

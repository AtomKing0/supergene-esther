package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadw implements zzack {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final int zze;
    private final byte[] zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private zzacn zzo;
    private zzadp zzp;
    private zzadi zzq;
    private boolean zzr;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzb = iArr;
        int i10 = zzet.zza;
        Charset charset = zzfuj.zzc;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
        zze = iArr[8];
    }

    public zzadw() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: EOFException -> 0x00b5, TryCatch #0 {EOFException -> 0x00b5, blocks: (B:5:0x0008, B:7:0x001c, B:21:0x003a, B:23:0x0043, B:22:0x003f, B:40:0x0081, B:41:0x009e, B:42:0x009f, B:43:0x00b4), top: B:45:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[Catch: EOFException -> 0x00b5, TryCatch #0 {EOFException -> 0x00b5, blocks: (B:5:0x0008, B:7:0x001c, B:21:0x003a, B:23:0x0043, B:22:0x003f, B:40:0x0081, B:41:0x009e, B:42:0x009f, B:43:0x00b4), top: B:45:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(com.google.android.gms.internal.ads.zzacl r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.zzj
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L8
            goto L55
        L8:
            r12.zzj()     // Catch: java.io.EOFException -> Lb5
            byte[] r0 = r11.zzf     // Catch: java.io.EOFException -> Lb5
            r4 = r12
            com.google.android.gms.internal.ads.zzaby r4 = (com.google.android.gms.internal.ads.zzaby) r4     // Catch: java.io.EOFException -> Lb5
            r4.zzm(r0, r3, r2, r3)     // Catch: java.io.EOFException -> Lb5
            byte[] r0 = r11.zzf     // Catch: java.io.EOFException -> Lb5
            r0 = r0[r3]     // Catch: java.io.EOFException -> Lb5
            r4 = r0 & 131(0x83, float:1.84E-43)
            r5 = 0
            if (r4 > 0) goto L9f
            int r0 = r0 >> 3
            boolean r4 = r11.zzg     // Catch: java.io.EOFException -> Lb5
            r0 = r0 & 15
            if (r4 == 0) goto L2d
            r6 = 10
            if (r0 < r6) goto L38
            r6 = 13
            if (r0 <= r6) goto L2d
            goto L38
        L2d:
            if (r4 != 0) goto L7a
            r6 = 12
            if (r0 < r6) goto L38
            r6 = 14
            if (r0 > r6) goto L38
            goto L7a
        L38:
            if (r4 == 0) goto L3f
            int[] r4 = com.google.android.gms.internal.ads.zzadw.zzb     // Catch: java.io.EOFException -> Lb5
            r0 = r4[r0]     // Catch: java.io.EOFException -> Lb5
            goto L43
        L3f:
            int[] r4 = com.google.android.gms.internal.ads.zzadw.zza     // Catch: java.io.EOFException -> Lb5
            r0 = r4[r0]     // Catch: java.io.EOFException -> Lb5
        L43:
            r11.zzi = r0     // Catch: java.io.EOFException -> Lb5
            r11.zzj = r0
            int r4 = r11.zzl
            if (r4 != r1) goto L4e
            r11.zzl = r0
            r4 = r0
        L4e:
            if (r4 != r0) goto L55
            int r4 = r11.zzm
            int r4 = r4 + r2
            r11.zzm = r4
        L55:
            com.google.android.gms.internal.ads.zzadp r4 = r11.zzp
            int r12 = r4.zzf(r12, r0, r2)
            if (r12 != r1) goto L5e
            return r1
        L5e:
            int r0 = r11.zzj
            int r0 = r0 - r12
            r11.zzj = r0
            if (r0 <= 0) goto L66
            return r3
        L66:
            com.google.android.gms.internal.ads.zzadp r4 = r11.zzp
            long r5 = r11.zzh
            r7 = 1
            int r8 = r11.zzi
            r9 = 0
            r10 = 0
            r4.zzs(r5, r7, r8, r9, r10)
            long r0 = r11.zzh
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.zzh = r0
            return r3
        L7a:
            java.lang.String r12 = "WB"
            java.lang.String r3 = "NB"
            if (r2 == r4) goto L81
            r12 = r3
        L81:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> Lb5
            r2.<init>()     // Catch: java.io.EOFException -> Lb5
            java.lang.String r3 = "Illegal AMR "
            r2.append(r3)     // Catch: java.io.EOFException -> Lb5
            r2.append(r12)     // Catch: java.io.EOFException -> Lb5
            java.lang.String r12 = " frame type "
            r2.append(r12)     // Catch: java.io.EOFException -> Lb5
            r2.append(r0)     // Catch: java.io.EOFException -> Lb5
            java.lang.String r12 = r2.toString()     // Catch: java.io.EOFException -> Lb5
            com.google.android.gms.internal.ads.zzbo r12 = com.google.android.gms.internal.ads.zzbo.zza(r12, r5)     // Catch: java.io.EOFException -> Lb5
            throw r12     // Catch: java.io.EOFException -> Lb5
        L9f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> Lb5
            r12.<init>()     // Catch: java.io.EOFException -> Lb5
            java.lang.String r2 = "Invalid padding bits for frame header "
            r12.append(r2)     // Catch: java.io.EOFException -> Lb5
            r12.append(r0)     // Catch: java.io.EOFException -> Lb5
            java.lang.String r12 = r12.toString()     // Catch: java.io.EOFException -> Lb5
            com.google.android.gms.internal.ads.zzbo r12 = com.google.android.gms.internal.ads.zzbo.zza(r12, r5)     // Catch: java.io.EOFException -> Lb5
            throw r12     // Catch: java.io.EOFException -> Lb5
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadw.zza(com.google.android.gms.internal.ads.zzacl):int");
    }

    private static boolean zzg(zzacl zzaclVar, byte[] bArr) throws IOException {
        zzaclVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzaby) zzaclVar).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzacl zzaclVar) throws IOException {
        byte[] bArr = zzc;
        if (zzg(zzaclVar, bArr)) {
            this.zzg = false;
            ((zzaby) zzaclVar).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzaclVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        ((zzaby) zzaclVar).zzo(bArr2.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        zzdi.zzb(this.zzp);
        int i10 = zzet.zza;
        if (zzaclVar.zzf() == 0 && !zzh(zzaclVar)) {
            throw zzbo.zza("Could not find AMR header.", null);
        }
        if (!this.zzr) {
            this.zzr = true;
            boolean z10 = this.zzg;
            String str = true != z10 ? MimeTypes.AUDIO_AMR_NB : MimeTypes.AUDIO_AMR_WB;
            int i11 = true != z10 ? 8000 : 16000;
            zzadp zzadpVar = this.zzp;
            zzad zzadVar = new zzad();
            zzadVar.zzX(str);
            zzadVar.zzP(zze);
            zzadVar.zzy(1);
            zzadVar.zzY(i11);
            zzadpVar.zzl(zzadVar.zzad());
        }
        int iZza = zza(zzaclVar);
        if (this.zzk) {
            return iZza;
        }
        zzadh zzadhVar = new zzadh(C.TIME_UNSET, 0L);
        this.zzq = zzadhVar;
        this.zzo.zzO(zzadhVar);
        this.zzk = true;
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzo = zzacnVar;
        this.zzp = zzacnVar.zzw(0, 1);
        zzacnVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        return zzh(zzaclVar);
    }

    public zzadw(int i10) {
        this.zzf = new byte[1];
        this.zzl = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}

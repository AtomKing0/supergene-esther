package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamb implements zzamf {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzej zzc = new zzej(new byte[7], 7);
    private final zzek zzd = new zzek(Arrays.copyOf(zza, 10));

    @Nullable
    private final String zze;
    private final int zzf;
    private String zzg;
    private zzadp zzh;
    private zzadp zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private zzadp zzv;
    private long zzw;

    public zzamb(boolean z10, @Nullable String str, int i10) {
        zzh();
        this.zzo = -1;
        this.zzp = -1;
        this.zzs = C.TIME_UNSET;
        this.zzu = C.TIME_UNSET;
        this.zzb = z10;
        this.zze = str;
        this.zzf = i10;
    }

    public static boolean zzf(int i10) {
        return (i10 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzn = false;
        zzh();
    }

    private final void zzh() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 256;
    }

    private final void zzi() {
        this.zzj = 3;
        this.zzk = 0;
    }

    private final void zzj(zzadp zzadpVar, long j10, int i10, int i11) {
        this.zzj = 4;
        this.zzk = i10;
        this.zzv = zzadpVar;
        this.zzw = j10;
        this.zzt = i11;
    }

    private final boolean zzk(zzek zzekVar, byte[] bArr, int i10) {
        int iMin = Math.min(zzekVar.zzb(), i10 - this.zzk);
        zzekVar.zzG(bArr, this.zzk, iMin);
        int i11 = this.zzk + iMin;
        this.zzk = i11;
        return i11 == i10;
    }

    private static final boolean zzl(byte b10, byte b11) {
        return zzf((b11 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzek zzekVar, byte[] bArr, int i10) {
        if (zzekVar.zzb() < i10) {
            return false;
        }
        zzekVar.zzG(bArr, 0, i10);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x026e, code lost:
    
        r16.zzj = 1;
        r16.zzk = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0274, code lost:
    
        zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0277, code lost:
    
        r17.zzK(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x025b, code lost:
    
        r16.zzq = (r11 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0263, code lost:
    
        if (1 == ((r11 & 1) ^ 1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0265, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0267, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0268, code lost:
    
        r16.zzm = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x026c, code lost:
    
        if (r16.zzn != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025b A[EDGE_INSN: B:143:0x025b->B:94:0x025b BREAK  A[LOOP:1: B:48:0x01a9->B:168:0x01a9], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0213  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r17) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 719
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamb.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzg = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 1);
        this.zzh = zzadpVarZzw;
        this.zzv = zzadpVarZzw;
        if (!this.zzb) {
            this.zzi = new zzacj();
            return;
        }
        zzansVar.zzc();
        zzadp zzadpVarZzw2 = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzi = zzadpVarZzw2;
        zzad zzadVar = new zzad();
        zzadVar.zzK(zzansVar.zzb());
        zzadVar.zzX(MimeTypes.APPLICATION_ID3);
        zzadpVarZzw2.zzl(zzadVar.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzu = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzu = C.TIME_UNSET;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
    }
}

package com.google.android.gms.internal.play_billing;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfg {
    private static final zzfg zza = new zzfg(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzfg(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzfg zzc() {
        return zza;
    }

    static zzfg zze(zzfg zzfgVar, zzfg zzfgVar2) {
        int i10 = zzfgVar.zzb + zzfgVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzfgVar.zzc, i10);
        System.arraycopy(zzfgVar2.zzc, 0, iArrCopyOf, zzfgVar.zzb, zzfgVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzfgVar.zzd, i10);
        System.arraycopy(zzfgVar2.zzd, 0, objArrCopyOf, zzfgVar.zzb, zzfgVar2.zzb);
        return new zzfg(i10, iArrCopyOf, objArrCopyOf, true);
    }

    static zzfg zzf() {
        return new zzfg(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        int i10 = this.zzb;
        if (i10 == zzfgVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzfgVar.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzfgVar.zzd;
                    int i12 = this.zzb;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (objArr[i13].equals(objArr2[i13])) {
                        }
                    }
                    return true;
                }
                if (iArr[i11] != iArr2[i11]) {
                    break;
                }
                i11++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = i10 + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = ((i11 * 31) + i12) * 31;
        Object[] objArr = this.zzd;
        int i15 = this.zzb;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public final int zza() {
        int iZzw;
        int iZzx;
        int iZzw2;
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 == 1) {
                    ((Long) this.zzd[i12]).longValue();
                    iZzw2 = zzby.zzw(i14 << 3) + 8;
                } else if (i15 == 2) {
                    int i16 = i14 << 3;
                    zzbq zzbqVar = (zzbq) this.zzd[i12];
                    int iZzw3 = zzby.zzw(i16);
                    int iZzd = zzbqVar.zzd();
                    iZzw2 = iZzw3 + zzby.zzw(iZzd) + iZzd;
                } else if (i15 == 3) {
                    int iZzw4 = zzby.zzw(i14 << 3);
                    iZzw = iZzw4 + iZzw4;
                    iZzx = ((zzfg) this.zzd[i12]).zza();
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException(zzdc.zza());
                    }
                    ((Integer) this.zzd[i12]).intValue();
                    iZzw2 = zzby.zzw(i14 << 3) + 4;
                }
                i11 += iZzw2;
            } else {
                int i17 = i14 << 3;
                long jLongValue = ((Long) this.zzd[i12]).longValue();
                iZzw = zzby.zzw(i17);
                iZzx = zzby.zzx(jLongValue);
            }
            iZzw2 = iZzw + iZzx;
            i11 += iZzw2;
        }
        this.zze = i11;
        return i11;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int iZzw = 0;
        for (int i11 = 0; i11 < this.zzb; i11++) {
            int i12 = this.zzc[i11] >>> 3;
            zzbq zzbqVar = (zzbq) this.zzd[i11];
            int iZzw2 = zzby.zzw(8);
            int iZzw3 = zzby.zzw(16) + zzby.zzw(i12);
            int iZzw4 = zzby.zzw(24);
            int iZzd = zzbqVar.zzd();
            iZzw += iZzw2 + iZzw2 + iZzw3 + iZzw4 + zzby.zzw(iZzd) + iZzd;
        }
        this.zze = iZzw;
        return iZzw;
    }

    final zzfg zzd(zzfg zzfgVar) {
        if (zzfgVar.equals(zza)) {
            return this;
        }
        zzg();
        int i10 = this.zzb + zzfgVar.zzb;
        zzm(i10);
        System.arraycopy(zzfgVar.zzc, 0, this.zzc, this.zzb, zzfgVar.zzb);
        System.arraycopy(zzfgVar.zzd, 0, this.zzd, this.zzb, zzfgVar.zzb);
        this.zzb = i10;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzee.zzb(sb, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    final void zzj(int i10, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    final void zzk(zzfx zzfxVar) throws IOException {
        for (int i10 = 0; i10 < this.zzb; i10++) {
            zzfxVar.zzw(this.zzc[i10] >>> 3, this.zzd[i10]);
        }
    }

    public final void zzl(zzfx zzfxVar) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    zzfxVar.zzt(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    zzfxVar.zzm(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    zzfxVar.zzd(i13, (zzbq) obj);
                } else if (i12 == 3) {
                    zzfxVar.zzF(i13);
                    ((zzfg) obj).zzl(zzfxVar);
                    zzfxVar.zzh(i13);
                } else {
                    if (i12 != 5) {
                        throw new RuntimeException(zzdc.zza());
                    }
                    zzfxVar.zzk(i13, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzfg() {
        this(0, new int[8], new Object[8], true);
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhad extends zzgwm {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgwm zzd;
    private final zzgwm zze;
    private final int zzf;
    private final int zzg;

    static zzgwm zzC(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        if (zzgwmVar2.zzd() == 0) {
            return zzgwmVar;
        }
        if (zzgwmVar.zzd() == 0) {
            return zzgwmVar2;
        }
        int iZzd = zzgwmVar.zzd() + zzgwmVar2.zzd();
        if (iZzd < 128) {
            return zzD(zzgwmVar, zzgwmVar2);
        }
        if (zzgwmVar instanceof zzhad) {
            zzhad zzhadVar = (zzhad) zzgwmVar;
            if (zzhadVar.zze.zzd() + zzgwmVar2.zzd() < 128) {
                return new zzhad(zzhadVar.zzd, zzD(zzhadVar.zze, zzgwmVar2));
            }
            if (zzhadVar.zzd.zzf() > zzhadVar.zze.zzf() && zzhadVar.zzg > zzgwmVar2.zzf()) {
                return new zzhad(zzhadVar.zzd, new zzhad(zzhadVar.zze, zzgwmVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgwmVar.zzf(), zzgwmVar2.zzf()) + 1) ? new zzhad(zzgwmVar, zzgwmVar2) : zzgzz.zza(new zzgzz(null), zzgwmVar, zzgwmVar2);
    }

    private static zzgwm zzD(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        int iZzd = zzgwmVar.zzd();
        int iZzd2 = zzgwmVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgwmVar.zzz(bArr, 0, 0, iZzd);
        zzgwmVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgwk(bArr);
    }

    static int zzc(int i10) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i10 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm)) {
            return false;
        }
        zzgwm zzgwmVar = (zzgwm) obj;
        if (this.zzc != zzgwmVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgwmVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzhaa zzhaaVar = null;
        zzhab zzhabVar = new zzhab(this, zzhaaVar);
        zzgwj zzgwjVarZza = zzhabVar.next();
        zzhab zzhabVar2 = new zzhab(zzgwmVar, zzhaaVar);
        zzgwj zzgwjVarZza2 = zzhabVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int iZzd = zzgwjVarZza.zzd() - i10;
            int iZzd2 = zzgwjVarZza2.zzd() - i11;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i10 == 0 ? zzgwjVarZza.zzg(zzgwjVarZza2, i11, iMin) : zzgwjVarZza2.zzg(zzgwjVarZza, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.zzc;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzgwjVarZza = zzhabVar.next();
                i10 = 0;
            } else {
                i10 += iMin;
                zzgwjVarZza = zzgwjVarZza;
            }
            if (iMin == iZzd2) {
                zzgwjVarZza2 = zzhabVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzgzx(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final byte zza(int i10) {
        zzgwm.zzy(i10, this.zzc);
        return zzb(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    final byte zzb(int i10) {
        int i11 = this.zzf;
        return i10 < i11 ? this.zzd.zzb(i10) : this.zze.zzb(i10 - i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final void zze(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.zzf;
        if (i13 <= i14) {
            this.zzd.zze(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.zze.zze(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.zzd.zze(bArr, i10, i11, i15);
            this.zze.zze(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final int zzi(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.zzf;
        if (i13 <= i14) {
            return this.zzd.zzi(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.zze.zzi(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.zze.zzi(this.zzd.zzi(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final int zzj(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.zzf;
        if (i13 <= i14) {
            return this.zzd.zzj(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.zze.zzj(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.zze.zzj(this.zzd.zzj(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgwm zzk(int i10, int i11) {
        int iZzq = zzgwm.zzq(i10, i11, this.zzc);
        if (iZzq == 0) {
            return zzgwm.zzb;
        }
        if (iZzq == this.zzc) {
            return this;
        }
        int i12 = this.zzf;
        if (i11 <= i12) {
            return this.zzd.zzk(i10, i11);
        }
        if (i10 >= i12) {
            return this.zze.zzk(i10 - i12, i11 - i12);
        }
        zzgwm zzgwmVar = this.zzd;
        return new zzhad(zzgwmVar.zzk(i10, zzgwmVar.zzd()), this.zze.zzk(0, i11 - this.zzf));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgww zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        Object[] objArr = 0;
        zzhab zzhabVar = new zzhab(this, null);
        while (zzhabVar.hasNext()) {
            arrayList.add(zzhabVar.next().zzn());
        }
        int i10 = zzgww.zzd;
        int i11 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i11 = byteBuffer.hasArray() ? i11 | 1 : byteBuffer.isDirect() ? i11 | 2 : i11 | 4;
        }
        return i11 == 2 ? new zzgwq(arrayList, iRemaining, true, objArr == true ? 1 : 0) : zzgww.zzG(new zzgyo(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    final void zzo(zzgwd zzgwdVar) throws IOException {
        this.zzd.zzo(zzgwdVar);
        this.zze.zzo(zzgwdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean zzp() {
        zzgwm zzgwmVar = this.zzd;
        zzgwm zzgwmVar2 = this.zze;
        return zzgwmVar2.zzj(zzgwmVar.zzj(0, 0, this.zzf), 0, zzgwmVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    /* JADX INFO: renamed from: zzs */
    public final zzgwh iterator() {
        return new zzgzx(this);
    }

    private zzhad(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        this.zzd = zzgwmVar;
        this.zze = zzgwmVar2;
        int iZzd = zzgwmVar.zzd();
        this.zzf = iZzd;
        this.zzc = iZzd + zzgwmVar2.zzd();
        this.zzg = Math.max(zzgwmVar.zzf(), zzgwmVar2.zzf()) + 1;
    }
}

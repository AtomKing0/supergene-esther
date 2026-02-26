package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzgwk extends zzgwj {
    protected final byte[] zza;

    zzgwk(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm) || zzd() != ((zzgwm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgwk)) {
            return obj.equals(this);
        }
        zzgwk zzgwkVar = (zzgwk) obj;
        int iZzr = zzr();
        int iZzr2 = zzgwkVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgwkVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public byte zza(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    byte zzb(int i10) {
        return this.zza[i10];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.zza, i10, bArr, i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    final boolean zzg(zzgwm zzgwmVar, int i10, int i11) {
        if (i11 > zzgwmVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i11 + zzd());
        }
        int i12 = i10 + i11;
        if (i12 > zzgwmVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + zzgwmVar.zzd());
        }
        if (!(zzgwmVar instanceof zzgwk)) {
            return zzgwmVar.zzk(i10, i12).equals(zzk(0, i11));
        }
        zzgwk zzgwkVar = (zzgwk) zzgwmVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgwkVar.zza;
        int iZzc = zzc() + i11;
        int iZzc2 = zzc();
        int iZzc3 = zzgwkVar.zzc() + i10;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final int zzi(int i10, int i11, int i12) {
        return zzgyl.zzb(i10, this.zza, zzc() + i11, i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final int zzj(int i10, int i11, int i12) {
        int iZzc = zzc() + i11;
        return zzhbe.zzf(i10, this.zza, iZzc, i12 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgwm zzk(int i10, int i11) {
        int iZzq = zzgwm.zzq(i10, i11, zzd());
        return iZzq == 0 ? zzgwm.zzb : new zzgwg(this.zza, zzc() + i10, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgww zzl() {
        return zzgww.zzH(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    final void zzo(zzgwd zzgwdVar) throws IOException {
        zzgwdVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean zzp() {
        int iZzc = zzc();
        return zzhbe.zzi(this.zza, iZzc, zzd() + iZzc);
    }
}

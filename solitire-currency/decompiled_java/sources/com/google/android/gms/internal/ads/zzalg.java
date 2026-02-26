package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.C;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalg implements zzaka {
    private final zzek zza = new zzek();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzalg(List list) {
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = C.SANS_SERIF_NAME;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzet.zzB(bArr, 43, bArr.length + (-43))) ? C.SERIF_NAME : str;
        int i10 = bArr[25] * 20;
        this.zzg = i10;
        boolean z10 = (bArr[0] & 32) != 0;
        this.zzb = z10;
        if (z10) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i10 >>> 8) | ((i10 & 255) << 24)), i12, i13, i14 | 33);
        }
    }

    private static void zzd(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            int i16 = i10 & 1;
            int i17 = i10 & 2;
            boolean z10 = true;
            if (i16 != 0) {
                if (i17 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                    z10 = false;
                }
            } else if (i17 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            } else {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            } else {
                if (i16 != 0 || z10) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i10, int i11, zzajz zzajzVar, zzdn zzdnVar) {
        String strZzA;
        int i12;
        int i13;
        int length;
        this.zza.zzI(bArr, i10 + i11);
        this.zza.zzK(i10);
        zzek zzekVar = this.zza;
        int i14 = 1;
        int i15 = 0;
        int i16 = 2;
        zzdi.zzd(zzekVar.zzb() >= 2);
        int iZzq = zzekVar.zzq();
        if (iZzq == 0) {
            strZzA = "";
        } else {
            int iZzd = zzekVar.zzd();
            Charset charsetZzB = zzekVar.zzB();
            int iZzd2 = zzekVar.zzd() - iZzd;
            if (charsetZzB == null) {
                charsetZzB = zzfuj.zzc;
            }
            strZzA = zzekVar.zzA(iZzq - iZzd2, charsetZzB);
        }
        if (strZzA.isEmpty()) {
            zzdnVar.zza(new zzajs(zzfxr.zzm(), C.TIME_UNSET, C.TIME_UNSET));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strZzA);
        zzd(spannableStringBuilder, this.zzc, 0, 0, spannableStringBuilder.length(), 16711680);
        zzc(spannableStringBuilder, this.zzd, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.zze;
        int length2 = spannableStringBuilder.length();
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fMax = this.zzf;
        while (true) {
            zzek zzekVar2 = this.zza;
            if (zzekVar2.zzb() < 8) {
                zzcz zzczVar = new zzcz();
                zzczVar.zzl(spannableStringBuilder);
                zzczVar.zze(fMax, 0);
                zzczVar.zzf(0);
                zzdnVar.zza(new zzajs(zzfxr.zzn(zzczVar.zzp()), C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
            int iZzd3 = zzekVar2.zzd();
            int iZzg = zzekVar2.zzg();
            int iZzg2 = this.zza.zzg();
            if (iZzg2 == 1937013100) {
                zzdi.zzd(this.zza.zzb() >= i16 ? i14 : i15);
                int iZzq2 = this.zza.zzq();
                int i17 = i15;
                while (i17 < iZzq2) {
                    zzek zzekVar3 = this.zza;
                    zzdi.zzd(zzekVar3.zzb() >= 12 ? i14 : i15);
                    int iZzq3 = zzekVar3.zzq();
                    int iZzq4 = zzekVar3.zzq();
                    zzekVar3.zzL(i16);
                    int iZzm = zzekVar3.zzm();
                    zzekVar3.zzL(i14);
                    int iZzg3 = zzekVar3.zzg();
                    if (iZzq4 > spannableStringBuilder.length()) {
                        int length3 = spannableStringBuilder.length();
                        StringBuilder sb = new StringBuilder();
                        i13 = iZzq2;
                        sb.append("Truncating styl end (");
                        sb.append(iZzq4);
                        sb.append(") to cueText.length() (");
                        sb.append(length3);
                        sb.append(").");
                        zzea.zzf("Tx3gParser", sb.toString());
                        length = spannableStringBuilder.length();
                    } else {
                        i13 = iZzq2;
                        length = iZzq4;
                    }
                    if (iZzq3 >= length) {
                        zzea.zzf("Tx3gParser", "Ignoring styl with start (" + iZzq3 + ") >= end (" + length + ").");
                    } else {
                        int i18 = length;
                        zzd(spannableStringBuilder, iZzm, this.zzc, iZzq3, i18, 0);
                        zzc(spannableStringBuilder, iZzg3, this.zzd, iZzq3, i18, 0);
                    }
                    i17++;
                    iZzq2 = i13;
                    i14 = 1;
                    i15 = 0;
                    i16 = 2;
                }
                i12 = i16;
            } else if (iZzg2 == 1952608120 && this.zzb) {
                i12 = 2;
                zzdi.zzd(this.zza.zzb() >= 2);
                fMax = Math.max(0.0f, Math.min(this.zza.zzq() / this.zzg, 0.95f));
            } else {
                i12 = 2;
            }
            this.zza.zzK(iZzd3 + iZzg);
            i16 = i12;
            i14 = 1;
            i15 = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}

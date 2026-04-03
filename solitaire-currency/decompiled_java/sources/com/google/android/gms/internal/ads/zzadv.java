package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadv {
    public static int zza(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i10 >>>= 1;
            i11++;
        }
        return i11;
    }

    @Nullable
    public static zzbk zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = (String) list.get(i10);
            int i11 = zzet.zza;
            String[] strArrSplit = str.split(v8.i.f15833b, 2);
            if (strArrSplit.length != 2) {
                zzea.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafj.zzb(new zzek(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e10) {
                    zzea.zzg("VorbisUtil", "Failed to parse vorbis picture", e10);
                }
            } else {
                arrayList.add(new zzaha(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbk(arrayList);
    }

    public static zzads zzc(zzek zzekVar, boolean z10, boolean z11) throws zzbo {
        if (z10) {
            zzd(3, zzekVar, false);
        }
        String strZzA = zzekVar.zzA((int) zzekVar.zzs(), zzfuj.zzc);
        int length = strZzA.length();
        long jZzs = zzekVar.zzs();
        String[] strArr = new String[(int) jZzs];
        int length2 = length + 15;
        for (int i10 = 0; i10 < jZzs; i10++) {
            String strZzA2 = zzekVar.zzA((int) zzekVar.zzs(), zzfuj.zzc);
            strArr[i10] = strZzA2;
            length2 = length2 + 4 + strZzA2.length();
        }
        if (z11 && (zzekVar.zzm() & 1) == 0) {
            throw zzbo.zza("framing bit expected to be set", null);
        }
        return new zzads(strZzA, strArr, length2 + 1);
    }

    public static boolean zzd(int i10, zzek zzekVar, boolean z10) throws zzbo {
        if (zzekVar.zzb() < 7) {
            if (z10) {
                return false;
            }
            throw zzbo.zza("too short header: " + zzekVar.zzb(), null);
        }
        if (zzekVar.zzm() != i10) {
            if (z10) {
                return false;
            }
            throw zzbo.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i10))), null);
        }
        if (zzekVar.zzm() == 118 && zzekVar.zzm() == 111 && zzekVar.zzm() == 114 && zzekVar.zzm() == 98 && zzekVar.zzm() == 105 && zzekVar.zzm() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw zzbo.zza("expected characters 'vorbis'", null);
    }
}

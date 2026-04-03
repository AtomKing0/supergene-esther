package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.extractor.WavUtil;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaoc {
    public static Pair zza(zzacl zzaclVar) throws IOException {
        zzaclVar.zzj();
        zzaob zzaobVarZzd = zzd(1684108385, zzaclVar, new zzek(8));
        ((zzaby) zzaclVar).zzo(8, false);
        return Pair.create(Long.valueOf(zzaclVar.zzf()), Long.valueOf(zzaobVarZzd.zzb));
    }

    public static zzaoa zzb(zzacl zzaclVar) throws IOException {
        byte[] bArr;
        zzek zzekVar = new zzek(16);
        zzaob zzaobVarZzd = zzd(WavUtil.FMT_FOURCC, zzaclVar, zzekVar);
        zzdi.zzf(zzaobVarZzd.zzb >= 16);
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(zzekVar.zzM(), 0, 16, false);
        zzekVar.zzK(0);
        int iZzk = zzekVar.zzk();
        int iZzk2 = zzekVar.zzk();
        int iZzj = zzekVar.zzj();
        int iZzj2 = zzekVar.zzj();
        int iZzk3 = zzekVar.zzk();
        int iZzk4 = zzekVar.zzk();
        int i10 = ((int) zzaobVarZzd.zzb) - 16;
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            zzabyVar.zzm(bArr2, 0, i10, false);
            bArr = bArr2;
        } else {
            bArr = zzet.zzf;
        }
        ((zzaby) zzaclVar).zzo((int) (zzaclVar.zze() - zzaclVar.zzf()), false);
        return new zzaoa(iZzk, iZzk2, iZzj, iZzj2, iZzk3, iZzk4, bArr);
    }

    public static boolean zzc(zzacl zzaclVar) throws IOException {
        zzek zzekVar = new zzek(8);
        int i10 = zzaob.zza(zzaclVar, zzekVar).zza;
        if (i10 != 1380533830 && i10 != 1380333108) {
            return false;
        }
        ((zzaby) zzaclVar).zzm(zzekVar.zzM(), 0, 4, false);
        zzekVar.zzK(0);
        int iZzg = zzekVar.zzg();
        if (iZzg == 1463899717) {
            return true;
        }
        zzea.zzc("WavHeaderReader", "Unsupported form type: " + iZzg);
        return false;
    }

    private static zzaob zzd(int i10, zzacl zzaclVar, zzek zzekVar) throws IOException {
        zzaob zzaobVarZza = zzaob.zza(zzaclVar, zzekVar);
        while (true) {
            int i11 = zzaobVarZza.zza;
            if (i11 == i10) {
                return zzaobVarZza;
            }
            zzea.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i11);
            long j10 = zzaobVarZza.zzb;
            long j11 = j10 & 1;
            long j12 = j10 + 8;
            if (j11 != 0) {
                j12++;
            }
            if (j12 > 2147483647L) {
                throw zzbo.zzc("Chunk is too large (~2GB+) to skip; id: " + zzaobVarZza.zza);
            }
            ((zzaby) zzaclVar).zzo((int) j12, false);
            zzaobVarZza = zzaob.zza(zzaclVar, zzekVar);
        }
    }
}

package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanj implements zzabt {
    private final zzer zza;
    private final zzek zzb = new zzek();
    private final int zzc;

    public zzanj(int i10, zzer zzerVar, int i11) {
        this.zzc = i10;
        this.zza = zzerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final zzabs zza(zzacl zzaclVar, long j10) throws IOException {
        int iZza;
        int iZza2;
        long jZzf = zzaclVar.zzf();
        int iMin = (int) Math.min(112800L, zzaclVar.zzd() - jZzf);
        this.zzb.zzH(iMin);
        ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin, false);
        zzek zzekVar = this.zzb;
        int iZze = zzekVar.zze();
        long j11 = -1;
        long j12 = -9223372036854775807L;
        long j13 = -1;
        while (zzekVar.zzb() >= 188 && (iZza2 = (iZza = zzanu.zza(zzekVar.zzM(), zzekVar.zzd(), iZze)) + TsExtractor.TS_PACKET_SIZE) <= iZze) {
            long jZzb = zzanu.zzb(zzekVar, iZza, this.zzc);
            if (jZzb != C.TIME_UNSET) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j10) {
                    j13 = iZza;
                    if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jZzb2 <= j10) {
                        j12 = jZzb2;
                    }
                } else if (j12 == C.TIME_UNSET) {
                    return zzabs.zzd(jZzb2, jZzf);
                }
                return zzabs.zze(jZzf + j13);
            }
            zzekVar.zzK(iZza2);
            j11 = iZza2;
        }
        return j12 != C.TIME_UNSET ? zzabs.zzf(j12, jZzf + j11) : zzabs.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final void zzb() {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}

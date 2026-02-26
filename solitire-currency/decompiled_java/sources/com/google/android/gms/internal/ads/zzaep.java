package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaep extends zzaet {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaep(zzadp zzadpVar) {
        super(zzadpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zza(zzek zzekVar) throws zzaes {
        if (this.zzc) {
            zzekVar.zzL(1);
        } else {
            int iZzm = zzekVar.zzm();
            int i10 = iZzm >> 4;
            this.zze = i10;
            if (i10 == 2) {
                int i11 = zzb[(iZzm >> 2) & 3];
                zzad zzadVar = new zzad();
                zzadVar.zzX(MimeTypes.AUDIO_MPEG);
                zzadVar.zzy(1);
                zzadVar.zzY(i11);
                this.zza.zzl(zzadVar.zzad());
                this.zzd = true;
            } else if (i10 == 7 || i10 == 8) {
                zzad zzadVar2 = new zzad();
                zzadVar2.zzX(i10 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW);
                zzadVar2.zzy(1);
                zzadVar2.zzY(8000);
                this.zza.zzl(zzadVar2.zzad());
                this.zzd = true;
            } else if (i10 != 10) {
                throw new zzaes("Audio format not supported: " + i10);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zzb(zzek zzekVar, long j10) throws zzbo {
        if (this.zze == 2) {
            int iZzb = zzekVar.zzb();
            this.zza.zzq(zzekVar, iZzb);
            this.zza.zzs(j10, 1, iZzb, 0, null);
            return true;
        }
        int iZzm = zzekVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZzb2 = zzekVar.zzb();
            this.zza.zzq(zzekVar, iZzb2);
            this.zza.zzs(j10, 1, iZzb2, 0, null);
            return true;
        }
        int iZzb3 = zzekVar.zzb();
        byte[] bArr = new byte[iZzb3];
        zzekVar.zzG(bArr, 0, iZzb3);
        zzabf zzabfVarZza = zzabg.zza(bArr);
        zzad zzadVar = new zzad();
        zzadVar.zzX(MimeTypes.AUDIO_AAC);
        zzadVar.zzz(zzabfVarZza.zzc);
        zzadVar.zzy(zzabfVarZza.zzb);
        zzadVar.zzY(zzabfVarZza.zza);
        zzadVar.zzL(Collections.singletonList(bArr));
        this.zza.zzl(zzadVar.zzad());
        this.zzd = true;
        return false;
    }
}

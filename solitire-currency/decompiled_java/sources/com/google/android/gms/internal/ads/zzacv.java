package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.OpusUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacv {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;

    @Nullable
    public final zzacu zzk;

    @Nullable
    private final zzbk zzl;

    private zzacv(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, @Nullable zzacu zzacuVar, @Nullable zzbk zzbkVar) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = zzi(i14);
        this.zzg = i15;
        this.zzh = i16;
        this.zzi = zzh(i16);
        this.zzj = j10;
        this.zzk = zzacuVar;
        this.zzl = zzbkVar;
    }

    private static int zzh(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 != 20) {
            return i10 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.SAMPLE_RATE /* 48000 */:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND /* 192000 */:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j10 = this.zzj;
        return j10 == 0 ? C.TIME_UNSET : (j10 * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j10) {
        return Math.max(0L, Math.min((j10 * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzaf zzc(byte[] bArr, @Nullable zzbk zzbkVar) {
        bArr[4] = -128;
        zzbk zzbkVarZzd = zzd(zzbkVar);
        zzad zzadVar = new zzad();
        zzadVar.zzX(MimeTypes.AUDIO_FLAC);
        int i10 = this.zzd;
        if (i10 <= 0) {
            i10 = -1;
        }
        zzadVar.zzP(i10);
        zzadVar.zzy(this.zzg);
        zzadVar.zzY(this.zze);
        zzadVar.zzR(zzet.zzl(this.zzh));
        zzadVar.zzL(Collections.singletonList(bArr));
        zzadVar.zzQ(zzbkVarZzd);
        return zzadVar.zzad();
    }

    @Nullable
    public final zzbk zzd(@Nullable zzbk zzbkVar) {
        zzbk zzbkVar2 = this.zzl;
        return zzbkVar2 == null ? zzbkVar : zzbkVar2.zzd(zzbkVar);
    }

    public final zzacv zze(List list) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbk(list)));
    }

    public final zzacv zzf(@Nullable zzacu zzacuVar) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzacuVar, this.zzl);
    }

    public final zzacv zzg(List list) {
        return new zzacv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzadv.zzb(list)));
    }

    public zzacv(byte[] bArr, int i10) {
        zzej zzejVar = new zzej(bArr, bArr.length);
        zzejVar.zzl(i10 * 8);
        this.zza = zzejVar.zzd(16);
        this.zzb = zzejVar.zzd(16);
        this.zzc = zzejVar.zzd(24);
        this.zzd = zzejVar.zzd(24);
        int iZzd = zzejVar.zzd(20);
        this.zze = iZzd;
        this.zzf = zzi(iZzd);
        this.zzg = zzejVar.zzd(3) + 1;
        int iZzd2 = zzejVar.zzd(5) + 1;
        this.zzh = iZzd2;
        this.zzi = zzh(iZzd2);
        this.zzj = zzejVar.zze(36);
        this.zzk = null;
        this.zzl = null;
    }
}

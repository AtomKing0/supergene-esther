package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.PlaybackException;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(31)
public final class zznv implements zzlq, zznw {
    private final Context zza;
    private final zznx zzb;
    private final PlaybackSession zzc;

    @Nullable
    private String zzi;

    @Nullable
    private PlaybackMetrics.Builder zzj;
    private int zzk;

    @Nullable
    private zzbp zzn;

    @Nullable
    private zznu zzo;

    @Nullable
    private zznu zzp;

    @Nullable
    private zznu zzq;

    @Nullable
    private zzaf zzr;

    @Nullable
    private zzaf zzs;

    @Nullable
    private zzaf zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;
    private final zzcb zze = new zzcb();
    private final zzca zzf = new zzca();
    private final HashMap zzh = new HashMap();
    private final HashMap zzg = new HashMap();
    private final long zzd = SystemClock.elapsedRealtime();
    private int zzl = 0;
    private int zzm = 0;

    private zznv(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zznt zzntVar = new zznt(zznt.zza);
        this.zzb = zzntVar;
        zzntVar.zzh(this);
    }

    @Nullable
    public static zznv zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zznv(context, mediaMetricsManager.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    private static int zzr(int i10) {
        switch (zzet.zzj(i10)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                return 25;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l10 = (Long) this.zzg.get(this.zzi);
            this.zzj.setNetworkTransferDurationMillis(l10 == null ? 0L : l10.longValue());
            Long l11 = (Long) this.zzh.get(this.zzi);
            this.zzj.setNetworkBytesRead(l11 == null ? 0L : l11.longValue());
            this.zzj.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j10, @Nullable zzaf zzafVar, int i10) {
        if (zzet.zzG(this.zzs, zzafVar)) {
            return;
        }
        int i11 = this.zzs == null ? 1 : 0;
        this.zzs = zzafVar;
        zzx(0, j10, zzafVar, i11);
    }

    private final void zzu(long j10, @Nullable zzaf zzafVar, int i10) {
        if (zzet.zzG(this.zzt, zzafVar)) {
            return;
        }
        int i11 = this.zzt == null ? 1 : 0;
        this.zzt = zzafVar;
        zzx(2, j10, zzafVar, i11);
    }

    private final void zzv(zzcc zzccVar, @Nullable zzui zzuiVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzuiVar == null || (iZza = zzccVar.zza(zzuiVar.zza)) == -1) {
            return;
        }
        int i10 = 0;
        zzccVar.zzd(iZza, this.zzf, false);
        zzccVar.zze(this.zzf.zzc, this.zze, 0L);
        zzax zzaxVar = this.zze.zzd.zzb;
        if (zzaxVar != null) {
            int iZzn = zzet.zzn(zzaxVar.zza);
            i10 = iZzn != 0 ? iZzn != 1 ? iZzn != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i10);
        zzcb zzcbVar = this.zze;
        long j10 = zzcbVar.zzm;
        if (j10 != C.TIME_UNSET && !zzcbVar.zzk && !zzcbVar.zzi && !zzcbVar.zzb()) {
            builder.setMediaDurationMillis(zzet.zzu(j10));
        }
        builder.setPlaybackType(true != this.zze.zzb() ? 1 : 2);
        this.zzz = true;
    }

    private final void zzw(long j10, @Nullable zzaf zzafVar, int i10) {
        if (zzet.zzG(this.zzr, zzafVar)) {
            return;
        }
        int i11 = this.zzr == null ? 1 : 0;
        this.zzr = zzafVar;
        zzx(1, j10, zzafVar, i11);
    }

    private final void zzx(int i10, long j10, @Nullable zzaf zzafVar, int i11) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i10).setTimeSinceCreatedMillis(j10 - this.zzd);
        if (zzafVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i11 != 1 ? 1 : 2);
            String str = zzafVar.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzafVar.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzafVar.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i12 = zzafVar.zzi;
            if (i12 != -1) {
                timeSinceCreatedMillis.setBitrate(i12);
            }
            int i13 = zzafVar.zzr;
            if (i13 != -1) {
                timeSinceCreatedMillis.setWidth(i13);
            }
            int i14 = zzafVar.zzs;
            if (i14 != -1) {
                timeSinceCreatedMillis.setHeight(i14);
            }
            int i15 = zzafVar.zzz;
            if (i15 != -1) {
                timeSinceCreatedMillis.setChannelCount(i15);
            }
            int i16 = zzafVar.zzA;
            if (i16 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i16);
            }
            String str4 = zzafVar.zzd;
            if (str4 != null) {
                int i17 = zzet.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f10 = zzafVar.zzt;
            if (f10 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f10);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private final boolean zzy(@Nullable zznu zznuVar) {
        if (zznuVar != null) {
            return zznuVar.zzc.equals(this.zzb.zze());
        }
        return false;
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zzc(zzlo zzloVar, String str) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName(MediaLibraryInfo.TAG).setPlayerVersion("1.4.0-alpha02");
            zzv(zzloVar.zzb, zzloVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zzd(zzlo zzloVar, String str, boolean z10) {
        zzui zzuiVar = zzloVar.zzd;
        if ((zzuiVar == null || !zzuiVar.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzf(zzlo zzloVar, int i10, long j10, long j11) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar != null) {
            zznx zznxVar = this.zzb;
            zzcc zzccVar = zzloVar.zzb;
            HashMap map = this.zzh;
            String strZzf = zznxVar.zzf(zzccVar, zzuiVar);
            Long l10 = (Long) map.get(strZzf);
            Long l11 = (Long) this.zzg.get(strZzf);
            this.zzh.put(strZzf, Long.valueOf((l10 == null ? 0L : l10.longValue()) + j10));
            this.zzg.put(strZzf, Long.valueOf((l11 != null ? l11.longValue() : 0L) + ((long) i10)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzg(zzlo zzloVar, zzue zzueVar) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null) {
            return;
        }
        zzaf zzafVar = zzueVar.zzb;
        zzafVar.getClass();
        zznu zznuVar = new zznu(zzafVar, 0, this.zzb.zzf(zzloVar.zzb, zzuiVar));
        int i10 = zzueVar.zza;
        if (i10 != 0) {
            if (i10 == 1) {
                this.zzp = zznuVar;
                return;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.zzq = zznuVar;
                return;
            }
        }
        this.zzo = zznuVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029d  */
    @Override // com.google.android.gms.internal.ads.zzlq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(com.google.android.gms.internal.ads.zzbw r19, com.google.android.gms.internal.ads.zzlp r20) {
        /*
            Method dump skipped, instruction units count: 990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zzi(com.google.android.gms.internal.ads.zzbw, com.google.android.gms.internal.ads.zzlp):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzl(zzlo zzloVar, zzbp zzbpVar) {
        this.zzn = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzm(zzlo zzloVar, zzbv zzbvVar, zzbv zzbvVar2, int i10) {
        if (i10 == 1) {
            this.zzu = true;
            i10 = 1;
        }
        this.zzk = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzo(zzlo zzloVar, zzhn zzhnVar) {
        this.zzw += zzhnVar.zzg;
        this.zzx += zzhnVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzq(zzlo zzloVar, zzcp zzcpVar) {
        zznu zznuVar = this.zzo;
        if (zznuVar != null) {
            zzaf zzafVar = zznuVar.zza;
            if (zzafVar.zzs == -1) {
                zzad zzadVarZzb = zzafVar.zzb();
                zzadVarZzb.zzac(zzcpVar.zzb);
                zzadVarZzb.zzI(zzcpVar.zzc);
                this.zzo = new zznu(zzadVarZzb.zzad(), 0, zznuVar.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzk(zzlo zzloVar, int i10) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zze(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzh(zzlo zzloVar, int i10, long j10) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzn(zzlo zzloVar, Object obj, long j10) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzp(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzj(zzlo zzloVar, zztz zztzVar, zzue zzueVar, IOException iOException, boolean z10) {
    }
}

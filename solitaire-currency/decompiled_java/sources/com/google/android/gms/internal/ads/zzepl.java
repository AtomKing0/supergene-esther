package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.media3.exoplayer.offline.DownloadService;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepl implements zzevo {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final long zze;
    private final zzcto zzf;
    private final zzfgo zzg;
    private final zzffg zzh;
    private final com.google.android.gms.ads.internal.util.zzg zzi = com.google.android.gms.ads.internal.zzu.zzo().zzi();
    private final zzdsf zzj;
    private final zzcub zzk;

    public zzepl(Context context, String str, String str2, zzcto zzctoVar, zzfgo zzfgoVar, zzffg zzffgVar, zzdsf zzdsfVar, zzcub zzcubVar, long j10) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzctoVar;
        this.zzg = zzfgoVar;
        this.zzh = zzffgVar;
        this.zzj = zzdsfVar;
        this.zzk = zzcubVar;
        this.zze = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        final Bundle bundle = new Bundle();
        this.zzj.zzb().put("seq_num", this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            this.zzj.zzc("tsacc", String.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - this.zze));
            zzdsf zzdsfVar = this.zzj;
            com.google.android.gms.ads.internal.zzu.zzp();
            zzdsfVar.zzc(DownloadService.KEY_FOREGROUND, true != com.google.android.gms.ads.internal.util.zzt.zzG(this.zza) ? "1" : "0");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeX)).booleanValue()) {
            this.zzf.zzk(this.zzh.zzd);
            bundle.putAll(this.zzg.zzb());
        }
        return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzepk
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzc(bundle, (Bundle) obj);
            }
        });
    }

    final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeX)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeW)).booleanValue()) {
                synchronized (zzb) {
                    this.zzf.zzk(this.zzh.zzd);
                    bundle2.putBundle("quality_signals", this.zzg.zzb());
                }
            } else {
                this.zzf.zzk(this.zzh.zzd);
                bundle2.putBundle("quality_signals", this.zzg.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!this.zzi.zzS()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !this.zzi.zzS());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeY)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzu.zzp();
                bundle2.putString("_app_id", com.google.android.gms.ads.internal.util.zzt.zzp(this.zza));
            } catch (RemoteException | RuntimeException e10) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AppStatsSignal_AppId");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeZ)).booleanValue() && this.zzh.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzk.zzb(this.zzh.zzf));
            bundle3.putInt("pcc", this.zzk.zza(this.zzh.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziQ)).booleanValue() || com.google.android.gms.ads.internal.zzu.zzo().zza() <= 0) {
            return;
        }
        bundle2.putInt("nrwv", com.google.android.gms.ads.internal.zzu.zzo().zza());
    }
}

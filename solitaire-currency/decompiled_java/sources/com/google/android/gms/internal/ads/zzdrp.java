package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.ironsource.w8;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrp implements zzdbl, com.google.android.gms.ads.internal.client.zza, zzcxk, zzcwu {
    private final Context zza;
    private final zzffy zzb;
    private final zzdsk zzc;
    private final zzfex zzd;
    private final zzfel zze;
    private final zzedh zzf;
    private final String zzg;

    @Nullable
    private Boolean zzh;
    private final boolean zzi = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgg)).booleanValue();

    public zzdrp(Context context, zzffy zzffyVar, zzdsk zzdskVar, zzfex zzfexVar, zzfel zzfelVar, zzedh zzedhVar, String str) {
        this.zza = context;
        this.zzb = zzffyVar;
        this.zzc = zzdskVar;
        this.zzd = zzfexVar;
        this.zze = zzfelVar;
        this.zzf = zzedhVar;
        this.zzg = str;
    }

    private final zzdsj zzd(String str) {
        zzdsj zzdsjVarZza = this.zzc.zza();
        zzdsjVarZza.zzd(this.zzd.zzb.zzb);
        zzdsjVarZza.zzc(this.zze);
        zzdsjVarZza.zzb("action", str);
        zzdsjVarZza.zzb("ad_format", this.zzg.toUpperCase(Locale.ROOT));
        if (!this.zze.zzt.isEmpty()) {
            zzdsjVarZza.zzb("ancn", (String) this.zze.zzt.get(0));
        }
        if (this.zze.zzai) {
            zzdsjVarZza.zzb("device_connectivity", true != com.google.android.gms.ads.internal.zzu.zzo().zzA(this.zza) ? "offline" : "online");
            zzdsjVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()));
            zzdsjVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            boolean z10 = com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzf(this.zzd.zza.zza) != 1;
            zzdsjVarZza.zzb("scar", String.valueOf(z10));
            if (z10) {
                com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzd.zza.zza.zzd;
                zzdsjVarZza.zzb("ragent", zzlVar.zzp);
                zzdsjVarZza.zzb("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzc(zzlVar)));
            }
        }
        return zzdsjVarZza;
    }

    private final void zze(zzdsj zzdsjVar) {
        if (!this.zze.zzai) {
            zzdsjVar.zzf();
            return;
        }
        this.zzf.zzd(new zzedj(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdsjVar.zze(), 2));
    }

    private final boolean zzf() {
        String strZzp;
        if (this.zzh == null) {
            synchronized (this) {
                if (this.zzh == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbj);
                    com.google.android.gms.ads.internal.zzu.zzp();
                    try {
                        strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
                    } catch (RemoteException unused) {
                        strZzp = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzp != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzp);
                        } catch (RuntimeException e10) {
                            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzh = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zze.zzai) {
            zze(zzd(w8.f16021d));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "adapter");
            int i10 = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i10 = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i10 >= 0) {
                zzdsjVarZzd.zzb("arec", String.valueOf(i10));
            }
            String strZza = this.zzb.zza(str);
            if (strZza != null) {
                zzdsjVarZzd.zzb("areec", strZza);
            }
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzb() {
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "blocked");
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzc(zzdgw zzdgwVar) {
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgwVar.getMessage())) {
                zzdsjVarZzd.zzb("msg", zzdgwVar.getMessage());
            }
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbl
    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbl
    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (zzf() || this.zze.zzai) {
            zze(zzd("impression"));
        }
    }
}

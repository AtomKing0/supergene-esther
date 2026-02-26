package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdgy implements zzcye, com.google.android.gms.ads.internal.overlay.zzp, zzcxk {

    @Nullable
    @VisibleForTesting
    zzeeo zza;
    private final Context zzb;

    @Nullable
    private final zzcej zzc;
    private final zzfel zzd;
    private final VersionInfoParcel zze;
    private final zzbbc.zza.EnumC0191zza zzf;
    private final zzeem zzg;

    public zzdgy(Context context, @Nullable zzcej zzcejVar, zzfel zzfelVar, VersionInfoParcel versionInfoParcel, zzbbc.zza.EnumC0191zza enumC0191zza, zzeem zzeemVar) {
        this.zzb = context;
        this.zzc = zzcejVar;
        this.zzd = zzfelVar;
        this.zze = versionInfoParcel;
        this.zzf = enumC0191zza;
        this.zzg = zzeemVar;
    }

    private final boolean zzg() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && this.zzg.zzd();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdr() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeG)).booleanValue() || this.zzc == null) {
            return;
        }
        if (this.zza != null || zzg()) {
            if (this.zza != null) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzg.zzb();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdu(int i10) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (zzg()) {
            this.zzg.zzb();
            return;
        }
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeG)).booleanValue()) {
            this.zzc.zzd("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzeel zzeelVar;
        zzeek zzeekVar;
        zzbbc.zza.EnumC0191zza enumC0191zza;
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeJ)).booleanValue() || (enumC0191zza = this.zzf) == zzbbc.zza.EnumC0191zza.REWARD_BASED_VIDEO_AD || enumC0191zza == zzbbc.zza.EnumC0191zza.INTERSTITIAL || enumC0191zza == zzbbc.zza.EnumC0191zza.APP_OPEN) && this.zzd.zzT && this.zzc != null) {
            if (com.google.android.gms.ads.internal.zzu.zzA().zzl(this.zzb)) {
                if (zzg()) {
                    this.zzg.zzc();
                    return;
                }
                VersionInfoParcel versionInfoParcel = this.zze;
                String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
                zzffj zzffjVar = this.zzd.zzV;
                String strZza = zzffjVar.zza();
                if (zzffjVar.zzc() == 1) {
                    zzeekVar = zzeek.VIDEO;
                    zzeelVar = zzeel.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzeelVar = this.zzd.zzY == 2 ? zzeel.UNSPECIFIED : zzeel.BEGIN_TO_RENDER;
                    zzeekVar = zzeek.HTML_DISPLAY;
                }
                zzeeo zzeeoVarZza = com.google.android.gms.ads.internal.zzu.zzA().zza(str, this.zzc.zzG(), "", "javascript", strZza, zzeelVar, zzeekVar, this.zzd.zzal);
                this.zza = zzeeoVarZza;
                Object obj = this.zzc;
                if (zzeeoVarZza != null) {
                    zzflq zzflqVarZza = zzeeoVarZza.zza();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeB)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzu.zzA().zzj(zzflqVarZza, this.zzc.zzG());
                        Iterator it = this.zzc.zzV().iterator();
                        while (it.hasNext()) {
                            com.google.android.gms.ads.internal.zzu.zzA().zzg(zzflqVarZza, (View) it.next());
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzu.zzA().zzj(zzflqVarZza, (View) obj);
                    }
                    this.zzc.zzat(this.zza);
                    com.google.android.gms.ads.internal.zzu.zzA().zzk(zzflqVarZza);
                    this.zzc.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdH() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdt() {
    }
}

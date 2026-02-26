package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrh implements zzcye, zzcxk {
    private final Context zza;

    @Nullable
    private final zzcej zzb;
    private final zzfel zzc;
    private final VersionInfoParcel zzd;

    @Nullable
    private zzeeo zze;
    private boolean zzf;
    private final zzeem zzg;

    public zzcrh(Context context, @Nullable zzcej zzcejVar, zzfel zzfelVar, VersionInfoParcel versionInfoParcel, zzeem zzeemVar) {
        this.zza = context;
        this.zzb = zzcejVar;
        this.zzc = zzfelVar;
        this.zzd = versionInfoParcel;
        this.zzg = zzeemVar;
    }

    private final synchronized void zza() {
        zzeel zzeelVar;
        zzeek zzeekVar;
        if (this.zzc.zzT && this.zzb != null) {
            if (com.google.android.gms.ads.internal.zzu.zzA().zzl(this.zza)) {
                VersionInfoParcel versionInfoParcel = this.zzd;
                String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
                zzffj zzffjVar = this.zzc.zzV;
                String strZza = zzffjVar.zza();
                if (zzffjVar.zzc() == 1) {
                    zzeekVar = zzeek.VIDEO;
                    zzeelVar = zzeel.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzfel zzfelVar = this.zzc;
                    zzeek zzeekVar2 = zzeek.HTML_DISPLAY;
                    zzeelVar = zzfelVar.zze == 1 ? zzeel.ONE_PIXEL : zzeel.BEGIN_TO_RENDER;
                    zzeekVar = zzeekVar2;
                }
                zzeeo zzeeoVarZza = com.google.android.gms.ads.internal.zzu.zzA().zza(str, this.zzb.zzG(), "", "javascript", strZza, zzeelVar, zzeekVar, this.zzc.zzal);
                this.zze = zzeeoVarZza;
                Object obj = this.zzb;
                if (zzeeoVarZza != null) {
                    zzflq zzflqVarZza = zzeeoVarZza.zza();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeB)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzu.zzA().zzj(zzflqVarZza, this.zzb.zzG());
                        Iterator it = this.zzb.zzV().iterator();
                        while (it.hasNext()) {
                            com.google.android.gms.ads.internal.zzu.zzA().zzg(zzflqVarZza, (View) it.next());
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzu.zzA().zzj(zzflqVarZza, (View) obj);
                    }
                    this.zzb.zzat(this.zze);
                    com.google.android.gms.ads.internal.zzu.zzA().zzk(zzflqVarZza);
                    this.zzf = true;
                    this.zzb.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    private final boolean zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && this.zzg.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final synchronized void zzr() {
        zzcej zzcejVar;
        if (zzb()) {
            this.zzg.zzb();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzcejVar = this.zzb) == null) {
            return;
        }
        zzcejVar.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final synchronized void zzs() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}

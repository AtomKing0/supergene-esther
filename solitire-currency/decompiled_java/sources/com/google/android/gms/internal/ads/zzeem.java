package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeem {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfel zzc;

    @Nullable
    private final zzcej zzd;

    @Nullable
    private zzfmb zze;

    zzeem(Context context, VersionInfoParcel versionInfoParcel, zzfel zzfelVar, @Nullable zzcej zzcejVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfelVar;
        this.zzd = zzcejVar;
    }

    public final synchronized void zza(View view) {
        zzfmb zzfmbVar = this.zze;
        if (zzfmbVar != null) {
            com.google.android.gms.ads.internal.zzu.zzA().zzh(zzfmbVar, view);
        }
    }

    public final synchronized void zzb() {
        zzcej zzcejVar;
        if (this.zze == null || (zzcejVar = this.zzd) == null) {
            return;
        }
        zzcejVar.zzd("onSdkImpression", zzfxu.zzd());
    }

    public final synchronized void zzc() {
        zzcej zzcejVar;
        zzfmb zzfmbVar = this.zze;
        if (zzfmbVar == null || (zzcejVar = this.zzd) == null) {
            return;
        }
        Iterator it = zzcejVar.zzV().iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.zzu.zzA().zzh(zzfmbVar, (View) it.next());
        }
        this.zzd.zzd("onSdkLoaded", zzfxu.zzd());
    }

    public final synchronized boolean zzd() {
        return this.zze != null;
    }

    public final synchronized boolean zze(boolean z10) {
        if (this.zzc.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzez)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && this.zzd != null) {
                    if (this.zze != null) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzj("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzu.zzA().zzl(this.zza)) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to initialize omid.");
                        return false;
                    }
                    if (this.zzc.zzV.zzb()) {
                        zzfmb zzfmbVarZze = com.google.android.gms.ads.internal.zzu.zzA().zze(this.zzb, this.zzd.zzG(), true);
                        if (zzfmbVarZze == null) {
                            com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to create javascript session service.");
                            return false;
                        }
                        com.google.android.gms.ads.internal.util.client.zzm.zzi("Created omid javascript session service.");
                        this.zze = zzfmbVarZze;
                        this.zzd.zzas(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized void zzf(zzcey zzceyVar) {
        zzfmb zzfmbVar = this.zze;
        if (zzfmbVar == null || this.zzd == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzu.zzA().zzm(zzfmbVar, zzceyVar);
        this.zze = null;
        this.zzd.zzas(null);
    }
}

package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdop extends zzcru {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdgx zze;
    private final zzddu zzf;
    private final zzcxd zzg;
    private final zzcyk zzh;
    private final zzcsp zzi;
    private final zzbwd zzj;
    private final zzfos zzk;
    private final zzfez zzl;
    private boolean zzm;

    zzdop(zzcrt zzcrtVar, Context context, @Nullable zzcej zzcejVar, zzdgx zzdgxVar, zzddu zzdduVar, zzcxd zzcxdVar, zzcyk zzcykVar, zzcsp zzcspVar, zzfel zzfelVar, zzfos zzfosVar, zzfez zzfezVar) {
        super(zzcrtVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdgxVar;
        this.zzd = new WeakReference(zzcejVar);
        this.zzf = zzdduVar;
        this.zzg = zzcxdVar;
        this.zzh = zzcykVar;
        this.zzi = zzcspVar;
        this.zzk = zzfosVar;
        zzbvz zzbvzVar = zzfelVar.zzl;
        this.zzj = new zzbwx(zzbvzVar != null ? zzbvzVar.zza : "", zzbvzVar != null ? zzbvzVar.zzb : 1);
        this.zzl = zzfezVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcej zzcejVar = (zzcej) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzga)).booleanValue()) {
                if (!this.zzm && zzcejVar != null) {
                    zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdoo
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcejVar.destroy();
                        }
                    });
                }
            } else if (zzcejVar != null) {
                zzcejVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwd zzc() {
        return this.zzj;
    }

    public final zzfez zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcej zzcejVar = (zzcej) this.zzd.get();
        return (zzcejVar == null || zzcejVar.zzaG()) ? false : true;
    }

    public final boolean zzh(boolean z10, @Nullable Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzat)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzG(this.zzc)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzau)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfgi.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z10, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdgw e10) {
            this.zzg.zzc(e10);
            return false;
        }
    }
}

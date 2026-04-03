package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcpe extends zzcru {

    @Nullable
    private final zzcej zzc;
    private final int zzd;
    private final Context zze;
    private final zzcos zzf;
    private final zzdgx zzg;
    private final zzddu zzh;
    private final zzcxd zzi;
    private final boolean zzj;
    private final zzbzi zzk;
    private boolean zzl;

    zzcpe(zzcrt zzcrtVar, Context context, @Nullable zzcej zzcejVar, int i10, zzcos zzcosVar, zzdgx zzdgxVar, zzddu zzdduVar, zzcxd zzcxdVar, zzbzi zzbziVar) {
        super(zzcrtVar);
        this.zzl = false;
        this.zzc = zzcejVar;
        this.zze = context;
        this.zzd = i10;
        this.zzf = zzcosVar;
        this.zzg = zzdgxVar;
        this.zzh = zzdduVar;
        this.zzi = zzcxdVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeM)).booleanValue();
        this.zzk = zzbziVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zzb() {
        super.zzb();
        zzcej zzcejVar = this.zzc;
        if (zzcejVar != null) {
            zzcejVar.destroy();
        }
    }

    public final void zzc(zzazj zzazjVar) {
        zzcej zzcejVar = this.zzc;
        if (zzcejVar != null) {
            zzcejVar.zzak(zzazjVar);
        }
    }

    public final void zzd(Activity activity, zzazw zzazwVar, boolean z10) throws RemoteException {
        zzcej zzcejVar;
        zzfel zzfelVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        if (this.zzj) {
            this.zzh.zzb();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzat)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzG(context)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzau)).booleanValue()) {
                    new zzfos(context.getApplicationContext(), com.google.android.gms.ads.internal.zzu.zzt().zzb()).zza(this.zza.zzb.zzb.zzb);
                    return;
                }
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkU)).booleanValue() && (zzcejVar = this.zzc) != null && (zzfelVarZzD = zzcejVar.zzD()) != null && zzfelVarZzD.zzar && zzfelVarZzD.zzas != this.zzk.zzb()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("The app open consent form has been shown.");
            this.zzi.zza(zzfgi.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("App open interstitial ad is already visible.");
            this.zzi.zza(zzfgi.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            this.zzg.zza(z10, context, this.zzi);
            if (this.zzj) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdgw e10) {
            this.zzi.zzc(e10);
        }
    }

    public final void zze(long j10, int i10) {
        this.zzf.zza(j10, i10);
    }
}

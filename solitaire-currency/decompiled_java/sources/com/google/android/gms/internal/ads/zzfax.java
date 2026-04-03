package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfax implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzemk zzd;
    private final zzemo zze;
    private final ViewGroup zzf;

    @Nullable
    private zzbcr zzg;
    private final zzczj zzh;
    private final zzfki zzi;
    private final zzdbp zzj;
    private final zzffe zzk;
    private m zzl;
    private boolean zzm;
    private com.google.android.gms.ads.internal.client.zze zzn;
    private zzemz zzo;

    public zzfax(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcgj zzcgjVar, zzemk zzemkVar, zzemo zzemoVar, zzffe zzffeVar, zzdbp zzdbpVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zzd = zzemkVar;
        this.zze = zzemoVar;
        this.zzk = zzffeVar;
        this.zzh = zzcgjVar.zzf();
        this.zzi = zzcgjVar.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdbpVar;
        zzffeVar.zzs(zzqVar);
        this.zzm = true;
        this.zzn = null;
        this.zzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        this.zzl = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhp)).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfat
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk();
                }
            });
        }
        zzemz zzemzVar = this.zzo;
        if (zzemzVar != null) {
            zzemzVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        m mVar = this.zzl;
        return (mVar == null || mVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, @Nullable zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        zzcql zzcqlVarZzk;
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfav
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl();
                }
            });
            return false;
        }
        if (!zza()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzlVar.zzf) {
                this.zzc.zzl().zzo(true);
            }
            Bundle bundleZza = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzlVar.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis())));
            zzffe zzffeVar = this.zzk;
            zzffeVar.zzt(str);
            zzffeVar.zzH(zzlVar);
            zzffeVar.zzA(bundleZza);
            Context context = this.zza;
            zzffg zzffgVarZzJ = zzffeVar.zzJ();
            zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 3, zzlVar);
            zzfkf zzfkfVarZzj = null;
            if (!((Boolean) zzbdy.zze.zze()).booleanValue() || !this.zzk.zzh().zzk) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhp)).booleanValue()) {
                    zzcqk zzcqkVarZze = this.zzc.zze();
                    zzcvy zzcvyVar = new zzcvy();
                    zzcvyVar.zze(this.zza);
                    zzcvyVar.zzi(zzffgVarZzJ);
                    zzcqkVarZze.zzi(zzcvyVar.zzj());
                    zzdci zzdciVar = new zzdci();
                    zzdciVar.zzj(this.zzd, this.zzb);
                    zzdciVar.zzk(this.zzd, this.zzb);
                    zzcqkVarZze.zzf(zzdciVar.zzn());
                    zzcqkVarZze.zze(new zzekt(this.zzg));
                    zzcqkVarZze.zzd(new zzdhg(zzdjm.zza, null));
                    zzcqkVarZze.zzg(new zzcrm(this.zzh, this.zzj));
                    zzcqkVarZze.zzc(new zzcph(this.zzf));
                    zzcqlVarZzk = zzcqkVarZze.zzh();
                } else {
                    zzcqk zzcqkVarZze2 = this.zzc.zze();
                    zzcvy zzcvyVar2 = new zzcvy();
                    zzcvyVar2.zze(this.zza);
                    zzcvyVar2.zzi(zzffgVarZzJ);
                    zzcqkVarZze2.zzi(zzcvyVar2.zzj());
                    zzdci zzdciVar2 = new zzdci();
                    zzdciVar2.zzj(this.zzd, this.zzb);
                    zzdciVar2.zza(this.zzd, this.zzb);
                    zzdciVar2.zza(this.zze, this.zzb);
                    zzdciVar2.zzl(this.zzd, this.zzb);
                    zzdciVar2.zzd(this.zzd, this.zzb);
                    zzdciVar2.zze(this.zzd, this.zzb);
                    zzdciVar2.zzf(this.zzd, this.zzb);
                    zzdciVar2.zzb(this.zzd, this.zzb);
                    zzdciVar2.zzk(this.zzd, this.zzb);
                    zzdciVar2.zzi(this.zzd, this.zzb);
                    zzcqkVarZze2.zzf(zzdciVar2.zzn());
                    zzcqkVarZze2.zze(new zzekt(this.zzg));
                    zzcqkVarZze2.zzd(new zzdhg(zzdjm.zza, null));
                    zzcqkVarZze2.zzg(new zzcrm(this.zzh, this.zzj));
                    zzcqkVarZze2.zzc(new zzcph(this.zzf));
                    zzcqlVarZzk = zzcqkVarZze2.zzh();
                }
                if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                    zzfkfVarZzj = zzcqlVarZzk.zzj();
                    zzfkfVarZzj.zzi(3);
                    zzfkfVarZzj.zzb(zzlVar.zzp);
                    zzfkfVarZzj.zzf(zzlVar.zzm);
                }
                this.zzo = zzemzVar;
                zzctc zzctcVarZzd = zzcqlVarZzk.zzd();
                m mVarZzi = zzctcVarZzd.zzi(zzctcVarZzd.zzj());
                this.zzl = mVarZzi;
                zzgcj.zzr(mVarZzi, new zzfaw(this, zzfkfVarZzj, zzfjuVarZzb, zzcqlVarZzk), this.zzb);
                return true;
            }
            zzemk zzemkVar = this.zzd;
            if (zzemkVar != null) {
                zzemkVar.zzdB(zzfgi.zzd(7, null, null));
            }
        } else if (!this.zzk.zzS()) {
            this.zzm = true;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzffe zzg() {
        return this.zzk;
    }

    final /* synthetic */ void zzk() {
        this.zzd.zzdB(this.zzn);
    }

    final /* synthetic */ void zzl() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzm() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzn() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final void zzp(zzczc zzczcVar) {
        this.zzh.zzo(zzczcVar, this.zzb);
    }

    public final void zzq(zzbcr zzbcrVar) {
        this.zzg = zzbcrVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr() {
        synchronized (this) {
            m mVar = this.zzl;
            if (mVar != null && mVar.isDone()) {
                try {
                    zzcpk zzcpkVar = (zzcpk) this.zzl.get();
                    this.zzl = null;
                    this.zzf.removeAllViews();
                    if (zzcpkVar.zzd() != null) {
                        ViewParent parent = zzcpkVar.zzd().getParent();
                        if (parent instanceof ViewGroup) {
                            com.google.android.gms.ads.internal.util.client.zzm.zzj("Banner view provided from " + (zzcpkVar.zzm() != null ? zzcpkVar.zzm().zzg() : "") + " already has a parent view. Removing its old parent.");
                            ((ViewGroup) parent).removeView(zzcpkVar.zzd());
                        }
                    }
                    zzbbn zzbbnVar = zzbbw.zzhp;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                        zzday zzdayVarZzo = zzcpkVar.zzo();
                        zzdayVarZzo.zza(this.zzd);
                        zzdayVarZzo.zzc(this.zze);
                    }
                    this.zzf.addView(zzcpkVar.zzd());
                    this.zzo.zzb(zzcpkVar);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                        Executor executor = this.zzb;
                        final zzemk zzemkVar = this.zzd;
                        Objects.requireNonNull(zzemkVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfau
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzemkVar.zzs();
                            }
                        });
                    }
                    if (zzcpkVar.zza() >= 0) {
                        this.zzm = false;
                        this.zzh.zzd(zzcpkVar.zza());
                        this.zzh.zze(zzcpkVar.zzc());
                    } else {
                        this.zzm = true;
                        this.zzh.zzd(zzcpkVar.zzc());
                    }
                } catch (InterruptedException | ExecutionException e10) {
                    zzu();
                    com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e10);
                    this.zzm = true;
                    this.zzh.zza();
                }
            } else if (this.zzl != null) {
                com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                this.zzm = true;
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                this.zzm = true;
                this.zzh.zza();
            }
        }
    }

    public final boolean zzt() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzu.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzW(view, view.getContext());
    }
}

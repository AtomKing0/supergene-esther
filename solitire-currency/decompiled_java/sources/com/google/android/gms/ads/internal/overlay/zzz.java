package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzdeq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzz extends zzbsm {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;
    private boolean zze = false;

    public zzz(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (this.zzd) {
            return;
        }
        zzp zzpVar = this.zza.zzc;
        if (zzpVar != null) {
            zzpVar.zzdu(4);
        }
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean zzH() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzl(@Nullable Bundle bundle) {
        zzp zzpVar;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhY)).booleanValue() && !this.zze) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z10 = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z10 = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
            return;
        }
        if (z10) {
            this.zzb.finish();
            return;
        }
        if (bundle == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.zzb;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzdeq zzdeqVar = this.zza.zzu;
            if (zzdeqVar != null) {
                zzdeqVar.zzdG();
            }
            if (this.zzb.getIntent() != null && this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzpVar = this.zza.zzc) != null) {
                zzpVar.zzdr();
            }
        }
        Activity activity = this.zzb;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
        com.google.android.gms.ads.internal.zzu.zzh();
        zzc zzcVar = adOverlayInfoParcel2.zza;
        if (zza.zzb(activity, zzcVar, adOverlayInfoParcel2.zzi, zzcVar.zzi)) {
            return;
        }
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzm() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzo() throws RemoteException {
        zzp zzpVar = this.zza.zzc;
        if (zzpVar != null) {
            zzpVar.zzdk();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzr() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzp zzpVar = this.zza.zzc;
        if (zzpVar != null) {
            zzpVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzu() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzv() throws RemoteException {
        zzp zzpVar = this.zza.zzc;
        if (zzpVar != null) {
            zzpVar.zzdt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzx() throws RemoteException {
        this.zze = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzi() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzt() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzh(int i10, int i11, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzp(int i10, String[] strArr, int[] iArr) {
    }
}

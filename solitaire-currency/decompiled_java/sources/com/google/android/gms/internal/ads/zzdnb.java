package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnb extends zzblj implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbep {
    private View zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzdiw zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdnb(zzdiw zzdiwVar, zzdjb zzdjbVar) {
        this.zza = zzdjbVar.zzf();
        this.zzb = zzdjbVar.zzj();
        this.zzc = zzdiwVar;
        if (zzdjbVar.zzs() != null) {
            zzdjbVar.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar == null || (view = this.zza) == null) {
            return;
        }
        zzdiwVar.zzB(view, Collections.emptyMap(), Collections.emptyMap(), zzdiw.zzX(this.zza));
    }

    private final void zzh() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zza);
        }
    }

    private static final void zzi(zzbln zzblnVar, int i10) {
        try {
            zzblnVar.zze(i10);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzg();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    @Nullable
    public final zzbfa zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar == null || zzdiwVar.zzc() == null) {
            return null;
        }
        return zzdiwVar.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar != null) {
            zzdiwVar.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdna(this));
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zzf(IObjectWrapper iObjectWrapper, zzbln zzblnVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Instream ad can not be shown after destroy().");
            zzi(zzblnVar, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Instream internal error: ".concat(view == null ? "can not get video view." : "can not get video controller."));
            zzi(zzblnVar, 0);
            return;
        }
        if (this.zze) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Instream ad should not be used again.");
            zzi(zzblnVar, 1);
            return;
        }
        this.zze = true;
        zzh();
        ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.zzu.zzx();
        zzcab.zza(this.zza, this);
        com.google.android.gms.ads.internal.zzu.zzx();
        zzcab.zzb(this.zza, this);
        zzg();
        try {
            zzblnVar.zzf();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdik extends zzbez {
    private final zzdjb zza;
    private IObjectWrapper zzb;

    public zzdik(zzdjb zzdjbVar) {
        this.zza = zzdjbVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zze() throws RemoteException {
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Remote exception getting video controller aspect ratio.", e10);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzbfd zzbfdVarZzm = this.zza.zzm();
        if (zzbfdVarZzm == null) {
            return 0.0f;
        }
        float fZzd = (zzbfdVarZzm.zzd() == -1 || zzbfdVarZzm.zzc() == -1) ? 0.0f : zzbfdVarZzm.zzd() / zzbfdVarZzm.zzc();
        return fZzd == 0.0f ? zzb(zzbfdVarZzm.zzf()) : fZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzf() throws RemoteException {
        if (this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzg() throws RemoteException {
        if (this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    @Nullable
    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbfd zzbfdVarZzm = this.zza.zzm();
        if (zzbfdVarZzm == null) {
            return null;
        }
        return zzbfdVarZzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzk() throws RemoteException {
        return this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzl() throws RemoteException {
        return this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzm(zzbgl zzbglVar) {
        if (this.zza.zzj() instanceof zzcfl) {
            ((zzcfl) this.zza.zzj()).zzv(zzbglVar);
        }
    }
}

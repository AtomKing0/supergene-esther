package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbru extends NativeAd.Image {
    private final zzbfd zza;

    @Nullable
    private final Drawable zzb;

    @Nullable
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbru(zzbfd zzbfdVar) {
        double dZzb;
        int iZzd;
        IObjectWrapper iObjectWrapperZzf;
        this.zza = zzbfdVar;
        Uri uriZze = null;
        try {
            iObjectWrapperZzf = zzbfdVar.zzf();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
        Drawable drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException e11) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e11);
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException e12) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e12);
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        int iZzc = -1;
        try {
            iZzd = this.zza.zzd();
        } catch (RemoteException e13) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e13);
            iZzd = -1;
        }
        this.zze = iZzd;
        try {
            iZzc = this.zza.zzc();
        } catch (RemoteException e14) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e14);
        }
        this.zzf = iZzc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zzb() {
        return this.zze;
    }
}

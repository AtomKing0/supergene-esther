package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwj;
import com.google.android.gms.internal.ads.zzbwn;
import com.google.android.gms.internal.ads.zzbwo;
import com.google.android.gms.internal.ads.zzbwu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfc extends zzbwf {
    private static void zzr(final zzbwn zzbwnVar) {
        com.google.android.gms.ads.internal.util.client.zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfb
            @Override // java.lang.Runnable
            public final void run() {
                zzbwn zzbwnVar2 = zzbwnVar;
                if (zzbwnVar2 != null) {
                    try {
                        zzbwnVar2.zze(1);
                    } catch (RemoteException e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final zzdn zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    @Nullable
    public final zzbwd zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final String zze() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzf(zzl zzlVar, zzbwn zzbwnVar) throws RemoteException {
        zzr(zzbwnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzg(zzl zzlVar, zzbwn zzbwnVar) throws RemoteException {
        zzr(zzbwnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final boolean zzo() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzh(boolean z10) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzi(zzdd zzddVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzj(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzk(zzbwj zzbwjVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzl(zzbwu zzbwuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzp(zzbwo zzbwoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z10) {
    }
}

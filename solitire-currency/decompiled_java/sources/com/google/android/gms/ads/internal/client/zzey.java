package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbom;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzey extends zzcn {
    private zzblc zza;

    final /* synthetic */ void zzb() {
        zzblc zzblcVar = this.zza;
        if (zzblcVar != null) {
            try {
                zzblcVar.zzb(Collections.emptyList());
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not notify onComplete event.", e10);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final float zze() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final String zzf() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzk() throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzex
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzs(zzblc zzblcVar) throws RemoteException {
        this.zza = zzblcVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final boolean zzv() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzh(@Nullable String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzj(boolean z10) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzm(zzda zzdaVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzo(zzbom zzbomVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzp(boolean z10) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzq(float f10) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzr(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzt(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzu(zzff zzffVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzl(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }
}

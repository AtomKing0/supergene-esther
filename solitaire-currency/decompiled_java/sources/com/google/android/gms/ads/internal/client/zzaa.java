package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbsq;
import com.google.android.gms.internal.ads.zzbtq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaa extends zzax {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaw zzb;

    zzaa(zzaw zzawVar, Activity activity) {
        this.zza = activity;
        this.zzb = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object zzb(zzce zzceVar) throws RemoteException {
        return zzceVar.zzm(ObjectWrapper.wrap(this.zza));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbbw.zza(this.zza);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjN)).booleanValue()) {
            zzaw zzawVar = this.zzb;
            return zzawVar.zze.zza(this.zza);
        }
        try {
            return zzbsm.zzI(((zzbsq) com.google.android.gms.ads.internal.util.client.zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzo() { // from class: com.google.android.gms.ads.internal.client.zzz
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.ads.internal.util.client.zzo
                public final Object zza(Object obj) {
                    return zzbsp.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzp | NullPointerException e10) {
            this.zzb.zzg = zzbtq.zza(this.zza.getApplicationContext());
            this.zzb.zzg.zzh(e10, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}

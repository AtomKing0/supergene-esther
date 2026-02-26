package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzblb;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzei extends zzblb {
    final /* synthetic */ zzej zza;

    /* synthetic */ zzei(zzej zzejVar, zzeh zzehVar) {
        this.zza = zzejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zzb(List list) throws RemoteException {
        int i10;
        ArrayList arrayList;
        synchronized (this.zza.zzb) {
            this.zza.zzd = false;
            this.zza.zze = true;
            arrayList = new ArrayList(this.zza.zzc);
            this.zza.zzc.clear();
        }
        InitializationStatus initializationStatusZzy = zzej.zzy(list);
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((OnInitializationCompleteListener) arrayList.get(i10)).onInitializationComplete(initializationStatusZzy);
        }
    }
}

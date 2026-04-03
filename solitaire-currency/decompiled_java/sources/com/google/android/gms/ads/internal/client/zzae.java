package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbyo;
import com.google.android.gms.internal.ads.zzbyp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzae extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbom zzb;

    zzae(zzaw zzawVar, Context context, zzbom zzbomVar) {
        this.zza = context;
        this.zzb = zzbomVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    protected final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object zzb(zzce zzceVar) throws RemoteException {
        return zzceVar.zzp(ObjectWrapper.wrap(this.zza), this.zzb, 242402000);
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbyp) com.google.android.gms.ads.internal.util.client.zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzo() { // from class: com.google.android.gms.ads.internal.client.zzad
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.ads.internal.util.client.zzo
                public final Object zza(Object obj) {
                    return zzbyo.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.zza), this.zzb, 242402000);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzp | NullPointerException unused) {
            return null;
        }
    }
}

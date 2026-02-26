package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzax extends zzba {
    final /* synthetic */ boolean zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzax(zzbb zzbbVar, GoogleApiClient googleApiClient, boolean z10) {
        super(googleApiClient);
        this.zza = z10;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzdz zzdzVar = (zzdz) anyClient;
        if (this.zza) {
            zzdzVar.zzy(zzbb.zza(this));
        } else {
            zzdzVar.zzz(zzbb.zza(this));
        }
    }
}

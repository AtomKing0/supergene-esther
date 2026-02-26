package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzen extends zzds.zzb {
    private final /* synthetic */ zzds.zza zzc;
    private final /* synthetic */ zzds zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzen(zzds zzdsVar, zzds.zza zzaVar) {
        super(zzdsVar);
        this.zzc = zzaVar;
        this.zzd = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zzd.zzj)).setEventInterceptor(this.zzc);
    }
}

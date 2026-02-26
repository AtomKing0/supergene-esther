package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeu extends zzds.zzb {
    private final /* synthetic */ zzde zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzds zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeu(zzds zzdsVar, zzde zzdeVar, int i10) {
        super(zzdsVar);
        this.zzc = zzdeVar;
        this.zzd = i10;
        this.zze = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zze.zzj)).getTestFlag(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}

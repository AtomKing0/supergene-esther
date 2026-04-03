package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzcd implements zzbg {
    static final /* synthetic */ zzcd zza = new zzcd();

    private /* synthetic */ zzcd() {
    }

    @Override // com.google.android.gms.internal.location.zzbg
    public final /* synthetic */ void zza(zzdz zzdzVar, ListenerHolder.ListenerKey listenerKey, boolean z10, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdzVar.zzv(listenerKey, z10, taskCompletionSource);
    }
}

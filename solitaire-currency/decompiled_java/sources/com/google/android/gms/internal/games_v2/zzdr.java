package com.google.android.gms.internal.games_v2;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzdr implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdr(String str, boolean z10) {
        this.zza = str;
        this.zzb = z10;
    }

    @Override // com.google.android.gms.internal.games_v2.zzaq
    public final Task zza(GoogleApi googleApi) {
        final String str = this.zza;
        final boolean z10 = this.zzb;
        return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.games.internal.zzak) obj).zzF((TaskCompletionSource) obj2, str, z10);
            }
        }).setMethodKey(6711).build());
    }
}

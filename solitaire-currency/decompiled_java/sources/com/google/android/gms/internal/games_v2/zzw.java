package com.google.android.gms.internal.games_v2;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzw extends GoogleApi implements zzs {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new Api("GamesConnect.API", zzuVar, clientKey);
    }

    zzw(Context context, zzq zzqVar) {
        super(context, (Api<zzq>) zzc, zzqVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.internal.games_v2.zzs
    public final Task zza(final zzy zzyVar, boolean z10) {
        TaskApiCall taskApiCallBuild = TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzt
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzw zzwVar = this.zza;
                ((zzae) ((zzx) obj).getService()).zzd(new zzv(zzwVar, (TaskCompletionSource) obj2), zzyVar);
            }
        }).setMethodKey(6737).setAutoResolveMissingFeatures(z10).build();
        return z10 ? doWrite(taskApiCallBuild) : doBestEffortWrite(taskApiCallBuild);
    }
}

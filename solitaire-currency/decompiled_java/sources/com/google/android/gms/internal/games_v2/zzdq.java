package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzdq implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzdq(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // com.google.android.gms.internal.games_v2.zzaq
    public final Task zza(GoogleApi googleApi) {
        final String str = this.zza;
        final String str2 = this.zzb;
        final String str3 = this.zzc;
        return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdy
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzj(str, str2, str3));
            }
        }).setMethodKey(6712).build());
    }
}

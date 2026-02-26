package com.google.android.gms.internal.games_v2;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.EventsClient;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcl implements EventsClient {
    private final zzar zza;

    public zzcl(zzar zzarVar) {
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.games.EventsClient
    public final void increment(@NonNull final String str, final int i10) {
        this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzci
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i11 = i10;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcf
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzx(str2, i11);
                    }
                }).setMethodKey(6729).build());
            }
        });
    }

    @Override // com.google.android.gms.games.EventsClient
    public final Task<AnnotatedData<EventBuffer>> load(final boolean z10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcj
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z11 = z10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcg
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzA((TaskCompletionSource) obj2, z11);
                    }
                }).setMethodKey(6727).build());
            }
        });
    }

    @Override // com.google.android.gms.games.EventsClient
    public final Task<AnnotatedData<EventBuffer>> loadByIds(final boolean z10, @NonNull final String... strArr) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzck
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z11 = z10;
                final String[] strArr2 = strArr;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzch
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzB((TaskCompletionSource) obj2, z11, strArr2);
                    }
                }).setMethodKey(6728).build());
            }
        });
    }
}

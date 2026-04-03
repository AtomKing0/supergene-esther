package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzef implements PlayersClient {
    private final zzar zza;

    public zzef(zzar zzarVar) {
        this.zza = zzarVar;
    }

    private final Task zza(final String str, final int i10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdo
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i11 = i10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdw
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzI((TaskCompletionSource) obj2, str2, i11, true, false);
                    }
                }).setMethodKey(6716).build());
            }
        });
    }

    private final Task zzb(final String str, final int i10, final boolean z10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdp
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i11 = i10;
                final boolean z11 = z10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdx
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzI((TaskCompletionSource) obj2, str2, i11, false, z11);
                    }
                }).setMethodKey(6715).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntent(@NonNull final Player player) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzee
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final Player player2 = player;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdn
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        Intent intentZzi = ((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzi(new PlayerEntity(player2));
                        intentZzi.setExtrasClassLoader(PlayerEntity.class.getClassLoader());
                        ((TaskCompletionSource) obj2).setResult(intentZzi);
                    }
                }).setMethodKey(6713).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntentWithAlternativeNameHints(String str, @Nullable String str2, @Nullable String str3) {
        return this.zza.zzb(new zzdq(str, str2, str3));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Player> getCurrentPlayer() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdt
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeb
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzak) obj).zzp());
                    }
                }).setMethodKey(6710).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<String> getCurrentPlayerId() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdu
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzec
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzo());
                    }
                }).setMethodKey(6709).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getPlayerSearchIntent() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzdv
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzed
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzl());
                    }
                }).setMethodKey(6714).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadFriends(int i10, boolean z10) {
        return zzb("friends_all", i10, z10);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(int i10) {
        return zza("friends_all", i10);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i10) {
        return zza("played_with", i10);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> loadPlayer(@NonNull String str) {
        return this.zza.zzb(new zzdr(str, false));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i10, boolean z10) {
        return zzb("played_with", i10, z10);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntent(String str) {
        return this.zza.zzb(new zzdq(str, null, null));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> getCurrentPlayer(final boolean z10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzds
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z11 = z10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzea
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzv((TaskCompletionSource) obj2, z11);
                    }
                }).setMethodKey(6710).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> loadPlayer(@NonNull String str, boolean z10) {
        return this.zza.zzb(new zzdr(str, z10));
    }
}

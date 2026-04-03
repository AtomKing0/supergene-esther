package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface PlayersClient {

    @NonNull
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    @NonNull
    Task<Intent> getCompareProfileIntent(@NonNull Player player);

    @NonNull
    Task<Intent> getCompareProfileIntent(@NonNull String str);

    @NonNull
    Task<Intent> getCompareProfileIntentWithAlternativeNameHints(@NonNull String str, @Nullable String str2, @Nullable String str3);

    @NonNull
    Task<Player> getCurrentPlayer();

    @NonNull
    Task<AnnotatedData<Player>> getCurrentPlayer(boolean z10);

    @NonNull
    Task<String> getCurrentPlayerId();

    @NonNull
    Task<Intent> getPlayerSearchIntent();

    @NonNull
    Task<AnnotatedData<PlayerBuffer>> loadFriends(@IntRange(from = 1, to = 200) int i10, boolean z10);

    @NonNull
    Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(@IntRange(from = 1, to = 200) int i10);

    @NonNull
    @Deprecated
    Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(@IntRange(from = 1, to = 25) int i10);

    @NonNull
    Task<AnnotatedData<Player>> loadPlayer(@NonNull String str);

    @NonNull
    Task<AnnotatedData<Player>> loadPlayer(@NonNull String str, boolean z10);

    @NonNull
    @Deprecated
    Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(@IntRange(from = 1, to = 25) int i10, boolean z10);
}

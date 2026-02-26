package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface GamesMetadataClient {
    @NonNull
    Task<Game> getCurrentGame();

    @NonNull
    Task<AnnotatedData<Game>> loadGame();
}

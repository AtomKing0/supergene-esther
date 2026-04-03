package com.google.android.gms.games;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface EventsClient {
    void increment(@NonNull String str, @IntRange(from = 0) int i10);

    @NonNull
    Task<AnnotatedData<EventBuffer>> load(boolean z10);

    @NonNull
    Task<AnnotatedData<EventBuffer>> loadByIds(boolean z10, @NonNull String... strArr);
}

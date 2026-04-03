package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface AchievementsClient {
    @NonNull
    Task<Intent> getAchievementsIntent();

    void increment(@NonNull String str, @IntRange(from = 0) int i10);

    @NonNull
    Task<Boolean> incrementImmediate(@NonNull String str, @IntRange(from = 0) int i10);

    @NonNull
    Task<AnnotatedData<AchievementBuffer>> load(boolean z10);

    void reveal(@NonNull String str);

    @NonNull
    Task<Void> revealImmediate(@NonNull String str);

    void setSteps(@NonNull String str, @IntRange(from = 0) int i10);

    @NonNull
    Task<Boolean> setStepsImmediate(@NonNull String str, @IntRange(from = 0) int i10);

    void unlock(@NonNull String str);

    @NonNull
    Task<Void> unlockImmediate(@NonNull String str);
}

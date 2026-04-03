package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface Achievement extends Freezable<Achievement>, Parcelable {
    public static final int STATE_HIDDEN = 2;
    public static final int STATE_REVEALED = 1;
    public static final int STATE_UNLOCKED = 0;
    public static final int TYPE_INCREMENTAL = 1;
    public static final int TYPE_STANDARD = 0;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AchievementState {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AchievementType {
    }

    @NonNull
    String getAchievementId();

    int getCurrentSteps();

    @NonNull
    String getDescription();

    void getDescription(@NonNull CharArrayBuffer charArrayBuffer);

    @Nullable
    String getFormattedCurrentSteps();

    void getFormattedCurrentSteps(@NonNull CharArrayBuffer charArrayBuffer);

    @Nullable
    String getFormattedTotalSteps();

    void getFormattedTotalSteps(@NonNull CharArrayBuffer charArrayBuffer);

    long getLastUpdatedTimestamp();

    @NonNull
    String getName();

    void getName(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    Player getPlayer();

    @Nullable
    Uri getRevealedImageUri();

    @Nullable
    @KeepName
    @Deprecated
    String getRevealedImageUrl();

    int getState();

    int getTotalSteps();

    int getType();

    @Nullable
    Uri getUnlockedImageUri();

    @Nullable
    @KeepName
    @Deprecated
    String getUnlockedImageUrl();

    long getXpValue();

    float zza();

    @Nullable
    Player zzb();

    @NonNull
    String zzc();
}

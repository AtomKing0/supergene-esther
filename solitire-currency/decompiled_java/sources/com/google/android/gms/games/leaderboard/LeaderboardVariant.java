package com.google.android.gms.games.leaderboard;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface LeaderboardVariant extends Freezable<LeaderboardVariant> {
    public static final int COLLECTION_FRIENDS = 3;
    public static final int COLLECTION_PUBLIC = 0;
    public static final int NUM_SCORES_UNKNOWN = -1;
    public static final int NUM_TIME_SPANS = 3;
    public static final int PLAYER_RANK_UNKNOWN = -1;
    public static final int PLAYER_SCORE_UNKNOWN = -1;
    public static final int TIME_SPAN_ALL_TIME = 2;
    public static final int TIME_SPAN_DAILY = 0;
    public static final int TIME_SPAN_WEEKLY = 1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Collection {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeSpan {
    }

    int getCollection();

    @NonNull
    String getDisplayPlayerRank();

    @NonNull
    String getDisplayPlayerScore();

    long getNumScores();

    long getPlayerRank();

    @NonNull
    String getPlayerScoreTag();

    long getRawPlayerScore();

    int getTimeSpan();

    boolean hasPlayerInfo();

    @NonNull
    String zza();

    @NonNull
    String zzb();

    @NonNull
    String zzc();
}

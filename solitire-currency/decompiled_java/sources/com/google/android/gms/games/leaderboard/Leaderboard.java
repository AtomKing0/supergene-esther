package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface Leaderboard extends Freezable<Leaderboard> {
    public static final int SCORE_ORDER_LARGER_IS_BETTER = 1;
    public static final int SCORE_ORDER_SMALLER_IS_BETTER = 0;

    @NonNull
    String getDisplayName();

    void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    Uri getIconImageUri();

    @NonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @NonNull
    String getLeaderboardId();

    int getScoreOrder();

    @NonNull
    ArrayList<LeaderboardVariant> getVariants();

    @NonNull
    Game zza();
}

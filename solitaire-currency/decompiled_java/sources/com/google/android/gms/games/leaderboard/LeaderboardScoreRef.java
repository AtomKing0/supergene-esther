package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    private final PlayerRef zza;

    public LeaderboardScoreRef(@NonNull DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
        this.zza = new PlayerRef(dataHolder, i10, null);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return LeaderboardScoreEntity.zzc(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ LeaderboardScore freeze() {
        return new LeaderboardScoreEntity(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getDisplayRank() {
        return getString("display_rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getDisplayScore() {
        return getString("display_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return getLong("rank");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return getLong("raw_score");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @Nullable
    public final Player getScoreHolder() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getScoreHolderDisplayName() {
        return hasNull("external_player_id") ? getString("default_display_name") : this.zza.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @Nullable
    public final Uri getScoreHolderHiResImageUri() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @Nullable
    public String getScoreHolderHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zza.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final Uri getScoreHolderIconImageUri() {
        return hasNull("external_player_id") ? parseUri("default_display_image_uri") : this.zza.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public String getScoreHolderIconImageUrl() {
        return hasNull("external_player_id") ? getString("default_display_image_url") : this.zza.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getScoreTag() {
        return getString("score_tag");
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    @NonNull
    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_rank", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_score", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zza.getDisplayName(charArrayBuffer);
        }
    }
}

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final Uri zzg;
    private final Uri zzh;
    private final PlayerEntity zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;

    public LeaderboardScoreEntity(@NonNull LeaderboardScore leaderboardScore) {
        this.zza = leaderboardScore.getRank();
        this.zzb = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayRank());
        this.zzc = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayScore());
        this.zzd = leaderboardScore.getRawScore();
        this.zze = leaderboardScore.getTimestampMillis();
        this.zzf = leaderboardScore.getScoreHolderDisplayName();
        this.zzg = leaderboardScore.getScoreHolderIconImageUri();
        this.zzh = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzi = scoreHolder == null ? null : new PlayerEntity(scoreHolder);
        this.zzj = leaderboardScore.getScoreTag();
        this.zzk = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzl = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return Objects.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return Objects.toStringHelper(leaderboardScore).add("Rank", Long.valueOf(leaderboardScore.getRank())).add("DisplayRank", leaderboardScore.getDisplayRank()).add("Score", Long.valueOf(leaderboardScore.getRawScore())).add("DisplayScore", leaderboardScore.getDisplayScore()).add("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).add("DisplayName", leaderboardScore.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).add("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).add("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    static boolean zzc(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return Objects.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && Objects.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && Objects.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && Objects.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && Objects.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && Objects.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && Objects.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && Objects.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && Objects.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && Objects.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getDisplayRank() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getDisplayScore() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final Player getScoreHolder() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzf : playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzh : playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzl : playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzg : playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzk : playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    @NonNull
    public final String getScoreTag() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return this.zze;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @NonNull
    public final String toString() {
        return zzb(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzi;
        if (playerEntity == null) {
            DataUtils.copyStringToBuffer(this.zzf, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ LeaderboardScore freeze() {
        return this;
    }
}

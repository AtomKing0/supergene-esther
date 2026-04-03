package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface LeaderboardsClient {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static class LeaderboardScores implements Releasable {
        private final Leaderboard zza;
        private final LeaderboardScoreBuffer zzb;

        public LeaderboardScores(@Nullable Leaderboard leaderboard, @NonNull LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.zza = leaderboard;
            this.zzb = leaderboardScoreBuffer;
        }

        @Nullable
        public Leaderboard getLeaderboard() {
            return this.zza;
        }

        @NonNull
        public LeaderboardScoreBuffer getScores() {
            return this.zzb;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            this.zzb.release();
        }
    }

    @NonNull
    Task<Intent> getAllLeaderboardsIntent();

    @NonNull
    Task<Intent> getLeaderboardIntent(@NonNull String str);

    @NonNull
    Task<Intent> getLeaderboardIntent(@NonNull String str, int i10);

    @NonNull
    Task<Intent> getLeaderboardIntent(@NonNull String str, int i10, int i11);

    @NonNull
    Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(@NonNull String str, int i10, int i11);

    @NonNull
    Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(@NonNull String str, boolean z10);

    @NonNull
    Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z10);

    @NonNull
    Task<AnnotatedData<LeaderboardScores>> loadMoreScores(@NonNull LeaderboardScoreBuffer leaderboardScoreBuffer, @IntRange(from = 1, to = 25) int i10, int i11);

    @NonNull
    Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i10, int i11, @IntRange(from = 1, to = 25) int i12);

    @NonNull
    Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i10, int i11, @IntRange(from = 1, to = 25) int i12, boolean z10);

    @NonNull
    Task<AnnotatedData<LeaderboardScores>> loadTopScores(@NonNull String str, int i10, int i11, @IntRange(from = 1, to = 25) int i12);

    @NonNull
    Task<AnnotatedData<LeaderboardScores>> loadTopScores(@NonNull String str, int i10, int i11, @IntRange(from = 1, to = 25) int i12, boolean z10);

    void submitScore(@NonNull String str, long j10);

    void submitScore(@NonNull String str, long j10, @NonNull String str2);

    @NonNull
    Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j10);

    @NonNull
    Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j10, @NonNull String str2);
}

package com.google.android.gms.games.leaderboard;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games_v2.zzah;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ScoreSubmissionData {
    private static final String[] zza = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzb;
    private String zzc;
    private int zzd;
    private SparseArray zze = new SparseArray();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class Result {

        @NonNull
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;

        @NonNull
        public final String scoreTag;

        public Result(long j10, @NonNull String str, @NonNull String str2, boolean z10) {
            this.rawScore = j10;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z10;
        }

        @NonNull
        public String toString() {
            return Objects.toStringHelper(this).add("RawScore", Long.valueOf(this.rawScore)).add("FormattedScore", this.formattedScore).add("ScoreTag", this.scoreTag).add("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(@NonNull DataHolder dataHolder) {
        this.zzd = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        Preconditions.checkArgument(count == 3);
        int i10 = 0;
        while (i10 < count) {
            int windowIndex = dataHolder.getWindowIndex(i10);
            if (i10 == 0) {
                this.zzb = dataHolder.getString("leaderboardId", 0, windowIndex);
                this.zzc = dataHolder.getString("playerId", 0, windowIndex);
                i10 = 0;
            }
            if (dataHolder.getBoolean("hasResult", i10, windowIndex)) {
                this.zze.put(dataHolder.getInteger("timeSpan", i10, windowIndex), new Result(dataHolder.getLong("rawScore", i10, windowIndex), dataHolder.getString("formattedScore", i10, windowIndex), dataHolder.getString("scoreTag", i10, windowIndex), dataHolder.getBoolean("newBest", i10, windowIndex)));
            }
            i10++;
        }
    }

    @NonNull
    public String getLeaderboardId() {
        return this.zzb;
    }

    @NonNull
    public String getPlayerId() {
        return this.zzc;
    }

    @NonNull
    public Result getScoreResult(int i10) {
        return (Result) this.zze.get(i10);
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add("PlayerId", this.zzc).add("StatusCode", Integer.valueOf(this.zzd));
        for (int i10 = 0; i10 < 3; i10++) {
            Result result = (Result) this.zze.get(i10);
            toStringHelperAdd.add("TimesSpan", zzah.zza(i10));
            toStringHelperAdd.add("Result", result == null ? "null" : result.toString());
        }
        return toStringHelperAdd.toString();
    }
}

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
public final class LeaderboardEntity implements Leaderboard {
    private final String zza;
    private final String zzb;
    private final Uri zzc;
    private final int zzd;
    private final ArrayList zze;
    private final Game zzf;
    private final String zzg;

    public LeaderboardEntity(@NonNull Leaderboard leaderboard) {
        this.zza = leaderboard.getLeaderboardId();
        this.zzb = leaderboard.getDisplayName();
        this.zzc = leaderboard.getIconImageUri();
        this.zzg = leaderboard.getIconImageUrl();
        this.zzd = leaderboard.getScoreOrder();
        Game gameZza = leaderboard.zza();
        this.zzf = gameZza == null ? null : new GameEntity(gameZza);
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.zze = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.zze.add(variants.get(i10).freeze());
        }
    }

    static int zzb(Leaderboard leaderboard) {
        return Objects.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static String zzc(Leaderboard leaderboard) {
        return Objects.toStringHelper(leaderboard).add("LeaderboardId", leaderboard.getLeaderboardId()).add("DisplayName", leaderboard.getDisplayName()).add("IconImageUri", leaderboard.getIconImageUri()).add("IconImageUrl", leaderboard.getIconImageUrl()).add("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).add("Variants", leaderboard.getVariants()).toString();
    }

    static boolean zzd(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return Objects.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && Objects.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && Objects.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && Objects.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && Objects.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzd(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final Uri getIconImageUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public String getIconImageUrl() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final String getLeaderboardId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zze);
    }

    public final int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @NonNull
    public final String toString() {
        return zzc(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final Game zza() {
        throw null;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ Leaderboard freeze() {
        return this;
    }
}

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    private final int zza;
    private final Game zzb;

    LeaderboardRef(DataHolder dataHolder, int i10, int i11) {
        super(dataHolder, i10);
        this.zza = i11;
        this.zzb = new GameRef(dataHolder, i10);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return LeaderboardEntity.zzd(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ Leaderboard freeze() {
        return new LeaderboardEntity(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final String getDisplayName() {
        return getString("name");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final Uri getIconImageUri() {
        return parseUri("board_icon_image_uri");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return getInteger("score_order");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.zza);
        for (int i10 = 0; i10 < this.zza; i10++) {
            arrayList.add(new zzb(this.mDataHolder, this.mDataRow + i10));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return LeaderboardEntity.zzb(this);
    }

    @NonNull
    public final String toString() {
        return LeaderboardEntity.zzc(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    @NonNull
    public final Game zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}

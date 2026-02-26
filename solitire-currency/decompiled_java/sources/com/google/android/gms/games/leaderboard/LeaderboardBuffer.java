package com.google.android.gms.games.leaderboard;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class LeaderboardBuffer extends EntityBuffer<Leaderboard> {
    public LeaderboardBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final /* bridge */ /* synthetic */ Leaderboard getEntry(int i10, int i11) {
        return new LeaderboardRef(this.mDataHolder, i10, i11);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}

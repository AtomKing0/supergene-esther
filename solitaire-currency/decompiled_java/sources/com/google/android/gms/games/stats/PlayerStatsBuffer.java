package com.google.android.gms.games.stats;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    public PlayerStatsBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final PlayerStats get(int i10) {
        return new zzb(this.mDataHolder, i10);
    }
}

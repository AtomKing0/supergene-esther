package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class PlayerBuffer extends AbstractDataBuffer<Player> {
    public PlayerBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    public Player get(int i10) {
        return new PlayerRef(this.mDataHolder, i10, null);
    }
}

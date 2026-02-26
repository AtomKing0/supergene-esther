package com.google.android.gms.games.achievement;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AchievementBuffer extends AbstractDataBuffer<Achievement> {
    public AchievementBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    public Achievement get(int i10) {
        return new AchievementRef(this.mDataHolder, i10);
    }
}

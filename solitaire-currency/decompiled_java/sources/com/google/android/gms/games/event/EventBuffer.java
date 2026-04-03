package com.google.android.gms.games.event;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventBuffer extends AbstractDataBuffer<Event> {
    public EventBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    public Event get(int i10) {
        return new EventRef(this.mDataHolder, i10);
    }
}

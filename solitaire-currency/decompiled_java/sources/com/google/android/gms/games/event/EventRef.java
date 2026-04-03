package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventRef extends DataBufferRef implements Event {
    EventRef(DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return EventEntity.zzc(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ Event freeze() {
        return new EventEntity(this);
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final String getDescription() {
        return getString("description");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final String getEventId() {
        return getString("external_event_id");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final Uri getIconImageUri() {
        return parseUri("icon_image_uri");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final String getName() {
        return getString("name");
    }

    @Override // com.google.android.gms.games.event.Event
    @NonNull
    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    @Override // com.google.android.gms.games.event.Event
    public final long getValue() {
        return getLong("value");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return EventEntity.zza(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return getBoolean("visibility");
    }

    @NonNull
    public final String toString() {
        return EventEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        new EventEntity(this).writeToParcel(parcel, i10);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getFormattedValue(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("formatted_value", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}

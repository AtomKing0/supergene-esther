package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    private final Game zza;
    private final Player zzb;

    public SnapshotMetadataRef(@NonNull DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
        this.zza = new GameRef(dataHolder, i10);
        this.zzb = new PlayerRef(dataHolder, i10, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return SnapshotMetadataEntity.zzd(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ SnapshotMetadata freeze() {
        return new SnapshotMetadataEntity(this);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final float getCoverImageAspectRatio() {
        float f10 = getFloat("cover_icon_image_height");
        float f11 = getFloat("cover_icon_image_width");
        if (f10 == 0.0f) {
            return 0.0f;
        }
        return f11 / f10;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final Uri getCoverImageUri() {
        return parseUri("cover_icon_image_uri");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String getDescription() {
        return getString("description");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String getDeviceName() {
        return getString("device_name");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final Game getGame() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final Player getOwner() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getPlayedTime() {
        return getLong("duration");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final long getProgressValue() {
        return getLong("progress_value");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String getUniqueName() {
        return getString("unique_name");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return SnapshotMetadataEntity.zzb(this);
    }

    @NonNull
    public final String toString() {
        return SnapshotMetadataEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        new SnapshotMetadataEntity(this).writeToParcel(parcel, i10);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String zza() {
        return getString("title");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }
}

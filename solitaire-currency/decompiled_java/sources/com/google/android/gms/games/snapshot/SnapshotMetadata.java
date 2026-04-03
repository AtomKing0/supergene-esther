package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface SnapshotMetadata extends Freezable<SnapshotMetadata>, Parcelable {
    public static final long PLAYED_TIME_UNKNOWN = -1;
    public static final long PROGRESS_VALUE_UNKNOWN = -1;

    float getCoverImageAspectRatio();

    @Nullable
    Uri getCoverImageUri();

    @Nullable
    @KeepName
    @Deprecated
    String getCoverImageUrl();

    @NonNull
    String getDescription();

    void getDescription(@NonNull CharArrayBuffer charArrayBuffer);

    @Nullable
    String getDeviceName();

    @NonNull
    Game getGame();

    long getLastModifiedTimestamp();

    @NonNull
    Player getOwner();

    long getPlayedTime();

    long getProgressValue();

    @NonNull
    String getSnapshotId();

    @NonNull
    String getUniqueName();

    boolean hasChangePending();

    @NonNull
    String zza();
}

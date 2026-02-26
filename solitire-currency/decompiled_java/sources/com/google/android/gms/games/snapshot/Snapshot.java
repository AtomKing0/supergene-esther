package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface Snapshot extends Freezable<Snapshot>, Parcelable {
    @NonNull
    SnapshotMetadata getMetadata();

    @NonNull
    SnapshotContents getSnapshotContents();
}

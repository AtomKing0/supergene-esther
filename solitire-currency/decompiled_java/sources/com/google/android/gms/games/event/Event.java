package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface Event extends Freezable<Event>, Parcelable {
    @NonNull
    String getDescription();

    void getDescription(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    String getEventId();

    @NonNull
    String getFormattedValue();

    void getFormattedValue(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    Uri getIconImageUri();

    @NonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @NonNull
    String getName();

    void getName(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    Player getPlayer();

    long getValue();

    boolean isVisible();
}

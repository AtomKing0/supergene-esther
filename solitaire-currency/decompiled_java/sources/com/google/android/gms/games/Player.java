package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface Player extends Freezable<Player>, Parcelable {
    public static final long CURRENT_XP_UNKNOWN = -1;
    public static final long TIMESTAMP_UNKNOWN = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FriendsListVisibilityStatus {
        public static final int FEATURE_UNAVAILABLE = 3;
        public static final int REQUEST_REQUIRED = 2;
        public static final int UNKNOWN = 0;
        public static final int VISIBLE = 1;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerFriendStatus {
        public static final int FRIEND = 4;
        public static final int NO_RELATIONSHIP = 0;
        public static final int UNKNOWN = -1;
    }

    @Nullable
    Uri getBannerImageLandscapeUri();

    @Nullable
    @KeepName
    @Deprecated
    String getBannerImageLandscapeUrl();

    @Nullable
    Uri getBannerImagePortraitUri();

    @Nullable
    @KeepName
    @Deprecated
    String getBannerImagePortraitUrl();

    @Nullable
    CurrentPlayerInfo getCurrentPlayerInfo();

    @NonNull
    String getDisplayName();

    void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer);

    @Nullable
    Uri getHiResImageUri();

    @Nullable
    @KeepName
    @Deprecated
    String getHiResImageUrl();

    @Nullable
    Uri getIconImageUri();

    @Nullable
    @KeepName
    @Deprecated
    String getIconImageUrl();

    @Deprecated
    long getLastPlayedWithTimestamp();

    @Nullable
    PlayerLevelInfo getLevelInfo();

    @NonNull
    String getPlayerId();

    @Nullable
    PlayerRelationshipInfo getRelationshipInfo();

    long getRetrievedTimestamp();

    @Nullable
    String getTitle();

    void getTitle(@NonNull CharArrayBuffer charArrayBuffer);

    boolean hasHiResImage();

    boolean hasIconImage();

    @Deprecated
    int zza();

    long zzb();

    @Nullable
    com.google.android.gms.games.internal.player.zza zzc();

    @Nullable
    String zzd();

    @NonNull
    String zze();

    boolean zzf();

    boolean zzg();

    boolean zzh();
}

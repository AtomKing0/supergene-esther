package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface Game extends Freezable<Game>, Parcelable {
    boolean areSnapshotsEnabled();

    int getAchievementTotalCount();

    @NonNull
    String getApplicationId();

    @NonNull
    String getDescription();

    void getDescription(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    String getDeveloperName();

    void getDeveloperName(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    String getDisplayName();

    void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer);

    @NonNull
    Uri getFeaturedImageUri();

    @NonNull
    @KeepName
    @Deprecated
    String getFeaturedImageUrl();

    @NonNull
    Uri getHiResImageUri();

    @NonNull
    @KeepName
    @Deprecated
    String getHiResImageUrl();

    @NonNull
    Uri getIconImageUri();

    @NonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    @NonNull
    String getPrimaryCategory();

    @NonNull
    String getSecondaryCategory();

    @NonNull
    String getThemeColor();

    boolean hasGamepadSupport();

    @NonNull
    String zza();

    boolean zzb();

    boolean zzc();

    boolean zzd();

    boolean zze();

    @Deprecated
    boolean zzf();

    @Deprecated
    boolean zzg();
}

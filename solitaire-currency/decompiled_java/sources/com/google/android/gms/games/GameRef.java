package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class GameRef extends DataBufferRef implements Game {
    public GameRef(@NonNull DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return GameEntity.zzm(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ Game freeze() {
        return new GameEntity(this);
    }

    @Override // com.google.android.gms.games.Game
    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getApplicationId() {
        return getString("external_game_id");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getDescription() {
        return getString("game_description");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getDeveloperName() {
        return getString("developer_name");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getDisplayName() {
        return getString("display_name");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final Uri getFeaturedImageUri() {
        return parseUri("featured_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final Uri getHiResImageUri() {
        return parseUri("game_hi_res_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final Uri getIconImageUri() {
        return parseUri("game_icon_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String getThemeColor() {
        return getString("theme_color");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return GameEntity.zzh(this);
    }

    @NonNull
    public final String toString() {
        return GameEntity.zzj(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        new GameEntity(this).writeToParcel(parcel, i10);
    }

    @Override // com.google.android.gms.games.Game
    @NonNull
    public final String zza() {
        return getString(v8.h.V);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzb() {
        return getBoolean("identity_sharing_confirmed");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzc() {
        return getInteger("installed") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzd() {
        return getBoolean("muted");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zze() {
        return getBoolean("play_enabled_game");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzf() {
        return getInteger("real_time_support") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzg() {
        return getInteger("turn_based_support") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public final void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("game_description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final void getDeveloperName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("developer_name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_name", charArrayBuffer);
    }
}

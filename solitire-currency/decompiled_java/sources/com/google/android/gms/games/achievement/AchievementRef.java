package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class AchievementRef extends DataBufferRef implements Achievement {
    AchievementRef(DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return AchievementEntity.zzf(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ Achievement freeze() {
        return new AchievementEntity(this);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getInteger("current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String getDescription() {
        return getString("description");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String getFormattedCurrentSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getString("formatted_current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String getFormattedTotalSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getString("formatted_total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String getName() {
        return getString("name");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzb());
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return getInteger("state");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getInteger("total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return getInteger("type");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return (!hasColumn("instance_xp_value") || hasNull("instance_xp_value")) ? getLong("definition_xp_value") : getLong("instance_xp_value");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return AchievementEntity.zzd(this);
    }

    @NonNull
    public final String toString() {
        return AchievementEntity.zze(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        new AchievementEntity(this).writeToParcel(parcel, i10);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        if (!hasColumn("rarity_percent") || hasNull("rarity_percent")) {
            return -1.0f;
        }
        return getFloat("rarity_percent");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public final Player zzb() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String zzc() {
        return getString("external_game_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(@NonNull CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getInteger("type") == 1);
        copyToBuffer("formatted_current_steps", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(@NonNull CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getInteger("type") == 1);
        copyToBuffer("formatted_total_steps", charArrayBuffer);
    }
}

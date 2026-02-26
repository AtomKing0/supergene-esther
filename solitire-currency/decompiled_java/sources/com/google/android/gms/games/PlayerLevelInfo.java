package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "PlayerLevelInfoCreator")
@SafeParcelable.Reserved({1000})
public final class PlayerLevelInfo extends com.google.android.gms.games.internal.zzh {

    @NonNull
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzs();

    @SafeParcelable.Field(getter = "getCurrentXpTotal", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getLastLevelUpTimestamp", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getCurrentLevel", id = 3)
    private final PlayerLevel zzc;

    @SafeParcelable.Field(getter = "getNextLevel", id = 4)
    private final PlayerLevel zzd;

    @SafeParcelable.Constructor
    public PlayerLevelInfo(@SafeParcelable.Param(id = 1) long j10, @SafeParcelable.Param(id = 2) long j11, @NonNull @SafeParcelable.Param(id = 3) PlayerLevel playerLevel, @NonNull @SafeParcelable.Param(id = 4) PlayerLevel playerLevel2) {
        Preconditions.checkState(j10 != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zza = j10;
        this.zzb = j11;
        this.zzc = playerLevel;
        this.zzd = playerLevel2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.zza), Long.valueOf(playerLevelInfo.zza)) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(playerLevelInfo.zzb)) && Objects.equal(this.zzc, playerLevelInfo.zzc) && Objects.equal(this.zzd, playerLevelInfo.zzd);
    }

    @NonNull
    public PlayerLevel getCurrentLevel() {
        return this.zzc;
    }

    public long getCurrentXpTotal() {
        return this.zza;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzb;
    }

    @NonNull
    public PlayerLevel getNextLevel() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public boolean isMaxLevel() {
        return this.zzc.equals(this.zzd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "PlayerRelationshipInfoEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzt extends com.google.android.gms.games.internal.zzh implements PlayerRelationshipInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    @SafeParcelable.Field(getter = "getFriendStatus", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getNickname", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getInvitationNickname", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getNicknameAbuseReportToken", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Param(id = 1) int i10, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    static int zzd(PlayerRelationshipInfo playerRelationshipInfo) {
        return Objects.hashCode(Integer.valueOf(playerRelationshipInfo.getFriendStatus()), playerRelationshipInfo.zzb(), playerRelationshipInfo.zza(), playerRelationshipInfo.zzc());
    }

    static String zze(PlayerRelationshipInfo playerRelationshipInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(playerRelationshipInfo);
        stringHelper.add("FriendStatus", Integer.valueOf(playerRelationshipInfo.getFriendStatus()));
        if (playerRelationshipInfo.zzb() != null) {
            stringHelper.add("Nickname", playerRelationshipInfo.zzb());
        }
        if (playerRelationshipInfo.zza() != null) {
            stringHelper.add("InvitationNickname", playerRelationshipInfo.zza());
        }
        if (playerRelationshipInfo.zzc() != null) {
            stringHelper.add("NicknameAbuseReportToken", playerRelationshipInfo.zza());
        }
        return stringHelper.toString();
    }

    static boolean zzf(PlayerRelationshipInfo playerRelationshipInfo, Object obj) {
        if (!(obj instanceof PlayerRelationshipInfo)) {
            return false;
        }
        if (obj == playerRelationshipInfo) {
            return true;
        }
        PlayerRelationshipInfo playerRelationshipInfo2 = (PlayerRelationshipInfo) obj;
        return playerRelationshipInfo2.getFriendStatus() == playerRelationshipInfo.getFriendStatus() && Objects.equal(playerRelationshipInfo2.zzb(), playerRelationshipInfo.zzb()) && Objects.equal(playerRelationshipInfo2.zza(), playerRelationshipInfo.zza()) && Objects.equal(playerRelationshipInfo2.zzc(), playerRelationshipInfo.zzc());
    }

    public final boolean equals(@Nullable Object obj) {
        return zzf(this, obj);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return zzd(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zze(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzu.zza(this, parcel, i10);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    @Nullable
    public final String zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    @Nullable
    public final String zzc() {
        return this.zzd;
    }

    public zzt(PlayerRelationshipInfo playerRelationshipInfo) {
        this.zza = playerRelationshipInfo.getFriendStatus();
        this.zzb = playerRelationshipInfo.zzb();
        this.zzc = playerRelationshipInfo.zza();
        this.zzd = playerRelationshipInfo.zzc();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlayerRelationshipInfo freeze() {
        return this;
    }
}

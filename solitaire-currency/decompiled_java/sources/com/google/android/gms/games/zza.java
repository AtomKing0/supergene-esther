package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "CurrentPlayerInfoEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zza extends com.google.android.gms.games.internal.zzh implements CurrentPlayerInfo {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    @SafeParcelable.Field(getter = "getFriendsListVisibilityStatus", id = 1)
    private final int zza;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 1) int i10) {
        this.zza = i10;
    }

    static int zza(CurrentPlayerInfo currentPlayerInfo) {
        return Objects.hashCode(Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
    }

    static String zzb(CurrentPlayerInfo currentPlayerInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(currentPlayerInfo);
        stringHelper.add("FriendsListVisibilityStatus", Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
        return stringHelper.toString();
    }

    static boolean zzc(CurrentPlayerInfo currentPlayerInfo, Object obj) {
        if (obj instanceof CurrentPlayerInfo) {
            return obj == currentPlayerInfo || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == currentPlayerInfo.getFriendsListVisibilityStatus();
        }
        return false;
    }

    public final boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzb.zza(this, parcel, i10);
    }

    public zza(CurrentPlayerInfo currentPlayerInfo) {
        this.zza = currentPlayerInfo.getFriendsListVisibilityStatus();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ CurrentPlayerInfo freeze() {
        return this;
    }
}

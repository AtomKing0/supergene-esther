package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public final class zzc extends zzo implements CurrentPlayerInfo {
    private final com.google.android.gms.games.internal.player.zzd zza;

    public zzc(DataHolder dataHolder, int i10, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i10);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return zza.zzc(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ CurrentPlayerInfo freeze() {
        return new zza(this);
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return zzp(this.zza.zzK, 0);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zza.zza(this);
    }

    public final String toString() {
        return zza.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzb.zza(new zza(this), parcel, i10);
    }

    public final boolean zza() {
        return hasColumn(this.zza.zzK) && !hasNull(this.zza.zzK);
    }
}

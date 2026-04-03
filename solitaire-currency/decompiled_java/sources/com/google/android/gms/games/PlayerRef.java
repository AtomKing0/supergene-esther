package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public final class PlayerRef extends zzo implements Player {
    private final com.google.android.gms.games.internal.player.zzd zza;
    private final PlayerLevelInfo zzb;
    private final com.google.android.gms.games.internal.player.zzc zzc;
    private final zzv zzd;
    private final zzc zze;

    public PlayerRef(@NonNull DataHolder dataHolder, int i10, @NonNull String str) {
        super(dataHolder, i10);
        com.google.android.gms.games.internal.player.zzd zzdVar = new com.google.android.gms.games.internal.player.zzd(null);
        this.zza = zzdVar;
        this.zzc = new com.google.android.gms.games.internal.player.zzc(dataHolder, i10, zzdVar);
        this.zzd = new zzv(dataHolder, i10, zzdVar);
        this.zze = new zzc(dataHolder, i10, zzdVar);
        if (hasNull(zzdVar.zzj) || getLong(zzdVar.zzj) == -1) {
            this.zzb = null;
            return;
        }
        int integer = getInteger(zzdVar.zzk);
        int integer2 = getInteger(zzdVar.zzn);
        PlayerLevel playerLevel = new PlayerLevel(integer, getLong(zzdVar.zzl), getLong(zzdVar.zzm));
        this.zzb = new PlayerLevelInfo(getLong(zzdVar.zzj), getLong(zzdVar.zzp), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(zzdVar.zzm), getLong(zzdVar.zzo)) : playerLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return PlayerEntity.zzn(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* synthetic */ Player freeze() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zza.zzB);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public String getBannerImageLandscapeUrl() {
        return getString(this.zza.zzC);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zza.zzD);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public String getBannerImagePortraitUrl() {
        return getString(this.zza.zzE);
    }

    @Override // com.google.android.gms.games.Player
    @Nullable
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        if (this.zze.zza()) {
            return this.zze;
        }
        return null;
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final String getDisplayName() {
        return getString(this.zza.zzb);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final Uri getHiResImageUri() {
        return parseUri(this.zza.zze);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public String getHiResImageUrl() {
        return getString(this.zza.zzf);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final Uri getIconImageUri() {
        return parseUri(this.zza.zzc);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public String getIconImageUrl() {
        return getString(this.zza.zzd);
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zza.zzi) || hasNull(this.zza.zzi)) {
            return -1L;
        }
        return getLong(this.zza.zzi);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final String getPlayerId() {
        return getString(this.zza.zza);
    }

    @Override // com.google.android.gms.games.Player
    @Nullable
    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzv zzvVar = this.zzd;
        if (zzvVar.getFriendStatus() == -1 && zzvVar.zzb() == null && zzvVar.zza() == null) {
            return null;
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return getLong(this.zza.zzg);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final String getTitle() {
        return getString(this.zza.zzq);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.zzi(this);
    }

    @NonNull
    public final String toString() {
        return PlayerEntity.zzk(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        new PlayerEntity(this).writeToParcel(parcel, i10);
    }

    @Override // com.google.android.gms.games.Player
    public final int zza() {
        return getInteger(this.zza.zzh);
    }

    @Override // com.google.android.gms.games.Player
    public final long zzb() {
        String str = this.zza.zzF;
        if (!hasColumn(str) || hasNull(str)) {
            return -1L;
        }
        return getLong(str);
    }

    @Override // com.google.android.gms.games.Player
    @Nullable
    public final com.google.android.gms.games.internal.player.zza zzc() {
        if (hasNull(this.zza.zzs)) {
            return null;
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final String zzd() {
        return getString(this.zza.zzz);
    }

    @Override // com.google.android.gms.games.Player
    @NonNull
    public final String zze() {
        return getString(this.zza.zzA);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzf() {
        return getBoolean(this.zza.zzy);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzg() {
        return hasColumn(this.zza.zzL) && getBoolean(this.zza.zzL);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzh() {
        return getBoolean(this.zza.zzr);
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzb, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(@NonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzq, charArrayBuffer);
    }
}

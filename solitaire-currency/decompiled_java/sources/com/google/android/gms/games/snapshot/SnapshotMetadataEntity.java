package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataEntityCreator")
@SafeParcelable.Reserved({1000})
public final class SnapshotMetadataEntity extends zzh implements SnapshotMetadata {

    @NonNull
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new zzd();

    @SafeParcelable.Field(getter = "getGame", id = 1)
    private final GameEntity zza;

    @SafeParcelable.Field(getter = "getOwner", id = 2)
    private final PlayerEntity zzb;

    @SafeParcelable.Field(getter = "getSnapshotId", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getCoverImageUri", id = 5)
    private final Uri zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getCoverImageUrl", id = 6)
    private final String zze;

    @SafeParcelable.Field(getter = "getTitle", id = 7)
    private final String zzf;

    @SafeParcelable.Field(getter = "getDescription", id = 8)
    private final String zzg;

    @SafeParcelable.Field(getter = "getLastModifiedTimestamp", id = 9)
    private final long zzh;

    @SafeParcelable.Field(getter = "getPlayedTime", id = 10)
    private final long zzi;

    @SafeParcelable.Field(getter = "getCoverImageAspectRatio", id = 11)
    private final float zzj;

    @SafeParcelable.Field(getter = "getUniqueName", id = 12)
    private final String zzk;

    @SafeParcelable.Field(getter = "hasChangePending", id = 13)
    private final boolean zzl;

    @SafeParcelable.Field(getter = "getProgressValue", id = 14)
    private final long zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getDeviceName", id = 15)
    private final String zzn;

    @SafeParcelable.Constructor
    SnapshotMetadataEntity(@SafeParcelable.Param(id = 1) GameEntity gameEntity, @SafeParcelable.Param(id = 2) PlayerEntity playerEntity, @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 5) Uri uri, @Nullable @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) long j10, @SafeParcelable.Param(id = 10) long j11, @SafeParcelable.Param(id = 11) float f10, @SafeParcelable.Param(id = 12) String str5, @SafeParcelable.Param(id = 13) boolean z10, @SafeParcelable.Param(id = 14) long j12, @Nullable @SafeParcelable.Param(id = 15) String str6) {
        this.zza = gameEntity;
        this.zzb = playerEntity;
        this.zzc = str;
        this.zzd = uri;
        this.zze = str2;
        this.zzj = f10;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = j10;
        this.zzi = j11;
        this.zzk = str5;
        this.zzl = z10;
        this.zzm = j12;
        this.zzn = str6;
    }

    static int zzb(SnapshotMetadata snapshotMetadata) {
        return Objects.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.zza(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static String zzc(SnapshotMetadata snapshotMetadata) {
        return Objects.toStringHelper(snapshotMetadata).add("Game", snapshotMetadata.getGame()).add("Owner", snapshotMetadata.getOwner()).add("SnapshotId", snapshotMetadata.getSnapshotId()).add("CoverImageUri", snapshotMetadata.getCoverImageUri()).add("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).add("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).add("Description", snapshotMetadata.getDescription()).add("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).add("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).add("UniqueName", snapshotMetadata.getUniqueName()).add("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).add("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).add("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    static boolean zzd(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return Objects.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && Objects.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && Objects.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && Objects.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && Objects.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && Objects.equal(snapshotMetadata2.zza(), snapshotMetadata.zza()) && Objects.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && Objects.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && Objects.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && Objects.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && Objects.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && Objects.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && Objects.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    public boolean equals(@Nullable Object obj) {
        return zzd(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public SnapshotMetadata freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public float getCoverImageAspectRatio() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @Nullable
    public Uri getCoverImageUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @Nullable
    public String getCoverImageUrl() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public String getDescription() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public String getDeviceName() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public Game getGame() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getLastModifiedTimestamp() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public Player getOwner() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getPlayedTime() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getProgressValue() {
        return this.zzm;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public String getSnapshotId() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public String getUniqueName() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean hasChangePending() {
        return this.zzl;
    }

    public int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @NonNull
    public String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getOwner(), i10, false);
        SafeParcelWriter.writeString(parcel, 3, getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getCoverImageUri(), i10, false);
        SafeParcelWriter.writeString(parcel, 6, getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 9, getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getPlayedTime());
        SafeParcelWriter.writeFloat(parcel, 11, getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel, 12, getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel, 13, hasChangePending());
        SafeParcelWriter.writeLong(parcel, 14, getProgressValue());
        SafeParcelWriter.writeString(parcel, 15, getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    @NonNull
    public final String zza() {
        return this.zzf;
    }

    public SnapshotMetadataEntity(@NonNull SnapshotMetadata snapshotMetadata) {
        PlayerEntity playerEntity = new PlayerEntity(snapshotMetadata.getOwner());
        this.zza = new GameEntity(snapshotMetadata.getGame());
        this.zzb = playerEntity;
        this.zzc = snapshotMetadata.getSnapshotId();
        this.zzd = snapshotMetadata.getCoverImageUri();
        this.zze = snapshotMetadata.getCoverImageUrl();
        this.zzj = snapshotMetadata.getCoverImageAspectRatio();
        this.zzf = snapshotMetadata.zza();
        this.zzg = snapshotMetadata.getDescription();
        this.zzh = snapshotMetadata.getLastModifiedTimestamp();
        this.zzi = snapshotMetadata.getPlayedTime();
        this.zzk = snapshotMetadata.getUniqueName();
        this.zzl = snapshotMetadata.hasChangePending();
        this.zzm = snapshotMetadata.getProgressValue();
        this.zzn = snapshotMetadata.getDeviceName();
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ SnapshotMetadata freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzg, charArrayBuffer);
    }
}

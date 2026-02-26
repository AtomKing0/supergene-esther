package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataChangeCreator")
@SafeParcelable.Reserved({1000})
public final class SnapshotMetadataChangeEntity extends zzh implements SnapshotMetadataChange {

    @NonNull
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();

    @SafeParcelable.Field(getter = "getDescription", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getPlayedTimeMillis", id = 2)
    private final Long zzb;

    @SafeParcelable.Field(getter = "getCoverImageUri", id = 4)
    private final Uri zzc;

    @SafeParcelable.Field(getter = "getCoverImageTeleporter", id = 5)
    private BitmapTeleporter zzd;

    @SafeParcelable.Field(getter = "getProgressValue", id = 6)
    private final Long zze;

    SnapshotMetadataChangeEntity() {
        this(null, null, null, null, null);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    @Nullable
    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzd;
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    @Nullable
    public final String getDescription() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    @Nullable
    public final Long getPlayedTimeMillis() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    @Nullable
    public final Long getProgressValue() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLongObject(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i10, false);
        SafeParcelWriter.writeLongObject(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    @Nullable
    public final BitmapTeleporter zza() {
        return this.zzd;
    }

    @SafeParcelable.Constructor
    SnapshotMetadataChangeEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Long l10, @SafeParcelable.Param(id = 5) BitmapTeleporter bitmapTeleporter, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 6) Long l11) {
        this.zza = str;
        this.zzb = l10;
        this.zzd = bitmapTeleporter;
        this.zzc = uri;
        this.zze = l11;
        boolean z10 = true;
        if (bitmapTeleporter != null && uri != null) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Cannot set both a URI and an image");
    }
}

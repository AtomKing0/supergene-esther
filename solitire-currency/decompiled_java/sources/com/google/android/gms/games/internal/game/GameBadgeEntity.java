package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "GameBadgeEntityCreator")
@SafeParcelable.Reserved({1000})
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {

    @NonNull
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zzb();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private int zza;

    @SafeParcelable.Field(getter = "getTitle", id = 2)
    private String zzb;

    @SafeParcelable.Field(getter = "getDescription", id = 3)
    private String zzc;

    @SafeParcelable.Field(getter = "getIconImageUri", id = 4)
    private Uri zzd;

    @SafeParcelable.Constructor
    GameBadgeEntity(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) Uri uri) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zzaVar = (zza) obj;
        return Objects.equal(Integer.valueOf(zzaVar.zza()), this.zzb) && Objects.equal(zzaVar.zzb(), this.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @NonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(this.zza)).add("Title", this.zzb).add("Description", this.zzc).add("IconImageUri", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        if (shouldDowngrade()) {
            parcel.writeInt(this.zza);
            parcel.writeString(this.zzb);
            parcel.writeString(this.zzc);
            Uri uri = this.zzd;
            parcel.writeString(uri == null ? null : uri.toString());
            return;
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    @NonNull
    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }
}

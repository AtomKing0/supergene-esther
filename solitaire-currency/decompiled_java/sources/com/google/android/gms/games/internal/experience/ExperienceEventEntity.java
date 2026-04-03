package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ExperienceEventEntityCreator")
@SafeParcelable.Reserved({1000})
public final class ExperienceEventEntity extends zzh implements ExperienceEvent {

    @NonNull
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();

    @SafeParcelable.Field(getter = "getExperienceId", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getGame", id = 2)
    private final GameEntity zzb;

    @SafeParcelable.Field(getter = "getDisplayTitle", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getDisplayDescription", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getIconImageUrl", id = 5)
    private final String zze;

    @SafeParcelable.Field(getter = "getIconImageUri", id = 6)
    private final Uri zzf;

    @SafeParcelable.Field(getter = "getCreatedTimestamp", id = 7)
    private final long zzg;

    @SafeParcelable.Field(getter = "getXpEarned", id = 8)
    private final long zzh;

    @SafeParcelable.Field(getter = "getCurrentXp", id = 9)
    private final long zzi;

    @SafeParcelable.Field(getter = "getType", id = 10)
    private final int zzj;

    @SafeParcelable.Field(getter = "getNewLevel", id = 11)
    private final int zzk;

    @SafeParcelable.Constructor
    ExperienceEventEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) GameEntity gameEntity, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) long j10, @SafeParcelable.Param(id = 8) long j11, @SafeParcelable.Param(id = 9) long j12, @SafeParcelable.Param(id = 10) int i10, @SafeParcelable.Param(id = 11) int i11) {
        this.zza = str;
        this.zzb = gameEntity;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = uri;
        this.zzg = j10;
        this.zzh = j11;
        this.zzi = j12;
        this.zzj = i10;
        this.zzk = i11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ExperienceEvent)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ExperienceEvent experienceEvent = (ExperienceEvent) obj;
        return Objects.equal(experienceEvent.zzj(), this.zza) && Objects.equal(experienceEvent.zzg(), this.zzb) && Objects.equal(experienceEvent.zzi(), this.zzc) && Objects.equal(experienceEvent.zzh(), this.zzd) && Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && Objects.equal(experienceEvent.zzf(), this.zzf) && Objects.equal(Long.valueOf(experienceEvent.zzc()), Long.valueOf(this.zzg)) && Objects.equal(Long.valueOf(experienceEvent.zze()), Long.valueOf(this.zzh)) && Objects.equal(Long.valueOf(experienceEvent.zzd()), Long.valueOf(this.zzi)) && Objects.equal(Integer.valueOf(experienceEvent.zzb()), Integer.valueOf(this.zzj)) && Objects.equal(Integer.valueOf(experienceEvent.zza()), Integer.valueOf(this.zzk));
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public String getIconImageUrl() {
        return this.zze;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, getIconImageUrl(), this.zzf, Long.valueOf(this.zzg), Long.valueOf(this.zzh), Long.valueOf(this.zzi), Integer.valueOf(this.zzj), Integer.valueOf(this.zzk));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @NonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", this.zza).add("Game", this.zzb).add("DisplayTitle", this.zzc).add("DisplayDescription", this.zzd).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", this.zzf).add("CreatedTimestamp", Long.valueOf(this.zzg)).add("XpEarned", Long.valueOf(this.zzh)).add("CurrentXp", Long.valueOf(this.zzi)).add("Type", Integer.valueOf(this.zzj)).add("NewLevel", Integer.valueOf(this.zzk)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i10, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i10, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeLong(parcel, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zza() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzb() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public final Uri zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public final Game zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public final String zzh() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public final String zzi() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    @NonNull
    public final String zzj() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ ExperienceEvent freeze() {
        return this;
    }
}

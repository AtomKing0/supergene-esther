package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AchievementEntityCreator")
@SafeParcelable.Reserved({1000})
public final class AchievementEntity extends zzh implements Achievement {

    @NonNull
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();

    @SafeParcelable.Field(getter = "getAchievementId", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getDescription", id = 4)
    private final String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getUnlockedImageUri", id = 5)
    private final Uri zze;

    @Nullable
    @SafeParcelable.Field(getter = "getUnlockedImageUrl", id = 6)
    private final String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getRevealedImageUri", id = 7)
    private final Uri zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getRevealedImageUrl", id = 8)
    private final String zzh;

    @SafeParcelable.Field(getter = "getTotalStepsRaw", id = 9)
    private final int zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getFormattedTotalStepsRaw", id = 10)
    private final String zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getPlayerInternal", id = 11)
    private final PlayerEntity zzk;

    @SafeParcelable.Field(getter = "getState", id = 12)
    private final int zzl;

    @SafeParcelable.Field(getter = "getCurrentStepsRaw", id = 13)
    private final int zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getFormattedCurrentStepsRaw", id = 14)
    private final String zzn;

    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", id = 15)
    private final long zzo;

    @SafeParcelable.Field(getter = "getXpValue", id = 16)
    private final long zzp;

    @SafeParcelable.Field(defaultValue = "-1.0f", getter = "getRarityPercent", id = 17)
    private final float zzq;

    @SafeParcelable.Field(getter = "getApplicationId", id = 18)
    private final String zzr;

    public AchievementEntity(@NonNull Achievement achievement) {
        String achievementId = achievement.getAchievementId();
        this.zza = achievementId;
        this.zzb = achievement.getType();
        this.zzc = achievement.getName();
        String description = achievement.getDescription();
        this.zzd = description;
        this.zze = achievement.getUnlockedImageUri();
        this.zzf = achievement.getUnlockedImageUrl();
        this.zzg = achievement.getRevealedImageUri();
        this.zzh = achievement.getRevealedImageUrl();
        Player playerZzb = achievement.zzb();
        if (playerZzb != null) {
            this.zzk = new PlayerEntity(playerZzb);
        } else {
            this.zzk = null;
        }
        this.zzl = achievement.getState();
        this.zzo = achievement.getLastUpdatedTimestamp();
        this.zzp = achievement.getXpValue();
        this.zzq = achievement.zza();
        this.zzr = achievement.zzc();
        if (achievement.getType() == 1) {
            this.zzi = achievement.getTotalSteps();
            this.zzj = achievement.getFormattedTotalSteps();
            this.zzm = achievement.getCurrentSteps();
            this.zzn = achievement.getFormattedCurrentSteps();
        } else {
            this.zzi = 0;
            this.zzj = null;
            this.zzm = 0;
            this.zzn = null;
        }
        Asserts.checkNotNull(achievementId);
        Asserts.checkNotNull(description);
    }

    static int zzd(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            currentSteps = 0;
            totalSteps = 0;
        }
        return Objects.hashCode(achievement.getAchievementId(), achievement.zzc(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzb(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static String zze(Achievement achievement) {
        Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(achievement).add("Id", achievement.getAchievementId()).add("Game Id", achievement.zzc()).add("Type", Integer.valueOf(achievement.getType())).add("Name", achievement.getName()).add("Description", achievement.getDescription()).add("Player", achievement.zzb()).add("State", Integer.valueOf(achievement.getState())).add("Rarity Percent", Float.valueOf(achievement.zza()));
        if (achievement.getType() == 1) {
            toStringHelperAdd.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            toStringHelperAdd.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return toStringHelperAdd.toString();
    }

    static boolean zzf(Achievement achievement, @Nullable Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && Objects.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && Objects.equal(achievement2.zzc(), achievement.zzc()) && Objects.equal(achievement2.getName(), achievement.getName()) && Objects.equal(achievement2.getDescription(), achievement.getDescription()) && Objects.equal(achievement2.zzb(), achievement.zzb()) && achievement2.zza() == achievement.zza();
    }

    public boolean equals(@Nullable Object obj) {
        return zzf(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public String getAchievementId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzm;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public String getDescription() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public String getFormattedCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzn;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public String getFormattedTotalSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzj;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public String getName() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public Player getPlayer() {
        return (Player) Preconditions.checkNotNull(this.zzk);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public Uri getRevealedImageUri() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public String getRevealedImageUrl() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzi;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public Uri getUnlockedImageUri() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public String getUnlockedImageUrl() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzp;
    }

    public int hashCode() {
        return zzd(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @NonNull
    public String toString() {
        return zze(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i10, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i10, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i10, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.zzq);
        SafeParcelWriter.writeString(parcel, 18, this.zzr, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        return this.zzq;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @Nullable
    public final Player zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    @NonNull
    public final String zzc() {
        return this.zzr;
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getDescription(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzd, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(@NonNull CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(@NonNull CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getName(@NonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @SafeParcelable.Constructor
    AchievementEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) Uri uri, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Uri uri2, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) int i11, @SafeParcelable.Param(id = 10) String str6, @Nullable @SafeParcelable.Param(id = 11) PlayerEntity playerEntity, @SafeParcelable.Param(id = 12) int i12, @SafeParcelable.Param(id = 13) int i13, @SafeParcelable.Param(id = 14) String str7, @SafeParcelable.Param(id = 15) long j10, @SafeParcelable.Param(id = 16) long j11, @SafeParcelable.Param(id = 17) float f10, @SafeParcelable.Param(id = 18) String str8) {
        this.zza = str;
        this.zzb = i10;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = uri2;
        this.zzh = str5;
        this.zzi = i11;
        this.zzj = str6;
        this.zzk = playerEntity;
        this.zzl = i12;
        this.zzm = i13;
        this.zzn = str7;
        this.zzo = j10;
        this.zzp = j11;
        this.zzq = f10;
        this.zzr = str8;
    }
}

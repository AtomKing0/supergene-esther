package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;
import com.google.android.gms.games.zzw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ProfileSettingsEntityCreator")
@SafeParcelable.Reserved({1000})
public class ProfileSettingsEntity extends zzh implements zzw {

    @NonNull
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zza;

    @SafeParcelable.Field(getter = "getGamerTag", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "isGamerTagExplicitlySet", id = 3)
    private final boolean zzc;

    @SafeParcelable.Field(getter = "isProfileVisible", id = 4)
    private final boolean zzd;

    @SafeParcelable.Field(getter = "isVisibilityExplicitlySet", id = 5)
    private final boolean zze;

    @SafeParcelable.Field(getter = "getStockProfileImage", id = 6)
    private final StockProfileImageEntity zzf;

    @SafeParcelable.Field(getter = "isProfileDiscoverable", id = 7)
    private final boolean zzg;

    @SafeParcelable.Field(getter = "isAutoSignInEnabled", id = 8)
    private final boolean zzh;

    @SafeParcelable.Field(getter = "getHttpErrorCode", id = 9)
    private final int zzi;

    @SafeParcelable.Field(getter = "isSettingsChangesProhibited", id = 10)
    private final boolean zzj;

    @SafeParcelable.Field(getter = "allowFriendInvites", id = 11)
    private final boolean zzk;

    @SafeParcelable.Field(getter = "getProfileVisibility", id = 12)
    private final int zzl;

    @SafeParcelable.Field(getter = "getGlobalFriendsListVisibility", id = 13)
    private final int zzm;

    @SafeParcelable.Field(getter = "isAlwaysAutoSignIn", id = 14)
    private final boolean zzn;

    @SafeParcelable.Constructor
    public ProfileSettingsEntity(@NonNull @SafeParcelable.Param(id = 1) Status status, @NonNull @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z10, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) boolean z12, @NonNull @SafeParcelable.Param(id = 6) StockProfileImageEntity stockProfileImageEntity, @SafeParcelable.Param(id = 7) boolean z13, @SafeParcelable.Param(id = 8) boolean z14, @SafeParcelable.Param(id = 9) int i10, @SafeParcelable.Param(id = 10) boolean z15, @SafeParcelable.Param(id = 11) boolean z16, @SafeParcelable.Param(id = 12) int i11, @SafeParcelable.Param(id = 13) int i12, @SafeParcelable.Param(id = 14) boolean z17) {
        this.zza = status;
        this.zzb = str;
        this.zzc = z10;
        this.zzd = z11;
        this.zze = z12;
        this.zzf = stockProfileImageEntity;
        this.zzg = z13;
        this.zzh = z14;
        this.zzi = i10;
        this.zzj = z15;
        this.zzk = z16;
        this.zzl = i11;
        this.zzm = i12;
        this.zzn = z17;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzw)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzw zzwVar = (zzw) obj;
        return Objects.equal(this.zzb, zzwVar.zze()) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzwVar.zzi())) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzwVar.zzk())) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(zzwVar.zzm())) && Objects.equal(this.zza, zzwVar.getStatus()) && Objects.equal(this.zzf, zzwVar.zzd()) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(zzwVar.zzj())) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzwVar.zzh())) && this.zzi == zzwVar.zzb() && this.zzj == zzwVar.zzl() && this.zzk == zzwVar.zzf() && this.zzl == zzwVar.zzc() && this.zzm == zzwVar.zza() && this.zzn == zzwVar.zzg();
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public final Status getStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zza, this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), Boolean.valueOf(this.zzn));
    }

    @NonNull
    public final String toString() {
        return Objects.toStringHelper(this).add("GamerTag", this.zzb).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzc)).add("IsProfileVisible", Boolean.valueOf(this.zzd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zze)).add("Status", this.zza).add("StockProfileImage", this.zzf).add("IsProfileDiscoverable", Boolean.valueOf(this.zzg)).add("AutoSignIn", Boolean.valueOf(this.zzh)).add("httpErrorCode", Integer.valueOf(this.zzi)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzj)).add("AllowFriendInvites", Boolean.valueOf(this.zzk)).add("ProfileVisibility", Integer.valueOf(this.zzl)).add("global_friends_list_visibility", Integer.valueOf(this.zzm)).add("always_auto_sign_in", Boolean.valueOf(this.zzn)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i10, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzn);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.zzw
    public final int zza() {
        return this.zzm;
    }

    @Override // com.google.android.gms.games.zzw
    public final int zzb() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.zzw
    public final int zzc() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.zzw
    @NonNull
    public final StockProfileImage zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.zzw
    @NonNull
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzg() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzh() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzi() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzj() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzk() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzl() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.zzw
    public final boolean zzm() {
        return this.zze;
    }
}

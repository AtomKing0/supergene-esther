package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20, 33})
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzp();

    @Nullable
    @SafeParcelable.Field(id = 2)
    public final String zza;

    @SafeParcelable.Field(id = 32)
    public final int zzaa;

    @SafeParcelable.Field(id = 34)
    public final long zzab;

    @Nullable
    @SafeParcelable.Field(id = 35)
    public final String zzac;

    @SafeParcelable.Field(defaultValue = "", id = 36)
    public final String zzad;

    @SafeParcelable.Field(id = 13)
    @Deprecated
    private final long zzae;

    @Nullable
    @SafeParcelable.Field(id = 24)
    private final String zzaf;

    @Nullable
    @SafeParcelable.Field(id = 3)
    public final String zzb;

    @Nullable
    @SafeParcelable.Field(id = 4)
    public final String zzc;

    @Nullable
    @SafeParcelable.Field(id = 5)
    public final String zzd;

    @SafeParcelable.Field(id = 6)
    public final long zze;

    @SafeParcelable.Field(id = 7)
    public final long zzf;

    @Nullable
    @SafeParcelable.Field(id = 8)
    public final String zzg;

    @SafeParcelable.Field(defaultValue = com.ironsource.mediationsdk.metadata.a.f13688g, id = 9)
    public final boolean zzh;

    @SafeParcelable.Field(id = 10)
    public final boolean zzi;

    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzj;

    @Nullable
    @SafeParcelable.Field(id = 12)
    public final String zzk;

    @SafeParcelable.Field(id = 14)
    public final long zzl;

    @SafeParcelable.Field(id = 15)
    public final int zzm;

    @SafeParcelable.Field(defaultValue = com.ironsource.mediationsdk.metadata.a.f13688g, id = 16)
    public final boolean zzn;

    @SafeParcelable.Field(id = 18)
    public final boolean zzo;

    @Nullable
    @SafeParcelable.Field(id = 19)
    public final String zzp;

    @Nullable
    @SafeParcelable.Field(id = 21)
    public final Boolean zzq;

    @SafeParcelable.Field(id = 22)
    public final long zzr;

    @Nullable
    @SafeParcelable.Field(id = 23)
    public final List<String> zzs;

    @SafeParcelable.Field(defaultValue = "", id = 25)
    public final String zzt;

    @SafeParcelable.Field(defaultValue = "", id = 26)
    public final String zzu;

    @Nullable
    @SafeParcelable.Field(id = 27)
    public final String zzv;

    @SafeParcelable.Field(defaultValue = "false", id = 28)
    public final boolean zzw;

    @SafeParcelable.Field(id = 29)
    public final long zzx;

    @SafeParcelable.Field(defaultValue = "100", id = 30)
    public final int zzy;

    @SafeParcelable.Field(defaultValue = "", id = 31)
    public final String zzz;

    zzn(@Nullable String str, @Nullable String str2, @Nullable String str3, long j10, @Nullable String str4, long j11, long j12, @Nullable String str5, boolean z10, boolean z11, @Nullable String str6, long j13, long j14, int i10, boolean z12, boolean z13, @Nullable String str7, @Nullable Boolean bool, long j15, @Nullable List<String> list, @Nullable String str8, String str9, String str10, @Nullable String str11, boolean z14, long j16, int i11, String str12, int i12, long j17, @Nullable String str13, String str14) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j10;
        this.zzd = str4;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = str5;
        this.zzh = z10;
        this.zzi = z11;
        this.zzk = str6;
        this.zzae = j13;
        this.zzl = j14;
        this.zzm = i10;
        this.zzn = z12;
        this.zzo = z13;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j15;
        this.zzs = list;
        this.zzaf = null;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z14;
        this.zzx = j16;
        this.zzy = i11;
        this.zzz = str12;
        this.zzaa = i12;
        this.zzab = j17;
        this.zzac = str13;
        this.zzad = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzae);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.writeString(parcel, 19, this.zzp, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzr);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzaf, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzv, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzw);
        SafeParcelWriter.writeLong(parcel, 29, this.zzx);
        SafeParcelWriter.writeInt(parcel, 30, this.zzy);
        SafeParcelWriter.writeString(parcel, 31, this.zzz, false);
        SafeParcelWriter.writeInt(parcel, 32, this.zzaa);
        SafeParcelWriter.writeLong(parcel, 34, this.zzab);
        SafeParcelWriter.writeString(parcel, 35, this.zzac, false);
        SafeParcelWriter.writeString(parcel, 36, this.zzad, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzn(@Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3, @Nullable @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j10, @SafeParcelable.Param(id = 7) long j11, @Nullable @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z10, @SafeParcelable.Param(id = 10) boolean z11, @SafeParcelable.Param(id = 11) long j12, @Nullable @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j13, @SafeParcelable.Param(id = 14) long j14, @SafeParcelable.Param(id = 15) int i10, @SafeParcelable.Param(id = 16) boolean z12, @SafeParcelable.Param(id = 18) boolean z13, @Nullable @SafeParcelable.Param(id = 19) String str7, @Nullable @SafeParcelable.Param(id = 21) Boolean bool, @SafeParcelable.Param(id = 22) long j15, @Nullable @SafeParcelable.Param(id = 23) List<String> list, @Nullable @SafeParcelable.Param(id = 24) String str8, @SafeParcelable.Param(id = 25) String str9, @SafeParcelable.Param(id = 26) String str10, @SafeParcelable.Param(id = 27) String str11, @SafeParcelable.Param(id = 28) boolean z14, @SafeParcelable.Param(id = 29) long j16, @SafeParcelable.Param(id = 30) int i11, @SafeParcelable.Param(id = 31) String str12, @SafeParcelable.Param(id = 32) int i12, @SafeParcelable.Param(id = 34) long j17, @Nullable @SafeParcelable.Param(id = 35) String str13, @SafeParcelable.Param(id = 36) String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j12;
        this.zzd = str4;
        this.zze = j10;
        this.zzf = j11;
        this.zzg = str5;
        this.zzh = z10;
        this.zzi = z11;
        this.zzk = str6;
        this.zzae = j13;
        this.zzl = j14;
        this.zzm = i10;
        this.zzn = z12;
        this.zzo = z13;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j15;
        this.zzs = list;
        this.zzaf = str8;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z14;
        this.zzx = j16;
        this.zzy = i11;
        this.zzz = str12;
        this.zzaa = i12;
        this.zzab = j17;
        this.zzac = str13;
        this.zzad = str14;
    }
}

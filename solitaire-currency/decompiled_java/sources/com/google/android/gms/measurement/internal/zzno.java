package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzno extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzno> CREATOR = new zznr();

    @SafeParcelable.Field(id = 2)
    public final String zza;

    @SafeParcelable.Field(id = 3)
    public final long zzb;

    @Nullable
    @SafeParcelable.Field(id = 4)
    public final Long zzc;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final String zzd;

    @SafeParcelable.Field(id = 7)
    public final String zze;

    @Nullable
    @SafeParcelable.Field(id = 8)
    public final Double zzf;

    @SafeParcelable.Field(id = 1)
    private final int zzg;

    @Nullable
    @SafeParcelable.Field(id = 5)
    private final Float zzh;

    zzno(zznq zznqVar) {
        this(zznqVar.zzc, zznqVar.zzd, zznqVar.zze, zznqVar.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzg);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zze, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Nullable
    public final Object zza() {
        Long l10 = this.zzc;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.zzf;
        if (d10 != null) {
            return d10;
        }
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        return null;
    }

    zzno(String str, long j10, @Nullable Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zzg = 2;
        this.zza = str;
        this.zzb = j10;
        this.zze = str2;
        if (obj == null) {
            this.zzc = null;
            this.zzh = null;
            this.zzf = null;
            this.zzd = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzc = (Long) obj;
            this.zzh = null;
            this.zzf = null;
            this.zzd = null;
            return;
        }
        if (obj instanceof String) {
            this.zzc = null;
            this.zzh = null;
            this.zzf = null;
            this.zzd = (String) obj;
            return;
        }
        if (!(obj instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
        this.zzc = null;
        this.zzh = null;
        this.zzf = (Double) obj;
        this.zzd = null;
    }

    @SafeParcelable.Constructor
    zzno(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j10, @Nullable @SafeParcelable.Param(id = 4) Long l10, @SafeParcelable.Param(id = 5) Float f10, @Nullable @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @Nullable @SafeParcelable.Param(id = 8) Double d10) {
        this.zzg = i10;
        this.zza = str;
        this.zzb = j10;
        this.zzc = l10;
        this.zzh = null;
        if (i10 == 1) {
            this.zzf = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.zzf = d10;
        }
        this.zzd = str2;
        this.zze = str3;
    }
}

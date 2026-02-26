package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@SafeParcelable.Class(creator = "ChangesAvailableOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    @SafeParcelable.Field(id = 2)
    private final int zzbw;

    @SafeParcelable.Field(id = 3)
    private final boolean zzbx;

    @SafeParcelable.Field(id = 4)
    private final List<DriveSpace> zzby;

    @SafeParcelable.Constructor
    zze(@SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) boolean z10, @NonNull @SafeParcelable.Param(id = 4) List<DriveSpace> list) {
        this.zzbw = i10;
        this.zzbx = z10;
        this.zzby = list;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zze.class) {
            if (obj == this) {
                return true;
            }
            zze zzeVar = (zze) obj;
            if (Objects.equal(this.zzby, zzeVar.zzby) && this.zzbw == zzeVar.zzbw && this.zzbx == zzeVar.zzbx) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzby, Integer.valueOf(this.zzbw), Boolean.valueOf(this.zzbx));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzbw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbx);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

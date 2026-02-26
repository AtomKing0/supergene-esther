package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.TransferPreferences;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "ParcelableTransferPreferencesCreator")
@SafeParcelable.Reserved({1})
public final class zzgo extends AbstractSafeParcelable implements TransferPreferences {
    public static final Parcelable.Creator<zzgo> CREATOR = new zzgp();

    @SafeParcelable.Field(id = 4)
    private final boolean zzbm;

    @SafeParcelable.Field(id = 3)
    private final int zzbn;

    @SafeParcelable.Field(id = 2)
    private final int zzgy;

    @SafeParcelable.Constructor
    zzgo(@SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) boolean z10) {
        this.zzgy = i10;
        this.zzbn = i11;
        this.zzbm = z10;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getBatteryUsagePreference() {
        return this.zzbn;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getNetworkPreference() {
        return this.zzgy;
    }

    @Override // com.google.android.gms.drive.TransferPreferences
    public final boolean isRoamingAllowed() {
        return this.zzbm;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbm);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

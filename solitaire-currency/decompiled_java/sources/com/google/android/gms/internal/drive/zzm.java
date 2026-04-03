package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.ironsource.mediationsdk.metadata.a;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    @SafeParcelable.Field(id = 6)
    private final String zzan;

    @SafeParcelable.Field(id = 5)
    private final boolean zzao;

    @SafeParcelable.Field(defaultValue = a.f13688g, id = 10)
    private final boolean zzat;

    @SafeParcelable.Field(id = 2)
    private final DriveId zzdd;

    @SafeParcelable.Field(id = 3)
    private final MetadataBundle zzde;

    @Nullable
    @SafeParcelable.Field(id = 4)
    private final Contents zzdf;

    @SafeParcelable.Field(id = 7)
    private final int zzdg;

    @SafeParcelable.Field(id = 8)
    private final int zzdh;

    @SafeParcelable.Field(id = 9)
    private final boolean zzdi;

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(id = 4) Contents contents, @SafeParcelable.Param(id = 5) boolean z10, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i10, @SafeParcelable.Param(id = 8) int i11, @SafeParcelable.Param(id = 9) boolean z11, @SafeParcelable.Param(id = 10) boolean z12) {
        this.zzdd = driveId;
        this.zzde = metadataBundle;
        this.zzdf = contents;
        this.zzao = z10;
        this.zzan = str;
        this.zzdg = i10;
        this.zzdh = i11;
        this.zzdi = z11;
        this.zzat = z12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzao);
        SafeParcelWriter.writeString(parcel, 6, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzdg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzat);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i10, boolean z10, com.google.android.gms.drive.zzn zznVar) {
        this(driveId, metadataBundle, null, zznVar.zzm(), zznVar.zzl(), zznVar.zzn(), i10, z10, zznVar.zzp());
    }
}

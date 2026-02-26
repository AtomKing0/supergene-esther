package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "QueryResultEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzo extends com.google.android.gms.drive.zzu implements DriveEvent {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    @Nullable
    @SafeParcelable.Field(id = 2)
    private final DataHolder zzav;

    @SafeParcelable.Field(id = 3)
    private final boolean zzcq;

    @SafeParcelable.Field(id = 4)
    private final int zzcr;

    @SafeParcelable.Constructor
    public zzo(@Nullable @SafeParcelable.Param(id = 2) DataHolder dataHolder, @SafeParcelable.Param(id = 3) boolean z10, @SafeParcelable.Param(id = 4) int i10) {
        this.zzav = dataHolder;
        this.zzcq = z10;
        this.zzcr = i10;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 3;
    }

    @Override // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzav, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzcq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcr);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zzaa() {
        return this.zzcq;
    }

    public final int zzab() {
        return this.zzcr;
    }

    @Nullable
    public final DataHolder zzz() {
        return this.zzav;
    }
}

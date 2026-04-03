package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "OnEventResponseCreator")
@SafeParcelable.Reserved({1, 4, 8})
public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();

    @SafeParcelable.Field(id = 2)
    private final int zzda;

    @SafeParcelable.Field(id = 3)
    private final ChangeEvent zzib;

    @SafeParcelable.Field(id = 5)
    private final CompletionEvent zzic;

    @SafeParcelable.Field(id = 6)
    private final com.google.android.gms.drive.events.zzo zzid;

    @SafeParcelable.Field(id = 7)
    private final com.google.android.gms.drive.events.zzb zzie;

    @SafeParcelable.Field(id = 9)
    private final com.google.android.gms.drive.events.zzv zzif;

    @SafeParcelable.Field(id = 10)
    private final com.google.android.gms.drive.events.zzr zzig;

    @SafeParcelable.Constructor
    zzfp(@SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) ChangeEvent changeEvent, @SafeParcelable.Param(id = 5) CompletionEvent completionEvent, @SafeParcelable.Param(id = 6) com.google.android.gms.drive.events.zzo zzoVar, @SafeParcelable.Param(id = 7) com.google.android.gms.drive.events.zzb zzbVar, @SafeParcelable.Param(id = 9) com.google.android.gms.drive.events.zzv zzvVar, @SafeParcelable.Param(id = 10) com.google.android.gms.drive.events.zzr zzrVar) {
        this.zzda = i10;
        this.zzib = changeEvent;
        this.zzic = completionEvent;
        this.zzid = zzoVar;
        this.zzie = zzbVar;
        this.zzif = zzvVar;
        this.zzig = zzrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzib, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzic, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzid, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzie, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzif, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzig, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final DriveEvent zzat() {
        int i10 = this.zzda;
        if (i10 == 1) {
            return this.zzib;
        }
        if (i10 == 2) {
            return this.zzic;
        }
        if (i10 == 3) {
            return this.zzid;
        }
        if (i10 == 4) {
            return this.zzie;
        }
        if (i10 == 7) {
            return this.zzif;
        }
        if (i10 == 8) {
            return this.zzig;
        }
        int i11 = this.zzda;
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unexpected event type ");
        sb.append(i11);
        throw new IllegalStateException(sb.toString());
    }
}

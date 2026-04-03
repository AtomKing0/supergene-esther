package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "ConsentParcelCreator")
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzak();

    @SafeParcelable.Field(id = 1)
    public final Bundle zza;

    @SafeParcelable.Constructor
    public zzal(@SafeParcelable.Param(id = 1) Bundle bundle) {
        this.zza = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

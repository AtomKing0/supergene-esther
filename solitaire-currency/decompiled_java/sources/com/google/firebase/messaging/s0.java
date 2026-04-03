package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: RemoteMessageCreator.java */
/* JADX INFO: loaded from: classes3.dex */
public class s0 implements Parcelable.Creator<r0> {
    static void c(r0 r0Var, Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, r0Var.f10468a, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // android.os.Parcelable.Creator
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public r0 createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundleCreateBundle = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new r0(bundleCreateBundle);
    }

    @Override // android.os.Parcelable.Creator
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r0[] newArray(int i10) {
        return new r0[i10];
    }
}

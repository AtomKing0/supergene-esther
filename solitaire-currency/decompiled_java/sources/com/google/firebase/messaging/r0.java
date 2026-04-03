package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.d;
import java.util.Map;

/* JADX INFO: compiled from: RemoteMessage.java */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class r0 extends AbstractSafeParcelable {
    public static final Parcelable.Creator<r0> CREATOR = new s0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    Bundle f10468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f10469b;

    @SafeParcelable.Constructor
    public r0(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f10468a = bundle;
    }

    void a(Intent intent) {
        intent.putExtras(this.f10468a);
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.f10469b == null) {
            this.f10469b = d.a.a(this.f10468a);
        }
        return this.f10469b;
    }

    @Nullable
    public String getTo() {
        return this.f10468a.getString("google.to");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        s0.c(this, parcel, i10);
    }
}

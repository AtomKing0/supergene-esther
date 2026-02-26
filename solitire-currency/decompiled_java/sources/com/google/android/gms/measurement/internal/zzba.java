package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzba extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbc();

    @SafeParcelable.Field(getter = "z", id = 2)
    private final Bundle zza;

    @SafeParcelable.Constructor
    zzba(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final Bundle zzb() {
        return new Bundle(this.zza);
    }

    final Object zzc(String str) {
        return this.zza.get(str);
    }

    final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final int zza() {
        return this.zza.size();
    }

    final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    final Double zza(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }
}

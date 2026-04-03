package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();

    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequestUpdateData.OPERATION_ADD", getter = "getOperation", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationRequest", id = 2)
    private final zzeg zzb;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationListenerAsBinder", id = 3, type = "android.os.IBinder")
    private final com.google.android.gms.location.zzz zzc;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationCallbackAsBinder", id = 5, type = "android.os.IBinder")
    private final com.google.android.gms.location.zzw zzd;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getPendingIntent", id = 4)
    private final PendingIntent zze;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackAsBinder", id = 6, type = "android.os.IBinder")
    private final zzr zzf;

    @Nullable
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getListenerId", id = 8)
    private final String zzg;

    @SafeParcelable.Constructor
    zzei(@SafeParcelable.Param(id = 1) int i10, @Nullable @SafeParcelable.Param(id = 2) zzeg zzegVar, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 5) IBinder iBinder2, @Nullable @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @Nullable @SafeParcelable.Param(id = 6) IBinder iBinder3, @Nullable @SafeParcelable.Param(id = 8) String str) {
        this.zza = i10;
        this.zzb = zzegVar;
        zzr zzpVar = null;
        this.zzc = iBinder != null ? com.google.android.gms.location.zzy.zzb(iBinder) : null;
        this.zze = pendingIntent;
        this.zzd = iBinder2 != null ? com.google.android.gms.location.zzv.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzpVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder3);
        }
        this.zzf = zzpVar;
        this.zzg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i10, false);
        com.google.android.gms.location.zzz zzzVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzzVar == null ? null : zzzVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i10, false);
        com.google.android.gms.location.zzw zzwVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 5, zzwVar == null ? null : zzwVar.asBinder(), false);
        zzr zzrVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 6, zzrVar != null ? zzrVar.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

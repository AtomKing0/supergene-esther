package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzer;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "DeviceOrientationRequestCreator")
@SafeParcelable.Reserved({1, 3, 4, 5})
public final class DeviceOrientationRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DeviceOrientationRequest> CREATOR = new zzn();
    public static final long OUTPUT_PERIOD_DEFAULT = 20000;
    public static final long OUTPUT_PERIOD_FAST = 5000;
    public static final long OUTPUT_PERIOD_MEDIUM = 10000;

    @SafeParcelable.Field(getter = "getSamplingPeriodMicros", id = 2)
    private final long zza;

    @SafeParcelable.Field(defaultValueUnchecked = "false", getter = "isVelocityEnabled", id = 6)
    private final boolean zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
    public static final class Builder {
        private long zza;
        private final boolean zzb;

        public Builder(long j10) {
            this.zzb = false;
            setSamplingPeriodMicros(j10);
        }

        @NonNull
        public DeviceOrientationRequest build() {
            return new DeviceOrientationRequest(this.zza, this.zzb);
        }

        @NonNull
        public Builder setSamplingPeriodMicros(long j10) {
            boolean z10 = false;
            if (j10 >= 0 && j10 < Long.MAX_VALUE) {
                z10 = true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j10).length() + 102);
            sb.append("Invalid interval: ");
            sb.append(j10);
            sb.append(" should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
            zzer.zzb(z10, sb.toString());
            this.zza = j10;
            return this;
        }

        public Builder(@NonNull DeviceOrientationRequest deviceOrientationRequest) {
            this.zza = deviceOrientationRequest.zza();
            this.zzb = deviceOrientationRequest.zzb();
        }
    }

    @SafeParcelable.Constructor
    DeviceOrientationRequest(@SafeParcelable.Param(id = 2) long j10, @SafeParcelable.Param(id = 6) boolean z10) {
        this.zza = j10;
        this.zzb = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientationRequest)) {
            return false;
        }
        DeviceOrientationRequest deviceOrientationRequest = (DeviceOrientationRequest) obj;
        return this.zza == deviceOrientationRequest.zza && this.zzb == deviceOrientationRequest.zzb;
    }

    public long getSamplingPeriodMicros() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    @NonNull
    public String toString() {
        long j10 = this.zza;
        int length = String.valueOf(j10).length();
        String str = true != this.zzb ? "" : ", withVelocity";
        StringBuilder sb = new StringBuilder(length + 46 + str.length() + 1);
        sb.append("DeviceOrientationRequest[samplingPeriodMicros=");
        sb.append(j10);
        sb.append(str);
        sb.append(v8.i.f15839e);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getSamplingPeriodMicros());
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ long zza() {
        return this.zza;
    }

    final /* synthetic */ boolean zzb() {
        return this.zzb;
    }
}

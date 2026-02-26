package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "VideoCapabilitiesCreator")
@SafeParcelable.Reserved({1000})
public final class VideoCapabilities extends zzh {

    @NonNull
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();

    @SafeParcelable.Field(getter = "isCameraSupported", id = 1)
    private final boolean zza;

    @SafeParcelable.Field(getter = "isMicSupported", id = 2)
    private final boolean zzb;

    @SafeParcelable.Field(getter = "isWriteStorageSupported", id = 3)
    private final boolean zzc;

    @SafeParcelable.Field(getter = "getSupportedCaptureModes", id = 4)
    private final boolean[] zzd;

    @SafeParcelable.Field(getter = "getSupportedQualityLevels", id = 5)
    private final boolean[] zze;

    @SafeParcelable.Constructor
    public VideoCapabilities(@SafeParcelable.Param(id = 1) boolean z10, @SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) boolean z12, @NonNull @SafeParcelable.Param(id = 4) boolean[] zArr, @NonNull @SafeParcelable.Param(id = 5) boolean[] zArr2) {
        this.zza = z10;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = zArr;
        this.zze = zArr2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return Objects.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Objects.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    @NonNull
    public boolean[] getSupportedCaptureModes() {
        return this.zzd;
    }

    @NonNull
    public boolean[] getSupportedQualityLevels() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean isCameraSupported() {
        return this.zza;
    }

    public boolean isFullySupported(int i10, int i11) {
        return this.zza && this.zzb && this.zzc && supportsCaptureMode(i10) && supportsQualityLevel(i11);
    }

    public boolean isMicSupported() {
        return this.zzb;
    }

    public boolean isWriteStorageSupported() {
        return this.zzc;
    }

    public boolean supportsCaptureMode(int i10) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(i10, false));
        return this.zzd[i10];
    }

    public boolean supportsQualityLevel(int i10) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(i10, false));
        return this.zze[i10];
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("SupportedCaptureModes", getSupportedCaptureModes()).add("SupportedQualityLevels", getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(isCameraSupported())).add("MicSupported", Boolean.valueOf(isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

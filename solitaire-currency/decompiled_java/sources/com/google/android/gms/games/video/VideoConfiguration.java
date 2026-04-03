package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "VideoConfigurationCreator")
@SafeParcelable.Reserved({1000})
public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;

    @NonNull
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new zzb();
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;

    @SafeParcelable.Field(getter = "getQualityLevel", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getCaptureMode", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "shouldShowToastAfterRecording", id = 7)
    private final boolean zzc;

    @SafeParcelable.Field(getter = "getCameraEnabled", id = 8)
    private final boolean zzd;

    @SafeParcelable.Field(getter = "getMicEnabled", id = 9)
    private final boolean zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class Builder {
        private int zza;
        private int zzb;
        private boolean zzd = true;
        private boolean zze = true;
        private boolean zzc = true;

        public Builder(int i10, int i11) {
            this.zza = i10;
            this.zzb = i11;
        }

        @NonNull
        public VideoConfiguration build() {
            return new VideoConfiguration(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder setCameraEnabled(boolean z10) {
            this.zzd = z10;
            return this;
        }

        @NonNull
        public Builder setCaptureMode(int i10) {
            this.zzb = i10;
            return this;
        }

        @NonNull
        public Builder setMicEnabled(boolean z10) {
            this.zze = z10;
            return this;
        }

        @NonNull
        public Builder setQualityLevel(int i10) {
            this.zza = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ValidCaptureModes {
    }

    @SafeParcelable.Constructor
    public VideoConfiguration(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 7) boolean z10, @SafeParcelable.Param(id = 8) boolean z11, @SafeParcelable.Param(id = 9) boolean z12) {
        Preconditions.checkArgument(isValidQualityLevel(i10, false));
        Preconditions.checkArgument(isValidCaptureMode(i11, false));
        this.zza = i10;
        this.zzb = i11;
        this.zzc = z10;
        this.zzd = z11;
        this.zze = z12;
    }

    public static boolean isValidCaptureMode(int i10, boolean z10) {
        if (i10 != -1) {
            z10 = true;
            if (i10 != 0 && i10 != 1) {
                return false;
            }
        }
        return z10;
    }

    public static boolean isValidQualityLevel(int i10, boolean z10) {
        if (i10 != -1) {
            z10 = true;
            if (i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
                return false;
            }
        }
        return z10;
    }

    public boolean getCameraEnabled() {
        return this.zzd;
    }

    public int getCaptureMode() {
        return this.zzb;
    }

    public boolean getMicEnabled() {
        return this.zze;
    }

    public int getQualityLevel() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getQualityLevel());
        SafeParcelWriter.writeInt(parcel, 2, getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 8, getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel, 9, getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

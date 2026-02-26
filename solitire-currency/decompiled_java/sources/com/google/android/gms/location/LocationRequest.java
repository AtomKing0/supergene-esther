package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzeo;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 14, 1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzaf();

    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;

    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;

    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;

    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;

    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 1)
    private int zza;

    @SafeParcelable.Field(defaultValue = "3600000", getter = "getIntervalMillis", id = 2)
    private long zzb;

    @SafeParcelable.Field(defaultValue = "600000", getter = "getMinUpdateIntervalMillis", id = 3)
    private long zzc;

    @SafeParcelable.Field(defaultValue = "0", getter = "getMaxUpdateDelayMillis", id = 8)
    private long zzd;

    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 10)
    private long zze;

    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MAX_VALUE", getter = "getMaxUpdates", id = 6)
    private int zzf;

    @SafeParcelable.Field(defaultValue = "0", getter = "getMinUpdateDistanceMeters", id = 7)
    private float zzg;

    @SafeParcelable.Field(defaultValue = "false", getter = "isWaitForAccurateLocation", id = 9)
    private boolean zzh;

    @SafeParcelable.Field(defaultValueUnchecked = "-1", getter = "getMaxUpdateAgeMillis", id = 11)
    private long zzi;

    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 12)
    private final int zzj;

    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 13)
    private final int zzk;

    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 15)
    private final boolean zzl;

    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 16)
    private final WorkSource zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getImpersonation", id = 17)
    private final com.google.android.gms.internal.location.zze zzn;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    @NonNull
    @Deprecated
    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    private static String zze(long j10) {
        return j10 == Long.MAX_VALUE ? "∞" : zzeo.zzb(j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzl == locationRequest.zzl && this.zzm.equals(locationRequest.zzm) && Objects.equal(this.zzn, locationRequest.zzn)))) {
                return true;
            }
        }
        return false;
    }

    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    public long getExpirationTime() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.zze;
        long j11 = jElapsedRealtime + j10;
        if (((jElapsedRealtime ^ j11) & (j10 ^ j11)) < 0) {
            return Long.MAX_VALUE;
        }
        return j11;
    }

    @Deprecated
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    public long getInterval() {
        return getIntervalMillis();
    }

    public long getIntervalMillis() {
        return this.zzb;
    }

    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzm);
    }

    public boolean isBatched() {
        long j10 = this.zzd;
        return j10 > 0 && (j10 >> 1) >= this.zzb;
    }

    @Deprecated
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationDuration(long j10) {
        Preconditions.checkArgument(j10 > 0, "durationMillis must be greater than 0");
        this.zze = j10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationTime(long j10) {
        this.zze = Math.max(1L, j10 - SystemClock.elapsedRealtime());
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setFastestInterval(long j10) {
        Preconditions.checkArgument(j10 >= 0, "illegal fastest interval: %d", Long.valueOf(j10));
        this.zzc = j10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setInterval(long j10) {
        Preconditions.checkArgument(j10 >= 0, "intervalMillis must be greater than or equal to 0");
        long j11 = this.zzc;
        long j12 = this.zzb;
        if (j11 == j12 / 6) {
            this.zzc = j10 / 6;
        }
        if (this.zzi == j12) {
            this.zzi = j10;
        }
        this.zzb = j10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setMaxWaitTime(long j10) {
        Preconditions.checkArgument(j10 >= 0, "illegal max wait time: %d", Long.valueOf(j10));
        this.zzd = j10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setNumUpdates(int i10) {
        if (i10 > 0) {
            this.zzf = i10;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 20);
        sb.append("invalid numUpdates: ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }

    @NonNull
    @Deprecated
    public LocationRequest setPriority(int i10) {
        zzan.zza(i10);
        this.zza = i10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setSmallestDisplacement(float f10) {
        if (f10 >= 0.0f) {
            this.zzg = f10;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(f10).length() + 22);
        sb.append("invalid displacement: ");
        sb.append(f10);
        throw new IllegalArgumentException(sb.toString());
    }

    @NonNull
    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z10) {
        this.zzh = z10;
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzan.zzb(this.zza));
            if (this.zzd > 0) {
                sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
                zzeo.zzc(this.zzd, sb);
            }
        } else {
            sb.append("@");
            if (isBatched()) {
                zzeo.zzc(this.zzb, sb);
                sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
                zzeo.zzc(this.zzd, sb);
            } else {
                zzeo.zzc(this.zzb, sb);
            }
            sb.append(" ");
            sb.append(zzan.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zze(this.zzc));
        }
        if (this.zzg > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(zze(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzeo.zzc(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzar.zzb(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzq.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzl) {
            sb.append(", bypass");
        }
        if (!WorkSourceUtil.isEmpty(this.zzm)) {
            sb.append(", ");
            sb.append(this.zzm);
        }
        if (this.zzn != null) {
            sb.append(", impersonation=");
            sb.append(this.zzn);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzl);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzm, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzn, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzk;
    }

    public final boolean zzb() {
        return this.zzl;
    }

    @NonNull
    public final WorkSource zzc() {
        return this.zzm;
    }

    @Nullable
    public final com.google.android.gms.internal.location.zze zzd() {
        return this.zzn;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private boolean zzl;

        @Nullable
        private WorkSource zzm;

        @Nullable
        private com.google.android.gms.internal.location.zze zzn;

        public Builder(int i10, long j10) {
            this(j10);
            setPriority(i10);
        }

        @NonNull
        public LocationRequest build() {
            int i10 = this.zza;
            long j10 = this.zzb;
            long jMin = this.zzc;
            if (jMin == -1) {
                jMin = j10;
            } else if (i10 != 105) {
                jMin = Math.min(jMin, j10);
            }
            long jMax = Math.max(this.zzd, this.zzb);
            long j11 = this.zze;
            int i11 = this.zzf;
            float f10 = this.zzg;
            boolean z10 = this.zzh;
            long j12 = this.zzi;
            return new LocationRequest(i10, j10, jMin, jMax, Long.MAX_VALUE, j11, i11, f10, z10, j12 == -1 ? this.zzb : j12, this.zzj, this.zzk, this.zzl, new WorkSource(this.zzm), this.zzn);
        }

        @NonNull
        public Builder setDurationMillis(long j10) {
            Preconditions.checkArgument(j10 > 0, "durationMillis must be greater than 0");
            this.zze = j10;
            return this;
        }

        @NonNull
        public Builder setGranularity(int i10) {
            zzq.zza(i10);
            this.zzj = i10;
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(long j10) {
            Preconditions.checkArgument(j10 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j10;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j10;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(long j10) {
            Preconditions.checkArgument(j10 >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j10;
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(int i10) {
            Preconditions.checkArgument(i10 > 0, "maxUpdates must be greater than 0");
            this.zzf = i10;
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(float f10) {
            Preconditions.checkArgument(f10 >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f10;
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j10;
            return this;
        }

        @NonNull
        public Builder setPriority(int i10) {
            zzan.zza(i10);
            this.zza = i10;
            return this;
        }

        @NonNull
        public Builder setWaitForAccurateLocation(boolean z10) {
            this.zzh = z10;
            return this;
        }

        @NonNull
        public final Builder zza(int i10) {
            zzar.zza(i10);
            this.zzk = i10;
            return this;
        }

        @NonNull
        @RequiresPermission(anyOf = {"android.permission.WRITE_SECURE_SETTINGS", "android.permission.LOCATION_BYPASS"})
        public final Builder zzb(boolean z10) {
            this.zzl = z10;
            return this;
        }

        @NonNull
        @RequiresPermission("android.permission.UPDATE_DEVICE_STATS")
        public final Builder zzc(@Nullable WorkSource workSource) {
            this.zzm = workSource;
            return this;
        }

        public Builder(long j10) {
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = false;
            this.zzm = null;
            this.zzn = null;
            setIntervalMillis(j10);
        }

        public Builder(@NonNull LocationRequest locationRequest) {
            this(locationRequest.getPriority(), locationRequest.getIntervalMillis());
            setMinUpdateIntervalMillis(locationRequest.getMinUpdateIntervalMillis());
            setMaxUpdateDelayMillis(locationRequest.getMaxUpdateDelayMillis());
            setDurationMillis(locationRequest.getDurationMillis());
            setMaxUpdates(locationRequest.getMaxUpdates());
            setMinUpdateDistanceMeters(locationRequest.getMinUpdateDistanceMeters());
            setWaitForAccurateLocation(locationRequest.isWaitForAccurateLocation());
            setMaxUpdateAgeMillis(locationRequest.getMaxUpdateAgeMillis());
            setGranularity(locationRequest.getGranularity());
            int iZza = locationRequest.zza();
            zzar.zza(iZza);
            this.zzk = iZza;
            this.zzl = locationRequest.zzb();
            this.zzm = locationRequest.zzc();
            com.google.android.gms.internal.location.zze zzeVarZzd = locationRequest.zzd();
            boolean z10 = true;
            if (zzeVarZzd != null && zzeVarZzd.zza()) {
                z10 = false;
            }
            Preconditions.checkArgument(z10);
            this.zzn = zzeVarZzd;
        }
    }

    @SafeParcelable.Constructor
    LocationRequest(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) long j10, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 8) long j12, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 5) long j13, @SafeParcelable.Param(id = 10) long j14, @SafeParcelable.Param(id = 6) int i11, @SafeParcelable.Param(id = 7) float f10, @SafeParcelable.Param(id = 9) boolean z10, @SafeParcelable.Param(id = 11) long j15, @SafeParcelable.Param(id = 12) int i12, @SafeParcelable.Param(id = 13) int i13, @SafeParcelable.Param(id = 15) boolean z11, @SafeParcelable.Param(id = 16) WorkSource workSource, @Nullable @SafeParcelable.Param(id = 17) com.google.android.gms.internal.location.zze zzeVar) {
        long j16;
        this.zza = i10;
        if (i10 == 105) {
            this.zzb = Long.MAX_VALUE;
            j16 = j10;
        } else {
            j16 = j10;
            this.zzb = j16;
        }
        this.zzc = j11;
        this.zzd = j12;
        this.zze = j13 == Long.MAX_VALUE ? j14 : Math.min(Math.max(1L, j13 - SystemClock.elapsedRealtime()), j14);
        this.zzf = i11;
        this.zzg = f10;
        this.zzh = z10;
        this.zzi = j15 != -1 ? j15 : j16;
        this.zzj = i12;
        this.zzk = i13;
        this.zzl = z11;
        this.zzm = workSource;
        this.zzn = zzeVar;
    }
}

package androidx.work;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.compose.foundation.e;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d0;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Constraints.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Constraints {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Constraints NONE = new Constraints(null, false, false, false, 15, null);

    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;

    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;

    @ColumnInfo(name = "content_uri_triggers")
    @NotNull
    private final Set<ContentUriTrigger> contentUriTriggers;

    @ColumnInfo(name = "required_network_type")
    @NotNull
    private final NetworkType requiredNetworkType;

    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;

    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;

    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;

    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    /* JADX INFO: compiled from: Constraints.kt */
    public static final class Builder {

        @NotNull
        private Set<ContentUriTrigger> contentUriTriggers;

        @NotNull
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }

        @RequiresApi(24)
        @NotNull
        public final Builder addContentUriTrigger(@NotNull Uri uri, boolean z10) {
            t.i(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z10));
            return this;
        }

        @NotNull
        public final Constraints build() {
            Set setE;
            long j10;
            long j11;
            if (Build.VERSION.SDK_INT >= 24) {
                setE = d0.T0(this.contentUriTriggers);
                j10 = this.triggerContentUpdateDelay;
                j11 = this.triggerContentMaxDelay;
            } else {
                setE = z0.e();
                j10 = -1;
                j11 = -1;
            }
            return new Constraints(this.requiredNetworkType, this.requiresCharging, this.requiresDeviceIdle, this.requiresBatteryNotLow, this.requiresStorageNotLow, j10, j11, setE);
        }

        @NotNull
        public final Builder setRequiredNetworkType(@NotNull NetworkType networkType) {
            t.i(networkType, "networkType");
            this.requiredNetworkType = networkType;
            return this;
        }

        @NotNull
        public final Builder setRequiresBatteryNotLow(boolean z10) {
            this.requiresBatteryNotLow = z10;
            return this;
        }

        @NotNull
        public final Builder setRequiresCharging(boolean z10) {
            this.requiresCharging = z10;
            return this;
        }

        @RequiresApi(23)
        @NotNull
        public final Builder setRequiresDeviceIdle(boolean z10) {
            this.requiresDeviceIdle = z10;
            return this;
        }

        @NotNull
        public final Builder setRequiresStorageNotLow(boolean z10) {
            this.requiresStorageNotLow = z10;
            return this;
        }

        @RequiresApi(24)
        @NotNull
        public final Builder setTriggerContentMaxDelay(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(24)
        @NotNull
        public final Builder setTriggerContentUpdateDelay(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(26)
        @NotNull
        public final Builder setTriggerContentMaxDelay(@NotNull Duration duration) {
            t.i(duration, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        @NotNull
        public final Builder setTriggerContentUpdateDelay(@NotNull Duration duration) {
            t.i(duration, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NotNull Constraints constraints) {
            t.i(constraints, "constraints");
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints.requiresCharging();
            int i10 = Build.VERSION.SDK_INT;
            this.requiresDeviceIdle = constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (i10 >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = d0.S0(constraints.getContentUriTriggers());
            }
        }
    }

    /* JADX INFO: compiled from: Constraints.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Constraints.kt */
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;

        @NotNull
        private final Uri uri;

        public ContentUriTrigger(@NotNull Uri uri, boolean z10) {
            t.i(uri, "uri");
            this.uri = uri;
            this.isTriggeredForDescendants = z10;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!t.d(ContentUriTrigger.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            t.g(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return t.d(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants;
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + e.a(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z10, boolean z11, boolean z12, int i10, k kVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(Constraints.class, obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && this.requiredNetworkType == constraints.requiredNetworkType) {
            return t.d(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @RequiresApi(24)
    @NotNull
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    @NotNull
    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        return Build.VERSION.SDK_INT < 24 || (this.contentUriTriggers.isEmpty() ^ true);
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        int iHashCode = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long j10 = this.contentTriggerUpdateDelayMillis;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.contentTriggerMaxDelayMillis;
        return ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.contentUriTriggers.hashCode();
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    @SuppressLint({"NewApi"})
    @NotNull
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    @Ignore
    public Constraints(@NotNull NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12) {
        this(requiredNetworkType, z10, false, z11, z12);
        t.i(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z10, boolean z11, boolean z12, boolean z13, int i10, k kVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) == 0 ? z13 : false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(23)
    @SuppressLint({"NewApi"})
    @Ignore
    public Constraints(@NotNull NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12, boolean z13) {
        this(requiredNetworkType, z10, z11, z12, z13, -1L, 0L, null, PsExtractor.AUDIO_STREAM, null);
        t.i(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, Set set, int i10, k kVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) == 0 ? z13 : false, (i10 & 32) != 0 ? -1L : j10, (i10 & 64) == 0 ? j11 : -1L, (i10 & 128) != 0 ? z0.e() : set);
    }

    @RequiresApi(24)
    public Constraints(@NotNull NetworkType requiredNetworkType, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, @NotNull Set<ContentUriTrigger> contentUriTriggers) {
        t.i(requiredNetworkType, "requiredNetworkType");
        t.i(contentUriTriggers, "contentUriTriggers");
        this.requiredNetworkType = requiredNetworkType;
        this.requiresCharging = z10;
        this.requiresDeviceIdle = z11;
        this.requiresBatteryNotLow = z12;
        this.requiresStorageNotLow = z13;
        this.contentTriggerUpdateDelayMillis = j10;
        this.contentTriggerMaxDelayMillis = j11;
        this.contentUriTriggers = contentUriTriggers;
    }

    @SuppressLint({"NewApi"})
    public Constraints(@NotNull Constraints other) {
        t.i(other, "other");
        this.requiresCharging = other.requiresCharging;
        this.requiresDeviceIdle = other.requiresDeviceIdle;
        this.requiredNetworkType = other.requiredNetworkType;
        this.requiresBatteryNotLow = other.requiresBatteryNotLow;
        this.requiresStorageNotLow = other.requiresStorageNotLow;
        this.contentUriTriggers = other.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = other.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = other.contentTriggerMaxDelayMillis;
    }
}

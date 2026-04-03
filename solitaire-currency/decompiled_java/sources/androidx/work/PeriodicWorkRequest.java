package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PeriodicWorkRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    /* JADX INFO: compiled from: PeriodicWorkRequest.kt */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull Class<? extends ListenableWorker> workerClass, long j10, @NotNull TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            t.i(workerClass, "workerClass");
            t.i(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j10));
        }

        @NotNull
        public final Builder clearNextScheduleTimeOverride() {
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        @NotNull
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @NotNull
        public final Builder setNextScheduleTimeOverride(long j10) {
            if (!(j10 != Long.MAX_VALUE)) {
                throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time".toString());
            }
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(j10);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        @NotNull
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (!((getBackoffCriteriaSet$work_runtime_release() && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) ? false : true)) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
            }
            if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@NotNull Class<? extends ListenableWorker> workerClass, @NotNull Duration repeatInterval) {
            super(workerClass);
            t.i(workerClass, "workerClass");
            t.i(repeatInterval, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull Class<? extends ListenableWorker> workerClass, long j10, @NotNull TimeUnit repeatIntervalTimeUnit, long j11, @NotNull TimeUnit flexIntervalTimeUnit) {
            super(workerClass);
            t.i(workerClass, "workerClass");
            t.i(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            t.i(flexIntervalTimeUnit, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j10), flexIntervalTimeUnit.toMillis(j11));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@NotNull Class<? extends ListenableWorker> workerClass, @NotNull Duration repeatInterval, @NotNull Duration flexInterval) {
            super(workerClass);
            t.i(workerClass, "workerClass");
            t.i(repeatInterval, "repeatInterval");
            t.i(flexInterval, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval), DurationApi26Impl.toMillisCompat(flexInterval));
        }
    }

    /* JADX INFO: compiled from: PeriodicWorkRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(@NotNull Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        t.i(builder, "builder");
    }
}

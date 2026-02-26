package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WorkRequest {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;

    @NotNull
    private final UUID id;

    @NotNull
    private final Set<String> tags;

    @NotNull
    private final WorkSpec workSpec;

    /* JADX INFO: compiled from: WorkRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public WorkRequest(@NotNull UUID id, @NotNull WorkSpec workSpec, @NotNull Set<String> tags) {
        t.i(id, "id");
        t.i(workSpec, "workSpec");
        t.i(tags, "tags");
        this.id = id;
        this.workSpec = workSpec;
        this.tags = tags;
    }

    @NotNull
    public UUID getId() {
        return this.id;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final String getStringId() {
        String string = getId().toString();
        t.h(string, "id.toString()");
        return string;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final Set<String> getTags() {
        return this.tags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    /* JADX INFO: compiled from: WorkRequest.kt */
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;

        @NotNull
        private UUID id;

        @NotNull
        private final Set<String> tags;

        @NotNull
        private WorkSpec workSpec;

        @NotNull
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(@NotNull Class<? extends ListenableWorker> workerClass) {
            t.i(workerClass, "workerClass");
            this.workerClass = workerClass;
            UUID uuidRandomUUID = UUID.randomUUID();
            t.h(uuidRandomUUID, "randomUUID()");
            this.id = uuidRandomUUID;
            String string = this.id.toString();
            t.h(string, "id.toString()");
            String name = workerClass.getName();
            t.h(name, "workerClass.name");
            this.workSpec = new WorkSpec(string, name);
            String name2 = workerClass.getName();
            t.h(name2, "workerClass.name");
            this.tags = z0.f(name2);
        }

        @NotNull
        public final B addTag(@NotNull String tag) {
            t.i(tag, "tag");
            this.tags.add(tag);
            return (B) getThisObject$work_runtime_release();
        }

        @NotNull
        public final W build() {
            W w10 = (W) buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            boolean z10 = (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) || constraints.requiresBatteryNotLow() || constraints.requiresCharging() || constraints.requiresDeviceIdle();
            WorkSpec workSpec = this.workSpec;
            if (workSpec.expedited) {
                if (!(!z10)) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
                if (!(workSpec.initialDelay <= 0)) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            t.h(uuidRandomUUID, "randomUUID()");
            setId(uuidRandomUUID);
            return w10;
        }

        @NotNull
        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        @NotNull
        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        @NotNull
        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        @NotNull
        public abstract B getThisObject$work_runtime_release();

        @NotNull
        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        @NotNull
        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        @NotNull
        public final B keepResultsForAtLeast(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        @NotNull
        public final B setBackoffCriteria(@NotNull BackoffPolicy backoffPolicy, long j10, @NotNull TimeUnit timeUnit) {
            t.i(backoffPolicy, "backoffPolicy");
            t.i(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j10));
            return (B) getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z10) {
            this.backoffCriteriaSet = z10;
        }

        @NotNull
        public final B setConstraints(@NotNull Constraints constraints) {
            t.i(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return (B) getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NotNull
        public B setExpedited(@NotNull OutOfQuotaPolicy policy) {
            t.i(policy, "policy");
            WorkSpec workSpec = this.workSpec;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = policy;
            return (B) getThisObject$work_runtime_release();
        }

        @NotNull
        public final B setId(@NotNull UUID id) {
            t.i(id, "id");
            this.id = id;
            String string = id.toString();
            t.h(string, "id.toString()");
            this.workSpec = new WorkSpec(string, this.workSpec);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(@NotNull UUID uuid) {
            t.i(uuid, "<set-?>");
            this.id = uuid;
        }

        @NotNull
        public B setInitialDelay(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j10);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return (B) getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NotNull
        public final B setInitialRunAttemptCount(int i10) {
            this.workSpec.runAttemptCount = i10;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NotNull
        public final B setInitialState(@NotNull WorkInfo.State state) {
            t.i(state, "state");
            this.workSpec.state = state;
            return (B) getThisObject$work_runtime_release();
        }

        @NotNull
        public final B setInputData(@NotNull Data inputData) {
            t.i(inputData, "inputData");
            this.workSpec.input = inputData;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NotNull
        public final B setLastEnqueueTime(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NotNull
        public final B setScheduleRequestedAt(long j10, @NotNull TimeUnit timeUnit) {
            t.i(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(@NotNull WorkSpec workSpec) {
            t.i(workSpec, "<set-?>");
            this.workSpec = workSpec;
        }

        @RequiresApi(26)
        @NotNull
        public final B keepResultsForAtLeast(@NotNull Duration duration) {
            t.i(duration, "duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        @NotNull
        public final B setBackoffCriteria(@NotNull BackoffPolicy backoffPolicy, @NotNull Duration duration) {
            t.i(backoffPolicy, "backoffPolicy");
            t.i(duration, "duration");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        @NotNull
        public B setInitialDelay(@NotNull Duration duration) {
            t.i(duration, "duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return (B) getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }
    }
}

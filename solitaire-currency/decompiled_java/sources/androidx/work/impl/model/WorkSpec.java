package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkSpec {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;

    @NotNull
    private static final String TAG;

    @NotNull
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;

    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @ColumnInfo(name = "backoff_policy")
    @NotNull
    public BackoffPolicy backoffPolicy;

    @Embedded
    @NotNull
    public Constraints constraints;

    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NotNull
    public final String id;

    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @ColumnInfo(name = "input")
    @NotNull
    public Data input;

    @ColumnInfo(name = "input_merger_class_name")
    @NotNull
    public String inputMergerClassName;

    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;

    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;

    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;

    @ColumnInfo(name = "out_of_quota_policy")
    @NotNull
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @ColumnInfo(name = "output")
    @NotNull
    public Data output;

    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;

    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @ColumnInfo(name = "state")
    @NotNull
    public WorkInfo.State state;

    @ColumnInfo(defaultValue = "-256", name = DownloadService.KEY_STOP_REASON)
    private final int stopReason;

    @ColumnInfo(name = "worker_class_name")
    @NotNull
    public String workerClassName;

    /* JADX INFO: compiled from: WorkSpec.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final long calculateNextRunTime(boolean z10, int i10, @NotNull BackoffPolicy backoffPolicy, long j10, long j11, int i11, boolean z11, long j12, long j13, long j14, long j15) {
            t.i(backoffPolicy, "backoffPolicy");
            if (j15 != Long.MAX_VALUE && z11) {
                return i11 == 0 ? j15 : o.f(j15, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + j11);
            }
            if (z10) {
                return j11 + o.k(backoffPolicy == BackoffPolicy.LINEAR ? ((long) i10) * j10 : (long) Math.scalb(j10, i10 - 1), WorkRequest.MAX_BACKOFF_MILLIS);
            }
            if (!z11) {
                if (j11 == -1) {
                    return Long.MAX_VALUE;
                }
                return j11 + j12;
            }
            long j16 = i11 == 0 ? j11 + j12 : j11 + j14;
            if ((j13 != j14) && i11 == 0) {
                j16 += j14 - j13;
            }
            return j16;
        }
    }

    /* JADX INFO: compiled from: WorkSpec.kt */
    public static final class IdAndState {

        @ColumnInfo(name = "id")
        @NotNull
        public String id;

        @ColumnInfo(name = "state")
        @NotNull
        public WorkInfo.State state;

        public IdAndState(@NotNull String id, @NotNull WorkInfo.State state) {
            t.i(id, "id");
            t.i(state, "state");
            this.id = id;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = idAndState.id;
            }
            if ((i10 & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final WorkInfo.State component2() {
            return this.state;
        }

        @NotNull
        public final IdAndState copy(@NotNull String id, @NotNull WorkInfo.State state) {
            t.i(id, "id");
            t.i(state, "state");
            return new IdAndState(id, state);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return t.d(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        @NotNull
        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        t.h(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = strTagWithPrefix;
        WORK_INFO_MAPPER = new Function() { // from class: androidx.work.impl.model.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
            }
        };
    }

    public WorkSpec(@NotNull String id, @NotNull WorkInfo.State state, @NotNull String workerClassName, @NotNull String inputMergerClassName, @NotNull Data input, @NotNull Data output, long j10, long j11, long j12, @NotNull Constraints constraints, @IntRange(from = 0) int i10, @NotNull BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, @NotNull OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, long j17, int i13, int i14) {
        t.i(id, "id");
        t.i(state, "state");
        t.i(workerClassName, "workerClassName");
        t.i(inputMergerClassName, "inputMergerClassName");
        t.i(input, "input");
        t.i(output, "output");
        t.i(constraints, "constraints");
        t.i(backoffPolicy, "backoffPolicy");
        t.i(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = inputMergerClassName;
        this.input = input;
        this.output = output;
        this.initialDelay = j10;
        this.intervalDuration = j11;
        this.flexDuration = j12;
        this.constraints = constraints;
        this.runAttemptCount = i10;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j13;
        this.lastEnqueueTime = j14;
        this.minimumRetentionDuration = j15;
        this.scheduleRequestedAt = j16;
        this.expedited = z10;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i11;
        this.generation = i12;
        this.nextScheduleTimeOverride = j17;
        this.nextScheduleTimeOverrideGeneration = i13;
        this.stopReason = i14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(w.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j10, long j11, long j12, Constraints constraints, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, long j17, int i13, int i14, int i15, Object obj) {
        String str4 = (i15 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i15 & 2) != 0 ? workSpec.state : state;
        String str5 = (i15 & 4) != 0 ? workSpec.workerClassName : str2;
        String str6 = (i15 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i15 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i15 & 32) != 0 ? workSpec.output : data2;
        long j18 = (i15 & 64) != 0 ? workSpec.initialDelay : j10;
        long j19 = (i15 & 128) != 0 ? workSpec.intervalDuration : j11;
        long j20 = (i15 & 256) != 0 ? workSpec.flexDuration : j12;
        Constraints constraints2 = (i15 & 512) != 0 ? workSpec.constraints : constraints;
        return workSpec.copy(str4, state2, str5, str6, data3, data4, j18, j19, j20, constraints2, (i15 & 1024) != 0 ? workSpec.runAttemptCount : i10, (i15 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy, (i15 & 4096) != 0 ? workSpec.backoffDelayDuration : j13, (i15 & 8192) != 0 ? workSpec.lastEnqueueTime : j14, (i15 & 16384) != 0 ? workSpec.minimumRetentionDuration : j15, (i15 & 32768) != 0 ? workSpec.scheduleRequestedAt : j16, (i15 & 65536) != 0 ? workSpec.expedited : z10, (131072 & i15) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy, (i15 & 262144) != 0 ? workSpec.periodCount : i11, (i15 & 524288) != 0 ? workSpec.generation : i12, (i15 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j17, (i15 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i13, (i15 & 4194304) != 0 ? workSpec.stopReason : i14);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    @NotNull
    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    @NotNull
    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    @NotNull
    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    @NotNull
    public final String component3() {
        return this.workerClassName;
    }

    @NotNull
    public final String component4() {
        return this.inputMergerClassName;
    }

    @NotNull
    public final Data component5() {
        return this.input;
    }

    @NotNull
    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    @NotNull
    public final WorkSpec copy(@NotNull String id, @NotNull WorkInfo.State state, @NotNull String workerClassName, @NotNull String inputMergerClassName, @NotNull Data input, @NotNull Data output, long j10, long j11, long j12, @NotNull Constraints constraints, @IntRange(from = 0) int i10, @NotNull BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, @NotNull OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, long j17, int i13, int i14) {
        t.i(id, "id");
        t.i(state, "state");
        t.i(workerClassName, "workerClassName");
        t.i(inputMergerClassName, "inputMergerClassName");
        t.i(input, "input");
        t.i(output, "output");
        t.i(constraints, "constraints");
        t.i(backoffPolicy, "backoffPolicy");
        t.i(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, inputMergerClassName, input, output, j10, j11, j12, constraints, i10, backoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicy, i11, i12, j17, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return t.d(this.id, workSpec.id) && this.state == workSpec.state && t.d(this.workerClassName, workSpec.workerClassName) && t.d(this.inputMergerClassName, workSpec.inputMergerClassName) && t.d(this.input, workSpec.input) && t.d(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && t.d(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final boolean hasConstraints() {
        return !t.d(Constraints.NONE, this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + androidx.compose.animation.a.a(this.initialDelay)) * 31) + androidx.compose.animation.a.a(this.intervalDuration)) * 31) + androidx.compose.animation.a.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + androidx.compose.animation.a.a(this.backoffDelayDuration)) * 31) + androidx.compose.animation.a.a(this.lastEnqueueTime)) * 31) + androidx.compose.animation.a.a(this.minimumRetentionDuration)) * 31) + androidx.compose.animation.a.a(this.scheduleRequestedAt)) * 31;
        boolean z10 = this.expedited;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return ((((((((((((iHashCode + r12) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + this.periodCount) * 31) + this.generation) * 31) + androidx.compose.animation.a.a(this.nextScheduleTimeOverride)) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason;
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final void setBackoffDelayDuration(long j10) {
        if (j10 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j10 < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = o.p(j10, 10000L, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j10) {
        this.nextScheduleTimeOverride = j10;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i10) {
        this.nextScheduleTimeOverrideGeneration = i10;
    }

    public final void setPeriodCount(int i10) {
        this.periodCount = i10;
    }

    public final void setPeriodic(long j10) {
        if (j10 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(o.f(j10, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), o.f(j10, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS));
    }

    @NotNull
    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    public final void setPeriodic(long j10, long j11) {
        if (j10 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = o.f(j10, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (j11 < 300000) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j11 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + j10);
        }
        this.flexDuration = o.p(j11, 300000L, this.intervalDuration);
    }

    /* JADX INFO: compiled from: WorkSpec.kt */
    public static final class WorkInfoPojo {

        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;

        @ColumnInfo(name = "backoff_policy")
        @NotNull
        private BackoffPolicy backoffPolicy;

        @Embedded
        @NotNull
        private final Constraints constraints;

        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;

        @ColumnInfo(name = "generation")
        private final int generation;

        @ColumnInfo(name = "id")
        @NotNull
        private final String id;

        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;

        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;

        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;

        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;

        @ColumnInfo(name = "output")
        @NotNull
        private final Data output;

        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        @NotNull
        private final List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;

        @ColumnInfo(name = "state")
        @NotNull
        private final WorkInfo.State state;

        @ColumnInfo(name = DownloadService.KEY_STOP_REASON)
        private final int stopReason;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {ViewHierarchyNode.JsonKeys.TAG})
        @NotNull
        private final List<String> tags;

        public WorkInfoPojo(@NotNull String id, @NotNull WorkInfo.State state, @NotNull Data output, long j10, long j11, long j12, @NotNull Constraints constraints, int i10, @NotNull BackoffPolicy backoffPolicy, long j13, long j14, int i11, int i12, long j15, int i13, @NotNull List<String> tags, @NotNull List<Data> progress) {
            t.i(id, "id");
            t.i(state, "state");
            t.i(output, "output");
            t.i(constraints, "constraints");
            t.i(backoffPolicy, "backoffPolicy");
            t.i(tags, "tags");
            t.i(progress, "progress");
            this.id = id;
            this.state = state;
            this.output = output;
            this.initialDelay = j10;
            this.intervalDuration = j11;
            this.flexDuration = j12;
            this.constraints = constraints;
            this.runAttemptCount = i10;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = j13;
            this.lastEnqueueTime = j14;
            this.periodCount = i11;
            this.generation = i12;
            this.nextScheduleTimeOverride = j15;
            this.stopReason = i13;
            this.tags = tags;
            this.progress = progress;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j10 = this.intervalDuration;
            if (j10 != 0) {
                return new WorkInfo.PeriodicityInfo(j10, this.flexDuration);
            }
            return null;
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        @NotNull
        public final List<String> component16() {
            return this.tags;
        }

        @NotNull
        public final List<Data> component17() {
            return this.progress;
        }

        @NotNull
        public final WorkInfo.State component2() {
            return this.state;
        }

        @NotNull
        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        @NotNull
        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        @NotNull
        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        @NotNull
        public final WorkInfoPojo copy(@NotNull String id, @NotNull WorkInfo.State state, @NotNull Data output, long j10, long j11, long j12, @NotNull Constraints constraints, int i10, @NotNull BackoffPolicy backoffPolicy, long j13, long j14, int i11, int i12, long j15, int i13, @NotNull List<String> tags, @NotNull List<Data> progress) {
            t.i(id, "id");
            t.i(state, "state");
            t.i(output, "output");
            t.i(constraints, "constraints");
            t.i(backoffPolicy, "backoffPolicy");
            t.i(tags, "tags");
            t.i(progress, "progress");
            return new WorkInfoPojo(id, state, output, j10, j11, j12, constraints, i10, backoffPolicy, j13, j14, i11, i12, j15, i13, tags, progress);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return t.d(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && t.d(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && t.d(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && t.d(this.tags, workInfoPojo.tags) && t.d(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        @NotNull
        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        @NotNull
        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        @NotNull
        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        @NotNull
        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        @NotNull
        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        @NotNull
        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + androidx.compose.animation.a.a(this.initialDelay)) * 31) + androidx.compose.animation.a.a(this.intervalDuration)) * 31) + androidx.compose.animation.a.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + androidx.compose.animation.a.a(this.backoffDelayDuration)) * 31) + androidx.compose.animation.a.a(this.lastEnqueueTime)) * 31) + this.periodCount) * 31) + this.generation) * 31) + androidx.compose.animation.a.a(this.nextScheduleTimeOverride)) * 31) + this.stopReason) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final boolean isBackedOff() {
            return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        }

        public final boolean isPeriodic() {
            return this.intervalDuration != 0;
        }

        public final void setBackoffDelayDuration(long j10) {
            this.backoffDelayDuration = j10;
        }

        public final void setBackoffPolicy(@NotNull BackoffPolicy backoffPolicy) {
            t.i(backoffPolicy, "<set-?>");
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long j10) {
            this.lastEnqueueTime = j10;
        }

        public final void setPeriodCount(int i10) {
            this.periodCount = i10;
        }

        @NotNull
        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        @NotNull
        public final WorkInfo toWorkInfo() {
            Data progress = this.progress.isEmpty() ^ true ? this.progress.get(0) : Data.EMPTY;
            UUID uuidFromString = UUID.fromString(this.id);
            t.h(uuidFromString, "fromString(id)");
            WorkInfo.State state = this.state;
            HashSet hashSet = new HashSet(this.tags);
            Data data = this.output;
            t.h(progress, "progress");
            return new WorkInfo(uuidFromString, state, hashSet, data, progress, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        public /* synthetic */ WorkInfoPojo(String str, WorkInfo.State state, Data data, long j10, long j11, long j12, Constraints constraints, int i10, BackoffPolicy backoffPolicy, long j13, long j14, int i11, int i12, long j15, int i13, List list, List list2, int i14, k kVar) {
            this(str, state, data, (i14 & 8) != 0 ? 0L : j10, (i14 & 16) != 0 ? 0L : j11, (i14 & 32) != 0 ? 0L : j12, constraints, i10, (i14 & 256) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i14 & 512) != 0 ? 30000L : j13, (i14 & 1024) != 0 ? 0L : j14, (i14 & 2048) != 0 ? 0 : i11, i12, j15, i13, list, list2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j10, long j11, long j12, Constraints constraints, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, long j17, int i13, int i14, int i15, k kVar) {
        String str4;
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i15 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        if ((i15 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            t.h(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i15 & 16) != 0) {
            Data EMPTY = Data.EMPTY;
            t.h(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i15 & 32) != 0) {
            Data EMPTY2 = Data.EMPTY;
            t.h(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i15 & 64) != 0 ? 0L : j10, (i15 & 128) != 0 ? 0L : j11, (i15 & 256) != 0 ? 0L : j12, (i15 & 512) != 0 ? Constraints.NONE : constraints, (i15 & 1024) != 0 ? 0 : i10, (i15 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i15 & 4096) != 0 ? 30000L : j13, (i15 & 8192) != 0 ? -1L : j14, (i15 & 16384) != 0 ? 0L : j15, (32768 & i15) != 0 ? -1L : j16, (65536 & i15) != 0 ? false : z10, (131072 & i15) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i15) != 0 ? 0 : i11, (524288 & i15) != 0 ? 0 : i12, (1048576 & i15) != 0 ? Long.MAX_VALUE : j17, (2097152 & i15) != 0 ? 0 : i13, (i15 & 4194304) != 0 ? -256 : i14);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@NotNull String id, @NotNull String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388602, null);
        t.i(id, "id");
        t.i(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@NotNull String newId, @NotNull WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, other.nextScheduleTimeOverride, other.nextScheduleTimeOverrideGeneration, other.stopReason, 524288, null);
        t.i(newId, "newId");
        t.i(other, "other");
    }
}

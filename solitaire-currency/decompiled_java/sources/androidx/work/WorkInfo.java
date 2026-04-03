package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int STOP_REASON_APP_STANDBY = 12;
    public static final int STOP_REASON_BACKGROUND_RESTRICTION = 11;
    public static final int STOP_REASON_CANCELLED_BY_APP = 1;
    public static final int STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW = 5;
    public static final int STOP_REASON_CONSTRAINT_CHARGING = 6;
    public static final int STOP_REASON_CONSTRAINT_CONNECTIVITY = 7;
    public static final int STOP_REASON_CONSTRAINT_DEVICE_IDLE = 8;
    public static final int STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW = 9;
    public static final int STOP_REASON_DEVICE_STATE = 4;
    public static final int STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED = 15;
    public static final int STOP_REASON_NOT_STOPPED = -256;
    public static final int STOP_REASON_PREEMPT = 2;
    public static final int STOP_REASON_QUOTA = 10;
    public static final int STOP_REASON_SYSTEM_PROCESSING = 14;
    public static final int STOP_REASON_TIMEOUT = 3;
    public static final int STOP_REASON_UNKNOWN = -512;
    public static final int STOP_REASON_USER = 13;

    @NotNull
    private final Constraints constraints;
    private final int generation;

    @NotNull
    private final UUID id;
    private final long initialDelayMillis;
    private final long nextScheduleTimeMillis;

    @NotNull
    private final Data outputData;

    @Nullable
    private final PeriodicityInfo periodicityInfo;

    @NotNull
    private final Data progress;
    private final int runAttemptCount;

    @NotNull
    private final State state;
    private final int stopReason;

    @NotNull
    private final Set<String> tags;

    /* JADX INFO: compiled from: WorkInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: WorkInfo.kt */
    public static final class PeriodicityInfo {
        private final long flexIntervalMillis;
        private final long repeatIntervalMillis;

        public PeriodicityInfo(long j10, long j11) {
            this.repeatIntervalMillis = j10;
            this.flexIntervalMillis = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !t.d(PeriodicityInfo.class, obj.getClass())) {
                return false;
            }
            PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
            return periodicityInfo.repeatIntervalMillis == this.repeatIntervalMillis && periodicityInfo.flexIntervalMillis == this.flexIntervalMillis;
        }

        public final long getFlexIntervalMillis() {
            return this.flexIntervalMillis;
        }

        public final long getRepeatIntervalMillis() {
            return this.repeatIntervalMillis;
        }

        public int hashCode() {
            return (androidx.compose.animation.a.a(this.repeatIntervalMillis) * 31) + androidx.compose.animation.a.a(this.flexIntervalMillis);
        }

        @NotNull
        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.repeatIntervalMillis + ", flexIntervalMillis=" + this.flexIntervalMillis + '}';
        }
    }

    /* JADX INFO: compiled from: WorkInfo.kt */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags) {
        this(id, state, tags, null, null, 0, 0, null, 0L, null, 0L, 0, 4088, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(WorkInfo.class, obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.runAttemptCount == workInfo.runAttemptCount && this.generation == workInfo.generation && t.d(this.id, workInfo.id) && this.state == workInfo.state && t.d(this.outputData, workInfo.outputData) && t.d(this.constraints, workInfo.constraints) && this.initialDelayMillis == workInfo.initialDelayMillis && t.d(this.periodicityInfo, workInfo.periodicityInfo) && this.nextScheduleTimeMillis == workInfo.nextScheduleTimeMillis && this.stopReason == workInfo.stopReason && t.d(this.tags, workInfo.tags)) {
            return t.d(this.progress, workInfo.progress);
        }
        return false;
    }

    @NotNull
    public final Constraints getConstraints() {
        return this.constraints;
    }

    public final int getGeneration() {
        return this.generation;
    }

    @NotNull
    public final UUID getId() {
        return this.id;
    }

    public final long getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    public final long getNextScheduleTimeMillis() {
        return this.nextScheduleTimeMillis;
    }

    @NotNull
    public final Data getOutputData() {
        return this.outputData;
    }

    @Nullable
    public final PeriodicityInfo getPeriodicityInfo() {
        return this.periodicityInfo;
    }

    @NotNull
    public final Data getProgress() {
        return this.progress;
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.stopReason;
    }

    @NotNull
    public final Set<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.outputData.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.runAttemptCount) * 31) + this.generation) * 31) + this.constraints.hashCode()) * 31) + androidx.compose.animation.a.a(this.initialDelayMillis)) * 31;
        PeriodicityInfo periodicityInfo = this.periodicityInfo;
        return ((((iHashCode + (periodicityInfo != null ? periodicityInfo.hashCode() : 0)) * 31) + androidx.compose.animation.a.a(this.nextScheduleTimeMillis)) * 31) + this.stopReason;
    }

    @NotNull
    public String toString() {
        return "WorkInfo{id='" + this.id + "', state=" + this.state + ", outputData=" + this.outputData + ", tags=" + this.tags + ", progress=" + this.progress + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", constraints=" + this.constraints + ", initialDelayMillis=" + this.initialDelayMillis + ", periodicityInfo=" + this.periodicityInfo + ", nextScheduleTimeMillis=" + this.nextScheduleTimeMillis + "}, stopReason=" + this.stopReason;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData) {
        this(id, state, tags, outputData, null, 0, 0, null, 0L, null, 0L, 0, 4080, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress) {
        this(id, state, tags, outputData, progress, 0, 0, null, 0L, null, 0L, 0, 4064, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10) {
        this(id, state, tags, outputData, progress, i10, 0, null, 0L, null, 0L, 0, 4032, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11) {
        this(id, state, tags, outputData, progress, i10, i11, null, 0L, null, 0L, 0, 3968, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11, @NotNull Constraints constraints) {
        this(id, state, tags, outputData, progress, i10, i11, constraints, 0L, null, 0L, 0, 3840, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
        t.i(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11, @NotNull Constraints constraints, long j10) {
        this(id, state, tags, outputData, progress, i10, i11, constraints, j10, null, 0L, 0, RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
        t.i(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11, @NotNull Constraints constraints, long j10, @Nullable PeriodicityInfo periodicityInfo) {
        this(id, state, tags, outputData, progress, i10, i11, constraints, j10, periodicityInfo, 0L, 0, 3072, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
        t.i(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11, @NotNull Constraints constraints, long j10, @Nullable PeriodicityInfo periodicityInfo, long j11) {
        this(id, state, tags, outputData, progress, i10, i11, constraints, j10, periodicityInfo, j11, 0, 2048, null);
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
        t.i(constraints, "constraints");
    }

    public WorkInfo(@NotNull UUID id, @NotNull State state, @NotNull Set<String> tags, @NotNull Data outputData, @NotNull Data progress, int i10, int i11, @NotNull Constraints constraints, long j10, @Nullable PeriodicityInfo periodicityInfo, long j11, int i12) {
        t.i(id, "id");
        t.i(state, "state");
        t.i(tags, "tags");
        t.i(outputData, "outputData");
        t.i(progress, "progress");
        t.i(constraints, "constraints");
        this.id = id;
        this.state = state;
        this.tags = tags;
        this.outputData = outputData;
        this.progress = progress;
        this.runAttemptCount = i10;
        this.generation = i11;
        this.constraints = constraints;
        this.initialDelayMillis = j10;
        this.periodicityInfo = periodicityInfo;
        this.nextScheduleTimeMillis = j11;
        this.stopReason = i12;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkInfo(UUID uuid, State state, Set set, Data data, Data data2, int i10, int i11, Constraints constraints, long j10, PeriodicityInfo periodicityInfo, long j11, int i12, int i13, k kVar) {
        Data data3;
        Data data4;
        if ((i13 & 8) != 0) {
            Data EMPTY = Data.EMPTY;
            t.h(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i13 & 16) != 0) {
            Data EMPTY2 = Data.EMPTY;
            t.h(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(uuid, state, set, data3, data4, (i13 & 32) != 0 ? 0 : i10, (i13 & 64) != 0 ? 0 : i11, (i13 & 128) != 0 ? Constraints.NONE : constraints, (i13 & 256) != 0 ? 0L : j10, (i13 & 512) != 0 ? null : periodicityInfo, (i13 & 1024) != 0 ? Long.MAX_VALUE : j11, (i13 & 2048) != 0 ? -256 : i12);
    }
}

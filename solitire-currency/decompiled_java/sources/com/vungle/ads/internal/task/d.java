package com.vungle.ads.internal.task;

import android.os.Bundle;
import com.vungle.ads.internal.util.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements Cloneable {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "JobInfo";
    private long delay;

    @NotNull
    private Bundle extras;

    @NotNull
    private final String jobTag;
    private long nextRescheduleTimeout;
    private int priority;
    private int requiredNetworkType;
    private int reschedulePolicy;
    private long rescheduleTimeout;
    private boolean updateCurrent;

    /* JADX INFO: compiled from: JobInfo.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public d(@NotNull String jobTag) {
        t.i(jobTag, "jobTag");
        this.jobTag = jobTag;
        this.extras = new Bundle();
        this.reschedulePolicy = 1;
        this.priority = 2;
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    @Nullable
    public final d copy() {
        try {
            Object objClone = super.clone();
            t.g(objClone, "null cannot be cast to non-null type com.vungle.ads.internal.task.JobInfo");
            return (d) objClone;
        } catch (CloneNotSupportedException e10) {
            p.Companion.e(TAG, "Cannot copy JobInfo " + this, e10);
            return null;
        }
    }

    public final long getDelay() {
        return this.delay;
    }

    @NotNull
    public final Bundle getExtras() {
        return this.extras;
    }

    @NotNull
    public final String getJobTag() {
        return this.jobTag;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public final long makeNextRescedule() {
        long j10 = this.rescheduleTimeout;
        if (j10 == 0) {
            return 0L;
        }
        long j11 = this.nextRescheduleTimeout;
        if (j11 == 0) {
            this.nextRescheduleTimeout = j10;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j11 * ((long) 2);
        }
        return this.nextRescheduleTimeout;
    }

    @NotNull
    public final d setDelay(long j10) {
        this.delay = j10;
        return this;
    }

    @NotNull
    public final d setExtras(@NotNull Bundle extras) {
        t.i(extras, "extras");
        this.extras = extras;
        return this;
    }

    @NotNull
    public final d setPriority(int i10) {
        this.priority = i10;
        return this;
    }

    @NotNull
    public final d setRequiredNetworkType(int i10) {
        this.requiredNetworkType = i10;
        return this;
    }

    @NotNull
    public final d setReschedulePolicy(long j10, int i10) {
        this.rescheduleTimeout = j10;
        this.reschedulePolicy = i10;
        return this;
    }

    @NotNull
    public final d setUpdateCurrent(boolean z10) {
        this.updateCurrent = z10;
        return this;
    }

    public static /* synthetic */ void getPriority$annotations() {
    }

    public static /* synthetic */ void getRequiredNetworkType$annotations() {
    }

    private static /* synthetic */ void getReschedulePolicy$annotations() {
    }
}

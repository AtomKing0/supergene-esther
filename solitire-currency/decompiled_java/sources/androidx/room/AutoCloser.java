package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.sentry.protocol.SentryStackFrame;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AutoCloser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoCloser {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;

    @NotNull
    private final Runnable autoCloser;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    @Nullable
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;

    @NotNull
    private final Runnable executeAutoCloser;

    @NotNull
    private final Executor executor;

    @NotNull
    private final Handler handler;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private long lastDecrementRefCountTimeStamp;

    @NotNull
    private final Object lock;
    private boolean manuallyClosed;

    @Nullable
    private Runnable onAutoCloseCallback;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private int refCount;

    /* JADX INFO: compiled from: AutoCloser.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public AutoCloser(long j10, @NotNull TimeUnit autoCloseTimeUnit, @NotNull Executor autoCloseExecutor) {
        kotlin.jvm.internal.t.i(autoCloseTimeUnit, "autoCloseTimeUnit");
        kotlin.jvm.internal.t.i(autoCloseExecutor, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = autoCloseTimeUnit.toMillis(j10);
        this.executor = autoCloseExecutor;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new Runnable() { // from class: androidx.room.a
            @Override // java.lang.Runnable
            public final void run() {
                AutoCloser.executeAutoCloser$lambda$0(this.f1695a);
            }
        };
        this.autoCloser = new Runnable() { // from class: androidx.room.b
            @Override // java.lang.Runnable
            public final void run() {
                AutoCloser.autoCloser$lambda$3(this.f1698a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser this$0) {
        k0 k0Var;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        synchronized (this$0.lock) {
            if (SystemClock.uptimeMillis() - this$0.lastDecrementRefCountTimeStamp < this$0.autoCloseTimeoutInMs) {
                return;
            }
            if (this$0.refCount != 0) {
                return;
            }
            Runnable runnable = this$0.onAutoCloseCallback;
            if (runnable != null) {
                runnable.run();
                k0Var = k0.f35197a;
            } else {
                k0Var = null;
            }
            if (k0Var == null) {
                throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this$0.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                supportSQLiteDatabase.close();
            }
            this$0.delegateDatabase = null;
            k0 k0Var2 = k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.executor.execute(this$0.autoCloser);
    }

    public final void closeDatabaseIfOpen() throws IOException {
        synchronized (this.lock) {
            this.manuallyClosed = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.delegateDatabase = null;
            k0 k0Var = k0.f35197a;
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            int i10 = this.refCount;
            if (!(i10 > 0)) {
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
            }
            int i11 = i10 - 1;
            this.refCount = i11;
            if (i11 == 0) {
                if (this.delegateDatabase == null) {
                    return;
                } else {
                    this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                }
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final <V> V executeRefCountingFunction(@NotNull h9.l<? super SupportSQLiteDatabase, ? extends V> block) {
        kotlin.jvm.internal.t.i(block, "block");
        try {
            return block.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    @NotNull
    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        kotlin.jvm.internal.t.A("delegateOpenHelper");
        return null;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    @Nullable
    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    @VisibleForTesting
    public final int getRefCountForTest$room_runtime_release() {
        int i10;
        synchronized (this.lock) {
            i10 = this.refCount;
        }
        return i10;
    }

    @NotNull
    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (!(!this.manuallyClosed)) {
                throw new IllegalStateException("Attempting to open already closed database.".toString());
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteDatabase writableDatabase = getDelegateOpenHelper().getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void init(@NotNull SupportSQLiteOpenHelper delegateOpenHelper) {
        kotlin.jvm.internal.t.i(delegateOpenHelper, "delegateOpenHelper");
        setDelegateOpenHelper(delegateOpenHelper);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(@NotNull Runnable onAutoClose) {
        kotlin.jvm.internal.t.i(onAutoClose, "onAutoClose");
        this.onAutoCloseCallback = onAutoClose;
    }

    public final void setDelegateDatabase$room_runtime_release(@Nullable SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    public final void setDelegateOpenHelper(@NotNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        kotlin.jvm.internal.t.i(supportSQLiteOpenHelper, "<set-?>");
        this.delegateOpenHelper = supportSQLiteOpenHelper;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j10) {
        this.lastDecrementRefCountTimeStamp = j10;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(@Nullable Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final void setRefCount$room_runtime_release(int i10) {
        this.refCount = i10;
    }
}

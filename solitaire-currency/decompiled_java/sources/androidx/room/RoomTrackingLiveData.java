package androidx.room;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RoomTrackingLiveData.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
public final class RoomTrackingLiveData<T> extends LiveData<T> {

    @NotNull
    private final Callable<T> computeFunction;

    @NotNull
    private final AtomicBoolean computing;

    @NotNull
    private final InvalidationLiveDataContainer container;

    @NotNull
    private final RoomDatabase database;
    private final boolean inTransaction;

    @NotNull
    private final AtomicBoolean invalid;

    @NotNull
    private final Runnable invalidationRunnable;

    @NotNull
    private final InvalidationTracker.Observer observer;

    @NotNull
    private final Runnable refreshRunnable;

    @NotNull
    private final AtomicBoolean registeredObserver;

    public RoomTrackingLiveData(@NotNull RoomDatabase database, @NotNull InvalidationLiveDataContainer container, boolean z10, @NotNull Callable<T> computeFunction, @NotNull final String[] tableNames) {
        kotlin.jvm.internal.t.i(database, "database");
        kotlin.jvm.internal.t.i(container, "container");
        kotlin.jvm.internal.t.i(computeFunction, "computeFunction");
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
        this.database = database;
        this.container = container;
        this.inTransaction = z10;
        this.computeFunction = computeFunction;
        this.observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NotNull Set<String> tables) {
                kotlin.jvm.internal.t.i(tables, "tables");
                ArchTaskExecutor.getInstance().executeOnMainThread(this.getInvalidationRunnable());
            }
        };
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable() { // from class: androidx.room.y
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.refreshRunnable$lambda$0(this.f1731a);
            }
        };
        this.invalidationRunnable = new Runnable() { // from class: androidx.room.z
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f1732a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        boolean zHasActiveObservers = this$0.hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            this$0.getQueryExecutor().execute(this$0.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(RoomTrackingLiveData this$0) {
        boolean z10;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (this$0.registeredObserver.compareAndSet(false, true)) {
            this$0.database.getInvalidationTracker().addWeakObserver(this$0.observer);
        }
        do {
            if (this$0.computing.compareAndSet(false, true)) {
                T tCall = null;
                z10 = false;
                while (this$0.invalid.compareAndSet(true, false)) {
                    try {
                        try {
                            tCall = this$0.computeFunction.call();
                            z10 = true;
                        } catch (Exception e10) {
                            throw new RuntimeException("Exception while computing database live data.", e10);
                        }
                    } finally {
                        this$0.computing.set(false);
                    }
                }
                if (z10) {
                    this$0.postValue(tCall);
                }
            } else {
                z10 = false;
            }
            if (!z10) {
                return;
            }
        } while (this$0.invalid.get());
    }

    @NotNull
    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    @NotNull
    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    @NotNull
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    @NotNull
    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    @NotNull
    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    @NotNull
    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    @NotNull
    public final Executor getQueryExecutor() {
        return this.inTransaction ? this.database.getTransactionExecutor() : this.database.getQueryExecutor();
    }

    @NotNull
    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    @NotNull
    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }
}

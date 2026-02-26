package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ComputableLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {

    @NotNull
    private final LiveData<T> _liveData;

    @NotNull
    private final AtomicBoolean computing;

    @NotNull
    private final Executor executor;

    @NotNull
    private final AtomicBoolean invalid;

    @NotNull
    public final Runnable invalidationRunnable;

    @NotNull
    private final LiveData<T> liveData;

    @NotNull
    public final Runnable refreshRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(ComputableLiveData this$0) {
        t.i(this$0, "this$0");
        boolean zHasActiveObservers = this$0.getLiveData().hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            this$0.executor.execute(this$0.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void refreshRunnable$lambda$0(ComputableLiveData this$0) {
        t.i(this$0, "this$0");
        do {
            boolean z10 = false;
            if (this$0.computing.compareAndSet(false, true)) {
                Object objCompute = null;
                boolean z11 = false;
                while (this$0.invalid.compareAndSet(true, false)) {
                    try {
                        objCompute = this$0.compute();
                        z11 = true;
                    } catch (Throwable th) {
                        this$0.computing.set(false);
                        throw th;
                    }
                }
                if (z11) {
                    this$0.getLiveData().postValue(objCompute);
                }
                this$0.computing.set(false);
                z10 = z11;
            }
            if (!z10) {
                return;
            }
        } while (this$0.invalid.get());
    }

    @WorkerThread
    protected abstract T compute();

    @NotNull
    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    @NotNull
    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    @NotNull
    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    @NotNull
    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    public ComputableLiveData(@NotNull Executor executor) {
        t.i(executor, "executor");
        this.executor = executor;
        LiveData<T> liveData = new LiveData<T>(this) { // from class: androidx.lifecycle.ComputableLiveData$_liveData$1
            final /* synthetic */ ComputableLiveData<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.lifecycle.LiveData
            protected void onActive() {
                this.this$0.getExecutor$lifecycle_livedata_release().execute(this.this$0.refreshRunnable);
            }
        };
        this._liveData = liveData;
        this.liveData = liveData;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable() { // from class: androidx.lifecycle.a
            @Override // java.lang.Runnable
            public final void run() {
                ComputableLiveData.refreshRunnable$lambda$0(this.f973a);
            }
        };
        this.invalidationRunnable = new Runnable() { // from class: androidx.lifecycle.b
            @Override // java.lang.Runnable
            public final void run() {
                ComputableLiveData.invalidationRunnable$lambda$1(this.f974a);
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ComputableLiveData(Executor executor, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            t.h(executor, "getIOThreadExecutor()");
        }
        this(executor);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }
}

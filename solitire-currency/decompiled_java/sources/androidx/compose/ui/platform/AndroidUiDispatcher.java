package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.os.HandlerCompat;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AndroidUiDispatcher extends kotlinx.coroutines.k0 {

    @NotNull
    private final Choreographer choreographer;

    @NotNull
    private final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback;

    @NotNull
    private final MonotonicFrameClock frameClock;

    @NotNull
    private final Handler handler;

    @NotNull
    private final Object lock;
    private boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;

    @NotNull
    private List<Choreographer.FrameCallback> spareToRunOnFrame;

    @NotNull
    private List<Choreographer.FrameCallback> toRunOnFrame;

    @NotNull
    private final kotlin.collections.k<Runnable> toRunTrampolined;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final v8.l<z8.g> Main$delegate = v8.n.a(AndroidUiDispatcher$Companion$Main$2.INSTANCE);

    @NotNull
    private static final ThreadLocal<z8.g> currentThread = new ThreadLocal<z8.g>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$currentThread$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        public z8.g initialValue() {
            Choreographer choreographer = Choreographer.getInstance();
            kotlin.jvm.internal.t.h(choreographer, "getInstance()");
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                throw new IllegalStateException("no Looper on this thread".toString());
            }
            Handler handlerCreateAsync = HandlerCompat.createAsync(looperMyLooper);
            kotlin.jvm.internal.t.h(handlerCreateAsync, "createAsync(\n           …d\")\n                    )");
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, handlerCreateAsync, null);
            return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
        }
    };

    /* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final z8.g getCurrentThread() {
            if (AndroidUiDispatcher_androidKt.isMainThread()) {
                return getMain();
            }
            z8.g gVar = (z8.g) AndroidUiDispatcher.currentThread.get();
            if (gVar != null) {
                return gVar;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }

        @NotNull
        public final z8.g getMain() {
            return (z8.g) AndroidUiDispatcher.Main$delegate.getValue();
        }
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer, Handler handler, kotlin.jvm.internal.k kVar) {
        this(choreographer, handler);
    }

    private final Runnable nextTask() {
        Runnable runnableJ;
        synchronized (this.lock) {
            runnableJ = this.toRunTrampolined.j();
        }
        return runnableJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performFrameDispatch(long j10) {
        synchronized (this.lock) {
            if (this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = false;
                List<Choreographer.FrameCallback> list = this.toRunOnFrame;
                this.toRunOnFrame = this.spareToRunOnFrame;
                this.spareToRunOnFrame = list;
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.get(i10).doFrame(j10);
                }
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performTrampolineDispatch() {
        boolean z10;
        do {
            Runnable runnableNextTask = nextTask();
            while (runnableNextTask != null) {
                runnableNextTask.run();
                runnableNextTask = nextTask();
            }
            synchronized (this.lock) {
                if (this.toRunTrampolined.isEmpty()) {
                    z10 = false;
                    this.scheduledTrampolineDispatch = false;
                } else {
                    z10 = true;
                }
            }
        } while (z10);
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g context, @NotNull Runnable block) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(block, "block");
        synchronized (this.lock) {
            this.toRunTrampolined.addLast(block);
            if (!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if (!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    @NotNull
    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    @NotNull
    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    public final void postFrameCallback$ui_release(@NotNull Choreographer.FrameCallback callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        synchronized (this.lock) {
            this.toRunOnFrame.add(callback);
            if (!this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = true;
                this.choreographer.postFrameCallback(this.dispatchCallback);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    public final void removeFrameCallback$ui_release(@NotNull Choreographer.FrameCallback callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        synchronized (this.lock) {
            this.toRunOnFrame.remove(callback);
        }
    }

    private AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.choreographer = choreographer;
        this.handler = handler;
        this.lock = new Object();
        this.toRunTrampolined = new kotlin.collections.k<>();
        this.toRunOnFrame = new ArrayList();
        this.spareToRunOnFrame = new ArrayList();
        this.dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.frameClock = new AndroidUiFrameClock(choreographer);
    }
}

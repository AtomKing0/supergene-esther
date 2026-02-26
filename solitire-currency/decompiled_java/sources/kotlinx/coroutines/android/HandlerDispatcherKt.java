package kotlinx.coroutines.android;

import a9.c;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.jvm.internal.h;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;

    @Nullable
    public static final HandlerDispatcher Main;

    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            t.a aVar = t.f35208b;
            objB = t.b(new HandlerContext(asHandler(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            t.a aVar2 = t.f35208b;
            objB = t.b(u.a(th));
        }
        Main = (HandlerDispatcher) (t.g(objB) ? null : objB);
    }

    @VisibleForTesting
    @NotNull
    public static final Handler asHandler(@NotNull Looper looper, boolean z10) throws IllegalAccessException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        kotlin.jvm.internal.t.g(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }

    @Nullable
    public static final Object awaitFrame(@NotNull d<? super Long> dVar) throws Throwable {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            return awaitFrameSlowPath(dVar);
        }
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        postFrameCallback(choreographer2, pVar);
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitFrameSlowPath(d<? super Long> dVar) throws Throwable {
        final p pVar = new p(c.c(dVar), 1);
        pVar.C();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            updateChoreographerAndPostFrameCallback(pVar);
        } else {
            e1.c().dispatch(pVar.getContext(), new Runnable() { // from class: kotlinx.coroutines.android.HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(pVar);
                }
            });
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @NotNull
    public static final HandlerDispatcher from(@NotNull Handler handler) {
        return from$default(handler, null, 1, null);
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler handler, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return from(handler, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postFrameCallback(Choreographer choreographer2, final o<? super Long> oVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.b
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                HandlerDispatcherKt.postFrameCallback$lambda$6(oVar, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postFrameCallback$lambda$6(o oVar, long j10) {
        oVar.o(e1.c(), Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateChoreographerAndPostFrameCallback(o<? super Long> oVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            kotlin.jvm.internal.t.f(choreographer2);
            choreographer = choreographer2;
        }
        postFrameCallback(choreographer2, oVar);
    }

    @NotNull
    public static final HandlerDispatcher from(@NotNull Handler handler, @Nullable String str) {
        return new HandlerContext(handler, str);
    }

    public static /* synthetic */ void getMain$annotations() {
    }
}

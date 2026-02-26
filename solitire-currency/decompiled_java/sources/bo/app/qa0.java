package bo.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class qa0 implements kotlinx.coroutines.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qa0 f3696a = new qa0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static v00 f3697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z8.g f3698c;

    static {
        pa0 pa0Var = new pa0(kotlinx.coroutines.l0.N7);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        kotlin.jvm.internal.t.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        f3698c = s1.c(executorServiceNewSingleThreadExecutor).plus(pa0Var).plus(y2.b(null, 1, null));
    }

    @Override // kotlinx.coroutines.o0
    public final z8.g getCoroutineContext() {
        return f3698c;
    }
}

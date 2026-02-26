package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidUiDispatcher$Companion$Main$2 extends kotlin.jvm.internal.v implements h9.a<z8.g> {
    public static final AndroidUiDispatcher$Companion$Main$2 INSTANCE = new AndroidUiDispatcher$Companion$Main$2();

    AndroidUiDispatcher$Companion$Main$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final z8.g invoke() {
        Choreographer choreographer = AndroidUiDispatcher_androidKt.isMainThread() ? Choreographer.getInstance() : (Choreographer) kotlinx.coroutines.i.e(kotlinx.coroutines.e1.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null));
        kotlin.jvm.internal.t.h(choreographer, "if (isMainThread()) Chor…eographer.getInstance() }");
        Handler handlerCreateAsync = HandlerCompat.createAsync(Looper.getMainLooper());
        kotlin.jvm.internal.t.h(handlerCreateAsync, "createAsync(Looper.getMainLooper())");
        AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, handlerCreateAsync, null);
        return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
    }
}

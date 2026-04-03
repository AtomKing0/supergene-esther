package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.n2;
import org.jetbrains.annotations.NotNull;
import u9.v;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidDispatcherFactory implements v {
    @Override // u9.v
    @NotNull
    public n2 createDispatcher(@NotNull List<? extends v> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(HandlerDispatcherKt.asHandler(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // u9.v
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // u9.v
    @NotNull
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

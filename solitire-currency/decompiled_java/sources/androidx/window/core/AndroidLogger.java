package androidx.window.core;

import android.util.Log;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLogger implements Logger {

    @NotNull
    public static final AndroidLogger INSTANCE = new AndroidLogger();

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void debug(@NotNull String tag, @NotNull String message) {
        t.i(tag, "tag");
        t.i(message, "message");
        Log.d(tag, message);
    }
}

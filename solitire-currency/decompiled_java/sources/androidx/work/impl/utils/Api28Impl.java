package androidx.work.impl.utils;

import android.app.Application;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ProcessUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
final class Api28Impl {

    @NotNull
    public static final Api28Impl INSTANCE = new Api28Impl();

    private Api28Impl() {
    }

    @DoNotInline
    @NotNull
    public final String getProcessName() {
        String processName = Application.getProcessName();
        t.h(processName, "getProcessName()");
        return processName;
    }
}

package io.ktor.utils.io.jvm.javaio;

import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class i extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f26918a = new i();

    private i() {
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g context, @NotNull Runnable block) {
        t.i(context, "context");
        t.i(block, "block");
        block.run();
    }

    @Override // kotlinx.coroutines.k0
    public boolean isDispatchNeeded(@NotNull z8.g context) {
        t.i(context, "context");
        return true;
    }
}

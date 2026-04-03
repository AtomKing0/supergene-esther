package l8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StackWalkingFailedFrame.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m implements kotlin.coroutines.jvm.internal.e, z8.d<?> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f30962a = new m();

    private m() {
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        return null;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return z8.h.f37608a;
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        l.f30961a.a();
    }
}

package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpSpanFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class f3 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f3 f27807a = new f3();

    private f3() {
    }

    public static f3 b() {
        return f27807a;
    }

    @Override // io.sentry.o1
    @NotNull
    public p1 a(@NotNull y8 y8Var, @NotNull f1 f1Var, @NotNull a9 a9Var, @Nullable j jVar) {
        return g3.v();
    }
}

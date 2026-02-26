package y1;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements a2.b<Executor> {

    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f36412a = new k();
    }

    public static k a() {
        return a.f36412a;
    }

    public static Executor b() {
        return (Executor) a2.d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}

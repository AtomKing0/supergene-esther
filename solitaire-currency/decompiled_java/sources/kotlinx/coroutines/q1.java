package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class q1 extends k0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29974a = new a(null);

    /* JADX INFO: compiled from: Executors.kt */
    public static final class a extends z8.b<k0, q1> {

        /* JADX INFO: renamed from: kotlinx.coroutines.q1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Executors.kt */
        static final class C0606a extends kotlin.jvm.internal.v implements h9.l<g.b, q1> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0606a f29975g = new C0606a();

            C0606a() {
                super(1);
            }

            @Override // h9.l
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final q1 invoke(@NotNull g.b bVar) {
                if (bVar instanceof q1) {
                    return (q1) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private a() {
            super(k0.Key, C0606a.f29975g);
        }
    }

    @NotNull
    public abstract Executor I0();
}

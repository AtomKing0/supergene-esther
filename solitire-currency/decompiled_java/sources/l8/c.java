package l8;

import h9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PhaseContent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c<TSubject, Call> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f30943e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<Object> f30944f = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h f30945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f30946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> f30947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30948d;

    /* JADX INFO: compiled from: PhaseContent.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public c(@NotNull h phase, @NotNull i relation, @NotNull List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> interceptors) {
        t.i(phase, "phase");
        t.i(relation, "relation");
        t.i(interceptors, "interceptors");
        this.f30945a = phase;
        this.f30946b = relation;
        this.f30947c = interceptors;
        this.f30948d = true;
    }

    private final void d() {
        this.f30947c = c();
        this.f30948d = false;
    }

    public final void a(@NotNull q<? super e<TSubject, Call>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object> interceptor) {
        t.i(interceptor, "interceptor");
        if (this.f30948d) {
            d();
        }
        this.f30947c.add(interceptor);
    }

    public final void b(@NotNull List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> destination) {
        t.i(destination, "destination");
        List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> list = this.f30947c;
        if (destination instanceof ArrayList) {
            ((ArrayList) destination).ensureCapacity(destination.size() + list.size());
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            destination.add(list.get(i10));
        }
    }

    @NotNull
    public final List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f30947c);
        return arrayList;
    }

    @NotNull
    public final h e() {
        return this.f30945a;
    }

    @NotNull
    public final i f() {
        return this.f30946b;
    }

    public final int g() {
        return this.f30947c.size();
    }

    public final boolean h() {
        return this.f30947c.isEmpty();
    }

    @NotNull
    public final List<q<e<TSubject, Call>, TSubject, z8.d<? super k0>, Object>> i() {
        this.f30948d = true;
        return this.f30947c;
    }

    @NotNull
    public String toString() {
        return "Phase `" + this.f30945a.a() + "`, " + g() + " handlers";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@NotNull h phase, @NotNull i relation) {
        t.i(phase, "phase");
        t.i(relation, "relation");
        List<Object> list = f30944f;
        t.g(list, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>");
        this(phase, relation, t0.c(list));
        if (!list.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified".toString());
        }
    }
}

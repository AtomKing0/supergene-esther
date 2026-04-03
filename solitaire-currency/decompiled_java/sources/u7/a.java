package u7;

import e8.c;
import e8.k;
import f8.b;
import h9.p;
import h9.q;
import io.ktor.utils.io.j;
import io.ktor.utils.io.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;
import z8.g;

/* JADX INFO: compiled from: ObservableContent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b f34638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g f34639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final q<Long, Long, d<? super k0>, Object> f34640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.g f34641d;

    /* JADX INFO: renamed from: u7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObservableContent.kt */
    @f(c = "io.ktor.client.content.ObservableContent$content$1", f = "ObservableContent.kt", l = {36}, m = "invokeSuspend")
    static final class C0707a extends l implements p<w, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34642j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f34643k;

        C0707a(d<? super C0707a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C0707a c0707a = a.this.new C0707a(dVar);
            c0707a.f34643k = obj;
            return c0707a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable d<? super k0> dVar) {
            return ((C0707a) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34642j;
            if (i10 == 0) {
                u.b(obj);
                w wVar = (w) this.f34643k;
                b.d dVar = (b.d) a.this.f34638a;
                j jVarMo4209a = wVar.mo4209a();
                this.f34642j = 1;
                if (dVar.d(jVarMo4209a, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull b delegate, @NotNull g callContext, @NotNull q<? super Long, ? super Long, ? super d<? super k0>, ? extends Object> listener) {
        io.ktor.utils.io.g gVarMo4208a;
        t.i(delegate, "delegate");
        t.i(callContext, "callContext");
        t.i(listener, "listener");
        this.f34638a = delegate;
        this.f34639b = callContext;
        this.f34640c = listener;
        if (delegate instanceof b.a) {
            gVarMo4208a = io.ktor.utils.io.d.a(((b.a) delegate).d());
        } else if (delegate instanceof b.AbstractC0556b) {
            gVarMo4208a = io.ktor.utils.io.g.f26800a.a();
        } else if (delegate instanceof b.c) {
            gVarMo4208a = ((b.c) delegate).d();
        } else {
            if (!(delegate instanceof b.d)) {
                throw new v8.q();
            }
            gVarMo4208a = io.ktor.utils.io.q.d(t1.f29982a, callContext, true, new C0707a(null)).mo4208a();
        }
        this.f34641d = gVarMo4208a;
    }

    @Override // f8.b
    @Nullable
    public Long a() {
        return this.f34638a.a();
    }

    @Override // f8.b
    @Nullable
    public c b() {
        return this.f34638a.b();
    }

    @Override // f8.b
    @NotNull
    public k c() {
        return this.f34638a.c();
    }

    @Override // f8.b.c
    @NotNull
    public io.ktor.utils.io.g d() {
        return c8.a.a(this.f34641d, this.f34639b, a(), this.f34640c);
    }
}

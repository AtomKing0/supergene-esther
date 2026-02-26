package x7;

import g8.r;
import h9.p;
import io.ktor.utils.io.g;
import io.ktor.utils.io.i;
import io.ktor.utils.io.q;
import io.ktor.utils.io.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TimeoutExceptionsCommon.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: compiled from: TimeoutExceptionsCommon.kt */
    @f(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1", f = "TimeoutExceptionsCommon.kt", l = {39}, m = "invokeSuspend")
    static final class a extends l implements p<w, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36217j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ g f36218k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ io.ktor.utils.io.c f36219l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, io.ktor.utils.io.c cVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f36218k = gVar;
            this.f36219l = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f36218k, this.f36219l, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f36217j;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    g gVar = this.f36218k;
                    io.ktor.utils.io.c cVar = this.f36219l;
                    this.f36217j = 1;
                    if (i.c(gVar, cVar, 0L, this, 2, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
            } catch (Throwable th) {
                this.f36218k.b(th);
            }
            return k0.f35197a;
        }
    }

    @NotNull
    public static final g a(@NotNull o0 o0Var, @NotNull g input, @NotNull a8.d request) {
        t.i(o0Var, "<this>");
        t.i(input, "input");
        t.i(request, "request");
        if (r.f25911a.c()) {
            return input;
        }
        io.ktor.utils.io.c cVarA = d.a(request);
        q.e(o0Var, null, cVarA, new a(input, cVarA, null), 1, null);
        return cVarA;
    }
}

package y7;

import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpRequestLifecycle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36801a = k8.a.a("io.ktor.client.plugins.HttpRequestLifecycle");

    /* JADX INFO: compiled from: HttpRequestLifecycle.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g1 f36802g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g1 g1Var) {
            super(1);
            this.f36802g = g1Var;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f36802g.dispose();
        }
    }

    /* JADX INFO: compiled from: HttpRequestLifecycle.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.a0 f36803g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlinx.coroutines.a0 a0Var) {
            super(1);
            this.f36803g = a0Var;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            if (th == null) {
                t.f36801a.b("Cancelling request because engine Job completed");
                this.f36803g.complete();
                return;
            }
            t.f36801a.b("Cancelling request because engine Job failed with error: " + th);
            f2.c(this.f36803g, "Engine failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(kotlinx.coroutines.a0 a0Var, b2 b2Var) {
        a0Var.J(new a(b2Var.J(new b(a0Var))));
    }
}

package y7;

import org.jetbrains.annotations.NotNull;
import v8.k0;
import y7.d;

/* JADX INFO: compiled from: DefaultRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36664a = k8.a.a("io.ktor.client.plugins.DefaultRequest");

    /* JADX INFO: compiled from: DefaultRequest.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<d.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h9.l<d.a, k0> f36665g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(h9.l<? super d.a, k0> lVar) {
            super(1);
            this.f36665g = lVar;
        }

        public final void a(@NotNull d.a install) {
            kotlin.jvm.internal.t.i(install, "$this$install");
            this.f36665g.invoke(install);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(d.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public static final void b(@NotNull s7.b<?> bVar, @NotNull h9.l<? super d.a, k0> block) {
        kotlin.jvm.internal.t.i(bVar, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        bVar.i(d.f36655b, new a(block));
    }
}

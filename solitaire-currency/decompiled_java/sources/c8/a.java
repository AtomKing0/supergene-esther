package c8;

import h9.p;
import h9.q;
import io.ktor.utils.io.g;
import io.ktor.utils.io.w;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ByteChannelUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteChannelUtils.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", l = {23, 24, 26, 31}, m = "invokeSuspend")
    static final class C0155a extends l implements p<w, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f4612j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f4613k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f4614l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f4615m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f4616n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f4617o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f4618p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f4619q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f4620r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private /* synthetic */ Object f4621s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ Long f4622t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ g f4623u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ q<Long, Long, z8.d<? super k0>, Object> f4624v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0155a(Long l10, g gVar, q<? super Long, ? super Long, ? super z8.d<? super k0>, ? extends Object> qVar, z8.d<? super C0155a> dVar) {
            super(2, dVar);
            this.f4622t = l10;
            this.f4623u = gVar;
            this.f4624v = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0155a c0155a = new C0155a(this.f4622t, this.f4623u, this.f4624v, dVar);
            c0155a.f4621s = obj;
            return c0155a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable z8.d<? super k0> dVar) {
            return ((C0155a) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00eb A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:9:0x001d, B:61:0x01a0, B:37:0x00e5, B:39:0x00eb, B:42:0x0104, B:54:0x016e, B:58:0x0181), top: B:70:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x012a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0159 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x016e A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #1 {all -> 0x0022, blocks: (B:9:0x001d, B:61:0x01a0, B:37:0x00e5, B:39:0x00eb, B:42:0x0104, B:54:0x016e, B:58:0x0181), top: B:70:0x000c }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x015a -> B:51:0x0164). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 430
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: c8.a.C0155a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    public static final g a(@NotNull g gVar, @NotNull z8.g context, @Nullable Long l10, @NotNull q<? super Long, ? super Long, ? super z8.d<? super k0>, ? extends Object> listener) {
        t.i(gVar, "<this>");
        t.i(context, "context");
        t.i(listener, "listener");
        return io.ktor.utils.io.q.d(t1.f29982a, context, true, new C0155a(l10, gVar, listener, null)).mo4208a();
    }
}

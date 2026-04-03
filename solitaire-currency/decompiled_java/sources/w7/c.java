package w7;

import e8.t;
import f8.b;
import h9.p;
import io.ktor.utils.io.j;
import io.ktor.utils.io.w;
import java.util.List;
import kotlin.collections.v;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AndroidClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<t> f35449a;

    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @f(c = "io.ktor.client.engine.android.AndroidClientEngineKt", f = "AndroidClientEngine.kt", l = {116, 123}, m = "writeTo")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f35450j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f35451k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f35452l;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f35451k = obj;
            this.f35452l |= Integer.MIN_VALUE;
            return c.b(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @f(c = "io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$2$channel$1", f = "AndroidClientEngine.kt", l = {120}, m = "invokeSuspend")
    static final class b extends l implements p<w, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f35453j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f35454k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ f8.b f35455l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f8.b bVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f35455l = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f35455l, dVar);
            bVar.f35454k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f35453j;
            if (i10 == 0) {
                u.b(obj);
                w wVar = (w) this.f35454k;
                b.d dVar = (b.d) this.f35455l;
                j jVarMo4209a = wVar.mo4209a();
                this.f35453j = 1;
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

    static {
        t.a aVar = t.f25351b;
        f35449a = v.n(aVar.a(), aVar.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v3 */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull f8.b r16, @org.jetbrains.annotations.NotNull java.io.OutputStream r17, @org.jetbrains.annotations.NotNull z8.g r18, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r19) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.c.b(f8.b, java.io.OutputStream, z8.g, z8.d):java.lang.Object");
    }
}

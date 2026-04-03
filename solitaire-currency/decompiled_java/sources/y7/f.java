package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.k;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g8.a<k0> f36666a = new g8.a<>("ValidateMark");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final xa.a f36667b = k8.a.a("io.ktor.client.plugins.DefaultResponseValidation");

    /* JADX INFO: compiled from: DefaultResponseValidation.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<k.b, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ s7.b<?> f36668g;

        /* JADX INFO: renamed from: y7.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DefaultResponseValidation.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {42, 48}, m = "invokeSuspend")
        static final class C0742a extends kotlin.coroutines.jvm.internal.l implements h9.p<b8.c, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f36669j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f36670k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f36671l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            /* synthetic */ Object f36672m;

            C0742a(z8.d<? super C0742a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0742a c0742a = new C0742a(dVar);
                c0742a.f36672m = obj;
                return c0742a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull b8.c cVar, @Nullable z8.d<? super k0> dVar) {
                return ((C0742a) create(cVar, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:0|2|(1:(1:(9:6|61|7|30|34|(1:38)(1:37)|(3:40|(1:44)(1:43)|(2:(1:50)|(1:52)(1:53))(1:54))(1:55)|56|57)(2:9|10))(1:11))(2:12|(2:14|15)(2:16|(2:58|59)(2:21|(1:23)(1:24))))|25|63|26|(1:28)(7:29|30|34|(1:38)(0)|(0)(0)|56|57)) */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00d0, code lost:
            
                r0 = r1;
                r3 = r5;
                r1 = r11;
             */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0108  */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 317
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y7.f.a.C0742a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(s7.b<?> bVar) {
            super(1);
            this.f36668g = bVar;
        }

        public final void a(@NotNull k.b HttpResponseValidator) {
            kotlin.jvm.internal.t.i(HttpResponseValidator, "$this$HttpResponseValidator");
            HttpResponseValidator.d(this.f36668g.d());
            HttpResponseValidator.e(new C0742a(null));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(k.b bVar) {
            a(bVar);
            return k0.f35197a;
        }
    }

    public static final void c(@NotNull s7.b<?> bVar) {
        kotlin.jvm.internal.t.i(bVar, "<this>");
        l.b(bVar, new a(bVar));
    }
}

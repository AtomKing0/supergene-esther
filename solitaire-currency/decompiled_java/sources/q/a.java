package q;

import a0.j;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.m;
import q.b;
import t.c;
import v.n;
import v.q;
import v.r;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements q.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0655a f32984d = new C0655a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j.e f32985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final q f32986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final t.d f32987c;

    /* JADX INFO: renamed from: q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    public static final class C0655a {
        private C0655a() {
        }

        public /* synthetic */ C0655a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Drawable f32988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f32989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final m.f f32990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f32991d;

        public b(@NotNull Drawable drawable, boolean z10, @NotNull m.f fVar, @Nullable String str) {
            this.f32988a = drawable;
            this.f32989b = z10;
            this.f32990c = fVar;
            this.f32991d = str;
        }

        public static /* synthetic */ b b(b bVar, Drawable drawable, boolean z10, m.f fVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                drawable = bVar.f32988a;
            }
            if ((i10 & 2) != 0) {
                z10 = bVar.f32989b;
            }
            if ((i10 & 4) != 0) {
                fVar = bVar.f32990c;
            }
            if ((i10 & 8) != 0) {
                str = bVar.f32991d;
            }
            return bVar.a(drawable, z10, fVar, str);
        }

        @NotNull
        public final b a(@NotNull Drawable drawable, boolean z10, @NotNull m.f fVar, @Nullable String str) {
            return new b(drawable, z10, fVar, str);
        }

        @NotNull
        public final m.f c() {
            return this.f32990c;
        }

        @Nullable
        public final String d() {
            return this.f32991d;
        }

        @NotNull
        public final Drawable e() {
            return this.f32988a;
        }

        public final boolean f() {
            return this.f32989b;
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {199}, m = "decode")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f32992j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f32993k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f32994l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f32995m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f32996n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f32997o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f32998p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Object f32999q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f33000r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        /* synthetic */ Object f33001s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f33003u;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33001s = obj;
            this.f33003u |= Integer.MIN_VALUE;
            return a.this.h(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {122, 126, 144}, m = "execute")
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33004j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33005k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33006l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f33007m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f33008n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f33009o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f33010p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Object f33011q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        /* synthetic */ Object f33012r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f33014t;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33012r = obj;
            this.f33014t |= Integer.MIN_VALUE;
            return a.this.i(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {127}, m = "invokeSuspend")
    static final class e extends l implements p<o0, z8.d<? super b>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33015j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ n0<p.h> f33017l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ n0<j.b> f33018m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ v.i f33019n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ Object f33020o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ n0<n> f33021p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ j.c f33022q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(n0<p.h> n0Var, n0<j.b> n0Var2, v.i iVar, Object obj, n0<n> n0Var3, j.c cVar, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f33017l = n0Var;
            this.f33018m = n0Var2;
            this.f33019n = iVar;
            this.f33020o = obj;
            this.f33021p = n0Var3;
            this.f33022q = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return a.this.new e(this.f33017l, this.f33018m, this.f33019n, this.f33020o, this.f33021p, this.f33022q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f33015j;
            if (i10 == 0) {
                u.b(obj);
                a aVar = a.this;
                m mVar = (m) this.f33017l.f29834a;
                j.b bVar = this.f33018m.f29834a;
                v.i iVar = this.f33019n;
                Object obj2 = this.f33020o;
                n nVar = this.f33021p.f29834a;
                j.c cVar = this.f33022q;
                this.f33015j = 1;
                obj = aVar.h(mVar, bVar, iVar, obj2, nVar, cVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {165}, m = "fetch")
    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33023j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33024k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33025l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f33026m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f33027n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f33028o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f33029p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f33030q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        /* synthetic */ Object f33031r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f33033t;

        f(z8.d<? super f> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33031r = obj;
            this.f33033t |= Integer.MIN_VALUE;
            return a.this.j(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {73}, m = "intercept")
    static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33034j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33035k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33036l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f33038n;

        g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33036l = obj;
            this.f33038n |= Integer.MIN_VALUE;
            return a.this.a(null, this);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {75}, m = "invokeSuspend")
    static final class h extends l implements p<o0, z8.d<? super r>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33039j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ v.i f33041l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Object f33042m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ n f33043n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ j.c f33044o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ c.b f33045p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ b.a f33046q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(v.i iVar, Object obj, n nVar, j.c cVar, c.b bVar, b.a aVar, z8.d<? super h> dVar) {
            super(2, dVar);
            this.f33041l = iVar;
            this.f33042m = obj;
            this.f33043n = nVar;
            this.f33044o = cVar;
            this.f33045p = bVar;
            this.f33046q = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return a.this.new h(this.f33041l, this.f33042m, this.f33043n, this.f33044o, this.f33045p, this.f33046q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objE = a9.d.e();
            int i10 = this.f33039j;
            if (i10 == 0) {
                u.b(obj);
                a aVar = a.this;
                v.i iVar = this.f33041l;
                Object obj2 = this.f33042m;
                n nVar = this.f33043n;
                j.c cVar = this.f33044o;
                this.f33039j = 1;
                obj = aVar.i(iVar, obj2, nVar, cVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            b bVar = (b) obj;
            return new r(bVar.e(), this.f33041l, bVar.c(), a.this.f32987c.h(this.f33045p, this.f33041l, bVar) ? this.f33045p : null, bVar.d(), bVar.f(), j.t(this.f33046q));
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super r> dVar) {
            return ((h) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", l = {242}, m = "invokeSuspend")
    static final class i extends l implements p<o0, z8.d<? super b>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33047j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33048k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33049l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33050m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f33051n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private /* synthetic */ Object f33052o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ b f33054q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ n f33055r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ List<y.a> f33056s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ j.c f33057t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ v.i f33058u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(b bVar, n nVar, List<? extends y.a> list, j.c cVar, v.i iVar, z8.d<? super i> dVar) {
            super(2, dVar);
            this.f33054q = bVar;
            this.f33055r = nVar;
            this.f33056s = list;
            this.f33057t = cVar;
            this.f33058u = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            i iVar = a.this.new i(this.f33054q, this.f33055r, this.f33056s, this.f33057t, this.f33058u, dVar);
            iVar.f33052o = obj;
            return iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x007b -> B:13:0x007e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33051n
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                int r2 = r0.f33050m
                int r4 = r0.f33049l
                java.lang.Object r5 = r0.f33048k
                v.n r5 = (v.n) r5
                java.lang.Object r6 = r0.f33047j
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r7 = r0.f33052o
                kotlinx.coroutines.o0 r7 = (kotlinx.coroutines.o0) r7
                v8.u.b(r19)
                r9 = r0
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r19
                goto L7e
            L27:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L2f:
                v8.u.b(r19)
                java.lang.Object r2 = r0.f33052o
                kotlinx.coroutines.o0 r2 = (kotlinx.coroutines.o0) r2
                q.a r4 = q.a.this
                q.a$b r5 = r0.f33054q
                android.graphics.drawable.Drawable r5 = r5.e()
                v.n r6 = r0.f33055r
                java.util.List<y.a> r7 = r0.f33056s
                android.graphics.Bitmap r4 = q.a.b(r4, r5, r6, r7)
                j.c r5 = r0.f33057t
                v.i r6 = r0.f33058u
                r5.p(r6, r4)
                java.util.List<y.a> r5 = r0.f33056s
                v.n r6 = r0.f33055r
                int r7 = r5.size()
                r8 = 0
                r9 = r0
                r17 = r8
                r8 = r2
                r2 = r7
                r7 = r5
                r5 = r4
                r4 = r17
            L5f:
                if (r4 >= r2) goto L85
                java.lang.Object r10 = r7.get(r4)
                y.a r10 = (y.a) r10
                w.i r11 = r6.n()
                r9.f33052o = r8
                r9.f33047j = r7
                r9.f33048k = r6
                r9.f33049l = r4
                r9.f33050m = r2
                r9.f33051n = r3
                java.lang.Object r5 = r10.a(r5, r11, r9)
                if (r5 != r1) goto L7e
                return r1
            L7e:
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                kotlinx.coroutines.p0.g(r8)
                int r4 = r4 + r3
                goto L5f
            L85:
                j.c r1 = r9.f33057t
                v.i r2 = r9.f33058u
                r1.f(r2, r5)
                q.a$b r10 = r9.f33054q
                v.i r1 = r9.f33058u
                android.content.Context r1 = r1.l()
                android.content.res.Resources r1 = r1.getResources()
                android.graphics.drawable.BitmapDrawable r11 = new android.graphics.drawable.BitmapDrawable
                r11.<init>(r1, r5)
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 14
                r16 = 0
                q.a$b r1 = q.a.b.b(r10, r11, r12, r13, r14, r15, r16)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: q.a.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super b> dVar) {
            return ((i) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public a(@NotNull j.e eVar, @NotNull q qVar, @Nullable a0.r rVar) {
        this.f32985a = eVar;
        this.f32986b = qVar;
        this.f32987c = new t.d(eVar, qVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap g(Drawable drawable, n nVar, List<? extends y.a> list) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (kotlin.collections.p.H(j.o(), a0.a.c(bitmap))) {
                return bitmap;
            }
        }
        return a0.l.f48a.a(drawable, nVar.f(), nVar.n(), nVar.m(), nVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ab -> B:21:0x00b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(p.m r17, j.b r18, v.i r19, java.lang.Object r20, v.n r21, j.c r22, z8.d<? super q.a.b> r23) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.a.h(p.m, j.b, v.i, java.lang.Object, v.n, j.c, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c A[Catch: all -> 0x0212, TRY_LEAVE, TryCatch #0 {all -> 0x0212, blocks: (B:45:0x0151, B:47:0x015c, B:53:0x019c, B:55:0x01a0, B:76:0x020c, B:77:0x0211, B:27:0x00a5, B:29:0x00b1, B:30:0x00df, B:32:0x00e5, B:41:0x0114, B:34:0x00eb, B:36:0x00fa, B:37:0x0101, B:39:0x0107, B:40:0x010e), top: B:88:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019c A[Catch: all -> 0x0212, TRY_ENTER, TryCatch #0 {all -> 0x0212, blocks: (B:45:0x0151, B:47:0x015c, B:53:0x019c, B:55:0x01a0, B:76:0x020c, B:77:0x0211, B:27:0x00a5, B:29:0x00b1, B:30:0x00df, B:32:0x00e5, B:41:0x0114, B:34:0x00eb, B:36:0x00fa, B:37:0x0101, B:39:0x0107, B:40:0x010e), top: B:88:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021f  */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, j.b] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, v.n] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, j.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(v.i r36, java.lang.Object r37, v.n r38, j.c r39, z8.d<? super q.a.b> r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.a.i(v.i, java.lang.Object, v.n, j.c, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:21:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(j.b r10, v.i r11, java.lang.Object r12, v.n r13, j.c r14, z8.d<? super p.h> r15) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.a.j(j.b, v.i, java.lang.Object, v.n, j.c, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // q.b
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull q.b.a r14, @org.jetbrains.annotations.NotNull z8.d<? super v.j> r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof q.a.g
            if (r0 == 0) goto L13
            r0 = r15
            q.a$g r0 = (q.a.g) r0
            int r1 = r0.f33038n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33038n = r1
            goto L18
        L13:
            q.a$g r0 = new q.a$g
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f33036l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33038n
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r14 = r0.f33035k
            q.b$a r14 = (q.b.a) r14
            java.lang.Object r0 = r0.f33034j
            q.a r0 = (q.a) r0
            v8.u.b(r15)     // Catch: java.lang.Throwable -> L31
            goto L9b
        L31:
            r15 = move-exception
            goto L9e
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3b:
            v8.u.b(r15)
            v.i r6 = r14.getRequest()     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r15 = r6.m()     // Catch: java.lang.Throwable -> L9c
            w.i r2 = r14.getSize()     // Catch: java.lang.Throwable -> L9c
            j.c r9 = a0.j.g(r14)     // Catch: java.lang.Throwable -> L9c
            v.q r4 = r13.f32986b     // Catch: java.lang.Throwable -> L9c
            v.n r8 = r4.f(r6, r2)     // Catch: java.lang.Throwable -> L9c
            w.h r4 = r8.m()     // Catch: java.lang.Throwable -> L9c
            r9.n(r6, r15)     // Catch: java.lang.Throwable -> L9c
            j.e r5 = r13.f32985a     // Catch: java.lang.Throwable -> L9c
            j.b r5 = r5.getComponents()     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r7 = r5.g(r15, r8)     // Catch: java.lang.Throwable -> L9c
            r9.q(r6, r7)     // Catch: java.lang.Throwable -> L9c
            t.d r15 = r13.f32987c     // Catch: java.lang.Throwable -> L9c
            t.c$b r10 = r15.f(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9c
            if (r10 == 0) goto L77
            t.d r15 = r13.f32987c     // Catch: java.lang.Throwable -> L9c
            t.c$c r15 = r15.a(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L9c
            goto L78
        L77:
            r15 = 0
        L78:
            if (r15 == 0) goto L81
            t.d r0 = r13.f32987c     // Catch: java.lang.Throwable -> L9c
            v.r r14 = r0.g(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L9c
            return r14
        L81:
            kotlinx.coroutines.k0 r15 = r6.v()     // Catch: java.lang.Throwable -> L9c
            q.a$h r2 = new q.a$h     // Catch: java.lang.Throwable -> L9c
            r12 = 0
            r4 = r2
            r5 = r13
            r11 = r14
            r4.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9c
            r0.f33034j = r13     // Catch: java.lang.Throwable -> L9c
            r0.f33035k = r14     // Catch: java.lang.Throwable -> L9c
            r0.f33038n = r3     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r15 = kotlinx.coroutines.i.g(r15, r2, r0)     // Catch: java.lang.Throwable -> L9c
            if (r15 != r1) goto L9b
            return r1
        L9b:
            return r15
        L9c:
            r15 = move-exception
            r0 = r13
        L9e:
            boolean r1 = r15 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto Lad
            v.q r0 = r0.f32986b
            v.i r14 = r14.getRequest()
            v.f r14 = r0.b(r14, r15)
            return r14
        Lad:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: q.a.a(q.b$a, z8.d):java.lang.Object");
    }

    @VisibleForTesting
    @Nullable
    public final Object k(@NotNull b bVar, @NotNull v.i iVar, @NotNull n nVar, @NotNull j.c cVar, @NotNull z8.d<? super b> dVar) {
        List<y.a> listO = iVar.O();
        return listO.isEmpty() ? bVar : ((bVar.e() instanceof BitmapDrawable) || iVar.g()) ? kotlinx.coroutines.i.g(iVar.N(), new i(bVar, nVar, listO, cVar, iVar, null), dVar) : bVar;
    }
}

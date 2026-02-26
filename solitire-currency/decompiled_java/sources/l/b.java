package l;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import h9.l;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.y;
import v.i;
import v.r;
import v8.k0;
import v8.q;
import v8.u;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Stable
public final class b extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public static final C0611b f30116p = new C0611b(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private static final l<c, c> f30117q = a.f30133g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private o0 f30118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final y<Size> f30119b = s9.o0.a(Size.m1424boximpl(Size.Companion.m1445getZeroNHjbRc()));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final MutableState f30120c = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final MutableState f30121d = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final MutableState f30122e = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private c f30123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Painter f30124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private l<? super c, ? extends c> f30125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private l<? super c, k0> f30126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private ContentScale f30127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f30129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final MutableState f30130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final MutableState f30131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final MutableState f30132o;

    /* JADX INFO: renamed from: l.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    public static final class C0611b {
        private C0611b() {
        }

        public /* synthetic */ C0611b(k kVar) {
            this();
        }

        @NotNull
        public final l<c, c> a() {
            return b.f30117q;
        }
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @StabilityInferred(parameters = 0)
    public static abstract class c {

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @StabilityInferred(parameters = 0)
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f30134a = new a();

            private a() {
                super(null);
            }

            @Override // l.b.c
            @Nullable
            public Painter a() {
                return null;
            }
        }

        /* JADX INFO: renamed from: l.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @StabilityInferred(parameters = 0)
        public static final class C0612b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private final Painter f30135a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final v.f f30136b;

            public C0612b(@Nullable Painter painter, @NotNull v.f fVar) {
                super(null);
                this.f30135a = painter;
                this.f30136b = fVar;
            }

            @Override // l.b.c
            @Nullable
            public Painter a() {
                return this.f30135a;
            }

            @NotNull
            public final v.f b() {
                return this.f30136b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0612b)) {
                    return false;
                }
                C0612b c0612b = (C0612b) obj;
                return t.d(a(), c0612b.a()) && t.d(this.f30136b, c0612b.f30136b);
            }

            public int hashCode() {
                return ((a() == null ? 0 : a().hashCode()) * 31) + this.f30136b.hashCode();
            }

            @NotNull
            public String toString() {
                return "Error(painter=" + a() + ", result=" + this.f30136b + ')';
            }
        }

        /* JADX INFO: renamed from: l.b$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @StabilityInferred(parameters = 0)
        public static final class C0613c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private final Painter f30137a;

            public C0613c(@Nullable Painter painter) {
                super(null);
                this.f30137a = painter;
            }

            @Override // l.b.c
            @Nullable
            public Painter a() {
                return this.f30137a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0613c) && t.d(a(), ((C0613c) obj).a());
            }

            public int hashCode() {
                if (a() == null) {
                    return 0;
                }
                return a().hashCode();
            }

            @NotNull
            public String toString() {
                return "Loading(painter=" + a() + ')';
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @StabilityInferred(parameters = 0)
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final Painter f30138a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final r f30139b;

            public d(@NotNull Painter painter, @NotNull r rVar) {
                super(null);
                this.f30138a = painter;
                this.f30139b = rVar;
            }

            @Override // l.b.c
            @NotNull
            public Painter a() {
                return this.f30138a;
            }

            @NotNull
            public final r b() {
                return this.f30139b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return t.d(a(), dVar.a()) && t.d(this.f30139b, dVar.f30139b);
            }

            public int hashCode() {
                return (a().hashCode() * 31) + this.f30139b.hashCode();
            }

            @NotNull
            public String toString() {
                return "Success(painter=" + a() + ", result=" + this.f30139b + ')';
            }
        }

        private c() {
        }

        public /* synthetic */ c(k kVar) {
            this();
        }

        @Nullable
        public abstract Painter a();
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.compose.AsyncImagePainter$onRemembered$1", f = "AsyncImagePainter.kt", l = {246}, m = "invokeSuspend")
    static final class d extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f30140j;

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        static final class a extends v implements h9.a<v.i> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f30142g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.f30142g = bVar;
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final v.i invoke() {
                return this.f30142g.l();
            }
        }

        /* JADX INFO: renamed from: l.b$d$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @kotlin.coroutines.jvm.internal.f(c = "coil.compose.AsyncImagePainter$onRemembered$1$2", f = "AsyncImagePainter.kt", l = {245}, m = "invokeSuspend")
        static final class C0614b extends kotlin.coroutines.jvm.internal.l implements p<v.i, z8.d<? super c>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f30143j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f30144k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ b f30145l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0614b(b bVar, z8.d<? super C0614b> dVar) {
                super(2, dVar);
                this.f30145l = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0614b(this.f30145l, dVar);
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull v.i iVar, @Nullable z8.d<? super c> dVar) {
                return ((C0614b) create(iVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                b bVar;
                Object objE = a9.d.e();
                int i10 = this.f30144k;
                if (i10 == 0) {
                    u.b(obj);
                    b bVar2 = this.f30145l;
                    j.e eVarJ = bVar2.j();
                    b bVar3 = this.f30145l;
                    v.i iVarC = bVar3.C(bVar3.l());
                    this.f30143j = bVar2;
                    this.f30144k = 1;
                    Object objB = eVarJ.b(iVarC, this);
                    if (objB == objE) {
                        return objE;
                    }
                    bVar = bVar2;
                    obj = objB;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (b) this.f30143j;
                    u.b(obj);
                }
                return bVar.B((v.j) obj);
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        /* synthetic */ class c implements s9.i, n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f30146a;

            c(b bVar) {
                this.f30146a = bVar;
            }

            @Override // s9.i
            @Nullable
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull c cVar, @NotNull z8.d<? super k0> dVar) {
                Object objG = d.g(this.f30146a, cVar, dVar);
                return objG == a9.d.e() ? objG : k0.f35197a;
            }

            public final boolean equals(@Nullable Object obj) {
                if ((obj instanceof s9.i) && (obj instanceof n)) {
                    return t.d(getFunctionDelegate(), ((n) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.n
            @NotNull
            public final v8.g<?> getFunctionDelegate() {
                return new kotlin.jvm.internal.a(2, this.f30146a, b.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }
        }

        d(z8.d<? super d> dVar) {
            super(2, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object g(b bVar, c cVar, z8.d dVar) {
            bVar.D(cVar);
            return k0.f35197a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return b.this.new d(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f30140j;
            if (i10 == 0) {
                u.b(obj);
                s9.h hVarE = s9.j.E(SnapshotStateKt.snapshotFlow(new a(b.this)), new C0614b(b.this, null));
                c cVar = new c(b.this);
                this.f30140j = 1;
                if (hVarE.collect(cVar, this) == objE) {
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

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    static final class f implements w.j {

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements s9.h<w.i> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ s9.h f30149a;

            /* JADX INFO: renamed from: l.b$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class C0615a<T> implements s9.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ s9.i f30150a;

                /* JADX INFO: renamed from: l.b$f$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @kotlin.coroutines.jvm.internal.f(c = "coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2", f = "AsyncImagePainter.kt", l = {225}, m = "emit")
                public static final class C0616a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    /* synthetic */ Object f30151j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    int f30152k;

                    public C0616a(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f30151j = obj;
                        this.f30152k |= Integer.MIN_VALUE;
                        return C0615a.this.emit(null, this);
                    }
                }

                public C0615a(s9.i iVar) {
                    this.f30150a = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull z8.d r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof l.b.f.a.C0615a.C0616a
                        if (r0 == 0) goto L13
                        r0 = r8
                        l.b$f$a$a$a r0 = (l.b.f.a.C0615a.C0616a) r0
                        int r1 = r0.f30152k
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f30152k = r1
                        goto L18
                    L13:
                        l.b$f$a$a$a r0 = new l.b$f$a$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f30151j
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.f30152k
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r8)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        v8.u.b(r8)
                        s9.i r8 = r6.f30150a
                        androidx.compose.ui.geometry.Size r7 = (androidx.compose.ui.geometry.Size) r7
                        long r4 = r7.m1441unboximpl()
                        w.i r7 = l.c.b(r4)
                        if (r7 == 0) goto L4b
                        r0.f30152k = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L4b
                        return r1
                    L4b:
                        v8.k0 r7 = v8.k0.f35197a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: l.b.f.a.C0615a.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            public a(s9.h hVar) {
                this.f30149a = hVar;
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull s9.i<? super w.i> iVar, @NotNull z8.d dVar) {
                Object objCollect = this.f30149a.collect(new C0615a(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }

        f() {
        }

        @Override // w.j
        @Nullable
        public final Object a(@NotNull z8.d<? super w.i> dVar) {
            return s9.j.w(new a(b.this.f30119b), dVar);
        }
    }

    public b(@NotNull v.i iVar, @NotNull j.e eVar) {
        c.a aVar = c.a.f30134a;
        this.f30123f = aVar;
        this.f30125h = f30117q;
        this.f30127j = ContentScale.Companion.getFit();
        this.f30128k = DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I();
        this.f30130m = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(aVar, null, 2, null);
        this.f30131n = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iVar, null, 2, null);
        this.f30132o = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(eVar, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Painter A(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return BitmapPainterKt.m2092BitmapPainterQZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) drawable).getBitmap()), 0L, 0L, this.f30128k, 6, null);
        }
        return drawable instanceof ColorDrawable ? new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), null) : new q1.a(drawable.mutate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c B(v.j jVar) {
        if (jVar instanceof r) {
            r rVar = (r) jVar;
            return new c.d(A(rVar.a()), rVar);
        }
        if (!(jVar instanceof v.f)) {
            throw new q();
        }
        Drawable drawableA = jVar.a();
        return new c.C0612b(drawableA != null ? A(drawableA) : null, (v.f) jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v.i C(v.i iVar) {
        i.a aVarL = v.i.R(iVar, null, 1, null).l(new e());
        if (iVar.q().m() == null) {
            aVarL.k(new f());
        }
        if (iVar.q().l() == null) {
            aVarL.j(j.f(this.f30127j));
        }
        if (iVar.q().k() != w.e.EXACT) {
            aVarL.d(w.e.INEXACT);
        }
        return aVarL.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(c cVar) {
        c cVar2 = this.f30123f;
        c cVarInvoke = this.f30125h.invoke(cVar);
        z(cVarInvoke);
        Painter painterM = m(cVar2, cVarInvoke);
        if (painterM == null) {
            painterM = cVarInvoke.a();
        }
        y(painterM);
        if (this.f30118a != null && cVar2.a() != cVarInvoke.a()) {
            Object objA = cVar2.a();
            RememberObserver rememberObserver = objA instanceof RememberObserver ? (RememberObserver) objA : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object objA2 = cVarInvoke.a();
            RememberObserver rememberObserver2 = objA2 instanceof RememberObserver ? (RememberObserver) objA2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        l<? super c, k0> lVar = this.f30126i;
        if (lVar != null) {
            lVar.invoke(cVarInvoke);
        }
    }

    private final void g() {
        o0 o0Var = this.f30118a;
        if (o0Var != null) {
            p0.e(o0Var, null, 1, null);
        }
        this.f30118a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float h() {
        return ((Number) this.f30121d.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ColorFilter i() {
        return (ColorFilter) this.f30122e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Painter k() {
        return (Painter) this.f30120c.getValue();
    }

    private final l.f m(c cVar, c cVar2) {
        v.j jVarB;
        if (!(cVar2 instanceof c.d)) {
            if (cVar2 instanceof c.C0612b) {
                jVarB = ((c.C0612b) cVar2).b();
            }
            return null;
        }
        jVarB = ((c.d) cVar2).b();
        z.c cVarA = jVarB.b().P().a(l.c.f30154a, jVarB);
        if (cVarA instanceof z.a) {
            z.a aVar = (z.a) cVarA;
            return new l.f(cVar instanceof c.C0613c ? cVar.a() : null, cVar2.a(), this.f30127j, aVar.b(), ((jVarB instanceof r) && ((r) jVarB).d()) ? false : true, aVar.c());
        }
        return null;
    }

    private final void n(float f10) {
        this.f30121d.setValue(Float.valueOf(f10));
    }

    private final void o(ColorFilter colorFilter) {
        this.f30122e.setValue(colorFilter);
    }

    private final void t(Painter painter) {
        this.f30120c.setValue(painter);
    }

    private final void w(c cVar) {
        this.f30130m.setValue(cVar);
    }

    private final void y(Painter painter) {
        this.f30124g = painter;
        t(painter);
    }

    private final void z(c cVar) {
        this.f30123f = cVar;
        w(cVar);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        n(f10);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        o(colorFilter);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2089getIntrinsicSizeNHjbRc() {
        Painter painterK = k();
        return painterK != null ? painterK.mo2089getIntrinsicSizeNHjbRc() : Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    @NotNull
    public final j.e j() {
        return (j.e) this.f30132o.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final v.i l() {
        return (v.i) this.f30131n.getValue();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        g();
        Object obj = this.f30124g;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        this.f30119b.setValue(Size.m1424boximpl(drawScope.mo1996getSizeNHjbRc()));
        Painter painterK = k();
        if (painterK != null) {
            painterK.m2095drawx_KDEd0(drawScope, drawScope.mo1996getSizeNHjbRc(), h(), i());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        g();
        Object obj = this.f30124g;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        if (this.f30118a != null) {
            return;
        }
        o0 o0VarA = p0.a(y2.b(null, 1, null).plus(e1.c().getImmediate()));
        this.f30118a = o0VarA;
        Object obj = this.f30124g;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onRemembered();
        }
        if (!this.f30129l) {
            kotlinx.coroutines.k.d(o0VarA, null, null, new d(null), 3, null);
        } else {
            Drawable drawableF = v.i.R(l(), null, 1, null).c(j().a()).a().F();
            D(new c.C0613c(drawableF != null ? A(drawableF) : null));
        }
    }

    public final void p(@NotNull ContentScale contentScale) {
        this.f30127j = contentScale;
    }

    public final void q(int i10) {
        this.f30128k = i10;
    }

    public final void r(@NotNull j.e eVar) {
        this.f30132o.setValue(eVar);
    }

    public final void s(@Nullable l<? super c, k0> lVar) {
        this.f30126i = lVar;
    }

    public final void u(boolean z10) {
        this.f30129l = z10;
    }

    public final void v(@NotNull v.i iVar) {
        this.f30131n.setValue(iVar);
    }

    public final void x(@NotNull l<? super c, ? extends c> lVar) {
        this.f30125h = lVar;
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    static final class a extends v implements l<c, c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f30133g = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke(@NotNull c cVar) {
            return cVar;
        }
    }

    /* JADX INFO: compiled from: ImageRequest.kt */
    public static final class e implements x.a {
        public e() {
        }

        @Override // x.a
        public void b(@Nullable Drawable drawable) {
            b.this.D(new c.C0613c(drawable != null ? b.this.A(drawable) : null));
        }

        @Override // x.a
        public void a(@NotNull Drawable drawable) {
        }

        @Override // x.a
        public void c(@Nullable Drawable drawable) {
        }
    }
}

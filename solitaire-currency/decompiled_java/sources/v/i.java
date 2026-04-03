package v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import ga.u;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlinx.coroutines.k0;
import m.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import t.c;
import v.o;
import z.c;

/* JADX INFO: compiled from: ImageRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @NotNull
    private final Lifecycle A;

    @NotNull
    private final w.j B;

    @NotNull
    private final w.h C;

    @NotNull
    private final o D;

    @Nullable
    private final c.b E;

    @Nullable
    private final Integer F;

    @Nullable
    private final Drawable G;

    @Nullable
    private final Integer H;

    @Nullable
    private final Drawable I;

    @Nullable
    private final Integer J;

    @Nullable
    private final Drawable K;

    @NotNull
    private final d L;

    @NotNull
    private final c M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f34885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object f34886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final x.a f34887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final b f34888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final c.b f34889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final String f34890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Bitmap.Config f34891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final ColorSpace f34892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final w.e f34893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final v8.s<i.a<?>, Class<?>> f34894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final i.a f34895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<y.a> f34896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final c.a f34897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final ga.u f34898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final s f34899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f34900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f34901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f34902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f34903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final v.b f34904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final v.b f34905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private final v.b f34906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private final k0 f34907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private final k0 f34908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final k0 f34909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private final k0 f34910z;

    /* JADX INFO: compiled from: ImageRequest.kt */
    public interface b {
        @MainThread
        void a(@NotNull i iVar, @NotNull r rVar);

        @MainThread
        void b(@NotNull i iVar);

        @MainThread
        void c(@NotNull i iVar, @NotNull f fVar);

        @MainThread
        void d(@NotNull i iVar);
    }

    public /* synthetic */ i(Context context, Object obj, x.a aVar, b bVar, c.b bVar2, String str, Bitmap.Config config, ColorSpace colorSpace, w.e eVar, v8.s sVar, i.a aVar2, List list, c.a aVar3, ga.u uVar, s sVar2, boolean z10, boolean z11, boolean z12, boolean z13, v.b bVar3, v.b bVar4, v.b bVar5, k0 k0Var, k0 k0Var2, k0 k0Var3, k0 k0Var4, Lifecycle lifecycle, w.j jVar, w.h hVar, o oVar, c.b bVar6, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, d dVar, c cVar, kotlin.jvm.internal.k kVar) {
        this(context, obj, aVar, bVar, bVar2, str, config, colorSpace, eVar, sVar, aVar2, list, aVar3, uVar, sVar2, z10, z11, z12, z13, bVar3, bVar4, bVar5, k0Var, k0Var2, k0Var3, k0Var4, lifecycle, jVar, hVar, oVar, bVar6, num, drawable, num2, drawable2, num3, drawable3, dVar, cVar);
    }

    public static /* synthetic */ a R(i iVar, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = iVar.f34885a;
        }
        return iVar.Q(context);
    }

    @Nullable
    public final b A() {
        return this.f34888d;
    }

    @Nullable
    public final c.b B() {
        return this.f34889e;
    }

    @NotNull
    public final v.b C() {
        return this.f34904t;
    }

    @NotNull
    public final v.b D() {
        return this.f34906v;
    }

    @NotNull
    public final o E() {
        return this.D;
    }

    @Nullable
    public final Drawable F() {
        return a0.i.c(this, this.G, this.F, this.M.l());
    }

    @Nullable
    public final c.b G() {
        return this.E;
    }

    @NotNull
    public final w.e H() {
        return this.f34893i;
    }

    public final boolean I() {
        return this.f34903s;
    }

    @NotNull
    public final w.h J() {
        return this.C;
    }

    @NotNull
    public final w.j K() {
        return this.B;
    }

    @NotNull
    public final s L() {
        return this.f34899o;
    }

    @Nullable
    public final x.a M() {
        return this.f34887c;
    }

    @NotNull
    public final k0 N() {
        return this.f34910z;
    }

    @NotNull
    public final List<y.a> O() {
        return this.f34896l;
    }

    @NotNull
    public final c.a P() {
        return this.f34897m;
    }

    @NotNull
    public final a Q(@NotNull Context context) {
        return new a(this, context);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (kotlin.jvm.internal.t.d(this.f34885a, iVar.f34885a) && kotlin.jvm.internal.t.d(this.f34886b, iVar.f34886b) && kotlin.jvm.internal.t.d(this.f34887c, iVar.f34887c) && kotlin.jvm.internal.t.d(this.f34888d, iVar.f34888d) && kotlin.jvm.internal.t.d(this.f34889e, iVar.f34889e) && kotlin.jvm.internal.t.d(this.f34890f, iVar.f34890f) && this.f34891g == iVar.f34891g && ((Build.VERSION.SDK_INT < 26 || kotlin.jvm.internal.t.d(this.f34892h, iVar.f34892h)) && this.f34893i == iVar.f34893i && kotlin.jvm.internal.t.d(this.f34894j, iVar.f34894j) && kotlin.jvm.internal.t.d(this.f34895k, iVar.f34895k) && kotlin.jvm.internal.t.d(this.f34896l, iVar.f34896l) && kotlin.jvm.internal.t.d(this.f34897m, iVar.f34897m) && kotlin.jvm.internal.t.d(this.f34898n, iVar.f34898n) && kotlin.jvm.internal.t.d(this.f34899o, iVar.f34899o) && this.f34900p == iVar.f34900p && this.f34901q == iVar.f34901q && this.f34902r == iVar.f34902r && this.f34903s == iVar.f34903s && this.f34904t == iVar.f34904t && this.f34905u == iVar.f34905u && this.f34906v == iVar.f34906v && kotlin.jvm.internal.t.d(this.f34907w, iVar.f34907w) && kotlin.jvm.internal.t.d(this.f34908x, iVar.f34908x) && kotlin.jvm.internal.t.d(this.f34909y, iVar.f34909y) && kotlin.jvm.internal.t.d(this.f34910z, iVar.f34910z) && kotlin.jvm.internal.t.d(this.E, iVar.E) && kotlin.jvm.internal.t.d(this.F, iVar.F) && kotlin.jvm.internal.t.d(this.G, iVar.G) && kotlin.jvm.internal.t.d(this.H, iVar.H) && kotlin.jvm.internal.t.d(this.I, iVar.I) && kotlin.jvm.internal.t.d(this.J, iVar.J) && kotlin.jvm.internal.t.d(this.K, iVar.K) && kotlin.jvm.internal.t.d(this.A, iVar.A) && kotlin.jvm.internal.t.d(this.B, iVar.B) && this.C == iVar.C && kotlin.jvm.internal.t.d(this.D, iVar.D) && kotlin.jvm.internal.t.d(this.L, iVar.L) && kotlin.jvm.internal.t.d(this.M, iVar.M))) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        return this.f34900p;
    }

    public final boolean h() {
        return this.f34901q;
    }

    public int hashCode() {
        int iHashCode = ((this.f34885a.hashCode() * 31) + this.f34886b.hashCode()) * 31;
        x.a aVar = this.f34887c;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        b bVar = this.f34888d;
        int iHashCode3 = (iHashCode2 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        c.b bVar2 = this.f34889e;
        int iHashCode4 = (iHashCode3 + (bVar2 != null ? bVar2.hashCode() : 0)) * 31;
        String str = this.f34890f;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.f34891g.hashCode()) * 31;
        ColorSpace colorSpace = this.f34892h;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.f34893i.hashCode()) * 31;
        v8.s<i.a<?>, Class<?>> sVar = this.f34894j;
        int iHashCode7 = (iHashCode6 + (sVar != null ? sVar.hashCode() : 0)) * 31;
        i.a aVar2 = this.f34895k;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31) + this.f34896l.hashCode()) * 31) + this.f34897m.hashCode()) * 31) + this.f34898n.hashCode()) * 31) + this.f34899o.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f34900p)) * 31) + androidx.compose.foundation.e.a(this.f34901q)) * 31) + androidx.compose.foundation.e.a(this.f34902r)) * 31) + androidx.compose.foundation.e.a(this.f34903s)) * 31) + this.f34904t.hashCode()) * 31) + this.f34905u.hashCode()) * 31) + this.f34906v.hashCode()) * 31) + this.f34907w.hashCode()) * 31) + this.f34908x.hashCode()) * 31) + this.f34909y.hashCode()) * 31) + this.f34910z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31;
        c.b bVar3 = this.E;
        int iHashCode9 = (iHashCode8 + (bVar3 != null ? bVar3.hashCode() : 0)) * 31;
        Integer num = this.F;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.G;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.H;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.I;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.J;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.K;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.L.hashCode()) * 31) + this.M.hashCode();
    }

    public final boolean i() {
        return this.f34902r;
    }

    @NotNull
    public final Bitmap.Config j() {
        return this.f34891g;
    }

    @Nullable
    public final ColorSpace k() {
        return this.f34892h;
    }

    @NotNull
    public final Context l() {
        return this.f34885a;
    }

    @NotNull
    public final Object m() {
        return this.f34886b;
    }

    @NotNull
    public final k0 n() {
        return this.f34909y;
    }

    @Nullable
    public final i.a o() {
        return this.f34895k;
    }

    @NotNull
    public final c p() {
        return this.M;
    }

    @NotNull
    public final d q() {
        return this.L;
    }

    @Nullable
    public final String r() {
        return this.f34890f;
    }

    @NotNull
    public final v.b s() {
        return this.f34905u;
    }

    @Nullable
    public final Drawable t() {
        return a0.i.c(this, this.I, this.H, this.M.f());
    }

    @Nullable
    public final Drawable u() {
        return a0.i.c(this, this.K, this.J, this.M.g());
    }

    @NotNull
    public final k0 v() {
        return this.f34908x;
    }

    @Nullable
    public final v8.s<i.a<?>, Class<?>> w() {
        return this.f34894j;
    }

    @NotNull
    public final ga.u x() {
        return this.f34898n;
    }

    @NotNull
    public final k0 y() {
        return this.f34907w;
    }

    @NotNull
    public final Lifecycle z() {
        return this.A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private i(Context context, Object obj, x.a aVar, b bVar, c.b bVar2, String str, Bitmap.Config config, ColorSpace colorSpace, w.e eVar, v8.s<? extends i.a<?>, ? extends Class<?>> sVar, i.a aVar2, List<? extends y.a> list, c.a aVar3, ga.u uVar, s sVar2, boolean z10, boolean z11, boolean z12, boolean z13, v.b bVar3, v.b bVar4, v.b bVar5, k0 k0Var, k0 k0Var2, k0 k0Var3, k0 k0Var4, Lifecycle lifecycle, w.j jVar, w.h hVar, o oVar, c.b bVar6, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, d dVar, c cVar) {
        this.f34885a = context;
        this.f34886b = obj;
        this.f34887c = aVar;
        this.f34888d = bVar;
        this.f34889e = bVar2;
        this.f34890f = str;
        this.f34891g = config;
        this.f34892h = colorSpace;
        this.f34893i = eVar;
        this.f34894j = sVar;
        this.f34895k = aVar2;
        this.f34896l = list;
        this.f34897m = aVar3;
        this.f34898n = uVar;
        this.f34899o = sVar2;
        this.f34900p = z10;
        this.f34901q = z11;
        this.f34902r = z12;
        this.f34903s = z13;
        this.f34904t = bVar3;
        this.f34905u = bVar4;
        this.f34906v = bVar5;
        this.f34907w = k0Var;
        this.f34908x = k0Var2;
        this.f34909y = k0Var3;
        this.f34910z = k0Var4;
        this.A = lifecycle;
        this.B = jVar;
        this.C = hVar;
        this.D = oVar;
        this.E = bVar6;
        this.F = num;
        this.G = drawable;
        this.H = num2;
        this.I = drawable2;
        this.J = num3;
        this.K = drawable3;
        this.L = dVar;
        this.M = cVar;
    }

    /* JADX INFO: compiled from: ImageRequest.kt */
    public static final class a {

        @Nullable
        private k0 A;

        @Nullable
        private o.a B;

        @Nullable
        private c.b C;

        @DrawableRes
        @Nullable
        private Integer D;

        @Nullable
        private Drawable E;

        @DrawableRes
        @Nullable
        private Integer F;

        @Nullable
        private Drawable G;

        @DrawableRes
        @Nullable
        private Integer H;

        @Nullable
        private Drawable I;

        @Nullable
        private Lifecycle J;

        @Nullable
        private w.j K;

        @Nullable
        private w.h L;

        @Nullable
        private Lifecycle M;

        @Nullable
        private w.j N;

        @Nullable
        private w.h O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Context f34911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private c f34912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Object f34913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private x.a f34914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private b f34915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private c.b f34916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private String f34917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private Bitmap.Config f34918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private ColorSpace f34919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private w.e f34920j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private v8.s<? extends i.a<?>, ? extends Class<?>> f34921k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        private i.a f34922l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @NotNull
        private List<? extends y.a> f34923m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        private c.a f34924n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Nullable
        private u.a f34925o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Nullable
        private Map<Class<?>, Object> f34926p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f34927q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Nullable
        private Boolean f34928r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        private Boolean f34929s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f34930t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        private v.b f34931u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        private v.b f34932v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        private v.b f34933w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        private k0 f34934x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @Nullable
        private k0 f34935y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        @Nullable
        private k0 f34936z;

        public a(@NotNull Context context) {
            this.f34911a = context;
            this.f34912b = a0.i.b();
            this.f34913c = null;
            this.f34914d = null;
            this.f34915e = null;
            this.f34916f = null;
            this.f34917g = null;
            this.f34918h = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f34919i = null;
            }
            this.f34920j = null;
            this.f34921k = null;
            this.f34922l = null;
            this.f34923m = kotlin.collections.v.l();
            this.f34924n = null;
            this.f34925o = null;
            this.f34926p = null;
            this.f34927q = true;
            this.f34928r = null;
            this.f34929s = null;
            this.f34930t = true;
            this.f34931u = null;
            this.f34932v = null;
            this.f34933w = null;
            this.f34934x = null;
            this.f34935y = null;
            this.f34936z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final void e() {
            this.O = null;
        }

        private final void f() {
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final Lifecycle g() {
            x.a aVar = this.f34914d;
            Lifecycle lifecycleC = a0.d.c(aVar instanceof x.b ? ((x.b) aVar).getView().getContext() : this.f34911a);
            return lifecycleC == null ? h.f34883a : lifecycleC;
        }

        private final w.h h() {
            View view;
            w.j jVar = this.K;
            View view2 = null;
            w.l lVar = jVar instanceof w.l ? (w.l) jVar : null;
            if (lVar == null || (view = lVar.getView()) == null) {
                x.a aVar = this.f34914d;
                x.b bVar = aVar instanceof x.b ? (x.b) aVar : null;
                if (bVar != null) {
                    view2 = bVar.getView();
                }
            } else {
                view2 = view;
            }
            return view2 instanceof ImageView ? a0.j.n((ImageView) view2) : w.h.FIT;
        }

        private final w.j i() {
            x.a aVar = this.f34914d;
            if (!(aVar instanceof x.b)) {
                return new w.d(this.f34911a);
            }
            View view = ((x.b) aVar).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    return w.k.a(w.i.f35274d);
                }
            }
            return w.m.b(view, false, 2, null);
        }

        @NotNull
        public final i a() {
            Context context = this.f34911a;
            Object obj = this.f34913c;
            if (obj == null) {
                obj = k.f34937a;
            }
            Object obj2 = obj;
            x.a aVar = this.f34914d;
            b bVar = this.f34915e;
            c.b bVar2 = this.f34916f;
            String str = this.f34917g;
            Bitmap.Config configC = this.f34918h;
            if (configC == null) {
                configC = this.f34912b.c();
            }
            Bitmap.Config config = configC;
            ColorSpace colorSpace = this.f34919i;
            w.e eVarM = this.f34920j;
            if (eVarM == null) {
                eVarM = this.f34912b.m();
            }
            w.e eVar = eVarM;
            v8.s<? extends i.a<?>, ? extends Class<?>> sVar = this.f34921k;
            i.a aVar2 = this.f34922l;
            List<? extends y.a> list = this.f34923m;
            c.a aVarO = this.f34924n;
            if (aVarO == null) {
                aVarO = this.f34912b.o();
            }
            c.a aVar3 = aVarO;
            u.a aVar4 = this.f34925o;
            ga.u uVarV = a0.j.v(aVar4 != null ? aVar4.f() : null);
            Map<Class<?>, ? extends Object> map = this.f34926p;
            s sVarX = a0.j.x(map != null ? s.f34970b.a(map) : null);
            boolean z10 = this.f34927q;
            Boolean bool = this.f34928r;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.f34912b.a();
            Boolean bool2 = this.f34929s;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.f34912b.b();
            boolean z11 = this.f34930t;
            v.b bVarJ = this.f34931u;
            if (bVarJ == null) {
                bVarJ = this.f34912b.j();
            }
            v.b bVar3 = bVarJ;
            v.b bVarE = this.f34932v;
            if (bVarE == null) {
                bVarE = this.f34912b.e();
            }
            v.b bVar4 = bVarE;
            v.b bVarK = this.f34933w;
            if (bVarK == null) {
                bVarK = this.f34912b.k();
            }
            v.b bVar5 = bVarK;
            k0 k0VarI = this.f34934x;
            if (k0VarI == null) {
                k0VarI = this.f34912b.i();
            }
            k0 k0Var = k0VarI;
            k0 k0VarH = this.f34935y;
            if (k0VarH == null) {
                k0VarH = this.f34912b.h();
            }
            k0 k0Var2 = k0VarH;
            k0 k0VarD = this.f34936z;
            if (k0VarD == null) {
                k0VarD = this.f34912b.d();
            }
            k0 k0Var3 = k0VarD;
            k0 k0VarN = this.A;
            if (k0VarN == null) {
                k0VarN = this.f34912b.n();
            }
            k0 k0Var4 = k0VarN;
            Lifecycle lifecycleG = this.J;
            if (lifecycleG == null && (lifecycleG = this.M) == null) {
                lifecycleG = g();
            }
            Lifecycle lifecycle = lifecycleG;
            w.j jVarI = this.K;
            if (jVarI == null && (jVarI = this.N) == null) {
                jVarI = i();
            }
            w.j jVar = jVarI;
            w.h hVarH = this.L;
            if (hVarH == null && (hVarH = this.O) == null) {
                hVarH = h();
            }
            w.h hVar = hVarH;
            o.a aVar5 = this.B;
            return new i(context, obj2, aVar, bVar, bVar2, str, config, colorSpace, eVar, sVar, aVar2, list, aVar3, uVarV, sVarX, z10, zBooleanValue, zBooleanValue2, z11, bVar3, bVar4, bVar5, k0Var, k0Var2, k0Var3, k0Var4, lifecycle, jVar, hVar, a0.j.w(aVar5 != null ? aVar5.a() : null), this.C, this.D, this.E, this.F, this.G, this.H, this.I, new d(this.J, this.K, this.L, this.f34934x, this.f34935y, this.f34936z, this.A, this.f34924n, this.f34920j, this.f34918h, this.f34928r, this.f34929s, this.f34931u, this.f34932v, this.f34933w), this.f34912b, null);
        }

        @NotNull
        public final a b(@Nullable Object obj) {
            this.f34913c = obj;
            return this;
        }

        @NotNull
        public final a c(@NotNull c cVar) {
            this.f34912b = cVar;
            e();
            return this;
        }

        @NotNull
        public final a d(@NotNull w.e eVar) {
            this.f34920j = eVar;
            return this;
        }

        @NotNull
        public final a j(@NotNull w.h hVar) {
            this.L = hVar;
            return this;
        }

        @NotNull
        public final a k(@NotNull w.j jVar) {
            this.K = jVar;
            f();
            return this;
        }

        @NotNull
        public final a l(@Nullable x.a aVar) {
            this.f34914d = aVar;
            f();
            return this;
        }

        public a(@NotNull i iVar, @NotNull Context context) {
            this.f34911a = context;
            this.f34912b = iVar.p();
            this.f34913c = iVar.m();
            this.f34914d = iVar.M();
            this.f34915e = iVar.A();
            this.f34916f = iVar.B();
            this.f34917g = iVar.r();
            this.f34918h = iVar.q().c();
            if (Build.VERSION.SDK_INT >= 26) {
                this.f34919i = iVar.k();
            }
            this.f34920j = iVar.q().k();
            this.f34921k = iVar.w();
            this.f34922l = iVar.o();
            this.f34923m = iVar.O();
            this.f34924n = iVar.q().o();
            this.f34925o = iVar.x().f();
            this.f34926p = r0.z(iVar.L().a());
            this.f34927q = iVar.g();
            this.f34928r = iVar.q().a();
            this.f34929s = iVar.q().b();
            this.f34930t = iVar.I();
            this.f34931u = iVar.q().i();
            this.f34932v = iVar.q().e();
            this.f34933w = iVar.q().j();
            this.f34934x = iVar.q().g();
            this.f34935y = iVar.q().f();
            this.f34936z = iVar.q().d();
            this.A = iVar.q().n();
            this.B = iVar.E().e();
            this.C = iVar.G();
            this.D = iVar.F;
            this.E = iVar.G;
            this.F = iVar.H;
            this.G = iVar.I;
            this.H = iVar.J;
            this.I = iVar.K;
            this.J = iVar.q().h();
            this.K = iVar.q().m();
            this.L = iVar.q().l();
            if (iVar.l() == context) {
                this.M = iVar.z();
                this.N = iVar.K();
                this.O = iVar.J();
            } else {
                this.M = null;
                this.N = null;
                this.O = null;
            }
        }
    }
}

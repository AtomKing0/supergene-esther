package x4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final x4.c f36136m = new i(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f36137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f36138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f36139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f36140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    x4.c f36141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    x4.c f36142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    x4.c f36143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    x4.c f36144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f f36145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f36146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f36147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    f f36148l;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface c {
        @NonNull
        x4.c a(@NonNull x4.c cVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, @StyleRes int i10, @StyleRes int i11) {
        return c(context, i10, i11, 0);
    }

    @NonNull
    private static b c(Context context, @StyleRes int i10, @StyleRes int i11, int i12) {
        return d(context, i10, i11, new x4.a(i12));
    }

    @NonNull
    private static b d(Context context, @StyleRes int i10, @StyleRes int i11, @NonNull x4.c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(e4.k.f25011l4);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(e4.k.f25019m4, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(e4.k.f25043p4, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(e4.k.f25051q4, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(e4.k.f25035o4, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(e4.k.f25027n4, i12);
            x4.c cVarM = m(typedArrayObtainStyledAttributes, e4.k.f25059r4, cVar);
            x4.c cVarM2 = m(typedArrayObtainStyledAttributes, e4.k.f25083u4, cVarM);
            x4.c cVarM3 = m(typedArrayObtainStyledAttributes, e4.k.f25091v4, cVarM);
            x4.c cVarM4 = m(typedArrayObtainStyledAttributes, e4.k.f25075t4, cVarM);
            return new b().y(i13, cVarM2).C(i14, cVarM3).u(i15, cVarM4).q(i16, m(typedArrayObtainStyledAttributes, e4.k.f25067s4, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11, int i12) {
        return g(context, attributeSet, i10, i11, new x4.a(i12));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11, @NonNull x4.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.k.f25042p3, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(e4.k.f25050q3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(e4.k.f25058r3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    private static x4.c m(TypedArray typedArray, int i10, @NonNull x4.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i11 = typedValuePeekValue.type;
        return i11 == 5 ? new x4.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i11 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    @NonNull
    public f h() {
        return this.f36147k;
    }

    @NonNull
    public d i() {
        return this.f36140d;
    }

    @NonNull
    public x4.c j() {
        return this.f36144h;
    }

    @NonNull
    public d k() {
        return this.f36139c;
    }

    @NonNull
    public x4.c l() {
        return this.f36143g;
    }

    @NonNull
    public f n() {
        return this.f36148l;
    }

    @NonNull
    public f o() {
        return this.f36146j;
    }

    @NonNull
    public f p() {
        return this.f36145i;
    }

    @NonNull
    public d q() {
        return this.f36137a;
    }

    @NonNull
    public x4.c r() {
        return this.f36141e;
    }

    @NonNull
    public d s() {
        return this.f36138b;
    }

    @NonNull
    public x4.c t() {
        return this.f36142f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        boolean z10 = this.f36148l.getClass().equals(f.class) && this.f36146j.getClass().equals(f.class) && this.f36145i.getClass().equals(f.class) && this.f36147k.getClass().equals(f.class);
        float fA = this.f36141e.a(rectF);
        return z10 && ((this.f36142f.a(rectF) > fA ? 1 : (this.f36142f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f36144h.a(rectF) > fA ? 1 : (this.f36144h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f36143g.a(rectF) > fA ? 1 : (this.f36143g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f36138b instanceof j) && (this.f36137a instanceof j) && (this.f36139c instanceof j) && (this.f36140d instanceof j));
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public k w(float f10) {
        return v().o(f10).m();
    }

    @NonNull
    public k x(@NonNull x4.c cVar) {
        return v().p(cVar).m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public k y(@NonNull c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(@NonNull b bVar) {
        this.f36137a = bVar.f36149a;
        this.f36138b = bVar.f36150b;
        this.f36139c = bVar.f36151c;
        this.f36140d = bVar.f36152d;
        this.f36141e = bVar.f36153e;
        this.f36142f = bVar.f36154f;
        this.f36143g = bVar.f36155g;
        this.f36144h = bVar.f36156h;
        this.f36145i = bVar.f36157i;
        this.f36146j = bVar.f36158j;
        this.f36147k = bVar.f36159k;
        this.f36148l = bVar.f36160l;
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private d f36149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        private d f36150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        private d f36151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private d f36152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private x4.c f36153e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        private x4.c f36154f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        private x4.c f36155g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        private x4.c f36156h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        private f f36157i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        private f f36158j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NonNull
        private f f36159k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NonNull
        private f f36160l;

        public b() {
            this.f36149a = h.b();
            this.f36150b = h.b();
            this.f36151c = h.b();
            this.f36152d = h.b();
            this.f36153e = new x4.a(0.0f);
            this.f36154f = new x4.a(0.0f);
            this.f36155g = new x4.a(0.0f);
            this.f36156h = new x4.a(0.0f);
            this.f36157i = h.c();
            this.f36158j = h.c();
            this.f36159k = h.c();
            this.f36160l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f36135a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f36083a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(@Dimension float f10) {
            this.f36153e = new x4.a(f10);
            return this;
        }

        @NonNull
        public b B(@NonNull x4.c cVar) {
            this.f36153e = cVar;
            return this;
        }

        @NonNull
        public b C(int i10, @NonNull x4.c cVar) {
            return D(h.a(i10)).F(cVar);
        }

        @NonNull
        public b D(@NonNull d dVar) {
            this.f36150b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        @NonNull
        public b E(@Dimension float f10) {
            this.f36154f = new x4.a(f10);
            return this;
        }

        @NonNull
        public b F(@NonNull x4.c cVar) {
            this.f36154f = cVar;
            return this;
        }

        @NonNull
        public k m() {
            return new k(this);
        }

        @NonNull
        public b o(@Dimension float f10) {
            return A(f10).E(f10).w(f10).s(f10);
        }

        @NonNull
        public b p(@NonNull x4.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        @NonNull
        public b q(int i10, @NonNull x4.c cVar) {
            return r(h.a(i10)).t(cVar);
        }

        @NonNull
        public b r(@NonNull d dVar) {
            this.f36152d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        @NonNull
        public b s(@Dimension float f10) {
            this.f36156h = new x4.a(f10);
            return this;
        }

        @NonNull
        public b t(@NonNull x4.c cVar) {
            this.f36156h = cVar;
            return this;
        }

        @NonNull
        public b u(int i10, @NonNull x4.c cVar) {
            return v(h.a(i10)).x(cVar);
        }

        @NonNull
        public b v(@NonNull d dVar) {
            this.f36151c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        @NonNull
        public b w(@Dimension float f10) {
            this.f36155g = new x4.a(f10);
            return this;
        }

        @NonNull
        public b x(@NonNull x4.c cVar) {
            this.f36155g = cVar;
            return this;
        }

        @NonNull
        public b y(int i10, @NonNull x4.c cVar) {
            return z(h.a(i10)).B(cVar);
        }

        @NonNull
        public b z(@NonNull d dVar) {
            this.f36149a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }

        public b(@NonNull k kVar) {
            this.f36149a = h.b();
            this.f36150b = h.b();
            this.f36151c = h.b();
            this.f36152d = h.b();
            this.f36153e = new x4.a(0.0f);
            this.f36154f = new x4.a(0.0f);
            this.f36155g = new x4.a(0.0f);
            this.f36156h = new x4.a(0.0f);
            this.f36157i = h.c();
            this.f36158j = h.c();
            this.f36159k = h.c();
            this.f36160l = h.c();
            this.f36149a = kVar.f36137a;
            this.f36150b = kVar.f36138b;
            this.f36151c = kVar.f36139c;
            this.f36152d = kVar.f36140d;
            this.f36153e = kVar.f36141e;
            this.f36154f = kVar.f36142f;
            this.f36155g = kVar.f36143g;
            this.f36156h = kVar.f36144h;
            this.f36157i = kVar.f36145i;
            this.f36158j = kVar.f36146j;
            this.f36159k = kVar.f36147k;
            this.f36160l = kVar.f36148l;
        }
    }

    public k() {
        this.f36137a = h.b();
        this.f36138b = h.b();
        this.f36139c = h.b();
        this.f36140d = h.b();
        this.f36141e = new x4.a(0.0f);
        this.f36142f = new x4.a(0.0f);
        this.f36143g = new x4.a(0.0f);
        this.f36144h = new x4.a(0.0f);
        this.f36145i = h.c();
        this.f36146j = h.c();
        this.f36147k = h.c();
        this.f36148l = h.c();
    }
}

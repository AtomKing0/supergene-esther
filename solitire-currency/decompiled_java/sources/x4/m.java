package x4;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f36179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f36180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f36181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f36182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f36183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f36184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f36185g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f36186h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f36187i;

    /* JADX INFO: compiled from: ShapePath.java */
    class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f36188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f36189d;

        a(List list, Matrix matrix) {
            this.f36188c = list;
            this.f36189d = matrix;
        }

        @Override // x4.m.g
        public void a(Matrix matrix, w4.a aVar, int i10, Canvas canvas) {
            Iterator it = this.f36188c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f36189d, aVar, i10, canvas);
            }
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f36191c;

        public b(d dVar) {
            this.f36191c = dVar;
        }

        @Override // x4.m.g
        public void a(Matrix matrix, @NonNull w4.a aVar, int i10, @NonNull Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f36191c.k(), this.f36191c.o(), this.f36191c.l(), this.f36191c.j()), i10, this.f36191c.m(), this.f36191c.n());
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e f36192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f36193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f36194e;

        public c(e eVar, float f10, float f11) {
            this.f36192c = eVar;
            this.f36193d = f10;
            this.f36194e = f11;
        }

        @Override // x4.m.g
        public void a(Matrix matrix, @NonNull w4.a aVar, int i10, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f36192c.f36203c - this.f36194e, this.f36192c.f36202b - this.f36193d), 0.0f);
            this.f36206a.set(matrix);
            this.f36206a.preTranslate(this.f36193d, this.f36194e);
            this.f36206a.preRotate(c());
            aVar.b(canvas, this.f36206a, rectF, i10);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f36192c.f36203c - this.f36194e) / (this.f36192c.f36202b - this.f36193d)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f36195h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f36196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f36197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f36198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f36199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f36200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f36201g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f36199e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f36196b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f36198d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f36200f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f36201g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f36197c;
        }

        private void p(float f10) {
            this.f36199e = f10;
        }

        private void q(float f10) {
            this.f36196b = f10;
        }

        private void r(float f10) {
            this.f36198d = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f10) {
            this.f36200f = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f10) {
            this.f36201g = f10;
        }

        private void u(float f10) {
            this.f36197c = f10;
        }

        @Override // x4.m.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f36204a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f36195h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f36203c;

        @Override // x4.m.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f36204a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f36202b, this.f36203c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f36204a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Matrix f36205b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f36206a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, w4.a aVar, int i10, Canvas canvas);

        public final void b(w4.a aVar, int i10, Canvas canvas) {
            a(f36205b, aVar, i10, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f10) {
        if (g() == f10) {
            return;
        }
        float fG = ((f10 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f36186h.add(new b(dVar));
        p(f10);
    }

    private void c(g gVar, float f10, float f11) {
        b(f10);
        this.f36186h.add(gVar);
        p(f11);
    }

    private float g() {
        return this.f36183e;
    }

    private float h() {
        return this.f36184f;
    }

    private void p(float f10) {
        this.f36183e = f10;
    }

    private void q(float f10) {
        this.f36184f = f10;
    }

    private void r(float f10) {
        this.f36181c = f10;
    }

    private void s(float f10) {
        this.f36182d = f10;
    }

    private void t(float f10) {
        this.f36179a = f10;
    }

    private void u(float f10) {
        this.f36180b = f10;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f36185g.add(dVar);
        b bVar = new b(dVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f36185g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f36185g.get(i10).a(matrix, path);
        }
    }

    boolean e() {
        return this.f36187i;
    }

    @NonNull
    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f36186h), new Matrix(matrix));
    }

    float i() {
        return this.f36181c;
    }

    float j() {
        return this.f36182d;
    }

    float k() {
        return this.f36179a;
    }

    float l() {
        return this.f36180b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f36202b = f10;
        eVar.f36203c = f11;
        this.f36185g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f36185g.clear();
        this.f36186h.clear();
        this.f36187i = false;
    }
}

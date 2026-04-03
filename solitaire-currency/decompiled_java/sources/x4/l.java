package x4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m[] f36161a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f36162b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f36163c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f36164d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f36165e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f36166f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f36167g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f36168h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f36169i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f36170j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f36171k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f36172l = true;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final l f36173a = new l();
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
        void a(m mVar, Matrix matrix, int i10);

        void b(m mVar, Matrix matrix, int i10);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final k f36174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Path f36175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final RectF f36176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f36177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f36178e;

        c(@NonNull k kVar, float f10, RectF rectF, @Nullable b bVar, Path path) {
            this.f36177d = bVar;
            this.f36174a = kVar;
            this.f36178e = f10;
            this.f36176c = rectF;
            this.f36175b = path;
        }
    }

    public l() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f36161a[i10] = new m();
            this.f36162b[i10] = new Matrix();
            this.f36163c[i10] = new Matrix();
        }
    }

    private float a(int i10) {
        return ((i10 + 1) % 4) * 90;
    }

    private void b(@NonNull c cVar, int i10) {
        this.f36168h[0] = this.f36161a[i10].k();
        this.f36168h[1] = this.f36161a[i10].l();
        this.f36162b[i10].mapPoints(this.f36168h);
        if (i10 == 0) {
            Path path = cVar.f36175b;
            float[] fArr = this.f36168h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f36175b;
            float[] fArr2 = this.f36168h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f36161a[i10].d(this.f36162b[i10], cVar.f36175b);
        b bVar = cVar.f36177d;
        if (bVar != null) {
            bVar.b(this.f36161a[i10], this.f36162b[i10], i10);
        }
    }

    private void c(@NonNull c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f36168h[0] = this.f36161a[i10].i();
        this.f36168h[1] = this.f36161a[i10].j();
        this.f36162b[i10].mapPoints(this.f36168h);
        this.f36169i[0] = this.f36161a[i11].k();
        this.f36169i[1] = this.f36161a[i11].l();
        this.f36162b[i11].mapPoints(this.f36169i);
        float f10 = this.f36168h[0];
        float[] fArr = this.f36169i;
        float fMax = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f36176c, i10);
        this.f36167g.n(0.0f, 0.0f);
        f fVarJ = j(i10, cVar.f36174a);
        fVarJ.c(fMax, fI, cVar.f36178e, this.f36167g);
        this.f36170j.reset();
        this.f36167g.d(this.f36163c[i10], this.f36170j);
        if (this.f36172l && (fVarJ.b() || l(this.f36170j, i10) || l(this.f36170j, i11))) {
            Path path = this.f36170j;
            path.op(path, this.f36166f, Path.Op.DIFFERENCE);
            this.f36168h[0] = this.f36167g.k();
            this.f36168h[1] = this.f36167g.l();
            this.f36163c[i10].mapPoints(this.f36168h);
            Path path2 = this.f36165e;
            float[] fArr2 = this.f36168h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f36167g.d(this.f36163c[i10], this.f36165e);
        } else {
            this.f36167g.d(this.f36163c[i10], cVar.f36175b);
        }
        b bVar = cVar.f36177d;
        if (bVar != null) {
            bVar.a(this.f36167g, this.f36163c[i10], i10);
        }
    }

    private void f(int i10, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private x4.c g(int i10, @NonNull k kVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i10, @NonNull k kVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(@NonNull RectF rectF, int i10) {
        float[] fArr = this.f36168h;
        m mVar = this.f36161a[i10];
        fArr[0] = mVar.f36181c;
        fArr[1] = mVar.f36182d;
        this.f36162b[i10].mapPoints(fArr);
        return (i10 == 1 || i10 == 3) ? Math.abs(rectF.centerX() - this.f36168h[0]) : Math.abs(rectF.centerY() - this.f36168h[1]);
    }

    private f j(int i10, @NonNull k kVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static l k() {
        return a.f36173a;
    }

    @RequiresApi(19)
    private boolean l(Path path, int i10) {
        this.f36171k.reset();
        this.f36161a[i10].d(this.f36162b[i10], this.f36171k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f36171k.computeBounds(rectF, true);
        path.op(this.f36171k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(@NonNull c cVar, int i10) {
        h(i10, cVar.f36174a).b(this.f36161a[i10], 90.0f, cVar.f36178e, cVar.f36176c, g(i10, cVar.f36174a));
        float fA = a(i10);
        this.f36162b[i10].reset();
        f(i10, cVar.f36176c, this.f36164d);
        Matrix matrix = this.f36162b[i10];
        PointF pointF = this.f36164d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f36162b[i10].preRotate(fA);
    }

    private void n(int i10) {
        this.f36168h[0] = this.f36161a[i10].i();
        this.f36168h[1] = this.f36161a[i10].j();
        this.f36162b[i10].mapPoints(this.f36168h);
        float fA = a(i10);
        this.f36163c[i10].reset();
        Matrix matrix = this.f36163c[i10];
        float[] fArr = this.f36168h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f36163c[i10].preRotate(fA);
    }

    public void d(k kVar, float f10, RectF rectF, @NonNull Path path) {
        e(kVar, f10, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(k kVar, float f10, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f36165e.rewind();
        this.f36166f.rewind();
        this.f36166f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            n(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f36165e.close();
        if (this.f36165e.isEmpty()) {
            return;
        }
        path.op(this.f36165e, Path.Op.UNION);
    }
}

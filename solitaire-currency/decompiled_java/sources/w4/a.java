package w4;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f35423i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f35424j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f35425k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f35426l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Paint f35427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Paint f35428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Paint f35429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f35432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f35433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f35434h;

    public a() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f35433g;
        if (z10) {
            int[] iArr = f35425k;
            iArr[0] = 0;
            iArr[1] = this.f35432f;
            iArr[2] = this.f35431e;
            iArr[3] = this.f35430d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f35425k;
            iArr2[0] = 0;
            iArr2[1] = this.f35430d;
            iArr2[2] = this.f35431e;
            iArr2[3] = this.f35432f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / fWidth);
        float[] fArr = f35426l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f35428b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f35425k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f35434h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f35428b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f35423i;
        iArr[0] = this.f35432f;
        iArr[1] = this.f35431e;
        iArr[2] = this.f35430d;
        Paint paint = this.f35429c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f35424j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f35429c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f35427a;
    }

    public void d(int i10) {
        this.f35430d = ColorUtils.setAlphaComponent(i10, 68);
        this.f35431e = ColorUtils.setAlphaComponent(i10, 20);
        this.f35432f = ColorUtils.setAlphaComponent(i10, 0);
        this.f35427a.setColor(this.f35430d);
    }

    public a(int i10) {
        this.f35433g = new Path();
        Paint paint = new Paint();
        this.f35434h = paint;
        this.f35427a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f35428b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f35429c = new Paint(paint2);
    }
}

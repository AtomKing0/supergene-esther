package p4;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import u4.b;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f32613f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f32614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32618e;

    public a(@NonNull Context context) {
        this(b.b(context, e4.b.f24760q, false), n4.a.b(context, e4.b.f24759p, 0), n4.a.b(context, e4.b.f24758o, 0), n4.a.b(context, e4.b.f24756m, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(@ColorInt int i10) {
        return ColorUtils.setAlphaComponent(i10, 255) == this.f32617d;
    }

    public float a(float f10) {
        if (this.f32618e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int b(@ColorInt int i10, float f10) {
        int i11;
        float fA = a(f10);
        int iAlpha = Color.alpha(i10);
        int iJ = n4.a.j(ColorUtils.setAlphaComponent(i10, 255), this.f32615b, fA);
        if (fA > 0.0f && (i11 = this.f32616c) != 0) {
            iJ = n4.a.i(iJ, ColorUtils.setAlphaComponent(i11, f32613f));
        }
        return ColorUtils.setAlphaComponent(iJ, iAlpha);
    }

    @ColorInt
    public int c(@ColorInt int i10, float f10) {
        return (this.f32614a && e(i10)) ? b(i10, f10) : i10;
    }

    public boolean d() {
        return this.f32614a;
    }

    public a(boolean z10, @ColorInt int i10, @ColorInt int i11, @ColorInt int i12, float f10) {
        this.f32614a = z10;
        this.f32615b = i10;
        this.f32616c = i11;
        this.f32617d = i12;
        this.f32618e = f10;
    }
}

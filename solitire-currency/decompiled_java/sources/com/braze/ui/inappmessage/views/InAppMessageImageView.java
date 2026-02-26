package com.braze.ui.inappmessage.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.braze.enums.inappmessage.CropType;
import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class InAppMessageImageView extends ImageView implements IInAppMessageImageView {
    private float aspectRatio;

    @NotNull
    private Path clipPath;
    private float[] inAppRadii;

    @NotNull
    private RectF rectf;
    private boolean setToHalfParentHeight;

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageImageView$clipCanvasToPath$2, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageImageView.kt */
    static final class AnonymousClass2 extends v implements h9.a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message radii is uninitialized, not clipping path.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageImageView$clipCanvasToPath$3, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageImageView.kt */
    static final class AnonymousClass3 extends v implements h9.a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Encountered exception while trying to clip in-app message image";
        }
    }

    public InAppMessageImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clipPath = new Path();
        this.rectf = new RectF();
        this.aspectRatio = -1.0f;
        setAdjustViewBounds(true);
    }

    public final boolean clipCanvasToPath(@NotNull Canvas canvas, int i10, int i11) {
        t.i(canvas, "canvas");
        if (this.inAppRadii == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) AnonymousClass2.INSTANCE, 7, (Object) null);
            return false;
        }
        try {
            this.clipPath.reset();
            this.rectf.set(0.0f, 0.0f, i10, i11);
            this.clipPath.addRoundRect(this.rectf, getInAppRadii(), Path.Direction.CW);
            canvas.clipPath(this.clipPath);
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) AnonymousClass3.INSTANCE, 4, (Object) null);
            return false;
        }
    }

    @NotNull
    public final Path getClipPath() {
        return this.clipPath;
    }

    @NotNull
    public final float[] getInAppRadii() {
        float[] fArr = this.inAppRadii;
        if (fArr != null) {
            return fArr;
        }
        t.A("inAppRadii");
        return null;
    }

    @NotNull
    public final RectF getRectf() {
        return this.rectf;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        clipCanvasToPath(canvas, getWidth(), getHeight());
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if ((this.aspectRatio == -1.0f) || getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(measuredWidth, Math.min(getMeasuredHeight(), (int) (measuredWidth / this.aspectRatio)) + 1);
        }
        if (this.setToHalfParentHeight) {
            Object parent = getParent();
            t.g(parent, "null cannot be cast to non-null type android.view.View");
            setMeasuredDimension(getMeasuredWidth(), (int) (((double) ((View) parent).getHeight()) * 0.5d));
        }
    }

    public void setAspectRatio(float f10) {
        this.aspectRatio = f10;
        requestLayout();
    }

    public final void setClipPath(@NotNull Path path) {
        t.i(path, "<set-?>");
        this.clipPath = path;
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageImageView
    public void setCornersRadiiPx(float f10, float f11, float f12, float f13) {
        this.inAppRadii = new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageImageView
    public void setCornersRadiusPx(float f10) {
        setCornersRadiiPx(f10, f10, f10, f10);
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageImageView
    public void setInAppMessageImageCropType(@Nullable CropType cropType) {
        if (cropType == CropType.FIT_CENTER) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (cropType == CropType.CENTER_CROP) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public final void setRectf(@NotNull RectF rectF) {
        t.i(rectF, "<set-?>");
        this.rectf = rectF;
    }

    public void setToHalfParentHeight(boolean z10) {
        this.setToHalfParentHeight = z10;
        requestLayout();
    }

    private static /* synthetic */ void getSetToHalfParentHeight$annotations() {
    }
}

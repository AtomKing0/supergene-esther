package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextPaint.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {

    @Nullable
    private Brush brush;

    @Nullable
    private Size brushSize;

    @NotNull
    private Shadow shadow;

    @NotNull
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i10, float f10) {
        super(i10);
        ((TextPaint) this).density = f10;
        this.textDecoration = TextDecoration.Companion.getNone();
        this.shadow = Shadow.Companion.getNone();
    }

    /* JADX INFO: renamed from: setBrush-d16Qtg0, reason: not valid java name */
    public final void m3525setBrushd16Qtg0(@Nullable Brush brush, long j10) {
        if (brush == null) {
            setShader(null);
            return;
        }
        if (t.d(this.brush, brush)) {
            Size size = this.brushSize;
            if (size == null ? false : Size.m1432equalsimpl0(size.m1441unboximpl(), j10)) {
                return;
            }
        }
        this.brush = brush;
        this.brushSize = Size.m1424boximpl(j10);
        if (brush instanceof SolidColor) {
            setShader(null);
            m3526setColor8_81llA(((SolidColor) brush).m1867getValue0d7_KjU());
        } else if (brush instanceof ShaderBrush) {
            if (j10 != Size.Companion.m1444getUnspecifiedNHjbRc()) {
                setShader(((ShaderBrush) brush).mo1573createShaderuvyYCjk(j10));
            }
        }
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m3526setColor8_81llA(long j10) {
        int iM1653toArgb8_81llA;
        if (!(j10 != Color.Companion.m1634getUnspecified0d7_KjU()) || getColor() == (iM1653toArgb8_81llA = ColorKt.m1653toArgb8_81llA(j10))) {
            return;
        }
        setColor(iM1653toArgb8_81llA);
    }

    public final void setShadow(@Nullable Shadow shadow) {
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        if (t.d(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (t.d(shadow, Shadow.Companion.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(this.shadow.getBlurRadius(), Offset.m1367getXimpl(this.shadow.m1866getOffsetF1C5BW0()), Offset.m1368getYimpl(this.shadow.m1866getOffsetF1C5BW0()), ColorKt.m1653toArgb8_81llA(this.shadow.m1865getColor0d7_KjU()));
        }
    }

    public final void setTextDecoration(@Nullable TextDecoration textDecoration) {
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        if (t.d(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.Companion;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }
}

package androidx.compose.ui.text.android.style;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlaceholderSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class PlaceholderSpan extends ReplacementSpan {
    public static final int ALIGN_ABOVE_BASELINE = 0;
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TEXT_BOTTOM = 5;
    public static final int ALIGN_TEXT_CENTER = 6;
    public static final int ALIGN_TEXT_TOP = 4;
    public static final int ALIGN_TOP = 1;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int UNIT_EM = 1;
    public static final int UNIT_SP = 0;
    public static final int UNIT_UNSPECIFIED = 2;
    private Paint.FontMetricsInt fontMetrics;
    private final float height;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final float pxPerSp;
    private final int verticalAlign;
    private final float width;
    private int widthPx;
    private final int widthUnit;

    /* JADX INFO: compiled from: PlaceholderSpan.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: PlaceholderSpan.kt */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Unit {
        }

        /* JADX INFO: compiled from: PlaceholderSpan.kt */
        @Retention(RetentionPolicy.SOURCE)
        public @interface VerticalAlign {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public PlaceholderSpan(float f10, int i10, float f11, int i11, float f12, int i12) {
        this.width = f10;
        this.widthUnit = i10;
        this.height = f11;
        this.heightUnit = i11;
        this.pxPerSp = f12;
        this.verticalAlign = i12;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, @NotNull Paint paint) {
        t.i(canvas, "canvas");
        t.i(paint, "paint");
    }

    @NotNull
    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        t.A("fontMetrics");
        return null;
    }

    public final int getHeightPx() {
        if (this.isLaidOut) {
            return this.heightPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    @Override // android.text.style.ReplacementSpan
    @SuppressLint({"DocumentExceptions"})
    public int getSize(@NotNull Paint paint, @Nullable CharSequence charSequence, int i10, int i11, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        float f10;
        int iCeilToInt;
        t.i(paint, "paint");
        this.isLaidOut = true;
        float textSize = paint.getTextSize();
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        t.h(fontMetricsInt2, "paint.fontMetricsInt");
        this.fontMetrics = fontMetricsInt2;
        if (!(getFontMetrics().descent > getFontMetrics().ascent)) {
            throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
        }
        int i12 = this.widthUnit;
        if (i12 == 0) {
            f10 = this.width * this.pxPerSp;
        } else {
            if (i12 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            f10 = this.width * textSize;
        }
        this.widthPx = PlaceholderSpanKt.ceilToInt(f10);
        int i13 = this.heightUnit;
        if (i13 == 0) {
            iCeilToInt = PlaceholderSpanKt.ceilToInt(this.height * this.pxPerSp);
        } else {
            if (i13 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            iCeilToInt = PlaceholderSpanKt.ceilToInt(this.height * textSize);
        }
        this.heightPx = iCeilToInt;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = getFontMetrics().ascent;
            fontMetricsInt.descent = getFontMetrics().descent;
            fontMetricsInt.leading = getFontMetrics().leading;
            switch (this.verticalAlign) {
                case 0:
                    if (fontMetricsInt.ascent > (-getHeightPx())) {
                        fontMetricsInt.ascent = -getHeightPx();
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + getHeightPx() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + getHeightPx();
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - getHeightPx()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - getHeightPx();
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < getHeightPx()) {
                        int heightPx = fontMetricsInt.ascent - ((getHeightPx() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = heightPx;
                        fontMetricsInt.descent = heightPx + getHeightPx();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown verticalAlign.");
            }
            fontMetricsInt.top = Math.min(getFontMetrics().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(getFontMetrics().bottom, fontMetricsInt.descent);
        }
        return getWidthPx();
    }

    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    public final int getWidthPx() {
        if (this.isLaidOut) {
            return this.widthPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }
}

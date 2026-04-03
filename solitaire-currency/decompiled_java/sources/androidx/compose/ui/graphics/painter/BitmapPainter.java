package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import j9.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BitmapPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    private float alpha;

    @Nullable
    private ColorFilter colorFilter;
    private int filterQuality;

    @NotNull
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j10, long j11, k kVar) {
        this(imageBitmap, j10, j11);
    }

    /* JADX INFO: renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m2087validateSizeN5eqBDc(long j10, long j11) {
        if (IntOffset.m3791getXimpl(j10) >= 0 && IntOffset.m3792getYimpl(j10) >= 0 && IntSize.m3833getWidthimpl(j11) >= 0 && IntSize.m3832getHeightimpl(j11) >= 0 && IntSize.m3833getWidthimpl(j11) <= this.image.getWidth() && IntSize.m3832getHeightimpl(j11) <= this.image.getHeight()) {
            return j11;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        this.alpha = f10;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return t.d(this.image, bitmapPainter.image) && IntOffset.m3790equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m3831equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m1679equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
    }

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I$ui_graphics_release, reason: not valid java name */
    public final int m2088getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo2089getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m3843toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m3793hashCodeimpl(this.srcOffset)) * 31) + IntSize.m3834hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m1680hashCodeimpl(this.filterQuality);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        b.z(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(c.c(Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc())), c.c(Size.m1433getHeightimpl(drawScope.mo1996getSizeNHjbRc()))), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m2090setFilterQualityvDHp3xo$ui_graphics_release(int i10) {
        this.filterQuality = i10;
    }

    @NotNull
    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m3798toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m3836toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m1681toStringimpl(this.filterQuality)) + ')';
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j10, long j11, int i10, k kVar) {
        this(imageBitmap, (i10 & 2) != 0 ? IntOffset.Companion.m3801getZeronOccac() : j10, (i10 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j11, null);
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j10, long j11) {
        this.image = imageBitmap;
        this.srcOffset = j10;
        this.srcSize = j11;
        this.filterQuality = FilterQuality.Companion.m1684getLowfv9h1I();
        this.size = m2087validateSizeN5eqBDc(j10, j11);
        this.alpha = 1.0f;
    }
}

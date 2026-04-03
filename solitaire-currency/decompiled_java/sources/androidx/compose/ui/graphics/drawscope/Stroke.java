package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Stroke extends DrawStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DefaultCap = StrokeCap.Companion.m1885getButtKaPHkGw();
    private static final int DefaultJoin = StrokeJoin.Companion.m1896getMiterLxFBmk8();
    public static final float DefaultMiter = 4.0f;
    public static final float HairlineWidth = 0.0f;
    private final int cap;
    private final int join;
    private final float miter;

    @Nullable
    private final PathEffect pathEffect;
    private final float width;

    /* JADX INFO: compiled from: DrawScope.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDefaultCap-KaPHkGw, reason: not valid java name */
        public final int m2085getDefaultCapKaPHkGw() {
            return Stroke.DefaultCap;
        }

        /* JADX INFO: renamed from: getDefaultJoin-LxFBmk8, reason: not valid java name */
        public final int m2086getDefaultJoinLxFBmk8() {
            return Stroke.DefaultJoin;
        }
    }

    public /* synthetic */ Stroke(float f10, float f11, int i10, int i11, PathEffect pathEffect, k kVar) {
        this(f10, f11, i10, i11, pathEffect);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) obj;
        if (this.width == stroke.width) {
            return ((this.miter > stroke.miter ? 1 : (this.miter == stroke.miter ? 0 : -1)) == 0) && StrokeCap.m1881equalsimpl0(this.cap, stroke.cap) && StrokeJoin.m1891equalsimpl0(this.join, stroke.join) && t.d(this.pathEffect, stroke.pathEffect);
        }
        return false;
    }

    /* JADX INFO: renamed from: getCap-KaPHkGw, reason: not valid java name */
    public final int m2083getCapKaPHkGw() {
        return this.cap;
    }

    /* JADX INFO: renamed from: getJoin-LxFBmk8, reason: not valid java name */
    public final int m2084getJoinLxFBmk8() {
        return this.join;
    }

    public final float getMiter() {
        return this.miter;
    }

    @Nullable
    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iFloatToIntBits = ((((((Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.miter)) * 31) + StrokeCap.m1882hashCodeimpl(this.cap)) * 31) + StrokeJoin.m1892hashCodeimpl(this.join)) * 31;
        PathEffect pathEffect = this.pathEffect;
        return iFloatToIntBits + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) StrokeCap.m1883toStringimpl(this.cap)) + ", join=" + ((Object) StrokeJoin.m1893toStringimpl(this.join)) + ", pathEffect=" + this.pathEffect + ')';
    }

    public /* synthetic */ Stroke(float f10, float f11, int i10, int i11, PathEffect pathEffect, int i12, k kVar) {
        this((i12 & 1) != 0 ? 0.0f : f10, (i12 & 2) != 0 ? 4.0f : f11, (i12 & 4) != 0 ? StrokeCap.Companion.m1885getButtKaPHkGw() : i10, (i12 & 8) != 0 ? StrokeJoin.Companion.m1896getMiterLxFBmk8() : i11, (i12 & 16) != 0 ? null : pathEffect, null);
    }

    private Stroke(float f10, float f11, int i10, int i11, PathEffect pathEffect) {
        super(null);
        this.width = f10;
        this.miter = f11;
        this.cap = i10;
        this.join = i11;
        this.pathEffect = pathEffect;
    }
}

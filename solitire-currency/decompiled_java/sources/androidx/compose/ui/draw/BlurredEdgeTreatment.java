package androidx.compose.ui.draw;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BlurredEdgeTreatment {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Shape Rectangle = m1281constructorimpl(RectangleShapeKt.getRectangleShape());

    @NotNull
    private static final Shape Unbounded = m1281constructorimpl(null);

    @Nullable
    private final Shape shape;

    /* JADX INFO: compiled from: Blur.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        /* JADX INFO: renamed from: getRectangle---Goahg, reason: not valid java name */
        public final Shape m1287getRectangleGoahg() {
            return BlurredEdgeTreatment.Rectangle;
        }

        @NotNull
        /* JADX INFO: renamed from: getUnbounded---Goahg, reason: not valid java name */
        public final Shape m1288getUnboundedGoahg() {
            return BlurredEdgeTreatment.Unbounded;
        }
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape shape) {
        this.shape = shape;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m1280boximpl(Shape shape) {
        return new BlurredEdgeTreatment(shape);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1282equalsimpl(Shape shape, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && t.d(shape, ((BlurredEdgeTreatment) obj).m1286unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1283equalsimpl0(Shape shape, Shape shape2) {
        return t.d(shape, shape2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1284hashCodeimpl(Shape shape) {
        if (shape == null) {
            return 0;
        }
        return shape.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1285toStringimpl(Shape shape) {
        return "BlurredEdgeTreatment(shape=" + shape + ')';
    }

    public boolean equals(Object obj) {
        return m1282equalsimpl(this.shape, obj);
    }

    @Nullable
    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return m1284hashCodeimpl(this.shape);
    }

    public String toString() {
        return m1285toStringimpl(this.shape);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Shape m1286unboximpl() {
        return this.shape;
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Shape m1281constructorimpl(@Nullable Shape shape) {
        return shape;
    }
}

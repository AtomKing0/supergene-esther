package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Shadow {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Shadow None = new Shadow(0, 0, 0.0f, 7, null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    public /* synthetic */ Shadow(long j10, long j11, float f10, kotlin.jvm.internal.k kVar) {
        this(j10, j11, f10);
    }

    /* JADX INFO: renamed from: copy-qcb84PM$default, reason: not valid java name */
    public static /* synthetic */ Shadow m1861copyqcb84PM$default(Shadow shadow, long j10, long j11, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = shadow.color;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = shadow.offset;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            f10 = shadow.blurRadius;
        }
        return shadow.m1864copyqcb84PM(j12, j13, f10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-qcb84PM, reason: not valid java name */
    public final Shadow m1864copyqcb84PM(long j10, long j11, float f10) {
        return new Shadow(j10, j11, f10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        if (Color.m1599equalsimpl0(this.color, shadow.color) && Offset.m1364equalsimpl0(this.offset, shadow.offset)) {
            return (this.blurRadius > shadow.blurRadius ? 1 : (this.blurRadius == shadow.blurRadius ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m1865getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m1866getOffsetF1C5BW0() {
        return this.offset;
    }

    public int hashCode() {
        return (((Color.m1605hashCodeimpl(this.color) * 31) + Offset.m1369hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.blurRadius);
    }

    @NotNull
    public String toString() {
        return "Shadow(color=" + ((Object) Color.m1606toStringimpl(this.color)) + ", offset=" + ((Object) Offset.m1375toStringimpl(this.offset)) + ", blurRadius=" + this.blurRadius + ')';
    }

    private Shadow(long j10, long j11, float f10) {
        this.color = j10;
        this.offset = j11;
        this.blurRadius = f10;
    }

    public /* synthetic */ Shadow(long j10, long j11, float f10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? ColorKt.Color(4278190080L) : j10, (i10 & 2) != 0 ? Offset.Companion.m1383getZeroF1C5BW0() : j11, (i10 & 4) != 0 ? 0.0f : f10, null);
    }

    /* JADX INFO: compiled from: Shadow.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final Shadow getNone() {
            return Shadow.None;
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }
    }

    @Stable
    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1862getColor0d7_KjU$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getOffset-F1C5BW0$annotations, reason: not valid java name */
    public static /* synthetic */ void m1863getOffsetF1C5BW0$annotations() {
    }
}

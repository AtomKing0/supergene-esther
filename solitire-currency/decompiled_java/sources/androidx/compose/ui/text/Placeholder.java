package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Placeholder {
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    public /* synthetic */ Placeholder(long j10, long j11, int i10, k kVar) {
        this(j10, j11, i10);
    }

    /* JADX INFO: renamed from: copy-K8Q-__8$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m3271copyK8Q__8$default(Placeholder placeholder, long j10, long j11, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = placeholder.width;
        }
        long j12 = j10;
        if ((i11 & 2) != 0) {
            j11 = placeholder.height;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            i10 = placeholder.placeholderVerticalAlign;
        }
        return placeholder.m3272copyK8Q__8(j12, j13, i10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-K8Q-__8, reason: not valid java name */
    public final Placeholder m3272copyK8Q__8(long j10, long j11, int i10) {
        return new Placeholder(j10, j11, i10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return TextUnit.m3851equalsimpl0(this.width, placeholder.width) && TextUnit.m3851equalsimpl0(this.height, placeholder.height) && PlaceholderVerticalAlign.m3279equalsimpl0(this.placeholderVerticalAlign, placeholder.placeholderVerticalAlign);
    }

    /* JADX INFO: renamed from: getHeight-XSAIIZE, reason: not valid java name */
    public final long m3273getHeightXSAIIZE() {
        return this.height;
    }

    /* JADX INFO: renamed from: getPlaceholderVerticalAlign-J6kI3mc, reason: not valid java name */
    public final int m3274getPlaceholderVerticalAlignJ6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    /* JADX INFO: renamed from: getWidth-XSAIIZE, reason: not valid java name */
    public final long m3275getWidthXSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        return (((TextUnit.m3855hashCodeimpl(this.width) * 31) + TextUnit.m3855hashCodeimpl(this.height)) * 31) + PlaceholderVerticalAlign.m3280hashCodeimpl(this.placeholderVerticalAlign);
    }

    @NotNull
    public String toString() {
        return "Placeholder(width=" + ((Object) TextUnit.m3861toStringimpl(this.width)) + ", height=" + ((Object) TextUnit.m3861toStringimpl(this.height)) + ", placeholderVerticalAlign=" + ((Object) PlaceholderVerticalAlign.m3281toStringimpl(this.placeholderVerticalAlign)) + ')';
    }

    private Placeholder(long j10, long j11, int i10) {
        this.width = j10;
        this.height = j11;
        this.placeholderVerticalAlign = i10;
        if (!(!TextUnitKt.m3872isUnspecifiedR2X_6o(j10))) {
            throw new IllegalArgumentException("width cannot be TextUnit.Unspecified".toString());
        }
        if (!(!TextUnitKt.m3872isUnspecifiedR2X_6o(j11))) {
            throw new IllegalArgumentException("height cannot be TextUnit.Unspecified".toString());
        }
    }
}

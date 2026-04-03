package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaselineShift.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BaselineShift {
    private final float multiplier;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float Superscript = m3543constructorimpl(0.5f);
    private static final float Subscript = m3543constructorimpl(-0.5f);
    private static final float None = m3543constructorimpl(0.0f);

    private /* synthetic */ BaselineShift(float f10) {
        this.multiplier = f10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m3542boximpl(float f10) {
        return new BaselineShift(f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3544equalsimpl(float f10, Object obj) {
        if (obj instanceof BaselineShift) {
            return t.d(Float.valueOf(f10), Float.valueOf(((BaselineShift) obj).m3548unboximpl()));
        }
        return false;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3545equalsimpl0(float f10, float f11) {
        return t.d(Float.valueOf(f10), Float.valueOf(f11));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3546hashCodeimpl(float f10) {
        return Float.floatToIntBits(f10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3547toStringimpl(float f10) {
        return "BaselineShift(multiplier=" + f10 + ')';
    }

    public boolean equals(Object obj) {
        return m3544equalsimpl(this.multiplier, obj);
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public int hashCode() {
        return m3546hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m3547toStringimpl(this.multiplier);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m3548unboximpl() {
        return this.multiplier;
    }

    /* JADX INFO: compiled from: BaselineShift.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs, reason: not valid java name */
        public final float m3552getNoney9eOQZs() {
            return BaselineShift.None;
        }

        /* JADX INFO: renamed from: getSubscript-y9eOQZs, reason: not valid java name */
        public final float m3553getSubscripty9eOQZs() {
            return BaselineShift.Subscript;
        }

        /* JADX INFO: renamed from: getSuperscript-y9eOQZs, reason: not valid java name */
        public final float m3554getSuperscripty9eOQZs() {
            return BaselineShift.Superscript;
        }

        @Stable
        /* JADX INFO: renamed from: getNone-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m3549getNoney9eOQZs$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSubscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m3550getSubscripty9eOQZs$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSuperscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m3551getSuperscripty9eOQZs$annotations() {
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m3543constructorimpl(float f10) {
        return f10;
    }
}

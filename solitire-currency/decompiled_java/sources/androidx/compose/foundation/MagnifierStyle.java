package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Magnifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public final class MagnifierStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final MagnifierStyle Default;

    @NotNull
    private static final MagnifierStyle TextDefault;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final boolean fishEyeEnabled;
    private final long size;
    private final boolean useTextDefault;

    static {
        MagnifierStyle magnifierStyle = new MagnifierStyle(0L, 0.0f, 0.0f, false, false, 31, (kotlin.jvm.internal.k) null);
        Default = magnifierStyle;
        TextDefault = new MagnifierStyle(true, magnifierStyle.size, magnifierStyle.cornerRadius, magnifierStyle.elevation, magnifierStyle.clippingEnabled, magnifierStyle.fishEyeEnabled, (kotlin.jvm.internal.k) null);
    }

    @ExperimentalFoundationApi
    public /* synthetic */ MagnifierStyle(long j10, float f10, float f11, boolean z10, boolean z11, kotlin.jvm.internal.k kVar) {
        this(j10, f10, f11, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierStyle)) {
            return false;
        }
        MagnifierStyle magnifierStyle = (MagnifierStyle) obj;
        return this.useTextDefault == magnifierStyle.useTextDefault && DpSize.m3768equalsimpl0(this.size, magnifierStyle.size) && Dp.m3678equalsimpl0(this.cornerRadius, magnifierStyle.cornerRadius) && Dp.m3678equalsimpl0(this.elevation, magnifierStyle.elevation) && this.clippingEnabled == magnifierStyle.clippingEnabled && this.fishEyeEnabled == magnifierStyle.fishEyeEnabled;
    }

    public final boolean getClippingEnabled$foundation_release() {
        return this.clippingEnabled;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m232getCornerRadiusD9Ej5fM$foundation_release() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m233getElevationD9Ej5fM$foundation_release() {
        return this.elevation;
    }

    public final boolean getFishEyeEnabled$foundation_release() {
        return this.fishEyeEnabled;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ$foundation_release, reason: not valid java name */
    public final long m234getSizeMYxV2XQ$foundation_release() {
        return this.size;
    }

    public final boolean getUseTextDefault$foundation_release() {
        return this.useTextDefault;
    }

    public int hashCode() {
        return (((((((((e.a(this.useTextDefault) * 31) + DpSize.m3773hashCodeimpl(this.size)) * 31) + Dp.m3679hashCodeimpl(this.cornerRadius)) * 31) + Dp.m3679hashCodeimpl(this.elevation)) * 31) + e.a(this.clippingEnabled)) * 31) + e.a(this.fishEyeEnabled);
    }

    public final boolean isSupported() {
        return Companion.isStyleSupported$foundation_release$default(Companion, this, 0, 2, null);
    }

    @NotNull
    public String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        return "MagnifierStyle(size=" + ((Object) DpSize.m3778toStringimpl(this.size)) + ", cornerRadius=" + ((Object) Dp.m3684toStringimpl(this.cornerRadius)) + ", elevation=" + ((Object) Dp.m3684toStringimpl(this.elevation)) + ", clippingEnabled=" + this.clippingEnabled + ", fishEyeEnabled=" + this.fishEyeEnabled + ')';
    }

    public /* synthetic */ MagnifierStyle(boolean z10, long j10, float f10, float f11, boolean z11, boolean z12, kotlin.jvm.internal.k kVar) {
        this(z10, j10, f10, f11, z11, z12);
    }

    private MagnifierStyle(boolean z10, long j10, float f10, float f11, boolean z11, boolean z12) {
        this.useTextDefault = z10;
        this.size = j10;
        this.cornerRadius = f10;
        this.elevation = f11;
        this.clippingEnabled = z11;
        this.fishEyeEnabled = z12;
    }

    public /* synthetic */ MagnifierStyle(long j10, float f10, float f11, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? DpSize.Companion.m3780getUnspecifiedMYxV2XQ() : j10, (i10 & 2) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f10, (i10 & 4) != 0 ? Dp.Companion.m3693getUnspecifiedD9Ej5fM() : f11, (i10 & 8) != 0 ? true : z10, (i10 & 16) != 0 ? false : z11, (kotlin.jvm.internal.k) null);
    }

    private MagnifierStyle(long j10, float f10, float f11, boolean z10, boolean z11) {
        this(false, j10, f10, f11, z10, z11, (kotlin.jvm.internal.k) null);
    }

    /* JADX INFO: compiled from: Magnifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ boolean isStyleSupported$foundation_release$default(Companion companion, MagnifierStyle magnifierStyle, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = Build.VERSION.SDK_INT;
            }
            return companion.isStyleSupported$foundation_release(magnifierStyle, i10);
        }

        @NotNull
        public final MagnifierStyle getDefault() {
            return MagnifierStyle.Default;
        }

        @NotNull
        public final MagnifierStyle getTextDefault() {
            return MagnifierStyle.TextDefault;
        }

        public final boolean isStyleSupported$foundation_release(@NotNull MagnifierStyle style, int i10) {
            t.i(style, "style");
            if (MagnifierKt.isPlatformMagnifierSupported(i10) && !style.getFishEyeEnabled$foundation_release()) {
                return style.getUseTextDefault$foundation_release() || t.d(style, getDefault()) || i10 >= 29;
            }
            return false;
        }

        @ExperimentalFoundationApi
        public static /* synthetic */ void getDefault$annotations() {
        }

        @ExperimentalFoundationApi
        public static /* synthetic */ void getTextDefault$annotations() {
        }
    }
}

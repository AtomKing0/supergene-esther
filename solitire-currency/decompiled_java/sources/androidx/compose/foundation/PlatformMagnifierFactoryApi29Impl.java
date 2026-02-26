package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {

    @NotNull
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    /* JADX INFO: compiled from: PlatformMagnifier.kt */
    @StabilityInferred(parameters = 0)
    @RequiresApi(29)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(@NotNull Magnifier magnifier) {
            super(magnifier);
            t.i(magnifier, "magnifier");
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo237updateWko1d7g(long j10, long j11, float f10) {
            if (!Float.isNaN(f10)) {
                getMagnifier().setZoom(f10);
            }
            if (OffsetKt.m1386isSpecifiedk4lQ0M(j11)) {
                getMagnifier().show(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11));
            } else {
                getMagnifier().show(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    @NotNull
    public PlatformMagnifierImpl create(@NotNull MagnifierStyle style, @NotNull View view, @NotNull Density density, float f10) {
        t.i(style, "style");
        t.i(view, "view");
        t.i(density, "density");
        if (t.d(style, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long jMo297toSizeXkaWNTQ = density.mo297toSizeXkaWNTQ(style.m234getSizeMYxV2XQ$foundation_release());
        float fMo296toPx0680j_4 = density.mo296toPx0680j_4(style.m232getCornerRadiusD9Ej5fM$foundation_release());
        float fMo296toPx0680j_42 = density.mo296toPx0680j_4(style.m233getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jMo297toSizeXkaWNTQ != Size.Companion.m1444getUnspecifiedNHjbRc()) {
            builder.setSize(j9.c.c(Size.m1436getWidthimpl(jMo297toSizeXkaWNTQ)), j9.c.c(Size.m1433getHeightimpl(jMo297toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(fMo296toPx0680j_4)) {
            builder.setCornerRadius(fMo296toPx0680j_4);
        }
        if (!Float.isNaN(fMo296toPx0680j_42)) {
            builder.setElevation(fMo296toPx0680j_42);
        }
        if (!Float.isNaN(f10)) {
            builder.setInitialZoom(f10);
        }
        builder.setClippingEnabled(style.getClippingEnabled$foundation_release());
        Magnifier magnifierBuild = builder.build();
        t.h(magnifierBuild, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(magnifierBuild);
    }
}

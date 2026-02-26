package l;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.i;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f30198a = Constraints.Companion.m3649fixedJhjzzOo(0, 0);

    public static final float a(long j10, float f10) {
        return o.m(f10, Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10));
    }

    public static final float b(long j10, float f10) {
        return o.m(f10, Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10));
    }

    public static final long c() {
        return f30198a;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final v.i d(@Nullable Object obj, @Nullable Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1151830858, i10, -1, "coil.compose.requestOf (Utils.kt:21)");
        }
        return obj instanceof v.i ? (v.i) obj : new i.a((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).b(obj).a();
    }

    public static final long e(long j10) {
        return IntSizeKt.IntSize(j9.c.c(Size.m1436getWidthimpl(j10)), j9.c.c(Size.m1433getHeightimpl(j10)));
    }

    @Stable
    @NotNull
    public static final w.h f(@NotNull ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.Companion;
        return t.d(contentScale, companion.getFit()) ? true : t.d(contentScale, companion.getInside()) ? w.h.FIT : w.h.FILL;
    }
}

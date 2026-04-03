package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BringIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
final class BringIntoViewRequesterModifier extends BringIntoViewChildModifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterModifier(@NotNull BringIntoViewParent defaultParent) {
        super(defaultParent);
        t.i(defaultParent, "defaultParent");
    }

    @Nullable
    public final Object bringIntoView(@Nullable Rect rect, @NotNull d<? super k0> dVar) {
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return k0.f35197a;
        }
        if (rect == null) {
            rect = SizeKt.m1457toRectuvyYCjk(IntSizeKt.m3843toSizeozmzZPI(layoutCoordinates.mo2989getSizeYbymL2g()));
        }
        Object objBringChildIntoView = getParent().bringChildIntoView(rect, layoutCoordinates, dVar);
        return objBringChildIntoView == a9.d.e() ? objBringChildIntoView : k0.f35197a;
    }
}

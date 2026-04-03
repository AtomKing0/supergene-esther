package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 extends v implements p<IntRect, IntRect, k0> {
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.$transformOriginState = mutableState;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(IntRect intRect, IntRect intRect2) {
        invoke2(intRect, intRect2);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IntRect parentBounds, @NotNull IntRect menuBounds) {
        t.i(parentBounds, "parentBounds");
        t.i(menuBounds, "menuBounds");
        this.$transformOriginState.setValue(TransformOrigin.m1910boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
    }
}

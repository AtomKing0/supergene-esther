package androidx.compose.ui.window;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$SimpleStack$1$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    public static final AndroidPopup_androidKt$SimpleStack$1$measure$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$measure$1();

    public AndroidPopup_androidKt$SimpleStack$1$measure$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }
}

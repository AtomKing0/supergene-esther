package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class OnGloballyPositionedModifierImpl extends InspectorValueInfo implements OnGloballyPositionedModifier {

    @NotNull
    private final h9.l<LayoutCoordinates, k0> callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnGloballyPositionedModifierImpl(@NotNull h9.l<? super LayoutCoordinates, k0> callback, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(callback, "callback");
        t.i(inspectorInfo, "inspectorInfo");
        this.callback = callback;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnGloballyPositionedModifierImpl) {
            return t.d(this.callback, ((OnGloballyPositionedModifierImpl) obj).callback);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final h9.l<LayoutCoordinates, k0> getCallback() {
        return this.callback;
    }

    public int hashCode() {
        return this.callback.hashCode();
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        this.callback.invoke(coordinates);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

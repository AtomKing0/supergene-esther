package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusedBounds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusedBoundsModifier implements ModifierLocalConsumer, OnGloballyPositionedModifier {

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    @Nullable
    private h9.l<? super LayoutCoordinates, k0> observer;

    private final void notifyObserverWhenAttached() {
        h9.l<? super LayoutCoordinates, k0> lVar;
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates != null) {
            t.f(layoutCoordinates);
            if (!layoutCoordinates.isAttached() || (lVar = this.observer) == null) {
                return;
            }
            lVar.invoke(this.layoutCoordinates);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
        if (coordinates.isAttached()) {
            notifyObserverWhenAttached();
            return;
        }
        h9.l<? super LayoutCoordinates, k0> lVar = this.observer;
        if (lVar != null) {
            lVar.invoke(null);
        }
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        h9.l<? super LayoutCoordinates, k0> lVar;
        t.i(scope, "scope");
        h9.l<? super LayoutCoordinates, k0> lVar2 = (h9.l) scope.getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        if (lVar2 == null && (lVar = this.observer) != null) {
            lVar.invoke(null);
        }
        this.observer = lVar2;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BringIntoView.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class BringIntoViewChildModifier implements ModifierLocalConsumer, OnPlacedModifier {

    @NotNull
    private final BringIntoViewParent defaultParent;

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    @Nullable
    private BringIntoViewParent localParent;

    public BringIntoViewChildModifier(@NotNull BringIntoViewParent defaultParent) {
        t.i(defaultParent, "defaultParent");
        this.defaultParent = defaultParent;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return b.d(this, obj, pVar);
    }

    @Nullable
    protected final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    @NotNull
    protected final BringIntoViewParent getParent() {
        BringIntoViewParent bringIntoViewParent = this.localParent;
        return bringIntoViewParent == null ? this.defaultParent : bringIntoViewParent;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        this.localParent = (BringIntoViewParent) scope.getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

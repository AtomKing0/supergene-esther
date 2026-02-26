package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusedBounds.kt */
/* JADX INFO: loaded from: classes.dex */
final class FocusedBoundsObserverModifier implements ModifierLocalConsumer, ModifierLocalProvider<h9.l<? super LayoutCoordinates, ? extends k0>>, h9.l<LayoutCoordinates, k0> {

    @NotNull
    private final h9.l<LayoutCoordinates, k0> handler;

    @Nullable
    private LayoutCoordinates lastBounds;

    @Nullable
    private h9.l<? super LayoutCoordinates, k0> parent;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusedBoundsObserverModifier(@NotNull h9.l<? super LayoutCoordinates, k0> handler) {
        t.i(handler, "handler");
        this.handler = handler;
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

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<h9.l<? super LayoutCoordinates, ? extends k0>> getKey() {
        return FocusedBoundsKt.getModifierLocalFocusedBoundsObserver();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    /* JADX INFO: renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public h9.l<? super LayoutCoordinates, ? extends k0> getValue2() {
        return this;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return k0.f35197a;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        h9.l<? super LayoutCoordinates, k0> lVar = (h9.l) scope.getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        if (t.d(lVar, this.parent)) {
            return;
        }
        this.parent = lVar;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@Nullable LayoutCoordinates layoutCoordinates) {
        this.lastBounds = layoutCoordinates;
        this.handler.invoke(layoutCoordinates);
        h9.l<? super LayoutCoordinates, k0> lVar = this.parent;
        if (lVar != null) {
            lVar.invoke(layoutCoordinates);
        }
    }
}

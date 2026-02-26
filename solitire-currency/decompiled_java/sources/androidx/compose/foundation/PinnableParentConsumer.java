package androidx.compose.foundation;

import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Focusable.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
final class PinnableParentConsumer implements ModifierLocalConsumer {

    @NotNull
    private final h9.l<PinnableParent, k0> onPinnableParentAvailable;

    /* JADX WARN: Multi-variable type inference failed */
    public PinnableParentConsumer(@NotNull h9.l<? super PinnableParent, k0> onPinnableParentAvailable) {
        t.i(onPinnableParentAvailable, "onPinnableParentAvailable");
        this.onPinnableParentAvailable = onPinnableParentAvailable;
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
        return (obj instanceof PinnableParentConsumer) && t.d(((PinnableParentConsumer) obj).onPinnableParentAvailable, this.onPinnableParentAvailable);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, h9.p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final h9.l<PinnableParent, k0> getOnPinnableParentAvailable() {
        return this.onPinnableParentAvailable;
    }

    public int hashCode() {
        return this.onPinnableParentAvailable.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        this.onPinnableParentAvailable.invoke(scope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent()));
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

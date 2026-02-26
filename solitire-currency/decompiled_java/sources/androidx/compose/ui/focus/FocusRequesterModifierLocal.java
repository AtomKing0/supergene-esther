package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FocusRequesterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusRequesterModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<FocusRequesterModifierLocal> {

    @NotNull
    private final MutableVector<FocusModifier> focusModifiers;

    @NotNull
    private final FocusRequester focusRequester;

    @Nullable
    private FocusRequesterModifierLocal parent;

    public FocusRequesterModifierLocal(@NotNull FocusRequester focusRequester) {
        t.i(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
        this.focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
        focusRequester.getFocusRequesterModifierLocals$ui_release().add(this);
    }

    public final void addFocusModifier(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        this.focusModifiers.add(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifier(focusModifier);
        }
    }

    public final void addFocusModifiers(@NotNull MutableVector<FocusModifier> newModifiers) {
        t.i(newModifiers, "newModifiers");
        MutableVector<FocusModifier> mutableVector = this.focusModifiers;
        mutableVector.addAll(mutableVector.getSize(), newModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(newModifiers);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.focus.FocusModifier findFocusNode() {
        /*
            r9 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r9.focusModifiers
            int r1 = r0.getSize()
            r2 = 0
            if (r1 <= 0) goto L8a
            java.lang.Object[] r0 = r0.getContent()
            r3 = 0
        Le:
            r4 = r0[r3]
            androidx.compose.ui.focus.FocusModifier r4 = (androidx.compose.ui.focus.FocusModifier) r4
            if (r2 == 0) goto L85
            androidx.compose.ui.node.LayoutNodeWrapper r5 = r2.getLayoutNodeWrapper()
            if (r5 == 0) goto L85
            androidx.compose.ui.node.LayoutNode r5 = r5.getLayoutNode$ui_release()
            if (r5 != 0) goto L21
            goto L85
        L21:
            androidx.compose.ui.node.LayoutNodeWrapper r6 = r4.getLayoutNodeWrapper()
            if (r6 == 0) goto L86
            androidx.compose.ui.node.LayoutNode r6 = r6.getLayoutNode$ui_release()
            if (r6 != 0) goto L2e
            goto L86
        L2e:
            int r7 = r5.getDepth$ui_release()
            int r8 = r6.getDepth$ui_release()
            if (r7 <= r8) goto L40
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.t.f(r5)
            goto L2e
        L40:
            int r7 = r6.getDepth$ui_release()
            int r8 = r5.getDepth$ui_release()
            if (r7 <= r8) goto L52
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.t.f(r6)
            goto L40
        L52:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r8 = r6.getParent$ui_release()
            boolean r7 = kotlin.jvm.internal.t.d(r7, r8)
            if (r7 != 0) goto L6f
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            kotlin.jvm.internal.t.f(r5)
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            kotlin.jvm.internal.t.f(r6)
            goto L52
        L6f:
            androidx.compose.ui.node.LayoutNode r7 = r5.getParent$ui_release()
            kotlin.jvm.internal.t.f(r7)
            androidx.compose.runtime.collection.MutableVector r7 = r7.get_children$ui_release()
            int r5 = r7.indexOf(r5)
            int r6 = r7.indexOf(r6)
            if (r5 >= r6) goto L85
            goto L86
        L85:
            r2 = r4
        L86:
            int r3 = r3 + 1
            if (r3 < r1) goto Le
        L8a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequesterModifierLocal.findFocusNode():androidx.compose.ui.focus.FocusModifier");
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
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
        return FocusRequesterModifierKt.getModifierLocalFocusRequester();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public FocusRequesterModifierLocal getValue() {
        return this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) scope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (t.d(focusRequesterModifierLocal, this.parent)) {
            return;
        }
        FocusRequesterModifierLocal focusRequesterModifierLocal2 = this.parent;
        if (focusRequesterModifierLocal2 != null) {
            focusRequesterModifierLocal2.removeFocusModifiers(this.focusModifiers);
        }
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(this.focusModifiers);
        }
        this.parent = focusRequesterModifierLocal;
    }

    public final void removeFocusModifier(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        this.focusModifiers.remove(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    public final void removeFocusModifiers(@NotNull MutableVector<FocusModifier> removedModifiers) {
        t.i(removedModifiers, "removedModifiers");
        this.focusModifiers.removeAll(removedModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifiers(removedModifiers);
        }
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

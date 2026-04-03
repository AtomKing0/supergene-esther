package androidx.compose.ui.input.key;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.a;
import androidx.compose.ui.b;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KeyInputModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInputModifier implements ModifierLocalConsumer, ModifierLocalProvider<KeyInputModifier>, OnPlacedModifier {

    @Nullable
    private FocusModifier focusModifier;

    @Nullable
    private LayoutNode layoutNode;

    @Nullable
    private final l<KeyEvent, Boolean> onKeyEvent;

    @Nullable
    private final l<KeyEvent, Boolean> onPreviewKeyEvent;

    @Nullable
    private KeyInputModifier parent;

    /* JADX WARN: Multi-variable type inference failed */
    public KeyInputModifier(@Nullable l<? super KeyEvent, Boolean> lVar, @Nullable l<? super KeyEvent, Boolean> lVar2) {
        this.onKeyEvent = lVar;
        this.onPreviewKeyEvent = lVar2;
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

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<KeyInputModifier> getKey() {
        return KeyInputModifierKt.getModifierLocalKeyInput();
    }

    @Nullable
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Nullable
    public final l<KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    @Nullable
    public final l<KeyEvent, Boolean> getOnPreviewKeyEvent() {
        return this.onPreviewKeyEvent;
    }

    @Nullable
    public final KeyInputModifier getParent() {
        return this.parent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public KeyInputModifier getValue() {
        return this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        MutableVector<KeyInputModifier> keyInputChildren;
        MutableVector<KeyInputModifier> keyInputChildren2;
        t.i(scope, "scope");
        FocusModifier focusModifier = this.focusModifier;
        if (focusModifier != null && (keyInputChildren2 = focusModifier.getKeyInputChildren()) != null) {
            keyInputChildren2.remove(this);
        }
        FocusModifier focusModifier2 = (FocusModifier) scope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        this.focusModifier = focusModifier2;
        if (focusModifier2 != null && (keyInputChildren = focusModifier2.getKeyInputChildren()) != null) {
            keyInputChildren.add(this);
        }
        this.parent = (KeyInputModifier) scope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        this.layoutNode = ((LayoutNodeWrapper) coordinates).getLayoutNode$ui_release();
    }

    /* JADX INFO: renamed from: processKeyInput-ZmokQxo, reason: not valid java name */
    public final boolean m2767processKeyInputZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        FocusModifier focusModifierFindActiveFocusNode;
        KeyInputModifier keyInputModifierFindLastKeyInputModifier;
        t.i(keyEvent, "keyEvent");
        FocusModifier focusModifier = this.focusModifier;
        if (focusModifier == null || (focusModifierFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier)) == null || (keyInputModifierFindLastKeyInputModifier = FocusTraversalKt.findLastKeyInputModifier(focusModifierFindActiveFocusNode)) == null) {
            throw new IllegalStateException("KeyEvent can't be processed because this key input node is not active.".toString());
        }
        if (keyInputModifierFindLastKeyInputModifier.m2769propagatePreviewKeyEventZmokQxo(keyEvent)) {
            return true;
        }
        return keyInputModifierFindLastKeyInputModifier.m2768propagateKeyEventZmokQxo(keyEvent);
    }

    /* JADX INFO: renamed from: propagateKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m2768propagateKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        t.i(keyEvent, "keyEvent");
        l<KeyEvent, Boolean> lVar = this.onKeyEvent;
        Boolean boolInvoke = lVar != null ? lVar.invoke(KeyEvent.m2743boximpl(keyEvent)) : null;
        if (t.d(boolInvoke, Boolean.TRUE)) {
            return boolInvoke.booleanValue();
        }
        KeyInputModifier keyInputModifier = this.parent;
        if (keyInputModifier != null) {
            return keyInputModifier.m2768propagateKeyEventZmokQxo(keyEvent);
        }
        return false;
    }

    /* JADX INFO: renamed from: propagatePreviewKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m2769propagatePreviewKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        t.i(keyEvent, "keyEvent");
        KeyInputModifier keyInputModifier = this.parent;
        Boolean boolValueOf = keyInputModifier != null ? Boolean.valueOf(keyInputModifier.m2769propagatePreviewKeyEventZmokQxo(keyEvent)) : null;
        if (t.d(boolValueOf, Boolean.TRUE)) {
            return boolValueOf.booleanValue();
        }
        l<KeyEvent, Boolean> lVar = this.onPreviewKeyEvent;
        if (lVar != null) {
            return lVar.invoke(KeyEvent.m2743boximpl(keyEvent)).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}

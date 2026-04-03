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
import v8.k0;

/* JADX INFO: compiled from: FocusEventModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusEventModifierLocal implements ModifierLocalProvider<FocusEventModifierLocal>, ModifierLocalConsumer {

    @NotNull
    private final MutableVector<FocusEventModifierLocal> children;

    @NotNull
    private final MutableVector<FocusModifier> focusModifiers;

    @NotNull
    private final l<FocusState, k0> onFocusEvent;

    @Nullable
    private FocusEventModifierLocal parent;

    /* JADX INFO: compiled from: FocusEventModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusEventModifierLocal(@NotNull l<? super FocusState, k0> onFocusEvent) {
        t.i(onFocusEvent, "onFocusEvent");
        this.onFocusEvent = onFocusEvent;
        this.children = new MutableVector<>(new FocusEventModifierLocal[16], 0);
        this.focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
    }

    private final void addFocusModifiers(MutableVector<FocusModifier> mutableVector) {
        MutableVector<FocusModifier> mutableVector2 = this.focusModifiers;
        mutableVector2.addAll(mutableVector2.getSize(), mutableVector);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifiers(mutableVector);
        }
    }

    private final void removeFocusModifiers(MutableVector<FocusModifier> mutableVector) {
        this.focusModifiers.removeAll(mutableVector);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifiers(mutableVector);
        }
    }

    public final void addFocusModifier(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        this.focusModifiers.add(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifier(focusModifier);
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

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<FocusEventModifierLocal> getKey() {
        return FocusEventModifierKt.getModifierLocalFocusEvent();
    }

    @NotNull
    public final l<FocusState, k0> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public FocusEventModifierLocal getValue() {
        return this;
    }

    public final void notifyIfNoFocusModifiers() {
        if (this.focusModifiers.isEmpty()) {
            this.onFocusEvent.invoke(FocusStateImpl.Inactive);
        }
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        if (!t.d(focusEventModifierLocal, this.parent)) {
            FocusEventModifierLocal focusEventModifierLocal2 = this.parent;
            if (focusEventModifierLocal2 != null) {
                focusEventModifierLocal2.children.remove(this);
                focusEventModifierLocal2.removeFocusModifiers(this.focusModifiers);
            }
            this.parent = focusEventModifierLocal;
            if (focusEventModifierLocal != null) {
                focusEventModifierLocal.children.add(this);
                focusEventModifierLocal.addFocusModifiers(this.focusModifiers);
            }
        }
        this.parent = (FocusEventModifierLocal) scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
    }

    public final void propagateFocusEvent() {
        FocusStateImpl focusState;
        Boolean bool;
        int size = this.focusModifiers.getSize();
        if (size != 0) {
            int i10 = 0;
            if (size != 1) {
                MutableVector<FocusModifier> mutableVector = this.focusModifiers;
                int size2 = mutableVector.getSize();
                FocusModifier focusModifier = null;
                Boolean bool2 = null;
                if (size2 > 0) {
                    FocusModifier[] content = mutableVector.getContent();
                    FocusModifier focusModifier2 = null;
                    do {
                        FocusModifier focusModifier3 = content[i10];
                        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier3.getFocusState().ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                bool2 = Boolean.FALSE;
                                focusModifier2 = focusModifier3;
                                break;
                            case 5:
                                if (bool2 == null) {
                                    bool2 = Boolean.TRUE;
                                }
                                break;
                            case 6:
                                bool2 = Boolean.FALSE;
                                break;
                        }
                        i10++;
                    } while (i10 < size2);
                    bool = bool2;
                    focusModifier = focusModifier2;
                } else {
                    bool = null;
                }
                if (focusModifier == null || (focusState = focusModifier.getFocusState()) == null) {
                    focusState = t.d(bool, Boolean.TRUE) ? FocusStateImpl.Deactivated : FocusStateImpl.Inactive;
                }
            } else {
                focusState = this.focusModifiers.getContent()[0].getFocusState();
            }
        } else {
            focusState = FocusStateImpl.Inactive;
        }
        this.onFocusEvent.invoke(focusState);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.propagateFocusEvent();
        }
    }

    public final void removeFocusModifier(@NotNull FocusModifier focusModifier) {
        t.i(focusModifier, "focusModifier");
        this.focusModifiers.remove(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

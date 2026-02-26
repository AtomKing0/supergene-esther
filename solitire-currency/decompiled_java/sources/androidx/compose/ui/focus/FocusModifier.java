package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusAwareInputModifier;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusModifier extends InspectorValueInfo implements ModifierLocalConsumer, ModifierLocalProvider<FocusModifier>, OwnerScope, OnPlacedModifier {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<FocusModifier, k0> RefreshFocusProperties = FocusModifier$Companion$RefreshFocusProperties$1.INSTANCE;

    @Nullable
    private BeyondBoundsLayout beyondBoundsLayoutParent;

    @NotNull
    private final MutableVector<FocusModifier> children;

    @Nullable
    private FocusEventModifierLocal focusEventListener;

    @NotNull
    private final FocusProperties focusProperties;

    @Nullable
    private FocusPropertiesModifier focusPropertiesModifier;
    private boolean focusRequestedOnPlaced;

    @Nullable
    private FocusRequesterModifierLocal focusRequester;

    @NotNull
    private FocusStateImpl focusState;

    @Nullable
    private FocusModifier focusedChild;

    @NotNull
    private final MutableVector<KeyInputModifier> keyInputChildren;

    @Nullable
    private KeyInputModifier keyInputModifier;

    @Nullable
    private LayoutNodeWrapper layoutNodeWrapper;
    public ModifierLocalReadScope modifierLocalReadScope;

    @Nullable
    private FocusModifier parent;

    @Nullable
    private FocusAwareInputModifier<RotaryScrollEvent> rotaryScrollParent;

    /* JADX INFO: compiled from: FocusModifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final l<FocusModifier, k0> getRefreshFocusProperties() {
            return FocusModifier.RefreshFocusProperties;
        }
    }

    /* JADX INFO: compiled from: FocusModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ FocusModifier(FocusStateImpl focusStateImpl, l lVar, int i10, k kVar) {
        this(focusStateImpl, (i10 & 2) != 0 ? InspectableValueKt.getNoInspectorInfo() : lVar);
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

    @Nullable
    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return this.beyondBoundsLayoutParent;
    }

    @NotNull
    public final MutableVector<FocusModifier> getChildren() {
        return this.children;
    }

    @Nullable
    public final FocusEventModifierLocal getFocusEventListener() {
        return this.focusEventListener;
    }

    @NotNull
    public final FocusProperties getFocusProperties() {
        return this.focusProperties;
    }

    @Nullable
    public final FocusPropertiesModifier getFocusPropertiesModifier() {
        return this.focusPropertiesModifier;
    }

    public final boolean getFocusRequestedOnPlaced() {
        return this.focusRequestedOnPlaced;
    }

    @Nullable
    public final FocusRequesterModifierLocal getFocusRequester() {
        return this.focusRequester;
    }

    @NotNull
    public final FocusStateImpl getFocusState() {
        return this.focusState;
    }

    @Nullable
    public final FocusModifier getFocusedChild() {
        return this.focusedChild;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<FocusModifier> getKey() {
        return FocusModifierKt.getModifierLocalParentFocusModifier();
    }

    @NotNull
    public final MutableVector<KeyInputModifier> getKeyInputChildren() {
        return this.keyInputChildren;
    }

    @Nullable
    public final KeyInputModifier getKeyInputModifier() {
        return this.keyInputModifier;
    }

    @Nullable
    public final LayoutNodeWrapper getLayoutNodeWrapper() {
        return this.layoutNodeWrapper;
    }

    @NotNull
    public final ModifierLocalReadScope getModifierLocalReadScope() {
        ModifierLocalReadScope modifierLocalReadScope = this.modifierLocalReadScope;
        if (modifierLocalReadScope != null) {
            return modifierLocalReadScope;
        }
        t.A("modifierLocalReadScope");
        return null;
    }

    @Nullable
    public final FocusModifier getParent() {
        return this.parent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public FocusModifier getValue() {
        return this;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.parent != null;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        MutableVector<FocusModifier> mutableVector;
        MutableVector<FocusModifier> mutableVector2;
        LayoutNodeWrapper layoutNodeWrapper;
        LayoutNode layoutNode$ui_release;
        Owner owner$ui_release;
        FocusManager focusManager;
        t.i(scope, "scope");
        setModifierLocalReadScope(scope);
        FocusModifier focusModifier = (FocusModifier) scope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        if (!t.d(focusModifier, this.parent)) {
            if (focusModifier == null) {
                int i10 = WhenMappings.$EnumSwitchMapping$0[this.focusState.ordinal()];
                if ((i10 == 1 || i10 == 2) && (layoutNodeWrapper = this.layoutNodeWrapper) != null && (layoutNode$ui_release = layoutNodeWrapper.getLayoutNode$ui_release()) != null && (owner$ui_release = layoutNode$ui_release.getOwner$ui_release()) != null && (focusManager = owner$ui_release.getFocusManager()) != null) {
                    focusManager.clearFocus(true);
                }
            }
            FocusModifier focusModifier2 = this.parent;
            if (focusModifier2 != null && (mutableVector2 = focusModifier2.children) != null) {
                mutableVector2.remove(this);
            }
            if (focusModifier != null && (mutableVector = focusModifier.children) != null) {
                mutableVector.add(this);
            }
        }
        this.parent = focusModifier;
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        if (!t.d(focusEventModifierLocal, this.focusEventListener)) {
            FocusEventModifierLocal focusEventModifierLocal2 = this.focusEventListener;
            if (focusEventModifierLocal2 != null) {
                focusEventModifierLocal2.removeFocusModifier(this);
            }
            if (focusEventModifierLocal != null) {
                focusEventModifierLocal.addFocusModifier(this);
            }
        }
        this.focusEventListener = focusEventModifierLocal;
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) scope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (!t.d(focusRequesterModifierLocal, this.focusRequester)) {
            FocusRequesterModifierLocal focusRequesterModifierLocal2 = this.focusRequester;
            if (focusRequesterModifierLocal2 != null) {
                focusRequesterModifierLocal2.removeFocusModifier(this);
            }
            if (focusRequesterModifierLocal != null) {
                focusRequesterModifierLocal.addFocusModifier(this);
            }
        }
        this.focusRequester = focusRequesterModifierLocal;
        this.rotaryScrollParent = (FocusAwareInputModifier) scope.getCurrent(RotaryInputModifierKt.getModifierLocalRotaryScrollParent());
        this.beyondBoundsLayoutParent = (BeyondBoundsLayout) scope.getCurrent(androidx.compose.ui.layout.BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
        this.keyInputModifier = (KeyInputModifier) scope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
        this.focusPropertiesModifier = (FocusPropertiesModifier) scope.getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties());
        FocusPropertiesKt.refreshFocusProperties(this);
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(@NotNull LayoutCoordinates coordinates) {
        t.i(coordinates, "coordinates");
        boolean z10 = this.layoutNodeWrapper == null;
        this.layoutNodeWrapper = (LayoutNodeWrapper) coordinates;
        if (z10) {
            FocusPropertiesKt.refreshFocusProperties(this);
        }
        if (this.focusRequestedOnPlaced) {
            this.focusRequestedOnPlaced = false;
            FocusTransactionsKt.requestFocus(this);
        }
    }

    @ExperimentalComposeUiApi
    public final boolean propagateRotaryEvent(@NotNull RotaryScrollEvent event) {
        t.i(event, "event");
        FocusAwareInputModifier<RotaryScrollEvent> focusAwareInputModifier = this.rotaryScrollParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateFocusAwareEvent(event);
        }
        return false;
    }

    public final void setBeyondBoundsLayoutParent(@Nullable BeyondBoundsLayout beyondBoundsLayout) {
        this.beyondBoundsLayoutParent = beyondBoundsLayout;
    }

    public final void setFocusEventListener(@Nullable FocusEventModifierLocal focusEventModifierLocal) {
        this.focusEventListener = focusEventModifierLocal;
    }

    public final void setFocusPropertiesModifier(@Nullable FocusPropertiesModifier focusPropertiesModifier) {
        this.focusPropertiesModifier = focusPropertiesModifier;
    }

    public final void setFocusRequestedOnPlaced(boolean z10) {
        this.focusRequestedOnPlaced = z10;
    }

    public final void setFocusRequester(@Nullable FocusRequesterModifierLocal focusRequesterModifierLocal) {
        this.focusRequester = focusRequesterModifierLocal;
    }

    public final void setFocusState(@NotNull FocusStateImpl value) {
        t.i(value, "value");
        this.focusState = value;
        FocusTransactionsKt.sendOnFocusEvent(this);
    }

    public final void setFocusedChild(@Nullable FocusModifier focusModifier) {
        this.focusedChild = focusModifier;
    }

    public final void setLayoutNodeWrapper(@Nullable LayoutNodeWrapper layoutNodeWrapper) {
        this.layoutNodeWrapper = layoutNodeWrapper;
    }

    public final void setModifierLocalReadScope(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        t.i(modifierLocalReadScope, "<set-?>");
        this.modifierLocalReadScope = modifierLocalReadScope;
    }

    public final void setParent(@Nullable FocusModifier focusModifier) {
        this.parent = focusModifier;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusModifier(@NotNull FocusStateImpl initialFocus, @NotNull l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(initialFocus, "initialFocus");
        t.i(inspectorInfo, "inspectorInfo");
        this.children = new MutableVector<>(new FocusModifier[16], 0);
        this.focusState = initialFocus;
        this.focusProperties = new FocusPropertiesImpl();
        this.keyInputChildren = new MutableVector<>(new KeyInputModifier[16], 0);
    }

    private static /* synthetic */ void getRotaryScrollParent$annotations() {
    }
}

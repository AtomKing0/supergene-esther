package androidx.compose.ui.focus;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class FocusPropertiesModifier extends InspectorValueInfo implements ModifierLocalConsumer, ModifierLocalProvider<FocusPropertiesModifier> {

    @NotNull
    private final l<FocusProperties, k0> focusPropertiesScope;

    @NotNull
    private final ProvidableModifierLocal<FocusPropertiesModifier> key;

    @NotNull
    private final MutableState parent$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FocusPropertiesModifier(@NotNull l<? super FocusProperties, k0> focusPropertiesScope, @NotNull l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(focusPropertiesScope, "focusPropertiesScope");
        t.i(inspectorInfo, "inspectorInfo");
        this.focusPropertiesScope = focusPropertiesScope;
        this.parent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.key = FocusPropertiesKt.getModifierLocalFocusProperties();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FocusPropertiesModifier getParent() {
        return (FocusPropertiesModifier) this.parent$delegate.getValue();
    }

    private final void setParent(FocusPropertiesModifier focusPropertiesModifier) {
        this.parent$delegate.setValue(focusPropertiesModifier);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public final void calculateProperties(@NotNull FocusProperties focusProperties) {
        t.i(focusProperties, "focusProperties");
        this.focusPropertiesScope.invoke(focusProperties);
        FocusPropertiesModifier parent = getParent();
        if (parent != null) {
            parent.calculateProperties(focusProperties);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof FocusPropertiesModifier) && t.d(this.focusPropertiesScope, ((FocusPropertiesModifier) obj).focusPropertiesScope);
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
    public final l<FocusProperties, k0> getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<FocusPropertiesModifier> getKey() {
        return this.key;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public FocusPropertiesModifier getValue() {
        return this;
    }

    public int hashCode() {
        return this.focusPropertiesScope.hashCode();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        setParent((FocusPropertiesModifier) scope.getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties()));
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}

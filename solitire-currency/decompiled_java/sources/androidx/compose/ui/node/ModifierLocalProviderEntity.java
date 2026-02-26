package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ModifierLocalProviderEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalProviderEntity implements h9.a<k0> {

    @NotNull
    private final MutableVector<ModifierLocalConsumerEntity> consumers;
    private boolean isAttached;

    @NotNull
    private final LayoutNode layoutNode;

    @NotNull
    private final ModifierLocalProvider<?> modifier;

    @Nullable
    private ModifierLocalProviderEntity next;

    @Nullable
    private ModifierLocalProviderEntity prev;

    public ModifierLocalProviderEntity(@NotNull LayoutNode layoutNode, @NotNull ModifierLocalProvider<?> modifier) {
        t.i(layoutNode, "layoutNode");
        t.i(modifier, "modifier");
        this.layoutNode = layoutNode;
        this.modifier = modifier;
        this.consumers = new MutableVector<>(new ModifierLocalConsumerEntity[16], 0);
    }

    private final void invalidateConsumersOf(ModifierLocal<?> modifierLocal, boolean z10) {
        k0 k0Var;
        MutableVector<LayoutNode> mutableVector;
        int size;
        if (z10 && t.d(this.modifier.getKey(), modifierLocal)) {
            return;
        }
        MutableVector<ModifierLocalConsumerEntity> mutableVector2 = this.consumers;
        int size2 = mutableVector2.getSize();
        int i10 = 0;
        if (size2 > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector2.getContent();
            int i11 = 0;
            do {
                content[i11].invalidateConsumersOf(modifierLocal);
                i11++;
            } while (i11 < size2);
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = this.next;
        if (modifierLocalProviderEntity != null) {
            modifierLocalProviderEntity.invalidateConsumersOf(modifierLocal, true);
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var != null || (size = (mutableVector = this.layoutNode.get_children$ui_release()).getSize()) <= 0) {
            return;
        }
        LayoutNode[] content2 = mutableVector.getContent();
        do {
            content2[i10].getModifierLocalsHead$ui_release().invalidateConsumersOf(modifierLocal, true);
            i10++;
        } while (i10 < size);
    }

    public final void attach() {
        this.isAttached = true;
        int i10 = 0;
        invalidateConsumersOf(this.modifier.getKey(), false);
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            do {
                content[i10].attach();
                i10++;
            } while (i10 < size);
        }
    }

    public final void attachDelayed() {
        this.isAttached = true;
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.registerOnEndApplyChangesListener(this);
        }
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].attachDelayed();
                i10++;
            } while (i10 < size);
        }
    }

    public final void detach() {
        this.isAttached = false;
        MutableVector<ModifierLocalConsumerEntity> mutableVector = this.consumers;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].detach();
                i10++;
            } while (i10 < size);
        }
        invalidateConsumersOf(this.modifier.getKey(), false);
    }

    @Nullable
    public final ModifierLocalProvider<?> findModifierLocalProvider(@NotNull ModifierLocal<?> local) {
        ModifierLocalProviderEntity modifierLocalsTail$ui_release;
        ModifierLocalProvider<?> modifierLocalProviderFindModifierLocalProvider;
        t.i(local, "local");
        if (t.d(this.modifier.getKey(), local)) {
            return this.modifier;
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = this.prev;
        if (modifierLocalProviderEntity != null && (modifierLocalProviderFindModifierLocalProvider = modifierLocalProviderEntity.findModifierLocalProvider(local)) != null) {
            return modifierLocalProviderFindModifierLocalProvider;
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release == null || (modifierLocalsTail$ui_release = parent$ui_release.getModifierLocalsTail$ui_release()) == null) {
            return null;
        }
        return modifierLocalsTail$ui_release.findModifierLocalProvider(local);
    }

    @NotNull
    public final MutableVector<ModifierLocalConsumerEntity> getConsumers() {
        return this.consumers;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @NotNull
    public final ModifierLocalProvider<?> getModifier() {
        return this.modifier;
    }

    @Nullable
    public final ModifierLocalProviderEntity getNext() {
        return this.next;
    }

    @Nullable
    public final ModifierLocalProviderEntity getPrev() {
        return this.prev;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public final void setNext(@Nullable ModifierLocalProviderEntity modifierLocalProviderEntity) {
        this.next = modifierLocalProviderEntity;
    }

    public final void setPrev(@Nullable ModifierLocalProviderEntity modifierLocalProviderEntity) {
        this.prev = modifierLocalProviderEntity;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        if (this.isAttached) {
            invalidateConsumersOf(this.modifier.getKey(), false);
        }
    }
}

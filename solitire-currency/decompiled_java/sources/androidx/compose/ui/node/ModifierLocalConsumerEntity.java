package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalConsumerEntity implements h9.a<k0>, OwnerScope, ModifierLocalReadScope {
    private boolean isAttached;

    @NotNull
    private final ModifierLocalConsumer modifier;

    @NotNull
    private final MutableVector<ModifierLocal<?>> modifierLocalsRead;

    @NotNull
    private ModifierLocalProviderEntity provider;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<ModifierLocalConsumerEntity, k0> onReadValuesChanged = ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1.INSTANCE;

    @NotNull
    private static final ModifierLocalReadScope DetachedModifierLocalReadScope = new ModifierLocalReadScope() { // from class: androidx.compose.ui.node.ModifierLocalConsumerEntity$Companion$DetachedModifierLocalReadScope$1
        @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
        public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
            t.i(modifierLocal, "<this>");
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
    };

    /* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ModifierLocalReadScope getDetachedModifierLocalReadScope() {
            return ModifierLocalConsumerEntity.DetachedModifierLocalReadScope;
        }

        @NotNull
        public final l<ModifierLocalConsumerEntity, k0> getOnReadValuesChanged() {
            return ModifierLocalConsumerEntity.onReadValuesChanged;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.ModifierLocalConsumerEntity$notifyConsumerOfChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ModifierLocalConsumerEntity.this.getModifier().onModifierLocalsUpdated(ModifierLocalConsumerEntity.this);
        }
    }

    public ModifierLocalConsumerEntity(@NotNull ModifierLocalProviderEntity provider, @NotNull ModifierLocalConsumer modifier) {
        t.i(provider, "provider");
        t.i(modifier, "modifier");
        this.provider = provider;
        this.modifier = modifier;
        this.modifierLocalsRead = new MutableVector<>(new ModifierLocal[16], 0);
    }

    public final void attach() {
        this.isAttached = true;
        notifyConsumerOfChanges();
    }

    public final void attachDelayed() {
        this.isAttached = true;
        invalidateConsumer();
    }

    public final void detach() {
        this.modifier.onModifierLocalsUpdated(DetachedModifierLocalReadScope);
        this.isAttached = false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
        t.i(modifierLocal, "<this>");
        this.modifierLocalsRead.add(modifierLocal);
        ModifierLocalProvider<?> modifierLocalProviderFindModifierLocalProvider = this.provider.findModifierLocalProvider(modifierLocal);
        return modifierLocalProviderFindModifierLocalProvider == null ? modifierLocal.getDefaultFactory$ui_release().invoke() : (T) modifierLocalProviderFindModifierLocalProvider.getValue();
    }

    @NotNull
    public final ModifierLocalConsumer getModifier() {
        return this.modifier;
    }

    @NotNull
    public final ModifierLocalProviderEntity getProvider() {
        return this.provider;
    }

    public final void invalidateConsumer() {
        Owner owner$ui_release = this.provider.getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.registerOnEndApplyChangesListener(this);
        }
    }

    public final void invalidateConsumersOf(@NotNull ModifierLocal<?> local) {
        Owner owner$ui_release;
        t.i(local, "local");
        if (!this.modifierLocalsRead.contains(local) || (owner$ui_release = this.provider.getLayoutNode().getOwner$ui_release()) == null) {
            return;
        }
        owner$ui_release.registerOnEndApplyChangesListener(this);
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.isAttached;
    }

    public final void notifyConsumerOfChanges() {
        if (this.isAttached) {
            this.modifierLocalsRead.clear();
            LayoutNodeKt.requireOwner(this.provider.getLayoutNode()).getSnapshotObserver().observeReads$ui_release(this, onReadValuesChanged, new AnonymousClass1());
        }
    }

    public final void setProvider(@NotNull ModifierLocalProviderEntity modifierLocalProviderEntity) {
        t.i(modifierLocalProviderEntity, "<set-?>");
        this.provider = modifierLocalProviderEntity;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        notifyConsumerOfChanges();
    }
}

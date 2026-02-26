package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RecomposeScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {

    @Nullable
    private Anchor anchor;

    @Nullable
    private p<? super Composer, ? super Integer, k0> block;

    @Nullable
    private CompositionImpl composition;
    private int currentToken;
    private int flags;

    @Nullable
    private IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;

    @Nullable
    private IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(@Nullable CompositionImpl compositionImpl) {
        this.composition = compositionImpl;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean z10) {
        if (z10) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z10) {
        if (z10) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void adoptedBy(@NotNull CompositionImpl composition) {
        t.i(composition, "composition");
        this.composition = composition;
    }

    public final void compose(@NotNull Composer composer) {
        k0 k0Var;
        t.i(composer, "composer");
        p<? super Composer, ? super Integer, k0> pVar = this.block;
        if (pVar != null) {
            pVar.mo4invoke(composer, 1);
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    @Nullable
    public final l<Composition, k0> end(int i10) {
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        int size = identityArrayIntMap.getSize();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            if (identityArrayIntMap.getKeys()[i11] == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            if (identityArrayIntMap.getValues()[i11] != i10) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            return new RecomposeScopeImpl$end$1$2(this, i10, identityArrayIntMap);
        }
        return null;
    }

    @Nullable
    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    @Nullable
    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.composition == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl != null) {
            compositionImpl.invalidate(this, null);
        }
    }

    @NotNull
    public final InvalidationResult invalidateForResult(@Nullable Object obj) {
        InvalidationResult invalidationResultInvalidate;
        CompositionImpl compositionImpl = this.composition;
        return (compositionImpl == null || (invalidationResultInvalidate = compositionImpl.invalidate(this, obj)) == null) ? InvalidationResult.IGNORED : invalidationResultInvalidate;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInvalidFor(@org.jetbrains.annotations.Nullable androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != 0) goto L4
            return r0
        L4:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r5.trackedDependencies
            if (r1 != 0) goto L9
            return r0
        L9:
            boolean r2 = r6.isNotEmpty()
            if (r2 == 0) goto L43
            boolean r2 = r6.isEmpty()
            r3 = 0
            if (r2 == 0) goto L18
        L16:
            r6 = r0
            goto L40
        L18:
            java.util.Iterator r6 = r6.iterator()
        L1c:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L16
            java.lang.Object r2 = r6.next()
            boolean r4 = r2 instanceof androidx.compose.runtime.DerivedState
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r1.get(r2)
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            java.lang.Object r2 = r2.getCurrentValue()
            boolean r2 = kotlin.jvm.internal.t.d(r4, r2)
            if (r2 == 0) goto L3c
            r2 = r0
            goto L3d
        L3c:
            r2 = r3
        L3d:
            if (r2 != 0) goto L1c
            r6 = r3
        L40:
            if (r6 == 0) goto L43
            return r3
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet):boolean");
    }

    public final void recordRead(@NotNull Object instance) {
        t.i(instance, "instance");
        if (getRereading()) {
            return;
        }
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null) {
            identityArrayIntMap = new IdentityArrayIntMap();
            this.trackedInstances = identityArrayIntMap;
        }
        identityArrayIntMap.add(instance, this.currentToken);
        if (instance instanceof DerivedState) {
            IdentityArrayMap<DerivedState<?>, Object> identityArrayMap = this.trackedDependencies;
            if (identityArrayMap == null) {
                identityArrayMap = new IdentityArrayMap<>(0, 1, null);
                this.trackedDependencies = identityArrayMap;
            }
            identityArrayMap.set(instance, ((DerivedState) instance).getCurrentValue());
        }
    }

    public final void release() {
        this.composition = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap identityArrayIntMap;
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl == null || (identityArrayIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            int size = identityArrayIntMap.getSize();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = identityArrayIntMap.getKeys()[i10];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                int i11 = identityArrayIntMap.getValues()[i10];
                compositionImpl.recordReadOf(obj);
            }
        } finally {
            setRereading(false);
        }
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final void setAnchor(@Nullable Anchor anchor) {
        this.anchor = anchor;
    }

    public final void setDefaultsInScope(boolean z10) {
        if (z10) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z10) {
        if (z10) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setRequiresRecompose(boolean z10) {
        if (z10) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z10) {
        if (z10) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final void start(int i10) {
        this.currentToken = i10;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(@NotNull p<? super Composer, ? super Integer, k0> block) {
        t.i(block, "block");
        this.block = block;
    }
}

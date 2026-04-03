package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RecomposeScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class RecomposeScopeImpl$end$1$2 extends v implements l<Composition, k0> {
    final /* synthetic */ IdentityArrayIntMap $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i10, IdentityArrayIntMap identityArrayIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i10;
        this.$instances = identityArrayIntMap;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Composition composition) {
        invoke2(composition);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Composition composition) {
        t.i(composition, "composition");
        if (this.this$0.currentToken == this.$token && t.d(this.$instances, this.this$0.trackedInstances) && (composition instanceof CompositionImpl)) {
            IdentityArrayIntMap identityArrayIntMap = this.$instances;
            int i10 = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            int size = identityArrayIntMap.getSize();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Object obj = identityArrayIntMap.getKeys()[i12];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                int i13 = identityArrayIntMap.getValues()[i12];
                boolean z10 = i13 != i10;
                if (z10) {
                    CompositionImpl compositionImpl = (CompositionImpl) composition;
                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                    DerivedState<?> derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                    if (derivedState != null) {
                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                        IdentityArrayMap identityArrayMap = recomposeScopeImpl.trackedDependencies;
                        if (identityArrayMap != null) {
                            identityArrayMap.remove(derivedState);
                            if (identityArrayMap.getSize$runtime_release() == 0) {
                                recomposeScopeImpl.trackedDependencies = null;
                            }
                        }
                    }
                }
                if (!z10) {
                    if (i11 != i12) {
                        identityArrayIntMap.getKeys()[i11] = obj;
                        identityArrayIntMap.getValues()[i11] = i13;
                    }
                    i11++;
                }
            }
            int size2 = identityArrayIntMap.getSize();
            for (int i14 = i11; i14 < size2; i14++) {
                identityArrayIntMap.getKeys()[i14] = null;
            }
            identityArrayIntMap.setSize(i11);
            if (this.$instances.getSize() == 0) {
                this.this$0.trackedInstances = null;
            }
        }
    }
}

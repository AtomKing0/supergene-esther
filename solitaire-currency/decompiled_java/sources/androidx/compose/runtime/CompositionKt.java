package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import h9.l;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import z8.g;
import z8.h;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionKt {

    @NotNull
    private static final Object PendingApplyNoModifications = new Object();

    @NotNull
    public static final Composition Composition(@NotNull Applier<?> applier, @NotNull CompositionContext parent) {
        t.i(applier, "applier");
        t.i(parent, "parent");
        return new CompositionImpl(parent, applier, null, 4, null);
    }

    @NotNull
    public static final ControlledComposition ControlledComposition(@NotNull Applier<?> applier, @NotNull CompositionContext parent) {
        t.i(applier, "applier");
        t.i(parent, "parent");
        return new CompositionImpl(parent, applier, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> void addValue(IdentityArrayMap<K, IdentityArraySet<V>> identityArrayMap, K k10, V v10) {
        if (identityArrayMap.contains(k10)) {
            IdentityArraySet<V> identityArraySet = identityArrayMap.get(k10);
            if (identityArraySet != null) {
                identityArraySet.add(v10);
                return;
            }
            return;
        }
        IdentityArraySet<V> identityArraySet2 = new IdentityArraySet<>();
        identityArraySet2.add(v10);
        k0 k0Var = k0.f35197a;
        identityArrayMap.set(k10, identityArraySet2);
    }

    @ExperimentalComposeApi
    @NotNull
    public static final g getRecomposeCoroutineContext(@NotNull ControlledComposition controlledComposition) {
        g recomposeContext;
        t.i(controlledComposition, "<this>");
        CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
        return (compositionImpl == null || (recomposeContext = compositionImpl.getRecomposeContext()) == null) ? h.f37608a : recomposeContext;
    }

    public static final void invalidateGroupsWithKey(int i10) {
        HotReloader.Companion.invalidateGroupsWithKey$runtime_release(i10);
    }

    private static final <E> void removeValueIf(HashSet<E> hashSet, l<? super E, Boolean> lVar) {
        Iterator<E> it = hashSet.iterator();
        t.h(it, "iterator()");
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
    }

    public static final void simulateHotReload(@NotNull Object context) {
        t.i(context, "context");
        HotReloader.Companion.simulateHotReload$runtime_release(context);
    }

    @ExperimentalComposeApi
    @NotNull
    public static final Composition Composition(@NotNull Applier<?> applier, @NotNull CompositionContext parent, @NotNull g recomposeCoroutineContext) {
        t.i(applier, "applier");
        t.i(parent, "parent");
        t.i(recomposeCoroutineContext, "recomposeCoroutineContext");
        return new CompositionImpl(parent, applier, recomposeCoroutineContext);
    }

    @ExperimentalComposeApi
    @NotNull
    public static final ControlledComposition ControlledComposition(@NotNull Applier<?> applier, @NotNull CompositionContext parent, @NotNull g recomposeCoroutineContext) {
        t.i(applier, "applier");
        t.i(parent, "parent");
        t.i(recomposeCoroutineContext, "recomposeCoroutineContext");
        return new CompositionImpl(parent, applier, recomposeCoroutineContext);
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition controlledComposition) {
    }
}

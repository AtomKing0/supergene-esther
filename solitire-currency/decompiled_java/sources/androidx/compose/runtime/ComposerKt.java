package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import h9.l;
import h9.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposerKt {
    public static final int compositionLocalMapKey = 202;

    @Nullable
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final int nodeKeyReplace = 126;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;

    @NotNull
    private static final q<Applier<?>, SlotWriter, RememberManager, k0> removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;

    @NotNull
    private static final q<Applier<?>, SlotWriter, RememberManager, k0> skipToGroupEndInstance = ComposerKt$skipToGroupEndInstance$1.INSTANCE;

    @NotNull
    private static final q<Applier<?>, SlotWriter, RememberManager, k0> endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;

    @NotNull
    private static final q<Applier<?>, SlotWriter, RememberManager, k0> startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;

    @NotNull
    private static final q<Applier<?>, SlotWriter, RememberManager, k0> resetSlotsInstance = ComposerKt$resetSlotsInstance$1.INSTANCE;

    @NotNull
    private static final Object invocation = new OpaqueKey(IronSourceConstants.EVENTS_PROVIDER);

    @NotNull
    private static final Object provider = new OpaqueKey(IronSourceConstants.EVENTS_PROVIDER);

    @NotNull
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");

    @NotNull
    private static final Object providerValues = new OpaqueKey("providerValues");

    @NotNull
    private static final Object providerMaps = new OpaqueKey("providers");

    @NotNull
    private static final Object reference = new OpaqueKey("reference");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i10) {
        return i10 != 0;
    }

    @ComposeCompilerApi
    public static final <T> T cache(@NotNull Composer composer, boolean z10, @NotNull h9.a<? extends T> block) {
        t.i(composer, "<this>");
        t.i(block, "block");
        T t10 = (T) composer.rememberedValue();
        if (!z10 && t10 != Composer.Companion.getEmpty()) {
            return t10;
        }
        T tInvoke = block.invoke();
        composer.updateRememberedValue(tInvoke);
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        try {
            m1247collectNodesFrom$lambda10$collectFromGroup(slotReaderOpenReader, arrayList, slotTable.anchorIndex(anchor));
            k0 k0Var = k0.f35197a;
            return arrayList;
        } finally {
            slotReaderOpenReader.close();
        }
    }

    /* JADX INFO: renamed from: collectNodesFrom$lambda-10$collectFromGroup, reason: not valid java name */
    private static final void m1247collectNodesFrom$lambda10$collectFromGroup(SlotReader slotReader, List<Object> list, int i10) {
        if (slotReader.isNode(i10)) {
            list.add(slotReader.node(i10));
            return;
        }
        int iGroupSize = i10 + 1;
        int iGroupSize2 = i10 + slotReader.groupSize(i10);
        while (iGroupSize < iGroupSize2) {
            m1247collectNodesFrom$lambda10$collectFromGroup(slotReader, list, iGroupSize);
            iGroupSize += slotReader.groupSize(iGroupSize);
        }
    }

    @NotNull
    public static final Void composeRuntimeError(@NotNull String message) {
        t.i(message, "message");
        throw new IllegalStateException(("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + message + "). Please report to Google or use https://goo.gle/compose-feedback").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocalMapOf(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Composer composer, int i10) {
        composer.startReplaceableGroup(721128344);
        PersistentMap.Builder builder = ExtensionsKt.persistentHashMapOf().builder();
        for (ProvidedValue<?> providedValue : providedValueArr) {
            if (providedValue.getCanOverride() || !contains(persistentMap, providedValue.getCompositionLocal())) {
                builder.put(providedValue.getCompositionLocal(), providedValue.getCompositionLocal().provided$runtime_release(providedValue.getValue(), composer, 72));
            }
        }
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMapBuild = builder.build();
        composer.endReplaceableGroup();
        return persistentMapBuild;
    }

    public static final <T> boolean contains(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull CompositionLocal<T> key) {
        t.i(persistentMap, "<this>");
        t.i(key, "key");
        return persistentMap.containsKey(key);
    }

    private static final int distanceFrom(SlotReader slotReader, int i10, int i11) {
        int i12 = 0;
        while (i10 > 0 && i10 != i11) {
            i10 = slotReader.parent(i10);
            i12++;
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        for (int iFindInsertLocation = findInsertLocation(list, i10); iFindInsertLocation < list.size(); iFindInsertLocation++) {
            Invalidation invalidation = list.get(iFindInsertLocation);
            if (invalidation.getLocation() >= i11) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    private static final int findInsertLocation(List<Invalidation> list, int i10) {
        int iFindLocation = findLocation(list, i10);
        return iFindLocation < 0 ? -(iFindLocation + 1) : iFindLocation;
    }

    private static final int findLocation(List<Invalidation> list, int i10) {
        int size = list.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            int iK = t.k(list.get(i12).getLocation(), i10);
            if (iK < 0) {
                i11 = i12 + 1;
            } else {
                if (iK <= 0) {
                    return i12;
                }
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i10, int i11) {
        int iFindInsertLocation = findInsertLocation(list, i10);
        if (iFindInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(iFindInsertLocation);
        if (invalidation.getLocation() < i11) {
            return invalidation;
        }
        return null;
    }

    @NotNull
    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    @NotNull
    public static final Object getInvocation() {
        return invocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if ((!t.d(joinedKey.getLeft(), obj2) || !t.d(joinedKey.getRight(), obj3)) && (obj = getKey(joinedKey.getLeft(), obj2, obj3)) == null) {
            obj = getKey(joinedKey.getRight(), obj2, obj3);
        }
        return obj;
    }

    @NotNull
    public static final Object getProvider() {
        return provider;
    }

    @NotNull
    public static final Object getProviderMaps() {
        return providerMaps;
    }

    @NotNull
    public static final Object getProviderValues() {
        return providerValues;
    }

    @NotNull
    public static final Object getReference() {
        return reference;
    }

    public static final <T> T getValueOf(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull CompositionLocal<T> key) {
        t.i(persistentMap, "<this>");
        t.i(key, "key");
        State<? extends Object> state = persistentMap.get(key);
        if (state != null) {
            return (T) state.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i10, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iFindLocation = findLocation(list, i10);
        IdentityArraySet identityArraySet = null;
        if (iFindLocation < 0) {
            int i11 = -(iFindLocation + 1);
            if (obj != null) {
                identityArraySet = new IdentityArraySet();
                identityArraySet.add(obj);
            }
            list.add(i11, new Invalidation(recomposeScopeImpl, i10, identityArraySet));
            return;
        }
        if (obj == null) {
            list.get(iFindLocation).setInstances(null);
            return;
        }
        IdentityArraySet<Object> instances = list.get(iFindLocation).getInstances();
        if (instances != null) {
            instances.add(obj);
        }
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    @NotNull
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> mutate(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull l<? super Map<CompositionLocal<Object>, State<Object>>, k0> mutator) {
        t.i(persistentMap, "<this>");
        t.i(mutator, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i10, int i11, int i12) {
        if (i10 == i11) {
            return i10;
        }
        if (i10 == i12 || i11 == i12) {
            return i12;
        }
        if (slotReader.parent(i10) == i11) {
            return i11;
        }
        if (slotReader.parent(i11) == i10) {
            return i10;
        }
        if (slotReader.parent(i10) == slotReader.parent(i11)) {
            return slotReader.parent(i10);
        }
        int iDistanceFrom = distanceFrom(slotReader, i10, i12);
        int iDistanceFrom2 = distanceFrom(slotReader, i11, i12);
        int i13 = iDistanceFrom - iDistanceFrom2;
        for (int i14 = 0; i14 < i13; i14++) {
            i10 = slotReader.parent(i10);
        }
        int i15 = iDistanceFrom2 - iDistanceFrom;
        for (int i16 = 0; i16 < i15; i16++) {
            i11 = slotReader.parent(i11);
        }
        while (i10 != i11) {
            i10 = slotReader.parent(i10);
            i11 = slotReader.parent(i11);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> map, K k10) {
        V v10;
        LinkedHashSet<V> linkedHashSet = map.get(k10);
        if (linkedHashSet == null || (v10 = (V) d0.j0(linkedHashSet)) == null) {
            return null;
        }
        remove(map, k10, v10);
        return v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> map, K k10, V v10) {
        LinkedHashSet<V> linkedHashSet = map.get(k10);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            map.put(k10, linkedHashSet);
        }
        return linkedHashSet.add(v10);
    }

    private static final <K, V> k0 remove(HashMap<K, LinkedHashSet<V>> map, K k10, V v10) {
        LinkedHashSet<V> linkedHashSet = map.get(k10);
        if (linkedHashSet == null) {
            return null;
        }
        linkedHashSet.remove(v10);
        if (linkedHashSet.isEmpty()) {
            map.remove(k10);
        }
        return k0.f35197a;
    }

    public static final void removeCurrentGroup(@NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        RecomposeScopeImpl recomposeScopeImpl;
        CompositionImpl composition;
        t.i(slotWriter, "<this>");
        t.i(rememberManager, "rememberManager");
        Iterator<Object> itGroupSlots = slotWriter.groupSlots();
        while (itGroupSlots.hasNext()) {
            Object next = itGroupSlots.next();
            if (next instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) next);
            } else if ((next instanceof RecomposeScopeImpl) && (composition = (recomposeScopeImpl = (RecomposeScopeImpl) next).getComposition()) != null) {
                composition.setPendingInvalidScopes$runtime_release(true);
                recomposeScopeImpl.release();
            }
        }
        slotWriter.removeGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i10) {
        int iFindLocation = findLocation(list, i10);
        if (iFindLocation >= 0) {
            return list.remove(iFindLocation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i10, int i11) {
        int iFindInsertLocation = findInsertLocation(list, i10);
        while (iFindInsertLocation < list.size() && list.get(iFindInsertLocation).getLocation() < i11) {
            list.remove(iFindInsertLocation);
        }
    }

    public static final void runtimeCheck(boolean z10, @NotNull h9.a<? extends Object> lazyMessage) {
        t.i(lazyMessage, "lazyMessage");
        if (z10) {
            return;
        }
        composeRuntimeError(lazyMessage.invoke().toString());
        throw new h();
    }

    @ComposeCompilerApi
    public static final void sourceInformation(@NotNull Composer composer, @NotNull String sourceInformation) {
        t.i(composer, "composer");
        t.i(sourceInformation, "sourceInformation");
        composer.sourceInformation(sourceInformation);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(@NotNull Composer composer) {
        t.i(composer, "composer");
        composer.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(@NotNull Composer composer, int i10, @NotNull String sourceInformation) {
        t.i(composer, "composer");
        t.i(sourceInformation, "sourceInformation");
        composer.sourceInformationMarkerStart(i10, sourceInformation);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
            k0 k0Var = k0.f35197a;
        }
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i10, int i11, int i12, @NotNull String info) {
        t.i(info, "info");
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i10, i11, i12, info);
            k0 k0Var = k0.f35197a;
        }
    }

    public static final void runtimeCheck(boolean z10) {
        if (z10) {
            return;
        }
        composeRuntimeError("Check failed".toString());
        throw new h();
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z10) {
        return z10 ? 1 : 0;
    }
}

package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import h9.a;
import h9.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: SaveableStateRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {

    @NotNull
    private final l<Object, Boolean> canBeSaved;

    @NotNull
    private final Map<String, List<Object>> restored;

    @NotNull
    private final Map<String, List<a<Object>>> valueProviders;

    public SaveableStateRegistryImpl(@Nullable Map<String, ? extends List<? extends Object>> map, @NotNull l<Object, Boolean> canBeSaved) {
        Map<String, List<Object>> mapZ;
        t.i(canBeSaved, "canBeSaved");
        this.canBeSaved = canBeSaved;
        this.restored = (map == null || (mapZ = r0.z(map)) == null) ? new LinkedHashMap<>() : mapZ;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(@NotNull Object value) {
        t.i(value, "value");
        return this.canBeSaved.invoke(value).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @Nullable
    public Object consumeRestored(@NotNull String key) {
        t.i(key, "key");
        List<Object> listRemove = this.restored.remove(key);
        if (listRemove == null || !(!listRemove.isEmpty())) {
            return null;
        }
        if (listRemove.size() > 1) {
            this.restored.put(key, listRemove.subList(1, listRemove.size()));
        }
        return listRemove.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public Map<String, List<Object>> performSave() {
        Map<String, List<Object>> mapZ = r0.z(this.restored);
        for (Map.Entry<String, List<a<Object>>> entry : this.valueProviders.entrySet()) {
            String key = entry.getKey();
            List<a<Object>> value = entry.getValue();
            if (value.size() == 1) {
                Object objInvoke = value.get(0).invoke();
                if (objInvoke == null) {
                    continue;
                } else {
                    if (!canBeSaved(objInvoke)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    mapZ.put(key, v.f(objInvoke));
                }
            } else {
                int size = value.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    Object objInvoke2 = value.get(i10).invoke();
                    if (objInvoke2 != null && !canBeSaved(objInvoke2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    arrayList.add(objInvoke2);
                }
                mapZ.put(key, arrayList);
            }
        }
        return mapZ;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public SaveableStateRegistry.Entry registerProvider(@NotNull final String key, @NotNull final a<? extends Object> valueProvider) {
        t.i(key, "key");
        t.i(valueProvider, "valueProvider");
        if (!(!q.z(key))) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        Map<String, List<a<Object>>> map = this.valueProviders;
        List<a<Object>> arrayList = map.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(key, arrayList);
        }
        arrayList.add(valueProvider);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.registerProvider.3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                List list = (List) SaveableStateRegistryImpl.this.valueProviders.remove(key);
                if (list != null) {
                    list.remove(valueProvider);
                }
                if (list == null || !(!list.isEmpty())) {
                    return;
                }
                SaveableStateRegistryImpl.this.valueProviders.put(key, list);
            }
        };
    }
}

package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.R;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DisposableSaveableStateRegistry.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry_androidKt {

    @NotNull
    private static final Class<? extends Object>[] AcceptableClasses = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisposableSaveableStateRegistry.android.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
        final /* synthetic */ SavedStateRegistry $androidxRegistry;
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $registered;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, SavedStateRegistry savedStateRegistry, String str) {
            super(0);
            this.$registered = z10;
            this.$androidxRegistry = savedStateRegistry;
            this.$key = str;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            invoke2();
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$registered) {
                this.$androidxRegistry.unregisterSavedStateProvider(this.$key);
            }
        }
    }

    @NotNull
    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(@NotNull View view, @NotNull SavedStateRegistryOwner owner) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(owner, "owner");
        Object parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        View view2 = (View) parent;
        Object tag = view2.getTag(R.id.compose_view_saveable_id_tag);
        String strValueOf = tag instanceof String ? (String) tag : null;
        if (strValueOf == null) {
            strValueOf = String.valueOf(view2.getId());
        }
        return DisposableSaveableStateRegistry(strValueOf, owner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canBeSavedToBundle(Object obj) {
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() != SnapshotStateKt.neverEqualPolicy() && snapshotMutableState.getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && snapshotMutableState.getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                return false;
            }
            T value = snapshotMutableState.getValue();
            if (value == 0) {
                return true;
            }
            return canBeSavedToBundle(value);
        }
        if ((obj instanceof v8.g) && (obj instanceof Serializable)) {
            return false;
        }
        for (Class<? extends Object> cls : AcceptableClasses) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle toBundle(Map<String, ? extends List<? extends Object>> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, ? extends List<? extends Object>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<? extends Object> value = entry.getValue();
            bundle.putParcelableArrayList(key, value instanceof ArrayList ? (ArrayList) value : new ArrayList<>(value));
        }
        return bundle;
    }

    private static final Map<String, List<Object>> toMap(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> setKeySet = bundle.keySet();
        kotlin.jvm.internal.t.h(setKeySet, "this.keySet()");
        for (String key : setKeySet) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(key);
            if (parcelableArrayList == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            }
            kotlin.jvm.internal.t.h(key, "key");
            linkedHashMap.put(key, parcelableArrayList);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(@NotNull String id, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        boolean z10;
        kotlin.jvm.internal.t.i(id, "id");
        kotlin.jvm.internal.t.i(savedStateRegistryOwner, "savedStateRegistryOwner");
        String str = SaveableStateRegistry.class.getSimpleName() + ':' + id;
        SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(str);
        final SaveableStateRegistry SaveableStateRegistry = SaveableStateRegistryKt.SaveableStateRegistry(bundleConsumeRestoredStateForKey != null ? toMap(bundleConsumeRestoredStateForKey) : null, DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1.INSTANCE);
        try {
            savedStateRegistry.registerSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1
                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                @NotNull
                public final Bundle saveState() {
                    return DisposableSaveableStateRegistry_androidKt.toBundle(SaveableStateRegistry.performSave());
                }
            });
            z10 = true;
        } catch (IllegalArgumentException unused) {
            z10 = false;
        }
        return new DisposableSaveableStateRegistry(SaveableStateRegistry, new AnonymousClass1(z10, savedStateRegistry, str));
    }
}

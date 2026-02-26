package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import h9.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaveableStateHolderImpl implements SaveableStateHolder {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<SaveableStateHolderImpl, ?> Saver = SaverKt.Saver(SaveableStateHolderImpl$Companion$Saver$1.INSTANCE, SaveableStateHolderImpl$Companion$Saver$2.INSTANCE);

    @Nullable
    private SaveableStateRegistry parentSaveableStateRegistry;

    @NotNull
    private final Map<Object, RegistryHolder> registryHolders;

    @NotNull
    private final Map<Object, Map<String, List<Object>>> savedStates;

    /* JADX INFO: compiled from: SaveableStateHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<SaveableStateHolderImpl, ?> getSaver() {
            return SaveableStateHolderImpl.Saver;
        }
    }

    /* JADX INFO: compiled from: SaveableStateHolder.kt */
    public final class RegistryHolder {

        @NotNull
        private final Object key;

        @NotNull
        private final SaveableStateRegistry registry;
        private boolean shouldSave;
        final /* synthetic */ SaveableStateHolderImpl this$0;

        public RegistryHolder(@NotNull SaveableStateHolderImpl saveableStateHolderImpl, Object key) {
            t.i(key, "key");
            this.this$0 = saveableStateHolderImpl;
            this.key = key;
            this.shouldSave = true;
            this.registry = SaveableStateRegistryKt.SaveableStateRegistry((Map) saveableStateHolderImpl.savedStates.get(key), new SaveableStateHolderImpl$RegistryHolder$registry$1(saveableStateHolderImpl));
        }

        @NotNull
        public final Object getKey() {
            return this.key;
        }

        @NotNull
        public final SaveableStateRegistry getRegistry() {
            return this.registry;
        }

        public final boolean getShouldSave() {
            return this.shouldSave;
        }

        public final void saveTo(@NotNull Map<Object, Map<String, List<Object>>> map) {
            t.i(map, "map");
            if (this.shouldSave) {
                Map<String, List<Object>> mapPerformSave = this.registry.performSave();
                if (mapPerformSave.isEmpty()) {
                    map.remove(this.key);
                } else {
                    map.put(this.key, mapPerformSave);
                }
            }
        }

        public final void setShouldSave(boolean z10) {
            this.shouldSave = z10;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$2, reason: invalid class name */
    /* JADX INFO: compiled from: SaveableStateHolder.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Object $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Object obj, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$key = obj;
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SaveableStateHolderImpl.this.SaveableStateProvider(this.$key, this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SaveableStateHolderImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Map<String, List<Object>>> saveAll() {
        Map<Object, Map<String, List<Object>>> mapZ = r0.z(this.savedStates);
        Iterator<T> it = this.registryHolders.values().iterator();
        while (it.hasNext()) {
            ((RegistryHolder) it.next()).saveTo(mapZ);
        }
        if (mapZ.isEmpty()) {
            return null;
        }
        return mapZ;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    @Composable
    public void SaveableStateProvider(@NotNull Object key, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(key, "key");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1198538093);
        composerStartRestartGroup.startReplaceableGroup(444418301);
        composerStartRestartGroup.startReusableGroup(207, key);
        composerStartRestartGroup.startReplaceableGroup(-642722479);
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            SaveableStateRegistry saveableStateRegistry = this.parentSaveableStateRegistry;
            if (!(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(key) : true)) {
                throw new IllegalArgumentException(("Type of the key " + key + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
            objRememberedValue = new RegistryHolder(this, key);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        RegistryHolder registryHolder = (RegistryHolder) objRememberedValue;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(registryHolder.getRegistry())}, content, composerStartRestartGroup, (i10 & 112) | 8);
        EffectsKt.DisposableEffect(k0.f35197a, new SaveableStateHolderImpl$SaveableStateProvider$1$1(this, key, registryHolder), composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReusableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(key, content, i10));
    }

    @Nullable
    public final SaveableStateRegistry getParentSaveableStateRegistry() {
        return this.parentSaveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void removeState(@NotNull Object key) {
        t.i(key, "key");
        RegistryHolder registryHolder = this.registryHolders.get(key);
        if (registryHolder != null) {
            registryHolder.setShouldSave(false);
        } else {
            this.savedStates.remove(key);
        }
    }

    public final void setParentSaveableStateRegistry(@Nullable SaveableStateRegistry saveableStateRegistry) {
        this.parentSaveableStateRegistry = saveableStateRegistry;
    }

    public SaveableStateHolderImpl(@NotNull Map<Object, Map<String, List<Object>>> savedStates) {
        t.i(savedStates, "savedStates");
        this.savedStates = savedStates;
        this.registryHolders = new LinkedHashMap();
    }

    public /* synthetic */ SaveableStateHolderImpl(Map map, int i10, k kVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map);
    }
}

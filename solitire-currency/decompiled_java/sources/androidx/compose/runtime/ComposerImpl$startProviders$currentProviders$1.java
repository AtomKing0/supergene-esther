package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$startProviders$currentProviders$1 extends v implements p<Composer, Integer, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>>> {
    final /* synthetic */ PersistentMap<CompositionLocal<Object>, State<Object>> $parentScope;
    final /* synthetic */ ProvidedValue<?>[] $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposerImpl$startProviders$currentProviders$1(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        super(2);
        this.$values = providedValueArr;
        this.$parentScope = persistentMap;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> mo4invoke(Composer composer, Integer num) {
        return invoke(composer, num.intValue());
    }

    @Composable
    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> invoke(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(935231726);
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMapCompositionLocalMapOf = ComposerKt.compositionLocalMapOf(this.$values, this.$parentScope, composer, 8);
        composer.endReplaceableGroup();
        return persistentMapCompositionLocalMapOf;
    }
}

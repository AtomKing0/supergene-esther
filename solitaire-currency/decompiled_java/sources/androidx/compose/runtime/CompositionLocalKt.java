package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import h9.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: CompositionLocal.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ ProvidedValue<?>[] $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ProvidedValue<?>[] providedValueArr, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$values = providedValueArr;
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
            ProvidedValue<?>[] providedValueArr = this.$values;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) Arrays.copyOf(providedValueArr, providedValueArr.length), this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$3, reason: invalid class name */
    /* JADX INFO: compiled from: CompositionLocal.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ CompositionLocalContext $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(CompositionLocalContext compositionLocalContext, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$context = compositionLocalContext;
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
            CompositionLocalKt.CompositionLocalProvider(this.$context, this.$content, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(@NotNull ProvidedValue<?>[] values, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(values, "values");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1390796515);
        composerStartRestartGroup.startProviders(values);
        content.mo4invoke(composerStartRestartGroup, Integer.valueOf((i10 >> 3) & 14));
        composerStartRestartGroup.endProviders();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(values, content, i10));
    }

    @NotNull
    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(@NotNull SnapshotMutationPolicy<T> policy, @NotNull h9.a<? extends T> defaultFactory) {
        t.i(policy, "policy");
        t.i(defaultFactory, "defaultFactory");
        return new DynamicProvidableCompositionLocal(policy, defaultFactory);
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy snapshotMutationPolicy, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return compositionLocalOf(snapshotMutationPolicy, aVar);
    }

    @NotNull
    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(@NotNull h9.a<? extends T> defaultFactory) {
        t.i(defaultFactory, "defaultFactory");
        return new StaticProvidableCompositionLocal(defaultFactory);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(@NotNull CompositionLocalContext context, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(context, "context");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1853897736);
        int i11 = (i10 & 14) == 0 ? (composerStartRestartGroup.changed(context) ? 4 : 2) | i10 : i10;
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocals$runtime_release = context.getCompositionLocals$runtime_release();
            ArrayList arrayList = new ArrayList(compositionLocals$runtime_release.size());
            for (Map.Entry<CompositionLocal<Object>, State<Object>> entry : compositionLocals$runtime_release.entrySet()) {
                arrayList.add(((ProvidableCompositionLocal) entry.getKey()).provides(entry.getValue().getValue()));
            }
            Object[] array = arrayList.toArray(new ProvidedValue[0]);
            if (array != null) {
                ProvidedValue[] providedValueArr = (ProvidedValue[]) array;
                CompositionLocalProvider((ProvidedValue<?>[]) Arrays.copyOf(providedValueArr, providedValueArr.length), content, composerStartRestartGroup, (i11 & 112) | 8);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(context, content, i10));
    }
}

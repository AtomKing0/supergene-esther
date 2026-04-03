package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import h9.a;
import h9.l;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.b;

/* JADX INFO: compiled from: RememberSaveable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1, reason: invalid class name */
    /* JADX INFO: compiled from: RememberSaveable.kt */
    static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ String $finalKey;
        final /* synthetic */ SaveableStateRegistry $registry;
        final /* synthetic */ State<Saver<T, Object>> $saverState;
        final /* synthetic */ State<T> $valueState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SaveableStateRegistry saveableStateRegistry, String str, State<? extends Saver<T, Object>> state, State<? extends T> state2) {
            super(1);
            this.$registry = saveableStateRegistry;
            this.$finalKey = str;
            this.$saverState = state;
            this.$valueState = state2;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            RememberSaveableKt$rememberSaveable$1$valueProvider$1 rememberSaveableKt$rememberSaveable$1$valueProvider$1 = new RememberSaveableKt$rememberSaveable$1$valueProvider$1(this.$saverState, this.$valueState, this.$registry);
            RememberSaveableKt.requireCanBeSaved(this.$registry, rememberSaveableKt$rememberSaveable$1$valueProvider$1.invoke());
            final SaveableStateRegistry.Entry entryRegisterProvider = this.$registry.registerProvider(this.$finalKey, rememberSaveableKt$rememberSaveable$1$valueProvider$1);
            return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    entryRegisterProvider.unregister();
                }
            };
        }
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1(saver), new RememberSaveableKt$mutableStateSaver$1$2(saver));
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberSaveable, reason: collision with other method in class */
    public static final <T> T m1271rememberSaveable(@NotNull Object[] inputs, @Nullable Saver<T, ? extends Object> saver, @Nullable String str, @NotNull a<? extends T> init, @Nullable Composer composer, int i10, int i11) {
        Object objConsumeRestored;
        t.i(inputs, "inputs");
        t.i(init, "init");
        composer.startReplaceableGroup(441892779);
        if ((i11 & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        int i12 = i11 & 4;
        T tRestore = null;
        if (i12 != 0) {
            str = null;
        }
        composer.startReplaceableGroup(1059366469);
        if (str == null || str.length() == 0) {
            str = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash(composer, 0), b.a(MaxSupportedRadix));
            t.h(str, "toString(this, checkRadix(radix))");
        }
        composer.endReplaceableGroup();
        if (saver == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        }
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        Object[] objArrCopyOf = Arrays.copyOf(inputs, inputs.length);
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : objArrCopyOf) {
            zChanged |= composer.changed(obj);
        }
        T tInvoke = (T) composer.rememberedValue();
        if (zChanged || tInvoke == Composer.Companion.getEmpty()) {
            if (saveableStateRegistry != null && (objConsumeRestored = saveableStateRegistry.consumeRestored(str)) != null) {
                tRestore = saver.restore(objConsumeRestored);
            }
            tInvoke = tRestore == null ? init.invoke() : tRestore;
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        if (saveableStateRegistry != null) {
            EffectsKt.DisposableEffect(saveableStateRegistry, str, new AnonymousClass1(saveableStateRegistry, str, SnapshotStateKt.rememberUpdatedState(saver, composer, 0), SnapshotStateKt.rememberUpdatedState(tInvoke, composer, 0)), composer, 0);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj == null || saveableStateRegistry.canBeSaved(obj)) {
            return;
        }
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
        }
        throw new IllegalArgumentException(str);
    }

    @Composable
    @NotNull
    public static final <T> MutableState<T> rememberSaveable(@NotNull Object[] inputs, @NotNull Saver<T, ? extends Object> stateSaver, @Nullable String str, @NotNull a<? extends MutableState<T>> init, @Nullable Composer composer, int i10, int i11) {
        t.i(inputs, "inputs");
        t.i(stateSaver, "stateSaver");
        t.i(init, "init");
        composer.startReplaceableGroup(-202053668);
        if ((i11 & 4) != 0) {
            str = null;
        }
        MutableState<T> mutableState = (MutableState) m1271rememberSaveable(Arrays.copyOf(inputs, inputs.length), mutableStateSaver(stateSaver), str, (a) init, composer, (i10 & 896) | 8 | (i10 & 7168), 0);
        composer.endReplaceableGroup();
        return mutableState;
    }
}

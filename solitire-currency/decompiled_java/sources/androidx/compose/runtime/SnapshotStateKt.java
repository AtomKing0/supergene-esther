package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import h9.l;
import h9.p;
import java.util.Collection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.m0;
import v8.k0;
import v8.s;
import z8.g;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateKt {
    @Composable
    @NotNull
    public static final <T extends R, R> State<R> collectAsState(@NotNull h<? extends T> hVar, R r10, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(hVar, r10, gVar, composer, i10, i11);
    }

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull h9.a<? extends T> aVar) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(aVar);
    }

    public static final <T> T getValue(@NotNull State<? extends T> state, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(state, obj, kProperty);
    }

    @NotNull
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    @NotNull
    public static final <T> MutableState<T> mutableStateOf(T t10, @NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t10, snapshotMutationPolicy);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(@NotNull l<? super State<?>, k0> lVar, @NotNull l<? super State<?>, k0> lVar2, @NotNull h9.a<? extends R> aVar) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(lVar, lVar2, aVar);
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__ProduceStateKt.produceState(t10, pVar, composer, i10);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    @Composable
    @NotNull
    public static final <T> State<T> rememberUpdatedState(T t10, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t10, composer, i10);
    }

    public static final <T> void setValue(@NotNull MutableState<T> mutableState, @Nullable Object obj, @NotNull KProperty<?> kProperty, T t10) {
        SnapshotStateKt__SnapshotStateKt.setValue(mutableState, obj, kProperty, t10);
    }

    @NotNull
    public static final <T> h<T> snapshotFlow(@NotNull h9.a<? extends T> aVar) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(aVar);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    @NotNull
    public static final <T> SnapshotStateList<T> toMutableStateList(@NotNull Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(@NotNull Iterable<? extends s<? extends K, ? extends V>> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsState(@NotNull m0<? extends T> m0Var, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(m0Var, gVar, composer, i10, i11);
    }

    @NotNull
    public static final <T> SnapshotStateList<T> mutableStateListOf(@NotNull T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(@NotNull s<? extends K, ? extends V>... sVarArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(sVarArr);
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__ProduceStateKt.produceState(t10, obj, pVar, composer, i10);
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @Nullable Object obj2, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__ProduceStateKt.produceState(t10, obj, obj2, pVar, composer, i10);
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__ProduceStateKt.produceState(t10, obj, obj2, obj3, pVar, composer, i10);
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @NotNull Object[] objArr, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, @Nullable Composer composer, int i10) {
        return SnapshotStateKt__ProduceStateKt.produceState((Object) t10, objArr, (p) pVar, composer, i10);
    }
}

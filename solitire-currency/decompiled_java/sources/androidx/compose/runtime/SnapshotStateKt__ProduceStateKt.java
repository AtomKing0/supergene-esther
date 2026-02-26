package androidx.compose.runtime;

import androidx.media3.extractor.ts.TsExtractor;
import h9.p;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: ProduceState.kt */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__ProduceStateKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1", f = "ProduceState.kt", l = {86}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ProduceStateScope<T>, z8.d<? super k0>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, MutableState<T> mutableState, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$producer = pVar;
            this.$result = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$producer, this.$result, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                p<ProduceStateScope<T>, z8.d<? super k0>, Object> pVar = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, o0Var.getCoroutineContext());
                this.label = 1;
                if (pVar.mo4invoke(produceStateScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2", f = "ProduceState.kt", l = {119}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ProduceStateScope<T>, z8.d<? super k0>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, MutableState<T> mutableState, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$producer = pVar;
            this.$result = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$producer, this.$result, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                p<ProduceStateScope<T>, z8.d<? super k0>, Object> pVar = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, o0Var.getCoroutineContext());
                this.label = 1;
                if (pVar.mo4invoke(produceStateScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3", f = "ProduceState.kt", l = {153}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ProduceStateScope<T>, z8.d<? super k0>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, MutableState<T> mutableState, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$producer = pVar;
            this.$result = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$producer, this.$result, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                p<ProduceStateScope<T>, z8.d<? super k0>, Object> pVar = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, o0Var.getCoroutineContext());
                this.label = 1;
                if (pVar.mo4invoke(produceStateScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4", f = "ProduceState.kt", l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend")
    static final class AnonymousClass4 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ProduceStateScope<T>, z8.d<? super k0>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, MutableState<T> mutableState, z8.d<? super AnonymousClass4> dVar) {
            super(2, dVar);
            this.$producer = pVar;
            this.$result = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$producer, this.$result, dVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                p<ProduceStateScope<T>, z8.d<? super k0>, Object> pVar = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, o0Var.getCoroutineContext());
                this.label = 1;
                if (pVar.mo4invoke(produceStateScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass4) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5, reason: invalid class name */
    /* JADX INFO: compiled from: ProduceState.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5", f = "ProduceState.kt", l = {222}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ProduceStateScope<T>, z8.d<? super k0>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> pVar, MutableState<T> mutableState, z8.d<? super AnonymousClass5> dVar) {
            super(2, dVar);
            this.$producer = pVar;
            this.$result = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$producer, this.$result, dVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                p<ProduceStateScope<T>, z8.d<? super k0>, Object> pVar = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, o0Var.getCoroutineContext());
                this.label = 1;
                if (pVar.mo4invoke(produceStateScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass5) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> producer, @Nullable Composer composer, int i10) {
        t.i(producer, "producer");
        composer.startReplaceableGroup(10454275);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(k0.f35197a, new AnonymousClass1(producer, mutableState, null), composer, 0);
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> producer, @Nullable Composer composer, int i10) {
        t.i(producer, "producer");
        composer.startReplaceableGroup(-1928268701);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, new AnonymousClass2(producer, mutableState, null), composer, 8);
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @Nullable Object obj2, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> producer, @Nullable Composer composer, int i10) {
        t.i(producer, "producer");
        composer.startReplaceableGroup(-1703169085);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, new AnonymousClass3(producer, mutableState, null), composer, 72);
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> producer, @Nullable Composer composer, int i10) {
        t.i(producer, "producer");
        composer.startReplaceableGroup(1807205155);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, obj3, new AnonymousClass4(producer, mutableState, null), composer, 584);
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    @NotNull
    public static final <T> State<T> produceState(T t10, @NotNull Object[] keys, @NotNull p<? super ProduceStateScope<T>, ? super z8.d<? super k0>, ? extends Object> producer, @Nullable Composer composer, int i10) {
        t.i(keys, "keys");
        t.i(producer, "producer");
        composer.startReplaceableGroup(490154582);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(Arrays.copyOf(keys, keys.length), (p<? super o0, ? super z8.d<? super k0>, ? extends Object>) new AnonymousClass5(producer, mutableState, null), composer, 8);
        composer.endReplaceableGroup();
        return mutableState;
    }
}

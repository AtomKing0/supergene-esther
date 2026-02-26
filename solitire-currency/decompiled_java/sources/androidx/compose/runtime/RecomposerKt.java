package androidx.compose.runtime;

import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RecomposerKt {
    private static final int RecomposerCompoundHashKey = 1000;

    @NotNull
    private static final Object ProduceAnotherFrame = new Object();

    @NotNull
    private static final Object FramePending = new Object();

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2, reason: invalid class name */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", f = "Recomposer.kt", l = {69, 71}, m = "invokeSuspend")
    static final class AnonymousClass2<R> extends l implements p<o0, z8.d<? super R>, Object> {
        final /* synthetic */ q<o0, Recomposer, z8.d<? super R>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Recomposer.kt */
        @f(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1", f = "Recomposer.kt", l = {68}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ Recomposer $recomposer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Recomposer recomposer, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$recomposer = recomposer;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.$recomposer, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    Recomposer recomposer = this.$recomposer;
                    this.label = 1;
                    if (recomposer.runRecomposeAndApplyChanges(this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(q<? super o0, ? super Recomposer, ? super z8.d<? super R>, ? extends Object> qVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$block = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Recomposer recomposer;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                recomposer = new Recomposer(o0Var.getCoroutineContext());
                k.d(o0Var, null, null, new AnonymousClass1(recomposer, null), 3, null);
                q<o0, Recomposer, z8.d<? super R>, Object> qVar = this.$block;
                this.L$0 = recomposer;
                this.label = 1;
                obj = qVar.invoke(o0Var, recomposer, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj2 = this.L$0;
                    u.b(obj);
                    return obj2;
                }
                recomposer = (Recomposer) this.L$0;
                u.b(obj);
            }
            recomposer.close();
            this.L$0 = obj;
            this.label = 2;
            return recomposer.join(this) == objE ? objE : obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super R> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public static final <K, V> boolean addMultiValue(@NotNull Map<K, List<V>> map, K k10, V v10) {
        t.i(map, "<this>");
        List<V> arrayList = map.get(k10);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(k10, arrayList);
        }
        return arrayList.add(v10);
    }

    @Nullable
    public static final <K, V> V removeLastMultiValue(@NotNull Map<K, List<V>> map, K k10) {
        t.i(map, "<this>");
        List<V> list = map.get(k10);
        if (list == null) {
            return null;
        }
        V v10 = (V) a0.M(list);
        if (!list.isEmpty()) {
            return v10;
        }
        map.remove(k10);
        return v10;
    }

    @Nullable
    public static final <R> Object withRunningRecomposer(@NotNull q<? super o0, ? super Recomposer, ? super z8.d<? super R>, ? extends Object> qVar, @NotNull z8.d<? super R> dVar) {
        return p0.f(new AnonymousClass2(qVar, null), dVar);
    }
}

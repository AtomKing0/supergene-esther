package androidx.compose.runtime;

import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import s9.m0;
import v8.k0;
import v8.u;
import z8.g;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1", f = "SnapshotFlow.kt", l = {65, 66}, m = "invokeSuspend")
    static final class AnonymousClass1<R> extends l implements p<ProduceStateScope<R>, z8.d<? super k0>, Object> {
        final /* synthetic */ g $context;
        final /* synthetic */ h<T> $this_collectAsState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SnapshotFlow.kt */
        @f(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2", f = "SnapshotFlow.kt", l = {67}, m = "invokeSuspend")
        static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ ProduceStateScope<R> $$this$produceState;
            final /* synthetic */ h<T> $this_collectAsState;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(h<? extends T> hVar, ProduceStateScope<R> produceStateScope, z8.d<? super AnonymousClass2> dVar) {
                super(2, dVar);
                this.$this_collectAsState = hVar;
                this.$$this$produceState = produceStateScope;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass2(this.$this_collectAsState, this.$$this$produceState, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    h<T> hVar = this.$this_collectAsState;
                    final ProduceStateScope<R> produceStateScope = this.$$this$produceState;
                    Object obj2 = new i<T>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.collectAsState.1.2.1
                        @Override // s9.i
                        @Nullable
                        public final Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
                            produceStateScope.setValue(t10);
                            return k0.f35197a;
                        }
                    };
                    this.label = 1;
                    if (hVar.collect(obj2, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(g gVar, h<? extends T> hVar, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$context = gVar;
            this.$this_collectAsState = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$this_collectAsState, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ProduceStateScope<R> produceStateScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(produceStateScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
                if (t.d(this.$context, z8.h.f37608a)) {
                    h<T> hVar = this.$this_collectAsState;
                    Object obj2 = new i<T>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.collectAsState.1.1
                        @Override // s9.i
                        @Nullable
                        public final Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
                            produceStateScope.setValue(t10);
                            return k0.f35197a;
                        }
                    };
                    this.label = 1;
                    if (hVar.collect(obj2, this) == objE) {
                        return objE;
                    }
                } else {
                    g gVar = this.$context;
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_collectAsState, produceStateScope, null);
                    this.label = 2;
                    if (kotlinx.coroutines.i.g(gVar, anonymousClass2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @f(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", l = {134, 138, 160}, m = "invokeSuspend")
    static final class C09891<T> extends l implements p<i<? super T>, z8.d<? super k0>, Object> {
        final /* synthetic */ h9.a<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09891(h9.a<? extends T> aVar, z8.d<? super C09891> dVar) {
            super(2, dVar);
            this.$block = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C09891 c09891 = new C09891(this.$block, dVar);
            c09891.L$0 = obj;
            return c09891;
        }

        /* JADX WARN: Path cross not found for [B:36:0x00e8, B:40:0x00f1], limit reached: 83 */
        /* JADX WARN: Path cross not found for [B:44:0x0100, B:61:0x0146], limit reached: 83 */
        /* JADX WARN: Path cross not found for [B:61:0x0146, B:44:0x0100], limit reached: 83 */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00db A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0100 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #2 {all -> 0x0053, blocks: (B:34:0x00e4, B:36:0x00e8, B:41:0x00f2, B:44:0x0100, B:48:0x0116, B:50:0x011f, B:59:0x0142, B:60:0x0145, B:11:0x004b, B:45:0x010b, B:47:0x0113, B:56:0x013d, B:57:0x0140, B:46:0x010f), top: B:75:0x004b, inners: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 350
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.C09891.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super T> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((C09891) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsState(@NotNull m0<? extends T> m0Var, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        t.i(m0Var, "<this>");
        composer.startReplaceableGroup(-1439883919);
        if ((i11 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(m0Var, m0Var.getValue(), gVar, composer, IronSourceError.ERROR_NO_INTERNET_CONNECTION, 0);
        composer.endReplaceableGroup();
        return stateCollectAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean intersects$SnapshotStateKt__SnapshotFlowKt(Set<? extends T> set, Set<? extends T> set2) {
        if (set.size() < set2.size()) {
            Set<? extends T> set3 = set;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                Iterator<T> it = set3.iterator();
                while (it.hasNext()) {
                    if (set2.contains(it.next())) {
                        return true;
                    }
                }
            }
        } else {
            Set<? extends T> set4 = set2;
            if (!(set4 instanceof Collection) || !set4.isEmpty()) {
                Iterator<T> it2 = set4.iterator();
                while (it2.hasNext()) {
                    if (set.contains(it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final <T> h<T> snapshotFlow(@NotNull h9.a<? extends T> block) {
        t.i(block, "block");
        return j.z(new C09891(block, null));
    }

    @Composable
    @NotNull
    public static final <T extends R, R> State<R> collectAsState(@NotNull h<? extends T> hVar, R r10, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        t.i(hVar, "<this>");
        composer.startReplaceableGroup(-606625098);
        if ((i11 & 2) != 0) {
            gVar = z8.h.f37608a;
        }
        g gVar2 = gVar;
        int i12 = i10 >> 3;
        State<R> stateProduceState = SnapshotStateKt.produceState(r10, hVar, gVar2, new AnonymousClass1(gVar2, hVar, null), composer, (i12 & 8) | 576 | (i12 & 14));
        composer.endReplaceableGroup();
        return stateProduceState;
    }
}

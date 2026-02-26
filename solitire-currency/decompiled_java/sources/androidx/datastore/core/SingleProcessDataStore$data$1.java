package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import h9.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
final class SingleProcessDataStore$data$1<T> extends l implements p<i<? super T>, d<? super k0>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<State<T>, d<? super Boolean>, Object> {
        final /* synthetic */ State<T> $currentDownStreamFlowState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<T> state, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$currentDownStreamFlowState = state;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentDownStreamFlowState, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull State<T> state, @Nullable d<? super Boolean> dVar) {
            return ((AnonymousClass1) create(state, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            State<T> state = (State) this.L$0;
            State<T> state2 = this.$currentDownStreamFlowState;
            boolean z10 = false;
            if (!(state2 instanceof Data) && !(state2 instanceof Final) && state == state2) {
                z10 = true;
            }
            return b.a(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, d<? super SingleProcessDataStore$data$1> dVar) {
        super(2, dVar);
        this.this$0 = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, dVar);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            i iVar = (i) this.L$0;
            State state = (State) ((SingleProcessDataStore) this.this$0).downstreamFlow.getValue();
            if (!(state instanceof Data)) {
                ((SingleProcessDataStore) this.this$0).actor.offer(new SingleProcessDataStore.Message.Read(state));
            }
            final h hVarQ = j.q(((SingleProcessDataStore) this.this$0).downstreamFlow, new AnonymousClass1(state, null));
            h<T> hVar = new h<T>() { // from class: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Collect.kt */
                public static final class AnonymousClass2 implements i<State<T>> {
                    final /* synthetic */ i $this_unsafeFlow$inlined;

                    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(d dVar) {
                            super(dVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i iVar) {
                        this.$this_unsafeFlow$inlined = iVar;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // s9.i
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull z8.d r6) throws java.lang.Throwable {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = a9.b.e()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            v8.u.b(r6)
                            goto L53
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            v8.u.b(r6)
                            s9.i r6 = r4.$this_unsafeFlow$inlined
                            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                            boolean r2 = r5 instanceof androidx.datastore.core.ReadException
                            if (r2 != 0) goto L73
                            boolean r2 = r5 instanceof androidx.datastore.core.Final
                            if (r2 != 0) goto L6c
                            boolean r2 = r5 instanceof androidx.datastore.core.Data
                            if (r2 == 0) goto L56
                            androidx.datastore.core.Data r5 = (androidx.datastore.core.Data) r5
                            java.lang.Object r5 = r5.getValue()
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L53
                            return r1
                        L53:
                            v8.k0 r5 = v8.k0.f35197a
                            return r5
                        L56:
                            boolean r5 = r5 instanceof androidx.datastore.core.UnInitialized
                            if (r5 == 0) goto L66
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                            java.lang.String r6 = r6.toString()
                            r5.<init>(r6)
                            throw r5
                        L66:
                            v8.q r5 = new v8.q
                            r5.<init>()
                            throw r5
                        L6c:
                            androidx.datastore.core.Final r5 = (androidx.datastore.core.Final) r5
                            java.lang.Throwable r5 = r5.getFinalException()
                            throw r5
                        L73:
                            androidx.datastore.core.ReadException r5 = (androidx.datastore.core.ReadException) r5
                            java.lang.Throwable r5 = r5.getReadException()
                            throw r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                    }
                }

                @Override // s9.h
                @Nullable
                public Object collect(@NotNull i iVar2, @NotNull d dVar) {
                    Object objCollect = hVarQ.collect(new AnonymousClass2(iVar2), dVar);
                    return objCollect == a9.d.e() ? objCollect : k0.f35197a;
                }
            };
            this.label = 1;
            if (j.s(iVar, hVar, this) == objE) {
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
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull i<? super T> iVar, @Nullable d<? super k0> dVar) {
        return ((SingleProcessDataStore$data$1) create(iVar, dVar)).invokeSuspend(k0.f35197a);
    }
}

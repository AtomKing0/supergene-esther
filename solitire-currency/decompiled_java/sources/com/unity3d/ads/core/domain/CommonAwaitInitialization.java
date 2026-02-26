package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: CommonAwaitInitialization.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonAwaitInitialization implements AwaitInitialization {

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: CommonAwaitInitialization.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2", f = "CommonAwaitInitialization.kt", l = {15}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super InitializationState>, Object> {
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return CommonAwaitInitialization.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final h<InitializationState> observeInitializationState = CommonAwaitInitialization.this.sessionRepository.getObserveInitializationState();
                h<InitializationState> hVar = new h<InitializationState>() { // from class: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1

                    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    public static final class AnonymousClass2<T> implements i {
                        final /* synthetic */ i $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @f(c = "com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2", f = "CommonAwaitInitialization.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                        public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                            Object L$0;
                            Object L$1;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(z8.d dVar) {
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
                            this.$this_unsafeFlow = iVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // s9.i
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = a9.b.e()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                v8.u.b(r7)
                                goto L50
                            L29:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L31:
                                v8.u.b(r7)
                                s9.i r7 = r5.$this_unsafeFlow
                                r2 = r6
                                com.unity3d.ads.core.data.model.InitializationState r2 = (com.unity3d.ads.core.data.model.InitializationState) r2
                                com.unity3d.ads.core.data.model.InitializationState r4 = com.unity3d.ads.core.data.model.InitializationState.INITIALIZED
                                if (r2 == r4) goto L44
                                com.unity3d.ads.core.data.model.InitializationState r4 = com.unity3d.ads.core.data.model.InitializationState.FAILED
                                if (r2 != r4) goto L42
                                goto L44
                            L42:
                                r2 = 0
                                goto L45
                            L44:
                                r2 = r3
                            L45:
                                if (r2 == 0) goto L50
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r6, r0)
                                if (r6 != r1) goto L50
                                return r1
                            L50:
                                v8.k0 r6 = v8.k0.f35197a
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                        }
                    }

                    @Override // s9.h
                    @Nullable
                    public Object collect(@NotNull i<? super InitializationState> iVar, @NotNull z8.d dVar) {
                        Object objCollect = observeInitializationState.collect(new AnonymousClass2(iVar), dVar);
                        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
                    }
                };
                this.label = 1;
                obj = j.w(hVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super InitializationState> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public CommonAwaitInitialization(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.AwaitInitialization
    @Nullable
    public Object invoke(long j10, @NotNull z8.d<? super InitializationState> dVar) {
        return f3.e(j10, new AnonymousClass2(null), dVar);
    }
}

package androidx.datastore.core;

import h9.l;
import h9.p;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.g;
import r9.h;
import r9.n;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: SimpleActor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleActor<T> {

    @NotNull
    private final p<T, d<? super k0>, Object> consumeMessage;

    @NotNull
    private final r9.d<T> messageQueue;

    @NotNull
    private final AtomicInteger remainingMessages;

    @NotNull
    private final o0 scope;

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$1, reason: invalid class name */
    /* JADX INFO: compiled from: SimpleActor.kt */
    static final class AnonymousClass1 extends v implements l<Throwable, k0> {
        final /* synthetic */ l<Throwable, k0> $onComplete;
        final /* synthetic */ p<T, Throwable, k0> $onUndeliveredElement;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(l<? super Throwable, k0> lVar, SimpleActor<T> simpleActor, p<? super T, ? super Throwable, k0> pVar) {
            super(1);
            this.$onComplete = lVar;
            this.this$0 = simpleActor;
            this.$onUndeliveredElement = pVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            k0 k0Var;
            this.$onComplete.invoke(th);
            ((SimpleActor) this.this$0).messageQueue.d(th);
            do {
                Object objF = h.f(((SimpleActor) this.this$0).messageQueue.h());
                if (objF == null) {
                    k0Var = null;
                } else {
                    this.$onUndeliveredElement.mo4invoke(objF, th);
                    k0Var = k0.f35197a;
                }
            } while (k0Var != null);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    /* JADX INFO: compiled from: SimpleActor.kt */
    @f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SimpleActor<T> simpleActor, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.this$0 = simpleActor;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(this.this$0, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006c -> B:24:0x006e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                v8.u.b(r8)
                r8 = r7
                goto L6e
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                java.lang.Object r1 = r7.L$0
                h9.p r1 = (h9.p) r1
                v8.u.b(r8)
                r4 = r1
                r1 = r0
                r0 = r7
                goto L60
            L26:
                v8.u.b(r8)
                androidx.datastore.core.SimpleActor<T> r8 = r7.this$0
                java.util.concurrent.atomic.AtomicInteger r8 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r8)
                int r8 = r8.get()
                if (r8 <= 0) goto L37
                r8 = r3
                goto L38
            L37:
                r8 = 0
            L38:
                if (r8 == 0) goto L7d
                r8 = r7
            L3b:
                androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
                kotlinx.coroutines.o0 r1 = androidx.datastore.core.SimpleActor.access$getScope$p(r1)
                kotlinx.coroutines.p0.g(r1)
                androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
                h9.p r1 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r1)
                androidx.datastore.core.SimpleActor<T> r4 = r8.this$0
                r9.d r4 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r4)
                r8.L$0 = r1
                r8.label = r3
                java.lang.Object r4 = r4.s(r8)
                if (r4 != r0) goto L5b
                return r0
            L5b:
                r6 = r0
                r0 = r8
                r8 = r4
                r4 = r1
                r1 = r6
            L60:
                r5 = 0
                r0.L$0 = r5
                r0.label = r2
                java.lang.Object r8 = r4.mo4invoke(r8, r0)
                if (r8 != r1) goto L6c
                return r1
            L6c:
                r8 = r0
                r0 = r1
            L6e:
                androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
                java.util.concurrent.atomic.AtomicInteger r1 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r1)
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L3b
                v8.k0 r8 = v8.k0.f35197a
                return r8
            L7d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleActor(@NotNull o0 scope, @NotNull l<? super Throwable, k0> onComplete, @NotNull p<? super T, ? super Throwable, k0> onUndeliveredElement, @NotNull p<? super T, ? super d<? super k0>, ? extends Object> consumeMessage) {
        t.i(scope, "scope");
        t.i(onComplete, "onComplete");
        t.i(onUndeliveredElement, "onUndeliveredElement");
        t.i(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = g.b(Integer.MAX_VALUE, null, null, 6, null);
        this.remainingMessages = new AtomicInteger(0);
        b2 b2Var = (b2) scope.getCoroutineContext().get(b2.O7);
        if (b2Var == null) {
            return;
        }
        b2Var.J(new AnonymousClass1(onComplete, this, onUndeliveredElement));
    }

    public final void offer(T t10) {
        Object objF = this.messageQueue.f(t10);
        if (objF instanceof h.a) {
            Throwable thE = h.e(objF);
            if (thE != null) {
                throw thE;
            }
            throw new n("Channel was closed normally");
        }
        if (!h.i(objF)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            k.d(this.scope, null, null, new AnonymousClass2(this, null), 3, null);
        }
    }
}

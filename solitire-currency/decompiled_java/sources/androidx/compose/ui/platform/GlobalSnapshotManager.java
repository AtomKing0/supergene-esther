package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GlobalSnapshotManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshotManager {

    @NotNull
    public static final GlobalSnapshotManager INSTANCE = new GlobalSnapshotManager();

    @NotNull
    private static final AtomicBoolean started = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSnapshotManager.android.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", l = {63}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ r9.d<v8.k0> $channel;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(r9.d<v8.k0> dVar, z8.d<? super AnonymousClass1> dVar2) {
            super(2, dVar2);
            this.$channel = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.$channel, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:16:0x0041, B:18:0x0049), top: B:29:0x0041 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003b -> B:29:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r6.L$1
                r9.f r1 = (r9.f) r1
                java.lang.Object r3 = r6.L$0
                r9.t r3 = (r9.t) r3
                v8.u.b(r7)     // Catch: java.lang.Throwable -> L63
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r6
                goto L41
            L1b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L23:
                v8.u.b(r7)
                r9.d<v8.k0> r3 = r6.$channel
                r9.f r7 = r3.iterator()     // Catch: java.lang.Throwable -> L63
                r1 = r7
                r7 = r6
            L2e:
                r7.L$0 = r3     // Catch: java.lang.Throwable -> L63
                r7.L$1 = r1     // Catch: java.lang.Throwable -> L63
                r7.label = r2     // Catch: java.lang.Throwable -> L63
                java.lang.Object r4 = r1.b(r7)     // Catch: java.lang.Throwable -> L63
                if (r4 != r0) goto L3b
                return r0
            L3b:
                r5 = r0
                r0 = r7
                r7 = r4
                r4 = r3
                r3 = r1
                r1 = r5
            L41:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L60
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L60
                if (r7 == 0) goto L59
                java.lang.Object r7 = r3.next()     // Catch: java.lang.Throwable -> L60
                v8.k0 r7 = (v8.k0) r7     // Catch: java.lang.Throwable -> L60
                androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L60
                r7.sendApplyNotifications()     // Catch: java.lang.Throwable -> L60
                r7 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L2e
            L59:
                r7 = 0
                r9.j.a(r4, r7)
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L60:
                r7 = move-exception
                r3 = r4
                goto L64
            L63:
                r7 = move-exception
            L64:
                throw r7     // Catch: java.lang.Throwable -> L65
            L65:
                r0 = move-exception
                r9.j.a(r3, r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSnapshotManager.android.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.l<Object, v8.k0> {
        final /* synthetic */ r9.d<v8.k0> $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(r9.d<v8.k0> dVar) {
            super(1);
            this.$channel = dVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Object obj) {
            invoke2(obj);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object it) {
            kotlin.jvm.internal.t.i(it, "it");
            this.$channel.f(v8.k0.f35197a);
        }
    }

    private GlobalSnapshotManager() {
    }

    public final void ensureStarted() {
        if (started.compareAndSet(false, true)) {
            r9.d dVarB = r9.g.b(-1, null, null, 6, null);
            kotlinx.coroutines.k.d(kotlinx.coroutines.p0.a(AndroidUiDispatcher.Companion.getMain()), null, null, new AnonymousClass1(dVarB, null), 3, null);
            Snapshot.Companion.registerGlobalWriteObserver(new AnonymousClass2(dVarB));
        }
    }
}

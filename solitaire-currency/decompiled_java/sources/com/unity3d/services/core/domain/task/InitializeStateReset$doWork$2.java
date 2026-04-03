package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import z8.d;

/* JADX INFO: compiled from: InitializeStateReset.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", l = {41}, m = "invokeSuspend")
final class InitializeStateReset$doWork$2 extends l implements p<o0, d<? super t<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateReset.Params $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, d<? super InitializeStateReset$doWork$2> dVar) {
        super(2, dVar);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[Catch: all -> 0x00b5, CancellationException -> 0x00de, TryCatch #2 {CancellationException -> 0x00de, all -> 0x00b5, blocks: (B:6:0x0014, B:22:0x005d, B:27:0x006b, B:29:0x0077, B:31:0x0085, B:32:0x0087, B:34:0x008a, B:36:0x0096, B:37:0x00a1, B:38:0x00a4, B:39:0x00ad, B:40:0x00b4, B:25:0x0063, B:26:0x006a, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:53:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[Catch: all -> 0x00b5, CancellationException -> 0x00de, TryCatch #2 {CancellationException -> 0x00de, all -> 0x00b5, blocks: (B:6:0x0014, B:22:0x005d, B:27:0x006b, B:29:0x0077, B:31:0x0085, B:32:0x0087, B:34:0x008a, B:36:0x0096, B:37:0x00a1, B:38:0x00a4, B:39:0x00ad, B:40:0x00b4, B:25:0x0063, B:26:0x006a, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:53:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super t<? extends Configuration>> dVar) {
        return ((InitializeStateReset$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import z8.d;

/* JADX INFO: compiled from: InitializeStateLoadWeb.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", l = {46, 64, 71}, m = "invokeSuspend")
final class InitializeStateLoadWeb$doWork$2 extends l implements p<o0, d<? super t<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, d<? super InitializeStateLoadWeb$doWork$2> dVar) {
        super(2, dVar);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, dVar);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, d<? super t<? extends InitializeStateLoadWeb.LoadWebResult>> dVar) {
        return invoke2(o0Var, (d<? super t<InitializeStateLoadWeb.LoadWebResult>>) dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167 A[Catch: all -> 0x01ed, CancellationException -> 0x0216, TryCatch #6 {CancellationException -> 0x0216, all -> 0x01ed, blocks: (B:8:0x0018, B:51:0x0186, B:55:0x01a9, B:57:0x01b3, B:60:0x01be, B:61:0x01d0, B:63:0x01d3, B:64:0x01df, B:46:0x0161, B:48:0x0167, B:52:0x0189, B:53:0x019b, B:45:0x0157, B:38:0x0129, B:54:0x019c, B:37:0x011f, B:23:0x006f, B:13:0x0037, B:43:0x014e, B:40:0x012f), top: B:80:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0189 A[Catch: all -> 0x01ed, CancellationException -> 0x0216, TryCatch #6 {CancellationException -> 0x0216, all -> 0x01ed, blocks: (B:8:0x0018, B:51:0x0186, B:55:0x01a9, B:57:0x01b3, B:60:0x01be, B:61:0x01d0, B:63:0x01d3, B:64:0x01df, B:46:0x0161, B:48:0x0167, B:52:0x0189, B:53:0x019b, B:45:0x0157, B:38:0x0129, B:54:0x019c, B:37:0x011f, B:23:0x006f, B:13:0x0037, B:43:0x014e, B:40:0x012f), top: B:80:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b3 A[Catch: all -> 0x01ed, CancellationException -> 0x0216, TryCatch #6 {CancellationException -> 0x0216, all -> 0x01ed, blocks: (B:8:0x0018, B:51:0x0186, B:55:0x01a9, B:57:0x01b3, B:60:0x01be, B:61:0x01d0, B:63:0x01d3, B:64:0x01df, B:46:0x0161, B:48:0x0167, B:52:0x0189, B:53:0x019b, B:45:0x0157, B:38:0x0129, B:54:0x019c, B:37:0x011f, B:23:0x006f, B:13:0x0037, B:43:0x014e, B:40:0x012f), top: B:80:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d3 A[Catch: all -> 0x01ed, CancellationException -> 0x0216, TryCatch #6 {CancellationException -> 0x0216, all -> 0x01ed, blocks: (B:8:0x0018, B:51:0x0186, B:55:0x01a9, B:57:0x01b3, B:60:0x01be, B:61:0x01d0, B:63:0x01d3, B:64:0x01df, B:46:0x0161, B:48:0x0167, B:52:0x0189, B:53:0x019b, B:45:0x0157, B:38:0x0129, B:54:0x019c, B:37:0x011f, B:23:0x006f, B:13:0x0037, B:43:0x014e, B:40:0x012f), top: B:80:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0203  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r37) {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull o0 o0Var, @Nullable d<? super t<InitializeStateLoadWeb.LoadWebResult>> dVar) {
        return ((InitializeStateLoadWeb$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

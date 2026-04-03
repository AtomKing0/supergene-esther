package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.log.DeviceLog;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InitializeStateNetworkError.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", f = "InitializeStateNetworkError.kt", l = {39}, m = "invokeSuspend")
final class InitializeStateNetworkError$doWork$2 extends l implements p<o0, d<? super t<? extends k0>>, Object> {
    final /* synthetic */ InitializeStateNetworkError.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2(InitializeStateNetworkError initializeStateNetworkError, InitializeStateNetworkError.Params params, d<? super InitializeStateNetworkError$doWork$2> dVar) {
        super(2, dVar);
        this.this$0 = initializeStateNetworkError;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new InitializeStateNetworkError$doWork$2(this.this$0, this.$params, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, d<? super t<? extends k0>> dVar) {
        return invoke2(o0Var, (d<? super t<k0>>) dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objB;
        InitializeStateNetworkError initializeStateNetworkError;
        Object objE = a9.d.e();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u.b(obj);
                InitializeStateNetworkError initializeStateNetworkError2 = this.this$0;
                InitializeStateNetworkError.Params params = this.$params;
                t.a aVar = t.f35208b;
                DeviceLog.error("Unity Ads init: network error, waiting for connection events");
                initializeStateNetworkError2.maximumConnectedEvents = params.getConfig().getMaximumConnectedEvents();
                initializeStateNetworkError2.connectedEventThreshold = params.getConfig().getConnectedEventThreshold();
                long networkErrorTimeout = params.getConfig().getNetworkErrorTimeout();
                InitializeStateNetworkError$doWork$2$1$success$1 initializeStateNetworkError$doWork$2$1$success$1 = new InitializeStateNetworkError$doWork$2$1$success$1(initializeStateNetworkError2, null);
                this.L$0 = initializeStateNetworkError2;
                this.label = 1;
                Object objE2 = f3.e(networkErrorTimeout, initializeStateNetworkError$doWork$2$1$success$1, this);
                if (objE2 == objE) {
                    return objE;
                }
                initializeStateNetworkError = initializeStateNetworkError2;
                obj = objE2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                initializeStateNetworkError = (InitializeStateNetworkError) this.L$0;
                u.b(obj);
            }
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th) {
            t.a aVar2 = t.f35208b;
            objB = t.b(u.a(th));
        }
        if (((k0) obj) == null) {
            ConnectivityMonitor.removeListener(initializeStateNetworkError);
            throw new Exception("No connected events within the timeout!");
        }
        objB = t.b(k0.f35197a);
        if (t.h(objB)) {
            objB = t.b(objB);
        } else {
            Throwable thE = t.e(objB);
            if (thE != null) {
                objB = t.b(u.a(thE));
            }
        }
        return t.a(objB);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull o0 o0Var, @Nullable d<? super t<k0>> dVar) {
        return ((InitializeStateNetworkError$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

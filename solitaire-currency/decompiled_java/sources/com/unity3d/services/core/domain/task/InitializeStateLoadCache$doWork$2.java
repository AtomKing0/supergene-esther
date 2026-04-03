package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import h9.p;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InitializeStateLoadCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", f = "InitializeStateLoadCache.kt", l = {}, m = "invokeSuspend")
final class InitializeStateLoadCache$doWork$2 extends l implements p<o0, d<? super t<? extends InitializeStateLoadCache.LoadCacheResult>>, Object> {
    final /* synthetic */ InitializeStateLoadCache.Params $params;
    int label;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$2(InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadCache.Params params, d<? super InitializeStateLoadCache$doWork$2> dVar) {
        super(2, dVar);
        this.this$0 = initializeStateLoadCache;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new InitializeStateLoadCache$doWork$2(this.this$0, this.$params, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, d<? super t<? extends InitializeStateLoadCache.LoadCacheResult>> dVar) {
        return invoke2(o0Var, (d<? super t<InitializeStateLoadCache.LoadCacheResult>>) dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objB;
        InitializeStateLoadCache.LoadCacheResult loadCacheResult;
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        InitializeStateLoadCache initializeStateLoadCache = this.this$0;
        InitializeStateLoadCache.Params params = this.$params;
        try {
            t.a aVar = t.f35208b;
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            byte[] webViewData = initializeStateLoadCache.getWebViewData();
            boolean z10 = true;
            if (webViewData == null) {
                loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(true, null, 2, null);
            } else {
                String strSha256 = Utilities.Sha256(webViewData);
                Charset charsetForName = Charset.forName("UTF-8");
                kotlin.jvm.internal.t.h(charsetForName, "forName(\"UTF-8\")");
                String str = new String(webViewData, charsetForName);
                boolean z11 = strSha256 == null || !kotlin.jvm.internal.t.d(strSha256, params.getConfig().getWebViewHash());
                if (!z11) {
                    DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                }
                if (!z11) {
                    z10 = false;
                }
                loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(z10, str);
            }
            objB = t.b(loadCacheResult);
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th) {
            t.a aVar2 = t.f35208b;
            objB = t.b(u.a(th));
        }
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
    public final Object invoke2(@NotNull o0 o0Var, @Nullable d<? super t<InitializeStateLoadCache.LoadCacheResult>> dVar) {
        return ((InitializeStateLoadCache$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

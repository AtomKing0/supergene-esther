package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.properties.SdkProperties;
import f9.k;
import h9.p;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ConfigFileFromLocalStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", l = {}, m = "invokeSuspend")
final class ConfigFileFromLocalStorage$doWork$2 extends l implements p<o0, d<? super t<? extends Configuration>>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$2(ConfigFileFromLocalStorage.Params params, d<? super ConfigFileFromLocalStorage$doWork$2> dVar) {
        super(2, dVar);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new ConfigFileFromLocalStorage$doWork$2(this.$params, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objB;
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        ConfigFileFromLocalStorage.Params params = this.$params;
        try {
            t.a aVar = t.f35208b;
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            objB = t.b(!file.exists() ? params.getDefaultConfiguration() : new Configuration(new JSONObject(k.h(file, null, 1, null))));
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

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super t<? extends Configuration>> dVar) {
        return ((ConfigFileFromLocalStorage$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

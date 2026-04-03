package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t0 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final im f15357a;

    public static final class a implements fn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ vg f15358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InitListener f15359b;

        a(vg vgVar, InitListener initListener) {
            this.f15358a = vgVar;
            this.f15359b = initListener;
        }

        @Override // com.ironsource.fn
        public void onFail(@NotNull rf error) {
            kotlin.jvm.internal.t.i(error, "error");
            IronLog.ADAPTER_API.verbose("initSDKWithNetworkConfigurations error: " + error);
            this.f15359b.onInitFailed(hb.f12462a.a(new IronSourceError(error.a(), error.b())));
        }

        @Override // com.ironsource.fn
        public void onSuccess() {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("initSDKWithNetworkConfigurations success");
            StringBuilder sb = new StringBuilder();
            sb.append("controllerURL = ");
            r0 r0VarE = this.f15358a.e();
            sb.append(r0VarE != null ? r0VarE.c() : null);
            ironLog.verbose(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("controllerConfig = ");
            r0 r0VarE2 = this.f15358a.e();
            sb2.append(r0VarE2 != null ? r0VarE2.a() : null);
            ironLog.verbose(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("debugMode = ");
            r0 r0VarE3 = this.f15358a.e();
            sb3.append(r0VarE3 != null ? Integer.valueOf(r0VarE3.b()) : null);
            ironLog.verbose(sb3.toString());
            ironLog.verbose("applicationKey = " + this.f15358a.d());
            ironLog.verbose("userId = " + this.f15358a.h());
            this.f15359b.onInitSuccess();
        }
    }

    public t0(@NotNull im networkInitApi) {
        kotlin.jvm.internal.t.i(networkInitApi, "networkInitApi");
        this.f15357a = networkInitApi;
    }

    @Override // com.ironsource.s0
    public void a(@NotNull Context context, @NotNull vg initConfig, @NotNull InitListener initListener) {
        JSONObject jSONObjectA;
        String strC;
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initConfig, "initConfig");
        kotlin.jvm.internal.t.i(initListener, "initListener");
        im imVar = this.f15357a;
        r0 r0VarE = initConfig.e();
        imVar.a(r0VarE != null ? r0VarE.b() : 0);
        r0 r0VarE2 = initConfig.e();
        if (r0VarE2 != null && (strC = r0VarE2.c()) != null) {
            this.f15357a.b(strC);
        }
        r0 r0VarE3 = initConfig.e();
        if (r0VarE3 != null && (jSONObjectA = r0VarE3.a()) != null) {
            im imVar2 = this.f15357a;
            String string = jSONObjectA.toString();
            kotlin.jvm.internal.t.h(string, "applicationConfig.toString()");
            imVar2.a(string);
        }
        Map<String, String> mapA = new gm().a();
        this.f15357a.a(new a(initConfig, initListener));
        this.f15357a.a(context, initConfig.d(), initConfig.h(), mapA);
    }
}

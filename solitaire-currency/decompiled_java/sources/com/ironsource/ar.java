package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.cr;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ar {
    private final dq a(String str) {
        return str != null ? new dq(2110, str) : new dq(dq.f11856d, "noServerResponse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final nq a(Context context, sq sqVar, iq iqVar) {
        try {
            String strA = sqVar.a(context);
            if (TextUtils.isEmpty(strA)) {
                strA = sqVar.b(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            final kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
            String strSendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, iqVar.d(), iqVar.f(), strA, null, true, null, false), ah.a().toString(), new p.c() { // from class: com.ironsource.zu
                @Override // com.ironsource.mediationsdk.p.c
                public final void a(String str) {
                    ar.a(n0Var, str);
                }
            });
            if (strSendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return new nq(a((String) n0Var.f29834a));
            }
            if (sqVar.c()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(strSendPostRequest);
                String encryptedResponse = jSONObject.optString("response");
                if (TextUtils.isEmpty(encryptedResponse)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return new nq(new dq(2100, gq.f12335h));
                }
                boolean zOptBoolean = jSONObject.optBoolean("compression", false);
                kotlin.jvm.internal.t.h(encryptedResponse, "encryptedResponse");
                strSendPostRequest = a(encryptedResponse, zOptBoolean);
                if (TextUtils.isEmpty(strSendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    sqVar.d();
                    return new nq(new dq(dq.f11858f, gq.f12334g));
                }
            }
            cr crVar = new cr(context, iqVar.d(), iqVar.f(), strSendPostRequest);
            crVar.a(cr.a.SERVER);
            if (crVar.p()) {
                return new nq(new jq(crVar));
            }
            IronLog.INTERNAL.warning("response invalid - return null");
            return new nq(new dq(dq.f11857e, "serverResponseIsNotValid"));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.warning("exception = " + e10);
            return new nq(e10 instanceof JSONException ? new dq(dq.f11857e, "serverResponseIsNotValid") : new dq(510, "internal error"));
        }
    }

    private final nq b(Context context, sq sqVar, iq iqVar) {
        nq nqVarA = a(context, sqVar, iqVar);
        if (nqVarA.c()) {
            return nqVarA;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
        cr crVarA = sqVar.a(context, iqVar.d());
        if (crVarA == null) {
            return nqVarA;
        }
        nq nqVar = new nq(new jq(crVarA));
        IronSourceError ironSourceErrorBuildUsingCachedConfigurationError = ErrorBuilder.buildUsingCachedConfigurationError(iqVar.d(), iqVar.f());
        IronSourceLoggerManager.getLogger().log(ironSourceTag, ironSourceErrorBuildUsingCachedConfigurationError + ": " + nqVar.b(), 1);
        sqVar.e();
        return nqVar;
    }

    private final String a(String str, boolean z10) {
        String strDecryptAndDecompress = z10 ? IronSourceAES.decryptAndDecompress(xa.b().c(), str) : IronSourceAES.decode(xa.b().c(), str);
        kotlin.jvm.internal.t.h(strDecryptAndDecompress, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
        return strDecryptAndDecompress;
    }

    public final void a(@NotNull Context context, @NotNull iq request, @NotNull sq tools, @NotNull hq listener) {
        dq dqVarA;
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(request, "request");
        kotlin.jvm.internal.t.i(tools, "tools");
        kotlin.jvm.internal.t.i(listener, "listener");
        String strF = request.f();
        if (strF == null) {
            strF = "";
        }
        tools.a("userId", strF);
        tools.a("appKey", request.d());
        tools.b().i(request.f());
        nq nqVarB = b(context, tools, request);
        if (nqVarB.b() != null) {
            bq bqVar = new bq(nqVarB.b());
            if (nqVarB.c()) {
                listener.a(bqVar);
                return;
            }
            dqVarA = new dq(dq.f11857e, "serverResponseIsNotValid");
        } else {
            dqVarA = nqVarB.a();
            if (dqVarA == null) {
                dqVarA = new dq(510, "unknown error");
            }
        }
        listener.a(dqVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(kotlin.jvm.internal.n0 reason, String errorMessage) {
        kotlin.jvm.internal.t.i(reason, "$reason");
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
        reason.f29834a = errorMessage;
    }
}

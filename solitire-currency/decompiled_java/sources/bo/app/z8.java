package bo.app;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f4407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cc0 f4408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4409c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z8(Throwable th, cc0 cc0Var, boolean z10) {
        super(0);
        this.f4407a = th;
        this.f4408b = cc0Var;
        this.f4409c = z10;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        String str;
        StringBuilder sb = new StringBuilder("\n                original_sdk_version: 32.1.0\n                exception_class: ");
        sb.append(this.f4407a.getClass().getName());
        sb.append("\n                available_cpus: ");
        sb.append(Runtime.getRuntime().availableProcessors());
        sb.append("\n                ");
        cc0 cc0Var = this.f4408b;
        if (cc0Var != null) {
            str = "session_id: " + cc0Var;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("\n                ");
        z9 z9Var = ba.f2429g;
        Throwable throwable = this.f4407a;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(throwable, "throwable");
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        kotlin.jvm.internal.t.h(string, "result.toString()");
        sb.append(p9.t.h1(string, 5000));
        sb.append("\n            ");
        JSONObject eventData = new JSONObject().put("e", p9.j.f(sb.toString()));
        if (!this.f4409c) {
            eventData.put("nop", true);
        }
        lx lxVar = lx.INTERNAL_ERROR;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}

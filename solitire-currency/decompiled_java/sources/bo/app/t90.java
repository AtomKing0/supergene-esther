package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import h9.r;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t90 extends kotlin.jvm.internal.q implements r {
    public t90(Object obj) {
        super(4, obj, w90.class, "log", "log$android_sdk_base_release(Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // h9.r
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        String tag = (String) obj;
        BrazeLogger.Priority priority = (BrazeLogger.Priority) obj2;
        String message = (String) obj3;
        Object obj5 = (Throwable) obj4;
        kotlin.jvm.internal.t.i(tag, "p0");
        kotlin.jvm.internal.t.i(priority, "p1");
        kotlin.jvm.internal.t.i(message, "p2");
        w90 w90Var = (w90) this.receiver;
        w90Var.getClass();
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(priority, "priority");
        kotlin.jvm.internal.t.i(message, "message");
        if (w90Var.f4178c.f3752a && !p9.r.P(message, "Braze v32.1.0 .", false, 2, null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(priority);
            sb.append(' ');
            sb.append(tag);
            sb.append(": ");
            sb.append(message);
            sb.append(' ');
            String str = "";
            if (obj5 == null) {
                obj5 = "";
            }
            sb.append(obj5);
            for (String str2 : p9.r.C0(sb.toString(), new String[]{"\n"}, false, 0, 6, null)) {
                if (str2.length() + str.length() > w90Var.f4178c.f3757f) {
                    w90Var.a(priority + ": " + str);
                    str = str2;
                } else {
                    str = str + '\n' + str2;
                }
            }
            if (str.length() > 0) {
                w90Var.a(str);
            }
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new v90(w90Var, null), 3, null);
        }
        return v8.k0.f35197a;
    }
}

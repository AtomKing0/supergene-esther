package bo.app;

import com.braze.support.BrazeLogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class ih0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ih0 f3062a = new ih0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd0 f3063b;

    static {
        try {
            f3063b = new cd0();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f3062a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) gh0.f2913a, 4, (Object) null);
        }
    }

    public final HttpURLConnection a(URL url) throws IOException {
        kotlin.jvm.internal.t.i(url, "url");
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (kotlin.jvm.internal.t.d(url.getProtocol(), "https")) {
            try {
                kotlin.jvm.internal.t.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                cd0 cd0Var = f3063b;
                if (cd0Var == null) {
                    kotlin.jvm.internal.t.A("socketFactory");
                    cd0Var = null;
                }
                httpsURLConnection.setSSLSocketFactory(cd0Var);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) hh0.f2982a, 4, (Object) null);
            }
        }
        kotlin.jvm.internal.t.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }
}

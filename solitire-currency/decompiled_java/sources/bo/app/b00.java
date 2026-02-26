package bo.app;

import android.net.TrafficStats;
import com.braze.support.BrazeLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b00 implements x00 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2409b = (int) TimeUnit.SECONDS.toMillis(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2410a;

    public b00(int i10) {
        this.f2410a = i10;
    }

    @Override // bo.app.x00
    public final w00 a(b90 requestTarget, HashMap requestHeaders, JSONObject payload) {
        kotlin.jvm.internal.t.i(requestTarget, "requestTarget");
        kotlin.jvm.internal.t.i(requestHeaders, "requestHeaders");
        kotlin.jvm.internal.t.i(payload, "payload");
        TrafficStats.setThreadStatsTag(1337);
        URL url = requestTarget.f2427c;
        Map mapG = kotlin.collections.r0.g();
        int responseCode = -1;
        try {
            HttpURLConnection httpURLConnectionA = a(url, payload, requestHeaders);
            responseCode = httpURLConnectionA.getResponseCode();
            Map<String, List<String>> headerFields = httpURLConnectionA.getHeaderFields();
            kotlin.jvm.internal.t.h(headerFields, "connection.headerFields");
            mapG = com.braze.support.i.a(headerFields);
            Reader inputStreamReader = new InputStreamReader(zz.a(httpURLConnectionA), p9.d.f32952b);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String strE = f9.p.e(bufferedReader);
                f9.c.a(bufferedReader, null);
                return new w00(responseCode, mapG, new JSONObject(strE));
            } finally {
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new a00(requestTarget), 4, (Object) null);
            return new w00(responseCode, mapG, 4);
        }
    }

    public final HttpURLConnection a(URL url, JSONObject jSONObject, HashMap map) throws IOException {
        String string = jSONObject.toString();
        kotlin.jvm.internal.t.h(string, "payload.toString()");
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.t.h(charsetForName, "forName(charsetName)");
        byte[] bytes = string.getBytes(charsetForName);
        kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
        HttpURLConnection httpURLConnectionA = ih0.f3062a.a(url);
        for (Map.Entry entry : map.entrySet()) {
            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        httpURLConnectionA.setConnectTimeout(f2409b);
        httpURLConnectionA.setReadTimeout(this.f2410a);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setInstanceFollowRedirects(false);
        httpURLConnectionA.setRequestMethod("POST");
        httpURLConnectionA.setDoOutput(true);
        httpURLConnectionA.setFixedLengthStreamingMode(bytes.length);
        OutputStream outputStream = httpURLConnectionA.getOutputStream();
        try {
            outputStream.write(bytes);
            v8.k0 k0Var = v8.k0.f35197a;
            f9.c.a(outputStream, null);
            return httpURLConnectionA;
        } finally {
        }
    }
}

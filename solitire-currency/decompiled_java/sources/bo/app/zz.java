package bo.app;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class zz {
    public static final FilterInputStream a(HttpURLConnection httpURLConnection) throws IOException, x40 {
        int i10 = b00.f2409b;
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode / 100 == 2) {
            return p9.q.x("gzip", httpURLConnection.getContentEncoding(), true) ? new GZIPInputStream(httpURLConnection.getInputStream()) : new BufferedInputStream(httpURLConnection.getInputStream());
        }
        throw new x40("Bad HTTP response code from Braze: [" + responseCode + "] to url: " + httpURLConnection.getURL());
    }
}

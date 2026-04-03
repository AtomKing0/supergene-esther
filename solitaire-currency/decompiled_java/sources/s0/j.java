package s0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import s0.d;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    static final b f33455g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y0.g f33456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f33458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f33459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f33460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f33461f;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // s0.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(y0.g gVar, int i10) {
        this(gVar, i10, f33455g);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f33460e = o1.c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f33460e = httpURLConnection.getInputStream();
        }
        return this.f33460e;
    }

    private static boolean f(int i10) {
        return i10 / 100 == 2;
    }

    private static boolean g(int i10) {
        return i10 / 100 == 3;
    }

    private InputStream h(URL url, int i10, URL url2, Map<String, String> map) throws IOException {
        if (i10 >= 5) {
            throw new r0.e("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new r0.e("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f33459d = this.f33458c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f33459d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f33459d.setConnectTimeout(this.f33457b);
        this.f33459d.setReadTimeout(this.f33457b);
        this.f33459d.setUseCaches(false);
        this.f33459d.setDoInput(true);
        this.f33459d.setInstanceFollowRedirects(false);
        this.f33459d.connect();
        this.f33460e = this.f33459d.getInputStream();
        if (this.f33461f) {
            return null;
        }
        int responseCode = this.f33459d.getResponseCode();
        if (f(responseCode)) {
            return c(this.f33459d);
        }
        if (!g(responseCode)) {
            if (responseCode == -1) {
                throw new r0.e(responseCode);
            }
            throw new r0.e(this.f33459d.getResponseMessage(), responseCode);
        }
        String headerField = this.f33459d.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new r0.e("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return h(url3, i10 + 1, url, map);
    }

    @Override // s0.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // s0.d
    public void b() {
        InputStream inputStream = this.f33460e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f33459d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f33459d = null;
    }

    @Override // s0.d
    public void cancel() {
        this.f33461f = true;
    }

    @Override // s0.d
    @NonNull
    public r0.a d() {
        return r0.a.REMOTE;
    }

    @Override // s0.d
    public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long jB = o1.f.b();
        try {
            try {
                aVar.f(h(this.f33456a.h(), 0, null, this.f33456a.e()));
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.c(e10);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(o1.f.a(jB));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + o1.f.a(jB));
            }
            throw th;
        }
    }

    @VisibleForTesting
    j(y0.g gVar, int i10, b bVar) {
        this.f33456a = gVar;
        this.f33457b = i10;
        this.f33458c = bVar;
    }
}

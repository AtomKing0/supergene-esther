package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.autofill.HintConstants;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.datatransport.cct.d;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.nb;
import io.sentry.protocol.Device;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import x1.j;
import x1.k;
import x1.l;
import x1.m;
import x1.n;
import x1.o;
import x1.p;
import y1.h;
import y1.i;
import z1.f;
import z1.g;
import z1.m;

/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p5.a f8423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f8424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final URL f8426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i2.a f8427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i2.a f8428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8429g;

    /* JADX INFO: compiled from: CctTransportBackend.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final URL f8430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j f8431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        final String f8432c;

        a(URL url, j jVar, @Nullable String str) {
            this.f8430a = url;
            this.f8431b = jVar;
            this.f8432c = str;
        }

        a a(URL url) {
            return new a(url, this.f8431b, this.f8432c);
        }
    }

    /* JADX INFO: compiled from: CctTransportBackend.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        final URL f8434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f8435c;

        b(int i10, @Nullable URL url, long j10) {
            this.f8433a = i10;
            this.f8434b = url;
            this.f8435c = j10;
        }
    }

    d(Context context, i2.a aVar, i2.a aVar2, int i10) {
        this.f8423a = j.b();
        this.f8425c = context;
        this.f8424b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f8426d = n(com.google.android.datatransport.cct.a.f8414c);
        this.f8427e = aVar2;
        this.f8428f = aVar;
        this.f8429g = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e(a aVar) throws IOException {
        c2.a.f("CctTransportBackend", "Making request to: %s", aVar.f8430a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f8430a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f8429g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.8"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(nb.K, nb.L);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f8432c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f8423a.a(aVar.f8431b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    c2.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    c2.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(nb.K));
                    c2.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (ConnectException e10) {
            e = e10;
            c2.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            c2.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            c2.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (p5.b e13) {
            e = e13;
            c2.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return o.b.UNKNOWN_MOBILE_SUBTYPE.c();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return o.b.COMBINED.c();
        }
        if (o.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int g(NetworkInfo networkInfo) {
        return networkInfo == null ? o.c.NONE.c() : networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            c2.a.d("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    private j i(f fVar) {
        l.a aVarJ;
        HashMap map = new HashMap();
        for (i iVar : fVar.b()) {
            String strJ = iVar.j();
            if (map.containsKey(strJ)) {
                ((List) map.get(strJ)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(strJ, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            m.a aVarB = x1.m.a().f(p.DEFAULT).g(this.f8428f.a()).h(this.f8427e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(x1.a.a().m(Integer.valueOf(iVar2.g("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b(AppLovinEventTypes.USER_VIEWED_PRODUCT)).k(iVar2.b("os-uild")).h(iVar2.b(Device.JsonKeys.MANUFACTURER)).e(iVar2.b("fingerprint")).c(iVar2.b(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY)).g(iVar2.b(Device.JsonKeys.LOCALE)).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                w1.c cVarB = hVarE.b();
                if (cVarB.equals(w1.c.b("proto"))) {
                    aVarJ = l.j(hVarE.a());
                } else if (cVarB.equals(w1.c.b("json"))) {
                    aVarJ = l.i(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    c2.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", cVarB);
                }
                aVarJ.c(iVar3.f()).d(iVar3.k()).h(iVar3.h("tz-offset")).e(o.a().c(o.c.a(iVar3.g("net-type"))).b(o.b.a(iVar3.g("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVarJ.b(iVar3.d());
                }
                arrayList3.add(aVarJ.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return j.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    @VisibleForTesting
    static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.f8434b;
        if (url == null) {
            return null;
        }
        c2.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f8434b);
    }

    private static InputStream m(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    @Override // z1.m
    public i a(i iVar) {
        NetworkInfo activeNetworkInfo = this.f8424b.getActiveNetworkInfo();
        return iVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT).c("os-uild", Build.ID).c(Device.JsonKeys.MANUFACTURER, Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, Locale.getDefault().getCountry()).c(Device.JsonKeys.LOCALE, Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f8425c).getSimOperator()).c("application_build", Integer.toString(h(this.f8425c))).d();
    }

    @Override // z1.m
    public g b(f fVar) {
        j jVarI = i(fVar);
        URL urlN = this.f8426d;
        if (fVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a aVarC = com.google.android.datatransport.cct.a.c(fVar.c());
                strD = aVarC.d() != null ? aVarC.d() : null;
                if (aVarC.e() != null) {
                    urlN = n(aVarC.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) d2.b.a(5, new a(urlN, jVarI, strD), new d2.a() { // from class: com.google.android.datatransport.cct.b
                @Override // d2.a
                public final Object apply(Object obj) {
                    return this.f8422a.e((d.a) obj);
                }
            }, new d2.c() { // from class: com.google.android.datatransport.cct.c
                @Override // d2.c
                public final Object a(Object obj, Object obj2) {
                    return d.l((d.a) obj, (d.b) obj2);
                }
            });
            int i10 = bVar.f8433a;
            if (i10 == 200) {
                return g.e(bVar.f8435c);
            }
            if (i10 < 500 && i10 != 404) {
                return i10 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e10) {
            c2.a.d("CctTransportBackend", "Could not make request to the backend", e10);
            return g.f();
        }
    }

    d(Context context, i2.a aVar, i2.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}

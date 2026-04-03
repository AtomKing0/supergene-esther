package com.ironsource;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes4.dex */
public class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12120a = "POST";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12121b = "GET";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12122c = "ISHttpService";

    public static class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f12123h = 15000;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f12124i = 15000;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f12125j = "UTF-8";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f12126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f12127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f12128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f12129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f12130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f12131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ArrayList<Pair<String, String>> f12132g;

        /* JADX INFO: renamed from: com.ironsource.ff$a$a, reason: collision with other inner class name */
        static class C0256a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f12134b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            String f12136d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            List<Pair<String, String>> f12133a = new ArrayList();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            String f12135c = "POST";

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f12137e = 15000;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f12138f = 15000;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            String f12139g = a.f12125j;

            C0256a() {
            }

            C0256a a(int i10) {
                this.f12137e = i10;
                return this;
            }

            C0256a b(int i10) {
                this.f12138f = i10;
                return this;
            }

            C0256a c(String str) {
                this.f12134b = str;
                return this;
            }

            C0256a d(String str) {
                this.f12135c = str;
                return this;
            }

            C0256a a(Pair<String, String> pair) {
                this.f12133a.add(pair);
                return this;
            }

            C0256a b(String str) {
                this.f12139g = str;
                return this;
            }

            C0256a a(String str) {
                this.f12136d = str;
                return this;
            }

            C0256a a(List<Pair<String, String>> list) {
                this.f12133a.addAll(list);
                return this;
            }

            a a() {
                return new a(this);
            }
        }

        public a(C0256a c0256a) {
            this.f12126a = c0256a.f12134b;
            this.f12127b = c0256a.f12135c;
            this.f12128c = c0256a.f12136d;
            this.f12132g = new ArrayList<>(c0256a.f12133a);
            this.f12129d = c0256a.f12137e;
            this.f12130e = c0256a.f12138f;
            this.f12131f = c0256a.f12139g;
        }

        boolean a() {
            return "POST".equals(this.f12127b);
        }
    }

    public static vo a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri uriBuild = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0256a c0256a = new a.C0256a();
        c0256a.c(uriBuild.toString()).a(str2).d("GET").a(list);
        return b(c0256a.a());
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a0: MOVE (r8 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x00a0 */
    public static vo b(a aVar) throws Exception {
        HttpURLConnection httpURLConnectionA;
        InputStream inputStream;
        InputStream inputStream2;
        if (!a(aVar.f12126a, aVar.f12128c)) {
            throw new InvalidParameterException("not valid params");
        }
        vo voVar = new vo();
        InputStream inputStream3 = null;
        inputStream3 = null;
        inputStream3 = null;
        inputStream3 = null;
        inputStream3 = null;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnectionA = a(aVar);
            } catch (Throwable th) {
                th = th;
                httpURLConnectionA = null;
                inputStream3 = inputStream2;
            }
            try {
                a(httpURLConnectionA, aVar.f12132g);
                a(httpURLConnectionA, aVar);
                inputStream3 = httpURLConnectionA.getInputStream();
                voVar.f15931a = httpURLConnectionA.getResponseCode();
                if (inputStream3 != null) {
                    voVar.f15932b = xt.a(inputStream3);
                }
            } catch (InterruptedIOException e10) {
                e = e10;
                Log.d(f12122c, "Failed post to " + aVar.f12126a + " exception: " + e.getMessage());
                throw e;
            } catch (SSLException e11) {
                e = e11;
                Log.d(f12122c, "Failed post to " + aVar.f12126a + " exception: " + e.getMessage());
                throw e;
            } catch (IOException e12) {
                e = e12;
                inputStream = inputStream3;
                httpURLConnection = httpURLConnectionA;
                i9.d().a(e);
                if (httpURLConnection != null && httpURLConnection.getHeaderFields().isEmpty()) {
                    throw new ym(e);
                }
                if (httpURLConnection != null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    voVar.f15931a = responseCode;
                    if (responseCode >= 400) {
                        Log.d(f12122c, "Failed post to " + aVar.f12126a + " StatusCode: " + voVar.f15931a);
                        if (inputStream != null) {
                            InputStream inputStream4 = inputStream;
                            httpURLConnectionA = httpURLConnection;
                            inputStream3 = inputStream4;
                            inputStream3.close();
                        } else {
                            httpURLConnectionA = httpURLConnection;
                        }
                    }
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                throw th;
            }
        } catch (InterruptedIOException e13) {
            e = e13;
            Log.d(f12122c, "Failed post to " + aVar.f12126a + " exception: " + e.getMessage());
            throw e;
        } catch (SSLException e14) {
            e = e14;
            Log.d(f12122c, "Failed post to " + aVar.f12126a + " exception: " + e.getMessage());
            throw e;
        } catch (IOException e15) {
            e = e15;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionA = null;
        }
        if (inputStream3 != null) {
            inputStream3.close();
        }
        httpURLConnectionA.disconnect();
        return voVar;
    }

    private static HttpURLConnection a(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.f12126a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.f12129d);
        httpURLConnection.setReadTimeout(aVar.f12130e);
        httpURLConnection.setRequestMethod(aVar.f12127b);
        return httpURLConnection;
    }

    public static vo b(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0256a c0256a = new a.C0256a();
        c0256a.c(str).a(str2).d("POST").a(list);
        return b(c0256a.a());
    }

    private static void a(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        if (aVar.a()) {
            byte[] bytes = aVar.f12128c.getBytes(aVar.f12131f);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
            a(httpURLConnection, bytes);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) ? false : true;
    }
}

package com.ironsource.mediationsdk.server;

import android.text.TextUtils;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import com.ironsource.nb;
import com.ironsource.pd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13893a = 15000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13894b = "GET";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13895c = "POST";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13896d = "UTF-8";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13897e = "Bad Request - 400";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ExecutorService f13898f = Executors.newSingleThreadExecutor();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ pd f13901c;

        a(String str, String str2, pd pdVar) {
            this.f13899a = str;
            this.f13900b = str2;
            this.f13901c = pdVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnectionB;
            OutputStream outputStream;
            try {
                httpURLConnectionB = HttpFunctions.b(this.f13899a);
                try {
                    outputStream = httpURLConnectionB.getOutputStream();
                    try {
                        try {
                            HttpFunctions.b(this.f13900b, outputStream);
                            int responseCode = httpURLConnectionB.getResponseCode();
                            boolean z10 = responseCode == 200;
                            if (!z10) {
                                IronLog.INTERNAL.error("invalid response code " + responseCode + " sending request");
                            }
                            this.f13901c.a(z10);
                        } catch (Exception e10) {
                            e = e10;
                            i9.d().a(e);
                            IronLog.INTERNAL.error("exception while sending request " + e.getMessage());
                            this.f13901c.a(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        HttpFunctions.b(outputStream, httpURLConnectionB, null);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    outputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    HttpFunctions.b(outputStream, httpURLConnectionB, null);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                httpURLConnectionB = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnectionB = null;
                outputStream = null;
            }
            HttpFunctions.b(outputStream, httpURLConnectionB, null);
        }
    }

    @Nullable
    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection b(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(f13893a);
        httpURLConnection.setConnectTimeout(f13893a);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public static String getStringFromURL(String str) throws Exception {
        return getStringFromURL(str, null);
    }

    @Nullable
    public static String sendPostRequest(String str, String str2, p.c cVar) {
        BufferedReader bufferedReader;
        OutputStream outputStream;
        HttpURLConnection httpURLConnectionB;
        Exception e10;
        BufferedReader bufferedReader2;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnectionB = b(str);
            try {
                httpURLConnectionB.setRequestProperty(nb.K, "application/json; charset=utf-8");
                outputStream = httpURLConnectionB.getOutputStream();
            } catch (Exception e11) {
                e = e11;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                httpURLConnection = httpURLConnectionB;
                bufferedReader = null;
            }
            try {
                b(str2, outputStream);
                int responseCode = httpURLConnectionB.getResponseCode();
                if (!(responseCode == 200)) {
                    if (responseCode == 400 && cVar != null) {
                        cVar.a(f13897e);
                    }
                    b(outputStream, httpURLConnectionB, null);
                    return null;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnectionB.getInputStream()));
                try {
                    String strA = a(bufferedReader2);
                    b(outputStream, httpURLConnectionB, bufferedReader2);
                    return strA;
                } catch (Exception e12) {
                    e10 = e12;
                    try {
                        i9.d().a(e10);
                        IronLog.INTERNAL.error("exception while sending request " + e10.getMessage());
                        b(outputStream, httpURLConnectionB, bufferedReader2);
                        return null;
                    } catch (Throwable th3) {
                        httpURLConnection = httpURLConnectionB;
                        bufferedReader = bufferedReader2;
                        th = th3;
                        th = th;
                        bufferedReader2 = bufferedReader;
                        httpURLConnectionB = httpURLConnection;
                        b(outputStream, httpURLConnectionB, bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    b(outputStream, httpURLConnectionB, bufferedReader2);
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
                e10 = e;
                bufferedReader2 = null;
                i9.d().a(e10);
                IronLog.INTERNAL.error("exception while sending request " + e10.getMessage());
                b(outputStream, httpURLConnectionB, bufferedReader2);
                return null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnectionB;
                bufferedReader = null;
                th = th;
                bufferedReader2 = bufferedReader;
                httpURLConnectionB = httpURLConnection;
                b(outputStream, httpURLConnectionB, bufferedReader2);
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            httpURLConnectionB = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            outputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(OutputStream outputStream, HttpURLConnection httpURLConnection, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("exception while closing output stream " + e10.getMessage());
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e11) {
                i9.d().a(e11);
                IronLog.INTERNAL.error("exception while closing reader " + e11.getMessage());
            }
        }
    }

    public static String getStringFromURL(String str, p.c cVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        Exception e10;
        BufferedReader bufferedReader2;
        Throwable th;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(f13893a);
                httpURLConnection.setConnectTimeout(f13893a);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 400) {
                    if (cVar != null) {
                        cVar.a(f13897e);
                    }
                    b(null, httpURLConnection, null);
                    return null;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    String strA = a(bufferedReader2);
                    b(null, httpURLConnection, bufferedReader2);
                    return strA;
                } catch (Exception e11) {
                    e10 = e11;
                    try {
                        i9.d().a(e10);
                        b(null, httpURLConnection, bufferedReader2);
                        return null;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        BufferedReader bufferedReader3 = bufferedReader;
                        th = th;
                        bufferedReader2 = bufferedReader3;
                        b(null, httpURLConnection, bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    b(null, httpURLConnection, bufferedReader2);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                e10 = e;
                bufferedReader2 = null;
                i9.d().a(e10);
                b(null, httpURLConnection, bufferedReader2);
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                BufferedReader bufferedReader32 = bufferedReader;
                th = th;
                bufferedReader2 = bufferedReader32;
                b(null, httpURLConnection, bufferedReader2);
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public static void sendPostRequest(String str, String str2, pd pdVar) {
        f13898f.submit(new a(str, str2, pdVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, f13896d));
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

package com.king.http;

import androidx.annotation.Keep;
import com.king.http.HttpHeaders;
import com.king.usdk.logger.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class HttpTask implements Runnable {
    private static final int CONTENT_LENGTH_MISSING = -1;
    private static final int ERROR_CODE_MISSING = -1;
    public static final int HTTP_CONNECTION_CLOSED = 1;
    public static final int HTTP_CONNECTION_OPEN = 0;
    private static final int HTTP_ERROR_TYPE_DNS = 0;
    private static final int HTTP_ERROR_TYPE_HTTP = 2;
    private static final int HTTP_ERROR_TYPE_JSONRPC = 3;
    private static final int HTTP_ERROR_TYPE_SSL = 1;
    private static final int HTTP_ERROR_TYPE_UNKOWN = 4;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 0;
    public static final int HTTP_METHOD_POST = 2;
    public static final int HTTP_METHOD_PUT = 3;
    public static final int HTTP_RESULT_CORRUPT = 2;
    public static final int HTTP_RESULT_ERROR = 1;
    public static final int HTTP_RESULT_SUCCESS = 0;
    public static final int HTTP_RESULT_TIMEOUT = 3;
    private static final int READ_BUFFER_SIZE = 4096;
    private final String mClassName = "[com.king.http.HttpTask] ";
    private final byte[] mData;
    private final HttpHeaders mHeaders;
    private final Listener mListener;
    private final Logger mLogger;
    private final int mMethod;
    private final boolean mRedirect;
    private final long mRequestId;
    private final int mTimeoutMillis;
    private final URL mURL;

    @Keep
    public interface Listener {
        void onData(long j10, byte[] bArr, int i10);

        void onResponse(long j10, int i10, int i11, int i12, HttpHeaders.Header[] headerArr, int i13, String str, int i14, int i15);
    }

    HttpTask(Logger logger, long j10, Listener listener, int i10, String str, int i11, boolean z10, HttpHeaders httpHeaders, byte[] bArr) throws MalformedURLException {
        this.mLogger = logger;
        this.mRequestId = j10;
        this.mListener = listener;
        this.mMethod = i10;
        this.mURL = new URL(str);
        this.mTimeoutMillis = i11;
        this.mRedirect = z10;
        this.mHeaders = httpHeaders;
        this.mData = bArr;
        logger.i("[com.king.http.HttpTask] Creating task with mRequestId: " + j10);
    }

    private HttpURLConnection openConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.mURL.openConnection();
        int i10 = this.mTimeoutMillis;
        if (i10 > 0) {
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(this.mTimeoutMillis);
        } else {
            httpURLConnection.setConnectTimeout(0);
            httpURLConnection.setReadTimeout(0);
        }
        return httpURLConnection;
    }

    private HttpHeaders.Header[] parseHeaders(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                httpHeaders.add(entry.getKey(), it.next());
            }
        }
        return httpHeaders.array();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r5.mLogger.d("[com.king.http.HttpTask] readData interrupted");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readData(java.net.HttpURLConnection r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            int r2 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L51
            r3 = 400(0x190, float:5.6E-43)
            if (r2 >= r3) goto L12
            java.io.InputStream r6 = r6.getInputStream()     // Catch: java.lang.Throwable -> L51
            goto L16
        L12:
            java.io.InputStream r6 = r6.getErrorStream()     // Catch: java.lang.Throwable -> L51
        L16:
            r1 = r6
            if (r1 != 0) goto L1f
            if (r1 == 0) goto L1e
            r1.close()
        L1e:
            return
        L1f:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L51
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L51
            int r1 = r6.read(r0)     // Catch: java.lang.Throwable -> L4d
        L28:
            r2 = -1
            if (r1 == r2) goto L49
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L4d
            boolean r2 = r2.isInterrupted()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L3d
            com.king.usdk.logger.Logger r0 = r5.mLogger     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "[com.king.http.HttpTask] readData interrupted"
            r0.d(r1)     // Catch: java.lang.Throwable -> L4d
            goto L49
        L3d:
            com.king.http.HttpTask$Listener r2 = r5.mListener     // Catch: java.lang.Throwable -> L4d
            long r3 = r5.mRequestId     // Catch: java.lang.Throwable -> L4d
            r2.onData(r3, r0, r1)     // Catch: java.lang.Throwable -> L4d
            int r1 = r6.read(r0)     // Catch: java.lang.Throwable -> L4d
            goto L28
        L49:
            r6.close()
            return
        L4d:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto L52
        L51:
            r6 = move-exception
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.http.HttpTask.readData(java.net.HttpURLConnection):void");
    }

    private void writeData(URLConnection uRLConnection) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        outputStream.write(this.mData);
        outputStream.flush();
        outputStream.close();
    }

    public long getRequestId() {
        return this.mRequestId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v15, types: [com.king.http.HttpTask$Listener] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.king.http.HttpTask$Listener] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4, types: [com.king.http.HttpHeaders$Header[]] */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v20, types: [com.king.http.HttpHeaders$Header[]] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        IOException iOException;
        ?? r02;
        UnknownHostException unknownHostException;
        ?? r03;
        int responseCode;
        SocketTimeoutException socketTimeoutException;
        ?? r04;
        ?? r17;
        String str;
        int i10;
        int i11;
        String str2;
        int i12;
        int i13;
        ?? r22 = 3;
        r22 = 3;
        ?? headers = 0;
        headers = 0;
        headers = 0;
        headers = 0;
        headers = 0;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = null;
        headers = 0;
        ?? r52 = 1;
        r52 = 1;
        r52 = 1;
        int i14 = 0;
        int contentLength = -1;
        ?? r82 = 4;
        r82 = 4;
        r82 = 4;
        r82 = 4;
        r82 = 4;
        r82 = 4;
        r82 = 4;
        try {
            try {
                try {
                    this.mLogger.i("[com.king.http.HttpTask] Connect to: " + this.mURL.toString());
                    HttpURLConnection httpURLConnectionOpenConnection = openConnection();
                    try {
                        this.mLogger.i("[com.king.http.HttpTask] Connection opened");
                        if (this.mHeaders != null) {
                            this.mLogger.d("[com.king.http.HttpTask] Set headers");
                            for (HttpHeaders.Header header : this.mHeaders.array()) {
                                httpURLConnectionOpenConnection.addRequestProperty(header.key, header.value);
                            }
                        }
                        int i15 = this.mMethod;
                        if (i15 == 0) {
                            httpURLConnectionOpenConnection.setRequestMethod("HEAD");
                        } else if (i15 == 1) {
                            httpURLConnectionOpenConnection.setRequestMethod("GET");
                        } else if (i15 == 2) {
                            httpURLConnectionOpenConnection.setDoOutput(true);
                            httpURLConnectionOpenConnection.setRequestMethod("POST");
                            byte[] bArr = this.mData;
                            httpURLConnectionOpenConnection.setFixedLengthStreamingMode(bArr != null ? bArr.length : 0);
                        } else if (i15 == 3) {
                            httpURLConnectionOpenConnection.setDoOutput(true);
                            httpURLConnectionOpenConnection.setRequestMethod("PUT");
                            byte[] bArr2 = this.mData;
                            httpURLConnectionOpenConnection.setFixedLengthStreamingMode(bArr2 != null ? bArr2.length : 0);
                        }
                        httpURLConnectionOpenConnection.setInstanceFollowRedirects(this.mRedirect);
                        this.mLogger.d("[com.king.http.HttpTask] Connecting method: " + this.mMethod);
                        httpURLConnectionOpenConnection.connect();
                        int i16 = this.mMethod;
                        if ((i16 == 2 || i16 == 3) && this.mData != null) {
                            this.mLogger.d("[com.king.http.HttpTask] Write data to socket");
                            writeData(httpURLConnectionOpenConnection);
                        }
                        this.mLogger.d("[com.king.http.HttpTask] Retrieve connection results");
                        responseCode = httpURLConnectionOpenConnection.getResponseCode();
                        if (responseCode == -1) {
                            str2 = "Result corrupt";
                            i12 = 2;
                        } else {
                            str2 = null;
                            i12 = 0;
                        }
                        try {
                            headers = parseHeaders(httpURLConnectionOpenConnection.getHeaderFields());
                            contentLength = httpURLConnectionOpenConnection.getContentLength();
                            if (i12 == 0) {
                                try {
                                    this.mLogger.d("[com.king.http.HttpTask] Invoke response (open) result: " + i12 + ", status: " + responseCode + ", content-length: " + contentLength);
                                    i13 = i12;
                                    try {
                                        this.mListener.onResponse(this.mRequestId, 0, i12, responseCode, headers, contentLength, null, -1, 4);
                                        this.mLogger.i("[com.king.http.HttpTask] Read data from socket");
                                        readData(httpURLConnectionOpenConnection);
                                    } catch (SocketTimeoutException e10) {
                                        e = e10;
                                        i14 = responseCode;
                                        socketTimeoutException = e;
                                        r04 = headers;
                                        httpURLConnection = httpURLConnectionOpenConnection;
                                        this.mLogger.w("[com.king.http.HttpTask] " + socketTimeoutException.toString());
                                        String string = socketTimeoutException.toString();
                                        Logger logger = this.mLogger;
                                        logger.d("[com.king.http.HttpTask] Disconnect result: 3 - Error type: 2");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        r17 = r04;
                                        i10 = 3;
                                        i11 = 2;
                                        str = string;
                                        headers = httpURLConnection;
                                        r52 = string;
                                        r82 = logger;
                                    } catch (UnknownHostException e11) {
                                        e = e11;
                                        unknownHostException = e;
                                        r03 = headers;
                                        httpURLConnection2 = httpURLConnectionOpenConnection;
                                        this.mLogger.w("[com.king.http.HttpTask] " + unknownHostException.toString());
                                        String string2 = unknownHostException.toString();
                                        String str3 = "[com.king.http.HttpTask] Disconnect result: 1 - Error type: 0";
                                        this.mLogger.d(str3);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        r17 = r03;
                                        str = string2;
                                        i10 = 1;
                                        i11 = 0;
                                        i14 = responseCode;
                                        r22 = string2;
                                        headers = httpURLConnection2;
                                        r82 = str3;
                                    } catch (IOException e12) {
                                        e = e12;
                                        iOException = e;
                                        r02 = headers;
                                        httpURLConnection3 = httpURLConnectionOpenConnection;
                                        i14 = responseCode;
                                        this.mLogger.w("[com.king.http.HttpTask] " + iOException.toString());
                                        String string3 = iOException.toString();
                                        this.mLogger.d("[com.king.http.HttpTask] Disconnect result: 1 - Error type: 4");
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        r17 = r02;
                                        str = string3;
                                        i10 = 1;
                                        i11 = 4;
                                        r22 = string3;
                                        headers = httpURLConnection3;
                                    } catch (Throwable th) {
                                        th = th;
                                        headers = httpURLConnectionOpenConnection;
                                        r22 = i13;
                                        this.mLogger.d("[com.king.http.HttpTask] Disconnect result: " + r22 + " - Error type: " + r82);
                                        if (headers != 0) {
                                            headers.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e13) {
                                    e = e13;
                                    i13 = i12;
                                } catch (UnknownHostException e14) {
                                    e = e14;
                                    i13 = i12;
                                } catch (IOException e15) {
                                    e = e15;
                                    i13 = i12;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i13 = i12;
                                }
                            } else {
                                i13 = i12;
                            }
                            Logger logger2 = this.mLogger;
                            StringBuilder sb = new StringBuilder();
                            sb.append("[com.king.http.HttpTask] Disconnect result: ");
                            int i17 = i13;
                            sb.append(i17);
                            r52 = " - Error type: ";
                            sb.append(" - Error type: ");
                            sb.append(4);
                            logger2.d(sb.toString());
                            httpURLConnectionOpenConnection.disconnect();
                            str = str2;
                            r17 = headers;
                            i11 = 4;
                            i14 = responseCode;
                            i10 = i17;
                        } catch (SocketTimeoutException e16) {
                            e = e16;
                            i14 = responseCode;
                        } catch (UnknownHostException e17) {
                            unknownHostException = e17;
                            r03 = headers;
                            httpURLConnection2 = httpURLConnectionOpenConnection;
                        } catch (IOException e18) {
                            iOException = e18;
                            r02 = headers;
                            httpURLConnection3 = httpURLConnectionOpenConnection;
                            i14 = responseCode;
                        } catch (Throwable th3) {
                            th = th3;
                            headers = httpURLConnectionOpenConnection;
                            r22 = i12;
                        }
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                    } catch (UnknownHostException e20) {
                        unknownHostException = e20;
                        r03 = 0;
                        responseCode = 0;
                        httpURLConnection2 = httpURLConnectionOpenConnection;
                    } catch (IOException e21) {
                        iOException = e21;
                        r02 = 0;
                        httpURLConnection3 = httpURLConnectionOpenConnection;
                    } catch (Throwable th4) {
                        th = th4;
                        r22 = 1;
                        headers = httpURLConnectionOpenConnection;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r22 = r52;
                }
            } catch (SocketTimeoutException e22) {
                socketTimeoutException = e22;
                r04 = 0;
            } catch (UnknownHostException e23) {
                unknownHostException = e23;
                r03 = 0;
                responseCode = 0;
            } catch (IOException e24) {
                iOException = e24;
                r02 = 0;
            }
            this.mLogger.d("[com.king.http.HttpTask] Invoke response (closed) result: " + i10 + ", status: " + i14 + ", content-length: " + contentLength);
            this.mListener.onResponse(this.mRequestId, 1, i10, i14, r17, contentLength, str, -1, i11);
        } catch (Throwable th6) {
            th = th6;
        }
    }
}

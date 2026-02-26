package com.king.amp.sa;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: Http.java */
/* JADX INFO: loaded from: classes4.dex */
class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    z0 f16718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f16719d;

    public a1(String str, String str2, z0 z0Var, int i10) {
        this.f16716a = str;
        this.f16717b = str2;
        this.f16718c = z0Var;
        if (i10 > 0) {
            this.f16719d = i10;
        } else {
            this.f16719d = 16000;
        }
    }

    private void a(Exception exc) {
        Log.w("HttpGetRunnable", "GET failed: ", exc);
        z0 z0Var = this.f16718c;
        if (z0Var == null) {
            Log.w("HttpGetRunnable", "Unable to handle exception, handler is null");
            return;
        }
        if (exc instanceof MalformedURLException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_FLOAT, new byte[0]);
            return;
        }
        if (exc instanceof ProtocolException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_COLOR, new byte[0]);
            return;
        }
        if (exc instanceof FileNotFoundException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_STRING, new byte[0]);
            return;
        }
        if (exc instanceof SocketTimeoutException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_DIMENSION, new byte[0]);
            return;
        }
        if (exc instanceof SocketException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_BOOLEAN, new byte[0]);
        } else if (exc instanceof IOException) {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_BOOLEAN, new byte[0]);
        } else {
            z0Var.onGetRequestCompleted(this.f16716a, TypedValues.Custom.TYPE_INT, new byte[0]);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|59|(5:53|3|55|4|(2:69|7))|(7:9|10|64|11|(4:12|(1:14)(1:72)|52|38)|15|16)|62|19|(3:21|52|38)(1:73)|(3:(0)|(1:66)|(1:71))) */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.lang.String r2 = r7.f16717b     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            r2 = 1
            r1.setDoInput(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            int r2 = r7.f16719d     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            r1.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            int r2 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L75
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L75
            r3.<init>(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L75
            goto L33
        L2a:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L75
            java.io.InputStream r1 = r1.getErrorStream()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L75
            r3.<init>(r1)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L75
        L33:
            com.king.amp.sa.z0 r1 = r7.f16718c     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            if (r1 == 0) goto L5b
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r1.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
        L40:
            int r4 = r3.read(r0)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            r5 = -1
            if (r4 == r5) goto L4c
            r5 = 0
            r1.write(r0, r5, r4)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            goto L40
        L4c:
            com.king.amp.sa.z0 r0 = r7.f16718c     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            java.lang.String r4 = r7.f16716a     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            byte[] r5 = r1.toByteArray()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            r0.onGetRequestCompleted(r4, r2, r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L8b
            r0 = r1
            goto L5b
        L59:
            r0 = move-exception
            goto L7d
        L5b:
            r3.close()     // Catch: java.lang.Exception -> L5e
        L5e:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L8a
            goto L8a
        L64:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L8d
        L68:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L7d
        L6d:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            java.lang.String r2 = "Failed to get either inputStream or errorStream"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
            throw r1     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L79
        L75:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L8e
        L79:
            r1 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
        L7d:
            r7.a(r0)     // Catch: java.lang.Throwable -> L8b
            if (r3 == 0) goto L85
            r3.close()     // Catch: java.lang.Exception -> L85
        L85:
            if (r1 == 0) goto L8a
            r1.close()     // Catch: java.lang.Exception -> L8a
        L8a:
            return
        L8b:
            r0 = move-exception
            r2 = r0
        L8d:
            r0 = r3
        L8e:
            if (r0 == 0) goto L93
            r0.close()     // Catch: java.lang.Exception -> L93
        L93:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Exception -> L98
        L98:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.a1.run():void");
    }
}

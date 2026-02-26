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
class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f16738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f16739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    b1 f16740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f16741f;

    public c1(String str, String str2, String str3, String str4, b1 b1Var, int i10) {
        this.f16736a = str;
        this.f16737b = str2;
        this.f16738c = str3;
        this.f16739d = str4;
        this.f16740e = b1Var;
        this.f16741f = i10 <= 0 ? 16000 : i10;
    }

    private void a(Exception exc) {
        Log.w("HttpRunnable", "POST failed: ", exc);
        b1 b1Var = this.f16740e;
        if (b1Var == null) {
            Log.w("HttpRunnable", "Unable to handle exception, handler is null");
            return;
        }
        if (exc instanceof MalformedURLException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_FLOAT, exc.getMessage());
            return;
        }
        if (exc instanceof ProtocolException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_COLOR, exc.getMessage());
            return;
        }
        if (exc instanceof FileNotFoundException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_STRING, exc.getMessage());
            return;
        }
        if (exc instanceof SocketTimeoutException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_DIMENSION, exc.getMessage());
            return;
        }
        if (exc instanceof SocketException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_BOOLEAN, exc.getMessage());
        } else if (exc instanceof IOException) {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_BOOLEAN, exc.getMessage());
        } else {
            b1Var.onPostRequestCompleted(this.f16736a, TypedValues.Custom.TYPE_INT, exc.getMessage());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(8:85|3|(3:5|80|6)(1:7)|8|75|9|95|12)|(6:14|98|15|(4:16|(1:18)(1:100)|84|54)|19|20)|(2:82|26)|91|27|(3:29|84|54)(1:101)|(3:(0)|(1:79)|(1:81))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db A[Catch: Exception -> 0x00de, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x00de, blocks: (B:53:0x00db, B:29:0x00a3), top: B:85:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedReader] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.c1.run():void");
    }
}

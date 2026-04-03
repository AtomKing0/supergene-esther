package w7;

import io.ktor.utils.io.g;
import io.ktor.utils.io.jvm.javaio.h;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import y7.y;
import y7.z;

/* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
    @f(c = "io.ktor.client.engine.android.AndroidURLConnectionUtilsKt", f = "AndroidURLConnectionUtils.kt", l = {60}, m = "timeoutAwareConnection")
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f35462j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f35463k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f35464l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f35465m;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f35464l = obj;
            this.f35465m |= Integer.MIN_VALUE;
            return e.e(null, null, null, this);
        }
    }

    @NotNull
    public static final g a(@NotNull HttpURLConnection httpURLConnection, @NotNull z8.g callContext, @NotNull a8.d request) {
        g gVarA;
        g gVarA2;
        t.i(httpURLConnection, "<this>");
        t.i(callContext, "callContext");
        t.i(request, "request");
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedInputStream = inputStream != null ? inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8192) : null;
        } catch (IOException unused) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                bufferedInputStream = errorStream instanceof BufferedInputStream ? (BufferedInputStream) errorStream : new BufferedInputStream(errorStream, 8192);
            }
        }
        return (bufferedInputStream == null || (gVarA = h.a(bufferedInputStream, callContext, h8.a.a())) == null || (gVarA2 = x7.c.a(p0.a(callContext), gVarA, request)) == null) ? g.f26800a.a() : gVarA2;
    }

    private static final boolean b(Throwable th) {
        if (!(th instanceof SocketTimeoutException)) {
            if (!(th instanceof ConnectException)) {
                return false;
            }
            String message = th.getMessage();
            if (!(message != null ? r.P(message, "timed out", false, 2, null) : false)) {
                return false;
            }
        }
        return true;
    }

    private static final void c(HttpURLConnection httpURLConnection, y.a aVar) {
        Long lD = aVar.d();
        if (lD != null) {
            long jLongValue = lD.longValue();
            if (jLongValue != Long.MAX_VALUE) {
                if (httpURLConnection.getConnectTimeout() == 0 || httpURLConnection.getConnectTimeout() > jLongValue) {
                    httpURLConnection.setConnectTimeout(z.d(jLongValue));
                }
            }
        }
    }

    public static final void d(@NotNull HttpURLConnection httpURLConnection, @NotNull a8.d requestData) {
        t.i(httpURLConnection, "<this>");
        t.i(requestData, "requestData");
        y.a aVar = (y.a) requestData.c(y.f36881d);
        if (aVar != null) {
            Long lC = aVar.c();
            if (lC != null) {
                httpURLConnection.setConnectTimeout(z.d(lC.longValue()));
            }
            Long lE = aVar.e();
            if (lE != null) {
                httpURLConnection.setReadTimeout(z.d(lE.longValue()));
            }
            c(httpURLConnection, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object e(@org.jetbrains.annotations.NotNull java.net.HttpURLConnection r4, @org.jetbrains.annotations.NotNull a8.d r5, @org.jetbrains.annotations.NotNull h9.l<? super java.net.HttpURLConnection, ? extends T> r6, @org.jetbrains.annotations.NotNull z8.d<? super T> r7) {
        /*
            boolean r0 = r7 instanceof w7.e.a
            if (r0 == 0) goto L13
            r0 = r7
            w7.e$a r0 = (w7.e.a) r0
            int r1 = r0.f35465m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35465m = r1
            goto L18
        L13:
            w7.e$a r0 = new w7.e$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35464l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f35465m
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f35463k
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r5 = r0.f35462j
            a8.d r5 = (a8.d) r5
            v8.u.b(r7)
            goto L4f
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            v8.u.b(r7)
            java.lang.Object r4 = r6.invoke(r4)     // Catch: java.lang.Throwable -> L41
            return r4
        L41:
            r4 = move-exception
            r0.f35462j = r5
            r0.f35463k = r4
            r0.f35465m = r3
            java.lang.Object r6 = kotlinx.coroutines.l3.a(r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            boolean r6 = b(r4)
            if (r6 == 0) goto L59
            x7.a r4 = y7.z.a(r5, r4)
        L59:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e.e(java.net.HttpURLConnection, a8.d, h9.l, z8.d):java.lang.Object");
    }
}

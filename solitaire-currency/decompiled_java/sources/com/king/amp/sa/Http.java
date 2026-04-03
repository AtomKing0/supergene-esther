package com.king.amp.sa;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.king.amp.sa.o1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Http implements z0, b1, g1 {
    public static final int CONNECTION_TIMEOUT_MS = 16000;
    public static final int READ_TIMEOUT_MS = 16000;
    public static final int REQUEST_TIMEOUT_SEC = 15;
    private static final String TAG = "AbmHttp";

    @NonNull
    private final u0 mChunksDownloader;
    private ExecutorService mExecutor;
    private final AtomicLong mHttpInstance;

    @Nullable
    private a mRequestConfig;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f16667d;

        public a(@NonNull String[] strArr) {
            this.f16664a = 0;
            this.f16665b = 0;
            this.f16666c = 0;
            this.f16667d = true;
            a();
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                try {
                    if (i11 >= strArr.length) {
                        return;
                    }
                    String str = strArr[i10];
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = strArr[i11];
                        if (!TextUtils.isEmpty(str2)) {
                            int i12 = Integer.parseInt(str2);
                            if (str.equals("requestTimeoutSec")) {
                                this.f16664a = i12;
                            } else if (str.equals("connectTimeoutMs")) {
                                this.f16665b = i12;
                            } else if (str.equals("readTimeoutMs")) {
                                this.f16666c = i12;
                            } else if (str.equals("enableNetworkObstructionCheckOnError")) {
                                this.f16667d = i12 > 0;
                            }
                        }
                    }
                    i10 += 2;
                } catch (Exception e10) {
                    Log.w(Http.TAG, "Failed to parse request configuration, will used default values", e10);
                    a();
                    return;
                }
            }
        }

        private void a() {
            this.f16664a = 15;
            this.f16665b = 16000;
            this.f16666c = 16000;
        }
    }

    public Http(long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.mHttpInstance = atomicLong;
        this.mExecutor = null;
        this.mRequestConfig = null;
        atomicLong.set(j10);
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.mExecutor = executorServiceNewCachedThreadPool;
        this.mChunksDownloader = new u0(executorServiceNewCachedThreadPool, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHttpDownloadFailed$0(String str, String str2, int i10, boolean z10, boolean z11) {
        String string;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append("VPN: ");
            sb.append(z11 ? "on" : "off");
            Log.d(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VPN=");
            sb2.append(z11 ? "on;" : "off;");
            string = sb2.toString();
        } else {
            Log.w(TAG, "No internet");
            string = "No internet connection;";
        }
        onHttpDownloadFailed(this.mHttpInstance.get(), str2, i10, string + str);
    }

    public static native void onGetCallback(long j10, String str, int i10, byte[] bArr);

    public static native void onHttpDataReceived(long j10, String str, long j11, long j12);

    public static native void onHttpDownloadCompleted(long j10, String str);

    public static native void onHttpDownloadFailed(long j10, String str, int i10, String str2);

    public static native void onHttpDownloadStarted(long j10, String str, long j11);

    public static native void onPostCallback(long j10, String str, int i10, String str2);

    public void get(String str, String str2, int i10) {
        if (this.mExecutor != null) {
            this.mExecutor.execute(new a1(str, str2, this, i10));
        }
    }

    @Override // com.king.amp.sa.z0
    public void onGetRequestCompleted(String str, int i10, byte[] bArr) {
        onGetCallback(this.mHttpInstance.get(), str, i10, bArr);
    }

    @Override // com.king.amp.sa.g1
    public void onHttpDataReceived(String str, long j10, long j11) {
        onHttpDataReceived(this.mHttpInstance.get(), str, j10, j11);
    }

    @Override // com.king.amp.sa.g1
    public void onHttpDownloadCompleted(@NonNull String str) {
        onHttpDownloadCompleted(this.mHttpInstance.get(), str);
    }

    @Override // com.king.amp.sa.g1
    public void onHttpDownloadFailed(@NonNull final String str, final int i10, @NonNull final String str2) {
        a aVar = this.mRequestConfig;
        if (aVar != null && aVar.f16667d) {
            o1.b(new o1.a() { // from class: com.king.amp.sa.y0
                @Override // com.king.amp.sa.o1.a
                public final void a(boolean z10, boolean z11) {
                    this.f17023a.lambda$onHttpDownloadFailed$0(str2, str, i10, z10, z11);
                }
            });
            return;
        }
        onHttpDownloadFailed(this.mHttpInstance.get(), str, i10, "VPN=n/a;" + str2);
    }

    @Override // com.king.amp.sa.g1
    public void onHttpDownloadStarted(@NonNull String str, long j10) {
        onHttpDownloadStarted(this.mHttpInstance.get(), str, j10);
    }

    @Override // com.king.amp.sa.b1
    public void onPostRequestCompleted(@NonNull String str, int i10, String str2) {
        onPostCallback(this.mHttpInstance.get(), str, i10, str2);
    }

    public void performHttpRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, int i10, @NonNull String[] strArr) {
        if (str3.isEmpty()) {
            Log.w(TAG, "Unable to perform download, output path is empty");
            onHttpDownloadFailed(str, TypedValues.Custom.TYPE_STRING, "Output filepath is empty");
            return;
        }
        if (this.mExecutor == null) {
            Log.i(TAG, "Executor is invalid");
            return;
        }
        a aVar = new a(strArr);
        this.mRequestConfig = aVar;
        if (aVar.f16664a > 0) {
            this.mExecutor.execute(new x0(str, str2, str3, aVar, i10, this, this.mChunksDownloader));
        } else {
            Log.w(TAG, "Invalid request configuration");
            this.mRequestConfig = null;
            onHttpDownloadFailed(str, TypedValues.Custom.TYPE_INT, "Invalid request configuration");
        }
    }

    public void post(String str, String str2, String str3, String str4, int i10) {
        if (this.mExecutor != null) {
            this.mExecutor.execute(new c1(str, str2, str3, str4, this, i10));
        }
    }

    public void resetHttpInstance() {
        this.mHttpInstance.set(0L);
        this.mChunksDownloader.f();
        this.mExecutor.shutdownNow();
        this.mExecutor = null;
    }
}

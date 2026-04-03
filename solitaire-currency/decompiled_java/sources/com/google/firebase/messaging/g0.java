package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: ImageDownload.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f10422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Future<?> f10423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Task<Bitmap> f10424c;

    private g0(URL url) {
        this.f10422a = url;
    }

    private byte[] i() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f10422a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f10422a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
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
    }

    @Nullable
    public static g0 n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(c());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public Bitmap c() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f10422a);
        }
        byte[] bArrI = i();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrI, 0, bArrI.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f10422a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f10422a);
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10423b.cancel(true);
    }

    public Task<Bitmap> q() {
        return (Task) Preconditions.checkNotNull(this.f10424c);
    }

    public void z(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10423b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10408a.x(taskCompletionSource);
            }
        });
        this.f10424c = taskCompletionSource.getTask();
    }
}

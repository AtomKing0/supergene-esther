package io.sentry.android.core;

import android.content.Context;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.sentry.c8;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: Installation.java */
/* JADX INFO: loaded from: classes5.dex */
final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @TestOnly
    @Nullable
    static String f27428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f27429b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    protected static final io.sentry.util.a f27430c = new io.sentry.util.a();

    public static String a(@NotNull Context context) throws RuntimeException {
        io.sentry.k1 k1VarA = f27430c.a();
        try {
            if (f27428a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        String strC = c(file);
                        f27428a = strC;
                        if (k1VarA != null) {
                            k1VarA.close();
                        }
                        return strC;
                    }
                    f27428a = b(file);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            String str = f27428a;
            if (k1VarA != null) {
                k1VarA.close();
            }
            return str;
        } catch (Throwable th2) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @TestOnly
    @NotNull
    static String b(@NotNull File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, f27429b);
            randomAccessFile.close();
            return str;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @TestOnly
    @NotNull
    static String c(@NotNull File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String strA = c8.a();
            fileOutputStream.write(strA.getBytes(f27429b));
            fileOutputStream.flush();
            fileOutputStream.close();
            return strA;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

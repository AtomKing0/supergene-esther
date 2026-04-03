package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class ExifInterfaceUtils {
    private static final String TAG = "ExifInterfaceUtils";

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void close(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        @DoNotInline
        static FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        @DoNotInline
        static long lseek(FileDescriptor fileDescriptor, long j10, int i10) throws ErrnoException {
            return Os.lseek(fileDescriptor, j10, i10);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    private ExifInterfaceUtils() {
    }

    static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return sb.toString();
    }

    static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        try {
            Api21Impl.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e(TAG, "Error closing fd.");
        }
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    static long[] convertToLongArray(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            jArr[i10] = iArr[i10];
        }
        return jArr;
    }

    static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i10 = 0;
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return i10;
            }
            i10 += i11;
            outputStream.write(bArr, 0, i11);
        }
    }

    static long parseSubSeconds(String str) {
        try {
            int iMin = Math.min(str.length(), 3);
            long j10 = Long.parseLong(str.substring(0, iMin));
            while (iMin < 3) {
                j10 *= 10;
                iMin++;
            }
            return j10;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    static void copy(InputStream inputStream, OutputStream outputStream, int i10) throws IOException {
        byte[] bArr = new byte[8192];
        while (i10 > 0) {
            int iMin = Math.min(i10, 8192);
            int i11 = inputStream.read(bArr, 0, iMin);
            if (i11 == iMin) {
                i10 -= i11;
                outputStream.write(bArr, 0, i11);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }
}

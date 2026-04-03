package b1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: TransformationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f1819a = new Paint(6);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f1820b = new Paint(7);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f1821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f1822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f1823e;

    /* JADX INFO: compiled from: TransformationUtils.java */
    private static final class a implements Lock {
        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f1822d = hashSet;
        f1823e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        f1821c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f1823e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f1819a);
            d(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f1823e.unlock();
            throw th;
        }
    }

    public static Bitmap b(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        float width;
        float height;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            width = i11 / bitmap.getHeight();
            width2 = (i10 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i10 / bitmap.getWidth();
            height = (i11 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapD = dVar.d(i10, i11, h(bitmap));
        l(bitmap, bitmapD);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap c(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return e(dVar, bitmap, i10, i11);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    private static void d(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap e(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapD = dVar.d((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), h(bitmap));
        l(bitmap, bitmapD);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i10 + ViewHierarchyNode.JsonKeys.X + i11);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapD.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmapD.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Lock f() {
        return f1823e;
    }

    public static int g(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    static void i(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static boolean j(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap k(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10) {
        if (!j(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i(i10, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapD = dVar.d(Math.round(rectF.width()), Math.round(rectF.height()), h(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapD.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static void l(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}

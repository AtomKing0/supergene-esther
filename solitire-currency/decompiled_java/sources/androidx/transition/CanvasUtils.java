package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }

        @DoNotInline
        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }
    }

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void enableZ(@NonNull Canvas canvas, boolean z10) {
        Method method;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            if (z10) {
                Api29Impl.enableZ(canvas);
                return;
            } else {
                Api29Impl.disableZ(canvas);
                return;
            }
        }
        if (i10 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!sOrderMethodsFetched) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                sReorderBarrierMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                sInorderBarrierMethod = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sOrderMethodsFetched = true;
        }
        if (z10) {
            try {
                Method method2 = sReorderBarrierMethod;
                if (method2 != null) {
                    method2.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        if (z10 || (method = sInorderBarrierMethod) == null) {
            return;
        }
        method.invoke(canvas, new Object[0]);
    }
}

package a4;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: BundleUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private static Method f139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static Method f140b;

    @Nullable
    public static IBinder a(Bundle bundle, @Nullable String str) {
        return o0.f214a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    @Nullable
    private static IBinder b(Bundle bundle, @Nullable String str) {
        Method method = f139a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f139a = method2;
                method2.setAccessible(true);
                method = f139a;
            } catch (NoSuchMethodException e10) {
                t.g("BundleUtil", "Failed to retrieve getIBinder method", e10);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            t.g("BundleUtil", "Failed to invoke getIBinder via reflection", e11);
            return null;
        }
    }

    public static void c(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (o0.f214a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    private static void d(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = f140b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f140b = method2;
                method2.setAccessible(true);
                method = f140b;
            } catch (NoSuchMethodException e10) {
                t.g("BundleUtil", "Failed to retrieve putIBinder method", e10);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            t.g("BundleUtil", "Failed to invoke putIBinder via reflection", e11);
        }
    }
}

package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowMetricsCalculatorCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {

    @NotNull
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();

    @NotNull
    private static final String TAG;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        t.h(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = simpleName;
    }

    private WindowMetricsCalculatorCompat() {
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection"})
    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException e10) {
            Log.w(TAG, e10);
        } catch (IllegalAccessException e11) {
            Log.w(TAG, e11);
        } catch (InstantiationException e12) {
            Log.w(TAG, e12);
        } catch (NoSuchFieldException e13) {
            Log.w(TAG, e13);
        } catch (NoSuchMethodException e14) {
            Log.w(TAG, e14);
        } catch (InvocationTargetException e15) {
            Log.w(TAG, e15);
        }
        return null;
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeCurrentWindowMetrics(@NotNull Activity activity) {
        t.i(activity, "activity");
        int i10 = Build.VERSION.SDK_INT;
        return new WindowMetrics(i10 >= 30 ? ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(activity) : i10 >= 29 ? computeWindowBoundsQ$window_release(activity) : i10 >= 28 ? computeWindowBoundsP$window_release(activity) : i10 >= 24 ? computeWindowBoundsN$window_release(activity) : computeWindowBoundsIceCreamSandwich$window_release(activity));
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeMaximumWindowMetrics(@NotNull Activity activity) {
        Rect rect;
        t.i(activity, "activity");
        if (Build.VERSION.SDK_INT >= 30) {
            rect = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(activity);
        } else {
            Display display = activity.getWindowManager().getDefaultDisplay();
            t.h(display, "display");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(display);
            rect = new Rect(0, 0, realSizeForDisplay$window_release.x, realSizeForDisplay$window_release.y);
        }
        return new WindowMetrics(rect);
    }

    @RequiresApi(14)
    @NotNull
    public final Rect computeWindowBoundsIceCreamSandwich$window_release(@NotNull Activity activity) {
        int i10;
        t.i(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        t.h(defaultDisplay, "defaultDisplay");
        Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
        Rect rect = new Rect();
        int i11 = realSizeForDisplay$window_release.x;
        if (i11 == 0 || (i10 = realSizeForDisplay$window_release.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i11;
            rect.bottom = i10;
        }
        return rect;
    }

    @RequiresApi(24)
    @NotNull
    public final Rect computeWindowBoundsN$window_release(@NotNull Activity activity) {
        t.i(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            t.h(defaultDisplay, "defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i10 = rect.bottom;
            if (i10 + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i10 + navigationBarHeight;
            } else {
                int i11 = rect.right;
                if (i11 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                    rect.right = i11 + navigationBarHeight;
                }
            }
        }
        return rect;
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    @NotNull
    public final Rect computeWindowBoundsP$window_release(@NotNull Activity activity) {
        DisplayCutout cutoutForDisplay;
        t.i(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            getRectSizeFromDisplay(activity, rect);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            getRectSizeFromDisplay(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        t.h(currentDisplay, "currentDisplay");
        displayCompatHelperApi17.getRealSize(currentDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i10 = rect.bottom;
            if (i10 + navigationBarHeight == point.y) {
                rect.bottom = i10 + navigationBarHeight;
            } else {
                int i11 = rect.right;
                if (i11 + navigationBarHeight == point.x) {
                    rect.right = i11 + navigationBarHeight;
                } else if (rect.left == navigationBarHeight) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity) && (cutoutForDisplay = getCutoutForDisplay(currentDisplay)) != null) {
            int i12 = rect.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
            if (i12 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                rect.right += displayCompatHelperApi28.safeInsetRight(cutoutForDisplay);
            }
            if (rect.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                rect.bottom += displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay);
            }
        }
        return rect;
    }

    @RequiresApi(29)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    @NotNull
    public final Rect computeWindowBoundsQ$window_release(@NotNull Activity activity) {
        t.i(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            if (objInvoke != null) {
                return new Rect((Rect) objInvoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            return computeWindowBoundsP$window_release(activity);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            return computeWindowBoundsP$window_release(activity);
        }
    }

    @RequiresApi(14)
    @VisibleForTesting
    @NotNull
    public final Point getRealSizeForDisplay$window_release(@NotNull Display display) {
        t.i(display, "display");
        Point point = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(display, point);
        return point;
    }
}

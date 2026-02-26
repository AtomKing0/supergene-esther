package com.applovin.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import com.applovin.impl.k0;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.z6;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinSdkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f8051a = new Handler(Looper.getMainLooper());

    public static final class Size {
        public static final Size ZERO = new Size(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8053b;

        public Size(int i10, int i11) {
            this.f8052a = i10;
            this.f8053b = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f8052a == size.getWidth() && this.f8053b == size.getHeight();
        }

        public int getHeight() {
            return this.f8053b;
        }

        public int getWidth() {
            return this.f8052a;
        }

        public int hashCode() {
            int i10 = this.f8053b;
            int i11 = this.f8052a;
            return i10 ^ ((i11 >>> 16) | (i11 << 16));
        }

        public String toString() {
            return this.f8052a + ViewHierarchyNode.JsonKeys.X + this.f8053b;
        }
    }

    private static boolean a(String str, String str2) {
        return StringUtils.startsWithAtLeastOnePrefix(str, CollectionUtils.explode(str2));
    }

    @Dimension(unit = 1)
    public static int dpToPx(Context context, @Dimension(unit = 0) int i10) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static boolean isEmulator() {
        return a(Build.DEVICE, "goldfish,vbox") || a(Build.HARDWARE, "ranchu,generic,vbox") || a(Build.MANUFACTURER, "Genymotion") || a(Build.MODEL, "Android SDK built for x86");
    }

    public static boolean isFireOS(Context context) {
        return "amazon".equalsIgnoreCase(Build.MANUFACTURER) || isFireTv(context);
    }

    public static boolean isFireTv(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static boolean isInclusiveVersion(String str, @Nullable String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int iG = z6.g(str);
        if (str2 == null || iG >= z6.g(str2)) {
            return str3 == null || iG <= z6.g(str3);
        }
        return false;
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= z6.g(str);
    }

    public static boolean isTablet(Context context) {
        Point pointB = k0.b(context);
        return Math.min(pointB.x, pointB.y) >= dpToPx(context, 600);
    }

    public static boolean isTv(Context context) {
        if (isFireTv(context)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        return k0.d() ? packageManager.hasSystemFeature("android.software.leanback") : packageManager.hasSystemFeature("android.hardware.type.television");
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    @Dimension(unit = 0)
    public static int pxToDp(Context context, @Dimension(unit = 1) int i10) {
        return (int) Math.ceil(i10 / context.getResources().getDisplayMetrics().density);
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j10) {
        runOnUiThreadDelayed(runnable, j10, f8051a);
    }

    public static void setImageUrl(String str, ImageView imageView, AppLovinSdk appLovinSdk) {
        ImageViewUtils.setImageUri(imageView, Uri.parse(str), appLovinSdk.a());
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return JsonUtils.toStringMap(jSONObject);
    }

    public static void runOnUiThread(boolean z10, Runnable runnable) {
        if (z10 || !z6.h()) {
            f8051a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j10, Handler handler) {
        if (j10 > 0) {
            handler.postDelayed(runnable, j10);
        } else if (z6.h()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}

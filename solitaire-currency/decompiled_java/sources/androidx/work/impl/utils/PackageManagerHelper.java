package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    private static int getComponentEnabledSetting(@NonNull Context context, @NonNull String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean isComponentEnabled(int i10, boolean z10) {
        return i10 == 0 ? z10 : i10 == 1;
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context context, @NonNull Class<?> cls) {
        return isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false);
    }

    public static void setComponentEnabled(@NonNull Context context, @NonNull Class<?> cls, boolean z10) {
        try {
            if (z10 == isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false)) {
                Logger.get().debug(TAG, "Skipping component enablement for " + cls.getName());
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z10 ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z10 ? "enabled" : "disabled");
            logger.debug(str, sb.toString());
        } catch (Exception e10) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z10 ? "enabled" : "disabled");
            logger2.debug(str2, sb2.toString(), e10);
        }
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context context, @NonNull String str) {
        return getComponentEnabledSetting(context, str) == 1;
    }
}

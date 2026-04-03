package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PropertiesProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class f {
    @Nullable
    public static Boolean a(g gVar, @NotNull String str) {
        String property = gVar.getProperty(str);
        if (property != null) {
            return Boolean.valueOf(property);
        }
        return null;
    }

    @Nullable
    public static Double b(g gVar, @NotNull String str) {
        String property = gVar.getProperty(str);
        if (property != null) {
            try {
                return Double.valueOf(property);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @NotNull
    public static List c(g gVar, @NotNull String str) {
        String property = gVar.getProperty(str);
        return property != null ? Arrays.asList(property.split(",")) : Collections.emptyList();
    }

    @Nullable
    public static List d(g gVar, @NotNull String str) {
        String property = gVar.getProperty(str);
        if (property != null) {
            return Arrays.asList(property.split(","));
        }
        return null;
    }

    @Nullable
    public static Long e(g gVar, @NotNull String str) {
        String property = gVar.getProperty(str);
        if (property != null) {
            try {
                return Long.valueOf(property);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @NotNull
    public static String f(g gVar, @NotNull String str, @NotNull String str2) {
        String property = gVar.getProperty(str);
        return property != null ? property : str2;
    }
}

package io.sentry.util;

import java.net.URI;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n0 {

    /* JADX INFO: compiled from: UrlUtils.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final String f28363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f28364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f28365c;

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.f28363a = str;
            this.f28364b = str2;
            this.f28365c = str3;
        }

        @Nullable
        public String a() {
            return this.f28365c;
        }

        @Nullable
        public String b() {
            return this.f28364b;
        }

        @Nullable
        public String c() {
            return this.f28363a;
        }
    }

    @NotNull
    private static String a(@NotNull String str) {
        if (!str.contains("@")) {
            return str;
        }
        if (str.startsWith("@")) {
            return "[Filtered]" + str;
        }
        return (str.substring(0, str.indexOf(64)).contains(":") ? "[Filtered]:[Filtered]" : "[Filtered]") + str.substring(str.indexOf(64));
    }

    private static boolean b(@NotNull URI uri) {
        try {
            uri.toURL();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @NotNull
    public static a c(@NotNull String str) {
        String str2;
        try {
            URI uri = new URI(str);
            if (uri.isAbsolute() && !b(uri)) {
                return new a(null, null, null);
            }
            String rawPath = "";
            if (uri.getScheme() == null) {
                str2 = "";
            } else {
                str2 = uri.getScheme() + "://";
            }
            String rawAuthority = uri.getRawAuthority() == null ? "" : uri.getRawAuthority();
            if (uri.getRawPath() != null) {
                rawPath = uri.getRawPath();
            }
            return new a(str2 + a(rawAuthority) + rawPath, uri.getRawQuery(), uri.getRawFragment());
        } catch (Exception unused) {
            return new a(null, null, null);
        }
    }
}

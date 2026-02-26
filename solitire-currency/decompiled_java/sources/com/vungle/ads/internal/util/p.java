package com.vungle.ads.internal.util;

import android.util.Log;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p {

    @NotNull
    public static final a Companion = new a(null);
    private static boolean enabled;

    public static final int d(@NotNull String str, @NotNull String str2) {
        return Companion.d(str, str2);
    }

    public static final int e(@NotNull String str, @NotNull String str2) {
        return Companion.e(str, str2);
    }

    public static final int i(@NotNull String str, @NotNull String str2) {
        return Companion.i(str, str2);
    }

    public static final int w(@NotNull String str, @NotNull String str2) {
        return Companion.w(str, str2);
    }

    /* JADX INFO: compiled from: Logger.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final int d(@NotNull String tag, @NotNull String message) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            if (p.enabled) {
                return Log.d(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final int e(@NotNull String tag, @NotNull String message) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            if (p.enabled) {
                return Log.e(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final void enable(boolean z10) {
            p.enabled = z10;
        }

        @NotNull
        public final String eraseSensitiveData(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            Pattern patternCompile = Pattern.compile("[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}");
            kotlin.jvm.internal.t.h(patternCompile, "compile(\"[\\\\d]{1,3}\\\\.[\\…[\\\\d]{1,3}\\\\.[\\\\d]{1,3}\")");
            return new p9.f(patternCompile).b(str, "xxx.xxx.xxx.xxx");
        }

        public final int i(@NotNull String tag, @NotNull String message) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            if (p.enabled) {
                return Log.i(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final int w(@NotNull String tag, @NotNull String message) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            if (p.enabled) {
                return Log.w(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final int e(@NotNull String tag, @NotNull String message, @NotNull Throwable throwable) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            kotlin.jvm.internal.t.i(throwable, "throwable");
            if (!p.enabled) {
                return -1;
            }
            return Log.e(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }

        public final int i(@NotNull String tag, @NotNull String message, @NotNull Throwable throwable) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            kotlin.jvm.internal.t.i(throwable, "throwable");
            if (!p.enabled) {
                return -1;
            }
            return Log.i(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }

        public final int w(@NotNull String tag, @NotNull String message, @NotNull Throwable throwable) {
            kotlin.jvm.internal.t.i(tag, "tag");
            kotlin.jvm.internal.t.i(message, "message");
            kotlin.jvm.internal.t.i(throwable, "throwable");
            if (!p.enabled) {
                return -1;
            }
            return Log.w(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }
    }

    public static final int e(@NotNull String str, @NotNull String str2, @NotNull Throwable th) {
        return Companion.e(str, str2, th);
    }

    public static final int i(@NotNull String str, @NotNull String str2, @NotNull Throwable th) {
        return Companion.i(str, str2, th);
    }

    public static final int w(@NotNull String str, @NotNull String str2, @NotNull Throwable th) {
        return Companion.w(str, str2, th);
    }
}

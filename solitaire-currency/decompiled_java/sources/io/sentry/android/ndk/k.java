package io.sentry.android.ndk;

import io.sentry.a7;
import io.sentry.protocol.SdkVersion;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryNdkUtil.java */
/* JADX INFO: loaded from: classes5.dex */
final class k {
    static {
        a7.d().b("maven:io.sentry:sentry-android-ndk", "8.14.0");
    }

    static void a(@Nullable SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            return;
        }
        sdkVersion.addPackage("maven:io.sentry:sentry-android-ndk", "8.14.0");
    }
}

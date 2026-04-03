package com.vungle.ads.internal.util;

import android.content.Context;
import android.os.StatFs;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PathProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    @NotNull
    private static final String CLEVER_CACHE_FOLDER = "clever_cache";

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String DOWNLOADS_FOLDER = "downloads";

    @NotNull
    private static final String JS_FOLDER = "js";
    private static final long UNKNOWN_SIZE = -1;

    @NotNull
    private static final String VUNGLE_FOLDER = "vungle_cache";

    @NotNull
    private final File cleverCacheDir;

    @NotNull
    private final Context context;

    @NotNull
    private final File downloadsDir;

    @NotNull
    private final File jsDir;

    @NotNull
    private final File vungleDir;

    /* JADX INFO: compiled from: PathProvider.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public q(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.context = context;
        File file = new File(context.getNoBackupFilesDir(), VUNGLE_FOLDER);
        this.vungleDir = file;
        File file2 = new File(file, DOWNLOADS_FOLDER);
        this.downloadsDir = file2;
        File file3 = new File(file, JS_FOLDER);
        this.jsDir = file3;
        File file4 = new File(file, CLEVER_CACHE_FOLDER);
        this.cleverCacheDir = file4;
        for (File file5 : kotlin.collections.v.n(file, file2, file3, file4)) {
            if (!file5.exists()) {
                file5.mkdirs();
            }
        }
    }

    public final long getAvailableBytes(@NotNull String path) {
        kotlin.jvm.internal.t.i(path, "path");
        try {
            return new StatFs(path).getAvailableBytes();
        } catch (IllegalArgumentException e10) {
            p.Companion.w("PathProvider", "Failed to get available bytes " + e10.getMessage());
            return -1L;
        }
    }

    @NotNull
    public final File getCleverCacheDir() {
        if (!this.cleverCacheDir.exists()) {
            this.cleverCacheDir.mkdirs();
        }
        return this.cleverCacheDir;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final File getDownloadDir() {
        if (!this.downloadsDir.exists()) {
            this.downloadsDir.mkdirs();
        }
        return this.downloadsDir;
    }

    @Nullable
    public final File getDownloadsDirForAd(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        File file = new File(getDownloadDir().getPath() + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @NotNull
    public final File getJsAssetDir(@NotNull String jsVersion) {
        kotlin.jvm.internal.t.i(jsVersion, "jsVersion");
        File file = new File(getJsDir(), jsVersion);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @NotNull
    public final File getJsDir() {
        if (!this.jsDir.exists()) {
            this.jsDir.mkdirs();
        }
        return this.jsDir;
    }

    @NotNull
    public final File getSharedPrefsDir() {
        File noBackupFilesDir = this.context.getNoBackupFilesDir();
        kotlin.jvm.internal.t.h(noBackupFilesDir, "{\n        context.noBackupFilesDir\n    }");
        return noBackupFilesDir;
    }

    @NotNull
    public final File getUnclosedAdFile(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return new File(getSharedPrefsDir(), name);
    }

    @NotNull
    public final File getVungleDir() {
        if (!this.vungleDir.exists()) {
            this.vungleDir.mkdirs();
        }
        return this.vungleDir;
    }
}

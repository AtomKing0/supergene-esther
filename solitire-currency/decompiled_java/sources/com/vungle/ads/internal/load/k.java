package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.a;
import com.vungle.ads.internal.downloader.d;
import com.vungle.ads.internal.load.k;
import com.vungle.ads.internal.model.a;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.q;
import com.vungle.ads.u0;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MraidJsLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final int MRAID_AVAILABLE = 13;
    public static final int MRAID_DOWNLOADED = 10;
    public static final int MRAID_DOWNLOAD_FAILED = 12;
    public static final int MRAID_INVALID_ENDPOINT = 11;

    @NotNull
    private static final String TAG = "MraidJsLoader";

    @NotNull
    public static final k INSTANCE = new k();

    @NotNull
    private static final AtomicBoolean isDownloading = new AtomicBoolean(false);

    @NotNull
    private static final CopyOnWriteArrayList<a> listeners = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: MraidJsLoader.kt */
    public interface a {
        void onDownloadResult(int i10);
    }

    /* JADX INFO: compiled from: MraidJsLoader.kt */
    public static final class b implements com.vungle.ads.internal.downloader.a {
        final /* synthetic */ com.vungle.ads.internal.executor.i $executor;
        final /* synthetic */ File $jsPath;
        final /* synthetic */ File $mraidJsFile;

        b(com.vungle.ads.internal.executor.i iVar, File file, File file2) {
            this.$executor = iVar;
            this.$jsPath = file;
            this.$mraidJsFile = file2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onError$lambda-0, reason: not valid java name */
        public static final void m4061onError$lambda0(a.C0502a c0502a, com.vungle.ads.internal.downloader.d downloadRequest, File jsPath) {
            t.i(downloadRequest, "$downloadRequest");
            t.i(jsPath, "$jsPath");
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download mraid js error: ");
                    sb.append(c0502a != null ? Integer.valueOf(c0502a.getServerCode()) : null);
                    sb.append(". Failed to load asset ");
                    sb.append(downloadRequest.getAsset().getServerPath());
                    String string = sb.toString();
                    p.Companion.d(k.TAG, string);
                    new u0(string).logErrorNoReturnValue$vungle_ads_release();
                    com.vungle.ads.internal.util.i.deleteContents(jsPath);
                } catch (Exception e10) {
                    p.Companion.e(k.TAG, "Failed to delete js assets", e10);
                }
            } finally {
                k.INSTANCE.notifyListeners(12);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onSuccess$lambda-1, reason: not valid java name */
        public static final void m4062onSuccess$lambda1(File file, File mraidJsFile, File jsPath) {
            t.i(file, "$file");
            t.i(mraidJsFile, "$mraidJsFile");
            t.i(jsPath, "$jsPath");
            try {
                if (!file.exists() || file.length() <= 0) {
                    com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(131, "Mraid js downloaded but write failure: " + mraidJsFile.getAbsolutePath(), (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
                    com.vungle.ads.internal.util.i.deleteContents(jsPath);
                    k.INSTANCE.notifyListeners(12);
                } else {
                    k.INSTANCE.notifyListeners(10);
                }
            } catch (Exception e10) {
                p.Companion.e(k.TAG, "Failed to delete js assets", e10);
                k.INSTANCE.notifyListeners(12);
            }
        }

        @Override // com.vungle.ads.internal.downloader.a
        public void onError(@Nullable final a.C0502a c0502a, @NotNull final com.vungle.ads.internal.downloader.d downloadRequest) {
            t.i(downloadRequest, "downloadRequest");
            com.vungle.ads.internal.executor.i iVar = this.$executor;
            final File file = this.$jsPath;
            iVar.execute(new Runnable() { // from class: com.vungle.ads.internal.load.l
                @Override // java.lang.Runnable
                public final void run() {
                    k.b.m4061onError$lambda0(c0502a, downloadRequest, file);
                }
            });
        }

        @Override // com.vungle.ads.internal.downloader.a
        public void onSuccess(@NotNull final File file, @NotNull com.vungle.ads.internal.downloader.d downloadRequest) {
            t.i(file, "file");
            t.i(downloadRequest, "downloadRequest");
            com.vungle.ads.internal.executor.i iVar = this.$executor;
            final File file2 = this.$mraidJsFile;
            final File file3 = this.$jsPath;
            iVar.execute(new Runnable() { // from class: com.vungle.ads.internal.load.m
                @Override // java.lang.Runnable
                public final void run() {
                    k.b.m4062onSuccess$lambda1(file, file2, file3);
                }
            });
        }
    }

    private k() {
    }

    public static /* synthetic */ void downloadJs$default(k kVar, q qVar, com.vungle.ads.internal.downloader.e eVar, com.vungle.ads.internal.executor.i iVar, a aVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            aVar = null;
        }
        kVar.downloadJs(qVar, eVar, iVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadJs$lambda-1, reason: not valid java name */
    public static final void m4060downloadJs$lambda1(a aVar, q pathProvider, com.vungle.ads.internal.downloader.e downloader, com.vungle.ads.internal.executor.i executor) {
        t.i(pathProvider, "$pathProvider");
        t.i(downloader, "$downloader");
        t.i(executor, "$executor");
        if (aVar != null) {
            try {
                listeners.add(aVar);
            } catch (Exception e10) {
                p.Companion.e(TAG, "Failed to download mraid js", e10);
                return;
            }
        }
        boolean z10 = true;
        if (isDownloading.getAndSet(true)) {
            p.Companion.w(TAG, "mraid js is downloading, waiting for the previous request.");
            return;
        }
        com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
        String mraidEndpoint = kVar.getMraidEndpoint();
        if (mraidEndpoint != null && mraidEndpoint.length() != 0) {
            z10 = false;
        }
        if (z10) {
            INSTANCE.notifyListeners(11);
            return;
        }
        File file = new File(pathProvider.getJsAssetDir(kVar.getMraidJsVersion()), com.vungle.ads.internal.l.MRAID_JS_FILE_NAME);
        if (file.exists()) {
            p.Companion.w(TAG, "mraid js already downloaded");
            INSTANCE.notifyListeners(13);
            return;
        }
        File jsDir = pathProvider.getJsDir();
        com.vungle.ads.internal.util.i.deleteContents(jsDir);
        String absolutePath = file.getAbsolutePath();
        t.h(absolutePath, "mraidJsFile.absolutePath");
        downloader.download(new com.vungle.ads.internal.downloader.d(d.a.HIGH, new com.vungle.ads.internal.model.a(com.vungle.ads.internal.l.MRAID_JS_FILE_NAME, mraidEndpoint + "/mraid.min.js", absolutePath, a.EnumC0510a.ASSET, true), null, null, null, 28, null), new b(executor, jsDir, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListeners(int i10) {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onDownloadResult(i10);
        }
        listeners.clear();
        isDownloading.set(false);
    }

    public final void downloadJs(@NotNull final q pathProvider, @NotNull final com.vungle.ads.internal.downloader.e downloader, @NotNull final com.vungle.ads.internal.executor.i executor, @Nullable final a aVar) {
        t.i(pathProvider, "pathProvider");
        t.i(downloader, "downloader");
        t.i(executor, "executor");
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.j
            @Override // java.lang.Runnable
            public final void run() {
                k.m4060downloadJs$lambda1(aVar, pathProvider, downloader, executor);
            }
        });
    }
}

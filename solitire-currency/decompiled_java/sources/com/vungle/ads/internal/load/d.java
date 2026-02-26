package com.vungle.ads.internal.load;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.annotation.WorkerThread;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.b2;
import com.vungle.ads.f1;
import com.vungle.ads.internal.downloader.a;
import com.vungle.ads.internal.downloader.d;
import com.vungle.ads.internal.load.d;
import com.vungle.ads.internal.load.k;
import com.vungle.ads.internal.model.a;
import com.vungle.ads.internal.model.b;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.q;
import com.vungle.ads.internal.util.w;
import com.vungle.ads.m0;
import com.vungle.ads.p;
import com.vungle.ads.u0;
import com.vungle.ads.v1;
import com.vungle.ads.w1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseAdLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String DOWNLOADED_FILE_NOT_FOUND = "Downloaded file not found!";

    @NotNull
    private static final String TAG = "BaseAdLoader";

    @NotNull
    private final List<com.vungle.ads.internal.model.a> adAssets;

    @Nullable
    private com.vungle.ads.internal.load.a adLoaderCallback;

    @NotNull
    private final com.vungle.ads.internal.load.b adRequest;

    @Nullable
    private com.vungle.ads.internal.model.b advertisement;

    @NotNull
    private w1 assetDownloadDurationMetric;

    @NotNull
    private final Context context;

    @NotNull
    private final AtomicLong downloadCount;

    @NotNull
    private final AtomicLong downloadRequiredCount;

    @NotNull
    private final com.vungle.ads.internal.downloader.e downloader;

    @NotNull
    private AtomicBoolean fullyDownloaded;

    @NotNull
    private v1 mainVideoSizeMetric;

    @NotNull
    private AtomicBoolean notifyFailed;

    @NotNull
    private AtomicBoolean notifySuccess;

    @NotNull
    private final com.vungle.ads.internal.omsdk.c omInjector;

    @NotNull
    private final q pathProvider;

    @NotNull
    private AtomicBoolean requiredAssetDownloaded;

    @NotNull
    private final com.vungle.ads.internal.executor.a sdkExecutors;

    @NotNull
    private v1 templateHtmlSizeMetric;

    @NotNull
    private v1 templateSizeMetric;

    @NotNull
    private final com.vungle.ads.internal.network.i vungleApiClient;

    /* JADX INFO: compiled from: BaseAdLoader.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: BaseAdLoader.kt */
    public static final class c implements com.vungle.ads.internal.downloader.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onError$lambda-0, reason: not valid java name */
        public static final void m4056onError$lambda0(d this$0, com.vungle.ads.internal.downloader.d downloadRequest) {
            t.i(this$0, "this$0");
            t.i(downloadRequest, "$downloadRequest");
            this$0.fullyDownloaded.set(false);
            if (downloadRequest.getAsset().isRequired()) {
                this$0.requiredAssetDownloaded.set(false);
            }
            if (downloadRequest.getAsset().isRequired() && this$0.downloadRequiredCount.decrementAndGet() <= 0) {
                this$0.onAdLoadFailed(new p());
                this$0.cancel();
            } else if (this$0.downloadCount.decrementAndGet() <= 0) {
                this$0.onAdLoadFailed(new p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onSuccess$lambda-1, reason: not valid java name */
        public static final void m4057onSuccess$lambda1(File file, c this$0, com.vungle.ads.internal.downloader.d downloadRequest, d this$1) {
            t.i(file, "$file");
            t.i(this$0, "this$0");
            t.i(downloadRequest, "$downloadRequest");
            t.i(this$1, "this$1");
            if (!file.exists()) {
                this$0.onError(new a.C0502a(-1, new IOException(d.DOWNLOADED_FILE_NOT_FOUND), a.C0502a.b.Companion.getFILE_NOT_FOUND_ERROR()), downloadRequest);
                return;
            }
            com.vungle.ads.internal.model.a asset = downloadRequest.getAsset();
            asset.setFileSize(file.length());
            asset.setStatus(a.b.DOWNLOAD_SUCCESS);
            if (downloadRequest.isTemplate()) {
                downloadRequest.stopRecord();
                v1 v1Var = downloadRequest.isHtmlTemplate() ? this$1.templateHtmlSizeMetric : this$1.templateSizeMetric;
                v1Var.setValue(Long.valueOf(file.length()));
                com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
                String referenceId = this$1.getAdRequest().getPlacement().getReferenceId();
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release = this$1.getAdvertisement$vungle_ads_release();
                String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release2 = this$1.getAdvertisement$vungle_ads_release();
                oVar.logMetric$vungle_ads_release(v1Var, referenceId, creativeId, advertisement$vungle_ads_release2 != null ? advertisement$vungle_ads_release2.eventId() : null, asset.getServerPath());
            } else if (downloadRequest.isMainVideo()) {
                this$1.mainVideoSizeMetric.setValue(Long.valueOf(file.length()));
                com.vungle.ads.o oVar2 = com.vungle.ads.o.INSTANCE;
                v1 v1Var2 = this$1.mainVideoSizeMetric;
                String referenceId2 = this$1.getAdRequest().getPlacement().getReferenceId();
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release3 = this$1.getAdvertisement$vungle_ads_release();
                String creativeId2 = advertisement$vungle_ads_release3 != null ? advertisement$vungle_ads_release3.getCreativeId() : null;
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release4 = this$1.getAdvertisement$vungle_ads_release();
                oVar2.logMetric$vungle_ads_release(v1Var2, referenceId2, creativeId2, advertisement$vungle_ads_release4 != null ? advertisement$vungle_ads_release4.eventId() : null, asset.getServerPath());
            }
            com.vungle.ads.internal.model.b advertisement$vungle_ads_release5 = this$1.getAdvertisement$vungle_ads_release();
            if (advertisement$vungle_ads_release5 != null) {
                advertisement$vungle_ads_release5.updateAdAssetPath(asset);
            }
            if (downloadRequest.isTemplate() && !this$1.processVmTemplate(asset, this$1.getAdvertisement$vungle_ads_release())) {
                this$1.fullyDownloaded.set(false);
                if (asset.isRequired()) {
                    this$1.requiredAssetDownloaded.set(false);
                }
            }
            if (asset.isRequired() && this$1.downloadRequiredCount.decrementAndGet() <= 0) {
                if (!this$1.requiredAssetDownloaded.get()) {
                    this$1.onAdLoadFailed(new p());
                    this$1.cancel();
                    return;
                }
                this$1.onAdReady();
            }
            if (this$1.downloadCount.decrementAndGet() <= 0) {
                if (!this$1.fullyDownloaded.get()) {
                    this$1.onAdLoadFailed(new p());
                    return;
                }
                com.vungle.ads.internal.load.b adRequest = this$1.getAdRequest();
                com.vungle.ads.internal.model.b advertisement$vungle_ads_release6 = this$1.getAdvertisement$vungle_ads_release();
                this$1.onDownloadCompleted(adRequest, advertisement$vungle_ads_release6 != null ? advertisement$vungle_ads_release6.eventId() : null);
            }
        }

        @Override // com.vungle.ads.internal.downloader.a
        public void onError(@Nullable a.C0502a c0502a, @NotNull final com.vungle.ads.internal.downloader.d downloadRequest) {
            t.i(downloadRequest, "downloadRequest");
            p.a aVar = com.vungle.ads.internal.util.p.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("onError called: reason ");
            sb.append(c0502a != null ? Integer.valueOf(c0502a.getReason()) : null);
            sb.append("; cause ");
            sb.append(c0502a != null ? c0502a.getCause() : null);
            aVar.e(d.TAG, sb.toString());
            com.vungle.ads.internal.executor.i backgroundExecutor = d.this.getSdkExecutors().getBackgroundExecutor();
            final d dVar = d.this;
            backgroundExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.e
                @Override // java.lang.Runnable
                public final void run() {
                    d.c.m4056onError$lambda0(dVar, downloadRequest);
                }
            });
        }

        @Override // com.vungle.ads.internal.downloader.a
        public void onSuccess(@NotNull final File file, @NotNull final com.vungle.ads.internal.downloader.d downloadRequest) {
            t.i(file, "file");
            t.i(downloadRequest, "downloadRequest");
            com.vungle.ads.internal.executor.i backgroundExecutor = d.this.getSdkExecutors().getBackgroundExecutor();
            final d dVar = d.this;
            backgroundExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.f
                @Override // java.lang.Runnable
                public final void run() {
                    d.c.m4057onSuccess$lambda1(file, this, downloadRequest, dVar);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.load.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class C0509d extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0509d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    /* JADX INFO: compiled from: BaseAdLoader.kt */
    public static final class e implements k.a {
        final /* synthetic */ com.vungle.ads.internal.model.b $advertisement;

        e(com.vungle.ads.internal.model.b bVar) {
            this.$advertisement = bVar;
        }

        @Override // com.vungle.ads.internal.load.k.a
        public void onDownloadResult(int i10) {
            if (i10 == 10 || i10 == 13) {
                if (i10 == 10) {
                    com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(Sdk$SDKMetric.b.MRAID_DOWNLOAD_JS_RETRY_SUCCESS, (34 & 2) != 0 ? 0L : 0L, (34 & 4) != 0 ? null : d.this.getAdRequest().getPlacement().getReferenceId(), (34 & 8) != 0 ? null : null, (34 & 16) != 0 ? null : null, (34 & 32) == 0 ? null : null);
                }
                d.this.downloadAssets(this.$advertisement);
            } else {
                com.vungle.ads.internal.load.a aVar = d.this.adLoaderCallback;
                if (aVar != null) {
                    aVar.onFailure(new u0(null, 1, null));
                }
            }
        }
    }

    /* JADX INFO: compiled from: BaseAdLoader.kt */
    public static final class f implements w.a {
        final /* synthetic */ List<String> $existingPaths;

        f(List<String> list) {
            this.$existingPaths = list;
        }

        @Override // com.vungle.ads.internal.util.w.a
        public boolean matches(@Nullable String str) {
            if (str == null || str.length() == 0) {
                return true;
            }
            File file = new File(str);
            Iterator<String> it = this.$existingPaths.iterator();
            while (it.hasNext()) {
                File file2 = new File(it.next());
                if (t.d(file2, file)) {
                    return false;
                }
                String path = file.getPath();
                t.h(path, "toExtract.path");
                if (p9.q.K(path, file2.getPath() + File.separator, false, 2, null)) {
                    return false;
                }
            }
            return true;
        }
    }

    public d(@NotNull Context context, @NotNull com.vungle.ads.internal.network.i vungleApiClient, @NotNull com.vungle.ads.internal.executor.a sdkExecutors, @NotNull com.vungle.ads.internal.omsdk.c omInjector, @NotNull com.vungle.ads.internal.downloader.e downloader, @NotNull q pathProvider, @NotNull com.vungle.ads.internal.load.b adRequest) {
        t.i(context, "context");
        t.i(vungleApiClient, "vungleApiClient");
        t.i(sdkExecutors, "sdkExecutors");
        t.i(omInjector, "omInjector");
        t.i(downloader, "downloader");
        t.i(pathProvider, "pathProvider");
        t.i(adRequest, "adRequest");
        this.context = context;
        this.vungleApiClient = vungleApiClient;
        this.sdkExecutors = sdkExecutors;
        this.omInjector = omInjector;
        this.downloader = downloader;
        this.pathProvider = pathProvider;
        this.adRequest = adRequest;
        this.downloadCount = new AtomicLong(0L);
        this.downloadRequiredCount = new AtomicLong(0L);
        this.notifySuccess = new AtomicBoolean(false);
        this.notifyFailed = new AtomicBoolean(false);
        this.adAssets = new ArrayList();
        this.fullyDownloaded = new AtomicBoolean(true);
        this.requiredAssetDownloaded = new AtomicBoolean(true);
        this.mainVideoSizeMetric = new v1(Sdk$SDKMetric.b.ASSET_FILE_SIZE);
        this.templateSizeMetric = new v1(Sdk$SDKMetric.b.TEMPLATE_ZIP_SIZE);
        this.templateHtmlSizeMetric = new v1(Sdk$SDKMetric.b.TEMPLATE_HTML_SIZE);
        this.assetDownloadDurationMetric = new w1(Sdk$SDKMetric.b.ASSET_DOWNLOAD_DURATION_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAssets(com.vungle.ads.internal.model.b bVar) {
        this.assetDownloadDurationMetric.markStart();
        this.downloadCount.set(this.adAssets.size());
        AtomicLong atomicLong = this.downloadRequiredCount;
        List<com.vungle.ads.internal.model.a> list = this.adAssets;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((com.vungle.ads.internal.model.a) obj).isRequired()) {
                arrayList.add(obj);
            }
        }
        atomicLong.set(arrayList.size());
        for (com.vungle.ads.internal.model.a aVar : this.adAssets) {
            com.vungle.ads.internal.downloader.d dVar = new com.vungle.ads.internal.downloader.d(getAssetPriority(aVar), aVar, this.adRequest.getPlacement().getReferenceId(), bVar.getCreativeId(), bVar.eventId());
            if (dVar.isTemplate()) {
                dVar.startRecord();
            }
            this.downloader.download(dVar, getAssetDownloadListener());
        }
    }

    private final boolean fileIsValid(File file, com.vungle.ads.internal.model.a aVar) {
        return file.exists() && file.length() == aVar.getFileSize();
    }

    private final com.vungle.ads.internal.downloader.a getAssetDownloadListener() {
        return new c();
    }

    private final d.a getAssetPriority(com.vungle.ads.internal.model.a aVar) {
        return aVar.isRequired() ? d.a.CRITICAL : d.a.HIGHEST;
    }

    private final File getDestinationDir(com.vungle.ads.internal.model.b bVar) {
        return this.pathProvider.getDownloadsDirForAd(bVar.eventId());
    }

    private final b getErrorInfo(com.vungle.ads.internal.model.b bVar) {
        Integer errorCode;
        b.c cVarAdUnit = bVar.adUnit();
        int iIntValue = (cVarAdUnit == null || (errorCode = cVarAdUnit.getErrorCode()) == null) ? 212 : errorCode.intValue();
        b.c cVarAdUnit2 = bVar.adUnit();
        Integer sleep = cVarAdUnit2 != null ? cVarAdUnit2.getSleep() : null;
        b.c cVarAdUnit3 = bVar.adUnit();
        String info = cVarAdUnit3 != null ? cVarAdUnit3.getInfo() : null;
        if (iIntValue != 10001 && iIntValue != 10002 && iIntValue != 20001 && iIntValue != 30001 && iIntValue != 30002) {
            return new b(212, "Response error: " + sleep, "Request failed with error: 212, " + info, false, 8, null);
        }
        return new b(iIntValue, "Response error: " + sleep, "Request failed with error: " + iIntValue + ", " + info, false, 8, null);
    }

    /* JADX INFO: renamed from: handleAdMetaData$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.signals.b m4054handleAdMetaData$lambda5(v8.l<com.vungle.ads.internal.signals.b> lVar) {
        return lVar.getValue();
    }

    public static /* synthetic */ void handleAdMetaData$vungle_ads_release$default(d dVar, com.vungle.ads.internal.model.b bVar, v1 v1Var, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleAdMetaData");
        }
        if ((i10 & 2) != 0) {
            v1Var = null;
        }
        dVar.handleAdMetaData$vungle_ads_release(bVar, v1Var);
    }

    private final boolean injectMraidJS(File file) {
        try {
            File file2 = new File(file.getPath(), com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME);
            File file3 = new File(this.pathProvider.getJsAssetDir(com.vungle.ads.internal.k.INSTANCE.getMraidJsVersion()), com.vungle.ads.internal.l.MRAID_JS_FILE_NAME);
            if (!file3.exists()) {
                return true;
            }
            f9.m.o(file3, file2, true, 0, 4, null);
            return true;
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Failed to inject mraid.js: " + e10.getMessage());
            return false;
        }
    }

    private final boolean isUrlValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAd$lambda-0, reason: not valid java name */
    public static final void m4055loadAd$lambda0(d this$0) {
        t.i(this$0, "this$0");
        com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(Sdk$SDKMetric.b.LOAD_AD_API, (34 & 2) != 0 ? 0L : 0L, (34 & 4) != 0 ? null : this$0.adRequest.getPlacement().getReferenceId(), (34 & 8) != 0 ? null : null, (34 & 16) != 0 ? null : null, (34 & 32) == 0 ? null : null);
        this$0.requestAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdReady() {
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        if (bVar == null || this.notifyFailed.get() || !this.notifySuccess.compareAndSet(false, true)) {
            return;
        }
        onAdLoadReady();
        com.vungle.ads.internal.load.a aVar = this.adLoaderCallback;
        if (aVar != null) {
            aVar.onSuccess(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean processVmTemplate(com.vungle.ads.internal.model.a aVar, com.vungle.ads.internal.model.b bVar) {
        if (bVar == null || aVar.getStatus() != a.b.DOWNLOAD_SUCCESS) {
            return false;
        }
        if (aVar.getLocalPath().length() == 0) {
            return false;
        }
        File file = new File(aVar.getLocalPath());
        if (!fileIsValid(file, aVar)) {
            return false;
        }
        File destinationDir = getDestinationDir(bVar);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Unable to access Destination Directory");
            return false;
        }
        if (aVar.getFileType() == a.EnumC0510a.ZIP && !unzipFile(bVar, file, destinationDir)) {
            return false;
        }
        if (bVar.omEnabled()) {
            try {
                this.omInjector.injectJsFiles(destinationDir);
            } catch (Exception e10) {
                com.vungle.ads.internal.util.p.Companion.e(TAG, "Failed to inject OMSDK: " + e10.getMessage());
                return false;
            }
        }
        boolean zInjectMraidJS = injectMraidJS(destinationDir);
        com.vungle.ads.internal.util.i.printDirectoryTree(destinationDir);
        return zInjectMraidJS;
    }

    private final boolean unzipFile(com.vungle.ads.internal.model.b bVar, File file, File file2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (com.vungle.ads.internal.model.a aVar : this.adAssets) {
            if (aVar.getFileType() == a.EnumC0510a.ASSET) {
                arrayList.add(aVar.getLocalPath());
            }
        }
        try {
            w wVar = w.INSTANCE;
            String path = file.getPath();
            String path2 = file2.getPath();
            t.h(path2, "destinationDir.path");
            wVar.unzip(path, path2, new f(arrayList));
            if (new File(file2.getPath(), com.vungle.ads.internal.l.AD_INDEX_FILE_NAME).exists()) {
                com.vungle.ads.internal.util.i.delete(file);
                return true;
            }
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(115, "Failed to retrieve indexFileUrl from the Ad.", this.adRequest.getPlacement().getReferenceId(), bVar.getCreativeId(), bVar.eventId());
            return false;
        } catch (Exception e10) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(109, "Unzip failed: " + e10.getMessage(), this.adRequest.getPlacement().getReferenceId(), bVar.getCreativeId(), bVar.eventId());
            return false;
        }
    }

    private final b validateAdMetadata(com.vungle.ads.internal.model.b bVar) {
        b.c cVarAdUnit = bVar.adUnit();
        if ((cVarAdUnit != null ? cVarAdUnit.getSleep() : null) != null) {
            return getErrorInfo(bVar);
        }
        String referenceId = this.adRequest.getPlacement().getReferenceId();
        com.vungle.ads.internal.model.b bVar2 = this.advertisement;
        if (!t.d(referenceId, bVar2 != null ? bVar2.placementId() : null)) {
            return new b(215, "Requests and responses don't match the placement Id.", null, false, 12, null);
        }
        b.c cVarAdUnit2 = bVar.adUnit();
        b.g templateSettings = cVarAdUnit2 != null ? cVarAdUnit2.getTemplateSettings() : null;
        if (templateSettings == null) {
            return new b(113, "Missing template settings", null, false, 12, null);
        }
        Map<String, b.d> cacheableReplacements = templateSettings.getCacheableReplacements();
        if (!bVar.isNativeTemplateType()) {
            b.c cVarAdUnit3 = bVar.adUnit();
            String templateURL = cVarAdUnit3 != null ? cVarAdUnit3.getTemplateURL() : null;
            b.c cVarAdUnit4 = bVar.adUnit();
            String vmURL = cVarAdUnit4 != null ? cVarAdUnit4.getVmURL() : null;
            if (templateURL == null || templateURL.length() == 0) {
                if (vmURL == null || vmURL.length() == 0) {
                    return new b(105, "Failed to prepare vmURL or templateURL for downloading.", null, false, 12, null);
                }
            }
            if (!(templateURL == null || templateURL.length() == 0) && !isUrlValid(templateURL)) {
                return new b(112, "Failed to load template asset.", null, false, 12, null);
            }
            if (!(vmURL == null || vmURL.length() == 0) && !isUrlValid(vmURL)) {
                return new b(112, "Failed to load vm url asset.", null, false, 12, null);
            }
        } else if (cacheableReplacements != null) {
            b.d dVar = cacheableReplacements.get(f1.TOKEN_MAIN_IMAGE);
            if ((dVar != null ? dVar.getUrl() : null) == null) {
                return new b(600, "Unable to load main image.", null, false, 12, null);
            }
            b.d dVar2 = cacheableReplacements.get(f1.TOKEN_VUNGLE_PRIVACY_ICON_URL);
            if ((dVar2 != null ? dVar2.getUrl() : null) == null) {
                return new b(600, "Unable to load privacy image.", null, false, 12, null);
            }
        }
        if (bVar.hasExpired()) {
            return new b(304, "The ad markup has expired for playback.", null, false, 12, null);
        }
        String strEventId = bVar.eventId();
        if (strEventId == null || strEventId.length() == 0) {
            return new b(200, "Event id is invalid.", null, false, 12, null);
        }
        if (cacheableReplacements != null) {
            Iterator<Map.Entry<String, b.d>> it = cacheableReplacements.entrySet().iterator();
            while (it.hasNext()) {
                String url = it.next().getValue().getUrl();
                if (url == null || url.length() == 0) {
                    return new b(111, "Invalid asset URL " + url, null, false, 12, null);
                }
                if (!isUrlValid(url)) {
                    return new b(112, "Invalid asset URL " + url, null, false, 12, null);
                }
            }
        }
        return null;
    }

    public final void cancel() {
        this.downloader.cancelAll();
    }

    @NotNull
    public final com.vungle.ads.internal.load.b getAdRequest() {
        return this.adRequest;
    }

    @Nullable
    public final com.vungle.ads.internal.model.b getAdvertisement$vungle_ads_release() {
        return this.advertisement;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final q getPathProvider() {
        return this.pathProvider;
    }

    @NotNull
    public final com.vungle.ads.internal.executor.a getSdkExecutors() {
        return this.sdkExecutors;
    }

    @NotNull
    public final com.vungle.ads.internal.network.i getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final void handleAdMetaData$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement, @Nullable v1 v1Var) {
        List<String> loadAdUrls;
        t.i(advertisement, "advertisement");
        this.advertisement = advertisement;
        com.vungle.ads.internal.model.g gVarConfig = advertisement.config();
        if (gVarConfig != null) {
            com.vungle.ads.internal.k.INSTANCE.initWithConfig$vungle_ads_release(this.context, gVarConfig, false, v1Var);
        }
        b bVarValidateAdMetadata = validateAdMetadata(advertisement);
        if (bVarValidateAdMetadata != null) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(bVarValidateAdMetadata.getReason(), bVarValidateAdMetadata.getDescription(), this.adRequest.getPlacement().getReferenceId(), advertisement.getCreativeId(), advertisement.eventId());
            onAdLoadFailed(new m0(bVarValidateAdMetadata.getReason(), bVarValidateAdMetadata.getDescriptionExternal()));
            return;
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory() || !destinationDir.exists()) {
            onAdLoadFailed(new com.vungle.ads.p());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.l lVarB = v8.n.b(v8.p.f35201a, new C0509d(this.context));
        b.c cVarAdUnit = advertisement.adUnit();
        if (cVarAdUnit != null && (loadAdUrls = cVarAdUnit.getLoadAdUrls()) != null) {
            com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(this.vungleApiClient, advertisement.placementId(), advertisement.getCreativeId(), advertisement.eventId(), this.sdkExecutors.getIoExecutor(), this.pathProvider, m4054handleAdMetaData$lambda5(lVarB));
            Iterator<T> it = loadAdUrls.iterator();
            while (it.hasNext()) {
                gVar.sendTpat((String) it.next(), this.sdkExecutors.getJobExecutor());
            }
        }
        if (!this.adAssets.isEmpty()) {
            this.adAssets.clear();
        }
        this.adAssets.addAll(advertisement.getDownloadableAssets(destinationDir));
        if (this.adAssets.isEmpty()) {
            onAdLoadFailed(new com.vungle.ads.p());
        } else {
            k.INSTANCE.downloadJs(this.pathProvider, this.downloader, this.sdkExecutors.getBackgroundExecutor(), new e(advertisement));
        }
    }

    public final void loadAd(@NotNull com.vungle.ads.internal.load.a adLoaderCallback) {
        t.i(adLoaderCallback, "adLoaderCallback");
        this.adLoaderCallback = adLoaderCallback;
        this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() { // from class: com.vungle.ads.internal.load.c
            @Override // java.lang.Runnable
            public final void run() {
                d.m4055loadAd$lambda0(this.f24324a);
            }
        });
    }

    public final void onAdLoadFailed(@NotNull b2 error) {
        com.vungle.ads.internal.load.a aVar;
        t.i(error, "error");
        if (this.notifySuccess.get() || !this.notifyFailed.compareAndSet(false, true) || (aVar = this.adLoaderCallback) == null) {
            return;
        }
        aVar.onFailure(error);
    }

    public abstract void onAdLoadReady();

    @WorkerThread
    public void onDownloadCompleted(@NotNull com.vungle.ads.internal.load.b request, @Nullable String str) {
        t.i(request, "request");
        com.vungle.ads.internal.util.p.Companion.d(TAG, "download completed " + request);
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        if (bVar != null) {
            bVar.setAssetFullyDownloaded();
        }
        onAdReady();
        this.assetDownloadDurationMetric.markEnd();
        com.vungle.ads.internal.model.b bVar2 = this.advertisement;
        String strPlacementId = bVar2 != null ? bVar2.placementId() : null;
        com.vungle.ads.internal.model.b bVar3 = this.advertisement;
        String creativeId = bVar3 != null ? bVar3.getCreativeId() : null;
        com.vungle.ads.internal.model.b bVar4 = this.advertisement;
        com.vungle.ads.o.logMetric$vungle_ads_release$default(com.vungle.ads.o.INSTANCE, this.assetDownloadDurationMetric, strPlacementId, creativeId, bVar4 != null ? bVar4.eventId() : null, (String) null, 16, (Object) null);
    }

    protected abstract void requestAd();

    public final void setAdvertisement$vungle_ads_release(@Nullable com.vungle.ads.internal.model.b bVar) {
        this.advertisement = bVar;
    }

    /* JADX INFO: compiled from: BaseAdLoader.kt */
    public static final class b {

        @NotNull
        private final String description;

        @NotNull
        private final String descriptionExternal;
        private final boolean errorIsTerminal;
        private final int reason;

        public b(int i10, @NotNull String description, @NotNull String descriptionExternal, boolean z10) {
            t.i(description, "description");
            t.i(descriptionExternal, "descriptionExternal");
            this.reason = i10;
            this.description = description;
            this.descriptionExternal = descriptionExternal;
            this.errorIsTerminal = z10;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getDescriptionExternal() {
            return this.descriptionExternal;
        }

        public final boolean getErrorIsTerminal() {
            return this.errorIsTerminal;
        }

        public final int getReason() {
            return this.reason;
        }

        public /* synthetic */ b(int i10, String str, String str2, boolean z10, int i11, kotlin.jvm.internal.k kVar) {
            this(i10, str, (i11 & 4) != 0 ? str : str2, (i11 & 8) != 0 ? false : z10);
        }
    }
}

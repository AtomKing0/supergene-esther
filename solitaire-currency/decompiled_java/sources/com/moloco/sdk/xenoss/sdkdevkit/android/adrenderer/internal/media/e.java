package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.l;
import com.moloco.sdk.internal.t;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f19403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f19404c;

    public e(@NotNull Context appContext, @NotNull String cacheDir) {
        t.i(appContext, "appContext");
        t.i(cacheDir, "cacheDir");
        this.f19402a = appContext;
        this.f19403b = cacheDir;
        this.f19404c = "MediaCacheLocationProviderImpl";
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d
    @NotNull
    public com.moloco.sdk.internal.t<File, l> a() {
        try {
            File externalCacheDir = this.f19402a.getExternalCacheDir();
            if (externalCacheDir != null) {
                File file = new File(externalCacheDir, this.f19403b);
                file.mkdir();
                if (file.exists()) {
                    return new t.b(file);
                }
            }
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", null, false, 12, null);
            return new t.a(new l("Failed to create cache directory in external storage", 102));
        } catch (IOException e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e10, false, 8, null);
            return new t.a(new l("Failed to create cache directory in external storage", 101));
        } catch (SecurityException e11) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e11, false, 8, null);
            return new t.a(new l("Failed to create cache directory in external storage", 100));
        } catch (Exception e12) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e12, false, 8, null);
            return new t.a(new l("Failed to create cache directory in external storage", 200));
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d
    @NotNull
    public com.moloco.sdk.internal.t<File, l> b() {
        try {
            if (this.f19402a.getCacheDir() != null) {
                File file = new File(this.f19402a.getCacheDir(), this.f19403b);
                file.mkdir();
                if (file.exists()) {
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f19404c, "Able to write to internal storage cache directory", false, 4, null);
                    return new t.b(file);
                }
            }
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in internal storage", null, false, 12, null);
            return new t.a(new l("Failed to create cache directory in internal storage", 102));
        } catch (IOException e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e10, false, 8, null);
            return new t.a(new l("Failed to create cache directory in internal storage", 101));
        } catch (SecurityException e11) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e11, false, 8, null);
            return new t.a(new l("Failed to create cache directory in internal storage", 100));
        } catch (Exception e12) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19404c, "Failed to create cache directory in external storage", e12, false, 8, null);
            return new t.a(new l("Failed to create cache directory in internal storage", 200));
        }
    }
}

package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface q {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f13550a;

        public a(@NotNull String adFormat) {
            t.i(adFormat, "adFormat");
            this.f13550a = adFormat;
        }

        @Nullable
        public final IronSourceError a(@NotNull h loadParams) {
            t.i(loadParams, "loadParams");
            h.b bVar = (h.b) loadParams;
            if (bVar.f() == null) {
                return new IronSourceError(1060, this.f13550a + " was initialized and loaded without Activity");
            }
            if (bVar.g() == null) {
                return new IronSourceError(510, "Missing banner layout");
            }
            if (bVar.g().isDestroyed()) {
                return new IronSourceError(510, "Banner layout is destroyed");
            }
            ISBannerSize size = bVar.g().getSize();
            if (size == null) {
                return new IronSourceError(510, "Missing banner size");
            }
            if ("CUSTOM" == size.getDescription() && (size.getHeight() <= 0 || size.getWidth() <= 0)) {
                return new IronSourceError(510, "Unsupported banner size. Height and width must be bigger than 0");
            }
            if (bVar.c() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String strB = bVar.b();
            if ((strB == null || strB.length() == 0) && loadParams.d()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f13551a;

        public b(@NotNull String adFormat) {
            t.i(adFormat, "adFormat");
            this.f13551a = adFormat;
        }

        @Nullable
        public final IronSourceError a(@NotNull h.d loadParams) {
            t.i(loadParams, "loadParams");
            if (loadParams.e() == null) {
                return new IronSourceError(1060, this.f13551a + " was initialized and loaded without Activity");
            }
            if (loadParams.c() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String strB = loadParams.b();
            if ((strB == null || strB.length() == 0) && loadParams.d()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    @Nullable
    IronSourceError a();
}

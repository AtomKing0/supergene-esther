package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.Keep;
import java.net.URL;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public abstract class OTProxyType {

    @Keep
    public static final class AgeGateLogo extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AgeGateLogo(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ AgeGateLogo copy$default(AgeGateLogo ageGateLogo, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = ageGateLogo.url;
            }
            return ageGateLogo.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final AgeGateLogo copy(@NotNull URL url) {
            t.i(url, "url");
            return new AgeGateLogo(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AgeGateLogo) && t.d(this.url, ((AgeGateLogo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "AgeGateLogo(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class BannerLogo extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerLogo(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ BannerLogo copy$default(BannerLogo bannerLogo, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = bannerLogo.url;
            }
            return bannerLogo.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final BannerLogo copy(@NotNull URL url) {
            t.i(url, "url");
            return new BannerLogo(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BannerLogo) && t.d(this.url, ((BannerLogo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "BannerLogo(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class GoogleVendors extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoogleVendors(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ GoogleVendors copy$default(GoogleVendors googleVendors, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = googleVendors.url;
            }
            return googleVendors.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final GoogleVendors copy(@NotNull URL url) {
            t.i(url, "url");
            return new GoogleVendors(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GoogleVendors) && t.d(this.url, ((GoogleVendors) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "GoogleVendors(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class IABVendors extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IABVendors(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ IABVendors copy$default(IABVendors iABVendors, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = iABVendors.url;
            }
            return iABVendors.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final IABVendors copy(@NotNull URL url) {
            t.i(url, "url");
            return new IABVendors(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IABVendors) && t.d(this.url, ((IABVendors) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "IABVendors(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class LogConsent extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LogConsent(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ LogConsent copy$default(LogConsent logConsent, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = logConsent.url;
            }
            return logConsent.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final LogConsent copy(@NotNull URL url) {
            t.i(url, "url");
            return new LogConsent(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LogConsent) && t.d(this.url, ((LogConsent) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "LogConsent(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class PCLogo extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PCLogo(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ PCLogo copy$default(PCLogo pCLogo, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = pCLogo.url;
            }
            return pCLogo.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final PCLogo copy(@NotNull URL url) {
            t.i(url, "url");
            return new PCLogo(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PCLogo) && t.d(this.url, ((PCLogo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "PCLogo(url=" + this.url + ')';
        }
    }

    @Keep
    public static final class SDKDataDownload extends OTProxyType {

        @NotNull
        public final URL url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SDKDataDownload(@NotNull URL url) {
            super(null);
            t.i(url, "url");
            this.url = url;
        }

        public static /* synthetic */ SDKDataDownload copy$default(SDKDataDownload sDKDataDownload, URL url, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                url = sDKDataDownload.url;
            }
            return sDKDataDownload.copy(url);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final SDKDataDownload copy(@NotNull URL url) {
            t.i(url, "url");
            return new SDKDataDownload(url);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SDKDataDownload) && t.d(this.url, ((SDKDataDownload) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "SDKDataDownload(url=" + this.url + ')';
        }
    }

    private OTProxyType() {
    }

    public /* synthetic */ OTProxyType(k kVar) {
        this();
    }
}

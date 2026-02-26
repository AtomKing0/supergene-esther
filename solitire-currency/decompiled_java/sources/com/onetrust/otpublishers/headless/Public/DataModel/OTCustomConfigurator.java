package com.onetrust.otpublishers.headless.Public.DataModel;

import java.net.URL;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class OTCustomConfigurator {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static OTCustomConfigurator f21975b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public OTProxyManager f21976a;

    private OTCustomConfigurator() {
    }

    public /* synthetic */ OTCustomConfigurator(k kVar) {
        this();
    }

    public static final String access$getProxyDomainURL(OTCustomConfigurator oTCustomConfigurator, OTProxyType oTProxyType) {
        OTProxyManager oTProxyManager = oTCustomConfigurator.f21976a;
        URL proxyDomain = oTProxyManager != null ? oTProxyManager.getProxyDomain(oTProxyType) : null;
        if (proxyDomain != null) {
            String string = proxyDomain.toString();
            t.h(string, "proxyDomainURL.toString()");
            if (!(string.length() == 0)) {
                return string;
            }
        }
        return "";
    }

    @NotNull
    public static final String getProxyDomainURLString(@NotNull OTProxyType oTProxyType) {
        return Companion.getProxyDomainURLString(oTProxyType);
    }

    @Nullable
    public static final OTCustomConfigurator getSharedInstance() {
        return Companion.getSharedInstance();
    }

    public static final void setupProxyManager(@NotNull OTProxyManager oTProxyManager) {
        Companion.setupProxyManager(oTProxyManager);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final String getProxyDomainURLString(@NotNull OTProxyType proxyType) {
            t.i(proxyType, "proxyType");
            if (OTCustomConfigurator.f21975b == null) {
                return "";
            }
            OTCustomConfigurator oTCustomConfigurator = OTCustomConfigurator.f21975b;
            t.f(oTCustomConfigurator);
            return OTCustomConfigurator.access$getProxyDomainURL(oTCustomConfigurator, proxyType);
        }

        @Nullable
        public final OTCustomConfigurator getSharedInstance() {
            if (OTCustomConfigurator.f21975b == null) {
                OTCustomConfigurator.f21975b = new OTCustomConfigurator(null);
            }
            return OTCustomConfigurator.f21975b;
        }

        public final void setupProxyManager(@NotNull OTProxyManager manager) {
            t.i(manager, "manager");
            if (OTCustomConfigurator.f21975b == null) {
                OTCustomConfigurator.f21975b = new OTCustomConfigurator(null);
            }
            OTCustomConfigurator oTCustomConfigurator = OTCustomConfigurator.f21975b;
            if (oTCustomConfigurator == null) {
                return;
            }
            oTCustomConfigurator.f21976a = manager;
        }

        public static /* synthetic */ void getSharedInstance$annotations() {
        }
    }
}

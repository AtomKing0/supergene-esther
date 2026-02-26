package com.moloco.sdk.internal.services.bidtoken;

import android.os.Build;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import java.util.Locale;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f18415a = v8.n.a(C0327a.f18416g);

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.bidtoken.a$a, reason: collision with other inner class name */
    public static final class C0327a extends kotlin.jvm.internal.v implements h9.a<z> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0327a f18416g = new C0327a();

        public C0327a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final z invoke() {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "ServerBidTokenService", "Creating BidTokenService instance", null, false, 12, null);
            a.e eVar = a.e.f18889a;
            s7.a aVarA = com.moloco.sdk.internal.http.a.a(eVar.b().invoke(), eVar.f().invoke());
            k kVar = new k(2800L, 3, 200L);
            String language = Locale.getDefault().getLanguage();
            kotlin.jvm.internal.t.h(language, "getDefault().language");
            String RELEASE = Build.VERSION.RELEASE;
            kotlin.jvm.internal.t.h(RELEASE, "RELEASE");
            String str = Build.MANUFACTURER;
            String str2 = str == null ? "" : str;
            String str3 = Build.MODEL;
            String str4 = str3 == null ? "" : str3;
            String str5 = Build.HARDWARE;
            return new z(new e(BuildConfig.SDK_VERSION_NAME, aVarA, kVar, new h(language, RELEASE, str2, str4, str5 == null ? "" : str5)), p0.a(y2.b(null, 1, null).plus(com.moloco.sdk.internal.scheduling.c.a().getIo())), v.f18570a.a(new com.moloco.sdk.internal.bidtoken.c(), new com.moloco.sdk.internal.services.s()));
        }
    }

    public static final z b() {
        return (z) f18415a.getValue();
    }
}

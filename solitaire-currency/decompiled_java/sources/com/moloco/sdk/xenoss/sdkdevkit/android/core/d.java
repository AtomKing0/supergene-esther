package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import p9.q;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.moloco.sdk.xenoss.sdkdevkit.android.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f21670a = "WebBrowserUserAgentService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l f21671b = n.a(new a());

    public static final class a extends v implements h9.a<String> {
        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            try {
                String property = System.getProperty("http.agent");
                if (property != null && !q.z(property)) {
                    t.h(property, "{\n                userAgent\n            }");
                    return property;
                }
                return "";
            } catch (Exception e10) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.f21670a, e10.toString(), null, false, 12, null);
                return "";
            }
        }
    }

    public final String a() {
        return (String) this.f21671b.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.a
    @NotNull
    public String invoke() {
        return a();
    }
}

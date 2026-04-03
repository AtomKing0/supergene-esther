package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11575a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final JSONObject a(Context context) {
            try {
                return new JSONObject(IronSourceUtils.getLastResponse(context));
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        public final boolean b(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            x7 x7VarD = d(context);
            if (x7VarD.d().length() > 0) {
                if (x7VarD.e().length() > 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.ironsource.cr c(@org.jetbrains.annotations.NotNull android.content.Context r5) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.i(r5, r0)
                com.ironsource.x7 r0 = r4.d(r5)
                java.lang.String r1 = r0.d()
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L17
                r1 = r2
                goto L18
            L17:
                r1 = r3
            L18:
                if (r1 == 0) goto L2a
                java.lang.String r1 = r0.e()
                int r1 = r1.length()
                if (r1 <= 0) goto L26
                r1 = r2
                goto L27
            L26:
                r1 = r3
            L27:
                if (r1 == 0) goto L2a
                goto L2b
            L2a:
                r2 = r3
            L2b:
                r1 = 0
                if (r2 == 0) goto L2f
                goto L30
            L2f:
                r0 = r1
            L30:
                if (r0 == 0) goto L48
                com.ironsource.cr r1 = new com.ironsource.cr
                java.lang.String r2 = r0.d()
                java.lang.String r3 = r0.f()
                java.lang.String r0 = r0.e()
                r1.<init>(r5, r2, r3, r0)
                com.ironsource.cr$a r5 = com.ironsource.cr.a.CACHE
                r1.a(r5)
            L48:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ch.a.c(android.content.Context):com.ironsource.cr");
        }

        @NotNull
        public final x7 d(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            JSONObject jSONObjectA = a(context);
            String cachedAppKey = jSONObjectA.optString("appKey");
            String cachedUserId = jSONObjectA.optString("userId");
            String cachedSettings = jSONObjectA.optString("response");
            kotlin.jvm.internal.t.h(cachedAppKey, "cachedAppKey");
            kotlin.jvm.internal.t.h(cachedUserId, "cachedUserId");
            kotlin.jvm.internal.t.h(cachedSettings, "cachedSettings");
            return new x7(cachedAppKey, cachedUserId, cachedSettings);
        }
    }

    public static final boolean a(@NotNull Context context) {
        return f11575a.b(context);
    }

    @Nullable
    public static final cr b(@NotNull Context context) {
        return f11575a.c(context);
    }

    @NotNull
    public static final x7 c(@NotNull Context context) {
        return f11575a.d(context);
    }
}

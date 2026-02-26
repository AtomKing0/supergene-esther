package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.net.Uri;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.t;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f19586b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f19587a;

    @StabilityInferred(parameters = 0)
    public static final class a extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f19588c = new a();

        public a() {
            super("close", null);
        }
    }

    public static final class b {

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f19589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final String f19590b;

            public a(boolean z10, @NotNull String description) {
                kotlin.jvm.internal.t.i(description, "description");
                this.f19589a = z10;
                this.f19590b = description;
            }

            public final boolean a() {
                return this.f19589a;
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        public final com.moloco.sdk.internal.t<n, a> a(@Nullable String str) {
            Object objB;
            try {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(Uri.parse(str));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            Object objB2 = null;
            if (v8.t.g(objB)) {
                objB = null;
            }
            Uri uri = (Uri) objB;
            if (uri == null) {
                return new t.a(new a(false, "Invalid url: " + str));
            }
            if (!kotlin.jvm.internal.t.d(uri.getScheme(), "mraid")) {
                return new t.a(new a(false, "Non-mraid url scheme: " + str));
            }
            Map<String, String> mapD = d(uri);
            String host = uri.getHost();
            if (host != null) {
                switch (host.hashCode()) {
                    case -1289167206:
                        if (host.equals("expand")) {
                            objB2 = b(mapD);
                        }
                        break;
                    case -934437708:
                        if (host.equals("resize")) {
                            c();
                        }
                        break;
                    case 3417674:
                        if (host.equals("open")) {
                            objB2 = e(mapD);
                        }
                        break;
                    case 94756344:
                        if (host.equals("close")) {
                            objB2 = a.f19588c;
                        }
                        break;
                    case 133423073:
                        if (host.equals(com.vungle.ads.internal.presenter.l.SET_ORIENTATION_PROPERTIES)) {
                            objB2 = f(mapD);
                        }
                        break;
                }
            }
            if (objB2 != null) {
                return new t.b(objB2);
            }
            return new t.a(new a(true, "Unknown/unsupported mraid command " + uri.getHost()));
        }

        public final c b(Map<String, String> map) {
            Object objB;
            String str = map.get("url");
            Uri uri = null;
            if (str != null) {
                try {
                    t.a aVar = v8.t.f35208b;
                    objB = v8.t.b(Uri.parse(str));
                } catch (Throwable th) {
                    t.a aVar2 = v8.t.f35208b;
                    objB = v8.t.b(v8.u.a(th));
                }
                uri = (Uri) (v8.t.g(objB) ? null : objB);
            }
            return new c(uri);
        }

        public final e c() {
            return null;
        }

        public final Map<String, String> d(Uri uri) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String queryParam : uri.getQueryParameterNames()) {
                kotlin.jvm.internal.t.h(queryParam, "queryParam");
                String strJoin = TextUtils.join(",", uri.getQueryParameters(queryParam));
                kotlin.jvm.internal.t.h(strJoin, "join(\",\", getQueryParameters(queryParam))");
                linkedHashMap.put(queryParam, strJoin);
            }
            return linkedHashMap;
        }

        public final d e(Map<String, String> map) {
            Object objB;
            String str = map.get("url");
            if (str == null) {
                return null;
            }
            try {
                t.a aVar = v8.t.f35208b;
                Uri uri = Uri.parse(str);
                kotlin.jvm.internal.t.h(uri, "parse(rawOpenUrl)");
                objB = v8.t.b(new d(uri));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            return (d) (v8.t.g(objB) ? null : objB);
        }

        public final f f(Map<String, String> map) {
            Boolean boolA1;
            String str = map.get("allowOrientationChange");
            if (str == null || (boolA1 = p9.r.a1(str)) == null) {
                return null;
            }
            boolean zBooleanValue = boolA1.booleanValue();
            p pVarA = p.f19595a.a(map.get("forceOrientation"));
            if (pVarA == null) {
                return null;
            }
            return new f(zBooleanValue, pVarA);
        }

        public b() {
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f19591c;

        public c(@Nullable Uri uri) {
            super("expand", null);
            this.f19591c = uri;
        }

        @Nullable
        public final Uri b() {
            return this.f19591c;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class d extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final Uri f19592c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Uri uri) {
            super("open", null);
            kotlin.jvm.internal.t.i(uri, "uri");
            this.f19592c = uri;
        }

        @NotNull
        public final Uri b() {
            return this.f19592c;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class e extends n {
    }

    @StabilityInferred(parameters = 0)
    public static final class f extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f19593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final p f19594d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, @NotNull p forceOrientation) {
            super(com.vungle.ads.internal.presenter.l.SET_ORIENTATION_PROPERTIES, null);
            kotlin.jvm.internal.t.i(forceOrientation, "forceOrientation");
            this.f19593c = z10;
            this.f19594d = forceOrientation;
        }

        @NotNull
        public final p b() {
            return this.f19594d;
        }
    }

    public /* synthetic */ n(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    @NotNull
    public final String a() {
        return this.f19587a;
    }

    public n(String str) {
        this.f19587a = str;
    }
}

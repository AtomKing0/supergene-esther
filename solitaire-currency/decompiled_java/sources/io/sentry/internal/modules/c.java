package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.w0;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ManifestModulesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
@ApiStatus.Experimental
public final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Pattern f27926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Pattern f27927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ClassLoader f27928g;

    /* JADX INFO: compiled from: ManifestModulesLoader.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f27929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f27930b;

        public a(@NotNull String str, @NotNull String str2) {
            this.f27929a = str;
            this.f27930b = str2;
        }
    }

    public c(@NotNull w0 w0Var) {
        this(c.class.getClassLoader(), w0Var);
    }

    @Nullable
    private a d(@Nullable String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = this.f27927f.matcher(str);
        if (matcher.matches() && matcher.groupCount() == 2) {
            return new a(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    @NotNull
    private List<a> e() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f27928g.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                a aVarD = d(f(resources.nextElement()));
                if (aVarD != null) {
                    arrayList.add(aVarD);
                }
            }
        } catch (Throwable th) {
            this.f27932a.b(SentryLevel.ERROR, "Unable to detect modules via manifest files.", th);
        }
        return arrayList;
    }

    @Nullable
    private String f(@NotNull URL url) {
        Matcher matcher = this.f27926e.matcher(url.toString());
        if (matcher.matches() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        return null;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        HashMap map = new HashMap();
        for (a aVar : e()) {
            map.put(aVar.f27929a, aVar.f27930b);
        }
        return map;
    }

    c(@Nullable ClassLoader classLoader, @NotNull w0 w0Var) {
        super(w0Var);
        this.f27926e = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.f27927f = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.f27928g = io.sentry.util.b.a(classLoader);
    }
}

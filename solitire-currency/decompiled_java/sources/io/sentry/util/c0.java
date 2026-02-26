package io.sentry.util;

import io.sentry.k7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpanUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f28340a = new ConcurrentHashMap();

    @NotNull
    public static List<String> a(@NotNull k7 k7Var) {
        ArrayList arrayList = new ArrayList();
        k7 k7Var2 = k7.AGENT;
        if (k7Var2 == k7Var || k7.AGENTLESS_SPRING == k7Var) {
            arrayList.add("auto.http.spring_jakarta.webmvc");
            arrayList.add("auto.http.spring.webmvc");
            arrayList.add("auto.spring_jakarta.webflux");
            arrayList.add("auto.spring.webflux");
            arrayList.add("auto.db.jdbc");
            arrayList.add("auto.http.spring_jakarta.webclient");
            arrayList.add("auto.http.spring.webclient");
            arrayList.add("auto.http.spring_jakarta.restclient");
            arrayList.add("auto.http.spring.restclient");
            arrayList.add("auto.http.spring_jakarta.resttemplate");
            arrayList.add("auto.http.spring.resttemplate");
            arrayList.add("auto.http.openfeign");
        }
        if (k7Var2 == k7Var) {
            arrayList.add("auto.graphql.graphql");
            arrayList.add("auto.graphql.graphql22");
        }
        return arrayList;
    }

    @ApiStatus.Internal
    public static boolean b(@Nullable List<io.sentry.j0> list, @Nullable String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Map<String, Boolean> map = f28340a;
            if (map.containsKey(str)) {
                return map.get(str).booleanValue();
            }
            Iterator<io.sentry.j0> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a().equalsIgnoreCase(str)) {
                    f28340a.put(str, Boolean.TRUE);
                    return true;
                }
            }
            Iterator<io.sentry.j0> it2 = list.iterator();
            while (it2.hasNext()) {
                try {
                    if (it2.next().b(str)) {
                        f28340a.put(str, Boolean.TRUE);
                        return true;
                    }
                    continue;
                } catch (Throwable unused) {
                }
            }
            f28340a.put(str, Boolean.FALSE);
        }
        return false;
    }
}

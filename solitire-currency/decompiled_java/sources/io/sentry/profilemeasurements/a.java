package io.sentry.profilemeasurements;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.profilemeasurements.b;
import io.sentry.protocol.MeasurementValue;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfileMeasurement.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f28068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private Collection<b> f28069c;

    /* JADX INFO: renamed from: io.sentry.profilemeasurements.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProfileMeasurement.java */
    public static final class C0585a implements x1<a> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("values")) {
                    List listD0 = l3Var.D0(w0Var, new b.a());
                    if (listD0 != null) {
                        aVar.f28069c = listD0;
                    }
                } else if (strC.equals(MeasurementValue.JsonKeys.UNIT)) {
                    String strO0 = l3Var.o0();
                    if (strO0 != null) {
                        aVar.f28068b = strO0;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            aVar.c(concurrentHashMap);
            l3Var.k();
            return aVar;
        }
    }

    public a() {
        this("unknown", new ArrayList());
    }

    public void c(@Nullable Map<String, Object> map) {
        this.f28067a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return w.a(this.f28067a, aVar.f28067a) && this.f28068b.equals(aVar.f28068b) && new ArrayList(this.f28069c).equals(new ArrayList(aVar.f28069c));
    }

    public int hashCode() {
        return w.b(this.f28067a, this.f28068b, this.f28069c);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(MeasurementValue.JsonKeys.UNIT).o(w0Var, this.f28068b);
        m3Var.e("values").o(w0Var, this.f28069c);
        Map<String, Object> map = this.f28067a;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28067a.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public a(@NotNull String str, @NotNull Collection<b> collection) {
        this.f28068b = str;
        this.f28069c = collection;
    }
}

package ea;

import ea.u;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonNamesMap.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final u.a<Map<String, Integer>> f25415a = new u.a<>();

    /* JADX INFO: compiled from: JsonNamesMap.kt */
    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.a<Map<String, ? extends Integer>> {
        a(Object obj) {
            super(0, obj, b0.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Map<String, Integer> invoke() {
            return b0.a((SerialDescriptor) this.receiver);
        }
    }

    @NotNull
    public static final Map<String, Integer> a(@NotNull SerialDescriptor serialDescriptor) {
        String[] strArrNames;
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        int iD = serialDescriptor.d();
        Map<String, Integer> mapA = null;
        for (int i10 = 0; i10 < iD; i10++) {
            List<Annotation> listF = serialDescriptor.f(i10);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                if (obj instanceof kotlinx.serialization.json.p) {
                    arrayList.add(obj);
                }
            }
            kotlinx.serialization.json.p pVar = (kotlinx.serialization.json.p) kotlin.collections.d0.F0(arrayList);
            if (pVar != null && (strArrNames = pVar.names()) != null) {
                for (String str : strArrNames) {
                    if (mapA == null) {
                        mapA = t.a(serialDescriptor.d());
                    }
                    kotlin.jvm.internal.t.f(mapA);
                    b(mapA, serialDescriptor, str, i10);
                }
            }
        }
        return mapA == null ? kotlin.collections.r0.g() : mapA;
    }

    private static final void b(Map<String, Integer> map, SerialDescriptor serialDescriptor, String str, int i10) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i10));
            return;
        }
        throw new z("The suggested name '" + str + "' for property " + serialDescriptor.e(i10) + " is already one of the names for property " + serialDescriptor.e(((Number) kotlin.collections.r0.h(map, str)).intValue()) + " in " + serialDescriptor);
    }

    @NotNull
    public static final u.a<Map<String, Integer>> c() {
        return f25415a;
    }

    public static final int d(@NotNull SerialDescriptor serialDescriptor, @NotNull kotlinx.serialization.json.a json, @NotNull String name) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(name, "name");
        int iC = serialDescriptor.c(name);
        if (iC != -3 || !json.e().j()) {
            return iC;
        }
        Integer num = (Integer) ((Map) kotlinx.serialization.json.u.a(json).b(serialDescriptor, f25415a, new a(serialDescriptor))).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int e(@NotNull SerialDescriptor serialDescriptor, @NotNull kotlinx.serialization.json.a json, @NotNull String name, @NotNull String suffix) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(suffix, "suffix");
        int iD = d(serialDescriptor, json, name);
        if (iD != -3) {
            return iD;
        }
        throw new z9.i(serialDescriptor.h() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int f(SerialDescriptor serialDescriptor, kotlinx.serialization.json.a aVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return e(serialDescriptor, aVar, str, str2);
    }
}

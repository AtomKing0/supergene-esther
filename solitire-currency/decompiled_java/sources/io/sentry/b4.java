package io.sentry;

import io.sentry.protocol.TransactionInfo;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.a;
import io.sentry.rrweb.d;
import io.sentry.rrweb.e;
import io.sentry.rrweb.f;
import io.sentry.rrweb.g;
import io.sentry.rrweb.h;
import io.sentry.rrweb.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplayRecording.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b4 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Integer f27590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private List<? extends io.sentry.rrweb.b> f27591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27592c;

    /* JADX INFO: compiled from: ReplayRecording.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f27594b;

        static {
            int[] iArr = new int[io.sentry.rrweb.c.values().length];
            f27594b = iArr;
            try {
                iArr[io.sentry.rrweb.c.IncrementalSnapshot.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27594b[io.sentry.rrweb.c.Meta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27594b[io.sentry.rrweb.c.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f27593a = iArr2;
            try {
                iArr2[d.b.MouseInteraction.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27593a[d.b.TouchMove.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: ReplayRecording.java */
    public static final class b implements x1<b4> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b4 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            b4 b4Var = new b4();
            l3Var.h();
            ArrayList arrayList = null;
            HashMap map = null;
            Integer numG0 = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("segment_id")) {
                    numG0 = l3Var.g0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            l3Var.k();
            l3Var.j(true);
            List list = (List) l3Var.A0();
            l3Var.j(false);
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        io.sentry.util.u uVar = new io.sentry.util.u(map2);
                        for (Map.Entry entry : map2.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (str.equals("type")) {
                                io.sentry.rrweb.c cVar = io.sentry.rrweb.c.values()[((Integer) value).intValue()];
                                int i10 = a.f27594b[cVar.ordinal()];
                                if (i10 == 1) {
                                    Map mapEmptyMap = (Map) map2.get("data");
                                    if (mapEmptyMap == null) {
                                        mapEmptyMap = Collections.emptyMap();
                                    }
                                    Integer num = (Integer) mapEmptyMap.get(TransactionInfo.JsonKeys.SOURCE);
                                    if (num != null) {
                                        d.b bVar = d.b.values()[num.intValue()];
                                        int i11 = a.f27593a[bVar.ordinal()];
                                        if (i11 == 1) {
                                            arrayList.add(new e.a().deserialize(uVar, w0Var));
                                        } else if (i11 != 2) {
                                            w0Var.c(SentryLevel.DEBUG, "Unsupported rrweb incremental snapshot type %s", bVar);
                                        } else {
                                            arrayList.add(new f.a().deserialize(uVar, w0Var));
                                        }
                                    }
                                } else if (i10 == 2) {
                                    arrayList.add(new g.a().deserialize(uVar, w0Var));
                                } else if (i10 != 3) {
                                    w0Var.c(SentryLevel.DEBUG, "Unsupported rrweb event type %s", cVar);
                                } else {
                                    Map mapEmptyMap2 = (Map) map2.get("data");
                                    if (mapEmptyMap2 == null) {
                                        mapEmptyMap2 = Collections.emptyMap();
                                    }
                                    String str2 = (String) mapEmptyMap2.get(ViewHierarchyNode.JsonKeys.TAG);
                                    if (str2 != null) {
                                        switch (str2) {
                                            case "performanceSpan":
                                                arrayList.add(new h.a().deserialize(uVar, w0Var));
                                                break;
                                            case "video":
                                                arrayList.add(new i.a().deserialize(uVar, w0Var));
                                                break;
                                            case "breadcrumb":
                                                arrayList.add(new a.C0586a().deserialize(uVar, w0Var));
                                                break;
                                            default:
                                                w0Var.c(SentryLevel.DEBUG, "Unsupported rrweb event type %s", cVar);
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            b4Var.b(numG0);
            b4Var.a(arrayList);
            b4Var.c(map);
            return b4Var;
        }
    }

    public void a(@Nullable List<? extends io.sentry.rrweb.b> list) {
        this.f27591b = list;
    }

    public void b(@Nullable Integer num) {
        this.f27590a = num;
    }

    public void c(@Nullable Map<String, Object> map) {
        this.f27592c = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b4.class != obj.getClass()) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return io.sentry.util.w.a(this.f27590a, b4Var.f27590a) && io.sentry.util.w.a(this.f27591b, b4Var.f27591b);
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f27590a, this.f27591b);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f27590a != null) {
            m3Var.e("segment_id").n(this.f27590a);
        }
        Map<String, Object> map = this.f27592c;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27592c.get(str));
            }
        }
        m3Var.k();
        m3Var.j(true);
        if (this.f27590a != null) {
            m3Var.l("\n");
        }
        List<? extends io.sentry.rrweb.b> list = this.f27591b;
        if (list != null) {
            m3Var.o(w0Var, list);
        }
        m3Var.j(false);
    }
}

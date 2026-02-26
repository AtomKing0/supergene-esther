package com.moloco.sdk.acm.eventprocessing;

import com.moloco.sdk.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final e f17369a;

    /* JADX INFO: renamed from: com.moloco.sdk.acm.eventprocessing.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0290a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17370a;

        static {
            int[] iArr = new int[com.moloco.sdk.acm.db.c.values().length];
            try {
                iArr[com.moloco.sdk.acm.db.c.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.acm.db.c.TIMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17370a = iArr;
        }
    }

    public a(@NotNull e dataAgeChecker) {
        t.i(dataAgeChecker, "dataAgeChecker");
        this.f17369a = dataAgeChecker;
    }

    @NotNull
    public com.moloco.sdk.acm.http.d a(@NotNull List<com.moloco.sdk.acm.db.b> events) {
        t.i(events, "events");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.moloco.sdk.acm.db.b bVar : events) {
            if (!this.f17369a.a(bVar)) {
                int i10 = C0290a.f17370a[bVar.b().ordinal()];
                if (i10 == 1) {
                    k.b.a aVarB = k.b.g().d(bVar.d()).b(bVar.e());
                    Long lA = bVar.a();
                    if (lA != null) {
                        aVarB.c((int) lA.longValue());
                    }
                    k.b bVarBuild = aVarB.build();
                    t.h(bVarBuild, "metric.build()");
                    arrayList2.add(bVarBuild);
                } else if (i10 == 2) {
                    k.c.a aVarB2 = k.c.g().d(bVar.d()).b(bVar.e());
                    Long lA2 = bVar.a();
                    if (lA2 != null) {
                        aVarB2.c(lA2.longValue());
                    }
                    k.c cVarBuild = aVarB2.build();
                    t.h(cVarBuild, "metric.build()");
                    arrayList.add(cVarBuild);
                }
            }
        }
        return new com.moloco.sdk.acm.http.d(arrayList2, arrayList);
    }
}

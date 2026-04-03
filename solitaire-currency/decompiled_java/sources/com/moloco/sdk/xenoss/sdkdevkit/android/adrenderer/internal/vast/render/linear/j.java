package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.collections.z;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class j {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public static final a f21411p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21412q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f21413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f21414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final List<String> f21415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final List<String> f21416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final List<String> f21417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final List<String> f21418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final List<String> f21419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final List<String> f21420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public List<String> f21421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i f21422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final n f21423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a> f21424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final List<l> f21426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21427o;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final j a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h linearTracking, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
            t.i(linearTracking, "linearTracking");
            t.i(customUserEventBuilderService, "customUserEventBuilderService");
            return new j(customUserEventBuilderService, linearTracking.a(), linearTracking.d(), linearTracking.m(), linearTracking.e(), linearTracking.f(), linearTracking.n(), linearTracking.c(), linearTracking.g(), linearTracking.o(), linearTracking.h(), linearTracking.j(), linearTracking.k(), linearTracking.l(), linearTracking.b(), linearTracking.i(), null, null, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, null);
        }

        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Long.valueOf(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a) t10).a()), Long.valueOf(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a) t11).a()));
        }
    }

    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Integer.valueOf(((l) t10).a()), Integer.valueOf(((l) t11).a()));
        }
    }

    public j(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable List<String> list5, @Nullable List<String> list6, @Nullable List<String> list7, @Nullable List<String> list8, @Nullable List<String> list9, @Nullable List<String> list10, @Nullable List<String> list11, @Nullable List<String> list12, @Nullable List<String> list13, @Nullable List<String> list14, @Nullable List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g> list15, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i buttonTracker, @NotNull n vastTracker) {
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(buttonTracker, "buttonTracker");
        t.i(vastTracker, "vastTracker");
        this.f21413a = customUserEventBuilderService;
        this.f21414b = list;
        this.f21415c = list8;
        this.f21416d = list9;
        this.f21417e = list10;
        this.f21418f = list11;
        this.f21419g = list12;
        this.f21420h = list13;
        this.f21421i = list14;
        this.f21422j = buttonTracker;
        this.f21423k = vastTracker;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList(w.v(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a((String) it.next(), 0L));
            }
            arrayList.addAll(arrayList3);
        }
        if (list3 != null) {
            ArrayList arrayList4 = new ArrayList(w.v(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a((String) it2.next(), 0L));
            }
            arrayList.addAll(arrayList4);
        }
        if (list4 != null) {
            ArrayList arrayList5 = new ArrayList(w.v(list4, 10));
            Iterator<T> it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(new l((String) it3.next(), 25));
            }
            arrayList2.addAll(arrayList5);
        }
        if (list5 != null) {
            ArrayList arrayList6 = new ArrayList(w.v(list5, 10));
            Iterator<T> it4 = list5.iterator();
            while (it4.hasNext()) {
                arrayList6.add(new l((String) it4.next(), 50));
            }
            arrayList2.addAll(arrayList6);
        }
        if (list6 != null) {
            ArrayList arrayList7 = new ArrayList(w.v(list6, 10));
            Iterator<T> it5 = list6.iterator();
            while (it5.hasNext()) {
                arrayList7.add(new l((String) it5.next(), 75));
            }
            arrayList2.addAll(arrayList7);
        }
        if (list7 != null) {
            ArrayList arrayList8 = new ArrayList(w.v(list7, 10));
            Iterator<T> it6 = list7.iterator();
            while (it6.hasNext()) {
                arrayList8.add(new l((String) it6.next(), 100));
            }
            arrayList2.addAll(arrayList8);
        }
        if (list15 != null) {
            for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g gVar : list15) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t tVarA = gVar.a();
                if (tVarA instanceof t.b) {
                    arrayList.add(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a(gVar.b(), ((t.b) gVar.a()).a()));
                } else if (tVarA instanceof t.a) {
                    arrayList2.add(new l(gVar.b(), ((t.a) gVar.a()).a()));
                }
            }
        }
        if (arrayList.size() > 1) {
            z.A(arrayList, new b());
        }
        this.f21424l = arrayList;
        if (arrayList2.size() > 1) {
            z.A(arrayList2, new c());
        }
        this.f21426n = arrayList2;
    }

    public final void a(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        this.f21422j.j(buttonType);
    }

    public final void b(@NotNull a.AbstractC0481a.c button) {
        kotlin.jvm.internal.t.i(button, "button");
        this.f21422j.g(button);
    }

    public final void c(@NotNull a.AbstractC0481a.f lastClickPosition, @Nullable Integer num, @Nullable String str) {
        kotlin.jvm.internal.t.i(lastClickPosition, "lastClickPosition");
        List<String> list = this.f21414b;
        if (list != null) {
            this.f21423k.b(list, null, num, str, this.f21422j.p(), this.f21413a, lastClickPosition);
            this.f21414b = null;
        }
    }

    public final void d(@Nullable String str, int i10, int i11) {
        double d10 = (((double) i10) / ((double) i11)) * ((double) 100);
        List<l> list = this.f21426n;
        List<l> listSubList = list.subList(this.f21427o, list.size());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSubList) {
            if (((l) obj).a() > d10) {
                break;
            } else {
                arrayList.add(obj);
            }
        }
        n nVar = this.f21423k;
        ArrayList arrayList2 = new ArrayList(w.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((l) it.next()).b());
        }
        nVar.a(arrayList2, null, Integer.valueOf(i10), str);
        this.f21427o += arrayList.size();
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a> list2 = this.f21424l;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a> listSubList2 = list2.subList(this.f21425m, list2.size());
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listSubList2) {
            if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a) obj2).a() > i10) {
                break;
            } else {
                arrayList3.add(obj2);
            }
        }
        n nVar2 = this.f21423k;
        ArrayList arrayList4 = new ArrayList(w.v(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.a) it2.next()).b());
        }
        nVar2.a(arrayList4, null, Integer.valueOf(i10), str);
        this.f21425m += arrayList3.size();
    }

    public final void e(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21415c;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public final void f(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21417e;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public final void g(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21418f;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public final void h(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21419g;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public final void i(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21420h;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public final void j(@Nullable Integer num, @Nullable String str) {
        List<String> list = this.f21416d;
        if (list != null) {
            this.f21423k.a(list, null, num, str);
        }
    }

    public /* synthetic */ j(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, List list12, List list13, List list14, List list15, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i iVar, n nVar, int i10, kotlin.jvm.internal.k kVar) {
        this(aVar, list, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, (i10 & 65536) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a() : iVar, (i10 & 131072) != 0 ? p.a() : nVar);
    }
}

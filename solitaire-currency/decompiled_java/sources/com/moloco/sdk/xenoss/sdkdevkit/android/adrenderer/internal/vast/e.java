package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import androidx.media3.common.MimeTypes;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final c f20127i = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k f20128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h f20129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f f20130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n f20131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final d0 f20132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final s7.a f20133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m f20134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f20135h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> f20136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final List<String> f20137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> f20138c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> impressions, @NotNull List<String> errorUrls, @NotNull List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> creativesPerWrapper) {
            t.i(impressions, "impressions");
            t.i(errorUrls, "errorUrls");
            t.i(creativesPerWrapper, "creativesPerWrapper");
            this.f20136a = impressions;
            this.f20137b = errorUrls;
            this.f20138c = creativesPerWrapper;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = aVar.f20136a;
            }
            if ((i10 & 2) != 0) {
                list2 = aVar.f20137b;
            }
            if ((i10 & 4) != 0) {
                list3 = aVar.f20138c;
            }
            return aVar.b(list, list2, list3);
        }

        @NotNull
        public final a b(@NotNull List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> impressions, @NotNull List<String> errorUrls, @NotNull List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> creativesPerWrapper) {
            t.i(impressions, "impressions");
            t.i(errorUrls, "errorUrls");
            t.i(creativesPerWrapper, "creativesPerWrapper");
            return new a(impressions, errorUrls, creativesPerWrapper);
        }

        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> c() {
            return this.f20138c;
        }

        @NotNull
        public final List<String> d() {
            return this.f20137b;
        }

        @NotNull
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> e() {
            return this.f20136a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.d(this.f20136a, aVar.f20136a) && t.d(this.f20137b, aVar.f20137b) && t.d(this.f20138c, aVar.f20138c);
        }

        public int hashCode() {
            return (((this.f20136a.hashCode() * 31) + this.f20137b.hashCode()) * 31) + this.f20138c.hashCode();
        }

        @NotNull
        public String toString() {
            return "AggregatedWrapperChainAdData(impressions=" + this.f20136a + ", errorUrls=" + this.f20137b + ", creativesPerWrapper=" + this.f20138c + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final List<w> f20139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a f20140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n>> f20141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> f20142d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<w> linearTrackingList, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a aVar, @NotNull List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n>> iconsPerWrapper, @NotNull List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> companionsPerWrapper) {
            t.i(linearTrackingList, "linearTrackingList");
            t.i(iconsPerWrapper, "iconsPerWrapper");
            t.i(companionsPerWrapper, "companionsPerWrapper");
            this.f20139a = linearTrackingList;
            this.f20140b = aVar;
            this.f20141c = iconsPerWrapper;
            this.f20142d = companionsPerWrapper;
        }

        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> a() {
            return this.f20142d;
        }

        @NotNull
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n>> b() {
            return this.f20141c;
        }

        @NotNull
        public final List<w> c() {
            return this.f20139a;
        }

        @Nullable
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a d() {
            return this.f20140b;
        }
    }

    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h b(List<w> list, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a aVar) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                x xVarA = ((w) obj).a();
                Object arrayList = linkedHashMap.get(xVarA);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(xVarA, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h(e(aVar), i(linkedHashMap, x.CreativeView), i(linkedHashMap, x.Start), i(linkedHashMap, x.FirstQuartile), i(linkedHashMap, x.Midpoint), i(linkedHashMap, x.ThirdQuartile), i(linkedHashMap, x.Complete), i(linkedHashMap, x.Mute), i(linkedHashMap, x.UnMute), i(linkedHashMap, x.Pause), i(linkedHashMap, x.Resume), i(linkedHashMap, x.Rewind), i(linkedHashMap, x.Skip), i(linkedHashMap, x.CloseLinear), h(linkedHashMap));
        }

        public final List<String> e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a aVar) {
            List<b0> listB;
            if (aVar == null || (listB = aVar.b()) == null) {
                return v.l();
            }
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((b0) it.next()).a());
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> List<T> f(List<? extends T> list, T t10) {
            List<T> listG;
            return (t10 == null || (listG = e.f20127i.g(list, u.e(t10))) == null) ? list == 0 ? v.l() : list : listG;
        }

        public final <T> List<T> g(List<? extends T> list, List<? extends T> list2) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                a0.B(arrayList, list);
            }
            if (list2 != null) {
                a0.B(arrayList, list2);
            }
            return arrayList;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g> h(Map<x, ? extends List<w>> map) {
            List<w> list = map.get(x.Progress);
            if (list == null) {
                return v.l();
            }
            ArrayList arrayList = new ArrayList();
            for (w wVar : list) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g gVar = wVar.b() == null ? null : new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g(wVar.c(), wVar.b());
                if (gVar != null) {
                    arrayList.add(gVar);
                }
            }
            return arrayList;
        }

        public final List<String> i(Map<x, ? extends List<w>> map, x xVar) {
            List<w> list = map.get(xVar);
            if (list == null) {
                return v.l();
            }
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((w) it.next()).c());
            }
            return arrayList;
        }

        public final <T> Set<T> k(Set<? extends T> set, T t10) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                a0.B(linkedHashSet, set);
            }
            if (t10 != null) {
                linkedHashSet.add(t10);
            }
            return linkedHashSet;
        }

        public final boolean q(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar) {
            String strA = gVar.a();
            return !(strA == null || p9.q.z(strA));
        }

        public final boolean r(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i iVar) {
            String strA = iVar.a();
            return !(strA == null || p9.q.z(strA));
        }

        public final boolean s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n nVar) {
            String strA = nVar.a();
            return !(strA == null || p9.q.z(strA));
        }

        public final boolean t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s sVar) {
            String strA = sVar.a();
            return !(strA == null || p9.q.z(strA));
        }

        public final boolean u(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return t.d(lowerCase, MimeTypes.VIDEO_MP4) || t.d(lowerCase, MimeTypes.VIDEO_H263) || t.d(lowerCase, "video/webm");
        }

        public c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final Set<String> f20144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f20145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final a f20146d;

        public d(int i10, @NotNull Set<String> usedVastAdTagUrls, boolean z10, @NotNull a aggregatedWrapperChainData) {
            t.i(usedVastAdTagUrls, "usedVastAdTagUrls");
            t.i(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            this.f20143a = i10;
            this.f20144b = usedVastAdTagUrls;
            this.f20145c = z10;
            this.f20146d = aggregatedWrapperChainData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ d b(d dVar, int i10, Set set, boolean z10, a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = dVar.f20143a;
            }
            if ((i11 & 2) != 0) {
                set = dVar.f20144b;
            }
            if ((i11 & 4) != 0) {
                z10 = dVar.f20145c;
            }
            if ((i11 & 8) != 0) {
                aVar = dVar.f20146d;
            }
            return dVar.a(i10, set, z10, aVar);
        }

        @NotNull
        public final d a(int i10, @NotNull Set<String> usedVastAdTagUrls, boolean z10, @NotNull a aggregatedWrapperChainData) {
            t.i(usedVastAdTagUrls, "usedVastAdTagUrls");
            t.i(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            return new d(i10, usedVastAdTagUrls, z10, aggregatedWrapperChainData);
        }

        @NotNull
        public final a c() {
            return this.f20146d;
        }

        public final boolean d() {
            return this.f20145c;
        }

        @NotNull
        public final Set<String> e() {
            return this.f20144b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f20143a == dVar.f20143a && t.d(this.f20144b, dVar.f20144b) && this.f20145c == dVar.f20145c && t.d(this.f20146d, dVar.f20146d);
        }

        public final int f() {
            return this.f20143a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = ((this.f20143a * 31) + this.f20144b.hashCode()) * 31;
            boolean z10 = this.f20145c;
            ?? r12 = z10;
            if (z10) {
                r12 = 1;
            }
            return ((iHashCode + r12) * 31) + this.f20146d.hashCode();
        }

        @NotNull
        public String toString() {
            return "WrapperChainParams(wrapperDepth=" + this.f20143a + ", usedVastAdTagUrls=" + this.f20144b + ", followAdditionalWrappers=" + this.f20145c + ", aggregatedWrapperChainData=" + this.f20146d + ')';
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$e, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {152, 163}, m = "invoke")
    public static final class C0424e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20147j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20148k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f20149l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f20150m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f20152o;

        public C0424e(z8.d<? super C0424e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20150m = obj;
            this.f20152o |= Integer.MIN_VALUE;
            return e.this.a(null, null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$invoke$renderAdResult$1", f = "VastAdLoader.kt", l = {164}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20153j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ y f20155l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f20156m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f20157n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(y yVar, boolean z10, String str, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f20155l = yVar;
            this.f20156m = z10;
            this.f20157n = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new f(this.f20155l, this.f20156m, this.f20157n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20153j;
            if (i10 == 0) {
                v8.u.b(obj);
                e eVar = e.this;
                y yVar = this.f20155l;
                double dX = eVar.x();
                com.moloco.sdk.common_adapter_internal.a aVarInvoke = e.this.f20134g.invoke();
                boolean z10 = this.f20156m;
                String str = this.f20157n;
                this.f20153j = 1;
                obj = eVar.v(yVar, null, dX, aVarInvoke, z10, str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {802, 356, 367}, m = "loadAndParseWrapperVastDocument")
    public static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20158j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20159k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20160l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20162n;

        public g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20160l = obj;
            this.f20162n |= Integer.MIN_VALUE;
            return e.this.s(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {418}, m = "tryLoadInLineRenderAd")
    public static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20163j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20164k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20165l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20166m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20167n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20168o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20169p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20170q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f20171r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Object f20172s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Object f20173t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Object f20174u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public double f20175v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f20176w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public /* synthetic */ Object f20177x;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f20179z;

        public h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20177x = obj;
            this.f20179z |= Integer.MIN_VALUE;
            return e.this.t(null, null, 0.0d, null, false, null, this);
        }
    }

    public static final class i extends kotlin.jvm.internal.v implements h9.l<List<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.common_adapter_internal.a f20181h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(com.moloco.sdk.common_adapter_internal.a aVar) {
            super(1);
            this.f20181h = aVar;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c invoke(@NotNull List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> it) {
            t.i(it, "it");
            return e.this.j(it, this.f20181h);
        }
    }

    public static final class j extends kotlin.jvm.internal.v implements h9.l<List<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e> {
        public j() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e invoke(@NotNull List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> it) {
            t.i(it, "it");
            return e.this.l(it);
        }
    }

    public static final class k extends kotlin.jvm.internal.v implements h9.a<b> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f20184h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar) {
            super(0);
            this.f20184h = aVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return e.this.e(this.f20184h);
        }
    }

    public static final class l implements s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f20185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f20186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f20187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ double f20188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.common_adapter_internal.a f20189e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f20190f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ n0 f20192h;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f20193a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f20194b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ d f20195c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ double f20196d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.common_adapter_internal.a f20197e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f20198f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f20199g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ n0 f20200h;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$l$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryLoadVastRenderAd$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", l = {227, 238, 258}, m = "emit")
            public static final class C0425a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f20201j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f20202k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public Object f20203l;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public Object f20205n;

                public C0425a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f20201j = obj;
                    this.f20202k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar, e eVar, d dVar, double d10, com.moloco.sdk.common_adapter_internal.a aVar, boolean z10, String str, n0 n0Var) {
                this.f20193a = iVar;
                this.f20194b = eVar;
                this.f20195c = dVar;
                this.f20196d = d10;
                this.f20197e = aVar;
                this.f20198f = z10;
                this.f20199g = str;
                this.f20200h = n0Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r24, @org.jetbrains.annotations.NotNull z8.d r25) {
                /*
                    Method dump skipped, instruction units count: 351
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.l.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public l(s9.h hVar, e eVar, d dVar, double d10, com.moloco.sdk.common_adapter_internal.a aVar, boolean z10, String str, n0 n0Var) {
            this.f20185a = hVar;
            this.f20186b = eVar;
            this.f20187c = dVar;
            this.f20188d = d10;
            this.f20189e = aVar;
            this.f20190f = z10;
            this.f20191g = str;
            this.f20192h = n0Var;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f20185a.collect(new a(iVar, this.f20186b, this.f20187c, this.f20188d, this.f20189e, this.f20190f, this.f20191g, this.f20192h), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    public static final class m<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b) t10).b(), ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b) t11).b());
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {280}, m = "tryLoadVastRenderAd")
    public static final class n extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20206j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20207k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20208l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20210n;

        public n(z8.d<? super n> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20208l = obj;
            this.f20210n |= Integer.MIN_VALUE;
            return e.this.v(null, null, 0.0d, null, false, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {311, 328}, m = "tryLoadWrapperRenderAd")
    public static final class o extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20211j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20212k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20213l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20214m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20215n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20216o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f20217p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f20218q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f20219r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public /* synthetic */ Object f20220s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f20222u;

        public o(z8.d<? super o> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20220s = obj;
            this.f20222u |= Integer.MIN_VALUE;
            return e.this.r(null, null, 0.0d, null, false, null, this);
        }
    }

    public static final class p implements s9.h<v8.s<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s, ? extends File>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f20223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f20225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f20226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ n0 f20227e;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f20228a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f20229b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f20230c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f20231d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ n0 f20232e;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$p$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryPrepareInLineRenderLinear$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", l = {226, 244, 252}, m = "emit")
            public static final class C0426a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f20233j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f20234k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public Object f20235l;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public Object f20237n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                public Object f20238o;

                public C0426a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f20233j = obj;
                    this.f20234k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar, boolean z10, e eVar, String str, n0 n0Var) {
                this.f20228a = iVar;
                this.f20229b = z10;
                this.f20230c = eVar;
                this.f20231d = str;
                this.f20232e = n0Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r9, @org.jetbrains.annotations.NotNull z8.d r10) {
                /*
                    Method dump skipped, instruction units count: 270
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.p.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public p(s9.h hVar, boolean z10, e eVar, String str, n0 n0Var) {
            this.f20223a = hVar;
            this.f20224b = z10;
            this.f20225c = eVar;
            this.f20226d = str;
            this.f20227e = n0Var;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super v8.s<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s, ? extends File>> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f20223a.collect(new a(iVar, this.f20224b, this.f20225c, this.f20226d, this.f20227e), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {565}, m = "tryPrepareInLineRenderLinear")
    public static final class q extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20239j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20240k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20241l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20242m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20243n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public /* synthetic */ Object f20244o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f20246q;

        public q(z8.d<? super q> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20244o = obj;
            this.f20246q |= Integer.MIN_VALUE;
            return e.this.u(null, null, null, null, 0.0d, null, null, false, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", l = {95}, m = "waitForAdLoadToStart-8Mi8wO0")
    public static final class r extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20247j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20248k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20249l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20251n;

        public r(z8.d<? super r> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20249l = obj;
            this.f20251n |= Integer.MIN_VALUE;
            return e.this.b(null, 0L, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1", f = "VastAdLoader.kt", l = {97}, m = "invokeSuspend")
    public static final class s extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20252j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a f20254l;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1$1", f = "VastAdLoader.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20255j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f20256k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ e f20257l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f20257l = eVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                a aVar = new a(this.f20257l, dVar);
                aVar.f20256k = obj;
                return aVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar, @Nullable z8.d<? super Boolean> dVar) {
                return ((a) create(cVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f20255j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) this.f20256k;
                if (cVar instanceof c.C0384c) {
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    String str = this.f20257l.f20135h;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Stream status: ");
                    c.C0384c c0384c = (c.C0384c) cVar;
                    sb.append(c0384c.b().a());
                    sb.append('/');
                    sb.append(c0384c.b().b());
                    sb.append(" bytes downloaded");
                    MolocoLogger.info$default(molocoLogger, str, sb.toString(), null, false, 12, null);
                }
                return kotlin.coroutines.jvm.internal.b.a((cVar instanceof c.a) || (cVar instanceof c.b));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, z8.d<? super s> dVar) {
            super(2, dVar);
            this.f20254l = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> dVar) {
            return ((s) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new s(this.f20254l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20252j;
            if (i10 == 0) {
                v8.u.b(obj);
                s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> hVarB = e.this.f20130c.b(this.f20254l.g().g());
                a aVar = new a(e.this, null);
                this.f20252j = 1;
                obj = s9.j.x(hVarB, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }
    }

    public e(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k parseVast, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h mediaConfig, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheRepository, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n vastTracker, @NotNull d0 connectivityService, @NotNull s7.a httpClient, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m screenService) {
        t.i(parseVast, "parseVast");
        t.i(mediaConfig, "mediaConfig");
        t.i(mediaCacheRepository, "mediaCacheRepository");
        t.i(vastTracker, "vastTracker");
        t.i(connectivityService, "connectivityService");
        t.i(httpClient, "httpClient");
        t.i(screenService, "screenService");
        this.f20128a = parseVast;
        this.f20129b = mediaConfig;
        this.f20130c = mediaCacheRepository;
        this.f20131d = vastTracker;
        this.f20132e = connectivityService;
        this.f20133f = httpClient;
        this.f20134g = screenService;
        this.f20135h = "VastAdLoaderImpl";
    }

    public static final b g(v8.l<b> lVar) {
        return lVar.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, boolean r21, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r22) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(java.lang.String, java.lang.String, boolean, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a r12, long r13, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r15) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, long, z8.d):java.lang.Object");
    }

    public final double c(long j10, int i10) {
        return (j10 * ((long) 8)) / ((double) (i10 * 1000));
    }

    public final b e(a aVar) {
        List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> listC;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (aVar != null && (listC = aVar.c()) != null) {
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i> arrayList8 = new ArrayList();
                for (Object obj : list) {
                    if (!f20127i.r((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i) obj)) {
                        arrayList8.add(obj);
                    }
                }
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i iVar : arrayList8) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j jVarB = iVar.b();
                    if (jVarB instanceof j.b) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVarA = ((j.b) iVar.b()).a();
                        a0.B(arrayList, rVarA.e());
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a aVarF = rVarA.f();
                        if (aVarF != null) {
                            a0.B(arrayList2, aVarF.b());
                            a0.B(arrayList3, aVarF.c());
                        }
                        a0.B(arrayList6, rVarA.b());
                    } else if (jVarB instanceof j.a) {
                        a0.B(arrayList7, ((j.a) iVar.b()).a());
                    }
                }
                arrayList4.add(arrayList6);
                arrayList5.add(arrayList7);
            }
        }
        return new b(arrayList, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a(null, arrayList2, arrayList3), arrayList4, arrayList5);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c j(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> list, com.moloco.sdk.common_adapter_internal.a aVar) {
        List<String> listL;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!f20127i.q((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) obj) && (!r2.e().isEmpty())) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) kotlin.collections.d0.k0(kotlin.collections.d0.I0(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i.i(Integer.valueOf(aVar.f()), Integer.valueOf(aVar.c()))));
        if (gVar == null) {
            return null;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0 a0Var = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0) kotlin.collections.d0.i0(kotlin.collections.d0.I0(gVar.e(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i.q()));
        Integer numF = gVar.f();
        int iIntValue = numF != null ? numF.intValue() : 0;
        Integer numD = gVar.d();
        int iIntValue2 = numD != null ? numD.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h hVarB = gVar.b();
        String strA = hVarB != null ? hVarB.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h hVarB2 = gVar.b();
        if (hVarB2 == null || (listL = hVarB2.b()) == null) {
            listL = v.l();
        }
        List<String> list2 = listL;
        List<w> listC = gVar.c();
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList2.add(((w) it.next()).c());
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c(a0Var, iIntValue, iIntValue2, strA, list2, arrayList2);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e l(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> list) {
        List<String> listL;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!f20127i.s((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n) obj)) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n nVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n) kotlin.collections.d0.k0(kotlin.collections.d0.I0(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i.g()));
        if (nVar == null) {
            return null;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0 a0VarF = nVar.f();
        Integer numH = nVar.h();
        int iIntValue = numH != null ? numH.intValue() : 0;
        Integer numD = nVar.d();
        int iIntValue2 = numD != null ? numD.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVarB = nVar.b();
        String strA = oVarB != null ? oVarB.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVarB2 = nVar.b();
        if (oVarB2 == null || (listL = oVarB2.b()) == null) {
            listL = v.l();
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e(a0VarF, iIntValue, iIntValue2, strA, listL, nVar.g(), nVar.c(), nVar.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d r25, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.d r26, double r27, com.moloco.sdk.common_adapter_internal.a r29, boolean r30, java.lang.String r31, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r32) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.r(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$d, double, com.moloco.sdk.common_adapter_internal.a, boolean, java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d r18, java.util.List<java.lang.String> r19, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r20) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d, java.util.List, z8.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x027d, code lost:
    
        r19 = r9;
        r13 = r13;
        r9 = r33;
        r6 = r6;
        r10 = r10;
        r3 = r3;
        r12 = r17;
        r7 = r7;
        r11 = r11;
        r4 = r4;
        r8 = r8;
        r14 = r14;
        r5 = r5;
        r2 = r2;
        r1 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x01a2 -> B:39:0x01ba). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q r33, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a r34, double r35, com.moloco.sdk.common_adapter_internal.a r37, boolean r38, java.lang.String r39, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r40) {
        /*
            Method dump skipped, instruction units count: 963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$a, double, com.moloco.sdk.common_adapter_internal.a, boolean, java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r r19, java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> r20, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a r21, java.util.List<java.lang.String> r22, double r23, java.lang.Long r25, com.moloco.sdk.common_adapter_internal.a r26, boolean r27, java.lang.String r28, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r29) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.u(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r, java.util.List, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a, java.util.List, double, java.lang.Long, com.moloco.sdk.common_adapter_internal.a, boolean, java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y r21, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.d r22, double r23, com.moloco.sdk.common_adapter_internal.a r25, boolean r26, java.lang.String r27, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r28) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.v(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$d, double, com.moloco.sdk.common_adapter_internal.a, boolean, java.lang.String, z8.d):java.lang.Object");
    }

    public final void w(List<String> list, z zVar) {
        n.a.a(this.f20131d, list, zVar, null, null, 12, null);
    }

    public final double x() {
        return !this.f20132e.b() ? 10.0d : 2.0d;
    }
}

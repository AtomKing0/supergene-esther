package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ironsourceads.AdSize;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f3 f12019a = new f3();

    public static final class a implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final IronSource.AD_UNIT f12020a;

        public a(@NotNull IronSource.AD_UNIT value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12020a = value;
        }

        public static /* synthetic */ a a(a aVar, IronSource.AD_UNIT ad_unit, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                ad_unit = aVar.f12020a;
            }
            return aVar.a(ad_unit);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f12020a == ((a) obj).f12020a;
        }

        public int hashCode() {
            return this.f12020a.hashCode();
        }

        @NotNull
        public String toString() {
            return "AdFormatEntity(value=" + this.f12020a + ')';
        }

        @NotNull
        public final a a(@NotNull IronSource.AD_UNIT value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new a(value);
        }

        private final IronSource.AD_UNIT a() {
            return this.f12020a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("adUnit", Integer.valueOf(ks.b(this.f12020a)));
        }
    }

    public static final class b implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12021a;

        public b(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12021a = value;
        }

        public static /* synthetic */ b a(b bVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bVar.f12021a;
            }
            return bVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.t.d(this.f12021a, ((b) obj).f12021a);
        }

        public int hashCode() {
            return this.f12021a.hashCode();
        }

        @NotNull
        public String toString() {
            return "AdIdentifier(value=" + this.f12021a + ')';
        }

        @NotNull
        public final b a(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new b(value);
        }

        private final String a() {
            return this.f12021a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_IRONSOURCE_AD_OBJECT_ID, this.f12021a);
        }
    }

    public static final class c implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final AdSize f12022a;

        public c(@NotNull AdSize size) {
            kotlin.jvm.internal.t.i(size, "size");
            this.f12022a = size;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
        @Override // com.ironsource.g3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> r4) {
            /*
                r3 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.t.i(r4, r0)
                com.unity3d.ironsourceads.AdSize r0 = r3.f12022a
                java.lang.String r0 = r0.getSizeDescription()
                int r1 = r0.hashCode()
                r2 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
                if (r1 == r2) goto L45
                r2 = 72205083(0x44dc31b, float:2.4187222E-36)
                if (r1 == r2) goto L3a
                r2 = 446888797(0x1aa2fb5d, float:6.740773E-23)
                if (r1 == r2) goto L2f
                r2 = 1951953708(0x7458732c, float:6.859571E31)
                if (r1 == r2) goto L24
                goto L4d
            L24:
                java.lang.String r1 = "BANNER"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L2d
                goto L4d
            L2d:
                r0 = 1
                goto L50
            L2f:
                java.lang.String r1 = "LEADERBOARD"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L38
                goto L4d
            L38:
                r0 = 4
                goto L50
            L3a:
                java.lang.String r1 = "LARGE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L43
                goto L4d
            L43:
                r0 = 2
                goto L50
            L45:
                java.lang.String r1 = "MEDIUM_RECTANGLE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L4f
            L4d:
                r0 = 0
                goto L50
            L4f:
                r0 = 3
            L50:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.String r1 = "bannerAdSize"
                r4.put(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.f3.c.a(java.util.Map):void");
        }
    }

    public static final class d implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12023a;

        public d(@NotNull String auctionId) {
            kotlin.jvm.internal.t.i(auctionId, "auctionId");
            this.f12023a = auctionId;
        }

        public static /* synthetic */ d a(d dVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = dVar.f12023a;
            }
            return dVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && kotlin.jvm.internal.t.d(this.f12023a, ((d) obj).f12023a);
        }

        public int hashCode() {
            return this.f12023a.hashCode();
        }

        @NotNull
        public String toString() {
            return "AuctionId(auctionId=" + this.f12023a + ')';
        }

        @NotNull
        public final d a(@NotNull String auctionId) {
            kotlin.jvm.internal.t.i(auctionId, "auctionId");
            return new d(auctionId);
        }

        private final String a() {
            return this.f12023a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("auctionId", this.f12023a);
        }
    }

    public static final class e implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12024a;

        public e(int i10) {
            this.f12024a = i10;
        }

        private final int a() {
            return this.f12024a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.f12024a == ((e) obj).f12024a;
        }

        public int hashCode() {
            return this.f12024a;
        }

        @NotNull
        public String toString() {
            return "DemandOnly(value=" + this.f12024a + ')';
        }

        @NotNull
        public final e a(int i10) {
            return new e(i10);
        }

        public static /* synthetic */ e a(e eVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = eVar.f12024a;
            }
            return eVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_DEMAND_ONLY, Integer.valueOf(this.f12024a));
        }
    }

    public static final class f implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12025a;

        public f(long j10) {
            this.f12025a = j10;
        }

        private final long a() {
            return this.f12025a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.f12025a == ((f) obj).f12025a;
        }

        public int hashCode() {
            return androidx.compose.animation.a.a(this.f12025a);
        }

        @NotNull
        public String toString() {
            return "Duration(duration=" + this.f12025a + ')';
        }

        @NotNull
        public final f a(long j10) {
            return new f(j10);
        }

        public static /* synthetic */ f a(f fVar, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = fVar.f12025a;
            }
            return fVar.a(j10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("duration", Long.valueOf(this.f12025a));
        }
    }

    public static final class g implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12026a;

        public g(@NotNull String dynamicSourceId) {
            kotlin.jvm.internal.t.i(dynamicSourceId, "dynamicSourceId");
            this.f12026a = dynamicSourceId;
        }

        public static /* synthetic */ g a(g gVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = gVar.f12026a;
            }
            return gVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && kotlin.jvm.internal.t.d(this.f12026a, ((g) obj).f12026a);
        }

        public int hashCode() {
            return this.f12026a.hashCode();
        }

        @NotNull
        public String toString() {
            return "DynamicDemandSourceId(dynamicSourceId=" + this.f12026a + ')';
        }

        @NotNull
        public final g a(@NotNull String dynamicSourceId) {
            kotlin.jvm.internal.t.i(dynamicSourceId, "dynamicSourceId");
            return new g(dynamicSourceId);
        }

        private final String a() {
            return this.f12026a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f12026a);
        }
    }

    public static final class h implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12027a;

        public h(@NotNull String sourceId) {
            kotlin.jvm.internal.t.i(sourceId, "sourceId");
            this.f12027a = sourceId;
        }

        public static /* synthetic */ h a(h hVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = hVar.f12027a;
            }
            return hVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && kotlin.jvm.internal.t.d(this.f12027a, ((h) obj).f12027a);
        }

        public int hashCode() {
            return this.f12027a.hashCode();
        }

        @NotNull
        public String toString() {
            return "DynamicSourceId(sourceId=" + this.f12027a + ')';
        }

        @NotNull
        public final h a(@NotNull String sourceId) {
            kotlin.jvm.internal.t.i(sourceId, "sourceId");
            return new h(sourceId);
        }

        private final String a() {
            return this.f12027a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f12027a);
        }
    }

    public static final class i implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final i f12028a = new i();

        private i() {
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
        }
    }

    public static final class j implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12029a;

        public j(int i10) {
            this.f12029a = i10;
        }

        private final int a() {
            return this.f12029a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f12029a == ((j) obj).f12029a;
        }

        public int hashCode() {
            return this.f12029a;
        }

        @NotNull
        public String toString() {
            return "ErrorCode(code=" + this.f12029a + ')';
        }

        @NotNull
        public final j a(int i10) {
            return new j(i10);
        }

        public static /* synthetic */ j a(j jVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = jVar.f12029a;
            }
            return jVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(this.f12029a));
        }
    }

    public static final class k implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final String f12030a;

        public k(@Nullable String str) {
            this.f12030a = str;
        }

        public static /* synthetic */ k a(k kVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = kVar.f12030a;
            }
            return kVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && kotlin.jvm.internal.t.d(this.f12030a, ((k) obj).f12030a);
        }

        public int hashCode() {
            String str = this.f12030a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            return "ErrorReason(reason=" + this.f12030a + ')';
        }

        @NotNull
        public final k a(@Nullable String str) {
            return new k(str);
        }

        private final String a() {
            return this.f12030a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            String str = this.f12030a;
            if (str == null || str.length() == 0) {
                return;
            }
            bundle.put("reason", this.f12030a);
        }
    }

    public static final class l implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12031a;

        public l(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12031a = value;
        }

        public static /* synthetic */ l a(l lVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = lVar.f12031a;
            }
            return lVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && kotlin.jvm.internal.t.d(this.f12031a, ((l) obj).f12031a);
        }

        public int hashCode() {
            return this.f12031a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Ext1(value=" + this.f12031a + ')';
        }

        @NotNull
        public final l a(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new l(value);
        }

        private final String a() {
            return this.f12031a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_EXT1, this.f12031a);
        }
    }

    public static final class m implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final JSONObject f12032a;

        public m(@Nullable JSONObject jSONObject) {
            this.f12032a = jSONObject;
        }

        public static /* synthetic */ m a(m mVar, JSONObject jSONObject, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                jSONObject = mVar.f12032a;
            }
            return mVar.a(jSONObject);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && kotlin.jvm.internal.t.d(this.f12032a, ((m) obj).f12032a);
        }

        public int hashCode() {
            JSONObject jSONObject = this.f12032a;
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.hashCode();
        }

        @NotNull
        public String toString() {
            return "GenericParams(genericParams=" + this.f12032a + ')';
        }

        @NotNull
        public final m a(@Nullable JSONObject jSONObject) {
            return new m(jSONObject);
        }

        private final JSONObject a() {
            return this.f12032a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            JSONObject jSONObject = this.f12032a;
            if (jSONObject == null) {
                return;
            }
            bundle.put("genericParams", jSONObject);
        }
    }

    public static final class n implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12033a;

        public n(int i10) {
            this.f12033a = i10;
        }

        private final int a() {
            return this.f12033a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.f12033a == ((n) obj).f12033a;
        }

        public int hashCode() {
            return this.f12033a;
        }

        @NotNull
        public String toString() {
            return "InstanceType(instanceType=" + this.f12033a + ')';
        }

        @NotNull
        public final n a(int i10) {
            return new n(i10);
        }

        public static /* synthetic */ n a(n nVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = nVar.f12033a;
            }
            return nVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("instanceType", Integer.valueOf(this.f12033a));
        }
    }

    public static final class o implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12034a;

        public o(int i10) {
            this.f12034a = i10;
        }

        private final int a() {
            return this.f12034a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && this.f12034a == ((o) obj).f12034a;
        }

        public int hashCode() {
            return this.f12034a;
        }

        @NotNull
        public String toString() {
            return "MultipleAdObjects(value=" + this.f12034a + ')';
        }

        @NotNull
        public final o a(int i10) {
            return new o(i10);
        }

        public static /* synthetic */ o a(o oVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = oVar.f12034a;
            }
            return oVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("isMultipleAdObjects", Integer.valueOf(this.f12034a));
        }
    }

    public static final class p implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12035a;

        public p(int i10) {
            this.f12035a = i10;
        }

        private final int a() {
            return this.f12035a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.f12035a == ((p) obj).f12035a;
        }

        public int hashCode() {
            return this.f12035a;
        }

        @NotNull
        public String toString() {
            return "OneFlow(value=" + this.f12035a + ')';
        }

        @NotNull
        public final p a(int i10) {
            return new p(i10);
        }

        public static /* synthetic */ p a(p pVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = pVar.f12035a;
            }
            return pVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("isOneFlow", Integer.valueOf(this.f12035a));
        }
    }

    public static final class q implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12036a;

        public q(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12036a = value;
        }

        public static /* synthetic */ q a(q qVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = qVar.f12036a;
            }
            return qVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && kotlin.jvm.internal.t.d(this.f12036a, ((q) obj).f12036a);
        }

        public int hashCode() {
            return this.f12036a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Placement(value=" + this.f12036a + ')';
        }

        @NotNull
        public final q a(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new q(value);
        }

        private final String a() {
            return this.f12036a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("placement", this.f12036a);
        }
    }

    public static final class r implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12037a;

        public r(int i10) {
            this.f12037a = i10;
        }

        private final int a() {
            return this.f12037a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.f12037a == ((r) obj).f12037a;
        }

        public int hashCode() {
            return this.f12037a;
        }

        @NotNull
        public String toString() {
            return "Programmatic(programmatic=" + this.f12037a + ')';
        }

        @NotNull
        public final r a(int i10) {
            return new r(i10);
        }

        public static /* synthetic */ r a(r rVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = rVar.f12037a;
            }
            return rVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.f12037a));
        }
    }

    public static final class s implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12038a;

        public s(@NotNull String sourceName) {
            kotlin.jvm.internal.t.i(sourceName, "sourceName");
            this.f12038a = sourceName;
        }

        public static /* synthetic */ s a(s sVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = sVar.f12038a;
            }
            return sVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && kotlin.jvm.internal.t.d(this.f12038a, ((s) obj).f12038a);
        }

        public int hashCode() {
            return this.f12038a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Provider(sourceName=" + this.f12038a + ')';
        }

        @NotNull
        public final s a(@NotNull String sourceName) {
            kotlin.jvm.internal.t.i(sourceName, "sourceName");
            return new s(sourceName);
        }

        private final String a() {
            return this.f12038a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER, this.f12038a);
        }
    }

    public static final class t implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12039a;

        public t(int i10) {
            this.f12039a = i10;
        }

        private final int a() {
            return this.f12039a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof t) && this.f12039a == ((t) obj).f12039a;
        }

        public int hashCode() {
            return this.f12039a;
        }

        @NotNull
        public String toString() {
            return "RewardAmount(value=" + this.f12039a + ')';
        }

        @NotNull
        public final t a(int i10) {
            return new t(i10);
        }

        public static /* synthetic */ t a(t tVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = tVar.f12039a;
            }
            return tVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.f12039a));
        }
    }

    public static final class u implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12040a;

        public u(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12040a = value;
        }

        public static /* synthetic */ u a(u uVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = uVar.f12040a;
            }
            return uVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof u) && kotlin.jvm.internal.t.d(this.f12040a, ((u) obj).f12040a);
        }

        public int hashCode() {
            return this.f12040a.hashCode();
        }

        @NotNull
        public String toString() {
            return "RewardName(value=" + this.f12040a + ')';
        }

        @NotNull
        public final u a(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new u(value);
        }

        private final String a() {
            return this.f12040a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_NAME, this.f12040a);
        }
    }

    public static final class v implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12041a;

        public v(@NotNull String version) {
            kotlin.jvm.internal.t.i(version, "version");
            this.f12041a = version;
        }

        public static /* synthetic */ v a(v vVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = vVar.f12041a;
            }
            return vVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof v) && kotlin.jvm.internal.t.d(this.f12041a, ((v) obj).f12041a);
        }

        public int hashCode() {
            return this.f12041a.hashCode();
        }

        @NotNull
        public String toString() {
            return "SdkVersion(version=" + this.f12041a + ')';
        }

        @NotNull
        public final v a(@NotNull String version) {
            kotlin.jvm.internal.t.i(version, "version");
            return new v(version);
        }

        private final String a() {
            return this.f12041a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, this.f12041a);
        }
    }

    public static final class w implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12042a;

        public w(int i10) {
            this.f12042a = i10;
        }

        private final int a() {
            return this.f12042a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof w) && this.f12042a == ((w) obj).f12042a;
        }

        public int hashCode() {
            return this.f12042a;
        }

        @NotNull
        public String toString() {
            return "SessionDepth(sessionDepth=" + this.f12042a + ')';
        }

        @NotNull
        public final w a(int i10) {
            return new w(i10);
        }

        public static /* synthetic */ w a(w wVar, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = wVar.f12042a;
            }
            return wVar.a(i10);
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("sessionDepth", Integer.valueOf(this.f12042a));
        }
    }

    public static final class x implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12043a;

        public x(@NotNull String subProviderId) {
            kotlin.jvm.internal.t.i(subProviderId, "subProviderId");
            this.f12043a = subProviderId;
        }

        public static /* synthetic */ x a(x xVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = xVar.f12043a;
            }
            return xVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof x) && kotlin.jvm.internal.t.d(this.f12043a, ((x) obj).f12043a);
        }

        public int hashCode() {
            return this.f12043a.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubProviderId(subProviderId=" + this.f12043a + ')';
        }

        @NotNull
        public final x a(@NotNull String subProviderId) {
            kotlin.jvm.internal.t.i(subProviderId, "subProviderId");
            return new x(subProviderId);
        }

        private final String a() {
            return this.f12043a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put("spId", this.f12043a);
        }
    }

    public static final class y implements g3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f12044a;

        public y(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            this.f12044a = value;
        }

        public static /* synthetic */ y a(y yVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = yVar.f12044a;
            }
            return yVar.a(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof y) && kotlin.jvm.internal.t.d(this.f12044a, ((y) obj).f12044a);
        }

        public int hashCode() {
            return this.f12044a.hashCode();
        }

        @NotNull
        public String toString() {
            return "TransId(value=" + this.f12044a + ')';
        }

        @NotNull
        public final y a(@NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            return new y(value);
        }

        private final String a() {
            return this.f12044a;
        }

        @Override // com.ironsource.g3
        public void a(@NotNull Map<String, Object> bundle) {
            kotlin.jvm.internal.t.i(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_TRANS_ID, this.f12044a);
        }
    }

    private f3() {
    }
}

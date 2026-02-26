package com.vungle.ads.internal.model;

import android.util.Base64;
import com.vungle.ads.internal.model.b;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import da.w1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z9.o;

/* JADX INFO: compiled from: BidPayload.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class e {

    @NotNull
    public static final c Companion = new c(null);

    @Nullable
    private final com.vungle.ads.internal.model.b ad;

    @Nullable
    private final String adunit;

    @Nullable
    private final List<String> impression;

    @NotNull
    private final kotlinx.serialization.json.a json;

    @Nullable
    private final Integer version;

    /* JADX INFO: compiled from: BidPayload.kt */
    public static final class a implements d0<e> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.BidPayload", aVar, 4);
            pluginGeneratedSerialDescriptor.k("version", true);
            pluginGeneratedSerialDescriptor.k("adunit", true);
            pluginGeneratedSerialDescriptor.k("impression", true);
            pluginGeneratedSerialDescriptor.k("ad", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(l0.f24594a), aa.a.s(w1Var), aa.a.s(new da.f(w1Var)), aa.a.s(b.a.INSTANCE)};
        }

        @Override // z9.b
        @NotNull
        public e deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            int i10;
            Object objK4;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK5 = null;
            if (cVarB.p()) {
                objK4 = cVarB.k(descriptor2, 0, l0.f24594a, null);
                w1 w1Var = w1.f24648a;
                objK = cVarB.k(descriptor2, 1, w1Var, null);
                objK2 = cVarB.k(descriptor2, 2, new da.f(w1Var), null);
                objK3 = cVarB.k(descriptor2, 3, b.a.INSTANCE, null);
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK6 = null;
                Object objK7 = null;
                Object objK8 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK5 = cVarB.k(descriptor2, 0, l0.f24594a, objK5);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK6 = cVarB.k(descriptor2, 1, w1.f24648a, objK6);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK7 = cVarB.k(descriptor2, 2, new da.f(w1.f24648a), objK7);
                        i11 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new o(iO);
                        }
                        objK8 = cVarB.k(descriptor2, 3, b.a.INSTANCE, objK8);
                        i11 |= 8;
                    }
                }
                objK = objK6;
                objK2 = objK7;
                objK3 = objK8;
                Object obj = objK5;
                i10 = i11;
                objK4 = obj;
            }
            cVarB.c(descriptor2);
            return new e(i10, (Integer) objK4, (String) objK, (List) objK2, (com.vungle.ads.internal.model.b) objK3, null);
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull e value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            e.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: BidPayload.kt */
    static final class b extends v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    /* JADX INFO: compiled from: BidPayload.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<e> serializer() {
            return a.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BidPayload.kt */
    static final class d extends v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    public e() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e copy$default(e eVar, Integer num, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = eVar.version;
        }
        if ((i10 & 2) != 0) {
            str = eVar.adunit;
        }
        if ((i10 & 4) != 0) {
            list = eVar.impression;
        }
        return eVar.copy(num, str, list);
    }

    private final String gzipDecode(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 1024);
            try {
                bArr2 = new byte[1024];
            } finally {
            }
        } finally {
        }
        while (true) {
            int i10 = gZIPInputStream.read(bArr2);
            if (i10 == -1) {
                k0 k0Var = k0.f35197a;
                f9.c.a(gZIPInputStream, null);
                f9.c.a(byteArrayInputStream, null);
                String string = byteArrayOutputStream.toString();
                t.h(string, "result.toString()");
                return string;
            }
            byteArrayOutputStream.write(bArr2, 0, i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void write$Self(@org.jetbrains.annotations.NotNull com.vungle.ads.internal.model.e r8, @org.jetbrains.annotations.NotNull ca.d r9, @org.jetbrains.annotations.NotNull kotlinx.serialization.descriptors.SerialDescriptor r10) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.t.i(r8, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.t.i(r9, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.t.i(r10, r0)
            r0 = 0
            boolean r1 = r9.z(r10, r0)
            r2 = 1
            if (r1 == 0) goto L19
        L17:
            r1 = r2
            goto L1f
        L19:
            java.lang.Integer r1 = r8.version
            if (r1 == 0) goto L1e
            goto L17
        L1e:
            r1 = r0
        L1f:
            if (r1 == 0) goto L28
            da.l0 r1 = da.l0.f24594a
            java.lang.Integer r3 = r8.version
            r9.h(r10, r0, r1, r3)
        L28:
            boolean r1 = r9.z(r10, r2)
            if (r1 == 0) goto L30
        L2e:
            r1 = r2
            goto L36
        L30:
            java.lang.String r1 = r8.adunit
            if (r1 == 0) goto L35
            goto L2e
        L35:
            r1 = r0
        L36:
            if (r1 == 0) goto L3f
            da.w1 r1 = da.w1.f24648a
            java.lang.String r3 = r8.adunit
            r9.h(r10, r2, r1, r3)
        L3f:
            r1 = 2
            boolean r3 = r9.z(r10, r1)
            if (r3 == 0) goto L48
        L46:
            r3 = r2
            goto L4e
        L48:
            java.util.List<java.lang.String> r3 = r8.impression
            if (r3 == 0) goto L4d
            goto L46
        L4d:
            r3 = r0
        L4e:
            if (r3 == 0) goto L5c
            da.f r3 = new da.f
            da.w1 r4 = da.w1.f24648a
            r3.<init>(r4)
            java.util.List<java.lang.String> r4 = r8.impression
            r9.h(r10, r1, r3, r4)
        L5c:
            r1 = 3
            boolean r3 = r9.z(r10, r1)
            if (r3 == 0) goto L65
        L63:
            r0 = r2
            goto L95
        L65:
            com.vungle.ads.internal.model.b r3 = r8.ad
            java.lang.String r4 = r8.adunit
            r5 = 0
            if (r4 == 0) goto L8e
            java.lang.String r4 = r8.getDecodedAdsResponse()
            if (r4 == 0) goto L8e
            kotlinx.serialization.json.a r5 = r8.json
            fa.c r6 = r5.a()
            java.lang.Class<com.vungle.ads.internal.model.b> r7 = com.vungle.ads.internal.model.b.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.o0.j(r7)
            kotlinx.serialization.KSerializer r6 = z9.l.b(r6, r7)
            java.lang.String r7 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.t.g(r6, r7)
            java.lang.Object r4 = r5.b(r6, r4)
            com.vungle.ads.internal.model.b r4 = (com.vungle.ads.internal.model.b) r4
            r5 = r4
        L8e:
            boolean r3 = kotlin.jvm.internal.t.d(r3, r5)
            if (r3 != 0) goto L95
            goto L63
        L95:
            if (r0 == 0) goto L9e
            com.vungle.ads.internal.model.b$a r0 = com.vungle.ads.internal.model.b.a.INSTANCE
            com.vungle.ads.internal.model.b r8 = r8.ad
            r9.h(r10, r1, r0, r8)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.e.write$Self(com.vungle.ads.internal.model.e, ca.d, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    @Nullable
    public final Integer component1() {
        return this.version;
    }

    @Nullable
    public final String component2() {
        return this.adunit;
    }

    @Nullable
    public final List<String> component3() {
        return this.impression;
    }

    @NotNull
    public final e copy(@Nullable Integer num, @Nullable String str, @Nullable List<String> list) {
        return new e(num, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return t.d(this.version, eVar.version) && t.d(this.adunit, eVar.adunit) && t.d(this.impression, eVar.impression);
    }

    @Nullable
    public final com.vungle.ads.internal.model.b getAdPayload() {
        return this.ad;
    }

    @Nullable
    public final String getAdunit() {
        return this.adunit;
    }

    @Nullable
    public final String getDecodedAdsResponse() throws Throwable {
        byte[] bArrDecode = Base64.decode(this.adunit, 0);
        if (bArrDecode != null) {
            return gzipDecode(bArrDecode);
        }
        return null;
    }

    @Nullable
    public final String getEventId() {
        com.vungle.ads.internal.model.b bVar = this.ad;
        if (bVar != null) {
            return bVar.eventId();
        }
        return null;
    }

    @Nullable
    public final List<String> getImpression() {
        return this.impression;
    }

    @Nullable
    public final String getPlacementId() {
        com.vungle.ads.internal.model.b bVar = this.ad;
        if (bVar != null) {
            return bVar.placementId();
        }
        return null;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Integer num = this.version;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.adunit;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.impression;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BidPayload(version=" + this.version + ", adunit=" + this.adunit + ", impression=" + this.impression + ')';
    }

    public /* synthetic */ e(int i10, Integer num, String str, List list, com.vungle.ads.internal.model.b bVar, s1 s1Var) {
        String decodedAdsResponse;
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        com.vungle.ads.internal.model.b bVar2 = null;
        if ((i10 & 1) == 0) {
            this.version = null;
        } else {
            this.version = num;
        }
        if ((i10 & 2) == 0) {
            this.adunit = null;
        } else {
            this.adunit = str;
        }
        if ((i10 & 4) == 0) {
            this.impression = null;
        } else {
            this.impression = list;
        }
        kotlinx.serialization.json.a aVarB = kotlinx.serialization.json.m.b(null, b.INSTANCE, 1, null);
        this.json = aVarB;
        if ((i10 & 8) != 0) {
            this.ad = bVar;
            return;
        }
        if (this.adunit != null && (decodedAdsResponse = getDecodedAdsResponse()) != null) {
            KSerializer<Object> kSerializerB = z9.l.b(aVarB.a(), o0.j(com.vungle.ads.internal.model.b.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            bVar2 = (com.vungle.ads.internal.model.b) aVarB.b(kSerializerB, decodedAdsResponse);
        }
        this.ad = bVar2;
    }

    public e(@Nullable Integer num, @Nullable String str, @Nullable List<String> list) {
        String decodedAdsResponse;
        this.version = num;
        this.adunit = str;
        this.impression = list;
        com.vungle.ads.internal.model.b bVar = null;
        kotlinx.serialization.json.a aVarB = kotlinx.serialization.json.m.b(null, d.INSTANCE, 1, null);
        this.json = aVarB;
        if (str != null && (decodedAdsResponse = getDecodedAdsResponse()) != null) {
            KSerializer<Object> kSerializerB = z9.l.b(aVarB.a(), o0.j(com.vungle.ads.internal.model.b.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            bVar = (com.vungle.ads.internal.model.b) aVarB.b(kSerializerB, decodedAdsResponse);
        }
        this.ad = bVar;
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    public /* synthetic */ e(Integer num, String str, List list, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : list);
    }
}

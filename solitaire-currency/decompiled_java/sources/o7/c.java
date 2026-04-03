package o7;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import da.d0;
import da.i1;
import da.p0;
import da.s1;
import da.w1;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import o7.b;
import o7.e;
import o7.h;
import o7.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: FirstPartyData.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class c {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private Map<String, String> _customData;

    @Nullable
    private volatile o7.b _demographic;

    @Nullable
    private volatile e _location;

    @Nullable
    private volatile h _revenue;

    @Nullable
    private volatile i _sessionContext;

    /* JADX INFO: compiled from: FirstPartyData.kt */
    public static final class a implements d0<c> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.FirstPartyData", aVar, 5);
            pluginGeneratedSerialDescriptor.k("session_context", true);
            pluginGeneratedSerialDescriptor.k("demographic", true);
            pluginGeneratedSerialDescriptor.k("location", true);
            pluginGeneratedSerialDescriptor.k(ImpressionData.IMPRESSION_DATA_KEY_REVENUE, true);
            pluginGeneratedSerialDescriptor.k("custom_data", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(i.a.INSTANCE), aa.a.s(b.a.INSTANCE), aa.a.s(e.a.INSTANCE), aa.a.s(h.a.INSTANCE), aa.a.s(new p0(w1Var, w1Var))};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        @Override // z9.b
        @NotNull
        public c deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            Object objK4;
            int i10;
            Object objK5;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            Object objK6 = null;
            if (cVarB.p()) {
                objK5 = cVarB.k(descriptor2, 0, i.a.INSTANCE, null);
                objK = cVarB.k(descriptor2, 1, b.a.INSTANCE, null);
                objK2 = cVarB.k(descriptor2, 2, e.a.INSTANCE, null);
                objK3 = cVarB.k(descriptor2, 3, h.a.INSTANCE, null);
                w1 w1Var = w1.f24648a;
                objK4 = cVarB.k(descriptor2, 4, new p0(w1Var, w1Var), null);
                i10 = 31;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK7 = null;
                Object objK8 = null;
                Object objK9 = null;
                Object objK10 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK6 = cVarB.k(descriptor2, 0, i.a.INSTANCE, objK6);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK7 = cVarB.k(descriptor2, 1, b.a.INSTANCE, objK7);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK8 = cVarB.k(descriptor2, 2, e.a.INSTANCE, objK8);
                        i11 |= 4;
                    } else if (iO == 3) {
                        objK9 = cVarB.k(descriptor2, 3, h.a.INSTANCE, objK9);
                        i11 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new o(iO);
                        }
                        w1 w1Var2 = w1.f24648a;
                        objK10 = cVarB.k(descriptor2, 4, new p0(w1Var2, w1Var2), objK10);
                        i11 |= 16;
                    }
                }
                objK = objK7;
                objK2 = objK8;
                objK3 = objK9;
                objK4 = objK10;
                Object obj = objK6;
                i10 = i11;
                objK5 = obj;
            }
            cVarB.c(descriptor2);
            return new c(i10, (i) objK5, (o7.b) objK, (e) objK2, (h) objK3, (Map) objK4, null);
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull c value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            c.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }
    }

    /* JADX INFO: compiled from: FirstPartyData.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<c> serializer() {
            return a.INSTANCE;
        }
    }

    public c() {
    }

    public static final void write$Self(@NotNull c self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self._sessionContext != null) {
            output.h(serialDesc, 0, i.a.INSTANCE, self._sessionContext);
        }
        if (output.z(serialDesc, 1) || self._demographic != null) {
            output.h(serialDesc, 1, b.a.INSTANCE, self._demographic);
        }
        if (output.z(serialDesc, 2) || self._location != null) {
            output.h(serialDesc, 2, e.a.INSTANCE, self._location);
        }
        if (output.z(serialDesc, 3) || self._revenue != null) {
            output.h(serialDesc, 3, h.a.INSTANCE, self._revenue);
        }
        if (output.z(serialDesc, 4) || self._customData != null) {
            w1 w1Var = w1.f24648a;
            output.h(serialDesc, 4, new p0(w1Var, w1Var), self._customData);
        }
    }

    public final synchronized void clearAll() {
        this._sessionContext = null;
        this._demographic = null;
        this._location = null;
        this._revenue = null;
        Map<String, String> map = this._customData;
        if (map != null) {
            map.clear();
        }
        this._customData = null;
    }

    @NotNull
    public final synchronized Map<String, String> getCustomData() {
        Map<String, String> concurrentHashMap;
        concurrentHashMap = this._customData;
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this._customData = concurrentHashMap;
        }
        return concurrentHashMap;
    }

    @NotNull
    public final synchronized o7.b getDemographic() {
        o7.b bVar;
        bVar = this._demographic;
        if (bVar == null) {
            bVar = new o7.b();
            this._demographic = bVar;
        }
        return bVar;
    }

    @NotNull
    public final synchronized e getLocation() {
        e eVar;
        eVar = this._location;
        if (eVar == null) {
            eVar = new e();
            this._location = eVar;
        }
        return eVar;
    }

    @NotNull
    public final synchronized h getRevenue() {
        h hVar;
        hVar = this._revenue;
        if (hVar == null) {
            hVar = new h();
            this._revenue = hVar;
        }
        return hVar;
    }

    @NotNull
    public final synchronized i getSessionContext() {
        i iVar;
        iVar = this._sessionContext;
        if (iVar == null) {
            iVar = new i();
            this._sessionContext = iVar;
        }
        return iVar;
    }

    public /* synthetic */ c(int i10, i iVar, o7.b bVar, e eVar, h hVar, Map map, s1 s1Var) {
        if ((i10 & 0) != 0) {
            i1.a(i10, 0, a.INSTANCE.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this._sessionContext = null;
        } else {
            this._sessionContext = iVar;
        }
        if ((i10 & 2) == 0) {
            this._demographic = null;
        } else {
            this._demographic = bVar;
        }
        if ((i10 & 4) == 0) {
            this._location = null;
        } else {
            this._location = eVar;
        }
        if ((i10 & 8) == 0) {
            this._revenue = null;
        } else {
            this._revenue = hVar;
        }
        if ((i10 & 16) == 0) {
            this._customData = null;
        } else {
            this._customData = map;
        }
    }

    private static /* synthetic */ void get_customData$annotations() {
    }

    private static /* synthetic */ void get_demographic$annotations() {
    }

    private static /* synthetic */ void get_location$annotations() {
    }

    private static /* synthetic */ void get_revenue$annotations() {
    }

    private static /* synthetic */ void get_sessionContext$annotations() {
    }
}

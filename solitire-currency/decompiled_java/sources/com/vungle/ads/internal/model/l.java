package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.f;
import com.vungle.ads.internal.model.h;
import com.vungle.ads.internal.model.k;
import da.d0;
import da.i1;
import da.l0;
import da.s1;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.o;

/* JADX INFO: compiled from: RtbToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class l {

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private final h device;

    @Nullable
    private final f.h ext;
    private final int ordinalView;

    @Nullable
    private final k request;

    @Nullable
    private final f.j user;

    /* JADX INFO: compiled from: RtbToken.kt */
    public static final class a implements d0<l> {

        @NotNull
        public static final a INSTANCE;
        public static final /* synthetic */ SerialDescriptor descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbToken", aVar, 5);
            pluginGeneratedSerialDescriptor.k("device", false);
            pluginGeneratedSerialDescriptor.k("user", true);
            pluginGeneratedSerialDescriptor.k("ext", true);
            pluginGeneratedSerialDescriptor.k(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, true);
            pluginGeneratedSerialDescriptor.k("ordinal_view", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{h.a.INSTANCE, aa.a.s(f.j.a.INSTANCE), aa.a.s(f.h.a.INSTANCE), aa.a.s(k.a.INSTANCE), l0.f24594a};
        }

        @Override // z9.b
        @NotNull
        public l deserialize(@NotNull Decoder decoder) {
            Object objK;
            int i10;
            Object objK2;
            Object objK3;
            int i11;
            Object objY;
            t.i(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.c cVarB = decoder.b(descriptor2);
            if (cVarB.p()) {
                objY = cVarB.y(descriptor2, 0, h.a.INSTANCE, null);
                objK2 = cVarB.k(descriptor2, 1, f.j.a.INSTANCE, null);
                Object objK4 = cVarB.k(descriptor2, 2, f.h.a.INSTANCE, null);
                objK3 = cVarB.k(descriptor2, 3, k.a.INSTANCE, null);
                i11 = cVarB.i(descriptor2, 4);
                objK = objK4;
                i10 = 31;
            } else {
                boolean z10 = true;
                int i12 = 0;
                Object objY2 = null;
                Object objK5 = null;
                objK = null;
                Object objK6 = null;
                int i13 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor2);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objY2 = cVarB.y(descriptor2, 0, h.a.INSTANCE, objY2);
                        i13 |= 1;
                    } else if (iO == 1) {
                        objK5 = cVarB.k(descriptor2, 1, f.j.a.INSTANCE, objK5);
                        i13 |= 2;
                    } else if (iO == 2) {
                        objK = cVarB.k(descriptor2, 2, f.h.a.INSTANCE, objK);
                        i13 |= 4;
                    } else if (iO == 3) {
                        objK6 = cVarB.k(descriptor2, 3, k.a.INSTANCE, objK6);
                        i13 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new o(iO);
                        }
                        i12 = cVarB.i(descriptor2, 4);
                        i13 |= 16;
                    }
                }
                i10 = i13;
                objK2 = objK5;
                objK3 = objK6;
                i11 = i12;
                objY = objY2;
            }
            cVarB.c(descriptor2);
            return new l(i10, (h) objY, (f.j) objK2, (f.h) objK, (k) objK3, i11, (s1) null);
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, @NotNull l value) {
            t.i(encoder, "encoder");
            t.i(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            ca.d dVarB = encoder.b(descriptor2);
            l.write$Self(value, dVarB, descriptor2);
            dVarB.c(descriptor2);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: compiled from: RtbToken.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<l> serializer() {
            return a.INSTANCE;
        }
    }

    public /* synthetic */ l(int i10, h hVar, f.j jVar, f.h hVar2, k kVar, int i11, s1 s1Var) {
        if (17 != (i10 & 17)) {
            i1.a(i10, 17, a.INSTANCE.getDescriptor());
        }
        this.device = hVar;
        if ((i10 & 2) == 0) {
            this.user = null;
        } else {
            this.user = jVar;
        }
        if ((i10 & 4) == 0) {
            this.ext = null;
        } else {
            this.ext = hVar2;
        }
        if ((i10 & 8) == 0) {
            this.request = null;
        } else {
            this.request = kVar;
        }
        this.ordinalView = i11;
    }

    public static /* synthetic */ l copy$default(l lVar, h hVar, f.j jVar, f.h hVar2, k kVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hVar = lVar.device;
        }
        if ((i11 & 2) != 0) {
            jVar = lVar.user;
        }
        f.j jVar2 = jVar;
        if ((i11 & 4) != 0) {
            hVar2 = lVar.ext;
        }
        f.h hVar3 = hVar2;
        if ((i11 & 8) != 0) {
            kVar = lVar.request;
        }
        k kVar2 = kVar;
        if ((i11 & 16) != 0) {
            i10 = lVar.ordinalView;
        }
        return lVar.copy(hVar, jVar2, hVar3, kVar2, i10);
    }

    public static final void write$Self(@NotNull l self, @NotNull ca.d output, @NotNull SerialDescriptor serialDesc) {
        t.i(self, "self");
        t.i(output, "output");
        t.i(serialDesc, "serialDesc");
        output.j(serialDesc, 0, h.a.INSTANCE, self.device);
        if (output.z(serialDesc, 1) || self.user != null) {
            output.h(serialDesc, 1, f.j.a.INSTANCE, self.user);
        }
        if (output.z(serialDesc, 2) || self.ext != null) {
            output.h(serialDesc, 2, f.h.a.INSTANCE, self.ext);
        }
        if (output.z(serialDesc, 3) || self.request != null) {
            output.h(serialDesc, 3, k.a.INSTANCE, self.request);
        }
        output.w(serialDesc, 4, self.ordinalView);
    }

    @NotNull
    public final h component1() {
        return this.device;
    }

    @Nullable
    public final f.j component2() {
        return this.user;
    }

    @Nullable
    public final f.h component3() {
        return this.ext;
    }

    @Nullable
    public final k component4() {
        return this.request;
    }

    public final int component5() {
        return this.ordinalView;
    }

    @NotNull
    public final l copy(@NotNull h device, @Nullable f.j jVar, @Nullable f.h hVar, @Nullable k kVar, int i10) {
        t.i(device, "device");
        return new l(device, jVar, hVar, kVar, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return t.d(this.device, lVar.device) && t.d(this.user, lVar.user) && t.d(this.ext, lVar.ext) && t.d(this.request, lVar.request) && this.ordinalView == lVar.ordinalView;
    }

    @NotNull
    public final h getDevice() {
        return this.device;
    }

    @Nullable
    public final f.h getExt() {
        return this.ext;
    }

    public final int getOrdinalView() {
        return this.ordinalView;
    }

    @Nullable
    public final k getRequest() {
        return this.request;
    }

    @Nullable
    public final f.j getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.device.hashCode() * 31;
        f.j jVar = this.user;
        int iHashCode2 = (iHashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        f.h hVar = this.ext;
        int iHashCode3 = (iHashCode2 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        k kVar = this.request;
        return ((iHashCode3 + (kVar != null ? kVar.hashCode() : 0)) * 31) + this.ordinalView;
    }

    @NotNull
    public String toString() {
        return "RtbToken(device=" + this.device + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ", ordinalView=" + this.ordinalView + ')';
    }

    public l(@NotNull h device, @Nullable f.j jVar, @Nullable f.h hVar, @Nullable k kVar, int i10) {
        t.i(device, "device");
        this.device = device;
        this.user = jVar;
        this.ext = hVar;
        this.request = kVar;
        this.ordinalView = i10;
    }

    public /* synthetic */ l(h hVar, f.j jVar, f.h hVar2, k kVar, int i10, int i11, kotlin.jvm.internal.k kVar2) {
        this(hVar, (i11 & 2) != 0 ? null : jVar, (i11 & 4) != 0 ? null : hVar2, (i11 & 8) != 0 ? null : kVar, i10);
    }

    public static /* synthetic */ void getOrdinalView$annotations() {
    }
}

package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.ironsource.f5;
import com.moloco.sdk.internal.ortb.model.d;
import da.c0;
import da.d0;
import da.i1;
import da.s1;
import da.w1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class c {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f17688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f17689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final d f17690d;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17692b;

        static {
            a aVar = new a();
            f17691a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Bid", aVar, 4);
            pluginGeneratedSerialDescriptor.k("adm", false);
            pluginGeneratedSerialDescriptor.k("price", false);
            pluginGeneratedSerialDescriptor.k(f5.f12057x, true);
            pluginGeneratedSerialDescriptor.k("ext", false);
            f17692b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c deserialize(@NotNull Decoder decoder) {
            float f10;
            int i10;
            String str;
            Object objK;
            Object objY;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            if (cVarB.p()) {
                String strN = cVarB.n(descriptor, 0);
                float fU = cVarB.u(descriptor, 1);
                objK = cVarB.k(descriptor, 2, w1.f24648a, null);
                objY = cVarB.y(descriptor, 3, d.a.f17697a, null);
                str = strN;
                f10 = fU;
                i10 = 15;
            } else {
                float fU2 = 0.0f;
                boolean z10 = true;
                String strN2 = null;
                Object objK2 = null;
                Object objY2 = null;
                int i11 = 0;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        strN2 = cVarB.n(descriptor, 0);
                        i11 |= 1;
                    } else if (iO == 1) {
                        fU2 = cVarB.u(descriptor, 1);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK2 = cVarB.k(descriptor, 2, w1.f24648a, objK2);
                        i11 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new z9.o(iO);
                        }
                        objY2 = cVarB.y(descriptor, 3, d.a.f17697a, objY2);
                        i11 |= 8;
                    }
                }
                f10 = fU2;
                i10 = i11;
                str = strN2;
                objK = objK2;
                objY = objY2;
            }
            cVarB.c(descriptor);
            return new c(i10, str, f10, (String) objK, (d) objY, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull c value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            c.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{w1Var, c0.f24548a, aa.a.s(w1Var), d.a.f17697a};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17692b;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<c> serializer() {
            return a.f17691a;
        }

        public b() {
        }
    }

    public /* synthetic */ c(int i10, String str, float f10, String str2, d dVar, s1 s1Var) {
        if (11 != (i10 & 11)) {
            i1.a(i10, 11, a.f17691a.getDescriptor());
        }
        this.f17687a = str;
        this.f17688b = f10;
        if ((i10 & 4) == 0) {
            this.f17689c = null;
        } else {
            this.f17689c = str2;
        }
        this.f17690d = dVar;
    }

    public static final /* synthetic */ void b(c cVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.y(serialDescriptor, 0, cVar.f17687a);
        dVar.s(serialDescriptor, 1, cVar.f17688b);
        if (dVar.z(serialDescriptor, 2) || cVar.f17689c != null) {
            dVar.h(serialDescriptor, 2, w1.f24648a, cVar.f17689c);
        }
        dVar.j(serialDescriptor, 3, d.a.f17697a, cVar.f17690d);
    }

    @NotNull
    public final String a() {
        return this.f17687a;
    }

    @Nullable
    public final String c() {
        return this.f17689c;
    }

    @NotNull
    public final d d() {
        return this.f17690d;
    }

    public final float e() {
        return this.f17688b;
    }

    public c(@NotNull String adm, float f10, @Nullable String str, @NotNull d ext) {
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(ext, "ext");
        this.f17687a = adm;
        this.f17688b = f10;
        this.f17689c = str;
        this.f17690d = ext;
    }
}

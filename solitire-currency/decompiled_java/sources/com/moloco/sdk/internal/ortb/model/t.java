package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.l;
import com.moloco.sdk.internal.ortb.model.u;
import da.d0;
import da.e2;
import da.i1;
import da.s1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class t {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l f17803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final u f17804c;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17806b;

        static {
            a aVar = new a();
            f17805a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.VastPrivacyIcon", aVar, 3);
            pluginGeneratedSerialDescriptor.k("padding", false);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", false);
            f17806b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t deserialize(@NotNull Decoder decoder) {
            Object objY;
            Object objY2;
            int i10;
            Object objY3;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            Object objY4 = null;
            if (cVarB.p()) {
                objY3 = cVarB.y(descriptor, 0, e2.f24564a, null);
                objY = cVarB.y(descriptor, 1, l.a.f17744a, null);
                objY2 = cVarB.y(descriptor, 2, u.a.f17812a, null);
                i10 = 7;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objY5 = null;
                Object objY6 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objY4 = cVarB.y(descriptor, 0, e2.f24564a, objY4);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objY5 = cVarB.y(descriptor, 1, l.a.f17744a, objY5);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new z9.o(iO);
                        }
                        objY6 = cVarB.y(descriptor, 2, u.a.f17812a, objY6);
                        i11 |= 4;
                    }
                }
                objY = objY5;
                objY2 = objY6;
                Object obj = objY4;
                i10 = i11;
                objY3 = obj;
            }
            cVarB.c(descriptor);
            return new t(i10, (c0) objY3, (l) objY, (u) objY2, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull t value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            t.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{e2.f24564a, l.a.f17744a, u.a.f17812a};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17806b;
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
        public final KSerializer<t> serializer() {
            return a.f17805a;
        }

        public b() {
        }
    }

    public /* synthetic */ t(int i10, c0 c0Var, l lVar, u uVar, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, c0Var, lVar, uVar, s1Var);
    }

    public static final /* synthetic */ void b(t tVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.j(serialDescriptor, 0, e2.f24564a, c0.a(tVar.f17802a));
        dVar.j(serialDescriptor, 1, l.a.f17744a, tVar.f17803b);
        dVar.j(serialDescriptor, 2, u.a.f17812a, tVar.f17804c);
    }

    @NotNull
    public final l a() {
        return this.f17803b;
    }

    public final int c() {
        return this.f17802a;
    }

    @NotNull
    public final u d() {
        return this.f17804c;
    }

    public t(int i10, c0 c0Var, l lVar, u uVar, s1 s1Var) {
        if (7 != (i10 & 7)) {
            i1.a(i10, 7, a.f17805a.getDescriptor());
        }
        this.f17802a = c0Var.g();
        this.f17803b = lVar;
        this.f17804c = uVar;
    }
}

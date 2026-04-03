package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import com.moloco.sdk.internal.ortb.model.l;
import com.moloco.sdk.internal.ortb.model.u;
import da.d0;
import da.e2;
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
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class g {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f17704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final l f17706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final u f17707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Color f17709g;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17711b;

        static {
            a aVar = new a();
            f17710a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CTA", aVar, 7);
            pluginGeneratedSerialDescriptor.k("text", false);
            pluginGeneratedSerialDescriptor.k("image_url", true);
            pluginGeneratedSerialDescriptor.k("padding", false);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.k("foreground_color", false);
            pluginGeneratedSerialDescriptor.k("background_color", true);
            f17711b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objY;
            Object objY2;
            Object objY3;
            Object objY4;
            String str;
            int i10;
            boolean z10;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 6;
            String strN = null;
            if (cVarB.p()) {
                String strN2 = cVarB.n(descriptor, 0);
                objK2 = cVarB.k(descriptor, 1, w1.f24648a, null);
                objY = cVarB.y(descriptor, 2, e2.f24564a, null);
                objY2 = cVarB.y(descriptor, 3, l.a.f17744a, null);
                objY3 = cVarB.y(descriptor, 4, u.a.f17812a, null);
                h hVar = h.f17712a;
                objY4 = cVarB.y(descriptor, 5, hVar, null);
                objK = cVarB.k(descriptor, 6, hVar, null);
                str = strN2;
                i10 = 127;
            } else {
                boolean z11 = true;
                int i12 = 0;
                Object objK3 = null;
                Object objK4 = null;
                Object objY5 = null;
                Object objY6 = null;
                Object objY7 = null;
                Object objY8 = null;
                while (z11) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z11 = false;
                            break;
                        case 0:
                            z10 = true;
                            strN = cVarB.n(descriptor, 0);
                            i12 |= 1;
                            i11 = 6;
                            break;
                        case 1:
                            z10 = true;
                            objK4 = cVarB.k(descriptor, 1, w1.f24648a, objK4);
                            i12 |= 2;
                            i11 = 6;
                            break;
                        case 2:
                            objY5 = cVarB.y(descriptor, 2, e2.f24564a, objY5);
                            i12 |= 4;
                            break;
                        case 3:
                            objY6 = cVarB.y(descriptor, 3, l.a.f17744a, objY6);
                            i12 |= 8;
                            break;
                        case 4:
                            objY7 = cVarB.y(descriptor, 4, u.a.f17812a, objY7);
                            i12 |= 16;
                            break;
                        case 5:
                            objY8 = cVarB.y(descriptor, 5, h.f17712a, objY8);
                            i12 |= 32;
                            break;
                        case 6:
                            objK3 = cVarB.k(descriptor, i11, h.f17712a, objK3);
                            i12 |= 64;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                objK = objK3;
                objK2 = objK4;
                objY = objY5;
                objY2 = objY6;
                objY3 = objY7;
                objY4 = objY8;
                str = strN;
                i10 = i12;
            }
            cVarB.c(descriptor);
            return new g(i10, str, (String) objK2, (c0) objY, (l) objY2, (u) objY3, (Color) objY4, (Color) objK, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull g value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            g.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            h hVar = h.f17712a;
            return new KSerializer[]{w1Var, aa.a.s(w1Var), e2.f24564a, l.a.f17744a, u.a.f17812a, hVar, aa.a.s(hVar)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17711b;
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
        public final KSerializer<g> serializer() {
            return a.f17710a;
        }

        public b() {
        }
    }

    public /* synthetic */ g(int i10, String str, String str2, c0 c0Var, l lVar, u uVar, @z9.h(with = h.class) Color color, @z9.h(with = h.class) Color color2, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, str, str2, c0Var, lVar, uVar, color, color2, s1Var);
    }

    public static final /* synthetic */ void b(g gVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.y(serialDescriptor, 0, gVar.f17703a);
        if (dVar.z(serialDescriptor, 1) || gVar.f17704b != null) {
            dVar.h(serialDescriptor, 1, w1.f24648a, gVar.f17704b);
        }
        dVar.j(serialDescriptor, 2, e2.f24564a, c0.a(gVar.f17705c));
        dVar.j(serialDescriptor, 3, l.a.f17744a, gVar.f17706d);
        dVar.j(serialDescriptor, 4, u.a.f17812a, gVar.f17707e);
        h hVar = h.f17712a;
        dVar.j(serialDescriptor, 5, hVar, Color.m1588boximpl(gVar.f17708f));
        if (!dVar.z(serialDescriptor, 6) && gVar.f17709g == null) {
            return;
        }
        dVar.h(serialDescriptor, 6, hVar, gVar.f17709g);
    }

    @Nullable
    public final Color a() {
        return this.f17709g;
    }

    public final long c() {
        return this.f17708f;
    }

    @NotNull
    public final l d() {
        return this.f17706d;
    }

    @Nullable
    public final String e() {
        return this.f17704b;
    }

    public final int f() {
        return this.f17705c;
    }

    @NotNull
    public final String g() {
        return this.f17703a;
    }

    @NotNull
    public final u h() {
        return this.f17707e;
    }

    public g(int i10, String str, String str2, c0 c0Var, l lVar, u uVar, Color color, Color color2, s1 s1Var) {
        if (61 != (i10 & 61)) {
            i1.a(i10, 61, a.f17710a.getDescriptor());
        }
        this.f17703a = str;
        if ((i10 & 2) == 0) {
            this.f17704b = null;
        } else {
            this.f17704b = str2;
        }
        this.f17705c = c0Var.g();
        this.f17706d = lVar;
        this.f17707e = uVar;
        this.f17708f = color.m1608unboximpl();
        if ((i10 & 64) == 0) {
            this.f17709g = null;
        } else {
            this.f17709g = color2;
        }
    }
}

package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
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
import org.jetbrains.annotations.Nullable;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class n {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final l f17752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final u f17753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final c0 f17755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Color f17756g;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17758b;

        static {
            a aVar = new a();
            f17757a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Mute", aVar, 7);
            pluginGeneratedSerialDescriptor.k("mute", false);
            pluginGeneratedSerialDescriptor.k("padding", false);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.k("foreground_color", false);
            pluginGeneratedSerialDescriptor.k("control_size", true);
            pluginGeneratedSerialDescriptor.k("background_color", true);
            f17758b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n deserialize(@NotNull Decoder decoder) {
            int i10;
            Object objK;
            Object objY;
            Object objY2;
            Object objY3;
            Object objY4;
            Object objK2;
            boolean z10;
            boolean z11;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 6;
            if (cVarB.p()) {
                boolean zC = cVarB.C(descriptor, 0);
                e2 e2Var = e2.f24564a;
                objY = cVarB.y(descriptor, 1, e2Var, null);
                objY2 = cVarB.y(descriptor, 2, l.a.f17744a, null);
                objY3 = cVarB.y(descriptor, 3, u.a.f17812a, null);
                h hVar = h.f17712a;
                objY4 = cVarB.y(descriptor, 4, hVar, null);
                objK2 = cVarB.k(descriptor, 5, e2Var, null);
                objK = cVarB.k(descriptor, 6, hVar, null);
                z10 = zC;
                i10 = 127;
            } else {
                boolean z12 = true;
                boolean zC2 = false;
                Object objY5 = null;
                Object objY6 = null;
                Object objY7 = null;
                Object objY8 = null;
                Object objK3 = null;
                Object objK4 = null;
                i10 = 0;
                while (z12) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z12 = false;
                            break;
                        case 0:
                            z11 = true;
                            zC2 = cVarB.C(descriptor, 0);
                            i10 |= 1;
                            i11 = 6;
                            break;
                        case 1:
                            z11 = true;
                            objY5 = cVarB.y(descriptor, 1, e2.f24564a, objY5);
                            i10 |= 2;
                            i11 = 6;
                            break;
                        case 2:
                            objY6 = cVarB.y(descriptor, 2, l.a.f17744a, objY6);
                            i10 |= 4;
                            break;
                        case 3:
                            objY7 = cVarB.y(descriptor, 3, u.a.f17812a, objY7);
                            i10 |= 8;
                            break;
                        case 4:
                            objY8 = cVarB.y(descriptor, 4, h.f17712a, objY8);
                            i10 |= 16;
                            break;
                        case 5:
                            objK3 = cVarB.k(descriptor, 5, e2.f24564a, objK3);
                            i10 |= 32;
                            break;
                        case 6:
                            objK4 = cVarB.k(descriptor, i11, h.f17712a, objK4);
                            i10 |= 64;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                objK = objK4;
                objY = objY5;
                objY2 = objY6;
                objY3 = objY7;
                objY4 = objY8;
                objK2 = objK3;
                z10 = zC2;
            }
            cVarB.c(descriptor);
            return new n(i10, z10, (c0) objY, (l) objY2, (u) objY3, (Color) objY4, (c0) objK2, (Color) objK, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull n value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            n.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            e2 e2Var = e2.f24564a;
            h hVar = h.f17712a;
            return new KSerializer[]{da.h.f24574a, e2Var, l.a.f17744a, u.a.f17812a, hVar, aa.a.s(e2Var), aa.a.s(hVar)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17758b;
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
        public final KSerializer<n> serializer() {
            return a.f17757a;
        }

        public b() {
        }
    }

    public /* synthetic */ n(int i10, boolean z10, c0 c0Var, l lVar, u uVar, @z9.h(with = h.class) Color color, c0 c0Var2, @z9.h(with = h.class) Color color2, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, z10, c0Var, lVar, uVar, color, c0Var2, color2, s1Var);
    }

    public static final /* synthetic */ void b(n nVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.x(serialDescriptor, 0, nVar.f17750a);
        e2 e2Var = e2.f24564a;
        dVar.j(serialDescriptor, 1, e2Var, c0.a(nVar.f17751b));
        dVar.j(serialDescriptor, 2, l.a.f17744a, nVar.f17752c);
        dVar.j(serialDescriptor, 3, u.a.f17812a, nVar.f17753d);
        h hVar = h.f17712a;
        dVar.j(serialDescriptor, 4, hVar, Color.m1588boximpl(nVar.f17754e));
        if (dVar.z(serialDescriptor, 5) || nVar.f17755f != null) {
            dVar.h(serialDescriptor, 5, e2Var, nVar.f17755f);
        }
        if (!dVar.z(serialDescriptor, 6) && nVar.f17756g == null) {
            return;
        }
        dVar.h(serialDescriptor, 6, hVar, nVar.f17756g);
    }

    @Nullable
    public final Color a() {
        return this.f17756g;
    }

    @Nullable
    public final c0 c() {
        return this.f17755f;
    }

    public final long d() {
        return this.f17754e;
    }

    @NotNull
    public final l e() {
        return this.f17752c;
    }

    public final boolean f() {
        return this.f17750a;
    }

    public final int g() {
        return this.f17751b;
    }

    @NotNull
    public final u h() {
        return this.f17753d;
    }

    public /* synthetic */ n(boolean z10, int i10, l lVar, u uVar, long j10, c0 c0Var, Color color, kotlin.jvm.internal.k kVar) {
        this(z10, i10, lVar, uVar, j10, c0Var, color);
    }

    public n(int i10, boolean z10, c0 c0Var, l lVar, u uVar, Color color, c0 c0Var2, Color color2, s1 s1Var) {
        if (31 != (i10 & 31)) {
            i1.a(i10, 31, a.f17757a.getDescriptor());
        }
        this.f17750a = z10;
        this.f17751b = c0Var.g();
        this.f17752c = lVar;
        this.f17753d = uVar;
        this.f17754e = color.m1608unboximpl();
        if ((i10 & 32) == 0) {
            this.f17755f = null;
        } else {
            this.f17755f = c0Var2;
        }
        if ((i10 & 64) == 0) {
            this.f17756g = null;
        } else {
            this.f17756g = color2;
        }
    }

    public n(boolean z10, int i10, l horizontalAlignment, u verticalAlignment, long j10, c0 c0Var, Color color) {
        kotlin.jvm.internal.t.i(horizontalAlignment, "horizontalAlignment");
        kotlin.jvm.internal.t.i(verticalAlignment, "verticalAlignment");
        this.f17750a = z10;
        this.f17751b = i10;
        this.f17752c = horizontalAlignment;
        this.f17753d = verticalAlignment;
        this.f17754e = j10;
        this.f17755f = c0Var;
        this.f17756g = color;
    }

    public /* synthetic */ n(boolean z10, int i10, l lVar, u uVar, long j10, c0 c0Var, Color color, int i11, kotlin.jvm.internal.k kVar) {
        this(z10, i10, lVar, uVar, j10, (i11 & 32) != 0 ? null : c0Var, (i11 & 64) != 0 ? null : color, null);
    }
}

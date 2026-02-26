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
public final class s {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final l f17796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final u f17797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Color f17799g;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17801b;

        static {
            a aVar = new a();
            f17800a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SkipClose", aVar, 7);
            pluginGeneratedSerialDescriptor.k("delay_seconds", false);
            pluginGeneratedSerialDescriptor.k("padding", false);
            pluginGeneratedSerialDescriptor.k("control_size", false);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.k("foreground_color", false);
            pluginGeneratedSerialDescriptor.k("background_color", true);
            f17801b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s deserialize(@NotNull Decoder decoder) {
            Object objY;
            int i10;
            Object objK;
            Object objY2;
            Object objY3;
            Object objY4;
            Object objY5;
            Object objY6;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 6;
            Object objY7 = null;
            if (cVarB.p()) {
                e2 e2Var = e2.f24564a;
                objY2 = cVarB.y(descriptor, 0, e2Var, null);
                Object objY8 = cVarB.y(descriptor, 1, e2Var, null);
                objY3 = cVarB.y(descriptor, 2, e2Var, null);
                objY4 = cVarB.y(descriptor, 3, l.a.f17744a, null);
                objY5 = cVarB.y(descriptor, 4, u.a.f17812a, null);
                h hVar = h.f17712a;
                objY6 = cVarB.y(descriptor, 5, hVar, null);
                objK = cVarB.k(descriptor, 6, hVar, null);
                objY = objY8;
                i10 = 127;
            } else {
                boolean z10 = true;
                int i12 = 0;
                Object objK2 = null;
                objY = null;
                Object objY9 = null;
                Object objY10 = null;
                Object objY11 = null;
                Object objY12 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z10 = false;
                            i11 = 6;
                            break;
                        case 0:
                            objY7 = cVarB.y(descriptor, 0, e2.f24564a, objY7);
                            i12 |= 1;
                            i11 = 6;
                            break;
                        case 1:
                            objY = cVarB.y(descriptor, 1, e2.f24564a, objY);
                            i12 |= 2;
                            i11 = 6;
                            break;
                        case 2:
                            objY9 = cVarB.y(descriptor, 2, e2.f24564a, objY9);
                            i12 |= 4;
                            break;
                        case 3:
                            objY10 = cVarB.y(descriptor, 3, l.a.f17744a, objY10);
                            i12 |= 8;
                            break;
                        case 4:
                            objY11 = cVarB.y(descriptor, 4, u.a.f17812a, objY11);
                            i12 |= 16;
                            break;
                        case 5:
                            objY12 = cVarB.y(descriptor, 5, h.f17712a, objY12);
                            i12 |= 32;
                            break;
                        case 6:
                            objK2 = cVarB.k(descriptor, i11, h.f17712a, objK2);
                            i12 |= 64;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                i10 = i12;
                objK = objK2;
                objY2 = objY7;
                objY3 = objY9;
                objY4 = objY10;
                objY5 = objY11;
                objY6 = objY12;
            }
            cVarB.c(descriptor);
            return new s(i10, (c0) objY2, (c0) objY, (c0) objY3, (l) objY4, (u) objY5, (Color) objY6, (Color) objK, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull s value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            s.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            e2 e2Var = e2.f24564a;
            h hVar = h.f17712a;
            return new KSerializer[]{e2Var, e2Var, e2Var, l.a.f17744a, u.a.f17812a, hVar, aa.a.s(hVar)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17801b;
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
        public final KSerializer<s> serializer() {
            return a.f17800a;
        }

        public b() {
        }
    }

    public /* synthetic */ s(int i10, int i11, int i12, l lVar, u uVar, long j10, Color color, kotlin.jvm.internal.k kVar) {
        this(i10, i11, i12, lVar, uVar, j10, color);
    }

    public static final /* synthetic */ void b(s sVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        e2 e2Var = e2.f24564a;
        dVar.j(serialDescriptor, 0, e2Var, c0.a(sVar.f17793a));
        dVar.j(serialDescriptor, 1, e2Var, c0.a(sVar.f17794b));
        dVar.j(serialDescriptor, 2, e2Var, c0.a(sVar.f17795c));
        dVar.j(serialDescriptor, 3, l.a.f17744a, sVar.f17796d);
        dVar.j(serialDescriptor, 4, u.a.f17812a, sVar.f17797e);
        h hVar = h.f17712a;
        dVar.j(serialDescriptor, 5, hVar, Color.m1588boximpl(sVar.f17798f));
        if (!dVar.z(serialDescriptor, 6) && sVar.f17799g == null) {
            return;
        }
        dVar.h(serialDescriptor, 6, hVar, sVar.f17799g);
    }

    @Nullable
    public final Color a() {
        return this.f17799g;
    }

    public final int c() {
        return this.f17795c;
    }

    public final int d() {
        return this.f17793a;
    }

    public final long e() {
        return this.f17798f;
    }

    @NotNull
    public final l f() {
        return this.f17796d;
    }

    public final int g() {
        return this.f17794b;
    }

    @NotNull
    public final u h() {
        return this.f17797e;
    }

    public /* synthetic */ s(int i10, c0 c0Var, c0 c0Var2, c0 c0Var3, l lVar, u uVar, @z9.h(with = h.class) Color color, @z9.h(with = h.class) Color color2, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, c0Var, c0Var2, c0Var3, lVar, uVar, color, color2, s1Var);
    }

    public s(int i10, int i11, int i12, l horizontalAlignment, u verticalAlignment, long j10, Color color) {
        kotlin.jvm.internal.t.i(horizontalAlignment, "horizontalAlignment");
        kotlin.jvm.internal.t.i(verticalAlignment, "verticalAlignment");
        this.f17793a = i10;
        this.f17794b = i11;
        this.f17795c = i12;
        this.f17796d = horizontalAlignment;
        this.f17797e = verticalAlignment;
        this.f17798f = j10;
        this.f17799g = color;
    }

    public s(int i10, c0 c0Var, c0 c0Var2, c0 c0Var3, l lVar, u uVar, Color color, Color color2, s1 s1Var) {
        if (63 != (i10 & 63)) {
            i1.a(i10, 63, a.f17800a.getDescriptor());
        }
        this.f17793a = c0Var.g();
        this.f17794b = c0Var2.g();
        this.f17795c = c0Var3.g();
        this.f17796d = lVar;
        this.f17797e = uVar;
        this.f17798f = color.m1608unboximpl();
        if ((i10 & 64) == 0) {
            this.f17799g = null;
        } else {
            this.f17799g = color2;
        }
    }

    public /* synthetic */ s(int i10, int i11, int i12, l lVar, u uVar, long j10, Color color, int i13, kotlin.jvm.internal.k kVar) {
        this(i10, i11, i12, lVar, uVar, j10, (i13 & 64) != 0 ? null : color, null);
    }
}

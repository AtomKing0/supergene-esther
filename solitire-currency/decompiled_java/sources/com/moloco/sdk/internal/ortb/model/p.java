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
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class p {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l f17772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final u f17773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17774d;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17776b;

        static {
            a aVar = new a();
            f17775a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.ProgressBar", aVar, 4);
            pluginGeneratedSerialDescriptor.k("padding", false);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.k("foreground_color", false);
            f17776b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p deserialize(@NotNull Decoder decoder) {
            Object objY;
            Object objY2;
            Object objY3;
            int i10;
            Object objY4;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            Object objY5 = null;
            if (cVarB.p()) {
                objY4 = cVarB.y(descriptor, 0, e2.f24564a, null);
                objY = cVarB.y(descriptor, 1, l.a.f17744a, null);
                objY2 = cVarB.y(descriptor, 2, u.a.f17812a, null);
                objY3 = cVarB.y(descriptor, 3, h.f17712a, null);
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objY6 = null;
                Object objY7 = null;
                Object objY8 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objY5 = cVarB.y(descriptor, 0, e2.f24564a, objY5);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objY6 = cVarB.y(descriptor, 1, l.a.f17744a, objY6);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objY7 = cVarB.y(descriptor, 2, u.a.f17812a, objY7);
                        i11 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new z9.o(iO);
                        }
                        objY8 = cVarB.y(descriptor, 3, h.f17712a, objY8);
                        i11 |= 8;
                    }
                }
                objY = objY6;
                objY2 = objY7;
                objY3 = objY8;
                Object obj = objY5;
                i10 = i11;
                objY4 = obj;
            }
            cVarB.c(descriptor);
            return new p(i10, (c0) objY4, (l) objY, (u) objY2, (Color) objY3, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull p value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            p.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{e2.f24564a, l.a.f17744a, u.a.f17812a, h.f17712a};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17776b;
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
        public final KSerializer<p> serializer() {
            return a.f17775a;
        }

        public b() {
        }
    }

    public /* synthetic */ p(int i10, l lVar, u uVar, long j10, kotlin.jvm.internal.k kVar) {
        this(i10, lVar, uVar, j10);
    }

    public static final /* synthetic */ void b(p pVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.j(serialDescriptor, 0, e2.f24564a, c0.a(pVar.f17771a));
        dVar.j(serialDescriptor, 1, l.a.f17744a, pVar.f17772b);
        dVar.j(serialDescriptor, 2, u.a.f17812a, pVar.f17773c);
        dVar.j(serialDescriptor, 3, h.f17712a, Color.m1588boximpl(pVar.f17774d));
    }

    public final long a() {
        return this.f17774d;
    }

    @NotNull
    public final l c() {
        return this.f17772b;
    }

    public final int d() {
        return this.f17771a;
    }

    @NotNull
    public final u e() {
        return this.f17773c;
    }

    public /* synthetic */ p(int i10, c0 c0Var, l lVar, u uVar, @z9.h(with = h.class) Color color, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, c0Var, lVar, uVar, color, s1Var);
    }

    public p(int i10, l horizontalAlignment, u verticalAlignment, long j10) {
        kotlin.jvm.internal.t.i(horizontalAlignment, "horizontalAlignment");
        kotlin.jvm.internal.t.i(verticalAlignment, "verticalAlignment");
        this.f17771a = i10;
        this.f17772b = horizontalAlignment;
        this.f17773c = verticalAlignment;
        this.f17774d = j10;
    }

    public p(int i10, c0 c0Var, l lVar, u uVar, Color color, s1 s1Var) {
        if (15 != (i10 & 15)) {
            i1.a(i10, 15, a.f17775a.getDescriptor());
        }
        this.f17771a = c0Var.g();
        this.f17772b = lVar;
        this.f17773c = uVar;
        this.f17774d = color.m1608unboximpl();
    }
}

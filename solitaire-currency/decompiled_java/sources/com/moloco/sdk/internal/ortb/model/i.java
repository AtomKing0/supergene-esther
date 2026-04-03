package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.moloco.sdk.internal.ortb.model.l;
import com.moloco.sdk.internal.ortb.model.u;
import da.d0;
import da.e2;
import da.l0;
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
public final class i {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Integer f17717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final l f17718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final u f17719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f17720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f17721h;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17723b;

        static {
            a aVar = new a();
            f17722a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CountDownTimer", aVar, 8);
            pluginGeneratedSerialDescriptor.k("custom_timer_desc", true);
            pluginGeneratedSerialDescriptor.k("is_default_timer", true);
            pluginGeneratedSerialDescriptor.k("control_size", true);
            pluginGeneratedSerialDescriptor.k("padding", true);
            pluginGeneratedSerialDescriptor.k("horizontal_alignment", true);
            pluginGeneratedSerialDescriptor.k("vertical_alignment", true);
            pluginGeneratedSerialDescriptor.k("foreground_color", true);
            pluginGeneratedSerialDescriptor.k("background_color", true);
            f17723b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i deserialize(@NotNull Decoder decoder) {
            Object objY;
            Object objY2;
            Object objY3;
            int i10;
            Object objY4;
            Object objK;
            Object objY5;
            boolean z10;
            Object objK2;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 7;
            int i12 = 6;
            if (cVarB.p()) {
                objK2 = cVarB.k(descriptor, 0, w1.f24648a, null);
                boolean zC = cVarB.C(descriptor, 1);
                objY4 = cVarB.y(descriptor, 2, e2.f24564a, null);
                objK = cVarB.k(descriptor, 3, l0.f24594a, null);
                objY5 = cVarB.y(descriptor, 4, l.a.f17744a, null);
                objY3 = cVarB.y(descriptor, 5, u.a.f17812a, null);
                h hVar = h.f17712a;
                objY2 = cVarB.y(descriptor, 6, hVar, null);
                objY = cVarB.y(descriptor, 7, hVar, null);
                i10 = 255;
                z10 = zC;
            } else {
                boolean z11 = true;
                boolean zC2 = false;
                Object objY6 = null;
                Object objY7 = null;
                Object objK3 = null;
                Object objY8 = null;
                Object objK4 = null;
                Object objY9 = null;
                Object objY10 = null;
                int i13 = 0;
                while (z11) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z11 = false;
                            i12 = 6;
                            break;
                        case 0:
                            objK3 = cVarB.k(descriptor, 0, w1.f24648a, objK3);
                            i13 |= 1;
                            i11 = 7;
                            i12 = 6;
                            break;
                        case 1:
                            zC2 = cVarB.C(descriptor, 1);
                            i13 |= 2;
                            i11 = 7;
                            break;
                        case 2:
                            objY8 = cVarB.y(descriptor, 2, e2.f24564a, objY8);
                            i13 |= 4;
                            i11 = 7;
                            break;
                        case 3:
                            objK4 = cVarB.k(descriptor, 3, l0.f24594a, objK4);
                            i13 |= 8;
                            i11 = 7;
                            break;
                        case 4:
                            objY9 = cVarB.y(descriptor, 4, l.a.f17744a, objY9);
                            i13 |= 16;
                            break;
                        case 5:
                            objY10 = cVarB.y(descriptor, 5, u.a.f17812a, objY10);
                            i13 |= 32;
                            break;
                        case 6:
                            objY7 = cVarB.y(descriptor, i12, h.f17712a, objY7);
                            i13 |= 64;
                            break;
                        case 7:
                            objY6 = cVarB.y(descriptor, i11, h.f17712a, objY6);
                            i13 |= 128;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                objY = objY6;
                objY2 = objY7;
                objY3 = objY10;
                i10 = i13;
                objY4 = objY8;
                objK = objK4;
                objY5 = objY9;
                Object obj = objK3;
                z10 = zC2;
                objK2 = obj;
            }
            cVarB.c(descriptor);
            return new i(i10, (String) objK2, z10, (c0) objY4, (Integer) objK, (l) objY5, (u) objY3, (Color) objY2, (Color) objY, null, null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull i value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            i.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            h hVar = h.f17712a;
            return new KSerializer[]{aa.a.s(w1.f24648a), da.h.f24574a, e2.f24564a, aa.a.s(l0.f24594a), l.a.f17744a, u.a.f17812a, hVar, hVar};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17723b;
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
        public final KSerializer<i> serializer() {
            return a.f17722a;
        }

        public b() {
        }
    }

    public /* synthetic */ i(int i10, String str, boolean z10, c0 c0Var, Integer num, l lVar, u uVar, @z9.h(with = h.class) Color color, @z9.h(with = h.class) Color color2, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, str, z10, c0Var, num, lVar, uVar, color, color2, s1Var);
    }

    public static final /* synthetic */ void b(i iVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (dVar.z(serialDescriptor, 0) || iVar.f17714a != null) {
            dVar.h(serialDescriptor, 0, w1.f24648a, iVar.f17714a);
        }
        if (dVar.z(serialDescriptor, 1) || !iVar.f17715b) {
            dVar.x(serialDescriptor, 1, iVar.f17715b);
        }
        if (dVar.z(serialDescriptor, 2) || iVar.f17716c != 30) {
            dVar.j(serialDescriptor, 2, e2.f24564a, c0.a(iVar.f17716c));
        }
        if (dVar.z(serialDescriptor, 3) || iVar.f17717d != null) {
            dVar.h(serialDescriptor, 3, l0.f24594a, iVar.f17717d);
        }
        if (dVar.z(serialDescriptor, 4) || iVar.f17718e != l.Right) {
            dVar.j(serialDescriptor, 4, l.a.f17744a, iVar.f17718e);
        }
        if (dVar.z(serialDescriptor, 5) || iVar.f17719f != u.Top) {
            dVar.j(serialDescriptor, 5, u.a.f17812a, iVar.f17719f);
        }
        if (dVar.z(serialDescriptor, 6) || !Color.m1599equalsimpl0(iVar.f17720g, ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")))) {
            dVar.j(serialDescriptor, 6, h.f17712a, Color.m1588boximpl(iVar.f17720g));
        }
        if (!dVar.z(serialDescriptor, 7) && Color.m1599equalsimpl0(iVar.f17721h, ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")))) {
            return;
        }
        dVar.j(serialDescriptor, 7, h.f17712a, Color.m1588boximpl(iVar.f17721h));
    }

    public final long a() {
        return this.f17721h;
    }

    public final int c() {
        return this.f17716c;
    }

    @Nullable
    public final String d() {
        return this.f17714a;
    }

    public final long e() {
        return this.f17720g;
    }

    @NotNull
    public final l f() {
        return this.f17718e;
    }

    @NotNull
    public final u g() {
        return this.f17719f;
    }

    public final boolean h() {
        return this.f17715b;
    }

    public i(int i10, String str, boolean z10, c0 c0Var, Integer num, l lVar, u uVar, Color color, Color color2, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17714a = null;
        } else {
            this.f17714a = str;
        }
        if ((i10 & 2) == 0) {
            this.f17715b = true;
        } else {
            this.f17715b = z10;
        }
        this.f17716c = (i10 & 4) == 0 ? 30 : c0Var.g();
        if ((i10 & 8) == 0) {
            this.f17717d = null;
        } else {
            this.f17717d = num;
        }
        if ((i10 & 16) == 0) {
            this.f17718e = l.Right;
        } else {
            this.f17718e = lVar;
        }
        if ((i10 & 32) == 0) {
            this.f17719f = u.Top;
        } else {
            this.f17719f = uVar;
        }
        this.f17720g = (i10 & 64) == 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")) : color.m1608unboximpl();
        this.f17721h = (i10 & 128) == 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")) : color2.m1608unboximpl();
    }
}

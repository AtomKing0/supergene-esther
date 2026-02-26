package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.k;
import da.d0;
import da.s1;
import da.w1;
import io.sentry.protocol.App;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class j {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f17725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f17726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f17727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f17728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f17729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f17730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final k f17731h;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17733b;

        static {
            a aVar = new a();
            f17732a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DEC", aVar, 8);
            pluginGeneratedSerialDescriptor.k("app_icon_url", true);
            pluginGeneratedSerialDescriptor.k(App.JsonKeys.APP_NAME, true);
            pluginGeneratedSerialDescriptor.k("imp_link", true);
            pluginGeneratedSerialDescriptor.k("click_through", true);
            pluginGeneratedSerialDescriptor.k("click_tracking", true);
            pluginGeneratedSerialDescriptor.k("cta_text", true);
            pluginGeneratedSerialDescriptor.k("skip_event", true);
            pluginGeneratedSerialDescriptor.k("close", true);
            f17733b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j deserialize(@NotNull Decoder decoder) {
            Object objK;
            int i10;
            Object objK2;
            Object objK3;
            Object objK4;
            Object objK5;
            Object objK6;
            Object objK7;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 7;
            Object objK8 = null;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                Object objK9 = cVarB.k(descriptor, 0, w1Var, null);
                objK4 = cVarB.k(descriptor, 1, w1Var, null);
                objK5 = cVarB.k(descriptor, 2, w1Var, null);
                objK6 = cVarB.k(descriptor, 3, w1Var, null);
                objK7 = cVarB.k(descriptor, 4, w1Var, null);
                Object objK10 = cVarB.k(descriptor, 5, w1Var, null);
                objK3 = cVarB.k(descriptor, 6, w1Var, null);
                objK2 = cVarB.k(descriptor, 7, k.a.f17735a, null);
                objK8 = objK9;
                objK = objK10;
                i10 = 255;
            } else {
                boolean z10 = true;
                int i12 = 0;
                Object objK11 = null;
                Object objK12 = null;
                objK = null;
                Object objK13 = null;
                Object objK14 = null;
                Object objK15 = null;
                Object objK16 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z10 = false;
                            i11 = 7;
                            break;
                        case 0:
                            objK8 = cVarB.k(descriptor, 0, w1.f24648a, objK8);
                            i12 |= 1;
                            i11 = 7;
                            break;
                        case 1:
                            objK13 = cVarB.k(descriptor, 1, w1.f24648a, objK13);
                            i12 |= 2;
                            i11 = 7;
                            break;
                        case 2:
                            objK14 = cVarB.k(descriptor, 2, w1.f24648a, objK14);
                            i12 |= 4;
                            i11 = 7;
                            break;
                        case 3:
                            objK15 = cVarB.k(descriptor, 3, w1.f24648a, objK15);
                            i12 |= 8;
                            i11 = 7;
                            break;
                        case 4:
                            objK16 = cVarB.k(descriptor, 4, w1.f24648a, objK16);
                            i12 |= 16;
                            break;
                        case 5:
                            objK = cVarB.k(descriptor, 5, w1.f24648a, objK);
                            i12 |= 32;
                            break;
                        case 6:
                            objK12 = cVarB.k(descriptor, 6, w1.f24648a, objK12);
                            i12 |= 64;
                            break;
                        case 7:
                            objK11 = cVarB.k(descriptor, i11, k.a.f17735a, objK11);
                            i12 |= 128;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                i10 = i12;
                objK2 = objK11;
                objK3 = objK12;
                objK4 = objK13;
                objK5 = objK14;
                objK6 = objK15;
                objK7 = objK16;
            }
            cVarB.c(descriptor);
            return new j(i10, (String) objK8, (String) objK4, (String) objK5, (String) objK6, (String) objK7, (String) objK, (String) objK3, (k) objK2, (s1) null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull j value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            j.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(k.a.f17735a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17733b;
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
        public final KSerializer<j> serializer() {
            return a.f17732a;
        }

        public b() {
        }
    }

    public j() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (k) null, 255, (kotlin.jvm.internal.k) null);
    }

    public static final /* synthetic */ void b(j jVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (dVar.z(serialDescriptor, 0) || jVar.f17724a != null) {
            dVar.h(serialDescriptor, 0, w1.f24648a, jVar.f17724a);
        }
        if (dVar.z(serialDescriptor, 1) || jVar.f17725b != null) {
            dVar.h(serialDescriptor, 1, w1.f24648a, jVar.f17725b);
        }
        if (dVar.z(serialDescriptor, 2) || jVar.f17726c != null) {
            dVar.h(serialDescriptor, 2, w1.f24648a, jVar.f17726c);
        }
        if (dVar.z(serialDescriptor, 3) || jVar.f17727d != null) {
            dVar.h(serialDescriptor, 3, w1.f24648a, jVar.f17727d);
        }
        if (dVar.z(serialDescriptor, 4) || jVar.f17728e != null) {
            dVar.h(serialDescriptor, 4, w1.f24648a, jVar.f17728e);
        }
        if (dVar.z(serialDescriptor, 5) || jVar.f17729f != null) {
            dVar.h(serialDescriptor, 5, w1.f24648a, jVar.f17729f);
        }
        if (dVar.z(serialDescriptor, 6) || jVar.f17730g != null) {
            dVar.h(serialDescriptor, 6, w1.f24648a, jVar.f17730g);
        }
        if (!dVar.z(serialDescriptor, 7) && jVar.f17731h == null) {
            return;
        }
        dVar.h(serialDescriptor, 7, k.a.f17735a, jVar.f17731h);
    }

    @Nullable
    public final String a() {
        return this.f17724a;
    }

    @Nullable
    public final String c() {
        return this.f17725b;
    }

    @Nullable
    public final k d() {
        return this.f17731h;
    }

    @Nullable
    public final String e() {
        return this.f17729f;
    }

    @Nullable
    public final String f() {
        return this.f17728e;
    }

    @Nullable
    public final String g() {
        return this.f17727d;
    }

    @Nullable
    public final String h() {
        return this.f17726c;
    }

    @Nullable
    public final String i() {
        return this.f17730g;
    }

    public /* synthetic */ j(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17724a = null;
        } else {
            this.f17724a = str;
        }
        if ((i10 & 2) == 0) {
            this.f17725b = null;
        } else {
            this.f17725b = str2;
        }
        if ((i10 & 4) == 0) {
            this.f17726c = null;
        } else {
            this.f17726c = str3;
        }
        if ((i10 & 8) == 0) {
            this.f17727d = null;
        } else {
            this.f17727d = str4;
        }
        if ((i10 & 16) == 0) {
            this.f17728e = null;
        } else {
            this.f17728e = str5;
        }
        if ((i10 & 32) == 0) {
            this.f17729f = null;
        } else {
            this.f17729f = str6;
        }
        if ((i10 & 64) == 0) {
            this.f17730g = null;
        } else {
            this.f17730g = str7;
        }
        if ((i10 & 128) == 0) {
            this.f17731h = null;
        } else {
            this.f17731h = kVar;
        }
    }

    public j(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable k kVar) {
        this.f17724a = str;
        this.f17725b = str2;
        this.f17726c = str3;
        this.f17727d = str4;
        this.f17728e = str5;
        this.f17729f = str6;
        this.f17730g = str7;
        this.f17731h = kVar;
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar, int i10, kotlin.jvm.internal.k kVar2) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) == 0 ? kVar : null);
    }
}

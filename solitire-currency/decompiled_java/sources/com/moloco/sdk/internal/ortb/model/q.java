package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import da.d0;
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
public final class q {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f17778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f17779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f17780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f17781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f17782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f17783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f17784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f17785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f17786j;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17788b;

        static {
            a aVar = new a();
            f17787a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SdkEvents", aVar, 10);
            pluginGeneratedSerialDescriptor.k("on_ad_load_start", true);
            pluginGeneratedSerialDescriptor.k("on_ad_load_failed", true);
            pluginGeneratedSerialDescriptor.k("on_ad_load_success", true);
            pluginGeneratedSerialDescriptor.k("on_ad_show_failed", true);
            pluginGeneratedSerialDescriptor.k("on_ad_show_success", true);
            pluginGeneratedSerialDescriptor.k("on_ad_clicked", true);
            pluginGeneratedSerialDescriptor.k("on_ad_hidden", true);
            pluginGeneratedSerialDescriptor.k("on_user_rewarded", true);
            pluginGeneratedSerialDescriptor.k("on_rewarded_video_started", true);
            pluginGeneratedSerialDescriptor.k("on_rewarded_video_completed", true);
            f17788b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            int i10;
            Object objK4;
            Object objK5;
            Object objK6;
            Object objK7;
            Object objK8;
            Object objK9;
            Object objK10;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 9;
            Object objK11 = null;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                objK9 = cVarB.k(descriptor, 0, w1Var, null);
                Object objK12 = cVarB.k(descriptor, 1, w1Var, null);
                objK10 = cVarB.k(descriptor, 2, w1Var, null);
                objK8 = cVarB.k(descriptor, 3, w1Var, null);
                Object objK13 = cVarB.k(descriptor, 4, w1Var, null);
                objK7 = cVarB.k(descriptor, 5, w1Var, null);
                objK6 = cVarB.k(descriptor, 6, w1Var, null);
                Object objK14 = cVarB.k(descriptor, 7, w1Var, null);
                objK5 = cVarB.k(descriptor, 8, w1Var, null);
                objK4 = cVarB.k(descriptor, 9, w1Var, null);
                objK3 = objK12;
                objK2 = objK13;
                objK = objK14;
                i10 = 1023;
            } else {
                boolean z10 = true;
                int i12 = 0;
                Object objK15 = null;
                Object objK16 = null;
                Object objK17 = null;
                objK = null;
                Object objK18 = null;
                objK2 = null;
                Object objK19 = null;
                objK3 = null;
                Object objK20 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z10 = false;
                            i11 = 9;
                            break;
                        case 0:
                            objK11 = cVarB.k(descriptor, 0, w1.f24648a, objK11);
                            i12 |= 1;
                            i11 = 9;
                            break;
                        case 1:
                            objK3 = cVarB.k(descriptor, 1, w1.f24648a, objK3);
                            i12 |= 2;
                            i11 = 9;
                            break;
                        case 2:
                            objK20 = cVarB.k(descriptor, 2, w1.f24648a, objK20);
                            i12 |= 4;
                            i11 = 9;
                            break;
                        case 3:
                            objK19 = cVarB.k(descriptor, 3, w1.f24648a, objK19);
                            i12 |= 8;
                            i11 = 9;
                            break;
                        case 4:
                            objK2 = cVarB.k(descriptor, 4, w1.f24648a, objK2);
                            i12 |= 16;
                            i11 = 9;
                            break;
                        case 5:
                            objK18 = cVarB.k(descriptor, 5, w1.f24648a, objK18);
                            i12 |= 32;
                            i11 = 9;
                            break;
                        case 6:
                            objK17 = cVarB.k(descriptor, 6, w1.f24648a, objK17);
                            i12 |= 64;
                            i11 = 9;
                            break;
                        case 7:
                            objK = cVarB.k(descriptor, 7, w1.f24648a, objK);
                            i12 |= 128;
                            i11 = 9;
                            break;
                        case 8:
                            objK16 = cVarB.k(descriptor, 8, w1.f24648a, objK16);
                            i12 |= 256;
                            break;
                        case 9:
                            objK15 = cVarB.k(descriptor, i11, w1.f24648a, objK15);
                            i12 |= 512;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                i10 = i12;
                objK4 = objK15;
                objK5 = objK16;
                objK6 = objK17;
                objK7 = objK18;
                objK8 = objK19;
                objK9 = objK11;
                objK10 = objK20;
            }
            cVarB.c(descriptor);
            return new q(i10, (String) objK9, (String) objK3, (String) objK10, (String) objK8, (String) objK2, (String) objK7, (String) objK6, (String) objK, (String) objK5, (String) objK4, (s1) null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull q value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            q.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var), aa.a.s(w1Var)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17788b;
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
        public final KSerializer<q> serializer() {
            return a.f17787a;
        }

        public b() {
        }
    }

    public q() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (kotlin.jvm.internal.k) null);
    }

    public static final /* synthetic */ void b(q qVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (dVar.z(serialDescriptor, 0) || qVar.f17777a != null) {
            dVar.h(serialDescriptor, 0, w1.f24648a, qVar.f17777a);
        }
        if (dVar.z(serialDescriptor, 1) || qVar.f17778b != null) {
            dVar.h(serialDescriptor, 1, w1.f24648a, qVar.f17778b);
        }
        if (dVar.z(serialDescriptor, 2) || qVar.f17779c != null) {
            dVar.h(serialDescriptor, 2, w1.f24648a, qVar.f17779c);
        }
        if (dVar.z(serialDescriptor, 3) || qVar.f17780d != null) {
            dVar.h(serialDescriptor, 3, w1.f24648a, qVar.f17780d);
        }
        if (dVar.z(serialDescriptor, 4) || qVar.f17781e != null) {
            dVar.h(serialDescriptor, 4, w1.f24648a, qVar.f17781e);
        }
        if (dVar.z(serialDescriptor, 5) || qVar.f17782f != null) {
            dVar.h(serialDescriptor, 5, w1.f24648a, qVar.f17782f);
        }
        if (dVar.z(serialDescriptor, 6) || qVar.f17783g != null) {
            dVar.h(serialDescriptor, 6, w1.f24648a, qVar.f17783g);
        }
        if (dVar.z(serialDescriptor, 7) || qVar.f17784h != null) {
            dVar.h(serialDescriptor, 7, w1.f24648a, qVar.f17784h);
        }
        if (dVar.z(serialDescriptor, 8) || qVar.f17785i != null) {
            dVar.h(serialDescriptor, 8, w1.f24648a, qVar.f17785i);
        }
        if (!dVar.z(serialDescriptor, 9) && qVar.f17786j == null) {
            return;
        }
        dVar.h(serialDescriptor, 9, w1.f24648a, qVar.f17786j);
    }

    @Nullable
    public final String a() {
        return this.f17782f;
    }

    @Nullable
    public final String c() {
        return this.f17783g;
    }

    @Nullable
    public final String d() {
        return this.f17778b;
    }

    @Nullable
    public final String e() {
        return this.f17777a;
    }

    @Nullable
    public final String f() {
        return this.f17779c;
    }

    @Nullable
    public final String g() {
        return this.f17780d;
    }

    @Nullable
    public final String h() {
        return this.f17781e;
    }

    @Nullable
    public final String i() {
        return this.f17786j;
    }

    @Nullable
    public final String j() {
        return this.f17785i;
    }

    @Nullable
    public final String k() {
        return this.f17784h;
    }

    public /* synthetic */ q(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17777a = null;
        } else {
            this.f17777a = str;
        }
        if ((i10 & 2) == 0) {
            this.f17778b = null;
        } else {
            this.f17778b = str2;
        }
        if ((i10 & 4) == 0) {
            this.f17779c = null;
        } else {
            this.f17779c = str3;
        }
        if ((i10 & 8) == 0) {
            this.f17780d = null;
        } else {
            this.f17780d = str4;
        }
        if ((i10 & 16) == 0) {
            this.f17781e = null;
        } else {
            this.f17781e = str5;
        }
        if ((i10 & 32) == 0) {
            this.f17782f = null;
        } else {
            this.f17782f = str6;
        }
        if ((i10 & 64) == 0) {
            this.f17783g = null;
        } else {
            this.f17783g = str7;
        }
        if ((i10 & 128) == 0) {
            this.f17784h = null;
        } else {
            this.f17784h = str8;
        }
        if ((i10 & 256) == 0) {
            this.f17785i = null;
        } else {
            this.f17785i = str9;
        }
        if ((i10 & 512) == 0) {
            this.f17786j = null;
        } else {
            this.f17786j = str10;
        }
    }

    public q(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.f17777a = str;
        this.f17778b = str2;
        this.f17779c = str3;
        this.f17780d = str4;
        this.f17781e = str5;
        this.f17782f = str6;
        this.f17783g = str7;
        this.f17784h = str8;
        this.f17785i = str9;
        this.f17786j = str10;
    }

    public /* synthetic */ q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) == 0 ? str10 : null);
    }
}

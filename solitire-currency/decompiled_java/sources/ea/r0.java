package ea;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ba.i;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamingJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public class r0 extends ca.a implements kotlinx.serialization.json.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.a f25478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final y0 f25479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final ea.a f25480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final fa.c f25481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private a f25483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.e f25484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final x f25485h;

    /* JADX INFO: compiled from: StreamingJsonDecoder.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f25486a;

        public a(@Nullable String str) {
            this.f25486a = str;
        }
    }

    /* JADX INFO: compiled from: StreamingJsonDecoder.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25487a;

        static {
            int[] iArr = new int[y0.values().length];
            try {
                iArr[y0.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[y0.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[y0.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[y0.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25487a = iArr;
        }
    }

    public r0(@NotNull kotlinx.serialization.json.a json, @NotNull y0 mode, @NotNull ea.a lexer, @NotNull SerialDescriptor descriptor, @Nullable a aVar) {
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(mode, "mode");
        kotlin.jvm.internal.t.i(lexer, "lexer");
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        this.f25478a = json;
        this.f25479b = mode;
        this.f25480c = lexer;
        this.f25481d = json.a();
        this.f25482e = -1;
        this.f25483f = aVar;
        kotlinx.serialization.json.e eVarE = json.e();
        this.f25484g = eVarE;
        this.f25485h = eVarE.f() ? null : new x(descriptor);
    }

    private final void K() {
        if (this.f25480c.E() != 4) {
            return;
        }
        ea.a.y(this.f25480c, "Unexpected leading comma", 0, null, 6, null);
        throw new v8.h();
    }

    private final boolean L(SerialDescriptor serialDescriptor, int i10) {
        String strF;
        kotlinx.serialization.json.a aVar = this.f25478a;
        SerialDescriptor serialDescriptorG = serialDescriptor.g(i10);
        if (!serialDescriptorG.b() && (!this.f25480c.M())) {
            return true;
        }
        if (!kotlin.jvm.internal.t.d(serialDescriptorG.getKind(), i.b.f2320a) || (strF = this.f25480c.F(this.f25484g.l())) == null || b0.d(serialDescriptorG, aVar, strF) != -3) {
            return false;
        }
        this.f25480c.q();
        return true;
    }

    private final int M() {
        boolean zL = this.f25480c.L();
        if (!this.f25480c.f()) {
            if (!zL) {
                return -1;
            }
            ea.a.y(this.f25480c, "Unexpected trailing comma", 0, null, 6, null);
            throw new v8.h();
        }
        int i10 = this.f25482e;
        if (i10 != -1 && !zL) {
            ea.a.y(this.f25480c, "Expected end of the array or comma", 0, null, 6, null);
            throw new v8.h();
        }
        int i11 = i10 + 1;
        this.f25482e = i11;
        return i11;
    }

    private final int N() {
        int i10 = this.f25482e;
        boolean zL = false;
        boolean z10 = i10 % 2 != 0;
        if (!z10) {
            this.f25480c.o(':');
        } else if (i10 != -1) {
            zL = this.f25480c.L();
        }
        if (!this.f25480c.f()) {
            if (!zL) {
                return -1;
            }
            ea.a.y(this.f25480c, "Expected '}', but had ',' instead", 0, null, 6, null);
            throw new v8.h();
        }
        if (z10) {
            if (this.f25482e == -1) {
                ea.a aVar = this.f25480c;
                boolean z11 = !zL;
                int i11 = aVar.f25411a;
                if (!z11) {
                    ea.a.y(aVar, "Unexpected trailing comma", i11, null, 4, null);
                    throw new v8.h();
                }
            } else {
                ea.a aVar2 = this.f25480c;
                int i12 = aVar2.f25411a;
                if (!zL) {
                    ea.a.y(aVar2, "Expected comma after the key-value pair", i12, null, 4, null);
                    throw new v8.h();
                }
            }
        }
        int i13 = this.f25482e + 1;
        this.f25482e = i13;
        return i13;
    }

    private final int O(SerialDescriptor serialDescriptor) {
        boolean zL;
        boolean zL2 = this.f25480c.L();
        while (this.f25480c.f()) {
            String strP = P();
            this.f25480c.o(':');
            int iD = b0.d(serialDescriptor, this.f25478a, strP);
            boolean z10 = false;
            if (iD == -3) {
                z10 = true;
                zL = false;
            } else {
                if (!this.f25484g.d() || !L(serialDescriptor, iD)) {
                    x xVar = this.f25485h;
                    if (xVar != null) {
                        xVar.c(iD);
                    }
                    return iD;
                }
                zL = this.f25480c.L();
            }
            zL2 = z10 ? Q(strP) : zL;
        }
        if (zL2) {
            ea.a.y(this.f25480c, "Unexpected trailing comma", 0, null, 6, null);
            throw new v8.h();
        }
        x xVar2 = this.f25485h;
        if (xVar2 != null) {
            return xVar2.d();
        }
        return -1;
    }

    private final String P() {
        return this.f25484g.l() ? this.f25480c.t() : this.f25480c.k();
    }

    private final boolean Q(String str) {
        if (this.f25484g.g() || S(this.f25483f, str)) {
            this.f25480c.H(this.f25484g.l());
        } else {
            this.f25480c.A(str);
        }
        return this.f25480c.L();
    }

    private final void R(SerialDescriptor serialDescriptor) {
        while (o(serialDescriptor) != -1) {
        }
    }

    private final boolean S(a aVar, String str) {
        if (aVar == null || !kotlin.jvm.internal.t.d(aVar.f25486a, str)) {
            return false;
        }
        aVar.f25486a = null;
        return true;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public <T> T D(@NotNull z9.b<T> deserializer) {
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        try {
            if ((deserializer instanceof da.b) && !this.f25478a.e().k()) {
                String strC = p0.c(deserializer.getDescriptor(), this.f25478a);
                String strL = this.f25480c.l(strC, this.f25484g.l());
                z9.b<? extends T> bVarC = strL != null ? ((da.b) deserializer).c(this, strL) : null;
                if (bVarC == null) {
                    return (T) p0.d(this, deserializer);
                }
                this.f25483f = new a(strC);
                return bVarC.deserialize(this);
            }
            return deserializer.deserialize(this);
        } catch (z9.c e10) {
            throw new z9.c(e10.a(), e10.getMessage() + " at path: " + this.f25480c.f25412b.a(), e10);
        }
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public boolean E() {
        x xVar = this.f25485h;
        return !(xVar != null ? xVar.b() : false) && this.f25480c.M();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public byte H() {
        long jP = this.f25480c.p();
        byte b10 = (byte) jP;
        if (jP == b10) {
            return b10;
        }
        ea.a.y(this.f25480c, "Failed to parse byte for input '" + jP + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    @Override // kotlinx.serialization.encoding.Decoder, ca.c
    @NotNull
    public fa.c a() {
        return this.f25481d;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    @NotNull
    public ca.c b(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        y0 y0VarB = z0.b(this.f25478a, descriptor);
        this.f25480c.f25412b.c(descriptor);
        this.f25480c.o(y0VarB.f25512a);
        K();
        int i10 = b.f25487a[y0VarB.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? new r0(this.f25478a, y0VarB, this.f25480c, descriptor, this.f25483f) : (this.f25479b == y0VarB && this.f25478a.e().f()) ? this : new r0(this.f25478a, y0VarB, this.f25480c, descriptor, this.f25483f);
    }

    @Override // ca.a, ca.c
    public void c(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        if (this.f25478a.e().g() && descriptor.d() == 0) {
            R(descriptor);
        }
        this.f25480c.o(this.f25479b.f25513b);
        this.f25480c.f25412b.b();
    }

    @Override // kotlinx.serialization.json.f
    @NotNull
    public final kotlinx.serialization.json.a d() {
        return this.f25478a;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public int e(@NotNull SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        return b0.e(enumDescriptor, this.f25478a, z(), " at path " + this.f25480c.f25412b.a());
    }

    @Override // kotlinx.serialization.json.f
    @NotNull
    public JsonElement g() {
        return new n0(this.f25478a.e(), this.f25480c).e();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public int h() {
        long jP = this.f25480c.p();
        int i10 = (int) jP;
        if (jP == i10) {
            return i10;
        }
        ea.a.y(this.f25480c, "Failed to parse int for input '" + jP + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    @Nullable
    public Void j() {
        return null;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public long m() {
        return this.f25480c.p();
    }

    @Override // ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        int i10 = b.f25487a[this.f25479b.ordinal()];
        int iM = i10 != 2 ? i10 != 4 ? M() : O(descriptor) : N();
        if (this.f25479b != y0.MAP) {
            this.f25480c.f25412b.g(iM);
        }
        return iM;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder q(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return t0.a(descriptor) ? new v(this.f25480c, this.f25478a) : super.q(descriptor);
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public short s() {
        long jP = this.f25480c.p();
        short s10 = (short) jP;
        if (jP == s10) {
            return s10;
        }
        ea.a.y(this.f25480c, "Failed to parse short for input '" + jP + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public float t() {
        ea.a aVar = this.f25480c;
        String strS = aVar.s();
        try {
            float f10 = Float.parseFloat(strS);
            if (!this.f25478a.e().a()) {
                if (!((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true)) {
                    a0.j(this.f25480c, Float.valueOf(f10));
                    throw new v8.h();
                }
            }
            return f10;
        } catch (IllegalArgumentException unused) {
            ea.a.y(aVar, "Failed to parse type '" + TypedValues.Custom.S_FLOAT + "' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public double v() {
        ea.a aVar = this.f25480c;
        String strS = aVar.s();
        try {
            double d10 = Double.parseDouble(strS);
            if (!this.f25478a.e().a()) {
                if (!((Double.isInfinite(d10) || Double.isNaN(d10)) ? false : true)) {
                    a0.j(this.f25480c, Double.valueOf(d10));
                    throw new v8.h();
                }
            }
            return d10;
        } catch (IllegalArgumentException unused) {
            ea.a.y(aVar, "Failed to parse type 'double' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public boolean w() {
        return this.f25484g.l() ? this.f25480c.i() : this.f25480c.g();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public char x() {
        String strS = this.f25480c.s();
        if (strS.length() == 1) {
            return strS.charAt(0);
        }
        ea.a.y(this.f25480c, "Expected single char, but got '" + strS + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    @Override // ca.a, ca.c
    public <T> T y(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.b<T> deserializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        boolean z10 = this.f25479b == y0.MAP && (i10 & 1) == 0;
        if (z10) {
            this.f25480c.f25412b.d();
        }
        T t11 = (T) super.y(descriptor, i10, deserializer, t10);
        if (z10) {
            this.f25480c.f25412b.f(t11);
        }
        return t11;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    @NotNull
    public String z() {
        return this.f25484g.l() ? this.f25480c.t() : this.f25480c.q();
    }
}

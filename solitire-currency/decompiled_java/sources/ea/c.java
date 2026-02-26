package ea;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ba.i;
import ba.j;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
abstract class c extends da.y0 implements kotlinx.serialization.json.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.a f25416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final JsonElement f25417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    protected final kotlinx.serialization.json.e f25418e;

    public /* synthetic */ c(kotlinx.serialization.json.a aVar, JsonElement jsonElement, kotlin.jvm.internal.k kVar) {
        this(aVar, jsonElement);
    }

    private final kotlinx.serialization.json.n d0(JsonPrimitive jsonPrimitive, String str) {
        kotlinx.serialization.json.n nVar = jsonPrimitive instanceof kotlinx.serialization.json.n ? (kotlinx.serialization.json.n) jsonPrimitive : null;
        if (nVar != null) {
            return nVar;
        }
        throw a0.e(-1, "Unexpected 'null' when " + str + " was expected");
    }

    private final JsonElement f0() {
        JsonElement jsonElementE0;
        String strU = U();
        return (strU == null || (jsonElementE0 = e0(strU)) == null) ? s0() : jsonElementE0;
    }

    private final Void t0(String str) {
        throw a0.f(-1, "Failed to parse '" + str + '\'', f0().toString());
    }

    @Override // da.x1, kotlinx.serialization.encoding.Decoder
    public <T> T D(@NotNull z9.b<T> deserializer) {
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        return (T) p0.d(this, deserializer);
    }

    @Override // da.x1, kotlinx.serialization.encoding.Decoder
    public boolean E() {
        return !(f0() instanceof JsonNull);
    }

    @Override // da.y0
    @NotNull
    protected String Z(@NotNull String parentName, @NotNull String childName) {
        kotlin.jvm.internal.t.i(parentName, "parentName");
        kotlin.jvm.internal.t.i(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.encoding.Decoder, ca.c
    @NotNull
    public fa.c a() {
        return d().a();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @NotNull
    public ca.c b(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        JsonElement jsonElementF0 = f0();
        ba.i kind = descriptor.getKind();
        if (kotlin.jvm.internal.t.d(kind, j.b.f2322a) ? true : kind instanceof ba.d) {
            kotlinx.serialization.json.a aVarD = d();
            if (jsonElementF0 instanceof JsonArray) {
                return new j0(aVarD, (JsonArray) jsonElementF0);
            }
            throw a0.e(-1, "Expected " + kotlin.jvm.internal.o0.b(JsonArray.class) + " as the serialized body of " + descriptor.h() + ", but had " + kotlin.jvm.internal.o0.b(jsonElementF0.getClass()));
        }
        if (!kotlin.jvm.internal.t.d(kind, j.c.f2323a)) {
            kotlinx.serialization.json.a aVarD2 = d();
            if (jsonElementF0 instanceof JsonObject) {
                return new h0(aVarD2, (JsonObject) jsonElementF0, null, null, 12, null);
            }
            throw a0.e(-1, "Expected " + kotlin.jvm.internal.o0.b(JsonObject.class) + " as the serialized body of " + descriptor.h() + ", but had " + kotlin.jvm.internal.o0.b(jsonElementF0.getClass()));
        }
        kotlinx.serialization.json.a aVarD3 = d();
        SerialDescriptor serialDescriptorA = z0.a(descriptor.g(0), aVarD3.a());
        ba.i kind2 = serialDescriptorA.getKind();
        if ((kind2 instanceof ba.e) || kotlin.jvm.internal.t.d(kind2, i.b.f2320a)) {
            kotlinx.serialization.json.a aVarD4 = d();
            if (jsonElementF0 instanceof JsonObject) {
                return new l0(aVarD4, (JsonObject) jsonElementF0);
            }
            throw a0.e(-1, "Expected " + kotlin.jvm.internal.o0.b(JsonObject.class) + " as the serialized body of " + descriptor.h() + ", but had " + kotlin.jvm.internal.o0.b(jsonElementF0.getClass()));
        }
        if (!aVarD3.e().b()) {
            throw a0.d(serialDescriptorA);
        }
        kotlinx.serialization.json.a aVarD5 = d();
        if (jsonElementF0 instanceof JsonArray) {
            return new j0(aVarD5, (JsonArray) jsonElementF0);
        }
        throw a0.e(-1, "Expected " + kotlin.jvm.internal.o0.b(JsonArray.class) + " as the serialized body of " + descriptor.h() + ", but had " + kotlin.jvm.internal.o0.b(jsonElementF0.getClass()));
    }

    @Override // ca.c
    public void c(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.f
    @NotNull
    public kotlinx.serialization.json.a d() {
        return this.f25416c;
    }

    @NotNull
    protected abstract JsonElement e0(@NotNull String str);

    @Override // kotlinx.serialization.json.f
    @NotNull
    public JsonElement g() {
        return f0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public boolean J(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        JsonPrimitive jsonPrimitiveR0 = r0(tag);
        if (!d().e().l() && d0(jsonPrimitiveR0, TypedValues.Custom.S_BOOLEAN).b()) {
            throw a0.f(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", f0().toString());
        }
        try {
            Boolean boolE = kotlinx.serialization.json.h.e(jsonPrimitiveR0);
            if (boolE != null) {
                return boolE.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            t0(TypedValues.Custom.S_BOOLEAN);
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public byte K(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            int iJ = kotlinx.serialization.json.h.j(r0(tag));
            boolean z10 = false;
            if (-128 <= iJ && iJ <= 127) {
                z10 = true;
            }
            Byte bValueOf = z10 ? Byte.valueOf((byte) iJ) : null;
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            t0("byte");
            throw new v8.h();
        } catch (IllegalArgumentException unused) {
            t0("byte");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public char L(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            return p9.t.g1(r0(tag).a());
        } catch (IllegalArgumentException unused) {
            t0("char");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public double M(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            double dG = kotlinx.serialization.json.h.g(r0(tag));
            if (!d().e().a()) {
                if (!((Double.isInfinite(dG) || Double.isNaN(dG)) ? false : true)) {
                    throw a0.a(Double.valueOf(dG), tag, f0().toString());
                }
            }
            return dG;
        } catch (IllegalArgumentException unused) {
            t0("double");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public int N(@NotNull String tag, @NotNull SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        return b0.f(enumDescriptor, d(), r0(tag).a(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public float O(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            float fI = kotlinx.serialization.json.h.i(r0(tag));
            if (!d().e().a()) {
                if (!((Float.isInfinite(fI) || Float.isNaN(fI)) ? false : true)) {
                    throw a0.a(Float.valueOf(fI), tag, f0().toString());
                }
            }
            return fI;
        } catch (IllegalArgumentException unused) {
            t0(TypedValues.Custom.S_FLOAT);
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    @NotNull
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public Decoder P(@NotNull String tag, @NotNull SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(inlineDescriptor, "inlineDescriptor");
        return t0.a(inlineDescriptor) ? new v(new u0(r0(tag).a()), d()) : super.P(tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public int Q(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            return kotlinx.serialization.json.h.j(r0(tag));
        } catch (IllegalArgumentException unused) {
            t0("int");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public long R(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            return kotlinx.serialization.json.h.m(r0(tag));
        } catch (IllegalArgumentException unused) {
            t0("long");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public short S(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        try {
            int iJ = kotlinx.serialization.json.h.j(r0(tag));
            boolean z10 = false;
            if (-32768 <= iJ && iJ <= 32767) {
                z10 = true;
            }
            Short shValueOf = z10 ? Short.valueOf((short) iJ) : null;
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            t0("short");
            throw new v8.h();
        } catch (IllegalArgumentException unused) {
            t0("short");
            throw new v8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    @NotNull
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public String T(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        JsonPrimitive jsonPrimitiveR0 = r0(tag);
        if (d().e().l() || d0(jsonPrimitiveR0, TypedValues.Custom.S_STRING).b()) {
            if (jsonPrimitiveR0 instanceof JsonNull) {
                throw a0.f(-1, "Unexpected 'null' value instead of string literal", f0().toString());
            }
            return jsonPrimitiveR0.a();
        }
        throw a0.f(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", f0().toString());
    }

    @NotNull
    protected final JsonPrimitive r0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        JsonElement jsonElementE0 = e0(tag);
        JsonPrimitive jsonPrimitive = jsonElementE0 instanceof JsonPrimitive ? (JsonPrimitive) jsonElementE0 : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw a0.f(-1, "Expected JsonPrimitive at " + tag + ", found " + jsonElementE0, f0().toString());
    }

    @NotNull
    public abstract JsonElement s0();

    private c(kotlinx.serialization.json.a aVar, JsonElement jsonElement) {
        this.f25416c = aVar;
        this.f25417d = jsonElement;
        this.f25418e = d().e();
    }
}

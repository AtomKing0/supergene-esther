package kotlin.jvm.internal;

import androidx.webkit.ProxyConfig;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TypeReference.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 implements KType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f29841e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KClassifier f29842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<KTypeProjection> f29843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final KType f29844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29845d;

    /* JADX INFO: compiled from: TypeReference.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TypeReference.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29846a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29846a = iArr;
        }
    }

    /* JADX INFO: compiled from: TypeReference.kt */
    static final class c extends v implements h9.l<KTypeProjection, CharSequence> {
        c() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull KTypeProjection it) {
            t.i(it, "it");
            return u0.this.c(it);
        }
    }

    public u0(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, @Nullable KType kType, int i10) {
        t.i(classifier, "classifier");
        t.i(arguments, "arguments");
        this.f29842a = classifier;
        this.f29843b = arguments;
        this.f29844c = kType;
        this.f29845d = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(KTypeProjection kTypeProjection) {
        String strValueOf;
        if (kTypeProjection.getVariance() == null) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        KType type = kTypeProjection.getType();
        u0 u0Var = type instanceof u0 ? (u0) type : null;
        if (u0Var == null || (strValueOf = u0Var.d(true)) == null) {
            strValueOf = String.valueOf(kTypeProjection.getType());
        }
        int i10 = b.f29846a[kTypeProjection.getVariance().ordinal()];
        if (i10 == 1) {
            return strValueOf;
        }
        if (i10 == 2) {
            return "in " + strValueOf;
        }
        if (i10 != 3) {
            throw new v8.q();
        }
        return "out " + strValueOf;
    }

    private final String d(boolean z10) {
        String name;
        KClassifier classifier = getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class<?> clsA = kClass != null ? g9.a.a(kClass) : null;
        if (clsA == null) {
            name = getClassifier().toString();
        } else if ((this.f29845d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsA.isArray()) {
            name = e(clsA);
        } else if (z10 && clsA.isPrimitive()) {
            KClassifier classifier2 = getClassifier();
            t.g(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = g9.a.b((KClass) classifier2).getName();
        } else {
            name = clsA.getName();
        }
        String str = name + (getArguments().isEmpty() ? "" : kotlin.collections.d0.r0(getArguments(), ", ", "<", ">", 0, null, new c(), 24, null)) + (isMarkedNullable() ? "?" : "");
        KType kType = this.f29844c;
        if (!(kType instanceof u0)) {
            return str;
        }
        String strD = ((u0) kType).d(true);
        if (t.d(strD, str)) {
            return str;
        }
        if (t.d(strD, str + '?')) {
            return str + '!';
        }
        return '(' + str + ".." + strD + ')';
    }

    private final String e(Class<?> cls) {
        return t.d(cls, boolean[].class) ? "kotlin.BooleanArray" : t.d(cls, char[].class) ? "kotlin.CharArray" : t.d(cls, byte[].class) ? "kotlin.ByteArray" : t.d(cls, short[].class) ? "kotlin.ShortArray" : t.d(cls, int[].class) ? "kotlin.IntArray" : t.d(cls, float[].class) ? "kotlin.FloatArray" : t.d(cls, long[].class) ? "kotlin.LongArray" : t.d(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof u0) {
            u0 u0Var = (u0) obj;
            if (t.d(getClassifier(), u0Var.getClassifier()) && t.d(getArguments(), u0Var.getArguments()) && t.d(this.f29844c, u0Var.f29844c) && this.f29845d == u0Var.f29845d) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return kotlin.collections.v.l();
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.f29843b;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public KClassifier getClassifier() {
        return this.f29842a;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + this.f29845d;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.f29845d & 1) != 0;
    }

    @NotNull
    public String toString() {
        return d(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u0(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, boolean z10) {
        this(classifier, arguments, null, z10 ? 1 : 0);
        t.i(classifier, "classifier");
        t.i(arguments, "arguments");
    }
}

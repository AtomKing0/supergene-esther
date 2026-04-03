package da;

import java.util.Iterator;
import java.util.Map;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> f24611a = kotlin.collections.r0.j(v8.y.a(kotlin.jvm.internal.o0.b(String.class), aa.a.B(kotlin.jvm.internal.s0.f29840a)), v8.y.a(kotlin.jvm.internal.o0.b(Character.TYPE), aa.a.v(kotlin.jvm.internal.g.f29818a)), v8.y.a(kotlin.jvm.internal.o0.b(char[].class), aa.a.d()), v8.y.a(kotlin.jvm.internal.o0.b(Double.TYPE), aa.a.w(kotlin.jvm.internal.l.f29830a)), v8.y.a(kotlin.jvm.internal.o0.b(double[].class), aa.a.e()), v8.y.a(kotlin.jvm.internal.o0.b(Float.TYPE), aa.a.x(kotlin.jvm.internal.m.f29832a)), v8.y.a(kotlin.jvm.internal.o0.b(float[].class), aa.a.f()), v8.y.a(kotlin.jvm.internal.o0.b(Long.TYPE), aa.a.z(kotlin.jvm.internal.w.f29848a)), v8.y.a(kotlin.jvm.internal.o0.b(long[].class), aa.a.i()), v8.y.a(kotlin.jvm.internal.o0.b(v8.e0.class), aa.a.F(v8.e0.f35179b)), v8.y.a(kotlin.jvm.internal.o0.b(v8.f0.class), aa.a.q()), v8.y.a(kotlin.jvm.internal.o0.b(Integer.TYPE), aa.a.y(kotlin.jvm.internal.s.f29839a)), v8.y.a(kotlin.jvm.internal.o0.b(int[].class), aa.a.g()), v8.y.a(kotlin.jvm.internal.o0.b(v8.c0.class), aa.a.E(v8.c0.f35170b)), v8.y.a(kotlin.jvm.internal.o0.b(v8.d0.class), aa.a.p()), v8.y.a(kotlin.jvm.internal.o0.b(Short.TYPE), aa.a.A(kotlin.jvm.internal.q0.f29837a)), v8.y.a(kotlin.jvm.internal.o0.b(short[].class), aa.a.m()), v8.y.a(kotlin.jvm.internal.o0.b(v8.h0.class), aa.a.G(v8.h0.f35185b)), v8.y.a(kotlin.jvm.internal.o0.b(v8.i0.class), aa.a.r()), v8.y.a(kotlin.jvm.internal.o0.b(Byte.TYPE), aa.a.u(kotlin.jvm.internal.e.f29816a)), v8.y.a(kotlin.jvm.internal.o0.b(byte[].class), aa.a.c()), v8.y.a(kotlin.jvm.internal.o0.b(v8.a0.class), aa.a.D(v8.a0.f35164b)), v8.y.a(kotlin.jvm.internal.o0.b(v8.b0.class), aa.a.o()), v8.y.a(kotlin.jvm.internal.o0.b(Boolean.TYPE), aa.a.t(kotlin.jvm.internal.d.f29815a)), v8.y.a(kotlin.jvm.internal.o0.b(boolean[].class), aa.a.b()), v8.y.a(kotlin.jvm.internal.o0.b(v8.k0.class), aa.a.H(v8.k0.f35197a)), v8.y.a(kotlin.jvm.internal.o0.b(q9.b.class), aa.a.C(q9.b.f33177b)));

    @NotNull
    public static final SerialDescriptor a(@NotNull String serialName, @NotNull ba.e kind) {
        kotlin.jvm.internal.t.i(serialName, "serialName");
        kotlin.jvm.internal.t.i(kind, "kind");
        d(serialName);
        return new o1(serialName, kind);
    }

    @Nullable
    public static final <T> KSerializer<T> b(@NotNull KClass<T> kClass) {
        kotlin.jvm.internal.t.i(kClass, "<this>");
        return (KSerializer) f24611a.get(kClass);
    }

    private static final String c(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? p9.c.i(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    private static final void d(String str) {
        Iterator<KClass<? extends Object>> it = f24611a.keySet().iterator();
        while (it.hasNext()) {
            String simpleName = it.next().getSimpleName();
            kotlin.jvm.internal.t.f(simpleName);
            String strC = c(simpleName);
            if (p9.q.x(str, "kotlin." + strC, true) || p9.q.x(str, strC, true)) {
                throw new IllegalArgumentException(p9.j.f("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exist " + c(strC) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}

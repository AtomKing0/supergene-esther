package kotlin.reflect;

import h9.l;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends q implements l<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // h9.l
    public final Class<?> invoke(@NotNull Class<?> p02) {
        t.i(p02, "p0");
        return p02.getComponentType();
    }
}

package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {

    @NotNull
    private final Type elementType;

    public GenericArrayTypeImpl(@NotNull Type elementType) {
        t.i(elementType, "elementType");
        this.elementType = elementType;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof GenericArrayType) && t.d(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @NotNull
    public Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        return TypesJVMKt.typeToString(this.elementType) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}

package kotlin.reflect;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {

    @Nullable
    private final Type ownerType;

    @NotNull
    private final Class<?> rawType;

    @NotNull
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(@NotNull Class<?> rawType, @Nullable Type type, @NotNull List<? extends Type> typeArguments) {
        t.i(rawType, "rawType");
        t.i(typeArguments, "typeArguments");
        this.rawType = rawType;
        this.ownerType = type;
        this.typeArguments = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (t.d(this.rawType, parameterizedType.getRawType()) && t.d(this.ownerType, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() throws IOException {
        StringBuilder sb = new StringBuilder();
        Type type = this.ownerType;
        if (type != null) {
            sb.append(TypesJVMKt.typeToString(type));
            sb.append("$");
            sb.append(this.rawType.getSimpleName());
        } else {
            sb.append(TypesJVMKt.typeToString(this.rawType));
        }
        Type[] typeArr = this.typeArguments;
        if (!(typeArr.length == 0)) {
            p.a0(typeArr, sb, (null & 2) != 0 ? ", " : null, (null & 4) != 0 ? "" : "<", (null & 8) == 0 ? ">" : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}

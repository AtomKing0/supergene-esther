package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class WildcardTypeImpl implements WildcardType, TypeImpl {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final WildcardTypeImpl STAR = new WildcardTypeImpl(null, null);

    @Nullable
    private final Type lowerBound;

    @Nullable
    private final Type upperBound;

    /* JADX INFO: compiled from: TypesJVM.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.STAR;
        }
    }

    public WildcardTypeImpl(@Nullable Type type, @Nullable Type type2) {
        this.upperBound = type;
        this.lowerBound = type2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        if (this.lowerBound != null) {
            return "? super " + TypesJVMKt.typeToString(this.lowerBound);
        }
        Type type = this.upperBound;
        if (type == null || t.d(type, Object.class)) {
            return "?";
        }
        return "? extends " + TypesJVMKt.typeToString(this.upperBound);
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.upperBound;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}

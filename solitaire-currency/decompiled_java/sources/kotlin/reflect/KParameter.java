package kotlin.reflect;

import b9.a;
import b9.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KParameter.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KParameter extends KAnnotatedElement {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: KParameter.kt */
    public static final class Kind {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind INSTANCE = new Kind("INSTANCE", 0);
        public static final Kind EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 1);
        public static final Kind VALUE = new Kind("VALUE", 2);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, EXTENSION_RECEIVER, VALUE};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = b.a(kindArr$values);
        }

        private Kind(String str, int i10) {
        }

        @NotNull
        public static a<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    int getIndex();

    @NotNull
    Kind getKind();

    @Nullable
    String getName();

    @NotNull
    KType getType();

    boolean isOptional();

    boolean isVararg();

    /* JADX INFO: compiled from: KParameter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void isVararg$annotations() {
        }
    }
}

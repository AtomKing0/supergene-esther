package kotlin.reflect;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KProperty<V> extends KCallable<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Accessor<V> {
        @NotNull
        KProperty<V> getProperty();
    }

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    @NotNull
    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();

    /* JADX INFO: compiled from: KProperty.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void isConst$annotations() {
        }

        public static /* synthetic */ void isLateinit$annotations() {
        }
    }
}

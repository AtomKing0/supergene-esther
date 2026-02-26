package fa;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SerializersModule.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: fa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SerializersModule.kt */
    public static final class C0558a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final KSerializer<?> f25768a;

        @Override // fa.a
        @NotNull
        public KSerializer<?> a(@NotNull List<? extends KSerializer<?>> typeArgumentsSerializers) {
            t.i(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f25768a;
        }

        @NotNull
        public final KSerializer<?> b() {
            return this.f25768a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof C0558a) && t.d(((C0558a) obj).f25768a, this.f25768a);
        }

        public int hashCode() {
            return this.f25768a.hashCode();
        }
    }

    /* JADX INFO: compiled from: SerializersModule.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final l<List<? extends KSerializer<?>>, KSerializer<?>> f25769a;

        @Override // fa.a
        @NotNull
        public KSerializer<?> a(@NotNull List<? extends KSerializer<?>> typeArgumentsSerializers) {
            t.i(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f25769a.invoke(typeArgumentsSerializers);
        }

        @NotNull
        public final l<List<? extends KSerializer<?>>, KSerializer<?>> b() {
            return this.f25769a;
        }
    }

    private a() {
    }

    @NotNull
    public abstract KSerializer<?> a(@NotNull List<? extends KSerializer<?>> list);
}

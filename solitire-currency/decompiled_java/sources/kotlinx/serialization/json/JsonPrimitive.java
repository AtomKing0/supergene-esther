package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
@z9.h(with = t.class)
public abstract class JsonPrimitive extends JsonElement {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: JsonElement.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<JsonPrimitive> serializer() {
            return t.f30088a;
        }
    }

    public /* synthetic */ JsonPrimitive(kotlin.jvm.internal.k kVar) {
        this();
    }

    @NotNull
    public abstract String a();

    @NotNull
    public String toString() {
        return a();
    }

    private JsonPrimitive() {
        super(null);
    }
}

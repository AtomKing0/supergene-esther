package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
@z9.h(with = i.class)
public abstract class JsonElement {

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
        public final KSerializer<JsonElement> serializer() {
            return i.f30067a;
        }
    }

    public /* synthetic */ JsonElement(kotlin.jvm.internal.k kVar) {
        this();
    }

    private JsonElement() {
    }
}

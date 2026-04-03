package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 {
    @NotNull
    public static final w a(@NotNull Number value, @NotNull String key, @NotNull String output) {
        kotlin.jvm.internal.t.i(value, "value");
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(output, "output");
        return e(-1, k(value, key, output));
    }

    @NotNull
    public static final y b(@NotNull Number value, @NotNull String output) {
        kotlin.jvm.internal.t.i(value, "value");
        kotlin.jvm.internal.t.i(output, "output");
        return new y("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) i(output, 0, 1, null)));
    }

    @NotNull
    public static final y c(@NotNull Number value, @NotNull String key, @NotNull String output) {
        kotlin.jvm.internal.t.i(value, "value");
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(output, "output");
        return new y(k(value, key, output));
    }

    @NotNull
    public static final y d(@NotNull SerialDescriptor keyDescriptor) {
        kotlin.jvm.internal.t.i(keyDescriptor, "keyDescriptor");
        return new y("Value of type '" + keyDescriptor.h() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    @NotNull
    public static final w e(int i10, @NotNull String message) {
        kotlin.jvm.internal.t.i(message, "message");
        if (i10 >= 0) {
            message = "Unexpected JSON token at offset " + i10 + ": " + message;
        }
        return new w(message);
    }

    @NotNull
    public static final w f(int i10, @NotNull String message, @NotNull CharSequence input) {
        kotlin.jvm.internal.t.i(message, "message");
        kotlin.jvm.internal.t.i(input, "input");
        return e(i10, message + "\nJSON input: " + ((Object) h(input, i10)));
    }

    @NotNull
    public static final w g(@NotNull String key, @NotNull String input) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(input, "input");
        return e(-1, "Encountered unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) i(input, 0, 1, null)));
    }

    private static final CharSequence h(CharSequence charSequence, int i10) {
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i10 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i11 = i10 - 30;
        int i12 = i10 + 30;
        return (i11 <= 0 ? "" : ".....") + charSequence.subSequence(n9.o.e(i11, 0), n9.o.j(i12, charSequence.length())).toString() + (i12 >= charSequence.length() ? "" : ".....");
    }

    static /* synthetic */ CharSequence i(CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        return h(charSequence, i10);
    }

    @NotNull
    public static final Void j(@NotNull a aVar, @NotNull Number result) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(result, "result");
        a.y(aVar, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new v8.h();
    }

    private static final String k(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) i(str2, 0, 1, null));
    }
}
